package mainsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PlayerManagementFacade {
	Connection conn = DBController.getConnection();
	public PlayerManagementFacade() {
		
	}

	public void CreatePlayer(String fn, String ln, String te, String st, String he, int ag, int threes, int frees, int points, int fouls, String pos, int id) {
		// TODO Auto-generated method stub
		player aplayer = new player(fn, ln, te, st, he, ag);
		playerstatistics stats = new playerstatistics(threes, frees, points, fouls, pos, id);
		ArrayList<String> Player = aplayer.CreatePlayer();
		ArrayList<String> Stats = stats.CreatePlayerStats();
		
		PreparedStatement gst = null;
		try {
			String sql = "insert into players values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			gst = conn.prepareStatement(sql);
					
			gst.setString(1, aplayer.getplayerfirstname());
			gst.setString(2, aplayer.getplayerlastname());
			gst.setString(3, aplayer.getplayerteam());
			gst.setString(4, aplayer.getplayerstatus());
			gst.setString(5, aplayer.getplayerheight());
			gst.setInt(6, aplayer.getplayerage());
			gst.setInt(7, stats.getplayerthrees());
			gst.setInt(8, stats.getplayerfrees());
			gst.setInt(9, stats.getplayerpoints());
			gst.setInt(10, stats.getplayerfouls());
			gst.setString(11, stats.getplayerpos());
			gst.setInt(12, stats.getplayerid());
			gst.execute();
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
	}

}
