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
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.type.DateTime;

import java.time.Instant;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;
import br.com.simplepass.loading_button_lib.customViews.CircularProgressEditText;

public class ActivityRegister extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private CircularProgressButton mRegisterBtn;
    private TextInputLayout mName, mMobileNumber, mEmail, mPassword;
    private TextView mGotoLog;
    private FirebaseFirestore userDb;
    private static final String DB_NAME = "users";
    private static final String TAG = "DocSnippets";
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        changeStatusBarColor();

        //Get Instance Authenticate
        mAuth = FirebaseAuth.getInstance();
        userId = mAuth.getCurrentUser().getUid();
        userDb = FirebaseFirestore.getInstance();

        //Reference to id layout register
        mRegisterBtn = (CircularProgressButton) findViewById(R.id.cirRegisterButton);
        mName = (TextInputLayout) findViewById(R.id.textInputName);
        mMobileNumber = (TextInputLayout) findViewById(R.id.textInputMobile);
        mEmail = (TextInputLayout) findViewById(R.id.textInputEmail);
        mPassword = (TextInputLayout) findViewById(R.id.textInputPassword);
        mGotoLog = (TextView) findViewById(R.id.gotoLog);

        mGotoLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityRegister.this, ActivityLogin.class);
                startActivity(intent);
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidate(mName.getEditText().getText().toString(), mMobileNumber.getEditText().getText().toString(), mEmail.getEditText().getText().toString(), mPassword.getEditText().getText().toString())){
                    mRegisterBtn.startAnimation();
                    registerUser(userDb, mAuth, userId, mName.getEditText().getText().toString(), mMobileNumber.getEditText().getText().toString(), mEmail.getEditText().getText().toString(), mPassword.getEditText().getText().toString());
                }else{
                    Toast.makeText(ActivityRegister.this, "Inputted data have problems", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.register_bk_color));
        }
    }

    private boolean isValidate(String name, String mobile, String email, String pwd){
        if(!isValidName(name)){
            Toast.makeText(ActivityRegister.this, "Name empty !", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidMobile(mobile)){
            Toast.makeText(ActivityRegister.this, "Mobile empty !", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidEmail(email)){
            Toast.makeText(ActivityRegister.this, "Wrong email !", Toast.LENGTH_LONG).show();
            return false;
        }else if(!isValidPassword(pwd)){
            Toast.makeText(ActivityRegister.this, "Wrong password !", Toast.LENGTH_LONG).show();
            return false;
        }else{
            return true;
        }
    }

    public static boolean isValidName(CharSequence target) {
        return (!TextUtils.isEmpty(target));
    }

    public static boolean isValidMobile(CharSequence target) {
        return (!TextUtils.isEmpty(target));
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        return !TextUtils.isEmpty(s) && PASSWORD_PATTERN.matcher(s).matches();
    }

    private void registerUser(FirebaseFirestore userDb, FirebaseAuth mAuth, String userId, String name, String mobile, String email, String pwd){
        mAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(ActivityRegister.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Bitmap myLogo = ((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.w3c_home, null)).getBitmap();
                    mRegisterBtn.doneLoadingAnimation(R.color.themeColor, myLogo);
                    createUserDocument(userDb, userId, name, mobile, email, pwd);
                    Toast.makeText(ActivityRegister.this, "User created !", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ActivityRegister.this, MainActivity.class);
                    overridePendingTransition(R.anim.slide_in_left,android.R.anim.slide_out_right);
                    startActivity(intent);
                }else{
                    Toast.makeText(ActivityRegister.this, "Registering process error !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void createUserDocument(FirebaseFirestore userDb, String userId, String name, String mobile, String email, String pwd){
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        user.put("name", name);
        user.put("mobile", mobile);
        user.put("email", email);
        user.put("password", pwd);
        user.put("created_at", Calendar.getInstance().getTime());

        userDb.collection(DB_NAME).document(userId).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Log.d(TAG, "DocumentSnapshot successfully written !");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error writing document !", e);
            }
        });
    }
}