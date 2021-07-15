package com.company.dao;

import com.company.beans.airCraft.AirLiner;
import com.company.beans.airCraft.BaggagePlane;
import com.company.exceptions.DaoException;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class BaggagePlaneDao implements DAO<BaggagePlane> {
    private Set<BaggagePlane> baggagePlanes ;
    private FileOutputStream fileOutputStream = null;
    private ObjectOutputStream objectOutputStream = null;
    private ObjectInputStream objectInputStream = null;
    private FileInputStream fileInputStream=null;
    private final File file=new File("dataBase.txt");

    @Override
    public void insert(BaggagePlane baggagePlane) throws IOException, DaoException {
        try {
            if (file.length()==0) {
                baggagePlanes = new HashSet<>();
            }else {
                fileInputStream=new FileInputStream(file);
                objectInputStream=new ObjectInputStream(fileInputStream);
                baggagePlanes=(Set<BaggagePlane>) objectInputStream.readObject();
            }
            baggagePlanes.add(baggagePlane);
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(baggagePlanes);
        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException(e.getMessage());
        } finally {
            if (objectOutputStream!=null){
                objectOutputStream.close();
            }
        }
    }

    @Override
    public boolean delete(BaggagePlane baggagePlane) throws IOException, DaoException {
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            baggagePlanes=(Set<BaggagePlane>) objectInputStream.readObject();
            baggagePlanes.remove(baggagePlane);
            fileOutputStream=new FileOutputStream(file);
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(baggagePlanes);
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
    public Iterator<BaggagePlane> select() throws IOException, DaoException {
        Iterator<BaggagePlane> iterator=null;
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            baggagePlanes=(Set<BaggagePlane>) objectInputStream.readObject();
            return baggagePlanes.iterator();
        } catch (IOException | ClassNotFoundException e) {
            throw new DaoException();
        }finally {
            fileInputStream.close();
        }
    }

    @Override
    public void update(BaggagePlane baggagePlane) {
        if (file.length() == 0){
            return ;
        }
        try {
            fileInputStream=new FileInputStream(file);
            objectInputStream=new ObjectInputStream(fileInputStream);
            baggagePlanes=(Set<BaggagePlane>) objectInputStream.readObject();
            Iterator iterator=select();
            while (iterator.hasNext()){
                if (iterator.next().equals(baggagePlanes)){
                    iterator.remove();
                }
            }
        } catch (IOException | ClassNotFoundException | DaoException e) {
            e.printStackTrace();
        }
    }
}
