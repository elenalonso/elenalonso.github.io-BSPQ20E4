package windows;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAdmin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2536273181002934434L;
	private JTextField fileName;
	private JButton addArchive;
	private JButton exit;
	public VentanaAdmin() { 
		// Formato de la ventana
		this.setTitle( "EasyFilmin Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución
		setSize(600,250);
		setLocation(600,175);

		
		getContentPane().setLayout(null);
		
		fileName = new JTextField();
		fileName.setBounds(305, 75, 250, 25);
		getContentPane().add(fileName);
		fileName.setColumns(10);
		
		addArchive = new JButton("Add File");
		addArchive.setBounds(50, 75, 150, 30);
		getContentPane().add(addArchive);
		
		exit = new JButton("x");
		exit.setFont(new Font("Tahoma", Font.PLAIN, 5));
		exit.setBounds(541, 10, 35, 35);
		getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public static void main(String[] args) {
		VentanaAdmin va = new VentanaAdmin();
		va.setSize(600, 250);
		va.setVisible(true);
	}
}
