
public class Persona extends BusinessObject{
	private String tipoDocumentoPersona;
	private String numeroDocumentoPersona;
	private String nombrePersona;
	private String telofonoPersona;
	private String emailPersona;
	
	public Persona(String tipoDocumentoPersona, String numeroDocumentoPersona,
			String nombrePersona, String telofonoPersona, String emailPersona)
	{
		super(tipoDocumentoPersona + numeroDocumentoPersona);
		this.tipoDocumentoPersona = tipoDocumentoPersona;
		this.numeroDocumentoPersona = numeroDocumentoPersona;
		this.nombrePersona = nombrePersona;
		this.telofonoPersona = telofonoPersona;
		this.emailPersona = emailPersona;
	}

	public String getTipoDocumentoPersona() {
		return tipoDocumentoPersona;
	}

	public void setTipoDocumentoPersona(String tipoDocumentoPersona) {
		this.tipoDocumentoPersona = tipoDocumentoPersona;
		setCodigoObjeto(tipoDocumentoPersona + getNumeroDocumentoPersona());
	}

	public String getNumeroDocumentoPersona() {
		return numeroDocumentoPersona;
	}

	public void setNumeroDocumentoPersona(String numeroDocumentoPersona) {
		this.numeroDocumentoPersona = numeroDocumentoPersona;
		setCodigoObjeto(getTipoDocumentoPersona() + numeroDocumentoPersona);
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public String getTelofonoPersona() {
		return telofonoPersona;
	}

	public void setTelofonoPersona(String telofonoPersona) {
		this.telofonoPersona = telofonoPersona;
	}

	public String getEmailPersona() {
		return emailPersona;
	}

	public void setEmailPersona(String emailPersona) {
		this.emailPersona = emailPersona;
	}
	
	public String toString()
	{
		return 	"INFORMACIÓN PERSONA: " + getCodigoObjeto();
	}
}
