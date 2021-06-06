package Ejercicio5;

public class PancakeSort 
{
	public static void ordenar(int[] arr)
	{
		boolean hayCambios = true;
		int i;
		int finSucesion;
		
		while (hayCambios)
		{
			hayCambios = false;
			
			i = 0;
			while (i < arr.length)
			{
				finSucesion = sucesionMonotonaDecreciente(arr, i);
				
				if (i == finSucesion) // i.e. no hay sucesion monotona decreciente
					i++;
				else
				{
					hayCambios = true;
					revertir(arr, i, finSucesion);
					i = finSucesion + 1;
				}
			}
		}
	}
	
	public static int sucesionMonotonaDecreciente(int[] arr, int i)
	{
		int j = i;
		
		while ((j < arr.length - 1) && (arr[j] > arr[j + 1]))
			j++;
		
		return j;
	}
	
	public static void revertir(int[] arr, int i, int f)
	{
		int t, j;
		
		for (j = 0; j <= (f - i)/2; j++)
		{
			t = arr[f - j];
			arr[f - j] = arr[i + j];
			arr[i + j] = t;
		}
	}
}
