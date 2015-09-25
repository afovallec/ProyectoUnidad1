
public class Actividad {
	private String codigoActividad;
	private String descripcionActividad;
	private String tipoActividad;
	private String fechaInicioActividad;
	private String horaInicioActividad;
	private String duracionActividad;
	private String nombrePersona;
	private String nombreOrganizacion;
	private String nombreNegocio;
	
	public Actividad(String codigoActividad, String descripcionActividad,
			String tipoActividad, String fechaInicioActividad,
			String horaInicioActividad, String duracionActividad)
	{
		super();
		this.codigoActividad = codigoActividad;
		this.descripcionActividad = descripcionActividad;
		this.tipoActividad = tipoActividad;
		this.fechaInicioActividad = fechaInicioActividad;
		this.horaInicioActividad = horaInicioActividad;
		this.duracionActividad = duracionActividad;
		this.nombrePersona = "";
		this.nombreOrganizacion = "";
		this.nombreNegocio = "";
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		this.descripcionActividad = descripcionActividad;
	}

	public String getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(String fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public String getHoraInicioActividad() {
		return horaInicioActividad;
	}

	public void setHoraInicioActividad(String horaInicioActividad) {
		this.horaInicioActividad = horaInicioActividad;
	}

	public String getDuracionActividad() {
		return duracionActividad;
	}

	public void setDuracionActividad(String duracionActividad) {
		this.duracionActividad = duracionActividad;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getNombreNegocio() {
		return nombreNegocio;
	}

	public void setNombreNegocio(String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}
	
	public String toString()
	{
		return 	"INFORMACIÓN ACTIVIDAD: " + getCodigoActividad() +
				"\n\tDescripción actividad: " + getDescripcionActividad() +
				"\n\tTipo actividad: " + getTipoActividad() + 
				"\n\tFecha inicio actividad: " + getFechaInicioActividad() +
				"\n\tHora inicio actividad: " + getHoraInicioActividad() +
				"\n\tDuración actividad: " + getDuracionActividad() +
				"\n\tNombre persona asignada: " + getNombrePersona() +
				"\n\tNombre organización: " + getNombreOrganizacion() +
				"\n\tNombre negocio: " + getNombreNegocio(); 
	}
}
