package semana1.PP;

import java.io.*;
import javax.swing.JOptionPane;

class Sucesion {

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
        String ruta = "sucesion.dat";
        FileWriter fw = new FileWriter(ruta);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter sucesion = new PrintWriter(bw);
        for (int i = 0; i < numeroTerminos; i++) {
            sucesion.print(sucesion(i) + " ");
        }
        sucesion.close();
        System.out.println("El archivo de salida ha sido creado: " + ruta);
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
