import java.util.*;
public class MazeRunner {
    static Maze myMap = new Maze();
    public static void main(String[] args){
        intro();
        userMove();
    }
    public static void intro(){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position:");
        myMap.printMap();
        System.out.println("----------------------------------------");

    }
    public static String userMove () {
        System.out.println("Where would you like to move? (R, L, U, D)");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        choice = choice.toUpperCase();
        int moves = 0;
        while (!myMap.didIWin()) {
            /* Three options are you can move and a move is added to the counter,
            there's a pit so you decide whether to jump it or
            not(doesn't add to counter), and there's a wall
            so there's nothing you can do but move another direction
             */
            if (choice.equals("R")) {
                if (myMap.canIMoveRight()) {
                    myMap.moveRight();
                    myMap.printMap();
                    moves++;
                    /*enters the number of moves until it hits a case where it can
                     return a string alerting you of the number of moves you've taken*/
                    movesMessages(moves);
                } else if(myMap.isThereAPit(choice)){
                    navigatePit(choice);
                } else {
                    System.out.println("Sorry you have hit a wall. Please choose another move.");
                }
            }
            else if (choice.equals("L")) {
                if (myMap.canIMoveLeft()) {
                    myMap.moveLeft();
                    myMap.printMap();
                    moves++;
                    movesMessages(moves);
                }else if(myMap.isThereAPit(choice)){
                    navigatePit(choice);
                }else {
                    System.out.println("Sorry you have hit a wall. Please choose another move.");
                }
            }else if (choice.equals("U")) {
                if (myMap.canIMoveUp()) {
                    myMap.moveUp();
                    myMap.printMap();
                    moves++;
                    movesMessages(moves);
                }else if(myMap.isThereAPit(choice)){
                    navigatePit(choice);
                }else {
                    System.out.println("Sorry you have hit a wall. Please choose another move.");
                }
            }else if (choice.equals("D")) {
                if (myMap.canIMoveDown()) {
                    myMap.moveDown();
                    myMap.printMap();
                    moves++;
                    movesMessages(moves);
                }
                else if(myMap.isThereAPit(choice)){
                    navigatePit(choice);
                }else{
                    System.out.println("Sorry you have hit a wall. Please choose another move.");
                }
            }
            else{
                System.out.println("That is a not a valid choice. Please choose again.");
            }
            //While not true, keep asking for input
            System.out.println("Where would you like to move? (R, L, U, D)");
            choice = input.next();
            choice = choice.toUpperCase();

        }
        System.out.println("Congratulations, you made it out alive and you did it in "+moves+" moves!");
        return choice; }
//Users only have 100 steps to move before the exit to the maze closes
    public static void movesMessages(int moves){
        if (moves==50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        }else if( moves ==75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
        }else if (moves==90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        }else if (moves == 100) {
        // Exits because user takes too long to escape
        System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[) \nSorry, but you didn't escape in time- you lose!");
        System.exit(0);
    }}

    public static void navigatePit(String choice){
        Scanner input = new Scanner(System.in);
        if (myMap.isThereAPit(choice)){System.out.println("Watch out! There's a pit ahead, jump it?");
            String answer = input.next();
            answer = answer.toLowerCase();
            if (answer.startsWith("y")){
                myMap.jumpOverPit(choice);
                myMap.printMap();
            }
        }
    }

}
