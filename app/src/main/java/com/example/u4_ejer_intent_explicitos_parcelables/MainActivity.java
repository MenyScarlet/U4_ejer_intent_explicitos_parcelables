package com.example.u4_ejer_intent_explicitos_parcelables;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //cREAMOS UNA VARIABLE FINAL PARA GUARDAR LA ETIQUETA
    static final String EXTRA_PERSONA = "PERSONA";
    EditText etNombre, etEdad, etSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.mainEtNombre);
        etEdad = (EditText)findViewById(R.id.mainEtEdad);
        etSueldo = (EditText)findViewById(R.id.mainEtSueldo);
    }

    public void mainClickAceptar (View view){

        String nombre = etNombre.getText().toString();
        String cajaEdad = etEdad.getText().toString();
        String cajaSueldo = etSueldo.getText().toString();

        if (nombre.equals("") || cajaEdad.equals("") || cajaSueldo.equals("")){
            Toast.makeText(getApplicationContext(), "Debes de rellenar todos los campos",
                    Toast.LENGTH_SHORT).show();
        }else{
            int edad = Integer.parseInt(cajaEdad);
            double sueldo = Double.parseDouble(cajaSueldo);

            //Creamos el objeto de tipo persona con los valores recogidos del formulario
            Persona persona = new Persona(nombre, edad, sueldo);
            //Creamos el objeto Intent para enviar nuestra persona a otra Activity
            Intent i = new Intent(getApplicationContext(),PersonaActivity.class);
            //Añadimos el objeto persona que queremos enviar al activity de destino
            i.putExtra(EXTRA_PERSONA,persona);
            //Iniciamos el nuevo activity
            startActivity(i);
        }

    }
}
