package ui;

import client.EasyFilmController;
import client.ExampleClient;
import easyFilminData.User;

public class PruebaVentanas {
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController(args[0], args[1]); 
		e.registerUser("egui2", "Image2", "11111@opendeusto.es","1234"); 

		UserLog u = new UserLog(args[0], args[1]);
		u.setVisible(true);

//		AdminUI a = new AdminUI();
//		a.setVisible(true);
//		
//		CreateList cl = new CreateList();
//		cl.setVisible(true);
//		
//		MyLists ml = new MyLists();
//		ml.setVisible(true);
		
//		UserReg ur = new UserReg(null, null);
//		ur.setVisible(true);
//		
//		User us = new User("egui", "src\\main\\resources\\image.png", "egui", "");
//		UserUI ui = new UserUI(us);
//		ui.setVisible(true);
		
	}
}


