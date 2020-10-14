package com.fishNco.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.fishNco.truecitizenquiz.model.Question;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_false;
    private Button button_true;
    private ImageButton button_next;
    private TextView textView_question;

    private int currentQuestionIndex = 0;

    private Question[] questionBank = new Question[] {
            new Question(R.string.question_amendments, false),
            new Question(R.string.question_constitution, true),
            new Question(R.string.question_declaration, true),
            new Question(R.string.question_independence_rights, true),
            new Question (R.string.question_religion, true),
            new Question(R.string.question_government, false),
            new Question(R.string.question_government_feds, false),
            new Question(R.string.question_government_senators, true),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_false = findViewById(R.id.false_button);
        button_true = findViewById(R.id.true_button);
        button_next = findViewById(R.id.next_button);
        textView_question = findViewById(R.id.answer_textView);

        //On Click Listener Interface: Activity has to implement View.OnClickListener
        button_false.setOnClickListener(this);
        button_true.setOnClickListener(this);
        button_next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next_button:
                //go to next question
                currentQuestionIndex = (currentQuestionIndex+1) % questionBank.length;
                updateQuestion();
                break;
        }
    }

    private void updateQuestion() {
        Log.d("Current", "onClick " + currentQuestionIndex);
        textView_question.setText(questionBank[currentQuestionIndex].getAnswerResId());
    }

    private void checkAnswer(boolean userChoseCorrect) {
        boolean answerIsTrue = questionBank[currentQuestionIndex].isAnswerTrue();
        int toastMessageId;

        if (userChoseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
        } else {
            toastMessageId = R.string.wrong_answer;
        }

        Toast.makeText(MainActivity.this, getResources().getText(toastMessageId), Toast.LENGTH_SHORT).show();
    }
}