package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Business.Actividad;
import Business.Negocio;
import Business.Organizacion;
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
	public final static String ITEMDEFECTOLISTAS = "Seleccione ...";
	
	
	private SistemaBusinessFacade sistema;
	//private ArrayList<String> listaNegocios;
	
	private JFrame frameSistemaGestion;

	
	private JPanel panelAplicacion;
	private JPanel panelPrincipal;
	private JPanel panelNegocios;
	private JPanel panelPersonas;
	private JPanel panelOrganizaciones;
	private JPanel panelActividades;
	
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
	
	private JTextField textCodigoOrganizacion;
	private JTextField textNitOrganizacion;
	private JTextField textNombreOrganizacion;
	private JTextField textTelefonoOrganizacion;
	private JLabel lblListaOrganizacion;
	private JComboBox<String> comboBoxListaOrganizacion;
	private JButton btnDetalleOrganizacion;
	private JButton btnEliminarOrganizacion;
	private JButton btnAgregarOrganizacion;
	private JButton btnVolverPrincipalOrganizacion;
	private JPanel panelDetalleOrganizacion;
	private JLabel lblCodigoOrganizacion;
	private JLabel lblNitOrganizacion;
	private JLabel lblNombreOrganizacion;
	private JLabel lblDireccionOrganizacion;
	private JTextField textDireccionOrganizacion;
	private JLabel lblTelefonoOrganizacion;
	private JButton btnVolverOrganizacion;
	private JButton btnAgregarActualizarOrganizacion;
	
	private JTextField textCodigoActividad;
	private JTextField textDescripcionActividad;
	private JComboBox<String> comboBoxTipoActividad;
	private JTextField textHoraInicioActividad;
	private JLabel lblListaActividad;
	private JComboBox<String> comboBoxListaActividad;
	private JButton btnDetalleActividad;
	private JButton btnEliminarActividad;
	private JButton btnAgregarActividad;
	private JButton btnVolverPrincipalActividad;
	private JPanel panelDetalleActividad;
	private JLabel lblCodigoActividad;
	private JLabel lblDescripcionActividad;
	private JLabel lblTipoActividad;
	private JLabel lblFechaInicioActividad;
	private JTextField textFechaInicioActividad;
	private JLabel lblHoraInicioActividad;
	private JButton btnVolverActividad;
	private JButton btnAgregarActualizarActividad;
	private JLabel lblNegocioActividad;
	private JComboBox<String> comboBoxNegocioActividad;
	private JLabel lblOrganizacionActividad;
	private JComboBox<String> comboBoxOrganizacionActividad;
	private JLabel lblResponsableActividad;
	private JComboBox<String> comboBoxResponsableActividad;
	private JLabel lblDuracionActividad;
	private JTextField textDuracionActividad;

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
		
		for(int contador = 0; contador < 3; contador ++)
		{
			sistema.agregarOrganizacion(	"8899777-" + contador,
											"Corporación " + contador,
											"Calle 8 #5-" + contador,
											"227071" + contador);
		}
		
		for(int contador = 0; contador < 3; contador ++)
		{
			sistema.agregarActividad(	"Actividad " + contador,
										Actividad.ADMINISTRATIVA,
										contador + "-oct-2015",
										contador + ":00 Pm",
										contador + " Horas",
										"",
										"",
										"");
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

		//Panel de Actividades
		panelActividades = new JPanel();
		panelAplicacion.add(panelActividades);
		panelActividades.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Administración de Actividades", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelActividades.setLayout(new GridLayout(0, 1, 0, 0));
		panelActividades.setVisible(Boolean.FALSE);
		
		lblListaActividad = new JLabel("Lista de actividades");
		panelActividades.add(lblListaActividad);
		
		comboBoxListaActividad = new JComboBox<String>();
		panelActividades.add(comboBoxListaActividad);
		
		btnDetalleActividad = new JButton("Detalle Actividad");

		panelActividades.add(btnDetalleActividad);
		
		btnEliminarActividad = new JButton("Eliminar Actividad");
		
		btnAdministrarActividades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelActividades.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnEliminarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemActividadElegida = comboBoxListaActividad.getSelectedItem().toString();
				int respuestaSeleccionada = 0;
				
				Actividad actividadElegida = sistema.consultarActividadPorCodigoNombre(itemActividadElegida);
				
				respuestaSeleccionada = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea eliminar la Actividad " + actividadElegida.getCodigoObjeto() + "-" + actividadElegida.getDescripcionObjeto() + "?",
						"Mensaje de confirmación",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(respuestaSeleccionada == 0)
				{
					sistema.getListaActividades().eliminarNodo(itemActividadElegida);
					
					JOptionPane.showMessageDialog(null,
							"Ítem eliminado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
					
					actualizarListaActividades();
				}
				
				if(sistema.getListaOrganizaciones().getNumeroNodos() == 0)
				{
					btnEliminarActividad.setEnabled(Boolean.FALSE);
					btnDetalleActividad.setEnabled(Boolean.FALSE);
				}
			}
		});

		panelActividades.add(btnEliminarActividad);
		
		btnAgregarActividad = new JButton("Agregar Actividad");
		btnAgregarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarActividad.setText("Agregar");			
				
				textCodigoActividad.setVisible(Boolean.FALSE);
				lblCodigoActividad.setVisible(Boolean.FALSE);
				panelActividades.setVisible(Boolean.FALSE);
				panelDetalleActividad.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
			}
		});

		panelActividades.add(btnAgregarActividad);
		
		btnVolverPrincipalActividad = new JButton("Volver al Menú principal");

		panelActividades.add(btnVolverPrincipalActividad);
		btnVolverPrincipalActividad.setActionCommand("Anterior");
		
		panelDetalleActividad = new JPanel();
		panelDetalleActividad.setBorder(new TitledBorder(null, "Detalle Actividad", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAplicacion.add(panelDetalleActividad);
		panelDetalleActividad.setVisible(Boolean.FALSE);
		panelDetalleActividad.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblCodigoActividad = new JLabel("Código:");
		panelDetalleActividad.add(lblCodigoActividad, "2, 2, left, default");
		
		textCodigoActividad = new JTextField();
		textCodigoActividad.setEnabled(false);
		textCodigoActividad.setEditable(false);
		panelDetalleActividad.add(textCodigoActividad, "4, 2, fill, default");
		textCodigoActividad.setColumns(10);
		
		lblDescripcionActividad = new JLabel("Descripción:");
		panelDetalleActividad.add(lblDescripcionActividad, "2, 4, left, default");
		
		textDescripcionActividad = new JTextField();
		panelDetalleActividad.add(textDescripcionActividad, "4, 4, fill, default");
		
		lblTipoActividad = new JLabel("Tipo actividad:");
		panelDetalleActividad.add(lblTipoActividad, "2, 6, left, default");
		
		comboBoxTipoActividad = new JComboBox<String>();
		panelDetalleActividad.add(comboBoxTipoActividad, "4, 6, fill, default");
		
		comboBoxTipoActividad.addItem("ADMINISTRATIVA");
		comboBoxTipoActividad.addItem("NEGOCIO");
		
		lblFechaInicioActividad = new JLabel("Fecha inicio:");
		panelDetalleActividad.add(lblFechaInicioActividad, "2, 8, left, default");
		
		textFechaInicioActividad = new JTextField();
		panelDetalleActividad.add(textFechaInicioActividad, "4, 8, fill, default");
		
		lblHoraInicioActividad = new JLabel("Hora inicio:");
		panelDetalleActividad.add(lblHoraInicioActividad, "2, 10, left, default");
		
		textHoraInicioActividad = new JTextField();
		panelDetalleActividad.add(textHoraInicioActividad, "4, 10, fill, default");
		textHoraInicioActividad.setColumns(10);
		
		lblDuracionActividad = new JLabel("Duración:");
		panelDetalleActividad.add(lblDuracionActividad, "2, 12, left, default");
		
		textDuracionActividad = new JTextField();
		textDuracionActividad.setColumns(10);
		panelDetalleActividad.add(textDuracionActividad, "4, 12, fill, default");
		
		lblResponsableActividad = new JLabel("Persona responsable:");
		panelDetalleActividad.add(lblResponsableActividad, "2, 14, left, default");
		
		comboBoxResponsableActividad = new JComboBox<String>();
		panelDetalleActividad.add(comboBoxResponsableActividad, "4, 14, fill, default");
		
		lblOrganizacionActividad = new JLabel("Organización responsable:");
		panelDetalleActividad.add(lblOrganizacionActividad, "2, 16, right, default");
		
		comboBoxOrganizacionActividad = new JComboBox<String>();
		panelDetalleActividad.add(comboBoxOrganizacionActividad, "4, 16, fill, default");
		
		lblNegocioActividad = new JLabel("Negocio padre:");
		panelDetalleActividad.add(lblNegocioActividad, "2, 18, left, default");
		
		comboBoxNegocioActividad = new JComboBox<String>();
		panelDetalleActividad.add(comboBoxNegocioActividad, "4, 18, fill, default");
		
		btnVolverActividad = new JButton("Volver");

		panelDetalleActividad.add(btnVolverActividad, "2, 20");
		
		btnAgregarActualizarActividad = new JButton("Agregar / Actualizar");

		panelDetalleActividad.add(btnAgregarActualizarActividad, "4, 20");
		
		comboBoxListaActividad.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxListaActividad.getSelectedItem() != null)
				{
					if(comboBoxListaActividad.getSelectedItem().toString().equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					{
						btnDetalleActividad.setEnabled(Boolean.FALSE);
						btnEliminarActividad.setEnabled(Boolean.FALSE);
					}
					else
					{
						btnDetalleActividad.setEnabled(Boolean.TRUE);
						btnEliminarActividad.setEnabled(Boolean.TRUE);
						actualizarListaPersonas(comboBoxResponsableActividad);
						actualizarListaOrganizaciones(comboBoxOrganizacionActividad);
						actualizarListaNegocios(comboBoxNegocioActividad);
					}
				}
				else
				{
					btnDetalleActividad.setEnabled(Boolean.FALSE);
					btnEliminarActividad.setEnabled(Boolean.FALSE);
				}
			}
		});
		
		btnAdministrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPersonas.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverPrincipalActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(Boolean.TRUE);
				panelActividades.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigoActividad.setVisible(Boolean.TRUE);
				lblCodigoActividad.setVisible(Boolean.TRUE);
				
				textDescripcionActividad.setText("");
				comboBoxTipoActividad.setSelectedIndex(0);
				textFechaInicioActividad.setText("");
				textHoraInicioActividad.setText("");
				textDuracionActividad.setText("");
				comboBoxResponsableActividad.setSelectedIndex(0);
				comboBoxOrganizacionActividad.setSelectedIndex(0);
				comboBoxNegocioActividad.setSelectedIndex(0);
				
				panelActividades.setVisible(Boolean.TRUE);
				panelDetalleActividad.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
				
				actualizarListaActividades();
			}
		});
		
		btnDetalleActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarActividad.setText("Actualizar");
				
				String itemActividadElegida = comboBoxListaActividad.getSelectedItem().toString();
				Actividad actividadElegida = sistema.consultarActividadPorCodigoNombre(itemActividadElegida);
				
				textCodigoActividad.setText(actividadElegida.getCodigoActividad());
				textDescripcionActividad.setText(actividadElegida.getDescripcionActividad());
				comboBoxTipoActividad.setSelectedIndex(actividadElegida.getTipoActividad());
				textFechaInicioActividad.setText(actividadElegida.getFechaInicioActividad());
				textHoraInicioActividad.setText(actividadElegida.getHoraInicioActividad());
				textDuracionActividad.setText(actividadElegida.getDuracionActividad());

				if(actividadElegida.getCodigoPersona().equalsIgnoreCase(""))
					comboBoxResponsableActividad.setSelectedIndex(0);
				else
				{		
					if(sistema.getListaPersonas().existeNodoPorCodigo(actividadElegida.getCodigoPersona()))
						comboBoxResponsableActividad.setSelectedItem(	(String) sistema.getListaPersonas().consultarNodo((String) actividadElegida.getCodigoPersona()).getBusinessObject().getCodigoObjeto() + "-" +
																sistema.getListaPersonas().consultarNodo((String) actividadElegida.getCodigoPersona()).getBusinessObject().getDescripcionObjeto());
					else
						comboBoxResponsableActividad.setSelectedIndex(0);
				}
				
				if(actividadElegida.getCodigoOrganizacion().equalsIgnoreCase(""))
					comboBoxOrganizacionActividad.setSelectedIndex(0);
				else
				{		
					if(sistema.getListaOrganizaciones().existeNodoPorCodigo(actividadElegida.getCodigoOrganizacion()))
						comboBoxOrganizacionActividad.setSelectedItem(	(String) sistema.getListaOrganizaciones().consultarNodo((String) actividadElegida.getCodigoOrganizacion()).getBusinessObject().getCodigoObjeto() + "-" +
																sistema.getListaOrganizaciones().consultarNodo((String) actividadElegida.getCodigoOrganizacion()).getBusinessObject().getDescripcionObjeto());
					else
						comboBoxOrganizacionActividad.setSelectedIndex(0);
				}
				
				if(actividadElegida.getCodigoNegocio().equalsIgnoreCase(""))
					comboBoxNegocioActividad.setSelectedIndex(0);
				else
				{		
					if(sistema.getListaNegocios().existeNodoPorCodigo(actividadElegida.getCodigoNegocio()))
						comboBoxNegocioActividad.setSelectedItem(	(String) sistema.getListaNegocios().consultarNodo((String) actividadElegida.getCodigoNegocio()).getBusinessObject().getCodigoObjeto() + "-" +
																sistema.getListaNegocios().consultarNodo((String) actividadElegida.getCodigoNegocio()).getBusinessObject().getDescripcionObjeto());
					else
						comboBoxNegocioActividad.setSelectedIndex(0);
				}
				
				panelActividades.setVisible(Boolean.FALSE);
				panelDetalleActividad.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
				
				//actualizarListaPersonas(comboBoxResponsableNegocio);
				actualizarListaOrganizaciones(comboBoxListaActividad);
			}
		});
		
		btnAgregarActualizarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codigoPersonaElegida = comboBoxResponsableActividad.getSelectedItem().toString();
				String codigoPersonaActualizada = "";
				
				String codigoOrganizacionElegida = comboBoxOrganizacionActividad.getSelectedItem().toString();
				String codigoOrganizacionActualizada = "";
				
				String codigoNegocioElegido = comboBoxNegocioActividad.getSelectedItem().toString();
				String codigoNegocioActualizado = "";
				
				if(!codigoPersonaElegida.equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					codigoPersonaActualizada = sistema.getListaPersonas().consultarNodoCodigoNombre(codigoPersonaElegida).getBusinessObject().getCodigoObjeto();

				if(!codigoOrganizacionElegida.equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					codigoOrganizacionActualizada = sistema.getListaOrganizaciones().consultarNodoCodigoNombre(codigoOrganizacionElegida).getBusinessObject().getCodigoObjeto();
				
				if(!codigoNegocioElegido.equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					codigoNegocioActualizado = sistema.getListaNegocios().consultarNodoCodigoNombre(codigoNegocioElegido).getBusinessObject().getCodigoObjeto();
				
				
				if(btnAgregarActualizarActividad.getText().equalsIgnoreCase("Actualizar"))
				{
					sistema.actualizarActividad(	textCodigoActividad.getText(),
													textDescripcionActividad.getText(),
													comboBoxTipoActividad.getSelectedIndex(),
													textFechaInicioActividad.getText(),
													textHoraInicioActividad.getText(),
													textDuracionActividad.getText(),
													codigoPersonaActualizada,
													codigoOrganizacionActualizada,
													codigoNegocioActualizado);
					
					JOptionPane.showMessageDialog(null,
							"Ítem actualizado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					sistema.agregarActividad(	textDescripcionActividad.getText(),
												comboBoxTipoActividad.getSelectedIndex(),
												textFechaInicioActividad.getText(),
												textHoraInicioActividad.getText(),
												textDuracionActividad.getText(),
												codigoPersonaActualizada,
												codigoOrganizacionActualizada,
												codigoNegocioActualizado);
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(sistema.getListaActividades().getNumeroNodos() > 0)
				{
					btnEliminarActividad.setEnabled(Boolean.TRUE);
					btnDetalleActividad.setEnabled(Boolean.TRUE);
				}
			}
		});
		//Fin Panel de Actividades
		
		//Panel de Organizaciones
		panelOrganizaciones = new JPanel();
		panelAplicacion.add(panelOrganizaciones);
		panelOrganizaciones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Administración de Organizaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrganizaciones.setLayout(new GridLayout(0, 1, 0, 0));
		panelOrganizaciones.setVisible(Boolean.FALSE);
		
		lblListaOrganizacion = new JLabel("Lista de organizaciones");
		panelOrganizaciones.add(lblListaOrganizacion);
		
		comboBoxListaOrganizacion = new JComboBox<String>();
		panelOrganizaciones.add(comboBoxListaOrganizacion);
		
		btnDetalleOrganizacion = new JButton("Detalle Organización");

		panelOrganizaciones.add(btnDetalleOrganizacion);
		
		btnEliminarOrganizacion = new JButton("Eliminar Organización");
		
		btnAdministrarOrganizaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOrganizaciones.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnEliminarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemOrganizacionElegida = comboBoxListaOrganizacion.getSelectedItem().toString();
				int respuestaSeleccionada = 0;
				
				Organizacion organizacionElegida = sistema.consultarOrganizacionPorCodigoNombre(itemOrganizacionElegida);
				
				respuestaSeleccionada = JOptionPane.showConfirmDialog(null,
						"¿Está seguro que desea eliminar la Organización " + organizacionElegida.getCodigoObjeto() + "-" + organizacionElegida.getDescripcionObjeto() + "?",
						"Mensaje de confirmación",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.QUESTION_MESSAGE);
				
				if(respuestaSeleccionada == 0)
				{
					sistema.getListaOrganizaciones().eliminarNodo(itemOrganizacionElegida);
					
					JOptionPane.showMessageDialog(null,
							"Ítem eliminado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
					
					actualizarListaOrganizaciones(comboBoxListaOrganizacion);
				}
				
				if(sistema.getListaOrganizaciones().getNumeroNodos() == 0)
				{
					btnEliminarOrganizacion.setEnabled(Boolean.FALSE);
					btnDetalleOrganizacion.setEnabled(Boolean.FALSE);
				}
				
				frameSistemaGestion.pack();
			}
		});

		panelOrganizaciones.add(btnEliminarOrganizacion);
		
		btnAgregarOrganizacion = new JButton("Agregar Organización");
		btnAgregarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarOrganizacion.setText("Agregar");			
				
				textCodigoOrganizacion.setVisible(Boolean.FALSE);
				lblCodigoOrganizacion.setVisible(Boolean.FALSE);
				panelOrganizaciones.setVisible(Boolean.FALSE);
				panelDetalleOrganizacion.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
			}
		});

		panelOrganizaciones.add(btnAgregarOrganizacion);
		
		btnVolverPrincipalOrganizacion = new JButton("Volver al Menú principal");

		panelOrganizaciones.add(btnVolverPrincipalOrganizacion);
		btnVolverPrincipalOrganizacion.setActionCommand("Anterior");
		
		panelDetalleOrganizacion = new JPanel();
		panelDetalleOrganizacion.setBorder(new TitledBorder(null, "Detalle Organización", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelAplicacion.add(panelDetalleOrganizacion);
		panelDetalleOrganizacion.setVisible(Boolean.FALSE);
		panelDetalleOrganizacion.setLayout(new FormLayout(new ColumnSpec[] {
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		lblCodigoOrganizacion = new JLabel("Código:");
		panelDetalleOrganizacion.add(lblCodigoOrganizacion, "2, 2, left, default");
		
		textCodigoOrganizacion = new JTextField();
		textCodigoOrganizacion.setEnabled(false);
		textCodigoOrganizacion.setEditable(false);
		panelDetalleOrganizacion.add(textCodigoOrganizacion, "4, 2, fill, default");
		textCodigoOrganizacion.setColumns(10);
		
		lblNitOrganizacion = new JLabel("NIT:");
		panelDetalleOrganizacion.add(lblNitOrganizacion, "2, 4, left, default");
		
		textNitOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textNitOrganizacion, "4, 4, fill, default");
		
		lblNombreOrganizacion = new JLabel("Nombre:");
		panelDetalleOrganizacion.add(lblNombreOrganizacion, "2, 6, left, default");
		
		textNombreOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textNombreOrganizacion, "4, 6, fill, default");
		textNombreOrganizacion.setColumns(10);
		
		lblDireccionOrganizacion = new JLabel("Dirección:");
		panelDetalleOrganizacion.add(lblDireccionOrganizacion, "2, 8, left, default");
		
		textDireccionOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textDireccionOrganizacion, "4, 8, fill, default");
		
		lblTelefonoOrganizacion = new JLabel("Teléfono:");
		panelDetalleOrganizacion.add(lblTelefonoOrganizacion, "2, 10, left, default");
		
		textTelefonoOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textTelefonoOrganizacion, "4, 10, fill, default");
		textTelefonoOrganizacion.setColumns(10);
		
		btnVolverOrganizacion = new JButton("Volver");

		panelDetalleOrganizacion.add(btnVolverOrganizacion, "2, 12");
		
		btnAgregarActualizarOrganizacion = new JButton("Agregar / Actualizar");

		panelDetalleOrganizacion.add(btnAgregarActualizarOrganizacion, "4, 12");
		
		comboBoxListaOrganizacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxListaOrganizacion.getSelectedItem() != null)
				{
					if(comboBoxListaOrganizacion.getSelectedItem().toString().equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					{
						btnDetalleOrganizacion.setEnabled(Boolean.FALSE);
						btnEliminarOrganizacion.setEnabled(Boolean.FALSE);
					}
					else
					{
						btnDetalleOrganizacion.setEnabled(Boolean.TRUE);
						btnEliminarOrganizacion.setEnabled(Boolean.TRUE);
					}
				}
				else
				{
					btnDetalleOrganizacion.setEnabled(Boolean.FALSE);
					btnEliminarOrganizacion.setEnabled(Boolean.FALSE);
				}
			}
		});
		
		btnAdministrarPersonas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPersonas.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverPrincipalOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(Boolean.TRUE);
				panelOrganizaciones.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigoOrganizacion.setVisible(Boolean.TRUE);
				lblCodigoOrganizacion.setVisible(Boolean.TRUE);
				
				textNitOrganizacion.setText("");
				textNombreOrganizacion.setText("");
				textDireccionOrganizacion.setText("");
				textTelefonoOrganizacion.setText("");	
				
				panelOrganizaciones.setVisible(Boolean.TRUE);
				panelDetalleOrganizacion.setVisible(Boolean.FALSE);
					
				actualizarListaOrganizaciones(comboBoxListaOrganizacion);
				
				frameSistemaGestion.pack();
			}
		});
		
		btnDetalleOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarOrganizacion.setText("Actualizar");
				
				String itemOrganizacionElegida = comboBoxListaOrganizacion.getSelectedItem().toString();
				Organizacion organizacionElegida = sistema.consultarOrganizacionPorCodigoNombre(itemOrganizacionElegida);
				
				textCodigoOrganizacion.setText(organizacionElegida.getCodigoOrganizacion());
				textNitOrganizacion.setText(organizacionElegida.getNitOrganizacion());
				textNombreOrganizacion.setText(organizacionElegida.getNombreOrganizacion());
				textDireccionOrganizacion.setText(organizacionElegida.getDireccionOrganizacion());
				textTelefonoOrganizacion.setText(organizacionElegida.getTelefonoOrganizacion());
				
				panelOrganizaciones.setVisible(Boolean.FALSE);
				panelDetalleOrganizacion.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
				
				//actualizarListaPersonas(comboBoxResponsableNegocio);
				actualizarListaOrganizaciones(comboBoxListaOrganizacion);
			}
		});
		
		btnAgregarActualizarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAgregarActualizarOrganizacion.getText().equalsIgnoreCase("Actualizar"))
				{
					sistema.actualizarOrganizacion(	textCodigoOrganizacion.getText(),
													textNitOrganizacion.getText(),
													textNombreOrganizacion.getText(),
													textDireccionOrganizacion.getText(),
													textTelefonoOrganizacion.getText());
					
					JOptionPane.showMessageDialog(null,
							"Ítem actualizado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					sistema.agregarOrganizacion(	textNitOrganizacion.getText(),
													textNombreOrganizacion.getText(),
													textDireccionOrganizacion.getText(),
													textTelefonoOrganizacion.getText());
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(sistema.getListaOrganizaciones().getNumeroNodos() > 0)
				{
					btnEliminarOrganizacion.setEnabled(Boolean.TRUE);
					btnDetalleOrganizacion.setEnabled(Boolean.TRUE);
				}
			}
		});
		//Fin Panel de Organizaciones
		
		//actualizarListaPersonas(comboBoxResponsableNegocio);
		
		//actualizarListaNegocios();
		
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
						actualizarListaOrganizaciones(comboBoxNombreOrganizacionNegocio);
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
				String codigoPersonaElegida = comboBoxResponsableNegocio.getSelectedItem().toString();
				String codigoPersonaActualizada = "";
				
				String codigoOrganizacionElegida = comboBoxNombreOrganizacionNegocio.getSelectedItem().toString();
				String codigoOrganizacionActualizada = "";
				
				if(!codigoPersonaElegida.equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					codigoPersonaActualizada = sistema.getListaPersonas().consultarNodoCodigoNombre(codigoPersonaElegida).getBusinessObject().getCodigoObjeto();

				if(!codigoOrganizacionElegida.equalsIgnoreCase(GestionPrincipal.ITEMDEFECTOLISTAS))
					codigoOrganizacionActualizada = sistema.getListaOrganizaciones().consultarNodoCodigoNombre(codigoOrganizacionElegida).getBusinessObject().getCodigoObjeto();
				
				if(btnAgregarActualizar.getText().equalsIgnoreCase("Actualizar"))
				{	
					sistema.actualizarNegocio(	textCodigoNegocio.getText(),
												textTituloNegocio.getText(),
												textDescripcionNegocio.getText(),
												codigoOrganizacionActualizada,
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
											codigoOrganizacionActualizada,
											Double.parseDouble(textValorNegocio.getText()),
											codigoPersonaActualizada,
											textFechaCierreNegocio.getText(),
											comboBoxEstadoNegocio.getSelectedIndex());
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(sistema.getListaNegocios().getNumeroNodos() > 0)
				{
					btnEliminarNegocio.setEnabled(Boolean.TRUE);
					btnDetalleNegocio.setEnabled(Boolean.TRUE);
				}
				
				actualizarListaOrganizaciones(comboBoxNombreOrganizacionNegocio);				
			}
		});
		
		btnVolverPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.setVisible(Boolean.TRUE);
				panelNegocios.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnAdministrarNegocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelNegocios.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnDetalleNegocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizar.setText("Actualizar");
				
				String itemNegocioElegido = comboBoxListaNegocios.getSelectedItem().toString();
				Negocio negocioElegido = sistema.consultarNegocioPorCodigoNombre(itemNegocioElegido);
				
				textCodigoNegocio.setText(negocioElegido.getCodigoNegocio());
				textTituloNegocio.setText(negocioElegido.getTituloNegocio());
				textDescripcionNegocio.setText(negocioElegido.getDescripcionNegocio());
				textValorNegocio.setText(Double.toString(negocioElegido.getValorNegocio()));
				textFechaCierreNegocio.setText(negocioElegido.getFechaCierreNegocio());
				
				if(negocioElegido.getCodigoOrganizacion().equalsIgnoreCase(""))
					comboBoxNombreOrganizacionNegocio.setSelectedIndex(0);
				else
				{		
					if(sistema.getListaOrganizaciones().existeNodoPorCodigo(negocioElegido.getCodigoOrganizacion()))
						comboBoxNombreOrganizacionNegocio.setSelectedItem(	(String) sistema.getListaOrganizaciones().consultarNodo((String) negocioElegido.getCodigoOrganizacion()).getBusinessObject().getCodigoObjeto() + "-" +
																sistema.getListaOrganizaciones().consultarNodo((String) negocioElegido.getCodigoOrganizacion()).getBusinessObject().getDescripcionObjeto());
					else
						comboBoxNombreOrganizacionNegocio.setSelectedIndex(0);
				}
				
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
				comboBoxNombreOrganizacionNegocio.setSelectedIndex(0);
				textValorNegocio.setText(Double.toString(0));
				comboBoxResponsableNegocio.setSelectedIndex(0);
				textFechaCierreNegocio.setText("1-oct-2015");
				comboBoxEstadoNegocio.setSelectedIndex(0);
				
				panelNegocios.setVisible(Boolean.TRUE);
				panelDetalleNegocio.setVisible(Boolean.FALSE);
				
				actualizarListaNegocios(comboBoxListaNegocios);
				
				frameSistemaGestion.pack();
			}
		});
		
		btnEliminarNegocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemNegocioElegido = comboBoxListaNegocios.getSelectedItem().toString();
				int respuestaSeleccionada = 0;
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
					
					actualizarListaNegocios(comboBoxListaNegocios);
				}
				
				if(sistema.getListaNegocios().getNumeroNodos() == 0)
				{
					btnEliminarNegocio.setEnabled(Boolean.FALSE);
					btnDetalleNegocio.setEnabled(Boolean.FALSE);
				}
				
				frameSistemaGestion.pack();
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
				
				frameSistemaGestion.pack();
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

		panelDetallePersona.add(btnVolverPersona, "2, 14");
		
		btnAgregarActualizarPersona = new JButton("Agregar / Actualizar");

		panelDetallePersona.add(btnAgregarActualizarPersona, "4, 14");
		
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
				panelPersonas.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverPrincipalPersona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				actualizarListaPersonas(comboBoxListaPersonas);
				
				frameSistemaGestion.pack();
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
		actualizarListaOrganizaciones(comboBoxNombreOrganizacionNegocio);
		
		actualizarListaPersonas(comboBoxResponsableActividad);
		actualizarListaOrganizaciones(comboBoxOrganizacionActividad);
		actualizarListaNegocios(comboBoxNegocioActividad);
	
		actualizarListaNegocios(comboBoxListaNegocios);
		actualizarListaPersonas(comboBoxListaPersonas);
		actualizarListaOrganizaciones(comboBoxListaOrganizacion);	
		actualizarListaActividades();
	}
	
	public void actualizarListaNegocios(JComboBox<String> comboBoxListaNegociosGeneral)
	{
		comboBoxListaNegociosGeneral.removeAllItems();

		ArrayList<String> listaNegocios = sistema.listarNegocios();
		
		if(listaNegocios != null)
		{
			comboBoxListaNegociosGeneral.addItem(GestionPrincipal.ITEMDEFECTOLISTAS);
			for(int contador = 0; contador < listaNegocios.size(); contador ++)
			{
				comboBoxListaNegociosGeneral.addItem(listaNegocios.get(contador));
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
	
	public void actualizarListaOrganizaciones(JComboBox<String> comboBoxListaOrganizacionesGeneral)
	{
		comboBoxListaOrganizacionesGeneral.removeAllItems();

		ArrayList<String> listaOrganizaciones = sistema.listarOrganizaciones();
		
		if(listaOrganizaciones != null)
		{
			comboBoxListaOrganizacionesGeneral.addItem(GestionPrincipal.ITEMDEFECTOLISTAS);
			for(int contador = 0; contador < listaOrganizaciones.size(); contador ++)
			{
				comboBoxListaOrganizacionesGeneral.addItem(listaOrganizaciones.get(contador));
			}
		}
	}
	
	public void actualizarListaActividades()
	{
		comboBoxListaActividad.removeAllItems();

		ArrayList<String> listaActividades = sistema.listarActividades();
		
		if(listaActividades != null)
		{
			comboBoxListaActividad.addItem(GestionPrincipal.ITEMDEFECTOLISTAS);
			for(int contador = 0; contador < listaActividades.size(); contador ++)
			{
				comboBoxListaActividad.addItem(listaActividades.get(contador));
			}
		}
	}
}
