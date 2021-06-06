package Ejercicio2;

public class Cuadrado 
{
	private Double centroX;
	private Double centroY;
	private Double longitudLado;
	
	// Funciona en los hechos como un "arbol cuaternario"
	private Cuadrado hijoSuperiorIzquierdo;
	private Cuadrado hijoSuperiorDerecho;
	private Cuadrado hijoInferiorIzquierdo;
	private Cuadrado hijoInferiorDerecho;
	
	public Cuadrado(Double centroX, Double centroY, Double longitudLado)
	{
		this.centroX = centroX;
		this.centroY = centroY;
		this.longitudLado = longitudLado;
		
		hijoSuperiorIzquierdo = null;
		hijoSuperiorDerecho = null;
		hijoInferiorIzquierdo = null;
		hijoInferiorDerecho = null;
	}
	
	private Boolean tieneHijos()
	{
		
		return 
		!(
			(hijoSuperiorIzquierdo == null) &&
			(hijoSuperiorDerecho == null)   &&
			(hijoInferiorIzquierdo == null) &&
			(hijoInferiorDerecho == null)
		);
	}
	
	public void agregarSubpatron()
	{
		if (this.tieneHijos())
		{
			this.hijoSuperiorIzquierdo.agregarSubpatron();
			this.hijoSuperiorDerecho.agregarSubpatron();
			this.hijoInferiorIzquierdo.agregarSubpatron();
			this.hijoInferiorDerecho.agregarSubpatron();
		}
		else
		{
			this.hijoSuperiorIzquierdo = new Cuadrado
			(
				this.centroX - longitudLado/2, 
				this.centroY + longitudLado/2, 
				longitudLado/2
			);
			
			this.hijoSuperiorDerecho = new Cuadrado
			(
				this.centroX + longitudLado/2, 
				this.centroY + longitudLado/2, 
				longitudLado/2
			);

			this.hijoInferiorIzquierdo = new Cuadrado
			(
				this.centroX - longitudLado/2, 
				this.centroY - longitudLado/2, 
				longitudLado/2
			);
			
			this.hijoInferiorDerecho = new Cuadrado
			(
				this.centroX + longitudLado/2, 
				this.centroY - longitudLado/2, 
				longitudLado/2
			);
		}
	}
	
	private Boolean contienePunto(Double x, Double y) // No se consideran dentro puntos en los bordes
	{
		return
		(
			(Math.abs(this.centroX - x) < longitudLado/2) &&
			(Math.abs(this.centroY - y) < longitudLado/2)
		);
	}
	
	public Integer cuadradosRodeandoPunto1(Double x, Double y)
	{
		Integer auxInteger;
		
		if (!this.tieneHijos())
			if (this.contienePunto(x, y))
				return 1;
			else
				return 0;
		else
		{
			if (this.contienePunto(x, y))
				auxInteger = 1;
			else
				auxInteger = 0;
			
			return
					auxInteger 												+
					this.hijoSuperiorIzquierdo.cuadradosRodeandoPunto1(x, y) +
					this.hijoSuperiorDerecho.cuadradosRodeandoPunto1(x, y)   +
					this.hijoInferiorIzquierdo.cuadradosRodeandoPunto1(x, y) +
					this.hijoInferiorDerecho.cuadradosRodeandoPunto1(x, y);
				// al menos 3 de 4 deben retornar 0
		}
	} 
	
	public Integer cuadradosRodeandoPunto2(Double x, Double y)
	{
		Integer auxInteger;
		
		if (!this.tieneHijos())
			if (this.contienePunto(x, y))
				return 1;
			else
				return 0;
		else
		{
			if (this.contienePunto(x, y))
				auxInteger = 1;
			else
				auxInteger = 0;
			
			if (this.enPrimerCuadrante(x, y))
				return auxInteger + this.hijoSuperiorDerecho.cuadradosRodeandoPunto2(x, y);
			else if (this.enSegundoCuadrante(x, y))
				return auxInteger + this.hijoSuperiorIzquierdo.cuadradosRodeandoPunto2(x, y);
			else if (this.enTercerCuadrante(x, y))
				return auxInteger + this.hijoInferiorIzquierdo.cuadradosRodeandoPunto2(x, y);
			else if (this.enCuartoCuadrante(x, y))
				return auxInteger + this.hijoInferiorDerecho.cuadradosRodeandoPunto2(x, y);
			else
				return auxInteger; // para cantidades finitas de cuadrados
		}
	}
	
	/*
	 * ii  | i
	 * ---------
	 * iii | iv
	*/
	private Boolean enPrimerCuadrante(Double x, Double y)  { return (x > this.centroX) && (y > this.centroY); }
	private Boolean enSegundoCuadrante(Double x, Double y) { return (x < this.centroX) && (y > this.centroY); }
	private Boolean enTercerCuadrante(Double x, Double y)  { return (x < this.centroX) && (y < this.centroY); }
	private Boolean enCuartoCuadrante(Double x, Double y)  { return (x > this.centroX) && (y < this.centroY); }
}

