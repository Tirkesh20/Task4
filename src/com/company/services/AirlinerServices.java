package com.company.services;

import com.company.beans.airCraft.AirLiner;
import com.company.dao.AirlinerDao;
import com.company.exceptions.DaoException;
import com.company.exceptions.ServiceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        airlinerDao.update(airLiner);
    }

    @Override
    public boolean delete(AirLiner airLiner) throws ServiceException {
        try {
           return airlinerDao.delete(airLiner);
        } catch (DaoException | IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public AirLiner findByFuelConsumption(float fuelConsumption) throws ServiceException {
        Iterator<AirLiner> iterator=read();
        while (iterator.hasNext()){
            AirLiner airLiner=iterator.next();
            if (Float.compare(airLiner.getFuelConsumption(), fuelConsumption) == 1) {
                return airLiner;
            }
        }
        return null;
    }

}


