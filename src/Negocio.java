public class Negocio extends BusinessObject
{
	private String codigoNegocio;
	private String tituloNegocio;
	private String descripcionNegocio;
	private String nombreOrganizacion;
	private double valorNegocio;
	private String nombrePersona;
	private String fechaCierreNegocio;
	private String estadoNegocio;
	
	public Negocio(String codigoNegocio, String tituloNegocio,
			String descripcionNegocio,
			double valorNegocio,
			String fechaCierreNegocio)
	{
		super(codigoNegocio);
		this.codigoNegocio = codigoNegocio;
		this.tituloNegocio = tituloNegocio;
		this.descripcionNegocio = descripcionNegocio;
		this.nombreOrganizacion = "SINASIGNAR";
		this.valorNegocio = valorNegocio;
		this.nombrePersona = "SINASIGNAR";
		this.fechaCierreNegocio = fechaCierreNegocio;
		this.estadoNegocio = "ENEJECUCION";
	}

	public String getCodigoNegocio() {
		return codigoNegocio;
	}

	public void setCodigoNegocio(String codigoNegocio) {
		this.codigoNegocio = codigoNegocio;
		setCodigoObjeto(codigoNegocio);
	}

	public String getTituloNegocio() {
		return tituloNegocio;
	}

	public void setTituloNegocio(String tituloNegocio) {
		this.tituloNegocio = tituloNegocio;
	}

	public String getDescripcionNegocio() {
		return descripcionNegocio;
	}

	public void setDescripcionNegocio(String descripcionNegocio) {
		this.descripcionNegocio = descripcionNegocio;
	}

	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	public double getValorNegocio() {
		return valorNegocio;
	}

	public void setValorNegocio(double valorNegocio) {
		this.valorNegocio = valorNegocio;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getFechaCierreNegocio() {
		return fechaCierreNegocio;
	}

	public void setFechaCierreNegocio(String fechaCierreNegocio) {
		this.fechaCierreNegocio = fechaCierreNegocio;
	}

	public String getEstadoNegocio() {
		return estadoNegocio;
	}

	public void setEstadoNegocio(String estadoNegocio) {
		this.estadoNegocio = estadoNegocio;
	}
	
	public String toString(int modo)
	{
		switch(modo)
		{
			case 0:
				return	"INFORMACIÓN NEGOCIO: " + getCodigoNegocio();
			default:
				return 	"INFORMACIÓN NEGOCIO: " + getCodigoNegocio() +
						"\n\tTítulo negocio: " + getTituloNegocio() +
						"\n\tDescripción negocio: " + getDescripcionNegocio() + 
						"\n\tNombre organización: " + getNombreOrganizacion() + 
						"\n\tValor negocio: " + Double.toString(getValorNegocio()) + 
						"\n\tNombre responsable negocio: " + getNombrePersona() +
						"\n\tFecha cierre negocio: " + getFechaCierreNegocio() + 
						"\n\tEstado negocio: " + getEstadoNegocio();
		}
	}
	
	public String toString()
	{
		return	"INFORMACIÓN NEGOCIO: " + getCodigoObjeto();

	}
}
