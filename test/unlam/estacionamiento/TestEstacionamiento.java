package unlam.estacionamiento;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEstacionamiento {

	@Test
	public void testQueAlComenzarLaCantidadDeCocherasOcupadasEsCero() {
		Estacionamiento estacionamiento = new Estacionamiento ("UNLAM");
		assertNotNull(estacionamiento);
		Cochera cochera = new Cochera("1", true);
		estacionamiento.agregarCochera(cochera);
		assertEquals(estacionamiento.getCantidadCocherasOcupadas(), (Integer)0);
		assertEquals(estacionamiento.buscarCocheraDisponible(), cochera);
	}
	@Test
	public void testQueAlIngresarUnCocheLaCantidadDeCocherasDisponiblesEs29() throws Exception {
		Estacionamiento estacionamiento = new Estacionamiento ("UNLAM");
		Cochera cochera1 = new Cochera("1", true);
		Cochera cochera2 = new Cochera("2", true);
		Cochera cochera3 = new Cochera("3", false);
		Cochera cochera4 = new Cochera("4", true);
		Cochera cochera5 = new Cochera("5", true);
		Cochera cochera6 = new Cochera("6", false);
		Cochera cochera7 = new Cochera("7", true);
		Cochera cochera8 = new Cochera("8", true);
		Cochera cochera9 = new Cochera("9", true);
		Cochera cochera10 = new Cochera("10", false);
		Cochera cochera11 = new Cochera("11", false);
		Cochera cochera12 = new Cochera("12", false);
		Cochera cochera13 = new Cochera("13", false);
		Cochera cochera14 = new Cochera("14", false);
		Cochera cochera15 = new Cochera("15", true);
		Cochera cochera16 = new Cochera("16", true);
		Cochera cochera17 = new Cochera("17", true);
		Cochera cochera18 = new Cochera("18", true);
		Cochera cochera19 = new Cochera("19", true);
		Cochera cochera20 = new Cochera("20", true);
		Cochera cochera21 = new Cochera("21", true);
		Cochera cochera22 = new Cochera("22", true);
		Cochera cochera23 = new Cochera("23", false);
		Cochera cochera24 = new Cochera("24", true);
		Cochera cochera25 = new Cochera("25", false);
		Cochera cochera26 = new Cochera("26", false);
		Cochera cochera27 = new Cochera("27", false);
		Cochera cochera28 = new Cochera("28", true);
		Cochera cochera29 = new Cochera("29", true);
		Cochera cochera30 = new Cochera("30", true);
		
		estacionamiento.agregarCochera(cochera1);
		estacionamiento.agregarCochera(cochera2);
		estacionamiento.agregarCochera(cochera3);
		estacionamiento.agregarCochera(cochera4);
		estacionamiento.agregarCochera(cochera5);
		estacionamiento.agregarCochera(cochera6);
		estacionamiento.agregarCochera(cochera7);
		estacionamiento.agregarCochera(cochera8);
		estacionamiento.agregarCochera(cochera9);
		estacionamiento.agregarCochera(cochera10);
		estacionamiento.agregarCochera(cochera11);
		estacionamiento.agregarCochera(cochera12);
		estacionamiento.agregarCochera(cochera13);
		estacionamiento.agregarCochera(cochera14);
		estacionamiento.agregarCochera(cochera15);
		estacionamiento.agregarCochera(cochera16);
		estacionamiento.agregarCochera(cochera17);
		estacionamiento.agregarCochera(cochera18);
		estacionamiento.agregarCochera(cochera19);
		estacionamiento.agregarCochera(cochera20);
		estacionamiento.agregarCochera(cochera21);
		estacionamiento.agregarCochera(cochera22);
		estacionamiento.agregarCochera(cochera23);
		estacionamiento.agregarCochera(cochera24);
		estacionamiento.agregarCochera(cochera25);
		estacionamiento.agregarCochera(cochera26);
		estacionamiento.agregarCochera(cochera27);
		estacionamiento.agregarCochera(cochera28);
		estacionamiento.agregarCochera(cochera29);
		estacionamiento.agregarCochera(cochera30);
		
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer)30);
		Auto auto = new Auto("ABC123", true);

		auto.estacionar(estacionamiento.buscarCocheraDisponible());
		
		assertEquals(auto.buscar(), cochera1);
		assertEquals(estacionamiento.getCantidadCocherasOcupadas(), (Integer)1);
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 29);
		
	}
	@Test (expected = Exception.class)
	public void testQueAlIntentarEstacionarUnAutoNoHabilitadoEnUnaCocheraReservadaLaCantidadDeCocherasDisponiblesNoCambia() throws Exception {
		Estacionamiento estacionamiento = new Estacionamiento ("UNLAM");
		Cochera cochera1 = new Cochera("1", true);
		Auto auto = new Auto("ABC123", false);
		estacionamiento.agregarCochera(cochera1);
		assertEquals(estacionamiento.getCantidadCocherasOcupadas(), (Integer)0);
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 1);
		auto.estacionar(cochera1);
		assertEquals(auto.getHabilitadoEspaciosReservados(), false);
		assertEquals(estacionamiento.getCantidadCocherasOcupadas(), (Integer)0);
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 1);
	}
	@Test (expected = Exception.class)
	public void testQueCuandoElEstacionamientoEstaCompletoNoPermiteEstacionarUnNuevoAuto() throws Exception {
		Estacionamiento estacionamiento = new Estacionamiento ("UNLAM");
		Cochera cochera1 = new Cochera("1", false);
		estacionamiento.agregarCochera(cochera1);
		
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 1);
		Auto auto1 = new Auto("ABC123", false);
		auto1.estacionar(estacionamiento.buscarCocheraDisponible());	
		
		assertEquals(auto1.getCocheraSeleccionada(), cochera1);
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 0);
		assertEquals(auto1.buscar(), cochera1);
		
		Auto auto2 = new Auto("BCP123", false);
		auto2.estacionar(estacionamiento.buscarCocheraDisponible());
		assertNull(auto2.buscar());	
	}
	
	@Test
	public void testQueCuandoSalgaElAutoElEspacioQuedeLibreNuevamente() throws Exception {
		Estacionamiento estacionamiento = new Estacionamiento ("UNLAM");
		Cochera cochera1 = new Cochera("1", true);
		Auto auto1 = new Auto("ABC123", true);
		estacionamiento.agregarCochera(cochera1);
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 1);
		
		auto1.estacionar(estacionamiento.buscarCocheraDisponible());
		
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 0);
		
		auto1.salir();
		
		assertEquals(estacionamiento.getCantidadCocherasDisponibles(), (Integer) 1);
	}
}
