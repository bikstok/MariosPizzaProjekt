import javax.xml.namespace.QName;
import java.io.*;
import java.time.LocalTime;
import java.util.*;
public class SystemMenu {
    String[] accounting; // for accounting
    static ArrayList<Pizza> menu; //editMenu(Scanner)
    static ArrayList<String> orders; //Main method hub
    static Scanner scan = new Scanner(System.in);

    public SystemMenu(String[] accounting, ArrayList<Pizza> menu, String[] orders) {

        this.accounting = new String[accounting.length];
        this.menu = new ArrayList<Pizza>();
        this.orders = new ArrayList<String>();
    }


    public static void AddPizzasToMenu(){
        File file = new File("./src/Menu.txt");
        menu = new ArrayList<Pizza>();
        orders = new ArrayList<String>();

        try {
            Scanner scanner = new Scanner(file);
            int pizzaNo = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                //Del op i navn og pris
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

        String newSale = OrderingSystem.makeNewSale();
        String order = OrderingSystem.createOrder();

        orders.add(order);
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
            System.out.println("Welcome to Marios pizza ordering system.");

            // printMenu
            System.out.println("Menu:");
            PrintMenu();
            System.out.println("\nPick your choice");


            System.out.println("Press 1 if you would like to view the orders.");
            System.out.println("Press 2 if you would like to edit the menu.");
            System.out.println("Press 3 if you would like to check accounting.");
            System.out.println("Press 4 if you would like to quit the program.");


            System.out.println("Press the number for the option you would like.");
            int menu = scan.nextInt();

            switch (menu) {
                case 1:
                    ordersCreation();
                    break;
                case 2:
                    menuEditing();
                    break;
                case 3:
                    accountingManagement();
                    break;
                case 4:
                    System.out.println("You ended the program");
                    System.exit(1);
                default:
                    System.out.println("You choose a wrong number.");
            }
        }
    }
}

