package Business;

public class Nodo {
	private BusinessObject businessObject;
	private Nodo siguiente;
	private Nodo anterior;
	
	public Nodo(BusinessObject objetoNegocio)
	{
		this.businessObject = objetoNegocio;
		this.siguiente = null;
		this.anterior = null;
	}

	public String toString()
	{
		return businessObject.toString();
	}

	public BusinessObject getBusinessObject() {
		return businessObject;
	}

	public void setBusinessObject(BusinessObject businessObject) {
		this.businessObject = businessObject;
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
