package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Business.Negocio;
import Business.SistemaBusinessFacade;

import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

public class GestionPrincipal {

	private SistemaBusinessFacade sistema;
	//private ArrayList<String> listaNegocios;
	
	private JFrame frameSistemaGestion;

	
	private JPanel panelAplicacion;
	private JPanel panelPrincipal;
	private JPanel panelNegocios;
	private JPanel panelPersonas;
	
	private JButton btnAdministrarNegocios;
	private JButton btnAdministrarOrganizaciones;
	private JButton btnAdministrarPersonas;
	private JButton btnAdministrarActividades;
	
	private JTextField textCodigoNegocio;
	private JTextField textTituloNegocio;
	private JTextField textDescripcionNegocio;
	private JTextField textValorNegocio;
	private JTextField textFechaCierreNegocio;
	private JLabel lblListaNegocios;
	private JComboBox<String> comboBoxListaNegocios;
	private JButton btnDetalleNegocio;
	private JButton btnEliminarNegocio;
	private JButton btnAgregarNegocio;
	private JButton btnVolverPrincipal;
	private JPanel panelDetalleNegocio;
	private JLabel lblCodigoNegocio;
	private JLabel lblTituloNegocio;
	private JLabel lblDescripcionNegocio;
	private JLabel lblNombreOrganizacionNegocio;
	private JComboBox<String> comboBoxNombreOrganizacionNegocio;
	private JLabel lblValorNegocio;
	private JLabel lblResponsableNegocio;
	private JComboBox<String> comboBoxResponsableNegocio;
	private JLabel lblFechaCierreNegocio;
	private JLabel lblEstadoNegocio;
	private JComboBox<String> comboBoxEstadoNegocio;
	private JButton btnVolver;
	private JButton btnAgregarActualizar;
	
	private JTextField textCodigoPersona;
	private JTextField textTituloPersona;
	private JTextField textDescripcionPersona;
	private JTextField textValorPersona;
	private JTextField textFechaCierrePersona;
	private JLabel lblListaPersonas;
	private JComboBox<String> comboBoxListaPersonas;
	private JButton btnDetallePersona;
	private JButton btnEliminarPersona;
	private JButton btnAgregarPersona;
	private JButton btnVolverPrincipalPersona;
	private JPanel panelDetallePersona;
	private JLabel lblCodigoPersona;
	private JLabel lblTituloPersona;
	private JLabel lblDescripcionPersona;
	private JLabel lblNombreOrganizacionPersona;
	private JComboBox<String> comboBoxNombreOrganizacionPersona;
	private JLabel lblValorPersona;
	private JLabel lblResponsablePersona;
	private JComboBox<String> comboBoxResponsablePersona;
	private JLabel lblFechaCierrePersona;
	private JLabel lblEstadoPersona;
	private JComboBox<String> comboBoxEstadoPersona;
	private JButton btnVolverPersona;
	private JButton btnAgregarActualizarPersona;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionPrincipal window = new GestionPrincipal();
					window.frameSistemaGestion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {	
		sistema = new SistemaBusinessFacade();
		
		for(int contador = 0; contador < 1; contador ++)
		{
			sistema.agregarNegocio(	"Título negocio " + contador,
									"Descripción negocio " + contador,
									"ORGANIZACIONPRUEBAAGREGADA",
									(double) 1000 + contador,
									"PERSONAPRUEBAAGREGADA",
									"1-ene-2015 " + contador,
									Negocio.PENDIENTE);	
		}
		//listaNegocios = sistema.listarNegocios();
		//
		
		frameSistemaGestion = new JFrame();
		//100, 100, 250, 250
		frameSistemaGestion.setBounds(100, 100, 1000, 1000);
		frameSistemaGestion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frameSistemaGestion.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelAplicacion = new JPanel();
		frameSistemaGestion.getContentPane().add(panelAplicacion);
		panelAplicacion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 8));
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Opciones del sistema", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelAplicacion.add(panelPrincipal);
		panelPrincipal.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnAdministrarNegocios = new JButton("Administrar Negocios");
		panelPrincipal.add(btnAdministrarNegocios);
		btnAdministrarNegocios.setActionCommand("Siguiente");
		
		btnAdministrarOrganizaciones = new JButton("Administrar Organizaciones");
		panelPrincipal.add(btnAdministrarOrganizaciones);
		
		btnAdministrarPersonas = new JButton("Administrar Personas");

		panelPrincipal.add(btnAdministrarPersonas);
		
		btnAdministrarActividades = new JButton("Administrar Actividades");
		panelPrincipal.add(btnAdministrarActividades);
		
		frameSistemaGestion.pack();
		
		panelNegocios = new JPanel();
		panelAplicacion.add(panelNegocios);
		panelNegocios.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Administraci\u00F3n de Negocios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNegocios.setLayout(new GridLayout(0, 1, 0, 0));
		panelNegocios.setVisible(Boolean.FALSE);
		
		lblListaNegocios = new JLabel("Lista de negocios");
		panelNegocios.add(lblListaNegocios);
		
		comboBoxListaNegocios = new JComboBox<String>();
		panelNegocios.add(comboBoxListaNegocios);
		
		btnDetalleNegocio = new JButton("Detalle Negocio");

		panelNegocios.add(btnDetalleNegocio);
		
		btnEliminarNegocio = new JButton("Eliminar Negocio");

		panelNegocios.add(btnEliminarNegocio);
		
		btnAgregarNegocio = new JButton("Agregar Negocio");

		panelNegocios.add(btnAgregarNegocio);
		
		btnVolverPrincipal = new JButton("Volver al Menú principal");
		panelNegocios.add(btnVolverPrincipal);
		btnVolverPrincipal.setActionCommand("Anterior");
		
		panelDetalleNegocio = new JPanel();
		panelDetalleNegocio.setBorder(new TitledBorder(null, "Detalle Negocio", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAplicacion.add(panelDetalleNegocio);
		panelDetalleNegocio.setVisible(Boolean.FALSE);
		panelDetalleNegocio.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblCodigoNegocio = new JLabel("Código:");
		panelDetalleNegocio.add(lblCodigoNegocio, "2, 2, left, default");
		
		textCodigoNegocio = new JTextField();
		textCodigoNegocio.setEnabled(false);
		textCodigoNegocio.setEditable(false);
		panelDetalleNegocio.add(textCodigoNegocio, "4, 2, fill, default");
		textCodigoNegocio.setColumns(10);
		
		lblTituloNegocio = new JLabel("Título:");
		panelDetalleNegocio.add(lblTituloNegocio, "2, 4, left, default");
		
		textTituloNegocio = new JTextField();
		panelDetalleNegocio.add(textTituloNegocio, "4, 4, fill, default");
		textTituloNegocio.setColumns(10);
		
		lblDescripcionNegocio = new JLabel("Descripción:");
		panelDetalleNegocio.add(lblDescripcionNegocio, "2, 6, left, default");
		
		textDescripcionNegocio = new JTextField();
		panelDetalleNegocio.add(textDescripcionNegocio, "4, 6, fill, default");
		textDescripcionNegocio.setColumns(10);
		
		lblNombreOrganizacionNegocio = new JLabel("Nombre organización:");
		panelDetalleNegocio.add(lblNombreOrganizacionNegocio, "2, 8, right, default");
		
		comboBoxNombreOrganizacionNegocio = new JComboBox<String>();
		panelDetalleNegocio.add(comboBoxNombreOrganizacionNegocio, "4, 8, fill, default");
		
		lblValorNegocio = new JLabel("Valor:");
		panelDetalleNegocio.add(lblValorNegocio, "2, 10, left, default");
		
		textValorNegocio = new JTextField();
		panelDetalleNegocio.add(textValorNegocio, "4, 10, fill, default");
		textValorNegocio.setColumns(10);
		
		lblResponsableNegocio = new JLabel("Responsable:");
		panelDetalleNegocio.add(lblResponsableNegocio, "2, 12, left, default");
		
		comboBoxResponsableNegocio = new JComboBox<String>();
		panelDetalleNegocio.add(comboBoxResponsableNegocio, "4, 12, fill, default");
		
		lblFechaCierreNegocio = new JLabel("Fecha cierre:");
		panelDetalleNegocio.add(lblFechaCierreNegocio, "2, 14, left, default");
		
		textFechaCierreNegocio = new JTextField();
		panelDetalleNegocio.add(textFechaCierreNegocio, "4, 14, fill, default");
		textFechaCierreNegocio.setColumns(10);
		
		lblEstadoNegocio = new JLabel("Estado:");
		panelDetalleNegocio.add(lblEstadoNegocio, "2, 16, left, default");
		
		comboBoxEstadoNegocio = new JComboBox<String>();
		panelDetalleNegocio.add(comboBoxEstadoNegocio, "4, 16, fill, default");

		comboBoxEstadoNegocio.addItem("PENDIENTE");
		comboBoxEstadoNegocio.addItem("ENEJECUCION");
		comboBoxEstadoNegocio.addItem("CERRADO");
		
		btnVolver = new JButton("Volver");

		panelDetalleNegocio.add(btnVolver, "2, 18");
		
		btnAgregarActualizar = new JButton("Agregar / Actualizar");
		btnAgregarActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				Negocio negocioSeleccionado;
				
				if(btnAgregarActualizar.getText().equalsIgnoreCase("Actualizar"))
				{
					negocioSeleccionado = (Negocio) sistema.getListaNegocios().consultarNodo(textCodigoNegocio.getText()).getBusinessObject();
				}
				else
				{
					negocioSeleccionado = new Negocio("", "", "", 0, "");
				}
				
				negocioSeleccionado.setTituloNegocio(textTituloNegocio.getText());
				negocioSeleccionado.setDescripcionNegocio(textDescripcionNegocio.getText());
				//TODO - negocioSeleccionado.setCodigoOrganizacion(codigoNombreOrganizacion);
				negocioSeleccionado.setValorNegocio(Double.parseDouble(textValorNegocio.getText()));
				negocioSeleccionado.setFechaCierreNegocio(textFechaCierreNegocio.getText());
				negocioSeleccionado.setEstadoNegocio(comboBoxEstadoNegocio.getSelectedIndex());
				
				
				//TODO - ajustar consultar nodo para que no reciba sino solamente el codigo del objeto y no con su descripcion
				//TODO - ajustar para que los métodos de actualización y adición de negocio reciban los códigos de persona y organización elegidos
				sistema.getListaNegocios().consultarNodo(textCodigoNegocio.getText()).setBusinessObject(negocioSeleccionado);
				*/
				if(btnAgregarActualizar.getText().equalsIgnoreCase("Actualizar"))
				{
					sistema.actualizarNegocio(	textCodigoNegocio.getText(),
												textTituloNegocio.getText(),
												textDescripcionNegocio.getText(),
												"ORGANIZACIONPRUEBAACTUALIZADA",
												Double.parseDouble(textValorNegocio.getText()),
												"PERSONAPRUEBAAGREGADA",
												textFechaCierreNegocio.getText(),
												comboBoxEstadoNegocio.getSelectedIndex());
					
					JOptionPane.showMessageDialog(null,
							"Ítem actualizado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					sistema.agregarNegocio(	textTituloNegocio.getText(),
											textDescripcionNegocio.getText(),
											"ORGANIZACIONPRUEBAAGREGADA",
											Double.parseDouble(textValorNegocio.getText()),
											"PERSONAPRUEBAAGREGADA",
											textFechaCierreNegocio.getText(),
											comboBoxEstadoNegocio.getSelectedIndex());
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				//TODO - Solucionar tema cuando se actualiza el campo de descripción del objeto y se requiere actualizar los ítems de a lista
				//comboBoxListaNegocios.set
				actualizarListaNegocios();
				
				
				if(sistema.getListaNegocios().getNumeroNodos() > 0)
				{
					btnEliminarNegocio.setEnabled(Boolean.TRUE);
					btnDetalleNegocio.setEnabled(Boolean.TRUE);
				}
			}
		});
		panelDetalleNegocio.add(btnAgregarActualizar, "4, 18");
		
		btnVolverPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelPrincipal.setVisible(Boolean.TRUE);
				panelNegocios.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnAdministrarNegocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelNegocios.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnDetalleNegocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizar.setText("Actualizar");
				
				String itemNegocioElegido = comboBoxListaNegocios.getSelectedItem().toString();
				//TODO - Ajustar para consultar por código más no por código Nombre
				Negocio negocioElegido = sistema.consultarNegocioPorCodigoNombre(itemNegocioElegido);
				
				textCodigoNegocio.setText(negocioElegido.getCodigoNegocio());
				textTituloNegocio.setText(negocioElegido.getTituloNegocio());
				textDescripcionNegocio.setText(negocioElegido.getDescripcionNegocio());
				textValorNegocio.setText(Double.toString(negocioElegido.getValorNegocio()));
				//comboBoxResponsableNegocio.setSelectedIndex()
				textFechaCierreNegocio.setText(negocioElegido.getFechaCierreNegocio());
				
				switch(negocioElegido.getEstadoNegocio())
				{
					case Negocio.PENDIENTE:
						comboBoxEstadoNegocio.setSelectedIndex(0);
						break;
					case Negocio.ENEJECUCION:
						comboBoxEstadoNegocio.setSelectedIndex(1);
						break;
					case Negocio.CERRADO:
						comboBoxEstadoNegocio.setSelectedIndex(2);
						break;
				}
				
				panelNegocios.setVisible(Boolean.FALSE);
				panelDetalleNegocio.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
				
				
			}
		});
		
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigoNegocio.setVisible(Boolean.TRUE);
				lblCodigoNegocio.setVisible(Boolean.TRUE);
				
				textTituloNegocio.setText("");
				textDescripcionNegocio.setText("");
				textValorNegocio.setText(Double.toString(0));
				textFechaCierreNegocio.setText("1-oct-2015");
				comboBoxEstadoNegocio.setSelectedIndex(0);
				
				panelNegocios.setVisible(Boolean.TRUE);
				panelDetalleNegocio.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnEliminarNegocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemNegocioElegido = comboBoxListaNegocios.getSelectedItem().toString();
				int respuestaSeleccionada = 0;
				//TODO - Ajustar para consultar por código más no por código Nombre
				Negocio negocioElegido = sistema.consultarNegocioPorCodigoNombre(itemNegocioElegido);
				
				respuestaSeleccionada = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea eliminar el Negocio " + negocioElegido.getCodigoObjeto() + "-" + negocioElegido.getDescripcionObjeto() + "?",
						"Mensaje de confirmación",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(respuestaSeleccionada == 0)
				{
					sistema.getListaNegocios().eliminarNodo(itemNegocioElegido);
					
					JOptionPane.showMessageDialog(null,
							"Ítem eliminado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
					
					actualizarListaNegocios();
				}
				
				if(sistema.getListaNegocios().getNumeroNodos() == 0)
				{
					btnEliminarNegocio.setEnabled(Boolean.FALSE);
					btnDetalleNegocio.setEnabled(Boolean.FALSE);
				}
			}
		});
		
		btnAgregarNegocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizar.setText("Agregar");			
				
				textCodigoNegocio.setVisible(Boolean.FALSE);
				lblCodigoNegocio.setVisible(Boolean.FALSE);
				panelNegocios.setVisible(Boolean.FALSE);
				panelDetalleNegocio.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
			}
		});
		
		//Panel de Personas
		panelPersonas = new JPanel();
		panelAplicacion.add(panelPersonas);
		panelPersonas.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Administración de Personas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelPersonas.setLayout(new GridLayout(0, 1, 0, 0));
		panelPersonas.setVisible(Boolean.FALSE);
		
		lblListaPersonas = new JLabel("Lista de personas");
		panelPersonas.add(lblListaPersonas);
		
		comboBoxListaPersonas = new JComboBox<String>();
		panelPersonas.add(comboBoxListaPersonas);
		
		btnDetallePersona = new JButton("Detalle Persona");

		panelPersonas.add(btnDetallePersona);
		
		btnEliminarPersona = new JButton("Eliminar Persona");

		panelPersonas.add(btnEliminarPersona);
		
		btnAgregarPersona = new JButton("Agregar Persona");

		panelPersonas.add(btnAgregarPersona);
		
		btnVolverPrincipalPersona = new JButton("Volver al Menú principal");

		panelPersonas.add(btnVolverPrincipalPersona);
		btnVolverPrincipalPersona.setActionCommand("Anterior");
		
		panelDetallePersona = new JPanel();
		panelDetallePersona.setBorder(new TitledBorder(null, "Detalle Persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAplicacion.add(panelDetallePersona);
		panelDetallePersona.setVisible(Boolean.FALSE);
		panelDetallePersona.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblCodigoPersona = new JLabel("Código:");
		panelDetallePersona.add(lblCodigoPersona, "2, 2, left, default");
		
		textCodigoPersona = new JTextField();
		textCodigoPersona.setEnabled(false);
		textCodigoPersona.setEditable(false);
		panelDetallePersona.add(textCodigoPersona, "4, 2, fill, default");
		textCodigoPersona.setColumns(10);
		
		lblTituloPersona = new JLabel("Título:");
		panelDetallePersona.add(lblTituloPersona, "2, 4, left, default");
		
		textTituloPersona = new JTextField();
		panelDetallePersona.add(textTituloPersona, "4, 4, fill, default");
		textTituloPersona.setColumns(10);
		
		lblDescripcionPersona = new JLabel("Descripción:");
		panelDetallePersona.add(lblDescripcionPersona, "2, 6, left, default");
		
		textDescripcionPersona = new JTextField();
		panelDetallePersona.add(textDescripcionPersona, "4, 6, fill, default");
		textDescripcionPersona.setColumns(10);
		
		lblNombreOrganizacionPersona = new JLabel("Nombre organización:");
		panelDetallePersona.add(lblNombreOrganizacionPersona, "2, 8, right, default");
		
		comboBoxNombreOrganizacionPersona = new JComboBox<String>();
		panelDetallePersona.add(comboBoxNombreOrganizacionPersona, "4, 8, fill, default");
		
		lblValorPersona = new JLabel("Valor:");
		panelDetallePersona.add(lblValorPersona, "2, 10, left, default");
		
		textValorPersona = new JTextField();
		panelDetallePersona.add(textValorPersona, "4, 10, fill, default");
		textValorPersona.setColumns(10);
		
		lblResponsablePersona = new JLabel("Responsable:");
		panelDetallePersona.add(lblResponsablePersona, "2, 12, left, default");
		
		comboBoxResponsablePersona = new JComboBox<String>();
		panelDetallePersona.add(comboBoxResponsablePersona, "4, 12, fill, default");
		
		lblFechaCierrePersona = new JLabel("Fecha cierre:");
		panelDetallePersona.add(lblFechaCierrePersona, "2, 14, left, default");
		
		textFechaCierrePersona = new JTextField();
		panelDetallePersona.add(textFechaCierrePersona, "4, 14, fill, default");
		textFechaCierrePersona.setColumns(10);
		
		lblEstadoPersona = new JLabel("Estado:");
		panelDetallePersona.add(lblEstadoPersona, "2, 16, left, default");
		
		comboBoxEstadoPersona = new JComboBox<String>();
		panelDetallePersona.add(comboBoxEstadoPersona, "4, 16, fill, default");

		comboBoxEstadoPersona.addItem("PENDIENTE");
		comboBoxEstadoPersona.addItem("ENEJECUCION");
		comboBoxEstadoPersona.addItem("CERRADO");
		
		btnVolverPersona = new JButton("Volver");

		panelDetallePersona.add(btnVolverPersona, "2, 18");
		
		btnAgregarActualizarPersona = new JButton("Agregar / Actualizar");
		
		btnAdministrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelPersonas.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverPrincipalPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelPrincipal.setVisible(Boolean.TRUE);
				panelPersonas.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		//Fin Panel de Personas
		
		
		
		
		actualizarListaNegocios();
	}
	
	public void actualizarListaNegocios()
	{
		comboBoxListaNegocios.removeAllItems();

		ArrayList<String> listaNegocios = sistema.listarNegocios();
		
		if(listaNegocios != null)
		{
			for(int contador = 0; contador < listaNegocios.size(); contador ++)
			{
				comboBoxListaNegocios.addItem(listaNegocios.get(contador));
			}
		}
	}
}
