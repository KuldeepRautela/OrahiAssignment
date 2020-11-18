package com.example.orahiassignment.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.orahiassignment.R;
import com.example.orahiassignment.utils.constants.Constants;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText phoneNoEditText, otpEditText;
    private TextInputLayout phoneNoTextInputLayout, otpTextInputLayout;
    private String otp,phoneNo;
    private Button resendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneNoEditText = findViewById(R.id.id_phoneNo);
        otpEditText = findViewById(R.id.id_otp);
        phoneNoTextInputLayout = findViewById(R.id.id_phoneNoTextInputLayout);
        otpTextInputLayout = findViewById(R.id.id_otpTextInputLayout);
        resendButton = findViewById(R.id.id_buttonResend);
    }

    public void buttonClick(View view) {
        Button button = (Button) view;
        if(view.getId()==R.id.id_buttonResend){
            createOtp();
            view.setVisibility(View.GONE);
            return;
        }
        if (button.getText().toString().equalsIgnoreCase("GET OTP")) {
             phoneNo = phoneNoEditText.getText().toString();
            if (!phoneNo.isEmpty()) {
                if (phoneNo.length() == 10) {
                    createOtp();
                    otpTextInputLayout.setAlpha(1.0f);
                    otpEditText.setEnabled(true);
                    button.setText("Verify");
                    phoneNoEditText.setEnabled(false);
                } else
                    phoneNoTextInputLayout.setError("The phone no should be 10 digit long ");
            } else {
                phoneNoTextInputLayout.setError("Field can not be empty ");
            }
        } else {
            String otpText = otpEditText.getText().toString();
            if (!otpText.isEmpty()) {
                if (otpText.length() == 4) {
                    if (otpText.equals(otp))
                    {
                  startActivity(new Intent(this,HomeActivity.class));
                    }
                    else {
                        showToast("Incorrect otp ");
                        resendButton.setVisibility(View.VISIBLE);
                    }
                } else
                    otpTextInputLayout.setError("otp should be 4 digit long ");
            } else
                otpTextInputLayout.setError("Otp can not be empty ");
        }
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    private void createOtp() {
        otp = phoneNo.substring(3, 7);
        showToast("Otp is " + otp);
    }
}
