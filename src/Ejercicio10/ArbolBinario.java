package Ejercicio10;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinario <E> extends Arbol<E>
{
	protected Arbol<E> izquierdo;
	protected Arbol<E> derecho;
	private Integer contadorElemento;
	
	public ArbolBinario(E e)
	{
		this.valor = e;
		this.izquierdo = new ArbolVacio<E>();
		this.derecho = new ArbolVacio<E>();
		
		contadorElemento = 1;
	}
	
	public Arbol<E> add(E e)
	{
		// No es lo optimo pero a los efectos del ejercicio alcanza
		Integer eInt = (Integer) e;
		Integer valorInt = (Integer) this.valor;
		
		if (eInt < valorInt)  
			this.izquierdo = this.izquierdo.add(e);
		else if (eInt > valorInt)
			this.derecho = this.derecho.add(e);
		else
			contadorElemento++;
		
		return this;	
	}
	
	public Arbol<E> remove(E e)
	{
		Arbol<E> padre = this.buscarNodoPadreDe(e); 
		Arbol<E> hijo = this.buscarNodo(e);
		Arbol<E> auxArbol = this, auxArbol2;
		
		if (!hijo.esVacio())
		{
			hijo.decrementarContador();
			
			if (hijo.getContadorElemento() == 0)
			{
				Boolean izqEsVacio = hijo.getIzquierdo().esVacio();
				Boolean derEsVacio = hijo.getDerecho().esVacio();
			
				if (izqEsVacio && derEsVacio)
					if (padre.getIzquierdo().equals(hijo))
						padre.setIzquierdo(new ArbolVacio<E>()); 
					else
						padre.setDerecho(new ArbolVacio<E>());
				else if (!izqEsVacio && derEsVacio)
					if (padre.getIzquierdo().equals(hijo))
						padre.setIzquierdo(hijo.getIzquierdo()); 
					else
						padre.setDerecho(hijo.getIzquierdo());
				else if (izqEsVacio && !derEsVacio)
					if (padre.getIzquierdo().equals(hijo))
						padre.setIzquierdo(hijo.getDerecho()); 
					else
						padre.setDerecho(hijo.getDerecho());
				else if (!izqEsVacio && !derEsVacio)
				{
					auxArbol2 = hijo.getDerecho().buscarNodoMasALaIzquierda(hijo, true);		
					auxArbol2.setIzquierdo(hijo.getIzquierdo());
					auxArbol2.setDerecho(hijo.getDerecho());
					
					if (!padre.esVacio())  
						if (padre.getIzquierdo().equals(hijo))
							padre.setIzquierdo(auxArbol2);
						else
							padre.setDerecho(auxArbol2);
					else
						auxArbol = auxArbol2; // Debe reasignarse la variable del que llama para que funcione
				}
			}
		}
					
		return auxArbol;
	}
	
	protected Arbol<E> buscarNodoMasALaIzquierda(Arbol<E> padre, Boolean derechoPadre)
	{
		Arbol<E> auxArbol;
		
		if (this.izquierdo.esVacio())
			if (this.derecho.esVacio())
			{
				auxArbol = this;
				
				if(derechoPadre)
					padre.setDerecho(new ArbolVacio<E>());
				else
					padre.setIzquierdo(new ArbolVacio<E>());
			}
			else
				auxArbol = this.derecho.buscarNodoMasALaIzquierda(this, true);
		else
			auxArbol = this.izquierdo.buscarNodoMasALaIzquierda(this, false);
	
		return auxArbol;
	}
	
	public Arbol<E> buscarNodo(E e)
	{
		Arbol<E> auxArbol;
		Integer eInt = (Integer) e;
		Integer valorInt = (Integer) this.valor;
		
		if (eInt < valorInt)  
			auxArbol =  this.izquierdo.buscarNodo(e);
		else if (eInt > valorInt)
			auxArbol = this.derecho.buscarNodo(e);
		else if (eInt == valorInt)
			auxArbol = this;
		else
			auxArbol = new ArbolVacio<E>();
		
		return auxArbol;
	}
	
	public Arbol<E> buscarNodoPadreDe(E e)
	{
		Arbol<E> auxArbol;
		Integer eInt = (Integer) e;
		Integer valorInt = (Integer) this.valor;
		
		// Apanio para salir al paso:
		Integer valorIzqInt = (this.izquierdo.valor == null)? Integer.MIN_VALUE : (Integer) this.izquierdo.valor;
		Integer valorDerInt = (this.derecho.valor == null)? Integer.MAX_VALUE : (Integer) this.derecho.valor;
		
		if (valorIzqInt == eInt || valorDerInt == eInt)
			auxArbol = this;
		else
			if (eInt < valorInt)  
				auxArbol =  this.izquierdo.buscarNodoPadreDe(e);
			else if (eInt > valorInt)
				auxArbol = this.derecho.buscarNodoPadreDe(e);
			else
				auxArbol = new ArbolVacio<E>();

		return auxArbol;
	}
	
	@Override
	public List<E> preOrden() 
	{
		List<E> lista = new ArrayList<E>();
		lista.add(this.valor);
		lista.addAll(this.izquierdo.preOrden());
		lista.addAll(this.derecho.preOrden());
		return lista;
	}
	
	@Override
	public List<E> inOrden() 
	{
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.inOrden());
		lista.add(this.valor);
		lista.addAll(this.derecho.inOrden());
		return lista;
	}
	@Override
	public List<E> posOrden() 
	{
		List<E> lista = new ArrayList<E>();
		lista.addAll(this.izquierdo.posOrden());
		lista.addAll(this.derecho.posOrden());
		lista.add(this.valor);
		return lista;

	}
	
	@Override
	public Boolean contiene(E e) 
	{
		return !this.buscarNodo(e).esVacio();
	}
        
	@Override
	public Boolean equals(Arbol<E> unArbol) 
	{
		return 
			this.valor.equals(unArbol.getValor()) 		      && 
			this.izquierdo.equals(unArbol.getIzquierdo()) && 
			this.derecho.equals(unArbol.getDerecho());
	}
        
        @Override
	public Integer profundidad() {
		 return 1 + Math.max(izquierdo.profundidad(), derecho.profundidad());
	}
	
	@Override
	public Integer cuentaHojas() 
	{
		if (izquierdo.esVacio() && derecho.esVacio())
			return 1;
		else
			return izquierdo.cuentaHojas() + derecho.cuentaHojas();		
	}

	@Override
	public Integer cuentaNodosDeNivel(Integer nivel) 
	{
		if (nivel == 0)
			return 1;
		else
			return this.izquierdo.cuentaNodosDeNivel(nivel - 1) + this.derecho.cuentaNodosDeNivel(nivel - 1);
    }
	
	@Override
	public Boolean esLleno() 
	{
            if(this.izquierdo.esVacio() && this.derecho.esVacio()) 
            	return true;
            if(this.izquierdo.profundidad() != this.derecho.profundidad()) 
                return false;
            else
                return derecho.esLleno() && izquierdo.esLleno();
	}
	
	@Override
	public Boolean esCompleto()
	{
		return this.esCompletoAux(this.profundidad());
	}
	
	protected Boolean esCompletoAux(Integer h) 
	{
		if (h == 1 || h == 2) // Depende de como se cuente la altura, por nodos o arcos. Si es por arcos, se debe hacer (h == 0 || h == 1)
			if (this.izquierdo.esVacio() && !this.derecho.esVacio())
				return false;
			else
				return true;
		else
			if (!this.izquierdo.esVacio() && !this.derecho.esVacio())
				return this.izquierdo.esCompletoAux(h - 1) && this.derecho.esCompletoAux(h - 1);
			else
				return false;
	}
	
	@Override
	public Integer calcularSuma() 
	{
		// Se podria considerar usar un lambda para sumar
		if (valor instanceof Number)
			return (Integer) valor + izquierdo.calcularSuma() + derecho.calcularSuma();
		else
			return 0;
	}
	
	@Override
	public Arbol<E> espejar() 
	{
            Arbol<E> auxArbol = this.izquierdo;
            this.izquierdo = this.derecho;
            this.derecho = auxArbol;
            
            this.derecho.espejar();
            this.izquierdo.espejar();
            
            return this;
	}
	
	@Override
	public Boolean existeCamino(E v1, E v2) 
	{
        if (this.valor.equals(v1))
        	return this.contiene(v2);
        else
        	return this.izquierdo.existeCamino(v1, v2) || this.derecho.existeCamino(v1, v2);
	}
	
	@Override
	public List<E> camino(E v1, E v2) // De v1 a v2
	{
		List<E> auxList = new ArrayList<E>();
		
		if (v1.equals(v2) && this.valor.equals(v2))
				auxList.add(v2);
		else
		{
			// La busqueda es guiada en lugar de no determinista. Se descartan los subarboles que se determino no tienen a v2
			if (this.izquierdo.existeCamino(this.izquierdo.valor, v2))
			{	
				if (this.valor.equals(v1)) // util hasta encontrar el comienzo del camino
				{
					auxList.add(v1);
					auxList.addAll(this.izquierdo.camino(this.izquierdo.valor, v2));	
				}
				else
					auxList.addAll(this.izquierdo.camino(v1, v2));				
			}
			else if (this.derecho.existeCamino(this.derecho.valor, v2))
			{
				if (this.valor.equals(v1)) // util hasta encontrar el comienzo del camino
				{
					auxList.add(v1);
					auxList.addAll(this.derecho.camino(this.derecho.valor, v2));
				}
				else
					auxList.addAll(this.derecho.camino(v1, v2));
			}	
		}
		
		return auxList;
	}

	@Override
	public Boolean esZurdo() 
	{
		Boolean auxBoolean;
		
		if (this.izquierdo.esVacio() && this.derecho.esVacio()) // i.e. es hoja
			auxBoolean = true;
		else
			auxBoolean = 
				this.izquierdo.esZurdo() &&
				this.derecho.esZurdo()   &&
				(this.izquierdo.cuentaNodos() > this.derecho.cuentaNodos());
		
		return auxBoolean;
	}

	@Override
	protected Integer cuentaNodos() {
		return 1 + this.izquierdo.cuentaNodos() + this.derecho.cuentaNodos();
	}

	@Override
	public String toString() 				{ return String.valueOf((Integer) this.valor); }
	protected void setIzquierdo(Arbol<E> a) { this.izquierdo = a; }
	protected void setDerecho(Arbol<E> a) 	{ this.derecho = a; }
	protected void decrementarContador() 	{ this.contadorElemento--; }
	protected Integer getContadorElemento() { return this.contadorElemento; }
	public Boolean esVacio() 				{ return false; }
	public E getValor() 					{ return this.valor; }
	public Arbol<E> getIzquierdo() 			{ return this.izquierdo; }
	public Arbol<E> getDerecho() 			{ return this.derecho; }
}
