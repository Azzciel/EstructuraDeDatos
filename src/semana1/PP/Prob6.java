package semana1.PP;

class Prob6 {

    final double horasTrabajo = 85;
    final double PagoHora = 5;
    final double PagoHoraExtra = PagoHora * 1.5;

    double calculoSueldoBruto(Empleado e) {
        return e.getSueldoBase() + e.getHorasExtras() * PagoHoraExtra;
    }
}
