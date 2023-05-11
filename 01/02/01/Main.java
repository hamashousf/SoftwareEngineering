import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main{
    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);

        Map<String, Address> addresses = new HashMap<String, Address>();
        String name;
        String number;
        String email;
        Address address;

        //INPUT
        while(true){
            System.out.print("Name: ");
            name = scanner.next();
            System.out.print("Number: ");
            number = scanner.next();
            System.out.print("Email: ");
            email = scanner.next();
            if(name.charAt(0) == '0') break;
            address = new Address();
            address.setNumber(number);
            address.setEmail(email);
            addresses.put(name, address);
        }

        //SEARCH
        System.out.println("Search mode");
        while(true){
            System.out.print("Name: ");
            name = scanner.next();
            if(name.charAt(0) == '0') break;
            address = addresses.get(name);
            if(address != null){
                System.out.printf("Number: %s%n", address.getNumber());
                System.out.printf("Email: %s%n", address.getEmail());
                break;
            }else{
                System.out.println("No data found.");
            }
        }
        scanner.close();
    }
}

class Address{
    private String number;
    private String email;
    public void setNumber(final String number){
        this.number = number;
    }
    public void setEmail(final String email){
        this.email = email;
    }
    public String getNumber(){
        return this.number;
    }
    public String getEmail(){
        return this.email;
    }
}
