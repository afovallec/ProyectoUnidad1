import java.util.ArrayList;

public class PrincipalListas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BusinessObject negocio1;
		/*BusinessObject organizacion1;
		BusinessObject persona1;
		BusinessObject actividad1;*/
		
		SistemaBusinessFacade sistema;
		
		sistema = new SistemaBusinessFacade();
		
		ArrayList<String> listaNegocios;
		listaNegocios = new ArrayList<String>();
		
		/*Nodo nodoNegocio;
		Nodo nodoOrganizacion;
		Nodo nodoPersona;
		Nodo nodoActividad;*/
		
		for( int contador = 0; contador < 10; contador ++)
		{
			negocio1 = new Negocio(	"codn" + contador,
								"Título negocio " + contador,
								"Descripción negocio " + contador,
								1000 + contador,
								"1-ene-2015 " + contador);
			
			sistema.agregarNegocio((Negocio) negocio1);
		}
		
		sistema.getListaNegocios().imprimirLista();
		listaNegocios = sistema.listarNegocios();
		
		System.out.println("\nPrueba de negocios: " + listaNegocios.get(7).toString());
		sistema.eliminarNegocio("codn7");
		sistema.consultarNegocioPorCodigo("codn7");
		
		/*organizacion1 = new Organizacion(	"nit1",
											"Nombre organización 1",
											"Calle 1",
											"11");
		persona1 = new Persona(	"cc",
								"111",
								"Persona 1",
								"1111",
								"1@1.com");
		actividad1 = new Actividad(	"coda1",
									"Actividad 1",
									"1-ene-2015",
									"2:00 Pm",
									"5 Horas");*/
		
		/*nodoNegocio = new Nodo((Negocio) negocio1);
		nodoOrganizacion = new Nodo((Organizacion)organizacion1);
		nodoPersona = new Nodo((Persona)persona1);
		nodoActividad = new Nodo((Actividad)actividad1);*/
		
		/*System.out.println(	"\nPRUEBA IMPRESIÓN" +
							"\n" + nodoNegocio.toString() +
							"\n\n" + nodoOrganizacion.toString() + 
							"\n\n" + nodoPersona.toString() +
							"\n\n" + nodoActividad.toString());*/
	}

}
