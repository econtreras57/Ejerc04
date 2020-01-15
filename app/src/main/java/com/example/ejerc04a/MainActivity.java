package com.example.ejerc04a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ejerc04a.domain.ObjetoTrabajador;

import java.util.ArrayList;
import java.util.Arrays;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity
        extends AppCompatActivity
        implements ListAdapterTrabajador.OnItemClickListener {

    public static final String EXTRA_MESSAGE = "com.example.Ejerc04a.MESSAGE";

    public static ObjetoTrabajador objetoTrabajador = new
            ObjetoTrabajador("", "", "");   // sin datos

    /*  carga algunos valores de prueba */
    static ObjetoTrabajador objetoTrabajador1 = new ObjetoTrabajador("Xavier", "11", "X");
    static ObjetoTrabajador objetoTrabajador2 = new ObjetoTrabajador("Juan", "22", "Z");
    static ObjetoTrabajador objetoTrabajador3 = new ObjetoTrabajador("Fulano", "33", "F");

    public static ArrayList listaTrabajador = new ArrayList<>(
            Arrays.asList(objetoTrabajador1, objetoTrabajador2, objetoTrabajador3));
    // con datos de prueba por ahora

    private ListAdapterTrabajador adapterTrabajador;
    private ListAdapterTrabajador.OnItemClickListener mlistenerTrabajador;
    private View v;

    // Creación

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // lista
        mlistenerTrabajador = (ListAdapterTrabajador.OnItemClickListener) this;

        RecyclerView rvlistadoTrabajador = findViewById(R.id.rvlistadoTrabajador);
        rvlistadoTrabajador.setLayoutManager(
                new LinearLayoutManager(
                        getApplicationContext(),
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );

        adapterTrabajador = new ListAdapterTrabajador(
                mlistenerTrabajador,
                getApplicationContext(),
                listaTrabajador);
        rvlistadoTrabajador.setAdapter(adapterTrabajador);

    } // onCreate

    /** Del botón OK, agrega a la lista */

    public void IngresaTrabajador(View view) {

        TextView et_nombre_trabajador = findViewById(R.id.et_nombre);
        objetoTrabajador.setNombre(et_nombre_trabajador.getText().toString());   // nombre

        TextView et_dni_trabajador = findViewById(R.id.et_dni);
        objetoTrabajador.setDni(et_dni_trabajador.getText().toString());   // dni

        adapterTrabajador.add(objetoTrabajador);


        // toast

        Context context = getApplicationContext();
        CharSequence text =
                "Ingresa Trabajador \r\n" +
                et_nombre_trabajador.getText()
                ;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    } // a Trabajador

    @Override
    public void onItemClicked(View v) {

        this.v = v;
        // v.findViewById(R.id.tv_nombre)
        /*
        TextView tv_nombre_trabajador = v.findViewById(R.id.tv_nombre);
        TextView et_nombre_trabajador = findViewById(R.id.et_nombre);
        et_nombre_trabajador.setText(
                tv_nombre_trabajador.getText().toString()
                );

        TextView tv_dni_trabajador = v.findViewById(R.id.tv_dni);
        TextView et_dni_trabajador = findViewById(R.id.et_dni);
        et_dni_trabajador.setText(
                tv_dni_trabajador.getText().toString()
        */

        // toast

        TextView tv_position = v.findViewById(R.id.tv_position);

        Context context = getApplicationContext();
        CharSequence text =
                "Click pos.: " + tv_position.getText().toString()
                ;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        Intent intent = new Intent(this, Main2Activity.class);
            // TextView tv_nombre = v.findViewById(R.id.tv_nombre);
            String message = tv_position.getText().toString();
            intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    } // onItemClicked
} // class MainActivity
