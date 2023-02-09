package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Prog {
    public static int[] generateSequence() {
        int[] sequence = new int[10];
        Random random = new Random();
        int difference = random.nextInt(10) + 1;
        int firstNumber = random.nextInt(10);
        sequence[0] = firstNumber;
        for (int i = 1; i < 10; i++) {
            int nextNumber = firstNumber + (i * difference);
            sequence[i] = nextNumber;
        }
        return sequence;
    }

    public static void findProg() {
        System.out.println("May I have your name? ");
        Scanner scannerName = new Scanner(System.in);
        String userName = scannerName.next();
        System.out.println("Hello, " + userName + "!");

        System.out.println("What number is missing in the progression?");

        int attempts = 3;
        boolean repeat = true;
        int correctAnswers = 0;
        while (repeat) {
            for (var i = 0; i < attempts; i++) {
                int[] sequence = generateSequence();
                int missingIndex = (int)(Math.random() * 10);
                int missingValue = sequence[missingIndex];
                sequence[missingIndex] = 0;

                System.out.print("Question: ");

                for (int j = 0; j < 10; j++) {
                    if (sequence[j] == 0) {
                        System.out.print(".. ");
                    } else {
                        System.out.print(sequence[j] + " ");
                    }
                }
                System.out.println();

                Scanner input = new Scanner(System.in);
                System.out.print("Your answer: ");
                int answer = input.nextInt();
                if (answer == missingValue) {
                    System.out.println("Correct!");
                    correctAnswers++;
                } else {
                    System.out.println("Incorrect!");
                    System.out.println("'" + answer + "'" + " is wrong answer ;(. Correct answer was " + "'" + missingValue + "'.");
                    correctAnswers = 0;
                    break;
                }

                if (correctAnswers == 3) {
                    System.out.println("Congratulations, " + userName + "!");
                    break;
                }
            }

            System.out.print("Do you want to continue playing? (yes/no): ");
            Scanner answerFinal = new Scanner(System.in);
            String answer = answerFinal.nextLine();
            if (!answer.equalsIgnoreCase("yes")) {
                repeat = false;
            }
        }

        System.out.println("Thanks for playing!");
    }
}