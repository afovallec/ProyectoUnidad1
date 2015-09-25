
public class AsignacionNegocioOrganizacion {
	private Negocio negocio;
	private Organizacion organizacion;
	
	public AsignacionNegocioOrganizacion(Negocio negocio,
			Organizacion organizacion) {
		super();
		this.negocio = negocio;
		this.organizacion = organizacion;
	}

	public Negocio getNegocio() {
		return negocio;
	}

	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
	}
}
