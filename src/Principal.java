
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Negocio negocio1;
		Organizacion organizacion1;
		Persona persona1;
		Actividad actividad1;
		
		negocio1 = new Negocio(	"codn1",
								"Título negocio 1",
								"Descripción negocio 1",
								1000,
								"1-ene-2015");
		organizacion1 = new Organizacion(	"nit1",
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
									"ADMIN",
									"1-ene-2015",
									"2:00 Pm",
									"5 Horas");
		
		System.out.println(	"\nPRUEBA IMPRESIÓN" +
							"\n" + negocio1.toString() +
							"\n\n" + organizacion1.toString() + 
							"\n\n" + persona1.toString() +
							"\n\n" + actividad1.toString());
	}

}
