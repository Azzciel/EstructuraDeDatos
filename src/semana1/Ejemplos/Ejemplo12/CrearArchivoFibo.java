/* Crea un archive
// Author Augusto Cortez Vasquez */
package semana1.Ejemplos.Ejemplo12;

import java.io.*;

public class CrearArchivoFibo {

    public static int FIBO(int X) {
        if (X <= 1) {
            return X;
        } else {
            return FIBO(X - 1) + FIBO(X - 2);
        }
    }

    public static void main(String[] args) throws IOException {
        final int MAX = 10;
        int i, valor;
        String arch = "prueba.dat";
        FileWriter fw = new FileWriter(arch);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salArch = new PrintWriter(bw);
        for (i = 0; i < MAX; i++) {
            valor = FIBO(i);
            salArch.print(valor + " ");
        }
        salArch.close();
        System.out.println("El archivo de salida ha sido creado: " + arch);
    }
}
