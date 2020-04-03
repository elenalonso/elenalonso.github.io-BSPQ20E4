package easyFilminDAO;

import java.util.List;

import easyFilminData.User;

public interface IEasyFilminDAO {
	
	public void saveUser(User user);
	public User loadUser(String username);

}