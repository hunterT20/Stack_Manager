package com.ngothanhtuan.managerstack.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ngothanhtuan.managerstack.R;

public class LoginActivity extends AppCompatActivity {

    TextView txtvSignUp;
    EditText edtEmail, edtPass;
    Button btnLogin;
    FirebaseAuth mAuth;

    ProgressBar probar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControls();
        addEvents();
    }

    private void addEvents() {

        txtvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                probar.setVisibility(ProgressBar.VISIBLE);
                mAuth.signInWithEmailAndPassword(edtEmail.getText().toString(), edtPass.getText().toString())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    probar.setVisibility(ProgressBar.INVISIBLE);
                                    Intent intent = new Intent(LoginActivity.this, ProjectActivity.class);
                                    startActivity(intent);
                                } else {
                                    probar.setVisibility(ProgressBar.INVISIBLE);
                                    Toast.makeText(LoginActivity.this, "Email or Pass incorrect!!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }

    private void addControls() {
        txtvSignUp = (TextView) findViewById(R.id.txtvSignUp);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        mAuth = FirebaseAuth.getInstance();

        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPass = (EditText) findViewById(R.id.edtPass);
        probar = (ProgressBar) findViewById(R.id.probar);
    }
}

