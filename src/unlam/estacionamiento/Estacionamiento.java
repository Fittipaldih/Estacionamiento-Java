package unlam.estacionamiento;

import java.util.Set;
import java.util.TreeSet;

public class Estacionamiento {
	private String nombre;
	private Set <Cochera> cocheras ;
	
	public Estacionamiento (String nombre) {
		this.nombre=nombre;
		cocheras= new TreeSet<>();
	}
	
	public void agregarCochera(Cochera cochera) {
		cocheras.add(cochera);
	}
	
	public Integer getCantidadCocherasDisponibles() {
		Integer libres=0;
		for (Cochera cochera : cocheras) {
			if ( cochera.getOcupadaPor() == null) {
				libres++;
			}
		} return libres;
	}
	
	public Integer getCantidadCocherasOcupadas() {
		Integer ocupadas=0;
		for (Cochera cochera : cocheras) {
			if ( cochera.getOcupadaPor() != null ) {
				ocupadas++;
			}
		} return ocupadas;
	}
	
	public Cochera buscarCocheraDisponible() {
		for (Cochera cochera : cocheras) {
			if( cochera.getOcupadaPor() == null) {
				return cochera;
			}
		} return null; // si retorna null es porque NO hay cochera disponible, TODAS ocupadas
	}

	@Override
	public String toString() {
		return "Estacionamiento " + nombre + "]";
	}
}
