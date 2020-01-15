package com.example.ejerc04a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.ejerc04a.domain.ObjetoTrabajador;

import static com.example.ejerc04a.MainActivity.EXTRA_MESSAGE;
import static com.example.ejerc04a.MainActivity.listaTrabajador;
import static com.example.ejerc04a.MainActivity.objetoTrabajador;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(EXTRA_MESSAGE);

        int position = Integer.parseInt(message);   // posición del arreglo

        // carga datos a pantalla...
        objetoTrabajador = (ObjetoTrabajador) listaTrabajador.get(position);

        TextView et_nom_trabajador = findViewById(R.id.et_nom_trabajador);
        TextView et_dni_trabajador = findViewById(R.id.et_dni_trabajador);
        TextView et_direccion_trabajador = findViewById(R.id.et_direccion_trabajador);
        TextView et_salario_trabajador = findViewById(R.id.et_salario_trabajador);

        TextView tv_position_trabajador = findViewById(R.id.tv_position_trabajador);

        et_nom_trabajador.setText(objetoTrabajador.getNombre());
        et_dni_trabajador.setText(objetoTrabajador.getDni());
        et_direccion_trabajador.setText(objetoTrabajador.getDireccion());
        et_salario_trabajador.setText(objetoTrabajador.getSalario());

        tv_position_trabajador.setText(message);

    } // onCreate

    /**
     * Called when the user taps the OK btn
     */
    public void IrAMain(View view) {

        // actualiza arreglo correspondiente

        TextView et_nom_trabajador = findViewById(R.id.et_nom_trabajador);
        TextView et_dni_trabajador = findViewById(R.id.et_dni_trabajador);
        TextView et_direccion_trabajador = findViewById(R.id.et_direccion_trabajador);
        TextView et_salario_trabajador = findViewById(R.id.et_salario_trabajador);

        objetoTrabajador.setNombre(et_nom_trabajador.getText().toString());
        objetoTrabajador.setDni(et_dni_trabajador.getText().toString());
        objetoTrabajador.setDireccion(et_direccion_trabajador.getText().toString());
        objetoTrabajador.setSalario(et_salario_trabajador.getText().toString());

        TextView tv_position_trabajador = findViewById(R.id.tv_position_trabajador);

        String message = et_nom_trabajador.getText().toString();
        String message2 = tv_position_trabajador.getText().toString();;

        Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(
                    EXTRA_MESSAGE,
                    "OK trabajador " + message + ", " + message2 );
        startActivity(intent);

    } // ir a Main

} // Main2...
