package mainsystem;

import java.util.ArrayList;

public class player {
	

	private String Firstname;
	private String Lastname;
	private String Team;
	private String Status;
	private String Height;
	private int Age;
	
	
	public player(String fname, String lname, String team, String status, String height, int age)    {
	   
	    
	    this.Firstname = fname;
	    this.Lastname = lname;
	    this.Team = team;
	    this.Status = status;
	    this.Height = height;
	    this.Age = age;
	    
	   
	    
	}
	
	public ArrayList<String> CreatePlayer(){
		
		 ArrayList<String> Player = new ArrayList<String>();
		 
		 Player.add(Firstname);
		 Player.add(Lastname);
		 Player.add(Team);
		 Player.add(Status);
		 Player.add(Height);
		 Player.add(Integer.toString(Age));
		 
		 return Player;
	}
	
	public String getplayerfirstname(){
		return this.Firstname; 
	}
	
	public String getplayerlastname(){
		return this.Lastname; 
	}
	
	public String getplayerteam(){
		return this.Team; 
	}
	
	public String getplayerstatus(){
		return this.Status; 
	}
	
	public String getplayerheight(){
		return this.Height;
	}
	
	public int getplayerage(){
		return this.Age;	 
	}
	
	public void setFirstname(String firstname) {
		Firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public void setTeam(String team) {
		Team = team;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public void setHeight(String height) {
		Height = height;
	}

	public void setAge(int age) {
		Age = age;
	}
	
	

}
