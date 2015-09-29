
public class Lista {
	private Nodo primero;
	private Nodo ultimo;
	private int numeroNodos;
	
	public Lista() {
		this.primero = null;
		this.ultimo = null;
		numeroNodos = 0;
	}
	
	public void incrementaNumeroNodos()
	{
		numeroNodos ++;
	}
	
	public void disminuirNumeroNodos()
	{
		numeroNodos --;
	}
	
	public int getNumeroNodos()
	{
		return numeroNodos;
	}
	
	public boolean listaVacia()
	{
		if(primero == null)
			return true;
		else
			return false;
				
	}

	public void agregarNodo(BusinessObject objetoNegocio)
	{
		Nodo auxiliar;
		incrementaNumeroNodos();
		
		if(listaVacia() == true)
		{
			auxiliar = new Nodo(objetoNegocio);
			setPrimeroNodo(auxiliar);
			setUltimoNodo(auxiliar);
		}
		else
		{
			auxiliar = new Nodo(objetoNegocio);
			auxiliar.setAnteriorNodo(getUltimoNodo());
			getUltimoNodo().setSiguienteNodo(auxiliar);
			setUltimoNodo(auxiliar);
		}
	}
	
	public void eliminarNodo(BusinessObject objetoNegocio)
	{
		Nodo auxiliar = getPrimeroNodo();
		
		if(listaVacia() != true)
		{
			
			do
			{
				
				if(auxiliar.getObjetoNegocio() == objetoNegocio)
				{
					
					if(auxiliar == getPrimeroNodo())
					{
						setPrimeroNodo(getPrimeroNodo().getSiguienteNodo());
						getPrimeroNodo().setAnteriorNodo(null);
					}
					else if(auxiliar == getUltimoNodo())
					{
						setUltimoNodo(getUltimoNodo().getAnteriorNodo());
						getUltimoNodo().setSiguienteNodo(null);
					}
					else
					{
						auxiliar.getAnteriorNodo().setSiguienteNodo(auxiliar.getSiguienteNodo());
						auxiliar.getSiguienteNodo().setAnteriorNodo(auxiliar.getAnteriorNodo());
					}
					
					disminuirNumeroNodos();
				}
				
				auxiliar = auxiliar.getSiguienteNodo();
			}while(auxiliar != null);
			
			if(auxiliar == null)
				System.out.println("El valor " + objetoNegocio.toString() + " no ha sido encontrado para eliminación");
		}
		
	}
	
	public Nodo consultarNodo(String codigo)
	{
		Nodo auxiliar = getPrimeroNodo();
		
		if(listaVacia() != true)
		{
			
			do
			{
				
				if(auxiliar.getObjetoNegocio().getCodigoObjeto() == codigo)
				{
					return auxiliar;

				}
				
				auxiliar = auxiliar.getSiguienteNodo();
			}while(auxiliar != null);
			
			if(auxiliar == null)
				return auxiliar;
		}

		return null;
	}
	
	public Boolean existeNodo(String codigo)
	{
		Nodo auxiliar = getPrimeroNodo();
		
		if(listaVacia() != true)
		{
			
			do
			{
				
				if(auxiliar.getObjetoNegocio().getCodigoObjeto() == codigo)
				{
					return Boolean.TRUE;

				}
				
				auxiliar = auxiliar.getSiguienteNodo();
			}while(auxiliar != null);
			
			if(auxiliar == null)
				return Boolean.FALSE;
		}

		return Boolean.FALSE;
	}
	
	public void setPrimeroNodo(Nodo primero)
	{
		this.primero = primero;
	}
	
	public Nodo getPrimeroNodo()
	{
		return this.primero;
	}
	
	public void setUltimoNodo(Nodo ultimo)
	{
		this.ultimo = ultimo;
	}
	
	public Nodo getUltimoNodo()
	{
		return this.ultimo;
	}
	
	public void imprimirLista()
	{
		Nodo auxiliar = getPrimeroNodo();
		int contador = 0;
		
		if(listaVacia() != true)
		{
			System.out.println("La lista tiene " + getNumeroNodos() + " nodos");
			
			do
			{
				if(contador == 0)
					System.out.print("[");
			
				System.out.print(auxiliar.toString());
				
				if(auxiliar.getSiguienteNodo() != null)
					System.out.print(", ");
				
				auxiliar = auxiliar.getSiguienteNodo();
				contador ++;
			}while(auxiliar != null);
			
			if(auxiliar == null)
				System.out.print("]");
		}
		else
		{
			System.out.println("La lista se encuentra vacía");
		}
	}
}
