package com.wap.lab12;

import java.util.List;

public class Quiz {
    private Integer score = 0;
    private List<Question> questions;
    private Integer index = 0;

    public Quiz() {
        this.questions = QuestionInit.initQuestions();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Question getCurrentQuestion(){
        if(index < questions.size()) {
            return getQuestions().get(index);
        }
        return getQuestions().get(0);
    }
    public Question getNextQuestion(){
        return (index + 1  >= questions.size()) ? getQuestions().get(0) : getQuestions().get(index + 1);
    }

    public Boolean isNextQuestion(){
        if(index == questions.size()) {
            index = 0;
            return false;
        }
        index++;
        return true;
    }


    public void answerCorrectAddScore(String answer){
        System.out.println(getCurrentQuestion());
        if(getCurrentQuestion().answerCheck(answer)) score++;
    }




}
