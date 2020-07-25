package com.inerxia.naiscut.facade;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GeneralFacade<T> {


    T findById(Integer i);
    List<T> findAll(Pageable pageable);

}
