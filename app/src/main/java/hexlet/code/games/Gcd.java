package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {

    private static final int QUESTIONS_COUNT = 3;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final String TASK = "Find the greatest common divisor of given numbers.";
    private static final int QUESTION_ROW_NUMBER = 0;
    private static final int ANSWER_ROW_NUMBER = 1;
    public static void start() {
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][2];

        for (String[] questionAnswer : questionsAnswers) {
            int questionNumber1 = Engine.generateNumber(1, MAX_RANDOM_NUMBER);
            int questionNumber2 = Engine.generateNumber(1, MAX_RANDOM_NUMBER);
            questionAnswer[QUESTION_ROW_NUMBER] = questionNumber1 + " " + questionNumber2;
            questionAnswer[ANSWER_ROW_NUMBER] = String.valueOf(gcd(questionNumber1, questionNumber2));
        }
        Engine.startGame(TASK, questionsAnswers);
    }

    private static int gcd(int a, int b) {
        return a == 0 ? b : gcd(b % a, a);
    }

}
