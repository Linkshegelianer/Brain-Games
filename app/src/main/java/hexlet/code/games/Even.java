package hexlet.code.games;

import hexlet.code.Engine;

public class Even {

    private static final int QUESTIONS_COUNT = 3;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final String TASK = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int QUESTION_ROW_NUMBER = 0;
    private static final int ANSWER_ROW_NUMBER = 1;
    public static void start() {
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][2];

        for (String[] questionAnswer : questionsAnswers) {
            int questionNumber = Engine.generateNumber(1, MAX_RANDOM_NUMBER);
            questionAnswer[QUESTION_ROW_NUMBER] = String.valueOf(questionNumber);
            questionAnswer[ANSWER_ROW_NUMBER] = (isEven(questionNumber)) ? "yes" : "no";
        }
        Engine.startGame(TASK, questionsAnswers);
    }

    private static boolean isEven(int currentNumber) {
        return currentNumber % 2 == 0;
    }

}
