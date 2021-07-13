package com.company.services;

import com.company.beans.airCraft.AirLiner;
import com.company.dao.AirlinerDao;
import com.company.exceptions.DaoException;
import com.company.exceptions.ServiceException;

import java.io.IOException;
import java.util.Iterator;

public class AirlinerServices implements Services<AirLiner> {
    private final AirlinerDao airlinerDao=new AirlinerDao();

    @Override
    public void creat(AirLiner airLiner) throws ServiceException {
        try {
            airlinerDao.insert(airLiner);
        }catch (DaoException | IOException e){
            throw new ServiceException(e.getMessage());
        }

    }

    @Override
    public Iterator read() throws ServiceException {
        try {
           return airlinerDao.select();
        }catch (DaoException|IOException exception){
            throw new ServiceException(exception.getMessage());
        }
    }

    @Override
    public void update(AirLiner airLiner) {
        try {
            airlinerDao.update();
        }
    }

    @Override
    public boolean delete(AirLiner airLiner) {
        return false;
    }


}
