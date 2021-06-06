package Ejercicio7;

public class App 
{
	public static void main(String[] args)
	{
		int[] arr1 = {4, 3, 2, 1, 2, 3, 4, 5, 6, 7};
		int[] arr2 = {7, 4, 3, 1, -1, 5, 9, 10};
		int[] arr3 = {100, 50, 25, 5, 3, 5, 7, 9, 11, 17};
		
		System.out.println(vertice(arr1));
		System.out.println(vertice(arr2));
		System.out.println(vertice(arr3));	
	}
	
	public static int vertice(int[] arr) { return verticeAux(arr, 0, arr.length - 1); }
	
	private static int verticeAux(int [] arr, int i, int f)
	{
		if (i == f)
			return arr[i];
		else
			if (arr[f - 1] < arr[f])
				return verticeAux(arr, i, f - 1);
			else //if (arr[i] > arr[i + 1])
				return verticeAux(arr, i + 1, f);
	}
}
