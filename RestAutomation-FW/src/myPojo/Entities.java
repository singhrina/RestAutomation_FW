package myPojo;

public class Entities {
	 private String[] symbols;

	    private String[] urls;

	    private String[] hashtags;

	    private User_mentions[] user_mentions;

	    public String[] getSymbols ()
	    {
	        return symbols;
	    }

	    public void setSymbols (String[] symbols)
	    {
	        this.symbols = symbols;
	    }

	    public String[] getUrls ()
	    {
	        return urls;
	    }

	    public void setUrls (String[] urls)
	    {
	        this.urls = urls;
	    }

	    public String[] getHashtags ()
	    {
	        return hashtags;
	    }

	    public void setHashtags (String[] hashtags)
	    {
	        this.hashtags = hashtags;
	    }

	    public User_mentions[] getUser_mentions ()
	    {
	        return user_mentions;
	    }

	    public void setUser_mentions (User_mentions[] user_mentions)
	    {
	        this.user_mentions = user_mentions;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [symbols = "+symbols+", urls = "+urls+", hashtags = "+hashtags+", user_mentions = "+user_mentions+"]";
	    }
	}



