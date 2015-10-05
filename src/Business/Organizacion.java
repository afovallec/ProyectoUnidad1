package Business;
public class Organizacion extends BusinessObject{
	private String nitOrganizacion;
	private String nombreOrganizacion;
	private String direccionOrganizacion;
	private String telefonoOrganizacion;
	
	public Organizacion(String nitOrganizacion, String nombreOrganizacion,
			String direccionOrganizacion, String telefonoOrganizacion)
	{
		super(nitOrganizacion);
		this.nitOrganizacion = nitOrganizacion;
		this.nombreOrganizacion = nombreOrganizacion;
		this.direccionOrganizacion = direccionOrganizacion;
		this.telefonoOrganizacion = telefonoOrganizacion;
	}

	public String getNitOrganizacion() {
		return nitOrganizacion;
	}

	public void setNitOrganizacion(String nitOrganizacion) {
		this.nitOrganizacion = nitOrganizacion;
		setCodigoObjeto(nitOrganizacion);
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public String getDireccionOrganizacion() {
		return direccionOrganizacion;
	}

	public void setDireccionOrganizacion(String direccionOrganizacion) {
		this.direccionOrganizacion = direccionOrganizacion;
	}

	public String getTelefonoOrganizacion() {
		return telefonoOrganizacion;
	}

	public void setTelefonoOrganizacion(String telefonoOrganizacion) {
		this.telefonoOrganizacion = telefonoOrganizacion;
	}
	
	public String toString()
	{
		return	"INFORMACIÓN ORGANIZACIÓN: " + getCodigoObjeto();
	}
}
