/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.darkem.poo;

/**
 *
 * @author emmanuel
 */
public class Question {
    public String question;
    public Object[] answers;
    public String option;
    
    //ArrayList<Object> answers = new ArrayList<Object>();
    //ArrayList<String> options = new ArrayList<String>();
    
    private QuestionsFrame frame;
    private TutorialFrame frameT;
    private TestFrame testFrame;
    
    public Question(String question, Object[] answers, String option) {
        this.question = question;
        this.answers = answers;
        this.option = option;
    }
    public Question(String question, Answer answer, String option) {
        this.question = question;
        Object[] answers = {answer};
        this.answers = answers;
        this.option = option;
    }
    public Question(String question, String option) {
        this.question = question;
        this.option = option;
    }
    public String getQuestion(QuestionsFrame frame) {
        this.frame = frame;
        
        frame.addQuestionPanel(this);
        return question;
    }
    public String getQuestion(TestFrame frame) {
        this.testFrame = frame;
        
        frame.addQuestionPanel(this);
        return question;
    }
    public String getQuestion(TutorialFrame frame) {
        this.frameT = frame;
        
        frameT.addQuestionPanel(this);
        return question;
    }
    public Object getAnswer(int option) {
        Object selectedAnswer = answers[option];
        if(selectedAnswer.getClass() == Answer.class) {
           Answer answer = (Answer) selectedAnswer;
           if(this.frame != null) return answer.getAnswer(this.frame);
           if(this.testFrame != null) return answer.getAnswer(this.testFrame);
           return answer.getAnswer(frameT);
        }
        else if(selectedAnswer.getClass() == Question.class) {
            Question questionAnswer = (Question) selectedAnswer;
            if(this.frame != null) return questionAnswer.getQuestion(this.frame);
            if(this.testFrame.getClass(
            ) == TestFrame.class) return questionAnswer.getQuestion(this.testFrame);
            return questionAnswer.getQuestion(frameT);
        }
        return selectedAnswer;
    }
    
    public void addAnswer(Object answer) {
        if(this.answers == null) {
            Object[] answers = {answer};
            this.answers = answers;
            return;
        }
        Object[] newAnswers = new Object[this.answers.length+1];
        
        for(int i=0;i<this.answers.length;i++) {
            newAnswers[i] = this.answers[i];
        }
        newAnswers[this.answers.length] = answer;
        
        this.answers = newAnswers;
    }
    public void addAnswers(Object[] answers) {
        this.answers = answers;
    }
}
