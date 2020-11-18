package com.example.jobhunting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class ActivityLogin extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private CircularProgressButton mLoginBtn;
    private EditText mEmail, mPassword;
    private TextView mGotoReg, mForgotPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M){
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        //Get Instance Authenticate
        mAuth = FirebaseAuth.getInstance();

        //Reference to id layout login
        mEmail = (EditText) findViewById(R.id.editTextEmail);
        mPassword = (EditText) findViewById(R.id.editTextPassword);
        mLoginBtn = (CircularProgressButton) findViewById(R.id.cirLoginButton);
        mGotoReg = (TextView) findViewById(R.id.gotoRegister);
        mForgotPwd = (TextView) findViewById(R.id.forgotPwd);
        mForgotPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mGotoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityLogin.this, ActivityRegister.class);
                startActivity(intent);
            }
        });

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate(mEmail.getText().toString(), mPassword.getText().toString())){
                    mLoginBtn.startAnimation();
                    loginWithAuth(mAuth, mEmail.getText().toString(), mPassword.getText().toString());
                }else{
                    Toast.makeText(ActivityLogin.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginWithAuth(FirebaseAuth mAuth, String email, String pwd){
        mAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(ActivityLogin.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Bitmap myLogo = ((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.w3c_home, null)).getBitmap();
                    mLoginBtn.doneLoadingAnimation(R.color.themeColor, myLogo);
                    Toast.makeText(ActivityLogin.this, "Logged in successful !", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                    overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
                    startActivity(intent);
                } else {
                    Toast.makeText(ActivityLogin.this, "Logging process error !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidate(String email, String pwd){
        if(isValidEmail(email) && isValidPassword(pwd)){
            return true;
        }else{
            Toast.makeText(ActivityLogin.this, "Wrong email or password", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
    }
}