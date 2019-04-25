package mainsystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import net.proteanit.sql.DbUtils;

public class PlayerManagementFacade {
	Connection conn = DBController.getConnection();
	public PlayerManagementFacade() {
		
	}

	public void CreatePlayer(String fn, String ln, String te, String st, String he, int ag, int threes, int frees, int points, int fouls, String pos, int id) {
		// TODO Auto-generated method stub
		player aplayer = new player(fn, ln, te, st, he, ag);
		playerstatistics stats = new playerstatistics(threes, frees, points, fouls, pos, id);
		
		
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
	
	public ResultSet SearchPlayer(int id) {
		
		PreparedStatement st = null;
		ResultSet rst = null;
		try {
			
			
			String sql = "select * from players where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			rst = st.executeQuery();
			
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		return rst;
	}
	
	public void DeletePlayer(int id) {
		
		PreparedStatement st = null;
		try {
			String sql = "delete from players where id = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, id);
			st.execute();
			
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
