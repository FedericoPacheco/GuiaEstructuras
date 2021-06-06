package Ejercicio10;

import java.util.ArrayList;
import java.util.List;


public class ArbolVacio<E> extends Arbol<E> 
{
	
	public ArbolVacio() { this.valor=null; }
	
	@Override
	public List<E> preOrden() 					 	 { return new ArrayList<E>(); }
	public List<E> inOrden() 						 { return new ArrayList<E>(); }
	public List<E> posOrden() 						 { return new ArrayList<E>(); }
	public Boolean esVacio() 						 { return true; }
	public E getValor() 						     { return null; }
	public Arbol<E> getIzquierdo() 		     		 { return null; }
	public Arbol<E> getDerecho() 			 		 { return null; }
	public Boolean contiene(E unValor) 		 	 	 { return false; }
	public Boolean equals(Arbol<E> unArbol)  		 { return unArbol.esVacio(); }
	public Integer profundidad() 					 { return 0;/*-1;*/ } //https://stackoverflow.com/questions/4065439/height-of-a-tree-with-only-one-node
	public Integer cuentaHojas() 					 { return 0; }
	public Integer cuentaNodosDeNivel(Integer nivel) { return 0; }
	public Boolean esCompleto() 			 		 { return false; }
	public void setIzquierdo(Arbol<E> a) 	 		 { }
	public void setDerecho(Arbol<E> a) 	     		 { }
	public Arbol<E> remove(E e) 			 		 { return this; }
	public Boolean esLleno() 				 		 { return false; }
	public Integer calcularSuma() 					 { return 0; }
    public Boolean existeCamino(E v1, E v2)  		 { return false; }
	public Arbol<E> espejar() 				 		 { return null; }
	public List<E> camino(E v1, E v2) 		 		 { return new ArrayList<E>(); }
	public Boolean esZurdo() 						 { return true; }
	public Arbol<E> add(E e) 				 		 { return new ArbolBinario<E>(e); }
	public String toString() 						 { return "NULL"; }
	public Arbol<E> buscarNodoPadreDe(E e) 			 { return new ArbolVacio<E>(); }
	public Arbol<E> buscarNodo(E e) 	   			 { return new ArbolVacio<E>(); }
	
	protected Integer cuentaNodos() 			   								       { return 0; }
	protected Boolean esCompletoAux(Integer h) 	   									   { return false; }
	protected Arbol<E> buscarNodoMasALaIzquierda(Arbol<E> padre, Boolean derechoPadre) { return null; }
	protected void decrementarContador() 											   { }
	protected Integer getContadorElemento() 										   { return -1; }
}
