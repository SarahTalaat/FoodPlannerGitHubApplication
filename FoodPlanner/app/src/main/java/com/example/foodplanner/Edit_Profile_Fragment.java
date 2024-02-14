package com.example.foodplanner;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Edit_Profile_Fragment extends Fragment {


    EditText editName , editUsername,editPassword;
    Button saveButton;
    String nameUser , emailUser , usernameUser,passwordUser, idUser;
    DatabaseReference reference;
    Bundle bundle;
    public static final String TAG = "Edit_Profile_Fragment";

    public Edit_Profile_Fragment() {
        // Required empty public constructor
    }


    public Edit_Profile_Fragment(String name, String email , String username,String password,String id) {
        nameUser=name;
        emailUser=email;
        usernameUser=username;
        passwordUser=password;
        idUser=id;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_edit_profile, container, false);

       reference = FirebaseDatabase.getInstance().getReference("users");

       editName = view.findViewById(R.id.et_name_edit_profile);
       editUsername = view.findViewById(R.id.et_username_edit_profile);
       editPassword = view.findViewById(R.id.et_password_edit_profile);
       saveButton = view.findViewById(R.id.button_save_edit_profile);

       getDataFromBundle();


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean isNameChangedBoolean = isNameChanged();
                Boolean isUserameChangedBoolean = isUsernameChanged();
                Boolean isPasswordChangdBoolean = isPasswordChanged();

                if(isNameChangedBoolean || isUserameChangedBoolean || isPasswordChangdBoolean){
                    Toast.makeText(getContext(),"Saved",Toast.LENGTH_SHORT).show();
                    bundle.putString("name",nameUser);
                    bundle.putString("username",usernameUser);
                    bundle.putString("password",passwordUser);
                    Profile_Fragment profile_fragment=new Profile_Fragment(nameUser,emailUser,usernameUser,passwordUser,idUser);
                    profile_fragment.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.navigation_drawer_frame_layout,profile_fragment).commit();

                }else{
                    Toast.makeText(getContext(),"No changes happened",Toast.LENGTH_SHORT).show();

                }
            }
        });

        return  view;

    }

    public boolean isNameChanged(){

        if(!nameUser.equals(editName.getText().toString())){
            reference.child(usernameUser).child("name").setValue(editName.getText().toString());
            nameUser=editName.getText().toString();
            return true;
        }else{
            return false;
        }
    }

    public boolean isUsernameChanged(){

        if(!usernameUser.equals(editUsername.getText().toString())){
            reference.child(usernameUser).child("username").setValue(editUsername.getText().toString());
            usernameUser=editUsername.getText().toString();
            return true;
        }else{
            return false;
        }
    }

    public boolean isPasswordChanged(){

        if(!passwordUser.equals(editPassword.getText().toString())){

            FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();

            if (user != null) {
                String newPassword =editPassword.getText().toString();

                user.updatePassword(newPassword)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Log.d(TAG, "Password updated successfully");
                                } else {
                                    Log.d(TAG, "Password update failed: " + task.getException().getMessage());
                                }
                            }
                        });
            } else {
                // User is not logged in or has been signed out
            }

            passwordUser=editPassword.getText().toString();
            return true;
        }else{
            return false;
        }
    }

    public void getDataFromBundle(){
        bundle = this.getArguments();
        nameUser = bundle.getString("name");
        emailUser = bundle.getString("email");
        usernameUser = bundle.getString("username");
        passwordUser = bundle.getString("password");
        idUser=bundle.getString("id");
    }


}