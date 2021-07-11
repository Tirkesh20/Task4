package com.company.dao;

import com.company.beans.airCraft.AirLiner;
import com.company.exceptions.DaoException;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AirlinerDao implements DAO<AirLiner>{
      Set<AirLiner> airLiners;
    FileOutputStream fileOutputStream = null;
    ObjectOutputStream objectOutputStream = null;
    ObjectInputStream objectInputStream = null;
    FileInputStream fileInputStream=null;
        File file=new File("dataBase.txt");
    @Override
    public void insert(AirLiner airLiner) throws IOException {
        try {
             fileInputStream=new FileInputStream(file);
             objectInputStream=new ObjectInputStream(fileInputStream);
            airLiners= (Set<AirLiner>) objectInputStream.readObject();
            airLiners.add(airLiner);
             fileOutputStream=new FileOutputStream(file);
             objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(airLiners);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
        }
    }

    @Override
    public boolean delete(AirLiner airLiner) throws DaoException, IOException {
        try {
        fileInputStream=new FileInputStream(file);
        objectInputStream=new ObjectInputStream(fileInputStream);
        airLiners=(Set<AirLiner>) objectInputStream.readObject();
        airLiners.remove(airLiner);
        fileOutputStream=new FileOutputStream(file);
        objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(airLiners);
        }catch (IOException | ClassNotFoundException e){
            throw new DaoException();
        }finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
        }
        return true;
    }

    @Override
    public Iterator<AirLiner> select() throws IOException {
        Iterator<AirLiner> iterator=null;
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            airLiners=(Set<AirLiner>) objectInputStream.readObject();
            return airLiners.iterator();
    } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
           fileInputStream.close();
        }
        return iterator;
    }

    @Override
    public void update() {

    }
}
