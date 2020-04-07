package ui;

import easyFilminData.User;

public class PruebaVentanas {
	public static void main(String[] args) {
		UserLog u = new UserLog();
		u.setVisible(true);

//		AdminUI a = new AdminUI();
//		a.setVisible(true);
//		
//		CreateList cl = new CreateList();
//		cl.setVisible(true);
//		
//		MyLists ml = new MyLists();
//		ml.setVisible(true);
		
		UserReg ur = new UserReg(null, null);
		ur.setVisible(true);
//		
//		User us = new User("egui", "src\\main\\resources\\image.png", "egui", "");
//		UserUI ui = new UserUI(us);
//		ui.setVisible(true);
		
	}
}


