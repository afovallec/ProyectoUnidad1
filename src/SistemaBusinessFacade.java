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
	}
	
	public Negocio consultarNegocioPorCodigo(String codigoNegocio)
	{
		
	}
	
	public void eliminarNegocio(String codigoNegocio)
	{
		
	}
	
	public ArrayList<String> listarNegocios()
	{
		
	}
	
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
}
