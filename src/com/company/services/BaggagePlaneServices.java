package com.company.services;

import com.company.beans.airCraft.BaggagePlane;
import com.company.dao.BaggagePlaneDao;
import com.company.exceptions.DaoException;
import com.company.exceptions.ServiceException;

import java.io.*;
import java.util.Iterator;


public class BaggagePlaneServices implements Services<BaggagePlane> {
    private final BaggagePlaneDao baggagePlaneDao=new BaggagePlaneDao();

    @Override
    public void creat(BaggagePlane baggagePlane) throws ServiceException {
        try {
            baggagePlaneDao.insert(baggagePlane);
        }catch (DaoException | IOException e){
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Iterator<BaggagePlane> read() throws ServiceException {
        try {
            return baggagePlaneDao.select();
        }catch (DaoException|IOException exception){
            throw new ServiceException(exception.getMessage());
        }
    }

    @Override
    public void update(BaggagePlane baggagePlane) {
        baggagePlaneDao.update(baggagePlane);
    }

    @Override
    public boolean delete(BaggagePlane baggagePlane) throws ServiceException {
        try {
            return baggagePlaneDao.delete(baggagePlane);
        } catch (DaoException | IOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    public BaggagePlane findByMaxBaggageCapacity(float maxCapacityStartPoint, float maxCapacityEndPoint) throws ServiceException {
        Iterator<BaggagePlane> iterator=read();
        while (iterator.hasNext()){
            BaggagePlane baggagePlane=iterator.next();
            float capacity=baggagePlane.getMaxBaggageCapacity();
            if (capacity == maxCapacityStartPoint||
                    capacity>maxCapacityStartPoint&&
                            capacity<=maxCapacityEndPoint) {
                return baggagePlane;
            }
        }
        return null;
    }



}
