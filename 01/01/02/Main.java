import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String... args){
        final double AverageBMICondition = 25;

        Scanner scanner = new Scanner(System.in);

        double height;
        double weight;
        double sumOfHeight = 0;
        double sumOfWeight = 0;

        Person maximum = new Person();
        Person minimum = new Person();
        Person average = new Person();
        List<Person> peopleWhoMeetTheCondition = new ArrayList<Person>();

        //INPUT
        while(true){
            while(true){
                try{
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
            if((height <= 0) || (weight <= 0)) break;
            Person person = new Person();
            person.setHeight(height);
            person.setWeight(weight);
            if((Double.isNaN(maximum.getBMI())) || (maximum.getBMI() < person.getBMI())){
                maximum = person;
            }
            if((Double.isNaN(minimum.getBMI())) || (minimum.getBMI() > person.getBMI())){
                minimum = person;
            }
            if(person.getBMI() >= AverageBMICondition) peopleWhoMeetTheCondition.add(person);
        }
        scanner.close();

        //CALCULATION
        for(Person person : peopleWhoMeetTheCondition){
            sumOfHeight += person.getHeight();
            sumOfWeight += person.getWeight();
        }
        average.setHeight(sumOfHeight / peopleWhoMeetTheCondition.size());
        average.setWeight(sumOfWeight / peopleWhoMeetTheCondition.size());

        //OUTPUT
        System.out.printf("MAXIMUM:%n\t Height: %5.2f; Weight: %4.2f; BMI: %4.2f%n", maximum.getHeight(), maximum.getWeight(), maximum.getBMI());
        System.out.printf("MINIMUM:%n\t Height: %5.2f; Weight: %4.2f; BMI: %4.2f%n", minimum.getHeight(), minimum.getWeight(), minimum.getBMI());
        System.out.printf("AVERAGE( BMI >= %4.2f ):%n\t Height: %5.2f; Weight: %4.2f; BMI: %4.2f%n", AverageBMICondition, average.getHeight(), average.getWeight(), average.getBMI());
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
