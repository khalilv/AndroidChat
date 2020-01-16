package com.example.androidchat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import tech.gusavila92.websocketclient.WebSocketClient;


public class Login extends AppCompatActivity {


    String username, password;

    EditText usernameInput;
    EditText passwordInput;

    Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //display login page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //get username and password input from user
        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);

        //when login button is pressed get username and password
        loginButton = (Button) findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = usernameInput.getText().toString();
                password = passwordInput.getText().toString();

                //put username in a bundle and sent to chat screen class
                Intent myIntent = new Intent(v.getContext(), ChatScreen.class);
                Bundle bundle = new Bundle();
                bundle.putString("user",username);
                myIntent.putExtras(bundle);
                startActivity(myIntent);
            }
        });
    }
}