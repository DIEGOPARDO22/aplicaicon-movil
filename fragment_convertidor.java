package com.example.drawer_completo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.drawer_completo.R;

import java.util.HashMap;
import java.util.Map;

public class fragment_convertidor extends Fragment  implements AdapterView.OnItemClickListener{

    private EditText text;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.conversion_monedas, container, false);
        primerMontoEditText = view.findViewById(R.id.primerMontoEditText);
        resultTextView = view.findViewById(R.id.resultTextView);
        mySpinner1 = view.findViewById(R.id.my_spinner1);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getContext(),
                R.array.opciones_spinner, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(adapter1);

        mySpinner2 = view.findViewById(R.id.my_spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),
                R.array.opciones_spinner, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(adapter2);


        exchangeRates = new HashMap<>();
        exchangeRates.put("€ Euro", 0.84);
        exchangeRates.put("£ Libra", 0.72);
        exchangeRates.put("₹ Rupia", 74.41);
        exchangeRates.put("R$ Real", 5.38);
        exchangeRates.put("$ Peso", 22.05);
        exchangeRates.put("¥ Yuan", 6.47);
        exchangeRates.put("¥ Yen", 109.82);
        exchangeRates.put("$ Dolar", 1.0);
        exchangeRates.put("S/ Soles", 3.97);
        return view;
    }

    private EditText primerMontoEditText;
    private TextView resultTextView;
    private Spinner mySpinner1, mySpinner2;
    private Map<String, Double> exchangeRates;

    private double convert(double amount, String currency1, String currency2) {
        double rate1 = exchangeRates.get(currency1);
        double rate2 = exchangeRates.get(currency2);
        return (amount / rate1) * rate2;
    }

    public void convert(@NonNull View view) {
        // Obtener el monto a convertir
        EditText montoEditText = view.findViewById(R.id.primerMontoEditText);
        String montoString = montoEditText.getText().toString();
        double monto = Double.parseDouble(montoString);

        // Obtener las opciones seleccionadas en los spinners
        Spinner spinner1 = view.findViewById(R.id.my_spinner1);
        String opcion1 = spinner1.getSelectedItem().toString();
        Spinner spinner2 = view.findViewById(R.id.my_spinner2);
        String opcion2 = spinner2.getSelectedItem().toString();

        // Realizar la conversión adecuada según las opciones seleccionadas
        double resultado = 0.0;
            switch (opcion1) {
                case "Euro":
                    switch (opcion2) {
                        case "Euro":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.86;
                            break;
                        case "Rupia":
                            resultado = monto * 80.97;
                            break;
                        case "Real":
                            resultado = monto * 4.77;
                            break;
                        case "Peso":
                            resultado = monto * 22.50;
                            break;
                        case "Yuan":
                            resultado = monto * 7.76;
                            break;
                        case "Yen":
                            resultado = monto * 130.21;
                            break;
                        case "Dolar":
                            resultado = monto * 1.18;
                            break;
                        case "Soles":
                            resultado = monto * 4.16;
                            break;
                    }
                    break;
                case "Libra":
                    switch (opcion2) {
                        case "Libra":
                            resultado = monto;
                            break;
                        case "Euro":
                            resultado = monto / 0.86;
                            break;
                        case "Rupia":
                            resultado = monto * 94.23;
                            break;
                        case "Real":
                            resultado = monto * 5.32;
                            break;
                        case "Peso":
                            resultado = monto * 25.07;
                            break;
                        case "Yuan":
                            resultado = monto * 8.63;
                            break;
                        case "Yen":
                            resultado = monto * 144.66;
                            break;
                        case "Dolar":
                            resultado = monto * 1.31;
                            break;
                        case "Soles":
                            resultado = monto * 4.63;
                            break;
                    }
                    break;
                case "Rupia":
                    switch (opcion2) {
                        case "Rupia":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto / 94.23;
                            break;
                        case "Euro":
                            resultado = monto / 80.97;
                            break;
                        case "Real":
                            resultado = monto / 15.20;
                            break;
                        case "Peso":
                            resultado = monto / 3.20;
                            break;
                        case "Yuan":
                            resultado = monto / 11.03;
                            break;
                        case "Yen":
                            resultado = monto / 1.45;
                            break;
                        case "Dolar":
                            resultado = monto / 74.98;
                            break;
                        case "Soles":
                            resultado = monto / 20.32;
                            break;
                    }
                    break;
                case "Real":
                    switch (opcion2) {
                        case "Real":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.012;
                            break;
                        case "Euro":
                            resultado = monto * 0.0124;
                            break;
                        case "Rupia":
                            resultado = monto * 2.07;
                            break;
                        case "Peso":
                            resultado = monto * 5.10;
                            break;
                        case "Yuan":
                            resultado = monto * 0.847;
                            break;
                        case "Yen":
                            resultado = monto * 1.72;
                            break;
                        case "Dolar":
                            resultado = monto * 0.133;
                            break;
                        case "Soles":
                            resultado = monto * 0.43;
                            break;
                    }
                    break;
                case "Peso":
                    switch (opcion2) {
                        case "Peso":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.012;
                            break;
                        case "Euro":
                            resultado = monto * 0.013;
                            break;
                        case "Rupia":
                            resultado = monto * 2.23;
                            break;
                        case "Real":
                            resultado = monto * 5.07;
                            break;
                        case "Yuan":
                            resultado = monto * 0.82;
                            break;
                        case "Yen":
                            resultado = monto * 1.81;
                            break;
                        case "Dolar":
                            resultado = monto * 0.015;
                            break;
                        case "Soles":
                            resultado = monto * 0.48;
                            break;
                    }
                    break;
                case "Yuan":
                    switch (opcion2) {
                        case "Yuan":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.012;
                            break;
                        case "Euro":
                            resultado = monto * 0.11;
                            break;
                        case "Rupia":
                            resultado = monto * 17.87;
                            break;
                        case "Real":
                            resultado = monto * 4.67;
                            break;
                        case "Peso":
                            resultado = monto * 0.62;
                            break;
                        case "Yen":
                            resultado = monto * 14.15;
                            break;
                        case "Dolar":
                            resultado = monto * 0.091;
                            break;
                        case "Soles":
                            resultado = monto * 0.29;
                            break;
                    }
                    break;
                case "Yen":
                    switch (opcion2) {
                        case "Yen":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.012;
                            break;
                        case "Euro":
                            resultado = monto * 0.11;
                            break;
                        case "Rupia":
                            resultado = monto * 17.87;
                            break;
                        case "Real":
                            resultado = monto * 4.67;
                            break;
                        case "Peso":
                            resultado = monto * 0.62;
                            break;
                        case "Yuan":
                            resultado = monto * 14.15;
                            break;
                        case "Dolar":
                            resultado = monto * 0.091;
                            break;
                        case "Soles":
                            resultado = monto * 0.29;
                            break;
                    }
                    break;
                case "Dolar":
                    switch (opcion2) {
                        case "Dolar":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.72;
                            break;
                        case "Euro":
                            resultado = monto * 0.83;
                            break;
                        case "Rupia":
                            resultado = monto * 74.89;
                            break;
                        case "Real":
                            resultado = monto * 5.25;
                            break;
                        case "Peso":
                            resultado = monto * 20.07;
                            break;
                        case "Yuan":
                            resultado = monto * 6.43;
                            break;
                        case "Yen":
                            resultado = monto * 109.98;
                            break;
                        case "Soles":
                            resultado = monto * 3.96;
                            break;
                    }
                    break;

                case "Soles":
                    switch (opcion2) {
                        case "Soles":
                            resultado = monto;
                            break;
                        case "Libra":
                            resultado = monto * 0.19;
                            break;
                        case "Euro":
                            resultado = monto * 0.22;
                            break;
                        case "Rupia":
                            resultado = monto * 19.76;
                            break;
                        case "Real":
                            resultado = monto * 1.39;
                            break;
                        case "Peso":
                            resultado = monto * 5.33;
                            break;
                        case "Yuan":
                            resultado = monto * 1.71;
                            break;
                        case "Yen":
                            resultado = monto * 29.19;
                            break;
                        case "Dolar":
                            resultado = monto * 0.26;
                            break;
                    }
                    break;
            }


            // Mostrar el resultado en el TextView
            TextView resultadoTextView = view.findViewById(R.id.resultTextView);
            resultadoTextView.setText(String.format("%.2f %s = %.2f %s", monto, opcion1, resultado, opcion2));
        }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}





