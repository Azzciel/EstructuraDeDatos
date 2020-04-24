package semana1.Ejemplos.archivo4;
// Author Augusto Cortez VAsquez

public class Lista implements java.io.Serializable {

    private int[] x; //array de datos
    private int n; //dimensión

    public Lista(int[] x) {
        this.x = x;
        n = x.length;
        ordenar();
    }

    public Lista(int[] x, int y) {
        this.x = x;
        n = x.length;
        invertir();
    }

    public double valorMedio() {
        int suma = 0;
        for (int i = 0; i < n; i++) {
            suma += x[i];
        }
        return (double) suma / n;
    }

    public int valorMayor() {
        return x[n - 1];
    }

    public int valorMenor() {
        return x[0];
    }

    private void ordenar() {
        int aux;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i] > x[j]) {
                    aux = x[j];
                    x[j] = x[i];
                    x[i] = aux;
                }
            }
        }
    }

    public void invertir() {
        int aux2;
        for (int i = 0; i < n; i++) {
            aux2 = x[i];
            x[i] = x[n - i - 1];
            x[n - i - 1] = aux2;
        }
    }

    public String toString() {
        String texto = "";
        for (int i = 0; i < n; i++) {
            texto += "\t" + x[i];
        }
        return texto;
    }
}
