package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jl.lilprinter.R;
import com.example.jl.lilprinter.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import static com.example.jl.lilprinter.model.User.database;
import static com.example.jl.lilprinter.model.User.myRef;

public class LoginActivity extends AppCompatActivity {
    private boolean isLoggedIn = false;
    public static final String MESSAGE = "ISLOGGEDIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = (Button) findViewById(R.id.btn_logLogin);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEdit = (EditText) findViewById(R.id.editTxt_logUsername);
                EditText passwordEdit = (EditText) findViewById(R.id.editTxt_logPassword);

                String username = "";
                String password = "";


                if (usernameEdit.getText() != null) {
                    username = usernameEdit.getText().toString();
                }
                if (passwordEdit.getText() != null) {
                    password = passwordEdit.getText().toString();
                }
                if (username.length() > 11) {
                    if (username.substring(username.length() - 11, username.length()).equals("@gatech.edu")) {
                        final String user = username.substring(0, username.length()-11);
                        isLoggedIn = true;

                        DatabaseReference userInfo = myRef.child("123").child("email");

                        userInfo.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String email = dataSnapshot.getValue(String.class);
                                if (email.equals(username));
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {


                            }
                        });
                        Intent intent = new Intent(v.getContext(), MapsActivity.class);
                        intent.putExtra(MESSAGE, isLoggedIn);
                        startActivity(intent);
                    }
                } else {
                    Toast toast = Toast.makeText(v.getContext(),
                            "username ", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }
}
