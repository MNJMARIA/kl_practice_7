package task_3;

import java.time.LocalDate;

public class Borrower {
    private int ID;
    private String firstName;
    private String secondName;
    private String thirdName;
    private LocalDate birthday;
    private int creditCount;
    private double amountOfDebt;

    public Borrower(){

    }
    public Borrower(int ID, String firstName, String secondName, String thirdName, LocalDate birthday, int creditCount, double amountOfDebt) {
        this.ID = ID;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.birthday = birthday;
        this.creditCount = creditCount;
        this.amountOfDebt = amountOfDebt;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String lastName) {
        this.secondName = lastName;
    }

    public String getThirdName() {
        return thirdName;
    }
    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public double getAmountOfDebt() {
        return amountOfDebt;
    }
    public void setAmountOfDebt(double amountOfDebt) {
        this.amountOfDebt = amountOfDebt;
    }

    @Override
    public String toString() {
        return "\nBorrower " + firstName + " " + secondName + " " + thirdName +
                "\n\tbirthday: " + birthday +
                "\n\tcreditCount: " + creditCount +
                "\n\tamountOfDebt: " + amountOfDebt;
    }
}
