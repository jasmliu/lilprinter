package com.example.jl.lilprinter.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jl.lilprinter.R;

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

                String username = "";
                if (usernameEdit.getText() != null) {
                    username = usernameEdit.getText().toString();
                }
                if (username.length() > 11) {
                    if (username.substring(username.length() - 11, username.length()).equals("@gatech.edu")) {
                        isLoggedIn = true;

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
