package controlador;

import java.io.*;

import java.util.ArrayList;

public class Archivo {
    private File archivo;
    public Archivo(String nombre_archivo){
        try {
            archivo = new File(nombre_archivo);
            archivo.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public <E> ArrayList<E> leerRegistros() {
        ArrayList<E> registros = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            registros = (ArrayList<E>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (EOFException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return registros;
    }
    public <E> void guardarRegistros(ArrayList<E> registros) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(registros);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
