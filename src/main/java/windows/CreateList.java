package windows;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateList extends JFrame {
	private JButton btnNewButton;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
 	public CreateList() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(550,400);
		setLocation(600,175);
		getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(40, 40, 200, 300);
		getContentPane().add(list);
		
		JList list_1 = new JList();
		list_1.setBounds(311, 40, 200, 300);
		getContentPane().add(list_1);
		
		JLabel lblNewLabel = new JLabel("Your New List");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel.setBounds(311, 10, 200, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Available Films");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_1.setBounds(40, 10, 200, 20);
		getContentPane().add(lblNewLabel_1);
		
		btnNewButton = new JButton(">");
		btnNewButton.setBounds(255, 130, 39, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.setBounds(255, 179, 39, 39);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SAVE");
		btnNewButton_2.setBounds(245, 310, 60, 30);
		getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(10, 10, 25, 25);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				VentanaGeneral u = new VentanaGeneral();
				u.setVisible(true);
			}
		});
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setBounds(500, 10, 25, 25);
		getContentPane().add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
	}
}
