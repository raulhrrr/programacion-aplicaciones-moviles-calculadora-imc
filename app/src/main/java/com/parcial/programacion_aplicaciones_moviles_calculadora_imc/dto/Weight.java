package com.parcial.programacion_aplicaciones_moviles_calculadora_imc.dto;

import java.util.Arrays;
import java.util.List;

public enum Weight {

    UNDERWEIGHT("Estás bajo de peso", Arrays.asList("Aumenta la ingesta calórica", "Opta por alimentos nutritivos", "Incorpora proteínas", "Hidrátate adecuadamente")),

    NORMAL("Estás en un peso normal", Arrays.asList("Mantén una dieta equilibrada", "Ejercicio regular", "Controla las porciones", "Hidratación adecuada")),

    OVERWEIGHT("Estás con sobrepeso", Arrays.asList("Consulta a un profesional de la salud", "Ajusta tu dieta", "Ejercicio regular", "Establece metas realistas y sostenibles"));

    private final String message;
    private final List<String> tips;

    Weight(String message, List<String> tips) {
        this.message = message;
        this.tips = tips;
    }

    public String getMessage() {
        return this.message;
    }

    public List<String> getTips() {
        return this.tips;
    }

}
