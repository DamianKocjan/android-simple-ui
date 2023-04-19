package com.example.damiankocjan_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class CreateTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);

        EditText taskName = findViewById(R.id.etTaskName);
        Button createTaskButton = findViewById(R.id.btnCreateTask);

        createTaskButton.setOnClickListener(v -> {
            String task = taskName.getText().toString();

            boolean isValid = TaskValidator.validate(task);
            if (!isValid) {
                return;
            }

            State.getInstance().addTask(task);
            finish();
        });
    }
}