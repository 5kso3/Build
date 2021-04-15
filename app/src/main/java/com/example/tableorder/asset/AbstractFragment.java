package com.example.tableorder.asset;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public abstract class AbstractFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(this.getViewId(), container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.associate(view);
        this.initialize();
    }

    protected abstract int getViewId();

    protected abstract void associate(View view);

    protected abstract void initialize();

    protected void navigateTo(int destinationId) {
        Navigation.findNavController(this.getView()).navigate(destinationId);
    }
}
