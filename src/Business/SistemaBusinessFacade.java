package Business;
import java.util.ArrayList;

public class SistemaBusinessFacade {
	private Lista listaNegocios;
	private Lista listaOrganizaciones;
	private Lista listaPersonas;
	private Lista listaActividades;
	private Lista listaNegociosPorOrganizacion;
	
	public static final String prefijoCodigoNegocio = "codn";
	public static final String prefijoCodigoOrganziacion = "codo";
	public static final String prefijoCodigoPersona = "codp";
	public static final String prefijoCodigoActividades = "coda";
	
	private int consecutivoNegocio;
	private int consecutivoOrganizacion;
	private int consecutivoPersona;
	private int consecutivoActividad;
	
	public SistemaBusinessFacade() {
		this.listaNegocios = new Lista();
		this.listaOrganizaciones = new Lista();
		this.listaPersonas = new Lista();
		this.listaActividades = new Lista();
		this.listaNegociosPorOrganizacion = new Lista();
		
		consecutivoNegocio = 0;
		consecutivoActividad = 0;
		consecutivoPersona = 0;
		consecutivoOrganizacion = 0;
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
	
	public int getConsecutivoNegocio()
	{
		return consecutivoNegocio;
	}
	
	public void incrementarConsecutivoNegocio()
	{
		this.consecutivoNegocio ++;
	}
	
	public int getConsecutivoActividad()
	{
		return consecutivoActividad;
	}

	public void incrementarConsecutivoActividad()
	{
		this.consecutivoActividad ++;
	}
	
	public int getConsecutivoPersona()
	{
		return consecutivoPersona;
	}
	
	public void incrementarConsecutivoPersona()
	{
		this.consecutivoPersona ++;
	}
	
	public int getConsecutivoOrganizacion()
	{
		return consecutivoOrganizacion;
	}

	public void incrementarConsecutivoOrganizacion()
	{
		this.consecutivoOrganizacion ++;
	}
	
	//Inicio operaciones sobre la entidad Lista de Negocios
	
	public void agregarNegocio(String tituloNegocio,
			String descripcionNegocio,
			String codigoNombreOrganizacion,
			double valorNegocio,
			String codigoNombrePersona,
			String fechaCierreNegocio,
			int estadoNegocio)
	{
		Negocio negocio;
		
		negocio = new Negocio(	SistemaBusinessFacade.prefijoCodigoNegocio + Integer.toString(getConsecutivoNegocio()),
								tituloNegocio,
								descripcionNegocio,
								codigoNombreOrganizacion,
								valorNegocio,
								codigoNombrePersona,
								fechaCierreNegocio);
		
		incrementarConsecutivoNegocio();
		
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
	
	public void actualizarNegocio(String codigoNegocio,
			String tituloNegocio,
			String descripcionNegocio,
			String codigoNombreOrganizacion,
			double valorNegocio,
			String codigoNombrePersona,
			String fechaCierreNegocio,
			int estadoNegocio)
	{
		Negocio negocioSeleccionado;
		negocioSeleccionado = (Negocio) getListaNegocios().consultarNodo(codigoNegocio).getBusinessObject();

		if(negocioSeleccionado != null)
		{
			negocioSeleccionado.setTituloNegocio(tituloNegocio);
			negocioSeleccionado.setDescripcionNegocio(descripcionNegocio);
			//TODO - negocioSeleccionado.setCodigoOrganizacion(codigoNombreOrganizacion);
			negocioSeleccionado.setValorNegocio(valorNegocio);
			//TODO - negocioSeleccionado.setCodigoPersona(codigoNombreOrganizacion);
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
