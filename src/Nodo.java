
public class Nodo {
	private int dato;
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo(int dato)
	{
		this.dato = dato;
		this.siguiente = null;
		this.anterior = null;
	}
	
	public String toString()
	{
		return Integer.toString(this.dato);
	}
	
	public void setSiguienteNodo(Nodo siguiente)
	{
		this.siguiente = siguiente;
	}
	
	public Nodo getSiguienteNodo()
	{
		return this.siguiente;
	}
	
	public void setAnteriorNodo(Nodo anterior)
	{
		this.anterior = anterior;
	}
	
	public Nodo getAnteriorNodo()
	{
		return this.anterior;
	}
	
	public void setDato(int dato)
	{
		this.dato = dato;
	}
	
	public int getDato()
	{
		return this.dato;
	}
}
