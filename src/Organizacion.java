public class Organizacion {
	private String nitOrganizacion;
	private String nombreOrganizacion;
	private String direccionOrganizacion;
	private String telefonoOrganizacion;
	
	public Organizacion(String nitOrganizacion, String nombreOrganizacion,
			String direccionOrganizacion, String telefonoOrganizacion)
	{
		super();
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
		return 	"INFORMACIÓN ORGANIZACIÓN: " + getNitOrganizacion() +
				"\n\tNombre organización: " + getNombreOrganizacion() +
				"\n\tDirección organización: " + getDireccionOrganizacion() + 
				"\n\tTeléfono organización: " + getTelefonoOrganizacion(); 
	}
}
