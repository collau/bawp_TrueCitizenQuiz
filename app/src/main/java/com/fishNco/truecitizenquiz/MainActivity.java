package com.fishNco.truecitizenquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button button_false;
    private Button button_true;
    private TextView textView_question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_false = findViewById(R.id.false_button);
        button_true = findViewById(R.id.true_button);
        textView_question = findViewById(R.id.answer_textView);

        //On Click Listener Interface: Activity has to implement View.OnClickListener
        button_false.setOnClickListener(this);
        button_true.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.false_button:
                Toast.makeText(MainActivity.this, "False", Toast.LENGTH_SHORT).show();
                break;
            case R.id.true_button:
                Toast.makeText(MainActivity.this, "True", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}