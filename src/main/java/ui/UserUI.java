package ui;

import javax.swing.JFrame;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import client.EasyFilmController;
import easyFilminData.User;
import serialization.UserData;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class UserUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8709399093642804047L;
	private JTextField busqueda;
	private JButton nuevaLista;
	private JButton misListas;
	private EasyFilmController controller;
	public UserUI(UserData user, EasyFilmController controller) {
		this.setTitle( "EasyFilmin User");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // cierra la ventana y se para la ejecución	
		setSize(740,480);
		setLocation(600,175);
		this.controller = controller;
		getContentPane().setLayout(new BorderLayout());
		
		busqueda = new JTextField();
		busqueda.setColumns(10);
		JLabel buscar = new JLabel("");
		JPanel pBusqueda = new JPanel();
		JPanel pSuperior = new JPanel();
		buscar.setIcon(new ImageIcon("src\\main\\resources\\Lupa.png"));
		pBusqueda.setLayout(new GridLayout(1,2));
		pBusqueda.add(buscar);
		pBusqueda.add(busqueda);
		pSuperior.setLayout(new BorderLayout(10,20));
		pSuperior.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 20));
		
		pSuperior.add(pBusqueda, BorderLayout.EAST);
		getContentPane().add(pSuperior, BorderLayout.NORTH);		
		
		nuevaLista = new JButton("New List");
		nuevaLista.setFont(new Font("Arial", Font.PLAIN, 15));
		getContentPane().add(nuevaLista);
		nuevaLista.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				CreateList u = new CreateList();
				u.setVisible(true);
			}
		});
		
		misListas = new JButton("My Lists");
		misListas.setBounds(100, 242, 150, 30);
		getContentPane().add(misListas);
		misListas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MyLists u = new MyLists(controller);
				u.setVisible(true);
			}
		});
		
		// Bottom panel 
		JPanel pCentral = new JPanel();
		JPanel pOpt = new JPanel();
		JPanel pPic = new JPanel();
		JLabel profile = new JLabel(user.getLogin());
		JLabel image = new JLabel("");
		String pathPic = user.getIcon();
		
		pCentral.setLayout(new FlowLayout(FlowLayout.CENTER));
		pPic.setLayout(new GridLayout(1,2));
		pOpt.setLayout(new GridLayout(2,1));
		pPic.add(image);pPic.add(profile);
		pOpt.add(nuevaLista); pOpt.add(misListas);		
		image.setSize(68, 68);
		
		//CAREFUL IF THERE IS NO PIC IN THE getIcon() 
		image.setIcon(new ImageIcon(pathPic));
		pCentral.setMinimumSize(new Dimension(100,20));
		pCentral.setPreferredSize(new Dimension(100,20));
		pCentral.setBorder(BorderFactory.createEmptyBorder(60, 20, 0, 20));
		pCentral.add(pPic, "West");
		pCentral.add(pOpt, "East");
		getContentPane().add(pCentral, "Center");
		
		
	}
	public static void main(String[] args) {
		UserData u = new UserData();
		EasyFilmController e = new EasyFilmController("127.0.0.1","8080");

		UserUI ui = new UserUI(u, e);
		ui.setVisible(true);
	}
	
}
