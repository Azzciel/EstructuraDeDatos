package semana1.PP;

import java.io.Serializable;

class Empleado implements Serializable {

    private String codigo;
    private String nombre;
    private double SueldoBase;
    private double horasExtras;

    public Empleado(String codigo, String nombre, double SueldoBase, double horasExtras) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.SueldoBase = SueldoBase;
        this.horasExtras = horasExtras;
    }

    public Empleado() {
        this.codigo="Sin codigo";
        this.nombre="Sin nombre";
        this.SueldoBase=0;
        this.horasExtras=0;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return SueldoBase;
    }

    public void setSueldoBase(double SueldoBase) {
        this.SueldoBase = SueldoBase;
    }

    @Override
    public String toString() {
        return "Codigo = " + codigo + " nombre=" + nombre + " SueldoBase=" + SueldoBase + " horasExtras=" + horasExtras;
    }
    
}
