package semana1.PP;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Agenda implements java.io.Serializable {

    final static String RUTA = "agenda.dat";
    ArrayList<Persona> contactos;

    public Agenda() {
        contactos = new ArrayList();
    }

    public void verContactos() {
        if (contactos.isEmpty()) {
            System.out.println("Lista de Contactos Vacia.");
        } else {
            for (Persona a : contactos) {
                System.out.println(a.tostring());
            }
        }
    }

    public ArrayList<Persona> Contactos() {
        return contactos;
    }

    public void grabarAgenda() {
        Archivo.guardar(RUTA, this);
    }

    void agregarContacto(Persona nuevo) {
        contactos.add(nuevo);
    }
}

class TestAgenda {

    static Agenda prueba=new Agenda();

    public static void main(String[] args) {
        prueba = (Agenda) Archivo.leer(Agenda.RUTA, prueba);
        menu();
    }

    public static void menu() {
        int opc;
        do {
            opc = 0;
            try {
                opc = Integer.valueOf(JOptionPane.showInputDialog("1.Añadir Contacto\n"
                        + "2.Ver Contactos\n"
                        + "0.Salir"));
            } catch (NumberFormatException e) {
            }
            switch (opc) {
                case 1:
                    agregar();
                    break;
                case 2:

                    prueba.verContactos();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no Valida");
            }
        } while (opc != 0);
    }

    public static void agregar() {
        Persona nuevo = new Persona();
        nuevo.setNombre(JOptionPane.showInputDialog("Nombre"));
        nuevo.setTelefono(JOptionPane.showInputDialog("Numero"));
        nuevo.setDNI(JOptionPane.showInputDialog("DNI"));
        nuevo.setDireccion(JOptionPane.showInputDialog("Direccion"));
        prueba.agregarContacto(nuevo);
        prueba.grabarAgenda();
    }
}
