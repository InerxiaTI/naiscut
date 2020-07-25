package com.inerxia.naiscut.facade;

import org.hibernate.ObjectNotFoundException;

import java.util.Objects;

public interface GeneralFacade<T> {


    T findById(Integer i);

}
