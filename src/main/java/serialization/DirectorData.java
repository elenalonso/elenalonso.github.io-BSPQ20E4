package serialization;

import easyFilminData.Director;

public class DirectorData {
	protected String name;
	
	public DirectorData() {

	}
	public DirectorData(Director d) {
		this.name=d.getName();

	}
	public String getName() {
	    return this.name;
	}

	public void setName(String name) {
	    this.name = name;
	}
	}


