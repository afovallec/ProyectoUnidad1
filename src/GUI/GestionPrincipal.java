package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Business.Negocio;
import Business.Persona;
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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GestionPrincipal {
	final static String ITEMDEFECTOLISTAS = "Seleccione ...";
	
	
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
	private JComboBox<String> comboBoxTipoDocumentoPersona;
	private JTextField textNumeroDocumentoPersona;
	private JTextField textTelefonoPersona;
	private JLabel lblListaPersonas;
	private JComboBox<String> comboBoxListaPersonas;
	private JButton btnDetallePersona;
	private JButton btnEliminarPersona;
	private JButton btnAgregarPersona;
	private JButton btnVolverPrincipalPersona;
	private JPanel panelDetallePersona;
	private JLabel lblCodigoPersona;
	private JLabel lblTipoDocumentoPersona;
	private JLabel lblNumeroDocumentoPersona;
	private JLabel lblNombresPersona;
	private JTextField textNombresPersona;
	private JLabel lblTelefonoPersona;
	private JLabel lblEmailPersona;
	private JTextField textEmailPersona;
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
		
		for(int contador = 0; contador < 3; contador ++)
		{
			sistema.agregarNegocio(	"Título negocio " + contador,
									"Descripción negocio " + contador,
									"",
									(double) 1000 + contador,
									"",
									"1-ene-2015 " + contador,
									Negocio.PENDIENTE);	
		}
		
		for(int contador = 0; contador < 3; contador ++)
		{
			sistema.agregarPersona(	Persona.CEDULA,
									"999999" + contador,
									"Persona" + contador + "Apellido" + contador,
									"222333" + contador,
									"persona" + contador + "@g.com");
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
		
		//Panel de Negocios
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
		panelDetalleNegocio.add(btnAgregarActualizar, "4, 18");
		
		comboBoxListaNegocios.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxListaNegocios.getSelectedItem() != null)
				{
					if(comboBoxListaNegocios.getSelectedItem().toString().equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					{
						btnDetalleNegocio.setEnabled(Boolean.FALSE);
						btnEliminarNegocio.setEnabled(Boolean.FALSE);
					}
					else
					{
						btnDetalleNegocio.setEnabled(Boolean.TRUE);
						btnEliminarNegocio.setEnabled(Boolean.TRUE);
						actualizarListaPersonas(comboBoxResponsableNegocio);
					}
				}
				else
				{
					btnDetalleNegocio.setEnabled(Boolean.FALSE);
					btnEliminarNegocio.setEnabled(Boolean.FALSE);
				}
			}
		});
		
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
				String codigoPersonaElegida = comboBoxResponsableNegocio.getSelectedItem().toString();
				String codigoPersonaActualizada = "";
				
				if(!codigoPersonaElegida.equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					codigoPersonaActualizada = sistema.getListaPersonas().consultarNodoCodigoNombre(codigoPersonaElegida).getBusinessObject().getCodigoObjeto();
				
				if(btnAgregarActualizar.getText().equalsIgnoreCase("Actualizar"))
				{	
					sistema.actualizarNegocio(	textCodigoNegocio.getText(),
												textTituloNegocio.getText(),
												textDescripcionNegocio.getText(),
												"ORGANIZACIONPRUEBAACTUALIZADA",
												Double.parseDouble(textValorNegocio.getText()),
												codigoPersonaActualizada,
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
											codigoPersonaActualizada,
											textFechaCierreNegocio.getText(),
											comboBoxEstadoNegocio.getSelectedIndex());
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				//TODO - Solucionar tema cuando se actualiza el campo de descripción del objeto y se requiere actualizar los ítems de a lista
				//comboBoxListaNegocios.set				
				
				if(sistema.getListaNegocios().getNumeroNodos() > 0)
				{
					btnEliminarNegocio.setEnabled(Boolean.TRUE);
					btnDetalleNegocio.setEnabled(Boolean.TRUE);
				}
			}
		});
		
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
				textFechaCierreNegocio.setText(negocioElegido.getFechaCierreNegocio());
				
				if(negocioElegido.getCodigoPersona().equalsIgnoreCase(""))
					comboBoxResponsableNegocio.setSelectedIndex(0);
				else
				{		
					if(sistema.getListaPersonas().existeNodoPorCodigo(negocioElegido.getCodigoPersona()))
						comboBoxResponsableNegocio.setSelectedItem(	(String) sistema.getListaPersonas().consultarNodo((String) negocioElegido.getCodigoPersona()).getBusinessObject().getCodigoObjeto() + "-" +
																sistema.getListaPersonas().consultarNodo((String) negocioElegido.getCodigoPersona()).getBusinessObject().getDescripcionObjeto());
					else
						comboBoxResponsableNegocio.setSelectedIndex(0);
				}
				
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
				
				actualizarListaNegocios();
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
		//Fin Panel de Negocios		
		
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
		btnEliminarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemPersonaElegida = comboBoxListaPersonas.getSelectedItem().toString();
				int respuestaSeleccionada = 0;
				
				Persona personaElegida = sistema.consultarPersonaPorCodigoNombre(itemPersonaElegida);
				
				respuestaSeleccionada = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea eliminar la Persona " + personaElegida.getCodigoObjeto() + "-" + personaElegida.getDescripcionObjeto() + "?",
						"Mensaje de confirmación",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(respuestaSeleccionada == 0)
				{
					sistema.getListaPersonas().eliminarNodo(itemPersonaElegida);
					
					JOptionPane.showMessageDialog(null,
							"Ítem eliminado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
					
					actualizarListaPersonas(comboBoxListaPersonas);
				}
				
				if(sistema.getListaPersonas().getNumeroNodos() == 0)
				{
					btnEliminarPersona.setEnabled(Boolean.FALSE);
					btnDetallePersona.setEnabled(Boolean.FALSE);
				}
			}
		});

		panelPersonas.add(btnEliminarPersona);
		
		btnAgregarPersona = new JButton("Agregar Persona");
		btnAgregarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarPersona.setText("Agregar");			
				
				textCodigoPersona.setVisible(Boolean.FALSE);
				lblCodigoPersona.setVisible(Boolean.FALSE);
				panelPersonas.setVisible(Boolean.FALSE);
				panelDetallePersona.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
			}
		});

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
		
		lblTipoDocumentoPersona = new JLabel("Tipo de documento:");
		panelDetallePersona.add(lblTipoDocumentoPersona, "2, 4, left, default");
		
		comboBoxTipoDocumentoPersona = new JComboBox<String>();
		panelDetallePersona.add(comboBoxTipoDocumentoPersona, "4, 4, fill, default");

		comboBoxTipoDocumentoPersona.addItem("CC");
		comboBoxTipoDocumentoPersona.addItem("TI");
		comboBoxTipoDocumentoPersona.addItem("NIT");
		
		lblNumeroDocumentoPersona = new JLabel("Número de documento:");
		panelDetallePersona.add(lblNumeroDocumentoPersona, "2, 6, left, default");
		
		textNumeroDocumentoPersona = new JTextField();
		panelDetallePersona.add(textNumeroDocumentoPersona, "4, 6, fill, default");
		textNumeroDocumentoPersona.setColumns(10);
		
		lblNombresPersona = new JLabel("Nombres y apellidos:");
		panelDetallePersona.add(lblNombresPersona, "2, 8, left, default");
		
		textNombresPersona = new JTextField();
		panelDetallePersona.add(textNombresPersona, "4, 8, fill, default");
		
		lblTelefonoPersona = new JLabel("Teléfono:");
		panelDetallePersona.add(lblTelefonoPersona, "2, 10, left, default");
		
		textTelefonoPersona = new JTextField();
		panelDetallePersona.add(textTelefonoPersona, "4, 10, fill, default");
		textTelefonoPersona.setColumns(10);
		
		lblEmailPersona = new JLabel("e-Mail:");
		panelDetallePersona.add(lblEmailPersona, "2, 12, left, default");
		
		textEmailPersona = new JTextField();
		panelDetallePersona.add(textEmailPersona, "4, 12, fill, default");
		
		btnVolverPersona = new JButton("Volver");

		panelDetallePersona.add(btnVolverPersona, "2, 18");
		
		btnAgregarActualizarPersona = new JButton("Agregar / Actualizar");

		panelDetallePersona.add(btnAgregarActualizarPersona, "4, 18");
		
		comboBoxListaPersonas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxListaPersonas.getSelectedItem() != null)
				{
					if(comboBoxListaPersonas.getSelectedItem().toString().equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					{
						btnDetallePersona.setEnabled(Boolean.FALSE);
						btnEliminarPersona.setEnabled(Boolean.FALSE);
					}
					else
					{
						btnDetallePersona.setEnabled(Boolean.TRUE);
						btnEliminarPersona.setEnabled(Boolean.TRUE);
					}
				}
				else
				{
					btnDetallePersona.setEnabled(Boolean.FALSE);
					btnEliminarPersona.setEnabled(Boolean.FALSE);
				}
			}
		});
		
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
		
		btnVolverPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigoPersona.setVisible(Boolean.TRUE);
				lblCodigoPersona.setVisible(Boolean.TRUE);
				
				comboBoxTipoDocumentoPersona.setSelectedIndex(0);
				textNumeroDocumentoPersona.setText("");
				textNombresPersona.setText("");
				textTelefonoPersona.setText("");
				textEmailPersona.setText("");
				
				
				panelPersonas.setVisible(Boolean.TRUE);
				panelDetallePersona.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
				
				actualizarListaPersonas(comboBoxListaPersonas);
			}
		});
		
		btnDetallePersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarPersona.setText("Actualizar");
				
				String itemPersonaElegida = comboBoxListaPersonas.getSelectedItem().toString();
				Persona personaElegida = sistema.consultarPersonaPorCodigoNombre(itemPersonaElegida);
				
				textCodigoPersona.setText(personaElegida.getCodigoPersona());
				//comboBoxTipoDocumentoPersona.setText(negocioElegido.getTituloNegocio());
				textNumeroDocumentoPersona.setText(personaElegida.getNumeroDocumentoPersona());
				textNombresPersona.setText(personaElegida.getNombrePersona());
				//comboBoxResponsableNegocio.setSelectedIndex()
				textTelefonoPersona.setText(personaElegida.getTelefonoPersona());
				textEmailPersona.setText(personaElegida.getEmailPersona());
				
				switch(personaElegida.getTipoDocumentoPersona())
				{
					case Persona.CEDULA:
						comboBoxTipoDocumentoPersona.setSelectedIndex(0);
						break;
					case Persona.TARJETAIDENTIDAD:
						comboBoxTipoDocumentoPersona.setSelectedIndex(1);
						break;
					case Persona.NIT:
						comboBoxTipoDocumentoPersona.setSelectedIndex(2);
						break;
				}
				
				panelPersonas.setVisible(Boolean.FALSE);
				panelDetallePersona.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
				
				actualizarListaPersonas(comboBoxResponsableNegocio);
				actualizarListaPersonas(comboBoxListaPersonas);
			}
		});
		
		btnAgregarActualizarPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAgregarActualizarPersona.getText().equalsIgnoreCase("Actualizar"))
				{
					sistema.actualizarPersona(	textCodigoPersona.getText(),
												comboBoxTipoDocumentoPersona.getSelectedIndex(),
												textNumeroDocumentoPersona.getText(),
												textNombresPersona.getText(),
												textTelefonoPersona.getText(),
												textEmailPersona.getText());
					
					JOptionPane.showMessageDialog(null,
							"Ítem actualizado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					sistema.agregarPersona(	comboBoxTipoDocumentoPersona.getSelectedIndex(),
											textNumeroDocumentoPersona.getText(),
											textNombresPersona.getText(),
											textTelefonoPersona.getText(),
											textEmailPersona.getText());
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(sistema.getListaPersonas().getNumeroNodos() > 0)
				{
					btnEliminarPersona.setEnabled(Boolean.TRUE);
					btnDetallePersona.setEnabled(Boolean.TRUE);
				}
			}
		});
		//Fin Panel de Personas
		
		actualizarListaPersonas(comboBoxResponsableNegocio);
		actualizarListaPersonas(comboBoxListaPersonas);
		
		actualizarListaNegocios();
	}
	
	public void actualizarListaNegocios()
	{
		comboBoxListaNegocios.removeAllItems();

		ArrayList<String> listaNegocios = sistema.listarNegocios();
		
		if(listaNegocios != null)
		{
			comboBoxListaNegocios.addItem(GestionPrincipal.ITEMDEFECTOLISTAS);
			for(int contador = 0; contador < listaNegocios.size(); contador ++)
			{
				comboBoxListaNegocios.addItem(listaNegocios.get(contador));
			}
		}
	}
	
	public void actualizarListaPersonas(JComboBox<String> comboBoxListaPersonasGeneral)
	{
		comboBoxListaPersonasGeneral.removeAllItems();

		ArrayList<String> listaPersonas = sistema.listarPersonas();
		
		if(listaPersonas != null)
		{
			comboBoxListaPersonasGeneral.addItem(GestionPrincipal.ITEMDEFECTOLISTAS);
			for(int contador = 0; contador < listaPersonas.size(); contador ++)
			{
				comboBoxListaPersonasGeneral.addItem(listaPersonas.get(contador));
			}
		}
	}
}
