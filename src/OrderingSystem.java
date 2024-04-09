import java.time.LocalTime;
import java.util.*;
import java.time.LocalTime;
public class OrderingSystem {

    String name;
    String customerID;
    int pizzaID;
    int quantity;
    LocalTime time;

    public OrderingSystem(String name, String customerID, int pizzaID, int quantity, LocalTime time){

        this.name = name;
        this.customerID = customerID;
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


    public static String createOrder(){
        Scanner scan = new Scanner(System.in);
        System.out.println("What pizza would you like? ");
        int pizzaID = scan.nextInt();
        System.out.println("Excellent choice, how many would you want? ");
        int quantity = scan.nextInt();
        System.out.println("And what time would you like the pizza to be ready? ");
        String timeInput = scan.next();
        LocalTime time = LocalTime.parse(timeInput);

        System.out.println("You ordered number " + pizzaID + " and you chose an amount of " + quantity + " with a finish time of " + time);
        return (pizzaID-1) + " " + quantity + " " + time;
    }

    public static void makePayment(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to pay by card or cash? Press 1 for card or press 2 cash. ");
        int payment = scan.nextInt();

        switch (payment){
            case 1:
                System.out.println("Please insert card. ");
                break;
            case 2:
                System.out.println("Please give the amount of cash. ");
                break;
            default:
                System.out.println("Sorry, this number isn't an option");
        }

    }




}
