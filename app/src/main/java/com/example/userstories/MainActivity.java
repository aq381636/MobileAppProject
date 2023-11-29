package com.example.userstories;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int questionumber = 0;
    private int finalmoney = 0;
    private TextView questionholder, counter;
    private Button nextquestion;
    private Button Briefcase1;
    private Button Briefcase2, pass;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        questionholder = findViewById(R.id.questionholder);
        counter = findViewById(R.id.counter);
        nextquestion = findViewById(R.id.nextquestion);
        Briefcase1 = findViewById(R.id.Briefcase1);
        Briefcase2 = findViewById(R.id.Briefcase2);
        pass = findViewById(R.id.pass);
        Nextquestion(); //question is displayed
        // the next question and pass button do the same thing
        nextquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionumber++;
                if (questionumber >= question.length) {
                    // If all questions are answered, loop back to the first question
                    questionumber = 0;
                }

                Nextquestion();
            }
        });


        Briefcase1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check the selected suitcase's answer and display amount
                answeramount(0);
            }
        });

        Briefcase2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check the selected suitcase's answer and display amount
                answeramount(0);
            }
        });

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // allows users to skip questions and at the end of question bank the first question is displayed again
                questionumber++;
                if (questionumber >= question.length) {
                    // If all questions are answered, loop back to the first question
                    questionumber = 0;
                }
                Nextquestion();
            }
        });
    }


    //Questions can be added here
    private String[] question = {"This is question 1", "This is question 2", "This is question 3", "This is question 4"};
    private String[] correctAnswers = {"choice 1", "choice 1", "choice 3", "choice 4"};
    private String[][] choice = {
            {"choice 1", "choice 2", "choice  3", "choice 4"},
            {"choice 1", "choice 2", "choice  3", "choice 4"},
            {"choice 1", "choice 2", "choice  3", "choice 4"},
            {"choice 1", "choice 2", "choice  3", "choice 4"}
    };

    // to test to see if the  counter I made worked I made the counter be coonected to the suitcase a
    //  suitcase is connected to the question and answer, the amount is displayed
    // the counter has to be connected to the question and question choices instead by the person assigned to that user story.
    private void answeramount(int suitcasechosen) {
        if (questionumber  < question.length) {

            String selectedAnswer = choice[questionumber ][suitcasechosen];// answer is obtained from array
            if (selectedAnswer.equals(correctAnswers[questionumber ])) {
                int questionamount = (questionumber + 1) * 50;
                // counter for each question money amount for this case I made the amount each question is worth is the question index times 50
                finalmoney += questionamount;
                counter.setText("$" + finalmoney);

                Toast.makeText(this, "You won $" + questionamount, Toast.LENGTH_SHORT).show();
            } else {
                // message to user if answer is right or wrong
                Toast.makeText(this, "Incorrect answer", Toast.LENGTH_SHORT).show();
            }

            questionumber ++;
            if (questionumber  < question.length) {
                // questions bank goes in a loop
                Nextquestion();
            }
        }
    }

    private void Nextquestion() {
        if (questionumber < question.length) {

            questionholder.setText(question[questionumber]);

        } else {

            Toast.makeText(this, "All questions answered!", Toast.LENGTH_SHORT).show();
        }
    }
}

