
public class AsignacionNegocioOrganizacion extends BusinessObject{
	private Negocio negocio;
	private Organizacion organizacion;
	
	public AsignacionNegocioOrganizacion(Negocio negocio,
			Organizacion organizacion) {
		super(negocio.getCodigoObjeto() + organizacion.getCodigoObjeto());
		this.negocio = negocio;
		this.organizacion = organizacion;
	}

	public Negocio getNegocio() {
		return negocio;
	}

	public void setNegocio(Negocio negocio) {
		this.negocio = negocio;
		setCodigoObjeto(negocio.getCodigoObjeto() + getOrganizacion().getCodigoObjeto());
	}

	public Organizacion getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(Organizacion organizacion) {
		this.organizacion = organizacion;
		setCodigoObjeto(getNegocio().getCodigoObjeto() + organizacion.getCodigoObjeto());
	}
	
	public String toString() {
		return getCodigoObjeto();
	}
	
}
