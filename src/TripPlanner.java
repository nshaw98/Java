import java.util.*;

public class TripPlanner {
    public static void main(String[] args) {
        intro();
        travel();
        time();
        country();
    }

    public static void intro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name?");
        String name = input.nextLine();
        System.out.print("Nice to meet you" + " " + name + ", where are you travelling to?");
        String city = input.nextLine();
        System.out.println("Great!" + " " + city + " " + "sounds like a great trip");
        System.out.println("**************");
    }

    //System.out.println("**************");
    public static void travel() {
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling?");
        int days = input.nextInt();
        System.out.print("How much money, in USD, are you planning to spend on your trip?");
        double money = input.nextDouble();
        System.out.print("What is the three letter currency symbol for your travel destination?");
        String sym = input.next();
        System.out.print("How many" + " " + sym + " " + "are there in 1 USD?");
        double conversion = input.nextDouble();
        double moneydays = (money/days);
        moneydays = (double)((int)(moneydays * 100))/ 100.0;
        double moneycon = (money * conversion) / days;
        moneycon = (double)((int) (moneycon * 100))/100.0;
        System.out.println(" ");
        System.out.println("If you are travelling for " + days + " days that is the same as " + (days * 24) + " hours or " + (days * 1440)+" minutes");
        System.out.println("If you are going to spend " + "$" + money + " USD that means per day you can spend up to $" + moneydays + " USD");
        System.out.println("Your total budget in " + sym + " is " + (money * conversion) + " " + sym + ", which per day is " + moneycon + " " + sym);
        System.out.println("**************");
    }

    public static void time() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home and your destination?");
        int time = input.nextInt();
        int midnight = time % 24;
        int noon = (time + 12) % 24;
        System.out.println("That means that when it is midnight at home it will be " + midnight +":00 in your travel destination and when it is noon at home it will be " + noon +":00");
        System.out.println("**************");
        System.out.println(" ");
    }

    public static void country() {
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        double areakm = input.nextInt();
        double areamiles = (areakm * .386);// conversion was rounded so number's slightly off
        areamiles = (double) ((int) (areamiles * 100)) /100.0;
        System.out.println("In miles2 that is "+(areamiles));
        System.out.println("**************");
    }
}

