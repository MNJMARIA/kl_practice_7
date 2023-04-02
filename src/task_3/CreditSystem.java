package task_3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CreditSystem {
    Scanner scanner = new Scanner(System.in);
    private Borrower borrower = new Borrower();
    private List<Borrower> borrowers = new ArrayList<>();

    private String enteredFirstName;
    private String enteredSecondName;
    private String enteredThirdName;


    public CreditSystem(){
        initializeBorrowers();
    }

    private void initializeBorrowers(){
        addBorrower(new Borrower(1, "Bell", "Cranel", "Oleksandrovich", LocalDate.of(2001, 05, 12), 1, 200000));
        addBorrower(new Borrower(2, "Ivan", "Ivanov","Ivanovich", LocalDate.of(1986, 7,21 ), 3, 150000));
        addBorrower(new Borrower(3, "Peter", "Kim", "Oleksandovich",LocalDate.of(1995, 11, 5), 1, 8000));
    }
    public int getCountOfBorrowers(){
       return borrowers.size();
    }
    public void makePayment(Borrower borrower){
        // Метод для внесення платежів(погашення боргу)
        System.out.println("Repay the debt");
        System.out.print("Enter sum: ");
        int sum = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                sum = scanner.nextInt();
                if (sum <= 0) {
                    throw new InputMismatchException();
                }
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.print("Please enter a valid integer: ");
                scanner.nextLine(); // consume the remaining newline
            }
        }
        while (sum > borrower.getAmountOfDebt()) {
            System.out.println("Your debt is: " + borrower.getAmountOfDebt() + ". You want to pay too much: " + sum + ".");
            System.out.print("Enter a smaller sum: ");
            validInput = false;
            while (!validInput) {
                try {
                    sum = scanner.nextInt();
                    if (sum <= 0) {
                        throw new InputMismatchException();
                    }
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid positive integer.");
                    scanner.nextLine(); // consume the remaining newline
                }
            }
        }
        borrower.setAmountOfDebt(borrower.getAmountOfDebt() - sum) ;
        if(isBorrower(borrower)){
            System.out.println("Thanks! Now your debt is: " + borrower.getAmountOfDebt());
        } else{
            System.out.println("Thanks! Now you are not borrower.");
            deleteBorrower(borrower);
        }
    }
    public Borrower getBorrowerByBasicInfo(){
        System.out.print("Please enter your first name (e.g Maria): ");
        while (true) {
            try {
                enteredFirstName = scanner.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid first name.");
                scanner.next();
            }
        }
        System.out.print("Enter your second name (e.g Stepanova): ");
        while (true) {
            try {
                enteredSecondName = scanner.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid second name.");
                scanner.next();
            }
        }
        System.out.print("Enter your third name (e.g Oleksandrivna): ");
        while (true) {
            try {
                enteredThirdName = scanner.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid third name.");
                scanner.next();
            }
        }

        for(Borrower borrower: borrowers)
        {
            if(borrower.getFirstName().equals(enteredFirstName) &&
                    borrower.getSecondName().equals(enteredSecondName) &&
                    borrower.getThirdName().equals(enteredThirdName)){
                return borrower;
            }
        }
        return null;
    }
    public void printBorrower(Borrower borrower){
        if(borrower != null){
            System.out.println(borrower);
        } else{
            System.out.println("The debtor with such data does not exist in the system!");
        }

    }
    public void printAllBorrowers() {
        //виведення інформації про всіх позичальників
        for (Borrower borrower : borrowers) {
            System.out.println(borrower);
        }
    }
    public boolean isBorrower(Borrower borrower){
        //перевірка чи є ще людина боржником
        return borrower.getAmountOfDebt() != 0; // якщо 0, тоді не боржник(false)
    }
    private void addBorrower(Borrower borrower){
        borrowers.add(borrower);
    }
    public void addNewBorrower(){
        int enteredYear;
        int enteredMonth;
        int enteredDay;
        LocalDate enteredBirthday;
        int enteredCreditCount = 1; //створили нового позичальника(отже він бере кредит, тому 1)
        double enteredAmountOfDebt;

        System.out.print("Please enter your first name (e.g Maria): ");
        while (true) {
            try {
                enteredFirstName = scanner.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid first name.");
                scanner.next();
            }
        }
        System.out.print("Enter your second name (e.g Stepanova): ");
        while (true) {
            try {
                enteredSecondName = scanner.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid second name.");
                scanner.next();
            }
        }
        System.out.print("Enter your third name (e.g Oleksandrivna): ");
        while (true) {
            try {
                enteredThirdName = scanner.next("[a-zA-Z]+");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid third name.");
                scanner.next();
            }
        }

        System.out.print("Enter borrowers birthday: \n");
        while (true) {
            try {
                System.out.print("Year: ");
                enteredYear = scanner.nextInt();
                if (enteredYear < 1900 || enteredYear > 2005) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid year.");
            }
        }
        while (true) {
            try {
                System.out.print("Month: ");
                enteredMonth = scanner.nextInt();
                if (enteredMonth < 1 || enteredMonth > 12) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid month (1-12).");
            }
        }
        while (true) {
            try {
                System.out.print("Day: ");
                enteredDay = scanner.nextInt();
                if (enteredDay < 1 || enteredDay > 31) {
                    throw new InputMismatchException();
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid day (1-31).");
            }
        }
        enteredBirthday = LocalDate.of(enteredYear, enteredMonth, enteredDay);
        while (true) {
            try {
                System.out.print("Enter sum of credit: ");
                enteredAmountOfDebt = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid amount.");
                scanner.next();
            }
        }

        addBorrower(new Borrower(getCountOfBorrowers()+1 , enteredFirstName, enteredSecondName, enteredThirdName,
                enteredBirthday, enteredCreditCount, enteredAmountOfDebt));

    }
    public void deleteBorrower(Borrower borrower){
        borrowers.remove(borrower);
    }
}
