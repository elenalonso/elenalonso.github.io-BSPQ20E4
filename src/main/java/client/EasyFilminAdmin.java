package client;

import easyFilminDAO.EasyFilminJDO;
import ui.AdminUI;
import ui.UserLog;

public class EasyFilminAdmin {
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController(args[0], args[1]);  

		EasyFilminJDO bd= new EasyFilminJDO();
		bd.startBD();
		
		AdminUI au = new AdminUI(e);
		au.setVisible(true);
	}
}
