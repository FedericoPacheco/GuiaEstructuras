package Ejercicio2;

public class App 
{
	public static void main(String[] args)
	{
		Cuadrado c = new Cuadrado(0.0, 0.0, 8.0);
		
		c.agregarSubpatron();
		c.agregarSubpatron();
		c.agregarSubpatron();
		
		//Ver carpeta
		System.out.println("P1(0.0, 0.0): " + c.cuadradosRodeandoPunto1(0.0, 0.0));
		System.out.println("P2(2.5, 2.5): " + c.cuadradosRodeandoPunto1(2.5, 2.5));
		System.out.println("P3(-6.5, -6.5): " + c.cuadradosRodeandoPunto1(-6.5, -6.5));
		System.out.println("P4(3.5, 3.5): " + c.cuadradosRodeandoPunto1(3.5, 3.5));
		System.out.println("P5(9.0, 2.0): " + c.cuadradosRodeandoPunto1(9.0, 2.0));
		System.out.println("P6(4.0, 0.0): " + c.cuadradosRodeandoPunto1(4.0, 0.0));
		
		System.out.println("----------------------");
		
		System.out.println("P1(0.0, 0.0): " + c.cuadradosRodeandoPunto2(0.0, 0.0));
		System.out.println("P2(2.5, 2.5): " + c.cuadradosRodeandoPunto2(2.5, 2.5));
		System.out.println("P3(-6.5, -6.5): " + c.cuadradosRodeandoPunto2(-6.5, -6.5));
		System.out.println("P4(3.5, 3.5): " + c.cuadradosRodeandoPunto2(3.5, 3.5));
		System.out.println("P5(9.0, 2.0): " + c.cuadradosRodeandoPunto2(9.0, 2.0));
		System.out.println("P6(4.0, 0.0): " + c.cuadradosRodeandoPunto2(4.0, 0.0));
	}
}
