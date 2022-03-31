/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author Walter
 */
public class Libro {
    private String titulo;
    private String autor;
    private Integer numEjem;
    private Integer numEjemPrest;
    
    public Libro(){
    }
    
    public Libro(String titulo,String autor,Integer numEjem,Integer numEjemPrest){
        this.titulo = titulo;
        this.autor = autor;
        this.numEjem = numEjem;
        this.numEjemPrest = numEjemPrest;
    }
    
    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNumEjem() {
        return numEjem;
    }

    public void setNumEjem(Integer numEjem) {
        this.numEjem = numEjem;
    }

    public Integer getNumEjemPrest() {
        return numEjemPrest;
    }

    public void setNumEjemPrest(Integer numEjemPrest) {
        this.numEjemPrest = numEjemPrest;
    }
    
    @Override
    public String toString(){
        return "Titulo: "+titulo+" // Autor: "+autor+
                " // Número de ejemplares: "+numEjem+
                " // Número de ejemplares prestados: "+numEjemPrest;
    }
    
    public static Scanner leer = new Scanner(System.in);
    
    public static boolean Prestamo(Libro libro){
        if(libro.getNumEjem()>0){
            libro.setNumEjemPrest(libro.getNumEjemPrest()+1);
            libro.setNumEjem(libro.getNumEjem()-1);
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean Devolucion(Libro libro){
        if(libro.getNumEjemPrest()>0){
            libro.setNumEjem(libro.getNumEjem()+1);
            libro.setNumEjemPrest(libro.getNumEjemPrest()-1);
            return true;
        }else{
            return false;
        }
    }
    
    public static void MostrarLibros(HashSet<Libro> Libros){
        System.out.println("\nLibros:");
        for (Libro i : Libros) {
            System.out.println(i);
        }
    }
}
