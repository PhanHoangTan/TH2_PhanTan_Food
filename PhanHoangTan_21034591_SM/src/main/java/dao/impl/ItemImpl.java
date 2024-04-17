package dao.impl;

import dao.ItemDao;
import entity.Food;
import entity.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class ItemImpl extends UnicastRemoteObject implements ItemDao, Serializable {
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public ItemImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }
//    @Override
    //Liet ke danh sach mat hang la mon an dac biet cua nha hang ma co su dung nguyen lieu duoc nhap tu nha cung cap nao do khi biet ten nha cung cap
    //listItems(String supplierName): List<Item>

//    public List<Item> listItems(String supplierName) throws RemoteException {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            List<Item> items = em.createQuery(
//                            "SELECT i FROM Item i " +
//                                    "JOIN i.ingredients ig " +
//                                    "JOIN ig.suppliers s " +
//                                    "WHERE i.onSpecial = true AND s.name = :name", Item.class)
//                    .setParameter("name", supplierName)
//                    .getResultList();
//            tx.commit();
//            return items;
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//        }
//        return null;
//    }
}
//    @Override
    //Liet ke danh sach cac mon an co thoi gian chuan bi lau nhat
    //listLongestPrepareFoods(): List<Food>





