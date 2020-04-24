/* Author Augusto Cortez Vasquez */
package semana1.Ejemplos.Ejemplo12;

import java.io.*;
import javax.swing.*;

public class Recorre {

    public static void main(String[] args) throws IOException {
        String F;
        String input = JOptionPane.showInputDialog("Qué archivo quiere leer?" + " (*.dat)");
        F = input;
        String arch;
        arch = F + ".dat";
        String línea;
        //Creación del lector de archivo    
        FileReader fr = new FileReader(arch);
        //Para manejo de entrada;   
        BufferedReader entArch = new BufferedReader(fr);
        //Se lee la primera línea
        línea = entArch.readLine();
        while (línea != null) {
            System.out.println(línea + "\n");
            //Se lee una nueva línea    
            línea = entArch.readLine();
        }
        entArch.close();
    }
}
