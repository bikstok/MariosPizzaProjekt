import javax.xml.namespace.QName;
import java.io.*;
import java.time.LocalTime;
import java.util.*;
public class SystemMenu {
    String[] accounting; // for accounting
    String[] menu; //editMenu(Scanner)
    String[] orders; //Main method hub
    static Scanner scan = new Scanner(System.in);

    public SystemMenu(String[] accounting, String[] menu, String[] orders) {

        this.accounting = new String[accounting.length];
        this.menu = new String[menu.length];
        this.orders = new String[orders.length];
    }




    public void ordersCreation() {

        String[] updatedOrder = new String[orders.length + 1];
        for (int i = 0; i < orders.length - 1; i++){
            updatedOrder[i] = orders[i];
        }

        String newSale = OrderingSystem.makeNewSale();
        String order = OrderingSystem.createOrder();
        updatedOrder[orders.length] = newSale + order;

        orders = updatedOrder;

    }


    public static void menuEditing() {

    }

    public static void accountingManagement() {

    }


    public static void main(String[] args) { //system menu

        Scanner scan = new Scanner(System.in);

        boolean program = true;

        while(program){
            System.out.println("Welcome to Marios pizza ordering system.");
            System.out.println("Pick your choice");
            // printMenu


            System.out.println("Press 1 if you would like to add orders.");
            System.out.println("Press 2 if you would like to edit the menu.");
            System.out.println("Press 3 if you would like to check accounting");
            System.out.println("Press 4 if you would like to quit the program");


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
                    program = false;
                    System.out.println("You ended the program");
                default:
                    System.out.println("You choose a wrong number.");
            }
        }
    }
}

