package com.example.e_assess.ui.HomeAdmin;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.e_assess.R;
import com.example.e_assess.ui.home.HomeViewModel;

public class HomeAdmin_fragment extends Fragment {
    private HomeAdminViewModel homeAdminViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeAdminViewModel =
                new ViewModelProvider((ViewModelStoreOwner) this).get(HomeAdminViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_admin, container, false);
        final TextView textView = root.findViewById(R.id.text_home_admin);
        homeAdminViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }



}
