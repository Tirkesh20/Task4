package com.company.dao;

import com.company.beans.airCraft.AirLiner;
import com.company.exceptions.DaoException;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AirlinerDao implements DAO<AirLiner>{
   private Set<AirLiner> airLiners;
   private FileOutputStream fileOutputStream = null;
   private ObjectOutputStream objectOutputStream = null;
   private ObjectInputStream objectInputStream = null;
   private FileInputStream fileInputStream=null;
   private final File file=new File("dataBase.txt");

    {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void insert(AirLiner airLiner) throws IOException, DaoException {
        try {
            if (file.length()==0) {
                airLiners = new HashSet<>();
            }else {
                fileInputStream=new FileInputStream(file);
                objectInputStream=new ObjectInputStream(fileInputStream);
               airLiners= (Set<AirLiner>) objectInputStream.readObject();
            }
            airLiners.add(airLiner);
            fileOutputStream=new FileOutputStream(file);
             objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(airLiners);
        } catch (IOException | ClassNotFoundException e) {
        throw new DaoException(e.getMessage());
        } finally {
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
        return true;
        }catch (IOException | ClassNotFoundException e){
            throw new DaoException();
        }finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
        }
    }

    @Override
    public Iterator<AirLiner> select() throws IOException, DaoException {
        Iterator<AirLiner> iterator=null;
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            airLiners=(Set<AirLiner>) objectInputStream.readObject();
            return airLiners.iterator();
    } catch (IOException | ClassNotFoundException e) {
            throw new DaoException();
        }finally {
           fileInputStream.close();
        }
    }

    @Override
    public void update(AirLiner airLiner) {
        if (file.length() == 0){
            return ;
        }
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            airLiners=(Set<AirLiner>) objectInputStream.readObject();
            Iterator iterator=select();
            while (iterator.hasNext()){
                if (iterator.next().equals(airLiner)){
                    iterator.remove();
                }
            }
        } catch (IOException | ClassNotFoundException | DaoException e) {
            e.printStackTrace();
        }
    }
}
