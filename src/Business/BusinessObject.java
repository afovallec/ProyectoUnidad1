package Business;

public class BusinessObject extends Object{
	private Object objeto;
	private String codigoObjeto;
	private String descripcionObjeto;
	
	public BusinessObject(String codigoObjeto, String descripcionObjeto) {
		super();
		this.codigoObjeto = codigoObjeto;
		this.descripcionObjeto = descripcionObjeto;
	}
	
	public Object getObjeto() {
		return objeto;
	}

	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}

	public void setCodigoObjeto(String codigoObjeto)
	{
		this.codigoObjeto = codigoObjeto;
	}
	
	public String getCodigoObjeto()
	{
		return codigoObjeto;
	}
	
	public void setDescripcionObjeto(String descripcionObjeto)
	{
		this.descripcionObjeto = descripcionObjeto;
	}
	
	public String getDescripcionObjeto()
	{
		return descripcionObjeto;
	}
	
	public String toString()
	{
		return objeto.toString();
	}
}
