import dao.FoodDao;
import dao.IngredientDao;
import dao.ItemDao;
import entity.Food;
import entity.Type;

import javax.naming.Context;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import java.util.Scanner;

public class client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        FoodDao foodDao = (FoodDao) Naming.lookup("rmi://PhanHoangTan:4591/food");
        ItemDao itemDao = (ItemDao) Naming.lookup("rmi://PhanHoangTan:4591/item");
        IngredientDao ingredientDao = (IngredientDao) Naming.lookup("rmi://PhanHoangTan:4591/ingredient");

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add food");
            System.out.println("2. List longest prepare foods");
            System.out.println("3. Delete expired ingredients");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Food food  = new Food("F4", "Phan Hoang Tan",
                            100.0, "Paintfull Cake", true,
                            Type.MAIN_COURSE, 10,  10);
                    if(foodDao.addFood(food)) {
                        System.out.println("Thêm food thành công");
                    } else {
                        System.out.println("Thêm food thất bại");
                    }
                    break;
                case 2:
                    foodDao.listLongestPrepareFoods().forEach(System.out::println);
                    break;
                case 3:
                    System.out.println( ingredientDao.deleteExpiredIngredients());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }
}
