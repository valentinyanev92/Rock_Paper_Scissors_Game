
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Greetings();

        String rock = "rock";
        String paper = "paper";
        String scissors = "scissors";

        System.out.println("Insert your next move!");
        System.out.println("(R)ock \\ (S)cissors \\ (P)aper");
        String input = scanner.nextLine().toLowerCase();
        int playerWinCount = 0;
        int computerWinCount = 0;
        int draw = 0;
        while (!input.equals("end") && !input.equals("end game")) {
            String playerMove = "";
            String computerMove = ComputerMoveGenerator();
            boolean isValid = true;
            switch (input) {
                case "r", "rock" -> playerMove = "rock";
                case "s", "scissors" -> playerMove = "scissors";
                case "p", "paper" -> playerMove = "paper";
                default -> isValid = false;
            }
            if (!isValid) {
                System.out.println("Invalid choice!");
                System.out.print("Insert your next move again - ");
                System.out.println("(R)ock \\ (S)cissors \\ (P)aper");
                input = scanner.nextLine();
            } else {
                String winner = choiceWinner(playerMove, computerMove);
                System.out.printf("Player choice: %s   Computer choice: %s  Winner: %s!%n", playerMove.toUpperCase(), computerMove.toUpperCase(), winner.toUpperCase());
                switch (winner) {
                    case "player" -> playerWinCount++;
                    case "computer" -> computerWinCount++;
                    case "draw" -> draw++;
                }

                System.out.print("Insert your next move - ");
                System.out.println("(R)ock \\ (S)cissors \\ (P)aper");
                input = scanner.nextLine();
            }
        }
        String winner = "";
        if (playerWinCount > computerWinCount){
            winner = "player";
        } else if (computerWinCount > playerWinCount) {
           winner = "computer";
        }else {
            winner = "draw";
        }
        System.out.printf("Results: Player have %d wins, Computer have %d wins and %d draws.%n", playerWinCount, computerWinCount, draw);
        System.out.printf("Winner is: %s!", winner.toUpperCase());

    }

    private static String choiceWinner(String playerMove, String computerMove) {
        String winner = "";
        boolean playerPaper = false;
        boolean playerScissors = false;
        boolean playerRock = false;
        boolean computerPaper = false;
        boolean computerScissors = false;
        boolean computerRock = false;

        switch (playerMove) {
            case "r", "rock" -> playerRock = true;
            case "s", "scissors" -> playerScissors = true;
            case "p", "paper" -> playerPaper = true;
        }
        switch (computerMove) {
            case "r", "rock" -> computerRock = true;
            case "s", "scissors" -> computerScissors = true;
            case "p", "paper" -> computerPaper = true;
        }

        if (playerScissors && computerScissors || playerRock && computerRock || playerPaper && computerPaper) {
            winner = "draw";
            return winner;
        }
        if (playerPaper) {
            if (computerRock) {
                winner = "player";
                return winner;
            }
            if (computerScissors) {
                winner = "computer";
                return winner;
            }
        }
        if (playerScissors) {
            if (computerPaper) {
                winner = "player";
                return winner;
            }
            if (computerRock) {
                winner = "computer";
                return winner;
            }
        }
        if (playerRock) {
            if (computerScissors) {
                winner = "player";
                return winner;
            }
            if (computerPaper) {
                winner = "computer";
                return winner;
            }
        }

        return winner;
    }

    private static String ComputerMoveGenerator() {
        Random random = new Random();
        int numberMove = random.nextInt(3);
        String computerMove = "";
        switch (numberMove) {
            case 0 -> computerMove = "rock";
            case 1 -> computerMove = "scissors";
            case 2 -> computerMove = "paper";
        }
        return computerMove;
    }

    private static void Greetings() {
        System.out.println("This is rock-paper-scissor console game.");
        System.out.println("Rules are simple:");
        System.out.println("Rock beat scissors and lose from paper.");
        System.out.println("Paper beat rock and lose from scissors.");
        System.out.println("Scissors beat paper and lose from rock.");
        System.out.println();
        System.out.println("To choice rock type - \"rock\" or \"r\".");
        System.out.println("To choice paper type -\"paper\" or \"p\".");
        System.out.println("To choice scissors type - \"scissors\" or \"s\".");
        System.out.println("To end game and see result type - \"end\" or \"end game\".");
        System.out.println("Input is NOT case sensitive!");
        System.out.println();
        System.out.println("Lets play!");
    }
}