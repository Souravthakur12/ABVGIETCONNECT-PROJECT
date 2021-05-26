package institute.college.abvgietconnect.StudentZone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import institute.college.abvgietconnect.R;


public class ForgetPassword extends AppCompatActivity {

    EditText email;
    Button button;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        ConstraintLayout constraintLayout = findViewById(R.id.layout_fp);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();


        email = findViewById(R.id.FP_EmailAddress);
        button = findViewById(R.id.FP_Send_Button);


        auth = FirebaseAuth.getInstance();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fpemail = email.getText().toString().trim();

                if (TextUtils.isEmpty(fpemail)){
                    Toast.makeText(ForgetPassword.this,"Please enter your email",Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.sendPasswordResetEmail(fpemail).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(ForgetPassword.this,"Reset Link Sent To Your Email",Toast.LENGTH_SHORT).show();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(ForgetPassword.this,"Error! Reset Link is Not Sent" +e.getMessage(),Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });


    }
}