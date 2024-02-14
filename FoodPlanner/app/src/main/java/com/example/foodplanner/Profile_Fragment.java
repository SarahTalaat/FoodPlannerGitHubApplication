package com.example.foodplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Profile_Fragment extends Fragment {


    TextView profileName , profileEmail, profileUsername , profilePassword;
    Button editProfileButton;
    String receiveName, receiveEmail, receiveUsername, receivePassword, recevedId;


    public Profile_Fragment() {
        // Required empty public constructor
    }

    public Profile_Fragment(String name , String email , String username , String password, String id){
        receiveName = name;
        receiveEmail =email;
        receiveUsername =username;
        receivePassword =password;
        recevedId=id;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileName = view.findViewById(R.id.tv_name_value_profile);
        profileEmail = view.findViewById(R.id.tv_email_value_profile);
        profileUsername = view.findViewById(R.id.tv_username_value_profile);
        profilePassword = view.findViewById(R.id.tv_password_value_profile);
        editProfileButton = view.findViewById(R.id.button_edit_profile_profile);

        /*
        Bundle bundle = this.getArguments();
        receiveName = bundle.getString("name");
        receiveEmail = bundle.getString("email");
        receiveUsername = bundle.getString("username");
        receivePassword = bundle.getString("password");
        recevedId = bundle.getString("id");
*/
        showUserData();

      editProfileButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Bundle bundle2 = new Bundle();
              bundle2.putString("name", receiveName);
              bundle2.putString("email",receiveEmail);
              bundle2.putString("username",receiveUsername);
              bundle2.putString("password",receivePassword);
              bundle2.putString("id",recevedId);

              Edit_Profile_Fragment edit_profile_fragment=new Edit_Profile_Fragment();
              edit_profile_fragment.setArguments(bundle2);
              getFragmentManager().beginTransaction().replace(R.id.navigation_drawer_frame_layout,edit_profile_fragment).commit();

          }
      });

        return  view;
    }

    public void showUserData(){
        profileName.setText(receiveName);
        profileEmail.setText(receiveEmail);
        profileUsername.setText(receiveUsername);
        profilePassword.setText(receivePassword);
    }
/*
    public void getDataFromDatabase(){
        String userUsername = profileUsername.getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                    String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    setDataOnTheBundleAndNavigateToEditProfileFragment(nameFromDB,emailFromDB,usernameFromDB,passwordFromDB);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
    public void setDataOnTheBundleAndNavigateToEditProfileFragment(String name , String email,String username , String password){
        Bundle bundle = new Bundle();
        bundle.putString("name", name);
        bundle.putString("email",email);
        bundle.putString("username",username);
        bundle.putString("password",password);
        Edit_Profile_Fragment edit_profile_fragment=new Edit_Profile_Fragment();
        edit_profile_fragment.setArguments(bundle);
        getFragmentManager().beginTransaction().replace(R.id.navigation_drawer_frame_layout,edit_profile_fragment).commit();

    }
*/


}