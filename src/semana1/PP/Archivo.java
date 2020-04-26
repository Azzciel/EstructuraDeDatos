package semana1.PP;

import java.io.*;
import java.util.ArrayList;

class Archivo {

    public static void leer(String RUTA, ArrayList a) {
        try {
            FileInputStream fis = new FileInputStream(RUTA);
            ObjectInputStream entrada = new ObjectInputStream(fis);
            while (fis.available() > 0) {
                a.add(entrada.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Archivo leido.");
        }
    }

    public static void guardar(String RUTA, ArrayList a) {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA));
            for (Object b : a) {
                salida.writeObject(b);
            }
            salida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}