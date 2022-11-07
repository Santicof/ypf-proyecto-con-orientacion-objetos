package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modulo.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sistema sis = new Sistema();
		System.out.println("-------1-----------");
		try {
			sis.agregarTarjeta("ABCDEFG123456", "DNI11222333");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarTarjeta("ABCDE1234567", "DNI11222333");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarTarjeta("ABCDEFG12345", "DNI11222333");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

//----------------------------------------------------------------
		System.out.println("-------2-----------");
		try {
			sis.agregarTarjeta("ABCDEF123456", "DNI11222333");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarTarjeta("GHIJKL987654", "DNI44555666");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			sis.agregarTarjeta("MNOPQR456654", "DNI77888999");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// ----------------------------------------------------------------
		System.out.println("-------3-----------");
		System.out.println("TRAER TARJETA CON DNI DNI11222333");
		// System.out.println(sis.traerTarjeta("DNI11222333").toString());
		sis.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 9, 10), LocalTime.of(10, 30), 100.0, 25.0,
				20.0);
		sis.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 10, 01), LocalTime.of(20, 30), 200.0, 40.0,
				50.0);
		sis.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 9, 15), LocalTime.of(10, 30), 100.0, 30.0,
				"medio", 500.0);
		sis.traerTarjeta("DNI11222333").agregarCompra(LocalDate.of(2021, 10, 01), LocalTime.of(20, 30), 200.0, 20.0,
				"medio", 500.0);
		System.out.println(sis.traerTarjeta("DNI11222333").toString());

		// ----------------------------------------------------------------
		System.out.println("-------3.2-----------");
		sis.traerTarjeta("DNI44555666").agregarCompra(LocalDate.of(2021, 9, 11), LocalTime.of(15, 0), 100.0, 20.0,
				20.0);

		// ----------------------------------------------------------------
		System.out.println("-------3.3-----------");
		sis.traerTarjeta("DNI44555666").agregarCompra(LocalDate.of(2021, 10, 16), LocalTime.of(15, 0), 100.0, 20.0,
				"mercado pago", 1000.0);

		// ----------------------------------------------------------------
		System.out.println("-------4-----------");

		Tarjeta tar = sis.traerTarjeta("DNI11222333");
		double total = 0;
		for (int i = 0; i < tar.getCompras().size(); i++) {
			total = total + tar.getCompras().get(i).calcularPuntajeFinal();
		}
		// System.out.println(tar.calcularPuntaje());
		System.out.println("puntaje total de tarjeta con DNI 11222333---> " + total);
		// ----------------------------------------------------------------

		System.out.println("-------5-----------");
		System.out.println("puntaje de DNI11222333 el día 01/10/2021----> "
				+ sis.traerTarjeta("DNI11222333").calcularPuntaje(LocalDate.of(2021, 10, 01)));

		// ----------------------------------------------------------------
		System.out.println("-------6-----------");
		System.out.println("calcular por anio y mes DNI11222333-----> "
				+ sis.traerTarjeta("DNI11222333").calcularPuntaje(2021, 9));
		// ----------------------------------------------------------------

		System.out.println("-------7-----------");
		System.out.println(sis.traerTarjetasComprasEfectivo(LocalDate.of(2021, 8, 21), LocalDate.of(2021, 11, 1)));
		
	}

}
