package semana1.PP;

import java.util.ArrayList;
import javax.swing.*;

class Prob6 {

    double pagoHora = 5;
    double PagoHoraExtra = pagoHora * 1.5;
    double horasTrabajadas = 85;
    String RUTA = "Empleados.dat";
    ArrayList<Empleado> Empleados;

    double sueldoBruto(Empleado e) {
        return e.getSueldoBase() + e.getHorasExtras() * PagoHoraExtra;
    }

    public Prob6() {
        Empleados = new ArrayList();
    }

    void grabarArchivo() {
        Archivo.guardar(RUTA, Empleados);
    }

    void agregarEmpleado(Empleado a) {
        for (Empleado e : Empleados) {
            if (!e.getCodigo().equals(a.getCodigo())) {
                Empleados.add(a);
            }
            else{
                System.out.println("Codigo de Empleado ya existe.");
            }
        }
    }

    void abrirArchivo() {
        Archivo.leer(RUTA, Empleados);
    }

    void calculoSueldoBruto() {
        for (Empleado a : Empleados) {
            System.out.println("El sueldo bruto de " + a.getNombre() + " es " + sueldoBruto(a));
        }
    }

    double calculoPagoHora(Empleado e) {
        return pagoHora = e.getSueldoBase() / horasTrabajadas;
    }

    void mostrarReporte() {
        Empleado masGano = new Empleado();
        Empleado menosGano;
        try {
            System.out.println("Reporte Empleados");
            menosGano = Empleados.get(0);
            for (Empleado e : Empleados) {
                System.out.println(e);
                if (sueldoBruto(e) > sueldoBruto(masGano)) {
                    masGano = e;
                }
                if (sueldoBruto(e) < sueldoBruto(menosGano)) {
                    menosGano = e;
                }
            }
            System.out.println("El empleado que mas gano es " + masGano.getNombre() + " con un sueldo de " + sueldoBruto(masGano));
            System.out.println("El empleado que menos gano es " + menosGano.getNombre() + " con un sueldo de " + sueldoBruto(menosGano));
        } catch (NullPointerException e) {
            System.out.println("Lista de Empleados vacia");
        }
    }
}

class TestProb6 {

    static Prob6 test = new Prob6();

    public static void main(String[] args) {
        test.abrirArchivo();

        menu();

    }

    public static void menu() {
        int opc;
        do {
            opc = 0;
            try {
                opc = Integer.valueOf(JOptionPane.showInputDialog("1.Añadir Empleado\n"
                        + "2.Mostrar Reporte\n"
                        + "0.Salir"));
            } catch (NumberFormatException e) {
            }
            switch (opc) {
                case 1:
                    agregar();
                    break;
                case 2:
                    test.mostrarReporte();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no Valida");
            }
        } while (opc != 0);
    }

    public static void agregar() {
        Empleado nuevo = new Empleado();
        nuevo.setNombre(JOptionPane.showInputDialog("Nombre"));
        nuevo.setCodigo(JOptionPane.showInputDialog("Codigo"));
        nuevo.setSueldoBase(Double.valueOf(JOptionPane.showInputDialog("SueldoBase")));
        nuevo.setHorasExtras(Double.valueOf(JOptionPane.showInputDialog("HorasExtras")));
        test.agregarEmpleado(nuevo);
        test.grabarArchivo();
    }
}
