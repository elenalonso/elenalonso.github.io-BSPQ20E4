package serialization;

public class UserData {

    private String login;
    private String password;
    private String icon;
    private String email;

    //Default public constructor for serialization
	public UserData() {

    }
	
	/** Constructor to use in the server 
	 * @param login
	 * @param password
	 * @param icon
	 * @param email
	 */
	public UserData(String login, String password, String icon, String email) {
		this.login = login;
		this.password = password;
		this.icon = null; //CHANGE WHEN WE HAVE A WAY TO INSERT PROFILE IMAGES
		this.email = email;
	}
    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "[login=" + login + ", password=" + password + "]";
    }
    
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}