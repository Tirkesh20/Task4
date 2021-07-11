package com.company.dao;

import com.company.exceptions.DaoException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public interface DAO <T>{

    public void  insert(T t) throws IOException;

    public boolean delete(T t) throws IOException, DaoException;

    public Iterator<T> select() throws IOException;

    public void update();

}
