import dao.FoodDao;
import dao.IngredientDao;
import dao.ItemDao;
import dao.impl.FoodImpl;
import dao.impl.IngredientImpl;
import dao.impl.ItemImpl;
import entity.Food;
import entity.Type;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
@Inheritance(strategy = InheritanceType.JOINED)
public class TestDao {
    static FoodDao f;
    static ItemDao i;
    static IngredientDao in;

    @BeforeAll
    public static void setUp() throws RemoteException{
        f = new FoodImpl();
        i = new ItemImpl();
        in = new IngredientImpl();
    }
    @AfterAll
    public static void tearDown() {
        f = null;
//        i = null;
//        in = null;
    }

    @Test
    public void testAddFood() throws RemoteException {
        Food food  = new Food("F5", "Phan Hoang Tan",
                100.0, "Paintfull Cake", true,
                 Type.MAIN_COURSE, 10,  10);
        if(f.addFood(food)) {
            System.out.println("Thêm food thành công");
        } else {
            System.out.println("Thêm food thất bại");
        }
    }
    @Test
    public void testListLongestPrepareFoods() throws RemoteException {
       f.listLongestPrepareFoods().forEach(System.out::println);
    }
    @Test
    public void testDeleteIngredient() throws RemoteException {
       System.out.println( in.deleteExpiredIngredients());

    }
//    @Test
//    public void testListItems() throws RemoteException {
//        i.listItems("Supplier A").forEach(System.out::println);
//    }





}
