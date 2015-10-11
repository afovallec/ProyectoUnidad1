package Business;

public class Persona extends BusinessObject{
	private String codigoPersona;
	private String tipoDocumentoPersona;
	private String numeroDocumentoPersona;
	private String nombrePersona;
	private String telefonoPersona;
	private String emailPersona;
	
	public static final int CEDULA = 0;
	public static final int TARJETAIDENTIDAD = 1;
	public static final int NIT = 2;
	
	
	public Persona(	String codigoPersona,
					String tipoDocumentoPersona,
					String numeroDocumentoPersona,
					String nombrePersona,
					String telefonoPersona,
					String emailPersona)
	{
		super(codigoPersona, nombrePersona);
		this.tipoDocumentoPersona = tipoDocumentoPersona;
		this.numeroDocumentoPersona = numeroDocumentoPersona;
		this.nombrePersona = nombrePersona;
		this.telefonoPersona = telefonoPersona;
		this.emailPersona = emailPersona;
	}

	public String getCodigoPersona()
	{
		return codigoPersona;
	}
	
	public void setCodigoPersona(String codigoPersona)
	{
		this.codigoPersona = codigoPersona;
		setCodigoObjeto(codigoPersona);
	}
	
	public String getTipoDocumentoPersona() {
		return tipoDocumentoPersona;
	}

	public void setTipoDocumentoPersona(String tipoDocumentoPersona) {
		if(!tipoDocumentoPersona.equalsIgnoreCase(""))
			this.tipoDocumentoPersona = tipoDocumentoPersona;
	}

	public String getNumeroDocumentoPersona() {
		return numeroDocumentoPersona;
	}

	public void setNumeroDocumentoPersona(String numeroDocumentoPersona) {
		if(!numeroDocumentoPersona.equalsIgnoreCase(""))
			this.numeroDocumentoPersona = numeroDocumentoPersona;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		if(!nombrePersona.equalsIgnoreCase(""))
		{
			this.nombrePersona = nombrePersona;
			setDescripcionObjeto(nombrePersona);
		}
	}

	public String getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(String telefonoPersona) {
		if(!telefonoPersona.equalsIgnoreCase(""))
			this.telefonoPersona = telefonoPersona;
	}

	public String getEmailPersona() {
		return emailPersona;
	}

	public void setEmailPersona(String emailPersona) {
		if(emailPersona.equalsIgnoreCase(""))
			this.emailPersona = emailPersona;
	}
	
	public String toString()
	{
		return 	getCodigoObjeto() + "-" + getDescripcionObjeto();
	}
}