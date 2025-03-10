import java.util.Scanner;

public class numberGame {
    static Scanner sc = new Scanner(System.in);

    // random number generation function here no. generates 1 - 100
    public static int randomGen(){
        int min = 1;
        int max = 100;
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    // user input here after start game take name input and also show the total score of user
    public static void userInput(){
        System.out.print("Enter Name: ");
        String userName = sc.next();
        int randomNo = randomGen();          // here random no is generated by calling randomGen function
        int userScore = guessNo(randomNo, 0);  // calling main comparison function
        System.out.println();
        System.out.println(userName + " Your Score: "+ userScore);
    }

    public static int guessNo(int randomNo, int score) {
        int chances = 6;                // chances how much to play
        while (chances > 0){
            System.out.print("Enter Number: ");
            int userGuess = sc.nextInt();
            chances--;                  // chances decrement show how much chances left

            if (randomNo == userGuess) {
                System.out.println("Correct...! You guess right number.\n");
                score++;
                break;                  // if user guess correct number then we break from this loop
            } else if (userGuess > randomNo) {
                System.out.println("Oh No...! Your Guess Number is Greater "+ chances +" Chances left \n");
            } else {
                System.out.println("Oh No...! Your Guess Number is Smaller "+ chances +" Chances left \n");
            }
        }
        System.out.println("The random number is: "+ randomNo);

        // to check user want to play again or not
        System.out.print("\nPlay again (Y or N) : ");
        String playAgain = sc.next();
        if(playAgain.equalsIgnoreCase("Y")){
            int newRandomGen = randomGen();             // new random generates if user play again
            guessNo(newRandomGen, score);               // calling the function recursively if play again
        }
        return score;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("********** Number Guess Game **********");
        // instruction of game how to play this game and rules
        System.out.println(
                "Instruction (How to Play)\n" +
                "- You have 6 Chances to Guess Correct Number\n" +
                "- Its show the your Guess number is Greater or Smaller than the random no.\n" +
                "- The Number you want to choose between 1 - 100\n\n"
        );

        // Start of game selection
        int userInput;
        while (true){
            System.out.println("\n\n1. Play Game");
            System.out.println("2. Exit");
            System.out.print("\n\nSelect: ");
            userInput = sc.nextInt();
            if(userInput == 1) userInput();
            else break;
        }
    }
}
