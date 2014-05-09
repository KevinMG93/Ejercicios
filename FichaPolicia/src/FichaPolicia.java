import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class FichaPolicia extends JFrame {

	//Elementos de la pantalla
	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Apellidos;
	private JTextField Edad;
	private JTextField Altura;
	private JTextField Crimen;
	private Delincuente delincuente;
	
	//ComboBox para guardar delincuentes
	private JComboBox<Delincuente> delincuentes;


	//Lanza la aplicación
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FichaPolicia frame = new FichaPolicia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public FichaPolicia() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		// Combo
		JComboBox<Delincuente> ComboBox new JComboBox<Delincuente>();
		ComboBox.setBounds(10, 23, 414, 20);
		// Añadir
		ComboBox.addItem(new Delincuente ("Jose","Fuente",40,175,"Omicidio"));
		ComboBox.addItem(new Delincuente ("Joan","Ivars",21,181,"Ser tontin"));
		contentPane.add(ComboBox);
		*/
		
		// Combo
		delincuentes = new JComboBox<Delincuente>();
		
		delincuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Para que al darle aL ComboBox te coja los datos
				delincuente=delincuentes.getItemAt(delincuentes.getSelectedIndex());
				// Muestre los datos
					Nombre.setText(delincuente.getNombre());
					Apellidos.setText(delincuente.getApellidos());
					Edad.setText(String.valueOf(delincuente.getEdad()));
					Altura.setText(String.valueOf(delincuente.getAltura()));
					Crimen.setText(delincuente.getCrimen());	
			}
		});
		

		delincuentes.setBounds(10, 49, 414, 20);
		contentPane.add(delincuentes);
		
		JLabel lblNombreDelicuente = new JLabel("Ficha");
		lblNombreDelicuente.setBounds(10, 25, 308, 14);
		contentPane.add(lblNombreDelicuente);
		
		JLabel lblApellidosNombre = new JLabel("Nombre");
		lblApellidosNombre.setBounds(10, 80, 55, 14);
		contentPane.add(lblApellidosNombre);
		
		Nombre = new JTextField();
		Nombre.setBounds(10, 105, 190, 20);
		contentPane.add(Nombre);
		Nombre.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(10, 136, 88, 14);
		contentPane.add(lblEdad);
		
		Edad = new JTextField();
		Edad.setColumns(10);
		Edad.setBounds(10, 161, 88, 20);
		contentPane.add(Edad);
		
		JLabel lblAltura = new JLabel("Altura (cm)");
		lblAltura.setBounds(10, 197, 88, 14);
		contentPane.add(lblAltura);
		
		Altura = new JTextField();
		Altura.setColumns(10);
		Altura.setBounds(10, 222, 88, 20);
		contentPane.add(Altura);
		
		JLabel lblCrimen = new JLabel("Crimen");
		lblCrimen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCrimen.setBounds(336, 136, 88, 14);
		contentPane.add(lblCrimen);
		
		
		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Aquí realizaremos los siguientes pasos
				//1.- Comprobaremos que todos los campos están completados
				//2.- Crearemos un nuevo objeto delincuente
				//3.- Lo almacenaremos en el ComboBox
				
				if(Nombre.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Error");
				}
				else if	(Apellidos.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Error");
				}
				else if	(Edad.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Error");
				}
				else if	(Altura.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Error");
				}
				else if	(Crimen.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Error");
				}
				
				else {
				// Creamos los OBJETOS delincuentes
				Delincuente D =new Delincuente();	
				D.setNombre(Nombre.getText());
				D.setApellidos(Apellidos.getText());
				D.setEdad(Integer.parseInt(Edad.getText()));
				D.setAltura(Integer.parseInt(Altura.getText()));
				D.setCrimen(Crimen.getText());
				// Lo almacenamos al ComboBox
				delincuentes.addItem(D);
				}
				
			}
		});
		botonGuardar.setBounds(10, 272, 89, 23);
		contentPane.add(botonGuardar);
		
		Crimen = new JTextField();
		Crimen.setBounds(148, 161, 276, 20);
		contentPane.add(Crimen);
		Crimen.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(227, 80, 72, 14);
		contentPane.add(lblApellidos);
		
		Apellidos = new JTextField();
		Apellidos.setBounds(227, 105, 190, 20);
		contentPane.add(Apellidos);
		Apellidos.setColumns(10);
		
		JButton btnPorDefecto = new JButton("Por defecto");
		btnPorDefecto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Delincuente delincuente=new Delincuente();
				colocarDatos(delincuente);
			}
		});
		btnPorDefecto.setBounds(121, 272, 98, 23);
		contentPane.add(btnPorDefecto);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Modifica los datos guardados (Machaca los datos nuevos sobre los ya establecidos)
				delincuente.setNombre(Nombre.getText());
				delincuente.setApellidos(Apellidos.getText());
				delincuente.setEdad(Integer.parseInt(Edad.getText()));
				delincuente.setAltura(Integer.parseInt(Altura.getText()));
				delincuente.setCrimen(Crimen.getText());
				
			}
		});
		btnModificar.setBounds(240, 272, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Borra el Objeto (delincuente) seleccionado
				delincuentes.removeItem(delincuente);
				
			}
		});
		btnBorrar.setBounds(121, 303, 98, 23);
		contentPane.add(btnBorrar);
		
		// Añadir Objetos al ComboBox
		delincuentes.addItem(new Delincuente ("Jose","Fuente",40,175,"Omicidio"));
		delincuentes.addItem(new Delincuente ("Joan","Ivars",21,181,"Ser tontin"));
	}
	private void colocarDatos(Delincuente delincuente){
		Crimen.setText(delincuente.getCrimen());
	}
}
