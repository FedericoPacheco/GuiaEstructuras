package Ejercicio3;

public class App 
{
	public static void main(String[] args)
	{
		Integer arr[] = {2, 2, 3, 5, 6, 8, 12, 45, 67, 89, 112};
		
		System.out.println("Piso de 4: " + hallarPiso(arr, 4));
		System.out.println("Piso de 40: " + hallarPiso(arr, 40));
		System.out.println("Piso de 1: " + hallarPiso(arr, 1));
		System.out.println("Piso de 150: " + hallarPiso(arr, 150));
		System.out.println("Piso de 8: " + hallarPiso(arr, 8));
		System.out.println("Piso de 2: " + hallarPiso(arr, 2));
	}
	
	public static Integer hallarPiso(Integer[] arr, Integer v)
	{
		return hallarPisoAux(arr, v, 0, arr.length - 1);
	}
	
	private static Integer hallarPisoAux(Integer[] arr, Integer v, Integer i, Integer f)
	{
		Integer m = i + (f - i) / 2;
		Integer j;
		Boolean b;
		Integer r = 0;
		
		if (v < arr[i])
			r = Integer.MIN_VALUE; // No existe piso. Se devuelve "-inf".
		else if (v > arr[f])
			r = arr[f];
		else if (v == arr[m])
		{
			r = Integer.MIN_VALUE; 
			j = m;
			b = false;
			while(j >= 0 && !b)  // Buscar el primer numero menor que v.
				if(arr[j] < v)
				{
					b = true;
					r = arr[j];
				}
				else
					j--;
		}
		else if (v > arr[m])   // Pseudo-busqueda binaria.
			if (v < arr[m + 1])
				r = arr[m];
			else
				r = hallarPisoAux(arr, v, m + 1, f);
		else if (v < arr[m])
				r = hallarPisoAux(arr, v, i, m - 1);
		
		return r;
	}
}
