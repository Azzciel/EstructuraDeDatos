package semana1.PP;

import java.io.*;
import javax.swing.JOptionPane;

class Sucesion {
    final String RUTA="sucesion.dat";
    int numeroTerminos;

    public Sucesion(int n) {
        numeroTerminos = n;
    }

    public static int sucesion(int n) {
        if (n < 1) {
            return 3;
        } else {
            return sucesion(n - 1) * 2 + 1;
        }
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = new FileWriter(RUTA);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter sucesion = new PrintWriter(bw);
        for (int i = 0; i < numeroTerminos; i++) {
            sucesion.print(sucesion(i) + " ");
        }
        sucesion.close();
        System.out.println("El archivo de salida ha sido creado: " + RUTA);
    }

    public static void main(String[] args) throws IOException {
        int numeroTerminos = menu();
        Sucesion suc = new Sucesion(numeroTerminos);
        suc.escribirArchivo();
    }

    public static int menu() throws IOException {
        int num;
        do {
            try {
                num = Integer.valueOf(JOptionPane.showInputDialog("Ingrese numero de terminos"));
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un numero valido");
                num = -1;
            }
        } while (num < 0);
        return num;
    }
}
