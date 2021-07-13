package com.company.services;

import com.company.exceptions.ServiceException;

import java.util.Iterator;

public interface Services<T> {

    public void  creat(T t) throws ServiceException;

    public Iterator read() throws ServiceException;

    public void update(T t);

    public boolean delete(T t);

}
