package Business;

public class Negocio extends BusinessObject
{
	private String codigoNegocio;
	private String tituloNegocio;
	private String descripcionNegocio;
	private String codigoOrganizacion;
	private double valorNegocio;
	private String codigoPersona;
	private String fechaCierreNegocio;
	private int estadoNegocio;
	
	public static final int PENDIENTE = 0;
	public static final int ENEJECUCION = 1;
	public static final int CERRADO = 2;
	
	public Negocio(	String codigoNegocio,
					String tituloNegocio,
					String descripcionNegocio,
					String codigoOrganizacion,
					double valorNegocio,
					String codigoPersona,
					String fechaCierreNegocio)
	{
		super(codigoNegocio, tituloNegocio);
		this.codigoNegocio = codigoNegocio;
		this.tituloNegocio = tituloNegocio;
		this.descripcionNegocio = descripcionNegocio;
		this.codigoOrganizacion = codigoOrganizacion;
		this.valorNegocio = valorNegocio;
		this.codigoPersona = codigoPersona;
		this.fechaCierreNegocio = fechaCierreNegocio;
		this.estadoNegocio = Negocio.PENDIENTE;
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
		if(!tituloNegocio.equalsIgnoreCase(""))
		{
			this.tituloNegocio = tituloNegocio;
			super.setDescripcionObjeto(tituloNegocio);
		}
	}

	public String getDescripcionNegocio() {
		return descripcionNegocio;
	}

	public void setDescripcionNegocio(String descripcionNegocio) {
		if(!descripcionNegocio.equalsIgnoreCase(""))
			this.descripcionNegocio = descripcionNegocio;
	}

	public String getCodigoOrganizacion() {
		return codigoOrganizacion;
	}

	public void setCodigoOrganizacion(String codigoOrganizacion) {
		if(!codigoOrganizacion.equalsIgnoreCase(""))
			this.codigoOrganizacion = codigoOrganizacion;
	}

	public double getValorNegocio() {
		return valorNegocio;
	}

	public void setValorNegocio(double valorNegocio) {
		if(!(valorNegocio == 0))
			this.valorNegocio = valorNegocio;
	}

	public String getCodigoPersona() {
		return codigoPersona;
	}

	public void setCodigoPersona(String codigoPersona) {
		if(!codigoPersona.equalsIgnoreCase(""))
			this.codigoPersona = codigoPersona;
	}

	public String getFechaCierreNegocio() {
		return fechaCierreNegocio;
	}

	public void setFechaCierreNegocio(String fechaCierreNegocio) {
		if(!fechaCierreNegocio.equalsIgnoreCase(""))
			this.fechaCierreNegocio = fechaCierreNegocio;
	}

	public int getEstadoNegocio() {
		return estadoNegocio;
	}

	public void setEstadoNegocio(int estadoNegocio) {
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
						"\n\tCódigo organización: " + getCodigoOrganizacion() + 
						"\n\tValor negocio: " + Double.toString(getValorNegocio()) + 
						"\n\tCódigo responsable negocio: " + getCodigoPersona() +
						"\n\tFecha cierre negocio: " + getFechaCierreNegocio() + 
						"\n\tEstado negocio: " + getEstadoNegocio();
		}
	}
	
	public String toString()
	{
		return	getCodigoObjeto() + "-" + getDescripcionObjeto();

	}
}
