package com.ngothanhtuan.managerstack.view;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.ngothanhtuan.managerstack.R;

public class SignUpActivity extends AppCompatActivity {

    EditText edtMail,edtPassAgain,edtPass;
    Button btnBack,btnSignUp;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        addControls();
        addEvents();
    }

    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtMail.length() == 0){
                    Toast.makeText(SignUpActivity.this, "Email not null!!!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (edtPass.length() == 0)
                    {
                        Toast.makeText(SignUpActivity.this, "Pass not null!!", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if (edtPass.getText().toString().equals(edtPassAgain.getText().toString())){
                            mAuth.createUserWithEmailAndPassword(edtMail.getText().toString(),edtPass.getText().toString())
                                    .addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (task.isSuccessful())
                                            {
                                                Toast.makeText(SignUpActivity.this, "SignUp complete!!!", Toast.LENGTH_SHORT).show();
                                            }
                                            else {
                                                Toast.makeText(SignUpActivity.this, "SignUp Fail!!!", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                        else {
                            Toast.makeText(SignUpActivity.this, "Pass again not true!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

    }

    private void addControls() {
        edtMail = (EditText) findViewById(R.id.edtMail);
        edtPass = (EditText) findViewById(R.id.edtPass);
        edtPassAgain = (EditText) findViewById(R.id.edtPassAgain);

        btnBack = (Button) findViewById(R.id.btnBack);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        mAuth = FirebaseAuth.getInstance();
    }
}
