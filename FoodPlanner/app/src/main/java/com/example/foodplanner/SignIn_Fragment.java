package com.example.foodplanner;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignIn_Fragment extends Fragment {

    Button button_back;
    Button button_sign_in;
    EditText emailSignIn;
    EditText passwordSignIn;
    Authentication_Activity authenticationActivity;
    Main_Activity mainActivity;
    FirebaseAuth mAuth;
    Intent intent;
    String namePassing , emailPassing , usernamePassing, passwordPassing , idPassing;
    String receivedName, receivedEmail , receivedUsername , receivedPassword , receivedId;

    Boolean isSignedIn=false;

    public SignIn_Fragment() {
        // Required empty public constructor
    }

    public SignIn_Fragment(String name,String email,String username, String password, String id){
        namePassing=name;
        emailPassing=email;
        usernamePassing=username;
        passwordPassing=password;
        idPassing=id;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

/*
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(getActivity(), NavigationDrawer_Activity.class);
            startActivity(intent);
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_in, container, false);
        button_sign_in=view.findViewById(R.id.button_sign_in_sign_in);

        mAuth = FirebaseAuth.getInstance();

       emailSignIn = view.findViewById(R.id.et_email_sign_in);
       passwordSignIn = view.findViewById(R.id.et_password_sign_in);
       button_back =view.findViewById(R.id.button_back_sign_in);

       authenticationActivity=(Authentication_Activity) getActivity();

       button_back.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Bundle bundle=new Bundle();
               SignUp_Fragment signUpFragment=new SignUp_Fragment();
               getFragmentManager().beginTransaction().replace(R.id.authentication_activity_frame_layout,signUpFragment).commit();
           }
       });

       button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailAuth;
                String passwordAuth;

                emailAuth=String.valueOf(emailSignIn.getText());
                passwordAuth=String.valueOf(passwordSignIn.getText());

                if(TextUtils.isEmpty(emailAuth)){
                    Toast.makeText(getContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(passwordAuth)){
                    Toast.makeText(getContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(emailAuth, passwordAuth)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    intent = new Intent(getActivity(), NavigationDrawer_Activity.class);
                                    startActivity(intent);

                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(getContext(), "Sign in succeded.",
                                            Toast.LENGTH_SHORT).show();
                                    isSignedIn=true;

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getContext(), "Sign in failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });




                        if(isSignedIn==true){
                            Bundle bundleSignIn = getArguments();
                            if (bundleSignIn != null) {
                                receivedName = bundleSignIn.getString("name");
                                receivedEmail = bundleSignIn.getString("email");
                                receivedUsername=bundleSignIn.getString("username");
                                receivedPassword = bundleSignIn.getString("password");
                                receivedId = bundleSignIn.getString("id");
                                // Use the value here

                                intent.putExtra("name",receivedName);
                                intent.putExtra("email",receivedEmail);
                                intent.putExtra("username",receivedUsername);
                                intent.putExtra("password",receivedPassword);
                                intent.putExtra("id",receivedId);


                            }else{
                                Toast.makeText(getContext(), "SignIn bundle is null.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(getContext(), "isSigned in boolean is false",
                                    Toast.LENGTH_SHORT).show();
                        }










             /*
                if(!validateUsername() | !validatePasword()){

                }else{
                    checkUser();
                }

            */
              //  Intent intent = new Intent(getActivity(), NavigationDrawer_Activity.class);
              //  startActivity(intent);
            }
        });

        return view;
    }
/*
    public boolean validateUsername(){
        String val = username.getText().toString();
        if(val.isEmpty()){
            username.setError("Username cannot be empty");
            return false;
        }else{
            username.setError(null);
            return true;
        }
    }

    public boolean validatePasword(){
        String val = password.getText().toString();
        if(val.isEmpty()){
            password.setError("Password cannot be empty");
            return false;
        }else{
            password.setError(null);
            return true;
        }
    }

    */
    /*
    public void checkUser(){
        String username_checkUser = username.getText().toString().trim();
        String password_checkUser = password.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(username_checkUser);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    username.setError(null);
                    String passwordFromDB  = snapshot.child(username_checkUser).child("password").getValue(String.class);


                    if(passwordFromDB.equals(password_checkUser)){
                        username.setError(null);

                        //Pass data using intent
                        String nameFromDB = snapshot.child(username_checkUser).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(username_checkUser).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(username_checkUser).child("username").getValue(String.class);

                        /*
                        Bundle bundle=new Bundle();
                        bundle.putString("name",nameFromDB);
                        bundle.putString("email",emailFromDB);
                        bundle.putString("username",usernameFromDB);
                        bundle.putString("password",passwordFromDB);

                        Profile_Fragment profileFragment=new Profile_Fragment();
                        profileFragment.setArguments(bundle);
                        */

/*
                        Intent intent = new Intent(getActivity(), NavigationDrawer_Activity.class);

                        intent.putExtra("name",nameFromDB);
                        intent.putExtra("email",emailFromDB);
                        intent.putExtra("username",usernameFromDB);
                        intent.putExtra("password",passwordFromDB);

                        startActivity(intent);
                    } else {
                        password.setError("Invalid Credetials");
                    }

                }else{
                    username.setError("User doesn't exist");
                    username.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

*/

}

