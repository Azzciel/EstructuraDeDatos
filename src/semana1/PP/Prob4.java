/*
 Se tiene un archivo con números enteros (2453, 123, 5674 …). 
 Construya una solucion que verifique cuales son primos. 
 Cuando un numero no es primo deberá mostrar la suma de sus dígitos
 */
package semana1.PP;

import java.util.ArrayList;

class Prob4 {

    final static String RUTA = "numeros.dat";
    ArrayList<Integer> numeros = new ArrayList();

    /*
     Esta Funcion devuelve true si el numero n es Primo.
     */
    int[] cargarNumeros() {
        int[] nums;
        Archivo.leer(RUTA, numeros);
        nums = new int[numeros.size()];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numeros.get(i);
        }
        return nums;
    }

    void guardarNumeros(int[] num) {
        ArrayList<Integer> data = new ArrayList();
        for (int a : num) {
            data.add(a);
        }
        Archivo.guardar(RUTA, data);
    }

    boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    int sumaDigitos(int numero) {
        int sum = 0;
        while (numero > 0) {
            sum += numero % 10;
            numero /= 10;
        }
        return sum;
    }
}

class Prob4Test {

    public static void main(String[] args) {
        Prob4 prueba = new Prob4();
        int[] a = {2453, 123, 5674, 98, 87, 67, 31, 30, 113, 10};
        prueba.guardarNumeros(a);
        for (int i : prueba.cargarNumeros()) {
            if (prueba.isPrime(i)) {
                System.out.println("El numero " + i + " es Primo");
            } else {
                System.out.print("El numero " + i + " no es Primo");
                System.out.println(", la suma de sus digitos es : " + prueba.sumaDigitos(i));
            }
        }
    }
}
