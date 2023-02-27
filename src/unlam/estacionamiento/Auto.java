package unlam.estacionamiento;

public class Auto {
	private String patente;
	private Boolean habilitadoEspaciosReservados;
	private Cochera cocheraSeleccionada;
	
	public Auto(String patente, Boolean habilitadoEspaciosReservados ) {
		this.patente=patente;
		this.habilitadoEspaciosReservados=habilitadoEspaciosReservados;
	}
	
	public void estacionar(Cochera cochera) throws Exception {

		// si NO esta ocupada, fijate si es reservada
		if ( cochera.getOcupadaPor() == null) {
			
			// Si no es reservada, estaciona tranqui
			if (!cochera.getReservada()) {
				cochera.setOcupadaPor(this);
				this.cocheraSeleccionada=cochera;
			}
			
			// si es reservada y el auto esta habilitado, estaciona tranqui
			else if( cochera.getReservada() && this.habilitadoEspaciosReservados) {
				cochera.setOcupadaPor(this);
				this.cocheraSeleccionada=cochera;
			}
			
			// si es reservada y el auto no esta habilitado
			else if( cochera.getReservada() && !this.habilitadoEspaciosReservados) {
				throw new Exception("El auto NO esta habilitado para estacionar en ésta cochera");
			}
		}
		// si esta ocupada NO la puedo usar
		if (cochera.getOcupadaPor() != this) {
			throw new Exception("La cochera NO esta disponible");
		}
	}
	
	public Cochera buscar() { // devuelve la cochera donde esta estacionado 
		return this.cocheraSeleccionada;
	}
	
	public void salir() {
		this.buscar().vaciar();
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Boolean getHabilitadoEspaciosReservados() {
		return habilitadoEspaciosReservados;
	}

	public void setHabilitadoEspaciosReservados(Boolean habilitadoEspaciosReservados) {
		this.habilitadoEspaciosReservados = habilitadoEspaciosReservados;
	}

	public Cochera getCocheraSeleccionada() {
		return cocheraSeleccionada;
	}

	public void setCocheraSeleccionada(Cochera cocheraSeleccionada) {
		this.cocheraSeleccionada = cocheraSeleccionada;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patente == null) ? 0 : patente.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Auto other = (Auto) obj;
		if (patente == null) {
			if (other.patente != null)
				return false;
		} else if (!patente.equals(other.patente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String habilitado ="";
		if( habilitadoEspaciosReservados ) {
			habilitado = "SI";
		}
		else {
			habilitado = "NO";
		}
		return "Auto [patente=" + patente + ", Esta habilitado para usar espacios reservados? " + habilitado + "]";
	}
}