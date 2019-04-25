package mainsystem;

import java.util.ArrayList;

public class playerstatistics {
	

	private int Threepointers;
	private int Freethrows;
	private int Points;
	private int Fouls;
	public String Position;
	public int Id;
	
	
	public playerstatistics(int threes, int fthrows, int points, int fouls, String pos, int id)    {
	   
	    
	    this.Threepointers = threes;
	    this.Freethrows = fthrows;
	    this.Points = points;
	    this.Fouls = fouls;
	    this.Position = pos;
	    this.Id = id;
	    
	   
	    
	}
	
	public ArrayList<String> CreatePlayerStats(){
		
		 ArrayList<String> PlayerStats = new ArrayList<String>();
		 
		 PlayerStats.add(Integer.toString(Threepointers));
		 PlayerStats.add(Integer.toString(Freethrows));
		 PlayerStats.add(Integer.toString(Points));
		 PlayerStats.add(Integer.toString(Fouls));
		 PlayerStats.add(Position);
		 PlayerStats.add(Integer.toString(Id));
		 
		 return PlayerStats;
	}
	
	public int getplayerthrees(){
		return this.Threepointers;
		
		 
	}
	public int getplayerfrees(){
		return this.Freethrows;
			
	}
	public int getplayerpoints(){
		return this.Points;
		
		 
	}
	public int getplayerfouls(){
		return this.Fouls;
		
		 
	}
	public String getplayerpos(){
		return this.Position;
		
		 
	}
	public int getplayerid(){
		return this.Id;
		
		 
	}

	public void setThreepointers(int threepointers) {
		Threepointers = threepointers;
	}

	public void setFreethrows(int freethrows) {
		Freethrows = freethrows;
	}

	public void setPoints(int points) {
		Points = points;
	}

	public void setFouls(int fouls) {
		Fouls = fouls;
	}

	public void setPosition(String position) {
		Position = position;
	}

	public void setId(int id) {
		Id = id;
	}
	
	

}
