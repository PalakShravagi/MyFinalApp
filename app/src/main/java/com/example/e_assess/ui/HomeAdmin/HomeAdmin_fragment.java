  package com.example.e_assess.ui.HomeAdmin;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_assess.R;
import com.example.e_assess.model;
import com.example.e_assess.myadapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


  public class HomeAdmin_fragment  extends Fragment {
      RecyclerView review;
      myadapter adapter;
      private FirebaseAuth auth;
      private FirebaseUser user;
      String userID;
      private DatabaseReference reference;
     private HomeAdminViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider( this).get(HomeAdminViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_admin, container, false);
        review = (RecyclerView) root.findViewById(R.id.review);
        review.setLayoutManager(new LinearLayoutManager(getContext()));

        FirebaseRecyclerOptions<model> options =
                new FirebaseRecyclerOptions.Builder<model>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("Users"), model.class)
                        .build();


        adapter = new myadapter(options);
        review.setAdapter(adapter);


        return root;
    }


      @Override
      public void onStart() {
          super.onStart();
          adapter.startListening();
      }

      @Override
      public void onStop() {
          super.onStop();
          adapter.stopListening();
      }

}
