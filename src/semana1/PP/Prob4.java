/*
    Se tiene un archivo con números enteros (2453, 123, 5674 …). 
    Construya una solucion que verifique cuales son primos. 
    Cuando un numero no es primo deberá mostrar la suma de sus dígitos
*/
package semana1.PP;

import java.util.ArrayList;

class Prob4{
    ArrayList<Integer> numeros=new ArrayList();
    /*
    Esta Funcion devuelve true si el numero n es Primo.
    */
    
    boolean isPrime(int n){
        if(n==0||n==1){
            return false;
        }
        if(n%2==0)
        {
            return false;
        }
        for(int i=3;i<Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
            
}