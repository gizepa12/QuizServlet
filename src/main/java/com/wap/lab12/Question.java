package com.wap.lab12;

public class Question {
    private String question;
    private String answer;

    public Question(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public boolean answerCheck(String answer){
        System.out.println(answer);
        if(answer == null) return false;
        System.out.println(this.answer.equals(answer));
        return this.answer.equals(answer);
    }

    @Override
    public String toString() {
        return question;
    }
}
