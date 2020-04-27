package client.main;

import client.controller.EasyFilmController;
import client.ui.AdminUI;
import client.ui.UserLog;
import server.easyFilminDAO.EasyFilminJDO;

public class EasyFilminAdmin {
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController(args[0], args[1]);  

		EasyFilminJDO bd= new EasyFilminJDO();
		bd.startBD();
		
		AdminUI au = new AdminUI(e);
		au.setVisible(true);
	}
}
