package com.example.damiankocjan_ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createTaskButton = findViewById(R.id.btnMainCreateTask);
        createTaskButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, CreateTaskActivity.class);
            startActivity(intent);
        });

        assertLoggedIn();
        updateTaskList();
    }

    @Override
    protected void onResume() {
        super.onResume();
        assertLoggedIn();
        updateTaskList();
    }

    private void assertLoggedIn() {
        boolean isLoggedIn = State.getInstance().isLogged();
        if (isLoggedIn) {
            return;
        }

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void updateTaskList() {
        FragmentManager fragmentManager = getSupportFragmentManager();

        LinearLayout llTasks = findViewById(R.id.llTasks);
        llTasks.removeAllViewsInLayout();

        for (String task : State.getInstance().getTasks()) {
            Log.d("MainActivity", "task: " + task);
            fragmentManager.beginTransaction()
                    .add(R.id.llTasks, TaskFragment.newInstance(task)).commit();
        }
    }
}