package com.example.tableorder;

import android.view.View;
import android.widget.TextView;

import com.example.tableorder.asset.AbstractFragment;

public class Main extends AbstractFragment {

    private TextView Main_Name_TextView;

    @Override
    protected int getViewId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void associate(View view) {
        this.Main_Name_TextView = view.findViewById(R.id.Main_Name_TextView);
    }

    @Override
    protected void initialize() {
        if(this.getArguments() != null) {
            MainArgs args = MainArgs.fromBundle(getArguments());
            this.Main_Name_TextView.setText(args.getUserName());
        }
    }
}