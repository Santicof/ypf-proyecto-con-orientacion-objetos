package modulo;

import java.time.LocalDate;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tarjeta {
private int idTarjeta;
private String codigo;
private String codigoCliente;
private List<Compra> compras;
public Tarjeta(int idTarjeta, String codigo, String codigoCliente) throws Exception {
	super();
	this.idTarjeta = idTarjeta;
	this.setCodigo(codigo);
	this.codigoCliente = codigoCliente;
	this.compras = new ArrayList<Compra>();
}
public int getIdTarjeta() {
	return idTarjeta;
}
public void setIdTarjeta(int idTarjeta) {
	this.idTarjeta = idTarjeta;
}
public String getCodigo() {
	return codigo;
}
public void setCodigo(String codigo) throws Exception {
	if(this.validacion(codigo)) {
		
	}
	this.codigo = codigo;
}
public String getCodigoCliente() {
	return codigoCliente;
}
public void setCodigoCliente(String codigoCliente) {
	this.codigoCliente = codigoCliente;
}
public List<Compra> getCompras() {
	return compras;
}
public boolean validacion(String codigo) throws Exception {
	int codLetra=0;
	int codDigit=0;
	if(codigo.length()==12) {
		for(int i=0;i<codigo.length();i++) {
			if(Character.isDigit(codigo.charAt(i))==true) {
				codDigit=codDigit+1;
			}
			if(Character.isLetter(codigo.charAt(i))==true) {
				codLetra=codLetra+1;
			}
		}
	}
	if(codigo.length()!=12||codLetra!=6||codDigit!=6) {
		throw new Exception("no es valido el codigo");
	}
	return true;
}


public boolean agregarCompra(LocalDate fecha, LocalTime hora, double puntosPorLitro, double
litrosComprados, double puntosExtra) {
	int proxId=1;
	if(0<compras.size()) {
		proxId=compras.get(compras.size()-1).getIdComprar()+1;
	}
	return compras.add(new Efectivo(proxId,fecha,hora,puntosPorLitro,litrosComprados,puntosExtra));
}



public boolean agregarCompra(LocalDate fecha, LocalTime hora, double puntosPorLitro, double
litrosComprados, String medio, double puntosDeRegalo) {
	int proxId=1;
	if(0<compras.size()) {
		proxId=compras.get(compras.size()-1).getIdComprar()+1;
	}
	return compras.add(new Electronica(proxId, fecha, hora, puntosPorLitro, litrosComprados, medio, puntosDeRegalo));
}

public double calcularPuntaje() {
	double total=0;
	for(int i=0;i<compras.size();i++) {
		total=this.compras.get(i).calcularPuntajeFinal()+total;
	}
	return total;
}
public double calcularPuntaje(LocalDate fecha) {
	double total=0;
	for(int i=0;i<compras.size();i++) {
		if(compras.get(i).getFecha().equals(fecha)) {
			total=total+compras.get(i).calcularPuntajeFinal();
		}
	}
	return total;
}

public double calcularPuntaje(int anio, int mes) {
	double total=0;
	for(int i=0;i<compras.size();i++) {
		if(compras.get(i).getFecha().getYear()==anio&&compras.get(i).getFecha().getMonthValue()==mes) {
			total=total+compras.get(i).calcularPuntajeFinal();
		}
		
	}
	return total;
}



@Override
public String toString() {
	return "Tarjeta [idTarjeta=" + idTarjeta + ", codigo=" + codigo + ", codigoCliente=" + codigoCliente + ", compras="
			+ compras + " ";
}


}
