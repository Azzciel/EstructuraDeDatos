package semana1.Ejemplos.archivo4;
// author Augusto Cortez VAsquez

import java.io.*;
import java.util.*;

public class ArchivoApp4 {

    public static void main(String[] args) {
        Lista lista1 = new Lista(new int[]{12, 15, 11, 4, 32});
        Lista lista2 = new Lista(new int[]{12, 15, 11, 4, 32}, 0);
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("media.obj"));
            salida.writeObject("guardar este string y un objeto\n");
            salida.writeObject(lista1);
            salida.writeObject(lista2);
            salida.close();
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("media.obj"));
            String str = (String) entrada.readObject();
            Lista obj1 = (Lista) entrada.readObject();
            Lista obj2 = (Lista) entrada.readObject();
            System.out.println("Valor medio " + obj1.valorMedio());
            System.out.println("--------------------------");
            System.out.println(str + obj1);
            System.out.println("--------------------------");
            System.out.println(obj2);
            entrada.close();
//se puede fundir en una catch Exception
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        try { //espera la pulsación de una tecla y luego RETORNO
            System.in.read();
        } catch (Exception e) {
        }
    }
}
