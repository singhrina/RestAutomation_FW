package myPojo;

public class User_mentions {

	 private String id;

	    private String name;

	    private String[] indices;

	    private String screen_name;

	    private String id_str;

	    public String getId ()
	    {
	        return id;
	    }

	    public void setId (String id)
	    {
	        this.id = id;
	    }

	    public String getName ()
	    {
	        return name;
	    }

	    public void setName (String name)
	    {
	        this.name = name;
	    }

	    public String[] getIndices ()
	    {
	        return indices;
	    }

	    public void setIndices (String[] indices)
	    {
	        this.indices = indices;
	    }

	    public String getScreen_name ()
	    {
	        return screen_name;
	    }

	    public void setScreen_name (String screen_name)
	    {
	        this.screen_name = screen_name;
	    }

	    public String getId_str ()
	    {
	        return id_str;
	    }

	    public void setId_str (String id_str)
	    {
	        this.id_str = id_str;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [id = "+id+", name = "+name+", indices = "+indices+", screen_name = "+screen_name+", id_str = "+id_str+"]";
	    }
	}
				

