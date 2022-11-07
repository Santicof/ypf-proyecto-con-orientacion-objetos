package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Electronica extends Compra {
private String media;
private double puntoDeRegalo;
public Electronica(int idComprar, LocalDate fecha, LocalTime hora, double puntoPorLitros, double litrosComprados,
		String media, double puntoDeRegalo) {
	super(idComprar, fecha, hora, puntoPorLitros, litrosComprados);
	this.media = media;
	this.puntoDeRegalo = puntoDeRegalo;
}


@Override
public double calcularPuntajeFinal() {
	double total=(this.puntoPorLitros*this.litrosComprados)+this.puntoDeRegalo;
	return total;
}








public String getMedia() {
	return media;
}
public void setMedia(String media) {
	this.media = media;
}
public double getPuntoDeRegalo() {
	return puntoDeRegalo;
}
public void setPuntoDeRegalo(double puntoDeRegalo) {
	this.puntoDeRegalo = puntoDeRegalo;
}
@Override
public String toString() {
	return "Electronica [media=" + media + ", puntoDeRegalo=" + puntoDeRegalo + " "+super.toString();
}

}
