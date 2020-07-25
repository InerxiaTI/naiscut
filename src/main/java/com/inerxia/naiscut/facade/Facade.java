package com.inerxia.naiscut.facade;

public abstract class Facade  <M,S>{
    public M mapper;
    public S service;

    public Facade(M mapper, S service) {
        this.mapper = mapper;
        this.service = service;
    }
}
