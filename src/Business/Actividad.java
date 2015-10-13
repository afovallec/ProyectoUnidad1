package Business;

public class Actividad extends BusinessObject{
	private String codigoActividad;
	private String descripcionActividad;
	private int tipoActividad;
	private String fechaInicioActividad;
	private String horaInicioActividad;
	private String duracionActividad;
	private String codigoPersona;
	private String codigoOrganizacion;
	private String codigoNegocio;
	
	public final static int ADMINISTRATIVA = 0;
	public final static int NEGOCIO = 1;
	
	public Actividad(	String codigoActividad,
						String descripcionActividad,
						String fechaInicioActividad,
						String horaInicioActividad,
						String duracionActividad)
	{
		super(codigoActividad, descripcionActividad);
		this.codigoActividad = codigoActividad;
		this.descripcionActividad = descripcionActividad;
		this.tipoActividad = Actividad.ADMINISTRATIVA;
		this.fechaInicioActividad = fechaInicioActividad;
		this.horaInicioActividad = horaInicioActividad;
		this.duracionActividad = duracionActividad;
		this.codigoPersona = "";
		this.codigoOrganizacion = "";
		this.codigoNegocio = "";
	}

	public String getCodigoActividad() {
		return codigoActividad;
	}

	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
		setCodigoObjeto(codigoActividad);
	}

	public String getDescripcionActividad() {
		return descripcionActividad;
	}

	public void setDescripcionActividad(String descripcionActividad) {
		if(!descripcionActividad.equalsIgnoreCase(""))
		{
			this.descripcionActividad = descripcionActividad;
			setDescripcionObjeto(descripcionActividad);
		}
	}

	public int getTipoActividad() {
		return tipoActividad;
	}

	public void setTipoActividad(int tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	public String getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(String fechaInicioActividad) {
		if(!fechaInicioActividad.equalsIgnoreCase(""))
			this.fechaInicioActividad = fechaInicioActividad;
	}

	public String getHoraInicioActividad() {
		return horaInicioActividad;
	}

	public void setHoraInicioActividad(String horaInicioActividad) {
		if(!horaInicioActividad.equalsIgnoreCase(""))
			this.horaInicioActividad = horaInicioActividad;
	}

	public String getDuracionActividad() {
		return duracionActividad;
	}

	public void setDuracionActividad(String duracionActividad) {
		if(!duracionActividad.equalsIgnoreCase(""))
			this.duracionActividad = duracionActividad;
	}

	public String getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(String codigoPersona) {
		this.codigoPersona = codigoPersona;
	}

	public String getCodigoOrganizacion() {
		return codigoOrganizacion;
	}

	public void setCodigoOrganizacion(String codigoOrganizacion) {
		this.codigoOrganizacion = codigoOrganizacion;
	}

	public String getCodigoNegocio() {
		return codigoNegocio;
	}

	public void setCodigoNegocio(String codigoNegocio) {
		this.codigoNegocio = codigoNegocio;
	}
	
	public String toString()
	{
		return 	getCodigoObjeto() + "-" + getDescripcionObjeto();
	}
}
