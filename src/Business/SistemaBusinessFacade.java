package Business;
import java.util.ArrayList;

public class SistemaBusinessFacade {
	private Lista listaNegocios;
	private Lista listaOrganizaciones;
	private Lista listaPersonas;
	private Lista listaActividades;
	private Lista listaNegociosPorOrganizacion;
	
	public SistemaBusinessFacade() {
		this.listaNegocios = new Lista();
		this.listaOrganizaciones = new Lista();
		this.listaPersonas = new Lista();
		this.listaActividades = new Lista();
		this.listaNegociosPorOrganizacion = new Lista();
	}
	
	public Lista getListaNegocios() {
		return listaNegocios;
	}

	public Lista getListaOrganizaciones() {
		return listaOrganizaciones;
	}

	public Lista getListaPersonas() {
		return listaPersonas;
	}

	public Lista getListaActividades() {
		return listaActividades;
	}

	public Lista getListaNegociosPorOrganizacion() {
		return listaNegociosPorOrganizacion;
	}

	//Inicio operaciones sobre la entidad Lista de Negocios
	
	public void agregarNegocio(Negocio negocio)
	{
		if(!getListaNegocios().existeNodo(negocio.getCodigoObjeto()))
			getListaNegocios().agregarNodo(negocio);
		else
			System.out.println("No pudo agregarse el negocio de código " + negocio.getCodigoObjeto() + " a la lista de negocios");
	}
	
	public Negocio consultarNegocioPorCodigo(String codigoNegocio)
	{	
		if(getListaNegocios().existeNodo(codigoNegocio))
		{
			return (Negocio) getListaNegocios().consultarNodo(codigoNegocio).getBusinessObject();
		}
		else
		{
			System.out.println("No existe ningún negocio con el código " + codigoNegocio);
			return null;
		}
	}
	
	public Negocio consultarNegocioPorCodigoNombre(String codigoNombreNegocio)
	{	
		return (Negocio) getListaNegocios().consultarNodoCodigoNombre(codigoNombreNegocio).getBusinessObject();
	}
	
	public void eliminarNegocio(String codigoNegocio)
	{
		if(getListaNegocios().existeNodo(codigoNegocio))
		{
			getListaNegocios().eliminarNodo(codigoNegocio);
		}
		else
		{
			System.out.println("No existe ningún negocio con el código " + codigoNegocio + " para eliminación");
		}		
	}
	
	public ArrayList<String> listarNegocios()
	{
		ArrayList<String> listaNegocios;
		
		listaNegocios = new ArrayList<String>();
		
		if(!getListaNegocios().listaVacia())
		{
			for(int contador = 0; contador < getListaNegocios().getNumeroNodos(); contador ++)
			{
				listaNegocios.add(getListaNegocios().obtenerNodoPorPosicion(contador).getBusinessObject().toString());
			}
			
			return listaNegocios;
		}
		else
		{
			return null;
		}
	}
	
	public void actualizarNegocio(String codigoNegocio, String tituloNegocio,
		String descripcionNegocio, String codigoNombreOrganizacion,
		double valorNegocio,
		String fechaCierreNegocio, int estadoNegocio)
	{
		Negocio negocioSeleccionado;
		negocioSeleccionado = (Negocio) getListaNegocios().consultarNodo(codigoNegocio).getBusinessObject();

		if(negocioSeleccionado != null)
		{
			negocioSeleccionado.setTituloNegocio(tituloNegocio);
			negocioSeleccionado.setDescripcionNegocio(descripcionNegocio);
			//TODO - negocioSeleccionado.setCodigoOrganizacion(codigoNombreOrganizacion);
			negocioSeleccionado.setValorNegocio(valorNegocio);
			negocioSeleccionado.setFechaCierreNegocio(fechaCierreNegocio);
			negocioSeleccionado.setEstadoNegocio(estadoNegocio);
			
			//TODO - ajustar consultar nodo para que no reciba sino solamente el codigo del objeto y no con su descripcion
			getListaNegocios().consultarNodo(codigoNegocio).setBusinessObject(negocioSeleccionado);
		}
	}

	/*
	//Inicio operaciones sobre la entidad Lista de Organizaciones
	
	public void agregarOrganizacion(Organizacion organizacion)
	{
	}
	
	public Negocio consultarOrganizacionPorNIT(String nitOrganizacion)
	{
		
	}
	
	public void eliminarOrganizacion(String nitOrganizacion)
	{
		
	}
	
	public ArrayList<String> listarOrganizaciones()
	{
		
	}
	
	//Inicio operaciones sobre la entidad Lista de Personas
	
	public void agregarPersona(Persona persona)
	{
	}
	
	public Negocio consultarPersonaPorIdentificacion(String tipoIdentificacion, String numeroIdentificacion)
	{
		
	}
	
	public void eliminarPersona(String nitOrganizacion)
	{
		
	}
	
	public ArrayList<String> listarPersonas()
	{
		
	}
	
	//Inicio operaciones sobre la entidad Lista de Actividades
	
	public void agregarActividad(Actividad actividad)
	{
	}
	
	public Negocio consultarActividadPorCodigo(String codigoActividad)
	{
		
	}
	
	public void eliminarActividad(String codigoActividad)
	{
		
	}
	
	public ArrayList<String> listarActividades()
	{
		ArrayList<String> listaActividades = new ArrayList<String>();
		
	}
	
	//Inicio operaciones sobre la entidad Lista de Negocios por Organizacion
	
	public void asignarNegocioAOrganizacion(Negocio negocio, Organizacion organizacion)
	{
	}
	
	public ArrayList<String> consultarNegociosPorOrganizacion(String nitOrganizacion)
	{
		
	}
	
	public void eliminarAsignacionNegocioAOrganizacion(Negocio negocio)
	{
		
	}
	*/
}
