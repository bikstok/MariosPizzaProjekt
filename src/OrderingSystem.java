import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.*;
import java.io.*;
public class OrderingSystem {

    public static int max = 500000;
    public static String[] orders = new String[max];
    public static int orderCount = 0;

    static {
        orders[0] = "1 2 10:30";
        orders[1] = "2 7 11:00";
        orders[2] = "13 3 12:00";
        orders[3] = "8 7 13:30";
        orders[4] = "5 2 14:45";
        orderCount = 5;
    }
    String name;
    String customerID;
    int pizzaID;
    int quantity;
    LocalTime time;

    public OrderingSystem(String name, int pizzaID, int quantity, LocalTime time){

        this.name = name;
        this.pizzaID = pizzaID;
        this.quantity = quantity;
        this.time = time;


    }

    private static int globalCustomerID = 0;
    public static String makeNewSale(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = scan.next();
        globalCustomerID++;
        String message = "The customers name is " + name + " and the customer id is #" + globalCustomerID;
        return message;
    }




    public static String createOrder() {

            Scanner scan = new Scanner(System.in);
            System.out.println("What pizza would you like? ");
            int pizzaID = scan.nextInt();
            System.out.println("Excellent choice, how many would you want? ");
            int quantity = scan.nextInt();
            System.out.println("And what time would you like the pizza to be ready? ");
            String timeInput = scan.next();
            LocalTime time = LocalTime.parse(timeInput);

            System.out.println("You ordered number " + pizzaID + " and you chose an amount of " + quantity + " with a finish time of " + time);
            int customerID = orderCount;
            orders[orderCount++] = "Pizza ID: " + pizzaID + " Amount:" + quantity + " " + " Time: " + time + " CustomerID: #" + orderCount;
            return "Pizza ID: " + pizzaID + " Amount: " + quantity + " " + " Time: " + time + " CustomerID: #" + orderCount;
           /* globalCustomerID++
        System.out.println("you have order nr:" +globalCustomerID); */
    }

    public static void removeOrder() {
        String[] orderChange = new String[orders.length - 1];
        Scanner scan = new Scanner(System.in);
        System.out.println("Which order would you like to remove. Please type the customerID of the order: ");
        int orderRemoval = scan.nextInt();

        int indexToRemove = 0;
        for (int i = 0, j = 0; i < orderCount; i++) {
            if (i != orderRemoval - 1){
            orderChange[j++] = orders[i];
            indexToRemove++;
            } else {
                try (FileWriter writer = new FileWriter("./src/OrderTotal.txt", true)) {
                    writer.write(orders[orderRemoval - 1] + "\n");
                    System.out.println("Successfully saved order to the file.");
                } catch (IOException e) {
                    System.out.println("Error writing index to file: " + e.getMessage());
                }
            }
        }
        orders = orderChange;
        orderCount--;

    }

}
