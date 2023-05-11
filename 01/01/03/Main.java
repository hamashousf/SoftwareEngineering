import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main{
    public static void main(String... args){
        List<Integer> primeNumbers = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        int target = 0;
        boolean isPrime;
        while(target < 2){
            try{
                System.out.print("Target: ");
                target = scanner.nextInt();
            }catch(InputMismatchException e){
                System.out.println("The value entered must be at least 2.");
                scanner.next();
            }
        }
        scanner.close();
        for(int i=2; i <= target; i++){
            isPrime = true;
            for(int primeNumber : primeNumbers){
                if(i % primeNumber == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primeNumbers.add(i);
            }
        }
        System.out.printf("Maximum: %d%n", primeNumbers.get(primeNumbers.size() - 1));
    }
}
