package dao;

import entity.Food;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface FoodDao extends Remote {
    public boolean addFood(Food food) throws RemoteException;
    public List<Food> listLongestPrepareFoods() throws RemoteException;
}
