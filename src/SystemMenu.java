import javax.xml.namespace.QName;
import java.io.*;
import java.time.LocalTime;
import java.util.*;
public class SystemMenu {
    String[] accounting; // for accounting
    static ArrayList<Pizza> menu; //editMenu(Scanner)

    static Scanner scan = new Scanner(System.in);

    public SystemMenu(String[] accounting, ArrayList<Pizza> menu) {

        this.accounting = new String[accounting.length];
        this.menu = new ArrayList<Pizza>();

    }


    public static void AddPizzasToMenu(){
        File file = new File("./src/Menu.txt");
        menu = new ArrayList<Pizza>();


        try {
            Scanner scanner = new Scanner(file);
            int pizzaNo = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //Del op i navn:ingredienser og pris
                String[] parts = line.split(" - ");

                String pizzaInfo = parts[0];

                //Del op i navn og ingredienser
                String[] pizzaData = pizzaInfo.split(": ");

                String name = pizzaData[0];
                String[] ingredients = pizzaData[1].split(", ");
                int price = Integer.parseInt(parts[1]);

                //Lav pizza og tilføj
                Pizza pizza = new Pizza(pizzaNo, name, price, ingredients);
                menu.add(pizza);

                pizzaNo++;
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void PrintMenu(){
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

    public static void ordersCreation() {



        boolean orderInProgress = true;

        while (orderInProgress) {


            String newSale = OrderingSystem.makeNewSale();
            String order = OrderingSystem.createOrder();

            String orderAccepted = newSale + order;
            System.out.printf(orderAccepted);
            System.out.println();

            System.out.println("Would you like to order a new pizza? If yes then type 1 otherwise type 2 to end your order.");
            int orderChoice = scan.nextInt();

            if (orderChoice == 2){
                orderInProgress = false;
            } else if (orderChoice == 1){
                System.out.println("Okay time for the next pizza :)");
            } else {
                System.out.println("Not an option. Please type a valid number.");
            }
        }
    }

    public static void displayOrders() {
        for (int i = 0; i < OrderingSystem.orderCount; i++) {
            System.out.println("Order " + (i + 1) + "; " + OrderingSystem.orders[i]);

        }
    }

    public static void menuEditing() {

    }

    public static void accountingManagement() {

    }


    public static void main(String[] args) { //system menu

         AddPizzasToMenu();

        Scanner scan = new Scanner(System.in);

        boolean program = true;

        while(program){
            System.out.println("Welcome to Marios pizz3a ordering system.");

            System.out.println("\nPick your choice");

            System.out.println("Press 1 if you would like to create an order.");
            System.out.println("Press 2 if you would like to remove an order.");
            System.out.println("Press 3 if you would like to display current orders.");
            System.out.println("Press 4 if you would like to check accounting.");
            System.out.println("Press 5 if you would like to quit the program.");


            System.out.println("Press the number for the option you would like.");
            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    PrintMenu();
                    ordersCreation();
                    break;
                case 2:
                    OrderingSystem.removeOrder();
                    break;
                case 3:
                    displayOrders();
                    break;
                case 4:
                    OrderingSystem.printFile();
                    break;
                case 5:
                    System.out.println("You ended the program");
                    System.exit(1);
                    break;
                default:
                    System.out.println("You choose a wrong number.");
            }
        }
    }
}