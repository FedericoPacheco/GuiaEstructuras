package Ejercicio10;

import java.util.List;


public abstract class Arbol<E> 
{
	protected E valor;

	public abstract Arbol<E> add(E e);
	public abstract Arbol<E> remove(E e);
	public abstract Arbol<E> buscarNodoPadreDe(E e);
	public abstract Arbol<E> buscarNodo(E e);
	
	public abstract Boolean contiene(E unValor);
	public abstract Boolean equals(Arbol<E> unArbol);
	public abstract Integer profundidad();
	public abstract Integer cuentaHojas();
	public abstract Integer cuentaNodosDeNivel(Integer nivel);
	public abstract Boolean esCompleto();
	public abstract Boolean esLleno();
	public abstract Integer calcularSuma();
	public abstract Boolean existeCamino(E v1, E v2);
	public abstract Arbol<E> espejar();
	public abstract String toString();
	public abstract List<E> camino(E v1, E v2);
	public abstract Boolean esZurdo();
	public abstract List<E> preOrden();
	public abstract List<E> inOrden();
	public abstract List<E> posOrden();
	public abstract Boolean esVacio();
	public abstract E getValor();
	public abstract Arbol<E> getIzquierdo();
	public abstract Arbol<E> getDerecho();
	
	protected abstract Boolean esCompletoAux(Integer h);
	protected abstract Integer cuentaNodos();
	protected abstract Arbol<E> buscarNodoMasALaIzquierda(Arbol<E> padre, Boolean derechoPadre);
	protected abstract void decrementarContador();
	protected abstract Integer getContadorElemento();
	protected abstract void setIzquierdo(Arbol<E> a);
	protected abstract void setDerecho(Arbol<E> a);
}
