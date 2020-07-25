package com.inerxia.naiscut.facade;

import java.util.List;

public interface GeneralFacade<T> {


    T findById(Integer i);
    List<T> findAll();

}
