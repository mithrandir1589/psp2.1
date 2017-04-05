import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Pruebas {
	/**
	 * Test para caso de prueba #1
	 */
	@Test 
	public void testCalculos() {
		Calculos calculos = new Calculos(10, 0.00001, 9, 1.1);
		assertEquals(0.350006,calculos.getP(), 0.0001);		
	}
	
	/**
	 * Test para caso de prueba #2
	 */
	@Test
	public void testCalculosDos() {
		Calculos calculos = new Calculos(10, 0.00001, 10, 1.1812);
		assertEquals(0.36757,calculos.getP(), 0.0001);		
	}

	/**
	 * Test para caso de prueba #3
	 */
	@Test
	public void testCalculosTres() {
		Calculos calculos = new Calculos(10, 0.00001, 30, 2.750);
		assertEquals(0.49500,calculos.getP(), 0.0001);		
	}
}
