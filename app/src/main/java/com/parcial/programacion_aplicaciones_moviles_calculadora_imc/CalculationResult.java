package com.parcial.programacion_aplicaciones_moviles_calculadora_imc;

import static com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.Weight.NORMAL;
import static com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.Weight.OVERWEIGHT;
import static com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.Weight.UNDERWEIGHT;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.User;
import com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto.Weight;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class CalculationResult extends AppCompatActivity {

    Map<Weight, Consumer<ImageView>> imageMap = new EnumMap<>(Weight.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculation_result);

        imageMap.put(UNDERWEIGHT, image -> image.setImageResource(R.drawable.under));
        imageMap.put(NORMAL, image -> image.setImageResource(R.drawable.normal));
        imageMap.put(OVERWEIGHT, image -> image.setImageResource(R.drawable.over));

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");

        float imc = Objects.requireNonNull(user).getWeight() / (user.getHeight() * user.getHeight());

        Weight userWeight;
        if (imc <= 18.5) {
            userWeight = UNDERWEIGHT;
        } else if (imc <= 25.0) {
            userWeight = Weight.NORMAL;
        } else {
            userWeight = Weight.OVERWEIGHT;
        }

        TextView result = findViewById(R.id.result);
        result.setText(String.valueOf(imc));

        TextView message = findViewById(R.id.message);
        message.setText(String.format("Hola, %s. %s", user.getName(), userWeight.getMessage()));

        TextView tip1 = findViewById(R.id.tip1);
        tip1.setText(userWeight.getTips().get(0));

        TextView tip2 = findViewById(R.id.tip2);
        tip2.setText(userWeight.getTips().get(1));

        TextView tip3 = findViewById(R.id.tip3);
        tip3.setText(userWeight.getTips().get(2));

        TextView tip4 = findViewById(R.id.tip4);
        tip4.setText(userWeight.getTips().get(3));

        ImageView image = findViewById(R.id.image);
        imageMap.get(userWeight).accept(image);

    }
}