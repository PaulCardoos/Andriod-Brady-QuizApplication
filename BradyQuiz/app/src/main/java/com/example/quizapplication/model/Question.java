package com.example.quizapplication.model;

public class Question {
    private int answerRsId;
    private boolean answerTrue;

    public Question(int answerRsId, boolean answerTrue){
        this.answerRsId = answerRsId;
        this.answerTrue = answerTrue;
    }

    public boolean getAnswerTrue(){
        return this.answerTrue;
    }

    public void setAnswerTrue(boolean answer){
         this.answerTrue = answer;
    }

    public int getAnswerRsId(){
        return answerRsId;
    }

    public void setAnswerRsId(int newId){
        this.answerRsId = newId;
    }

}
