package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Efectivo extends Compra{
private double puntosExtra;

public Efectivo(int idComprar, LocalDate fecha, LocalTime hora, double puntoPorLitros, double litrosComprados,
		double puntosExtra) {
	super(idComprar, fecha, hora, puntoPorLitros, litrosComprados);
	this.puntosExtra = puntosExtra;
}

public double getPuntosExtra() {
	return puntosExtra;
}

public void setPuntosExtra(double puntosExtra) {
	this.puntosExtra = puntosExtra;
}


@Override
public double calcularPuntajeFinal() {
double total=(this.puntoPorLitros+this.puntoPorLitros)*this.litrosComprados;
	return total;
}

@Override
public String toString() {
	return "Efectivo [puntosExtra=" + puntosExtra + " "+super.toString();
}



}
