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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp_Fragment extends Fragment {

    Button button_sign_in;
    Button button_sign_up;
    EditText signUpName;
    EditText signUpEmail;
    EditText signUpUsername;
    EditText signUpPassword;
    FirebaseDatabase database;
    DatabaseReference reference;
    String name;
    String email;
    String username;
    String password;
    FirebaseAuth mAuth;
    String uid;
    Intent intent;
    public SignUp_Fragment() {
        // Required empty public constructor
    }


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


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view=inflater.inflate(R.layout.fragment_sign_up, container, false);

        mAuth=FirebaseAuth.getInstance();

        button_sign_in = view.findViewById(R.id.button_sign_in_sign_up);
        button_sign_up = view.findViewById(R.id.button_sign_up);
        signUpName = view.findViewById(R.id.et_name_sign_up);
        signUpEmail  = view.findViewById(R.id.et_email_sign_up);
        signUpUsername = view.findViewById(R.id.et_username_sign_up);
        signUpPassword = view.findViewById(R.id.et_password_sign_up);


        button_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle=new Bundle();
                SignIn_Fragment signInFragment=new SignIn_Fragment();
                getFragmentManager().beginTransaction().replace(R.id.authentication_activity_frame_layout,signInFragment).commit();

            }
        });


        button_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String emailAuth;
                String passwordAuth;

                emailAuth=String.valueOf(signUpEmail.getText());
                passwordAuth=String.valueOf(signUpPassword.getText());

               // emailAuth=signUpEmail.getText().toString();
                //passwordAuth=signUpPassword.getText().toString();

                if(TextUtils.isEmpty(emailAuth)){
                    Toast.makeText(getContext(),"Enter email",Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(passwordAuth)){
                    Toast.makeText(getContext(),"Enter password",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(emailAuth, passwordAuth)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    FirebaseUser currentUser = mAuth.getCurrentUser();

                                    if (currentUser != null) {
                                        uid = currentUser.getUid();

                                        database = FirebaseDatabase.getInstance();
                                        reference=database.getReference("users");

                                        name = signUpName.getText().toString();
                                        email=signUpEmail.getText().toString();
                                        username=signUpUsername.getText().toString();
                                        password=signUpPassword.getText().toString();

                                        if(!name.isEmpty()){
                                            if(!email.isEmpty()){
                                                if(!username.isEmpty()){
                                                    if(!password.isEmpty()){

                                                        Authenticaton_HelperClass authenticaton_helperClass = new Authenticaton_HelperClass(name,username,uid);
                                                        reference.child(name).setValue(authenticaton_helperClass);
                                                        Toast.makeText(getContext(),"You have signed up sucessfully",Toast.LENGTH_SHORT).show();

                                                        intent = new Intent(getActivity(), NavigationDrawer_Activity.class);

                                                        intent.putExtra("name",name);
                                                        intent.putExtra("email",email);
                                                        intent.putExtra("username",username);
                                                        intent.putExtra("password",password);
                                                        intent.putExtra("id",uid);


                                                        Bundle bundle=new Bundle();

                                                        bundle.putString("name",name);
                                                        bundle.putString("email",email);
                                                        bundle.putString("username",username);
                                                        bundle.putString("password",password);
                                                        bundle.putString("id",uid);



                                                        SignIn_Fragment signInFragment=new SignIn_Fragment();
                                                        signInFragment.setArguments(bundle);

                                                        getFragmentManager().beginTransaction().replace(R.id.authentication_activity_frame_layout,signInFragment).commit();

                                                    }else{
                                                        signUpPassword.setError("Password can not be empty");
                                                    }
                                                }else{
                                                    signUpUsername.setError("Username can not be empty");
                                                }
                                            }else{
                                                signUpEmail.setError("Email can not be empty");
                                            }
                                        }else{
                                            signUpName.setError("Name can not be empty");
                                        }

                                        // Use uid as needed, for example, to access the user's data in Firebase Realtime Database or Firestore
                                        Toast.makeText(getContext(), "UserID :" + uid,
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        // User is not signed in
                                        Toast.makeText(getContext(), "No use id found.",
                                                Toast.LENGTH_SHORT).show();
                                    }

                                    Toast.makeText(getContext(), "Account created.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(getContext(), "Sign up failed. Ensure that your pssword length is at least 6 digits with at leas one upper case an special character such as !@#$%^&*",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });










/*
                Bundle bundle=new Bundle();
                SignIn_Fragment signInFragment=new SignIn_Fragment();
                getFragmentManager().beginTransaction().replace(R.id.authentication_activity_frame_layout,signInFragment).commit();
*/
            }
        });

        return view;

    }
}