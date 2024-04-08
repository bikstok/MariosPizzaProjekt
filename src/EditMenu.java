import java.util.*;
public class EditMenu{
    public static String[] pizzas = new String[14];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){

        while (true){
            System.out.println("Choose an option");
            System.out.println("1. Edit pizza");
            System.out.println("2. View menu");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                   // editPizza();
                   break;
                case 2:
                    // displayMenu();
                    break;
                case 3:
                    System.out.println("Exiting");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again");



            }
            }

        }

        public static void displayMenu(){

        }
    }




