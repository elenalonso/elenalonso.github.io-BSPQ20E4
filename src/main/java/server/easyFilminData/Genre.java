package server.easyFilminData;
	import javax.jdo.annotations.PersistenceCapable;



	import javax.jdo.annotations.Inheritance;
	import javax.jdo.annotations.InheritanceStrategy;


		@PersistenceCapable
		@Inheritance(strategy=InheritanceStrategy.NEW_TABLE)

	public class Genre {
			protected String name;
			
	public Genre(String name) {
		this.name=name;
	}
	
	  public String getName()
	    {
	        return name;
	    }
	
	public void setName(String name)
	    {
	        this.name = name;
	    }
	  
	
}
