package task_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathOperations mathOperations = new MathOperations();

        System.out.print("Enter expression (e.g. 2+3): ");
        String expression = scanner.nextLine();

        //перевірка на коректність введеного виразу
        if(!expression.matches("^[0-9]+[+\\-*/][0-9]+$")){
            throw new IllegalArgumentException("Invalid expression! Try again!");
        }

        String[] parts = expression.split("[+\\-*/]"); // розділення за знаком операції

        int number1 = Integer.parseInt(parts[0].trim());
        int number2 = Integer.parseInt(parts[1].trim());
        char operation = expression.replaceAll("\\d", "").charAt(0);

        switch(operation){
            case '+':
                mathOperations.add(number1, number2);
                break;
            case '-':
                mathOperations.sub(number1, number2);
                break;
            case '*':
                mathOperations.mul(number1, number2);
                break;
            case '/':
                mathOperations.div(number1, number2);
                break;
            default:
                System.out.println("Invalid operation! Try again!");
        }
    }
}