import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static final int MAX_RETRIES = 3;

    public static void main(String... args){
        final int amountOfReceived = 10000;
        final List<Integer> currencies = new ArrayList<Integer>(Arrays.asList(10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1));
        final List<Integer> excludedCurrencies = new ArrayList<Integer>(Arrays.asList(2000));

        Scanner input = new Scanner(System.in);
        int amountOfPayment = 0;
        final int change;
        int balance;

        //INPUT
        System.out.printf("Please input the amount of payment(0-%d): ", amountOfReceived);
        for(int i=0; i<MAX_RETRIES; i++){
            amountOfPayment = input.nextInt();
            if((amountOfPayment < 0) || (amountOfPayment > amountOfReceived)){
                System.out.printf("Please input a number(0-%d). Remaining Attempts: %d%n", amountOfReceived, MAX_RETRIES-i);
            }else{
                break;
            }
        }
        input.close();

        //CALCULATION
        change = amountOfReceived - amountOfPayment;
        balance = change;
        for(int currency : currencies){
            if(excludedCurrencies.contains(currency)){
                continue;
            }
            System.out.printf("%5d YEN: %d%n", currency, balance / currency);
            balance %= currency;
        }
    }
}
