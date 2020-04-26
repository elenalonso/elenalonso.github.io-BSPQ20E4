package client;

import easyFilminDAO.EasyFilminJDO;
import easyFilminData.User;
import ui.UserLog;

/** This class is the main class of our project, gets the arguments of the 
 * @author BSPQ-E4
 *
 */
public class EasyFilmin {
	public static void main(String[] args) {
		EasyFilmController e = new EasyFilmController(args[0], args[1]); 
		e.registerUser("egui2", "src/img/jimmy.jpg", "11111@opendeusto.es","1234"); 
		e.registerUser("Marcos", "Image3", "33333@opendeusto.es","1235");
				
		UserLog u = new UserLog(e);
		u.setVisible(true);

	}
}


