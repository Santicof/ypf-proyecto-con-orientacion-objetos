package modulo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
private List<Tarjeta> tarjetas;

public Sistema() {
	
	this.tarjetas = new ArrayList<Tarjeta>();
}

public List<Tarjeta> getTarjetas() {
	return tarjetas;
}

public void setTarjetas(List<Tarjeta> tarjetas) {
	this.tarjetas = tarjetas;
}



public Tarjeta traerTarjeta(String codigoCliente){
	Tarjeta tar=null;
	int i=0;
	while(tar==null&&i<tarjetas.size()) {
		if(tarjetas.get(i).getCodigoCliente().equals(codigoCliente)) {
			tar=tarjetas.get(i);
		}
		i++;
	}
	return tar;
}


public boolean agregarTarjeta(String codigo, String codigoCliente) throws Exception {
	int proxId=1;
	if(0<tarjetas.size()) {
		proxId=tarjetas.get(tarjetas.size()-1).getIdTarjeta()+1;
	}
	return tarjetas.add( new Tarjeta(proxId, codigo, codigoCliente));
}


public List<Tarjeta> traerTarjetasComprasEfectivo(LocalDate fechaDesde, LocalDate fechaHasta) {
	List<Tarjeta> lista=new ArrayList<Tarjeta>();
	for(int i=0;i<tarjetas.size();i++) {
		Tarjeta tar=this.tarjetas.get(i);
				for(int j=0;j<tar.getCompras().size();j++) {
					if(tar.getCompras().get(j)  instanceof Electronica) {
						if(tar.getCompras().get(j).getFecha().isBefore(fechaHasta.plusDays(1))&&
								tar.getCompras().get(j).getFecha().isAfter(fechaDesde.minusDays(1))){
							lista.add(tar);
						}
			}
			
		}
	}
	return lista;
}






@Override
public String toString() {
	return "Sistema [tarjetas=" + tarjetas + "]";
}

}
