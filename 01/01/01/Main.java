import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static final int MAX_RETRIES = 3;

    public static void main(String... args){
        final int amount_of_received = 10000;
        final List<Integer> currencies = new ArrayList<Integer>(Arrays.asList(10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1));
        final List<Integer> excluded_currencies = new ArrayList<Integer>(Arrays.asList(2000));

        Scanner input = new Scanner(System.in);
        String input_string;
        int amount_of_payment;
        final int change;
        List<Integer> change_list = new ArrayList<Integer>();
        int balance;

        //INPUT
        System.out.printf("Please input the amount of payment(0-%d).", amount_of_received);
        for(int i=0; i<MAX_RETRIES; i++){
            try{
                input_string = input.nextLine();
                amount_of_payment = Integer.parseInt(input_string);
                if((amount_of_payment < 0) || (amount_of_payment > amount_of_received)){
                    System.out.printf("Please input a number(0-%d). Remaining Attempts: %d\n", amount_of_received, MAX_RETRIES-i);
                    continue;
                }
                break;
            }catch(NumberFormatException exception){
                System.out.printf("Invalid value. Remaining Attempts: %d\n", MAX_RETRIES-i);
            }
        }

        //CALCULATION
        change = amount_of_received - amount_of_payment;
        balance = change;
        for(int currency : currencies){
            if(excluded_currencies.contains(currency)){
                change_list.add(0);
                continue;
            }
            change_list.add(balance / currency);
            balance %= currency;
        }
    }
}
