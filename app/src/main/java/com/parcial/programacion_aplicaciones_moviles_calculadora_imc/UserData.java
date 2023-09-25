package com.parcial.programacion_aplicaciones_moviles_calculadora_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.Gender;
import com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.User;

public class UserData extends AppCompatActivity {

    private Spinner genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);

        genderSpinner = findViewById(R.id.gender);
        genderSpinner.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Gender.values()));

        Button btnCalculate = findViewById(R.id.calculate);
        btnCalculate.setOnClickListener(this::showCalculationResult);
    }

    protected void showCalculationResult(View view) {
        Intent intent = new Intent(getApplicationContext(), CalculationResult.class);

        TextView name = findViewById(R.id.name);
        TextView age = findViewById(R.id.age);
        TextView weight = findViewById(R.id.weight);
        TextView height = findViewById(R.id.height);

        User user = new User();
        user.setName(name.getText().toString());
        user.setAge(Integer.valueOf(age.getText().toString()));
        user.setWeight(Float.valueOf(weight.getText().toString()));
        user.setHeight(Float.parseFloat(height.getText().toString()) / 100);
        user.setGender((Gender) genderSpinner.getSelectedItem());

        intent.putExtra("user", user);
        startActivity(intent);
    }

}