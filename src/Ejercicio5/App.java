package Ejercicio5;

public class App 
{
	public static void main(String[] args)
	{
		int[] arr = {7, 5, 1, 6, 9, 3, 4, 5};
		
		imprimir(arr);
		PancakeSort.ordenar(arr);
		imprimir(arr);
	}
	
	private static void imprimir(int[] arr)
	{
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println("]");
	}
}
