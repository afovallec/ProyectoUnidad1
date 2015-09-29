
public class Nodo {
	private BusinessObject objetoNegocio;
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo(BusinessObject objetoNegocio)
	{
		this.objetoNegocio = objetoNegocio;
		this.siguiente = null;
		this.anterior = null;
	}

	public String toString()
	{
		return objetoNegocio.toString();
	}

	public BusinessObject getObjetoNegocio() {
		return objetoNegocio;
	}

	public void setObjetoNegocio(BusinessObject objetoNegocio) {
		this.objetoNegocio = objetoNegocio;
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
}
