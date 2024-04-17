package server;

import dao.FoodDao;
import dao.IngredientDao;
import dao.ItemDao;
import dao.impl.FoodImpl;
import dao.impl.IngredientImpl;
import dao.impl.ItemImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {
    private static final String URL = "rmi://PhanHoangTan:4591/";
    public static void main(String[] args) {
        try {
            Context context = new InitialContext();

            ItemDao a = new ItemImpl();
            FoodDao b = new FoodImpl();
            IngredientDao c = new IngredientImpl();
            LocateRegistry.createRegistry(4591);

            context.bind(URL + "item", a);
            context.bind(URL + "food", b);
            context.bind(URL + "ingredient", c);
            System.out.println("Server is running...");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
