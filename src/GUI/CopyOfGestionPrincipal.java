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

public class CopyOfGestionPrincipal {
	final static String ITEMDEFECTOLISTAS = "Seleccione ...";
	
	
	private SistemaBusinessFacade sistema;
	//private ArrayList<String> listaNegocios;
	
	private JFrame frameSistemaGestion;

	
	private JPanel panelAplicacion;
	private JPanel panelPrincipal;
	private JPanel panelOrganizacion;
	
	private JButton btnAdministrarNegocios;
	private JButton btnAdministrarOrganizaciones;
	private JButton btnAdministrarPersonas;
	private JButton btnAdministrarActividades;
	
	private JTextField textCodigoOrganizacion;
	private JComboBox<String> comboBoxTipoDocumentoOrganizacion;
	private JTextField textNumeroDocumentoOrganizacion;
	private JTextField textTelefonoOrganizacion;
	private JLabel lblListaOrganizacion;
	private JComboBox<String> comboBoxListaOrganizacion;
	private JButton btnDetalleOrganizacion;
	private JButton btnEliminarOrganizacion;
	private JButton btnAgregarOrganizacion;
	private JButton btnVolverPrincipalOrganizacion;
	private JPanel panelDetalleOrganizacion;
	private JLabel lblCodigoOrganizacion;
	private JLabel lblTipoDocumentoOrganizacion;
	private JLabel lblNumeroDocumentoOrganizacion;
	private JLabel lblNombresOrganizacion;
	private JTextField textNombresOrganizacion;
	private JLabel lblTelefonoOrganizacion;
	private JLabel lblEmailOrganizacion;
	private JTextField textEmailOrganizacion;
	private JButton btnVolverOrganizacion;
	private JButton btnAgregarActualizarOrganizacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyOfGestionPrincipal window = new CopyOfGestionPrincipal();
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
	public CopyOfGestionPrincipal() {
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
		frameSistemaGestion.setBounds(100, 100, 1100, 500);
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
		
		//Panel de Organizaciones
		panelOrganizacion = new JPanel();
		panelAplicacion.add(panelOrganizacion);
		panelOrganizacion.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Administración de Organizaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelOrganizacion.setLayout(new GridLayout(0, 1, 0, 0));
		panelOrganizacion.setVisible(Boolean.FALSE);
		
		lblListaOrganizacion = new JLabel("Lista de organizaciones");
		panelOrganizacion.add(lblListaOrganizacion);
		
		comboBoxListaOrganizacion = new JComboBox<String>();
		panelOrganizacion.add(comboBoxListaOrganizacion);
		
		btnDetalleOrganizacion = new JButton("Detalle Organización");

		panelOrganizacion.add(btnDetalleOrganizacion);
		
		btnEliminarOrganizacion = new JButton("Eliminar Organización");
		
		btnAdministrarOrganizaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelOrganizacion.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnEliminarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String itemPersonaElegida = comboBoxListaOrganizacion.getSelectedItem().toString();
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
					
					actualizarListaPersonas(comboBoxListaOrganizacion);
				}
				
				if(sistema.getListaPersonas().getNumeroNodos() == 0)
				{
					btnEliminarOrganizacion.setEnabled(Boolean.FALSE);
					btnDetalleOrganizacion.setEnabled(Boolean.FALSE);
				}
			}
		});

		panelOrganizacion.add(btnEliminarOrganizacion);
		
		btnAgregarOrganizacion = new JButton("Agregar Organización");
		btnAgregarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarOrganizacion.setText("Agregar");			
				
				textCodigoOrganizacion.setVisible(Boolean.FALSE);
				lblCodigoOrganizacion.setVisible(Boolean.FALSE);
				panelOrganizacion.setVisible(Boolean.FALSE);
				panelDetalleOrganizacion.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
			}
		});

		panelOrganizacion.add(btnAgregarOrganizacion);
		
		btnVolverPrincipalOrganizacion = new JButton("Volver al Menú principal");

		panelOrganizacion.add(btnVolverPrincipalOrganizacion);
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
		
		lblTipoDocumentoOrganizacion = new JLabel("Tipo de documento:");
		panelDetalleOrganizacion.add(lblTipoDocumentoOrganizacion, "2, 4, left, default");
		
		comboBoxTipoDocumentoOrganizacion = new JComboBox<String>();
		panelDetalleOrganizacion.add(comboBoxTipoDocumentoOrganizacion, "4, 4, fill, default");

		comboBoxTipoDocumentoOrganizacion.addItem("CC");
		comboBoxTipoDocumentoOrganizacion.addItem("TI");
		comboBoxTipoDocumentoOrganizacion.addItem("NIT");
		
		lblNumeroDocumentoOrganizacion = new JLabel("Número de documento:");
		panelDetalleOrganizacion.add(lblNumeroDocumentoOrganizacion, "2, 6, left, default");
		
		textNumeroDocumentoOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textNumeroDocumentoOrganizacion, "4, 6, fill, default");
		textNumeroDocumentoOrganizacion.setColumns(10);
		
		lblNombresOrganizacion = new JLabel("Nombres y apellidos:");
		panelDetalleOrganizacion.add(lblNombresOrganizacion, "2, 8, left, default");
		
		textNombresOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textNombresOrganizacion, "4, 8, fill, default");
		
		lblTelefonoOrganizacion = new JLabel("Teléfono:");
		panelDetalleOrganizacion.add(lblTelefonoOrganizacion, "2, 10, left, default");
		
		textTelefonoOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textTelefonoOrganizacion, "4, 10, fill, default");
		textTelefonoOrganizacion.setColumns(10);
		
		lblEmailOrganizacion = new JLabel("e-Mail:");
		panelDetalleOrganizacion.add(lblEmailOrganizacion, "2, 12, left, default");
		
		textEmailOrganizacion = new JTextField();
		panelDetalleOrganizacion.add(textEmailOrganizacion, "4, 12, fill, default");
		
		btnVolverOrganizacion = new JButton("Volver");

		panelDetalleOrganizacion.add(btnVolverOrganizacion, "2, 18");
		
		btnAgregarActualizarOrganizacion = new JButton("Agregar / Actualizar");

		panelDetalleOrganizacion.add(btnAgregarActualizarOrganizacion, "4, 18");
		
		comboBoxListaOrganizacion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(comboBoxListaOrganizacion.getSelectedItem() != null)
				{
					if(comboBoxListaOrganizacion.getSelectedItem().toString().equalsIgnoreCase(CopyOfGestionPrincipal.ITEMDEFECTOLISTAS))
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
				// TODO Auto-generated method stub
				panelOrganizacion.setVisible(Boolean.TRUE);
				panelPrincipal.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverPrincipalOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panelPrincipal.setVisible(Boolean.TRUE);
				panelOrganizacion.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
			}
		});
		
		btnVolverOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textCodigoOrganizacion.setVisible(Boolean.TRUE);
				lblCodigoOrganizacion.setVisible(Boolean.TRUE);
				
				comboBoxTipoDocumentoOrganizacion.setSelectedIndex(0);
				textNumeroDocumentoOrganizacion.setText("");
				textNombresOrganizacion.setText("");
				textTelefonoOrganizacion.setText("");
				textEmailOrganizacion.setText("");
				
				
				panelOrganizacion.setVisible(Boolean.TRUE);
				panelDetalleOrganizacion.setVisible(Boolean.FALSE);
				frameSistemaGestion.pack();
				
				actualizarListaPersonas(comboBoxListaOrganizacion);
			}
		});
		
		btnDetalleOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAgregarActualizarOrganizacion.setText("Actualizar");
				
				String itemPersonaElegida = comboBoxListaOrganizacion.getSelectedItem().toString();
				Persona personaElegida = sistema.consultarPersonaPorCodigoNombre(itemPersonaElegida);
				
				textCodigoOrganizacion.setText(personaElegida.getCodigoPersona());
				//comboBoxTipoDocumentoPersona.setText(negocioElegido.getTituloNegocio());
				textNumeroDocumentoOrganizacion.setText(personaElegida.getNumeroDocumentoPersona());
				textNombresOrganizacion.setText(personaElegida.getNombrePersona());
				//comboBoxResponsableNegocio.setSelectedIndex()
				textTelefonoOrganizacion.setText(personaElegida.getTelefonoPersona());
				textEmailOrganizacion.setText(personaElegida.getEmailPersona());
				
				switch(personaElegida.getTipoDocumentoPersona())
				{
					case Persona.CEDULA:
						comboBoxTipoDocumentoOrganizacion.setSelectedIndex(0);
						break;
					case Persona.TARJETAIDENTIDAD:
						comboBoxTipoDocumentoOrganizacion.setSelectedIndex(1);
						break;
					case Persona.NIT:
						comboBoxTipoDocumentoOrganizacion.setSelectedIndex(2);
						break;
				}
				
				panelOrganizacion.setVisible(Boolean.FALSE);
				panelDetalleOrganizacion.setVisible(Boolean.TRUE);
				frameSistemaGestion.pack();
				
				//actualizarListaPersonas(comboBoxResponsableNegocio);
				actualizarListaPersonas(comboBoxListaOrganizacion);
			}
		});
		
		btnAgregarActualizarOrganizacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnAgregarActualizarOrganizacion.getText().equalsIgnoreCase("Actualizar"))
				{
					sistema.actualizarPersona(	textCodigoOrganizacion.getText(),
												comboBoxTipoDocumentoOrganizacion.getSelectedIndex(),
												textNumeroDocumentoOrganizacion.getText(),
												textNombresOrganizacion.getText(),
												textTelefonoOrganizacion.getText(),
												textEmailOrganizacion.getText());
					
					JOptionPane.showMessageDialog(null,
							"Ítem actualizado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					sistema.agregarPersona(	comboBoxTipoDocumentoOrganizacion.getSelectedIndex(),
											textNumeroDocumentoOrganizacion.getText(),
											textNombresOrganizacion.getText(),
											textTelefonoOrganizacion.getText(),
											textEmailOrganizacion.getText());
					
					JOptionPane.showMessageDialog(null,
							"Ítem agregado",
							"Mensaje de información",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				if(sistema.getListaPersonas().getNumeroNodos() > 0)
				{
					btnEliminarOrganizacion.setEnabled(Boolean.TRUE);
					btnDetalleOrganizacion.setEnabled(Boolean.TRUE);
				}
			}
		});
		//Fin Panel de Organizaciones
		
		//actualizarListaPersonas(comboBoxResponsableNegocio);
		actualizarListaPersonas(comboBoxListaOrganizacion);
		
		//actualizarListaNegocios();
	}
	
	public void actualizarListaPersonas(JComboBox<String> comboBoxListaPersonasGeneral)
	{
		comboBoxListaPersonasGeneral.removeAllItems();

		ArrayList<String> listaPersonas = sistema.listarPersonas();
		
		if(listaPersonas != null)
		{
			comboBoxListaPersonasGeneral.addItem(CopyOfGestionPrincipal.ITEMDEFECTOLISTAS);
			for(int contador = 0; contador < listaPersonas.size(); contador ++)
			{
				comboBoxListaPersonasGeneral.addItem(listaPersonas.get(contador));
			}
		}
	}
}
