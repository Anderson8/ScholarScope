package com.example.dalla.scholarscope2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


public class RegistrationActivity extends AppCompatActivity implements OnClickListener {

    private Button registration;
    private EditText Major;
    private EditText GPA;
    private EditText Classification;
    private EditText BannerId;
    private LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        registration = (Button) findViewById(R.id.registration_btn);
        Major = (EditText) findViewById(R.id.major);
        GPA = (EditText) findViewById(R.id.gpa);
        Classification = (EditText) findViewById(R.id.classification);
        BannerId = (EditText) findViewById(R.id.bannerId);
        registration.setOnClickListener(this);
        layout.setVisibility(View.GONE);

        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String major = Major.getText().toString();
                String gpa = GPA.getText().toString();
                String classification = Classification.getText().toString();
                String bannerId = BannerId.getText().toString();


               /* if (!major.isEmpty() && !gpa.isEmpty() && !classification.isEmpty() && !bannerId.isEmpty()) {
                    showDialog("Registration Complete");
                } else {
                    showDialog("Please enter your details!");
                }*/
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));

            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}




