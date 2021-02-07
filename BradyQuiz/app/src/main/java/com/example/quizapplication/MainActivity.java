package com.example.quizapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.quizapplication.databinding.ActivityMainBinding;
import com.example.quizapplication.model.Question;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Question[] question;
    private int index = 0;

    public MainActivity() {
        question = new Question[]{
            new Question(R.string.question_white, false),
            new Question(R.string.question_brady, true),
            new Question(R.string.question_goat, true),
            new Question(R.string.question_superBowls, true),
            new Question(R.string.question_diet, false),
            new Question(R.string.question_manyMen, true),
            new Question(R.string.question_edelman, true),
            new Question(R.string.question_peyton, false),
           new Question(R.string.question_malcolm, true),
        };

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.question.setText(question[index].getAnswerRsId());
        binding.nextBtn.setOnClickListener(v -> {
            updateQuestion();
        });
        binding.prevBtn.setOnClickListener(v -> {
            prevQuestion();
        });

        binding.trueButton.setOnClickListener(v -> {
            isCorrect(question[index]);
        });

        binding.falseButton.setOnClickListener(v -> isFalseCorrect(question[index]));

    }

    private void isFalseCorrect(Question question) {
        binding.answer.setVisibility(View.GONE);
        if (!question.getAnswerTrue()) {
            binding.answer.setText(R.string.answer_correct);
        } else {
            binding.answer.setText(R.string.answer_wrong);
        }
        binding.answer.setVisibility(View.VISIBLE);

    }


    private void isCorrect(Question question) {
        binding.answer.setVisibility(View.GONE);
        if (question.getAnswerTrue()) {
            binding.answer.setText(R.string.answer_correct);
        } else {
            binding.answer.setText(R.string.answer_wrong);
        }
        binding.answer.setVisibility(View.VISIBLE);

    }

    private void prevQuestion() {
        binding.answer.setVisibility(View.GONE);
        if(index == 0) return;
        binding.question.setText(question[--index % 9].getAnswerRsId());
    }

    private void updateQuestion() {
        binding.answer.setVisibility(View.GONE);
        binding.question.setText(question[++index % 9].getAnswerRsId());
    }


}