/* Author Augusto Cortez Vasquez */
package semana1.Ejemplos.Ejemplo12;

import java.io.*;

public class CreaArchivo1 {

    public static int lucas(int x) {
        switch (x) {
            case 1:
                return 1;
            case 2:
                return 3;
            default:
                return lucas(x - 1) + lucas(x - 2);
        }
    }

    public static void main(String[] args) throws IOException {
        final int MAX = 10;
        int valor = 0;
        String arch = "lucas.dat";
        FileWriter fw = new FileWriter(arch);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salArch = new PrintWriter(bw);
        for (int i = 1; i <= MAX; i++) {
            valor = lucas(i);
            salArch.print(valor + " ");
        }
        salArch.close();
        System.out.println("El archivo de salida ha sido creado: " + arch);
    }
}
