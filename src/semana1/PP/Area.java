package semana1.PP;

import java.io.*;
import java.util.ArrayList;

/*
 Se lee una fila que contiene información, base y altura triangulos. Se quiere hallar el área mayor, área menor y el área promedio
 */
public class Area {

    static final String RUTA = "baseAltura.dat";
    double May = 0, Men, Prom = 0;
    int contador = 0;
    static ArrayList<Triangulo> triangulos;

    public Area() {
        triangulos = new ArrayList();
        
        Archivo.leer(RUTA, triangulos);
        //guardarArchivo();
        // leerArchivo();
        May = 0;
        Prom = 0;
        System.out.println(triangulos.size());
    }
    
    void agregarData(ArrayList<Triangulo> data){
        Archivo.guardar(RUTA, data);
    }
    void MayMenProm() {
        Men = calcularArea(triangulos.get(0));
        for (Triangulo a : triangulos) {
            double area = calcularArea(a);
            if (area < Men) {
                Men = area;
            }
            if (area > May) {
                May = area;
            }
            Prom += area;
            contador++;
            System.out.println("Àrea " + contador + " : " + area);
        }
        mostrar();
    }

    double calcularArea(Triangulo t) {
        return t.getAltura() * t.getBase() / 2;
    }

    static void leerArchivo() {
        try {
            FileInputStream fis = new FileInputStream(RUTA);
            ObjectInputStream entrada = new ObjectInputStream(fis);
            for (int i = 0;; i++) {
                triangulos.add((Triangulo) entrada.readObject());
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Archivo leido.");
        }
    }

//
    static void guardarArchivo() {
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(RUTA));
            salida.writeObject(new Triangulo(2, 6));
            salida.writeObject(new Triangulo(5, 6));
            salida.writeObject(new Triangulo(5, 8));
            salida.writeObject(new Triangulo(7, 8));
            salida.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    void mostrar() {
        System.out.println("El area menor es : " + Men);
        System.out.println("El area mayor es : " + May);
        System.out.println("El area promedio es : " + Prom);
    }
}

class AreaTest {

    public static void main(String[] args) {
        Area test = new Area();

        ArrayList<Triangulo> data = new ArrayList();
        data.add(new Triangulo(2, 6));
        data.add(new Triangulo(4, 6));
        test.agregarData(data);
        
        test.MayMenProm();
    }
}
