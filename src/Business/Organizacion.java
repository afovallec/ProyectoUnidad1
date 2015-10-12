package Business;
public class Organizacion extends BusinessObject{
	private String codigoOrganizacion;
	private String nitOrganizacion;
	private String nombreOrganizacion;
	private String direccionOrganizacion;
	private String telefonoOrganizacion;
	
	public Organizacion(	String codigoOrganizacion,
							String nitOrganizacion,
							String nombreOrganizacion,
							String direccionOrganizacion,
							String telefonoOrganizacion)
	{
		super(codigoOrganizacion, nombreOrganizacion);
		this.codigoOrganizacion = codigoOrganizacion;
		this.nitOrganizacion = nitOrganizacion;
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccionOrganizacion = direccionOrganizacion;
		this.telefonoOrganizacion = telefonoOrganizacion;
	}

	public String getCodigoOrganizacion() {
		return codigoOrganizacion;
	}

	public void setCodigoOrganizacion(String codigoOrganizacion) {
		this.codigoOrganizacion = codigoOrganizacion;
		setCodigoObjeto(nitOrganizacion);
	}
	
	public String getNitOrganizacion() {
		return nitOrganizacion;
	}

	public void setNitOrganizacion(String nitOrganizacion) {
		if(!nitOrganizacion.equalsIgnoreCase(""))
			this.nitOrganizacion = nitOrganizacion;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		if(!nombreOrganizacion.equalsIgnoreCase(""))
			this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getDireccionOrganizacion() {
		return direccionOrganizacion;
	}

	public void setDireccionOrganizacion(String direccionOrganizacion) {
		if(!direccionOrganizacion.equalsIgnoreCase(""))
			this.direccionOrganizacion = direccionOrganizacion;
	}

	public String getTelefonoOrganizacion() {
		return telefonoOrganizacion;
	}

	public void setTelefonoOrganizacion(String telefonoOrganizacion) {
		if(!telefonoOrganizacion.equalsIgnoreCase(""))
			this.telefonoOrganizacion = telefonoOrganizacion;
	}
	
	public String toString()
	{
		return	getCodigoObjeto() + "-" + getDescripcionObjeto();
	}
}
