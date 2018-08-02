import java.util.*;

public class OddsAndEvens {

    public static void main(String[] args) {
        int i = 0;
        while (i < 2) {
            System.out.println("Let's play a game called 'Odds and Evens'");
            Scanner input = new Scanner(System.in);
            System.out.print("What is your name? ");
            String name = input.nextLine();
            System.out.println("Hi " + name + ", which do you choose? (O)dds or (E)vens?");
            String answer = input.nextLine();
            if (answer.equals("O")) {
                System.out.println(name + " has picked odds! The computer will be evens.");
            } else if (answer.equals("E")) {
                System.out.println(name + " has picked evens! The computer will be odds.");
            }
            System.out.println("-----------------------------------");
            System.out.println("How many 'fingers' do you put out?");
            int human = input.nextInt();
            Random rand = new Random();
            int computer = rand.nextInt(6);
            int sum = human + computer;
            System.out.println("The computer plays " + computer + " 'fingers'.");
            System.out.println("--------------------------------------");
            System.out.println("User + Computer Sum = " + (sum));
            boolean oddOrEven = sum % 2 == 0;
            if (oddOrEven) {
                System.out.println(sum + " is... even!");
                if (answer.equals("E")) {
                    System.out.println("That means " + name + " wins!");
                } else {
                    System.out.println("That means the computer wins!");
                }
            } else {
                System.out.println(sum + "is... odd!");
                if (answer.equals("O")) {
                    System.out.println("That means " + name + " wins!");
                } else {
                    System.out.println("That means the computer wins!");
                }
            }
            System.out.println("----------------------------------------");
            i++;
        }
    }
}
