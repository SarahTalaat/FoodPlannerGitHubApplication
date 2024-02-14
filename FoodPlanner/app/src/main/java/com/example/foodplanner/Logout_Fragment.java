package com.example.foodplanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Logout_Fragment extends Fragment {

    FirebaseAuth auth;
    FirebaseUser user;
    Button button_logout;

    public Logout_Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_logout, container, false);


        auth=FirebaseAuth.getInstance();

        button_logout = view.findViewById(R.id.button_logout);

        user=auth.getCurrentUser();


        if(user == null){
            Intent intent = new Intent(getActivity(), Authentication_Activity.class);
            startActivity(intent);
        }else{

        }

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Authentication_Activity.class);
                startActivity(intent);
            }
        });




        /*  Intent intent = new Intent(getActivity(), NavigationDrawer_Activity.class);
                        startActivity(intent);*/
        return view;
    }
}