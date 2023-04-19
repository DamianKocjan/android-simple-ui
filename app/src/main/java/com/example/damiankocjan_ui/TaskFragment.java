package com.example.damiankocjan_ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TaskFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TaskFragment extends Fragment {
    private static final String ARG_NAME = "name";

    private String mName;

    public TaskFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param name Name of the task.
     * @return A new instance of fragment TaskFragment.
     */
    public static TaskFragment newInstance(String name) {
        TaskFragment fragment = new TaskFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString(ARG_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);

        TextView tvTaskName = view.findViewById(R.id.tvTaskName);
        tvTaskName.setText(mName);

        Button btnTaskRemove = view.findViewById(R.id.btnTaskRemove);
        btnTaskRemove.setOnClickListener(v -> {
            State.getInstance().removeTask(mName);

            MainActivity activity = (MainActivity) getActivity();
            assert activity != null;
            activity.updateTaskList();
        });

        return view;
    }
}