package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IngredientDao extends Remote {
    public int deleteExpiredIngredients() throws RemoteException;
}
