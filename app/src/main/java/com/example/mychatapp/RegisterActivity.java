package com.example.mychatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText name;
    EditText mail;
    EditText pass;
    EditText number;
    Button btn;
    FirebaseAuth mAuth;
    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance ();
    DatabaseReference reference = mDatabase.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.nameET);
        mail = findViewById(R.id.mailET);
        pass = findViewById(R.id.passET);
        number = findViewById(R.id.phoneET);
        btn = findViewById(R.id.registerbtn);

        mAuth = FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_name = name.getText().toString();
                String txt_mail = mail.getText().toString();
                String txt_pass = pass.getText().toString();
                String txt_number = number.getText().toString();

                if(TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_mail) || TextUtils.isEmpty(txt_pass) || TextUtils.isEmpty(txt_number)){
                    Toast.makeText(RegisterActivity.this, "All informations are required", Toast.LENGTH_LONG).show();
                } else if (txt_pass.length() < 6) {
                    Toast.makeText(RegisterActivity.this, "Password length has to be longer than 6 chars", Toast.LENGTH_LONG).show();
                } else {
                    register(txt_mail,txt_pass, txt_name, txt_number);
                }
            }
        });
    }
    private void register(final String mail, String pass, final String name, final String number){
         mAuth.createUserWithEmailAndPassword(mail, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = mAuth.getCurrentUser();
                            assert firebaseUser != null;
                            String userid = firebaseUser.getUid();

                            reference = mDatabase.getReference("Users").child(userid);
                            HashMap<String, String> hashMap = new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("name", name);
                            hashMap.put("number", number);

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                   if(task.isSuccessful()){
                                       Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                       intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                       startActivity(intent);
                                       finish();
                                   }
                                }
                            });
                        }
                        else {
                            Toast.makeText(RegisterActivity.this, "Wrong authentification data", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

}
