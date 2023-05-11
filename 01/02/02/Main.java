import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String... args){
        final double Slender = 18.5;
        final double Fatness = 25.0;

        List<Person> people = new ArrayList<Person>();
        Scanner scanner = new Scanner(System.in);

        String name;
        double height;
        double weight;
        //INPUT
        while(true){
            while(true){
                try{
                    System.out.print("Name: ");
                    name = scanner.next();
                    System.out.print("Height: ");
                    height = scanner.nextDouble();
                    System.out.print("Weight: ");
                    weight = scanner.nextDouble();
                    break;
                }catch(InputMismatchException e){
                    System.out.println("The input value must be a real number.");
                    scanner.next();
                }
            }
            if(name.charAt(0) == '0') break;
            Person person = new Person();
            person.setName(name);
            person.setHeight(height);
            person.setWeight(weight);
            people.add(person);
        }
        scanner.close();
        //OUTPUT
        System.out.println("Slender:");
        for(Person person: people){
            if(person.getBMI() < Slender){
                System.out.printf("\t%s%n", person.getName());
            }
        }
        System.out.println("Normal:");
        for(Person person: people){
            if(Fatness > person.getBMI() && person.getBMI() >= Slender){
                System.out.printf("\t%s%n", person.getName());
            }
        }
        System.out.println("Fatness:");
        for(Person person: people){
            if(person.getBMI() >= Fatness){
                System.out.printf("\t%s%n", person.getName());
            }
        }
    }
}

class Person{
    private String name = null;
    private double height = 0;
    private double weight = 0;
    public void setName(final String name){
        this.name = name;
    }
    public void setHeight(final double height){
        if(height <= 0){
            throw new IllegalArgumentException("{height} must be positive.");
        }
        this.height = height;
    }
    public void setWeight(final double weight){
        if(weight <= 0){
            throw new IllegalArgumentException("{weight} must be positive.");
        }
        this.weight = weight;
    }
    public String getName(){
        return this.name;
    }
    public double getHeight(){
        return this.height;
    }
    public double getWeight(){
        return this.weight;
    }
    public double getBMI(){
        return ((this.height == 0) || (this.weight == 0)) ? Double.NaN : (this.weight / Math.pow(this.height / 100, 2));
    }
}

