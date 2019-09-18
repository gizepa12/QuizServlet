package com.wap.lab12;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestionInit {
    public static List<Question> initQuestions(){
        Question q1 = new Question("3, 1, 4, 1, 5", "9");
        Question q2 = new Question("1, 1, 2, 3, 5", "8");
        Question q3 = new Question("1, 4, 9, 16, 25", "36");
        Question q4 = new Question("2, 3, 5, 7, 11", "13");
        Question q5 = new Question("1, 2, 4, 8, 16", "32");
        List<Question> questions = Arrays.asList(q1,q2,q3,q4,q5);
        return shuffledQuestions(questions);
    }

    public static List<Question> shuffledQuestions(List<Question> questions){
        Random random = new Random();
        random.nextInt();
        int n = questions.size();
        for(int i = 0; i < n; i++){
            int j = i + random.nextInt(n - i);
            swap(questions, i , j);
        }
        return questions;
    }
    private static void swap(List<Question> questions, int i, int j) {
        Question helper = questions.get(i);
        questions.set(i, questions.get(j));
        questions.set(j, helper);
    }
}
