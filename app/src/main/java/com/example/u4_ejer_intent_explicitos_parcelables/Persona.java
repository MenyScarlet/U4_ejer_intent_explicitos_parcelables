package com.example.u4_ejer_intent_explicitos_parcelables;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DIDACT on 14/02/2018.
 */
//Implementar la clase parcelable y sus metodos
public class Persona implements Parcelable {

    //Atributos

    String nombre;
    int edad;
    Double sueldo;

    //CREATOR
    public static final Parcelable.Creator<Persona> CREATOR = new Parcelable.Creator<Persona>() {
        public Persona createFromParcel(Parcel in) {
            return new Persona(in);
        }

        public Persona[] newArray(int size) {
            return new Persona[size];
        }
    };

    //Constructor

    public Persona(String nombre, int edad, Double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sueldo = sueldo;
    }

    //Crear costructor que reciba por parametros un parcel
    public Persona (Parcel p){
        readFromParcel(p); //Llamamos al metodo readFromParcel() y le pasamos el parcelabre
    }

    //Getters & setters


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public void setSueldo(Double sueldo) {
        this.sueldo = sueldo;
    }

    //Metodos implementados de la clase parcelable
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeInt(this.edad);
        dest.writeDouble(this.sueldo);

    }
    //Creamos un metodo readFromParsel que usaremos para llamarlo en el constructor parcelable.
    private void readFromParcel(Parcel p){
        this.nombre = p.readString();
        this.edad = p.readInt();
        this.sueldo = p.readDouble();
    }
}
