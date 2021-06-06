package Ejercicio10;

public class App 
{
		public static void main(String[] args)
		{
			/* a1:
			 *			  45	
			 *		
			 *		30			60
			 *	
			 *	20     40   50		70 
			 *
			 * Inorden:20 30 40 45 50 60 70 
			 *
			 * ------------------------- 
			 * a2:
			 *			  45	
			 *		
			 *		30			60
			 *	
			 *	20     
			 * 			
			 */
			
			ArbolBinario<Integer> a1, a2;
			a1 = new ArbolBinario<Integer>(45);
			a1.add(30).add(60).add(20).add(40).add(50).add(70);
			
			a2 = new ArbolBinario<Integer>(45);
			a2.add(30).add(60).add(20);
			
			System.out.println("a1.contiene(40) = " + a1.contiene(40));
			System.out.println("a2.contiene(40) = " + a2.contiene(40));
			System.out.println("a1.equals(a2) = " + a1.equals(a2));
			System.out.println("a1.equals(a1) = " + a1.equals(a1));
			System.out.println("a1.profundidad() = " + a1.profundidad());
			System.out.println("a1.cuentaHojasRec() = " + a1.cuentaHojas());
			System.out.println("a1.cuentaNodosDeNivel(2) = " + a1.cuentaNodosDeNivel(2));
			System.out.println("a1.esLleno() = " + a1.esLleno());
			System.out.println("a2.esLleno() = " + a2.esLleno());
			System.out.println("a1.esCompleto() = " + a1.esCompleto());
			System.out.println("a2.esCompleto() = " + a2.esCompleto());
			System.out.println("a1.calcularSuma() = " + a1.calcularSuma());
			System.out.println("a1.camino(45, 20) = " + a1.camino(45, 20));
			System.out.println("a2.camino(45, 40) = " + a2.camino(45, 40));
			System.out.println("a1.esZurdo() = " + a1.esZurdo());
			System.out.println("a2.esZurdo() = " + a2.esZurdo());
			
			System.out.println("-----------------------------------");
			a1.remove(20);
			System.out.println(a1.inOrden().toString());
			a1.remove(30);
			System.out.println(a1.inOrden().toString());
			a1.remove(60);
			System.out.println(a1.inOrden().toString());
			a1 = (ArbolBinario<Integer>) a1.remove(45);
			System.out.println(a1.inOrden().toString());
		}
	}
