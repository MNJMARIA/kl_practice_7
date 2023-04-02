package task_2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConversion {
    private Scanner scanner = new Scanner(System.in);
    private Map<String, Double> exchangeRates = new HashMap<>();
    private double amount;
    private String currentCurrency;
    private String currencyToConvert;

    public void showMenu(){
        System.out.println("COVERT RATE");
        System.out.printf("%-12s\t%-4s\t%-8s\t%-8s%n", "Currency","Code","Purchase","Selling");
        System.out.printf("%-12s\t%-4s\t%-8s\t%-8s%n", "Гривня", "UAH", "1.0000", "1.0000");
        System.out.printf("%-12s\t%-4s\t%-8s\t%-8s%n", "Долар США", "USD", "37,5500", "38,5500");
        System.out.printf("%-12s\t%-4s\t%-8s\t%-8s%n", "Євро", "EUR", "40.4000", "41.2000");
        System.out.printf("%-12s\t%-4s\t%-8s\t%-8s%n", "Фунт стерлінгів", "GBP", "44.5000", "47.5000");
        System.out.printf("%-12s\t%-4s\t%-8s\t%-8s%n", "Злотий", "PLN", "8.3000", "8.5000");

        initializeMapExchangeRates();

        try{
            System.out.print("\nEnter the amount of money: ");
            amount = scanner.nextDouble();
        } catch(InputMismatchException e){
            System.out.println("Incorrect type of input! Please enter a valid number.");
            scanner.nextLine(); //у буфері сканера залишилось невірне  значення і ми його прибираємо
            showMenu(); // знову виводимо метод після помилки користувача
            return; // вихід з методу
        }

        System.out.print("Enter your current currency (e.g. UAH): ");
        currentCurrency = scanner.next().toUpperCase();
        while(!exchangeRates.containsKey(currentCurrency))
        {
            System.out.println("Invalid currency code! Please enter a valid code.");
            System.out.print("Enter your current currency (e.g. UAH): ");
            currentCurrency = scanner.next().toUpperCase();
        }

        System.out.print("Enter the currency you want to convert (e.g. EUR): ");
        currencyToConvert = scanner.next().toUpperCase();
        while(!exchangeRates.containsKey(currencyToConvert))
        {
            System.out.println("Invalid currency code! Please enter a valid code.");
            System.out.print("Enter the currency you want to convert (e.g. EUR): ");
            currencyToConvert = scanner.next().toUpperCase();
        }
        convert();
    }
    private void initializeMapExchangeRates(){
        exchangeRates.put("UAH", 1.0);
        exchangeRates.put("USD", 37.6);
        exchangeRates.put("EUR", 40.4);
        exchangeRates.put("GBP", 44.5);
        exchangeRates.put("PLN", 8.3);
    }
    private void convert(){
        double currentRate = exchangeRates.get(currentCurrency);
        double convertRate = exchangeRates.get(currencyToConvert);
        double convertedAmount = amount * (currentRate/convertRate);
        System.out.printf("%.2f %s = %.2f %s", amount, currentCurrency, convertedAmount, currencyToConvert);

        scanner.close();
    }
}
