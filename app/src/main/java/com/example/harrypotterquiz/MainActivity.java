package com.example.harrypotterquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void evaluate_first_question() {
        RadioButton ans3 = findViewById(R.id.q1_ans3);
        if (ans3.isChecked())
            ++points;
    }

    private void evaluate_second_question() {
        RadioButton ans1 = findViewById(R.id.q2_ans1);
        if (ans1.isChecked())
            ++points;
    }

    private void evaluate_fourth_question() {
        EditText ans4 = findViewById(R.id.q4_ans);
        if (ans4.getText().toString().equals("7")) ++points;
    }

    private void evaluate_third_question() {
        boolean addPoint = true;
        CheckBox[] answers = {findViewById(R.id.q3_ans1), findViewById(R.id.q3_ans2), findViewById(R.id.q3_ans3), findViewById(R.id.q3_ans4)};
        for (int i = 0; i < 4; ++i)
            if (!answers[i].isChecked()) {
                addPoint = false;
                break;
            }
        if (addPoint) ++points;
    }

    public void submit(View view) {
        evaluate_first_question();
        evaluate_second_question();
        evaluate_third_question();
        evaluate_fourth_question();
        String message;
        if (points == 4)
            message = getString(R.string.all_correct);
        else if (points == 0)
            message = getString(R.string.zero_correct);
        else
            message = getString(R.string.score_message, String.valueOf(points));
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        points = 0;
    }

}