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
    public Iterator<AirLiner> read() throws ServiceException {
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

    public AirLiner findByFuelConsumption(float fuelConsumptionStartPoint,float fuelConsumptionEndPoint) throws ServiceException {
        Iterator<AirLiner> iterator=read();
        while (iterator.hasNext()){
            AirLiner airLiner=iterator.next();
            float consumption=airLiner.getFuelConsumption();
            if (consumption == fuelConsumptionStartPoint||
                    consumption>fuelConsumptionStartPoint&&
                            consumption<=fuelConsumptionEndPoint) {
                return airLiner;
            }
        }
        return null;
    }

    public AirLiner findByPassengerCapacity(int passengerCapacityStartPoint,int passengerCapacityEndPoint) throws ServiceException {
        Iterator<AirLiner> iterator=read();
        while (iterator.hasNext()){
            AirLiner airLiner=iterator.next();
            int capacity=airLiner.getPassengerCapacity();
            if (capacity == passengerCapacityStartPoint||
                    capacity>passengerCapacityStartPoint&&
                            capacity<=passengerCapacityEndPoint){
                return airLiner;
            }
        }
        return null;
    }
}


