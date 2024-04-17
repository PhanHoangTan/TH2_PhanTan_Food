package dao.impl;

import dao.IngredientDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.TemporalType;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Date;

public class IngredientImpl extends UnicastRemoteObject implements IngredientDao, Serializable {
    private static final long serialVersionUID = 1L;
    private EntityManager em;

    public IngredientImpl() throws RemoteException {
        em = Persistence.createEntityManagerFactory("SQLdb").createEntityManager();
    }

    //Xoa Tat ca cac nguyen lieu da het han, tra ve so phan tu da xoa
    //deleteExpiredIngredients(): int
    @Override

    public int deleteExpiredIngredients() throws RemoteException {
        em.getTransaction().begin();
        int result = em.createQuery("DELETE FROM Ingredient i WHERE i.expiryDate < :currentDate")
                .setParameter("currentDate", LocalDate.now())
                .executeUpdate();
        em.getTransaction().commit();
        return result;
    }
}
