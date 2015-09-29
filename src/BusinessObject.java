
public class BusinessObject extends Object{
	private Object objeto;
	private String codigoObjeto;
	
	public BusinessObject(String codigoObjeto) {
		super();
		this.codigoObjeto = codigoObjeto;
	}

	public void setCodigoObjeto(String codigoObjeto)
	{
		this.codigoObjeto = codigoObjeto;
	}
	
	public String getCodigoObjeto()
	{
		return codigoObjeto;
	}
	
	public String toString()
	{
		return objeto.toString();
	}
}
