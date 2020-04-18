package client;

import easyFilminDAO.EasyFilminJDO;
import easyFilminData.User;
import ui.UserLog;

public class EasyFilmin {
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController(args[0], args[1]); 
		e.registerUser("egui2", "src/img/jimmy.jpg", "11111@opendeusto.es","1234"); 
		e.registerUser("Marcos", "Image3", "33333@opendeusto.es","1235");
		
		// Is this after or before registering users?
		EasyFilminJDO prueba= new EasyFilminJDO();
		prueba.startBD();
		
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
//		
//		UserReg ur = new UserReg(null, null);
//		ur.setVisible(true);
		
	}
}


