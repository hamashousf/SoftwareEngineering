import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    private static final int MAX_RETRIES = 3;

    public static void main(String... args){
        final int amount_of_received = 10000;
        final List<Integer> currency = new ArrayList<Integer>(Arrays.asList(10000, 5000, 2000, 1000, 500, 100, 50, 10, 5, 1));
        final List<Integer> excluded_currency = new ArrayList<Integer>(Arrays.asList(2000));

        Scanner input = new Scanner(System.in);
        String input_string;

        for(int i=0; i<MAX_RETRIES; i++){
            try{
                input_string = input.nextLine();
                int amount_of_payment = Integer.parseInt(input_string);
                if(amount_of_payment > amount_of_received){
                    System.out.printf("Please enter a value less than %d\n", ); //TODO: THIS CODE IS NOT COMPLETED!
                }
                break;
            }catch(NumberFormatException exception){
                System.out.printf("Invalid value. Remaining Attempts: %d\n", MAX_RETRIES-i);
        }
    }
}
