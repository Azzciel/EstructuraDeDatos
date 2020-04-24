package semana1.Ejemplos.Ejemplo11;

import java.io.*;

class FS {

    public static void crearArchivo() throws IOException {
        String archivo = "./pares.dat";
        FileWriter fw = new FileWriter(archivo);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter salArchivo = new PrintWriter(bw);
        int n = 20;
        for (int i = 1; i <= n; i++) {
            salArchivo.print(2 * i + " ");
            salArchivo.println();
        }
        salArchivo.close();
        System.out.println("El archivo de salida ha sido creado" + archivo);
    }

    public static void recorrearchivo() throws IOException {
        String arch = "./pares.dat";
        String linea; //Creacion del lector de archivo
        FileReader fr = new FileReader(arch);
        BufferedReader entArch = new BufferedReader(fr);
        linea = entArch.readLine();
        while (linea != null) {
            System.out.print(linea + "\n");
            linea = entArch.readLine(); //Se lee una nueva linea
        }
        entArch.close();
    }
    
    public static void main(String[] args) throws IOException{
        FS.crearArchivo();
        FS.recorrearchivo();
    }
}
