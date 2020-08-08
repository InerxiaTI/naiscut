package com.inerxia.naiscut.config.jwt;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inerxia.naiscut.exception.AutenticationInvalidatedException;
import com.inerxia.naiscut.model.cliente.Usuario;
import com.inerxia.naiscut.util.StandardResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private JWTService jwtService;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));

        this.jwtService = jwtService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        System.out.println("contect-: "+request.getContentType());

        String username = obtainUsername(request);
        String password = obtainPassword(request);

        System.out.println(username+" ========"+password);

        if(username != null && password !=null) {
            logger.info("Username desde request parameter (form-data): " + username);
            logger.info("Password desde request parameter (form-data): " + password);

        }else if(username==null ||password ==null){
            try{
                username = username.trim();

            }catch (NullPointerException ex){
                throw new AutenticationInvalidatedException("Malo.malo");
            }
        } else {
            Usuario user = null;
            try {
                user = new ObjectMapper().readValue(request.getInputStream(), Usuario.class);

                username = user.getUsuario();
                password = user.getClave();

                logger.info("Username desde request InputStream (raw): " + username);
                logger.info("Password desde request InputStream (raw): " + password);

            } catch (JsonParseException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);

        return authenticationManager.authenticate(authToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        String token = jwtService.create(authResult);

        response.addHeader(JWTService.HEADER_STRING, JWTService.TOKEN_PREFIX + token);

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("token", token);
        body.put("usuario", (User) authResult.getPrincipal());
        StandardResponse standardResponse = new StandardResponse(StandardResponse.EstadoStandardResponse.OK,"usuario.login.exito",body);
        response.getWriter().write(new ObjectMapper().writeValueAsString(standardResponse));
        response.setStatus(200);
        response.setContentType("application/json");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {



        Map<String, Object> body = new HashMap<String, Object>();
        body.put("error", failed.getMessage());
        StandardResponse standardResponse =
                new StandardResponse(StandardResponse.EstadoStandardResponse.ERROR,"usuario.login.error",body);

        response.getWriter().write(new ObjectMapper().writeValueAsString(standardResponse));
        response.setStatus(401);
        response.setContentType("application/json");
    }
}
