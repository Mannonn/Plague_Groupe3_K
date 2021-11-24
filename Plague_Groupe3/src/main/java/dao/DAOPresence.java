package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Attractiv;
import model.Politique;
import model.Presence;


public class DAOPresence implements IDAO<Presence,Integer>{

	@Override
	public Presence findById(Integer id) {
		Presence p=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			p = new Presence(rs.getInt("id"),rs.getInt("id_planete"),rs.getInt("id_partie"),rs.getInt("population_malade"),rs.getInt("population_totale"),rs.getInt("cadavres"),Attractiv.valueOf(rs.getString("attractivite")),Politique.valueOf(rs.getString("politique"))); 
			
			rs.close();
			ps.close();
			conn.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Presence> findAll() {
		return null;
	}

	@Override
	public void insert(Presence presence) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (id,id_planete,id_partie,population_mondiale,population_totale,cadavres,attractivite,politique) VALUES (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, presence.getId());
			ps.setInt(2, presence.getId_planete());
			ps.setInt(3, presence.getId_partie());
			ps.setInt(4, presence.getPopulation_malade());
			ps.setInt(5, presence.getPopulation_totale());
			ps.setInt(6, presence.getCadavres());
			ps.setString(7, presence.getAttractivite().toString());
			ps.setString(8, presence.getPolitique().toString());

			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Presence presence) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
			
			PreparedStatement ps = conn.prepareStatement("Update compte set id_planete=?, id_partie=?, population_mondiale=?, population_totale=?, cadavres=?, attractivite=?, politique=? where id=?");

			ps.setInt(1, presence.getId_planete());
			ps.setInt(2, presence.getId_partie());
			ps.setInt(3, presence.getPopulation_malade());
			ps.setInt(4, presence.getPopulation_totale());
			ps.setInt(5, presence.getCadavres());
			ps.setString(6, presence.getAttractivite().toString());
			ps.setString(7, presence.getPolitique().toString());
			ps.setInt(8, presence.getId());
		
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	@Override
	public void delete(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
			
			PreparedStatement ps = conn.prepareStatement("DELETE from presence where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Presence connect(String libelle) 
	{
		Presence p=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where libelle=?");
			ps.setString(1, libelle);
			
			ResultSet rs=ps.executeQuery();
	
			p = new Presence(rs.getInt("id"),rs.getInt("id_planete"),rs.getInt("id_partie"),rs.getInt("population_malade"),rs.getInt("population_totale"),rs.getInt("cadavres"),Attractiv.valueOf(rs.getString("attractivite")),Politique.valueOf(rs.getString("politique"))); 
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}


}