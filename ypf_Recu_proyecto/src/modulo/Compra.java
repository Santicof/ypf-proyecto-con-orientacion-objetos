package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract  class Compra  {
	
protected  int idComprar;
protected LocalDate fecha;
protected LocalTime hora;
protected double puntoPorLitros;
protected double litrosComprados;
public Compra(int idComprar, LocalDate fecha, LocalTime hora, double puntoPorLitros, double litrosComprados) {

	this.idComprar = idComprar;
	this.fecha = fecha;
	this.hora = hora;
	this.puntoPorLitros = puntoPorLitros;
	this.litrosComprados = litrosComprados;
}





public abstract double calcularPuntajeFinal();



public int getIdComprar() {
	return idComprar;
}
public void setIdComprar(int idComprar) {
	this.idComprar = idComprar;
}
public LocalDate getFecha() {
	return fecha;
}
public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
}
public LocalTime getHora() {
	return hora;
}
public void setHora(LocalTime hora) {
	this.hora = hora;
}
public double getPuntoPorLitros() {
	return puntoPorLitros;
}
public void setPuntoPorLitros(double puntoPorLitros) {
	this.puntoPorLitros = puntoPorLitros;
}
public double getLitrosComprados() {
	return litrosComprados;
}
public void setLitrosComprados(double litrosComprados) {
	this.litrosComprados = litrosComprados;
}









@Override
public String toString() {
	return "abtract [idComprar=" + idComprar + ", fecha=" + fecha + ", hora=" + hora + ", puntoPorLitros="
			+ puntoPorLitros + ", litrosComprados=" + litrosComprados + " puntaje final="+this.calcularPuntajeFinal();
}


}
