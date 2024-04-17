package dao.impl;

import dao.FoodDao;
import entity.Food;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class FoodImpl extends UnicastRemoteObject implements FoodDao, Serializable {
    private EntityManager em;

    public FoodImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }
@Override
    public boolean addFood(Food food) throws RemoteException {
        try {
            em.getTransaction().begin();
            em.persist(food);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
    //Liet ke danh sach cac mon an co thoi gian chuan bi lau nhat
    //listLongestPrepareFoods(): List<Food>
    @Override
    public List<Food> listLongestPrepareFoods() throws RemoteException {
        return em.createQuery("SELECT f FROM Food f WHERE f.servingTime = (SELECT MAX(f2.servingTime) FROM Food f2)", Food.class).getResultList();
    }
}
