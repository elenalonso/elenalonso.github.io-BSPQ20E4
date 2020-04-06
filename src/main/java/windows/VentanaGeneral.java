package windows;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VentanaGeneral extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8709399093642804047L;
	private JTextField busqueda;
	public VentanaGeneral() {
		this.setTitle( "EasyFilmin User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(740,480);
		setLocation(600,175);

		
		getContentPane().setLayout(null);
		
		busqueda = new JTextField();
		busqueda.setBounds(459, 29, 225, 24);
		getContentPane().add(busqueda);
		busqueda.setColumns(10);
		
		JLabel buscar = new JLabel("");
		buscar.setBounds(404, 29, 45, 25);
		buscar.setIcon(new ImageIcon("src\\main\\resources\\Lupa.png"));
		getContentPane().add(buscar);
		
		JButton nuevaLista = new JButton("New List");
		nuevaLista.setFont(new Font("Arial", Font.PLAIN, 15));
		nuevaLista.setBounds(100, 158, 150, 30);
		getContentPane().add(nuevaLista);
		
		JButton misListas = new JButton("My Lists");
		misListas.setBounds(100, 242, 150, 30);
		getContentPane().add(misListas);
		
		JLabel profile = new JLabel("SomeName");
		profile.setBounds(100, 10, 150, 13);
		getContentPane().add(profile);
		
		JLabel image = new JLabel("");
		image.setBounds(10, 10, 68, 68);
		image.setIcon(new ImageIcon("src\\main\\resources\\image.png"));
		getContentPane().add(image);
		
		
	}
}
