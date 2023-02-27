package unlam.estacionamiento;

public class Cochera implements Comparable <Cochera>{
	private Boolean esReservada;
	private String identificacion;
	private Auto autoQueLaOcupa;

	public Cochera (String id, Boolean esReservada) {
		this.esReservada=esReservada;
		this.identificacion=id;
	}

	public Boolean getReservada() {
		return esReservada;
	}

	public void setReservada(Boolean esReservada) {
		this.esReservada = esReservada;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}
	
	public Auto getOcupadaPor() {
		return this.autoQueLaOcupa;
	}
	
	public void setOcupadaPor(Auto autoQueLaOcupa) {
		this.autoQueLaOcupa = autoQueLaOcupa;
	}
	
	public void vaciar() {
		this.autoQueLaOcupa=null;	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificacion == null) ? 0 : identificacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Cochera other = (Cochera) obj;
		if (identificacion == null) {
			if (other.identificacion != null)
				return false;
		} else if (!identificacion.equals(other.identificacion))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cochera otra) {
		return this.getIdentificacion().compareTo(otra.getIdentificacion());
	}
}
