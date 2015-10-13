package Business;
import java.util.ArrayList;

public class SistemaBusinessFacade {
	private Lista listaNegocios;
	private Lista listaOrganizaciones;
	private Lista listaPersonas;
	private Lista listaActividades;
	private Lista listaNegociosPorOrganizacion;
	
	public static final String prefijoCodigoNegocio = "codn";
	public static final String prefijoCodigoOrganizacion = "codo";
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
	
	public void agregarNegocio(	String tituloNegocio,
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
		
		if(!getListaNegocios().existeNodoPorCodigoNombre(negocio.getCodigoObjeto()))
			getListaNegocios().agregarNodo(negocio);
		else
			System.out.println("No pudo agregarse el negocio de código " + negocio.getCodigoObjeto() + " a la lista de negocios");
	}
	
	public Negocio consultarNegocioPorCodigo(String codigoNegocio)
	{	
		if(getListaNegocios().existeNodoPorCodigoNombre(codigoNegocio))
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
	
	public void eliminarNegocio(String codigoNombreNegocio)
	{
		if(getListaNegocios().existeNodoPorCodigoNombre(codigoNombreNegocio))
		{
			getListaNegocios().eliminarNodo(codigoNombreNegocio);
		}
		else
		{
			System.out.println("No existe ningún negocio con el código " + codigoNombreNegocio + " para eliminación");
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
	
	public void actualizarNegocio(	String codigoNegocio,
									String tituloNegocio,
									String descripcionNegocio,
									String codigoOrganizacion,
									double valorNegocio,
									String codigoPersona,
									String fechaCierreNegocio,
									int estadoNegocio)
	{
		Negocio negocioSeleccionado;
		negocioSeleccionado = (Negocio) getListaNegocios().consultarNodo(codigoNegocio).getBusinessObject();

		if(negocioSeleccionado != null)
		{
			negocioSeleccionado.setTituloNegocio(tituloNegocio);
			negocioSeleccionado.setDescripcionNegocio(descripcionNegocio);
			negocioSeleccionado.setCodigoOrganizacion(codigoOrganizacion);
			negocioSeleccionado.setValorNegocio(valorNegocio);
			negocioSeleccionado.setCodigoPersona(codigoPersona);
			negocioSeleccionado.setFechaCierreNegocio(fechaCierreNegocio);
			negocioSeleccionado.setEstadoNegocio(estadoNegocio);
			
			//TODO - ajustar consultar nodo para que no reciba sino solamente el codigo del objeto y no con su descripcion
			getListaNegocios().consultarNodo(codigoNegocio).setBusinessObject(negocioSeleccionado);
		}
	}

	//Inicio operaciones sobre la entidad Lista de Personas
	
	public void agregarPersona(	int tipoDocumentoPersona,
								String numeroDocumentoPersona,
								String nombrePersona,
								String telefonoPersona,
								String emailPersona)
	{
		Persona persona;
		
		persona = new Persona(	SistemaBusinessFacade.prefijoCodigoPersona + Integer.toString(getConsecutivoPersona()),
								tipoDocumentoPersona,
								numeroDocumentoPersona,
								nombrePersona,
								telefonoPersona,
								emailPersona);
		
		incrementarConsecutivoPersona();
		
		if(!getListaPersonas().existeNodoPorCodigoNombre(persona.getCodigoObjeto()))
			getListaPersonas().agregarNodo(persona);
		else
			System.out.println("No pudo agregarse el persona de código " + persona.getCodigoObjeto() + " a la lista de personas");
	}
	
	public Persona consultarPersonaPorCodigoNombre(String codigoNombrePersona)
	{
		if(getListaPersonas().existeNodoPorCodigoNombre(codigoNombrePersona))
		{
			return (Persona) getListaPersonas().consultarNodoCodigoNombre(codigoNombrePersona).getBusinessObject();
		}
		else
		{
			System.out.println("No existe ninguna persona con el código " + codigoNombrePersona);
			return null;
		}
	}
	
	public void eliminarPersona(String codigoNombrePersona)
	{	
		if(getListaPersonas().existeNodoPorCodigoNombre(codigoNombrePersona))
		{
			getListaPersonas().eliminarNodo(codigoNombrePersona);
		}
		else
		{
			System.out.println("No existe ninguna persona con el código " + codigoNombrePersona + " para eliminación");
		}	
	}
	
	public ArrayList<String> listarPersonas()
	{	
		ArrayList<String> listaPersonas;
		
		listaPersonas = new ArrayList<String>();
		
		if(!getListaPersonas().listaVacia())
		{
			for(int contador = 0; contador < getListaPersonas().getNumeroNodos(); contador ++)
			{
				listaPersonas.add(getListaPersonas().obtenerNodoPorPosicion(contador).getBusinessObject().toString());
			}
			
			return listaPersonas;
		}
		else
		{
			return null;
		}
	}
	
	public void actualizarPersona(	String codigoPersona,
									int tipoDocumentoPersona,
									String numeroDocumentoPersona,
									String nombrePersona,
									String telefonoPersona,
									String emailPersona)
	{
		Persona personaSeleccionada;
		personaSeleccionada = (Persona) getListaPersonas().consultarNodo(codigoPersona).getBusinessObject();

		if(personaSeleccionada != null)
		{
			personaSeleccionada.setTipoDocumentoPersona(tipoDocumentoPersona);
			personaSeleccionada.setNumeroDocumentoPersona(numeroDocumentoPersona);
			personaSeleccionada.setNombrePersona(nombrePersona);
			personaSeleccionada.setTelefonoPersona(telefonoPersona);
			personaSeleccionada.setEmailPersona(emailPersona);
			
			getListaPersonas().consultarNodo(codigoPersona).setBusinessObject(personaSeleccionada);
		}
	}
	
	//Inicio operaciones sobre la entidad Lista de Organizaciones
	
	public void agregarOrganizacion(	String nitOrganizacion,
										String nombreOrganizacion,
										String direccionOrganizacion,
										String telefonoOrganizacion)
	{
		Organizacion organizacion;
		
		organizacion = new Organizacion(	SistemaBusinessFacade.prefijoCodigoOrganizacion + Integer.toString(getConsecutivoOrganizacion()),
											nitOrganizacion,
											nombreOrganizacion,
											direccionOrganizacion,
											telefonoOrganizacion);
		
		incrementarConsecutivoOrganizacion();
		
		if(!getListaOrganizaciones().existeNodoPorCodigoNombre(organizacion.getCodigoObjeto() + "-" + organizacion.getDescripcionObjeto()))
			getListaOrganizaciones().agregarNodo(organizacion);
		else
			System.out.println("No pudo agregarse la organización de código " + organizacion.getCodigoObjeto() + " a la lista de organización");
	}
	
	public Organizacion consultarOrganizacionPorCodigoNombre(String codigoNombreOrganizacion)
	{
		if(getListaOrganizaciones().existeNodoPorCodigoNombre(codigoNombreOrganizacion))
		{
			return (Organizacion) getListaOrganizaciones().consultarNodoCodigoNombre(codigoNombreOrganizacion).getBusinessObject();
		}
		else
		{
			System.out.println("No existe ninguna organización con el código " + codigoNombreOrganizacion);
			return null;
		}
	}
	
	public void eliminarOrganizacion(String codigoNombreOrganizacion)
	{	
		if(getListaOrganizaciones().existeNodoPorCodigoNombre(codigoNombreOrganizacion))
		{
			getListaOrganizaciones().eliminarNodo(codigoNombreOrganizacion);
		}
		else
		{
			System.out.println("No existe ninguna organización con el código " + codigoNombreOrganizacion + " para eliminación");
		}	
	}
	
	public ArrayList<String> listarOrganizaciones()
	{	
		ArrayList<String> listaOrganizaciones;
		
		listaOrganizaciones = new ArrayList<String>();
		
		if(!getListaOrganizaciones().listaVacia())
		{
			for(int contador = 0; contador < getListaOrganizaciones().getNumeroNodos(); contador ++)
			{
				listaOrganizaciones.add(getListaOrganizaciones().obtenerNodoPorPosicion(contador).getBusinessObject().toString());
			}
			
			return listaOrganizaciones;
		}
		else
		{
			return null;
		}
	}
	
	public void actualizarOrganizacion(	String codigoOrganizacion,
									String nitOrganizacion,
									String nombreOrganizacion,
									String direccionOrganizacion,
									String telefonoOrganizacion)
	{
		Organizacion organizacionSeleccionada;
		organizacionSeleccionada = (Organizacion) getListaOrganizaciones().consultarNodo(codigoOrganizacion).getBusinessObject();

		if(organizacionSeleccionada != null)
		{
			organizacionSeleccionada.setNitOrganizacion(nitOrganizacion);
			organizacionSeleccionada.setNombreOrganizacion(nombreOrganizacion);
			organizacionSeleccionada.setDireccionOrganizacion(direccionOrganizacion);
			organizacionSeleccionada.setTelefonoOrganizacion(telefonoOrganizacion);
			
			getListaOrganizaciones().consultarNodo(codigoOrganizacion).setBusinessObject(organizacionSeleccionada);
		}
	}
	
	//Inicio operaciones sobre la entidad Lista de Actividades
	
	public void agregarActividad(		String descripcionActividad,
										int tipoActividad,
										String fechaInicioActividad,
										String horaInicioActividad,
										String duracionActividad,
										String codigoPersona,
										String codigoOrganizacion,
										String codigoNegocio)
	{
		Actividad actividad;
		
		actividad = new Actividad(	SistemaBusinessFacade.prefijoCodigoActividades + Integer.toString(getConsecutivoActividad()),
									descripcionActividad,
									fechaInicioActividad,
									horaInicioActividad,
									duracionActividad);
		
		incrementarConsecutivoActividad();
		
		if(!getListaActividades().existeNodoPorCodigoNombre(actividad.getCodigoObjeto() + "-" + actividad.getDescripcionObjeto()))
			getListaActividades().agregarNodo(actividad);
		else
			System.out.println("No pudo agregarse la actividad de código " + actividad.getCodigoObjeto() + " a la lista de actividades");
	}
	
	public Actividad consultarActividadPorCodigoNombre(String codigoNombreActividad)
	{
		if(getListaActividades().existeNodoPorCodigoNombre(codigoNombreActividad))
		{
			return (Actividad) getListaActividades().consultarNodoCodigoNombre(codigoNombreActividad).getBusinessObject();
		}
		else
		{
			System.out.println("No existe ninguna actividad con el código " + codigoNombreActividad);
			return null;
		}
	}
	
	public void eliminarActividad(String codigoNombreActividad)
	{	
		if(getListaActividades().existeNodoPorCodigoNombre(codigoNombreActividad))
		{
			getListaActividades().eliminarNodo(codigoNombreActividad);
		}
		else
		{
			System.out.println("No existe ninguna actividad con el código " + codigoNombreActividad + " para eliminación");
		}	
	}
	
	public ArrayList<String> listarActividades()
	{	
		ArrayList<String> listaActividades;
		
		listaActividades = new ArrayList<String>();
		
		if(!getListaActividades().listaVacia())
		{
			for(int contador = 0; contador < getListaActividades().getNumeroNodos(); contador ++)
			{
				listaActividades.add(getListaActividades().obtenerNodoPorPosicion(contador).getBusinessObject().toString());
			}
			
			return listaActividades;
		}
		else
		{
			return null;
		}
	}
	
	public void actualizarActividad(	String codigoActividad,
										String descripcionActividad,
										int tipoActividad,
										String fechaInicioActividad,
										String horaInicioActividad,
										String duracionActividad,
										String codigoPersona,
										String codigoOrganizacion,
										String codigoNegocio)
	{
		Actividad actividadSeleccionada;
		actividadSeleccionada = (Actividad) getListaActividades().consultarNodo(codigoActividad).getBusinessObject();

		if(actividadSeleccionada != null)
		{
			actividadSeleccionada.setDescripcionActividad(descripcionActividad);
			actividadSeleccionada.setTipoActividad(tipoActividad);
			actividadSeleccionada.setFechaInicioActividad(fechaInicioActividad);
			actividadSeleccionada.setHoraInicioActividad(horaInicioActividad);
			actividadSeleccionada.setDuracionActividad(duracionActividad);
			actividadSeleccionada.setCodigoPersona(codigoPersona);
			actividadSeleccionada.setCodigoOrganizacion(codigoOrganizacion);
			actividadSeleccionada.setCodigoNegocio(codigoNegocio);
			
			getListaActividades().consultarNodo(codigoActividad).setBusinessObject(actividadSeleccionada);
		}
	}
	
	/*
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
