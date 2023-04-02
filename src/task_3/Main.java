package task_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static CreditSystem creditSystem = new CreditSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        System.out.println("CREDIT SYSTEM");
        System.out.println("MAIN MENU");
        System.out.println("1. Show menu for administrators");
        System.out.println("2. Show menu for users");
        System.out.println("3. Exit");
        System.out.print("\nChoose the option: ");
        option = nextIntSafe(scanner);

        switch(option){
            case 1:
                checkAccess();
                showMenuForAdministrators();
                break;
            case 2:
                showMenuForUsers();
                break;
            case 3:
                System.out.println("Exiting the program...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option selected. Please choose a valid option.");
        }
    }
    private static void showMenuForAdministrators(){
        System.out.println("\nOPTIONS ");
        System.out.println("1. Add a new borrower");
        System.out.println("2. Delete a borrower");
        System.out.println("3. Show info about all borrowers");
        System.out.println("4. Back to main menu");
        System.out.print("\nChoose the option: ");
        int option = nextIntSafe(scanner);

        switch(option){
            case 1:
                creditSystem.addNewBorrower();
                showMenuForAdministrators();
                break;
            case 2:
                creditSystem.deleteBorrower(creditSystem.getBorrowerByBasicInfo());
                showMenuForAdministrators();
                break;
            case 3:
                creditSystem.printAllBorrowers();
                showMenuForAdministrators();
                break;
            case 4:
                System.out.println("Backing to main menu......");
                main(new String[]{});
                break;
            default:
                System.out.println("Invalid option selected. Please choose a valid option.");
                showMenuForAdministrators();
        }
    }
    private static void showMenuForUsers(){
        System.out.println("\nOPTIONS ");
        System.out.println("1. Show my info");
        System.out.println("2. Repay the debt");
        System.out.println("3. Back to main menu");
        System.out.print("\nChoose the option: ");
        int option = nextIntSafe(scanner);

        switch(option){
            case 1:
                creditSystem.printBorrower(creditSystem.getBorrowerByBasicInfo());
                showMenuForUsers();
                break;
            case 2:
                creditSystem.makePayment(creditSystem.getBorrowerByBasicInfo());
                showMenuForUsers();
                break;
            case 3:
                System.out.println("Backing to main menu......");
                main(new String[]{});
                break;
            default:
                System.out.println("Invalid option selected. Please choose a valid option.");
                showMenuForUsers();
        }
    }
    private static void checkAccess(){
        System.out.print("Enter password to continue: ");
        String password = scanner.next();
        while(!password.equals("qwerty")) {
            System.out.println("Wrong password! You do not have access to this feature! Try again.");
            password = scanner.next();
        }
        System.out.println("Success!");
    }
    private static int nextIntSafe(Scanner scanner) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                value = scanner.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid integer: ");
                scanner.nextLine(); // consume the remaining newline
            }
        }
        return value;
    }
}
