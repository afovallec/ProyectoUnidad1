package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import Business.BusinessObject;
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
	private ArrayList<String> listaNegocios;
	
	private JFrame frameSistemaGestion;
	private JTextField textCodigoNegocio;
	private JTextField textTituloNegocio;
	private JTextField textDescripcionNegocio;
	private JTextField textValorNegocio;
	private JTextField textFechaCierreNegocio;
	
	private JPanel panelAplicacion;
	private JPanel panelPrincipal;
	private JPanel panelNegocios;
	
	private JButton btnAdministrarNegocios;
	private JButton btnAdministrarOrganizaciones;
	private JButton btnAdministrarPersonas;
	private JButton btnAdministrarActividades;
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
		//
		BusinessObject negocio1;
		
		sistema = new SistemaBusinessFacade();
		
		for(int contador = 0; contador < 10; contador ++)
		{
			negocio1 = new Negocio(	"codn" + contador,
								"Título negocio " + contador,
								"Descripción negocio " + contador,
								1000 + contador,
								"1-ene-2015 " + contador);
			
			sistema.agregarNegocio((Negocio) negocio1);
		}
		listaNegocios = sistema.listarNegocios();
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
		
		btnAdministrarNegocios = new JButton("Administrar negocios");
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
				Negocio negocioSeleccionado;
				
				negocioSeleccionado = (Negocio) sistema.getListaNegocios().consultarNodo(textCodigoNegocio.getText()).getBusinessObject();
				
				negocioSeleccionado.setTituloNegocio(textTituloNegocio.getText());
				negocioSeleccionado.setDescripcionNegocio(textDescripcionNegocio.getText());
				//TODO - negocioSeleccionado.setCodigoOrganizacion(codigoNombreOrganizacion);
				negocioSeleccionado.setValorNegocio(Double.parseDouble(textValorNegocio.getText()));
				negocioSeleccionado.setFechaCierreNegocio(textFechaCierreNegocio.getText().toString());
				negocioSeleccionado.setEstadoNegocio(comboBoxEstadoNegocio.getSelectedIndex());
				
				//TODO - ajustar consultar nodo para que no reciba sino solamente el codigo del objeto y no con su descripcion
				sistema.getListaNegocios().consultarNodo(textCodigoNegocio.getText()).setBusinessObject(negocioSeleccionado);
				
				//TODO - Solucionar tema cuando se actualiza el campo de descripción del objeto y se requiere actualizar los ítems de a lista
				//comboBoxListaNegocios.set
				actualizarListaNegocios(comboBoxListaNegocios);
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
					
					actualizarListaNegocios(comboBoxListaNegocios);
				}
			}
		});
		
		actualizarListaNegocios(comboBoxListaNegocios);
	}
	
	public void actualizarListaNegocios(JComboBox<String> comboBoxListaNegocios)
	{
		comboBoxListaNegocios.removeAllItems();
		listaNegocios = sistema.listarNegocios();
		
		for(int contador = 0; contador < listaNegocios.size(); contador ++)
		{
			comboBoxListaNegocios.addItem(listaNegocios.get(contador));
		}		
	}
}
