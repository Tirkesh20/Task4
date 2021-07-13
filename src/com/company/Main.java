package com.company;

import com.company.beans.airCraft.AirLiner;
import com.company.dao.AirlinerDao;
import com.company.enums.AirLineClasses;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        AirLiner airLiner=new AirLiner();
        airLiner.setAirLineClasses(AirLineClasses.Business);
        airLiner.setPassengerCapacity(34);
        AirLiner airLiner1=new AirLiner();
        airLiner1.setAirLineClasses(AirLineClasses.Business);
        airLiner1.setPassengerCapacity(45);
        AirlinerDao airlinerDao=new AirlinerDao();
        try {
            airlinerDao.insert(airLiner);
            airlinerDao.insert(airLiner1);
            airlinerDao.delete(airLiner);
            Iterator iterator=airlinerDao.select();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }catch (Exception e){
            System.out.println("ex");
        }
    }
}
