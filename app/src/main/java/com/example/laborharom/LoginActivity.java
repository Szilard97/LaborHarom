package com.example.laborharom;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {

    private Users users;
    private Button buttonLogin;
    private Button pickUpButton;
    private TextView namePlaneText;
    private TextView emailPlaneText;
    private TextView burthDate;
    private TextView passwordPlanetext;
    private Integer year;
    private Integer mouth;
    private Integer dayOfMounth;
    private Calendar calendar;
    private DatePickerDialog datePickerDialog;
    private CheckBox checkBox;
    public static final String  SHARED_PREF = "sharedPrefs";
    public static final String switch1 = "switch1";
    private Button hobbyButton;
    private String name, email, password, burthDate1;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        declaration();
        onClickListener();

    }



    private void declaration() {
        buttonLogin = findViewById(R.id.buttonLoginLogin);
        pickUpButton = findViewById(R.id.buttonPickDate);
        namePlaneText = findViewById(R.id.editTextNameLogin);
        emailPlaneText = findViewById(R.id.editTextEmailLogin);
        burthDate = findViewById(R.id.textViewDate);
        passwordPlanetext = findViewById(R.id.editTextPasswordLogin);
        checkBox = findViewById(R.id.checkBoxRememberMe);
        hobbyButton = findViewById(R.id.Hobby);

    }

    private void onClickListener() {

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!namePlaneText.getText().toString().isEmpty()){

                }else{
                    Toast.makeText(getApplicationContext(), "Please insert your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!emailPlaneText.getText().toString().isEmpty()){

                }else{
                    Toast.makeText(getApplicationContext(), "Please insert your email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!passwordPlanetext.getText().toString().isEmpty()){

                }else{
                    Toast.makeText(getApplicationContext(), "Please insert your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!burthDate.getText().toString().isEmpty()){

                    startActivityForResult(new Intent(LoginActivity.this, ProfileActivity.class), 0);

                }else{
                    Toast.makeText(getApplicationContext(), "Please insert burth date", Toast.LENGTH_SHORT).show();
                    return;

                }
                if(checkBox.isChecked()){

                    putDataString();
                    Toast.makeText(getApplicationContext(), "Saved!", Toast.LENGTH_SHORT).show();

                }else
                    Toast.makeText(getApplicationContext(), "Not saved", Toast.LENGTH_SHORT).show();
            }

        });

        pickUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            calendar = Calendar.getInstance();
            year = calendar.get(Calendar.YEAR);
            mouth = calendar.get(Calendar.MONTH);
            dayOfMounth = calendar.get(Calendar.DAY_OF_MONTH);
            datePickerDialog = new DatePickerDialog(LoginActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                    burthDate.setText(dayOfMonth+ "/" + month + "/"+ year);
                }
            }, year, mouth, dayOfMounth);
            datePickerDialog.show();
            }
        });

        loadData();

        hobbyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AddNewHobby.class));
            }
        });

    }

    private void putDataString() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor  editor = sharedPreferences.edit();
        editor.putString("name", namePlaneText.getText().toString());
        editor.putString("email", emailPlaneText.getText().toString());
        editor.putString("password", passwordPlanetext.getText().toString());
        editor.putString("burthDate", burthDate.getText().toString());
        editor.putBoolean(switch1, checkBox.isChecked());
        editor.apply();
    }

    public void loadData(){

        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        name = sharedPreferences.getString("name", "");
        email = sharedPreferences.getString("email", "");
        password = sharedPreferences.getString("password", "");
        burthDate1 = sharedPreferences.getString("burthDate", "");

        if(name != "" && email != "" && password != "" && burthDate1 != ""){
            namePlaneText.setText(name);
            emailPlaneText.setText(email);
            passwordPlanetext.setText(password);
            burthDate.setText(burthDate1);
        }

    }
}



