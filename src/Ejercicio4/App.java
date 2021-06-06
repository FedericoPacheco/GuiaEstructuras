package Ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

public class App 
{
	public static void main(String[] args)
	{
		ArrayList<Double> arr1 = new ArrayList<Double>(Arrays.asList(3.0, 9.0, 6.0, 1.0, 2.0, 7.0, 5.0, 8.0, 6.0));
		ArrayList<Double> arr2 = new ArrayList<Double>(Arrays.asList(4.0, 5.0, 3.0, 7.0, 69.0, 10.0, 5.0, 6.0));
		
		System.out.println("Mediana de " + arr1.toString() + " (sin ordenar): " + mediana(arr1));
		System.out.println("Mediana de " + arr2.toString() + " (sin ordenar): " + mediana(arr2));
	}
	
	public static Double mediana(ArrayList<Double> arr)
	{
		if (arr.size() == 1)
			return arr.get(0);
		else if (arr.size() == 2)
			return (arr.get(0) + arr.get(1)) / 2.0;
		else
		{
			//arr.remove(obtenerIndiceMenor(arr, 0));
			//arr.remove(obtenerIndiceMayor(arr, 0));	
			arr.remove(obtenerIndice(arr, 0, (i, j) -> arr.get(i) < arr.get(j)));
			arr.remove(obtenerIndice(arr, 0, (i, j) -> arr.get(i) > arr.get(j)));
			return mediana(arr);
		}
	}
	
	//Mas generico:
	private static int obtenerIndice(ArrayList<Double> arr, int i, BiPredicate<Integer, Integer> condicion)
	{
		int j;
		
		if (i == arr.size() - 1)
			return i;
		else
		{
			j = obtenerIndice(arr, i + 1, condicion);
			
			if (condicion.test(i, j))
				return i;
			else
				return j;
		}
	}
	
	/*
	private static int obtenerIndiceMenor(ArrayList<Double> arr, int i)
	{
		int j;
		
		if (i == arr.size() - 1)
			return i;
		else
		{
			j = obtenerIndiceMenor(arr, i + 1);
			
			if (arr.get(i) < arr.get(j))
				return i;
			else
				return j;
		}
	}
	
	private static int obtenerIndiceMayor(ArrayList<Double> arr, int i)
	{
		int j;
		
		if (i == arr.size() - 1)
			return i;
		else
		{
			j = obtenerIndiceMayor(arr, i + 1);
			
			if (arr.get(i) > arr.get(j))
				return i;
			else
				return j;
		}		
	}
	*/
}
