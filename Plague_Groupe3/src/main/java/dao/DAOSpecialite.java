package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import model.Specialite;

public class DAOSpecialite implements IDAO<Specialite,Integer>{

	@Override
	public Specialite findById(Integer id) {
		Specialite s=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			s = new Specialite(rs.getInt("id"),rs.getString("libelle")); 
			
			
			rs.close();
			ps.close();
			conn.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public List<Specialite> findAll() {
		return null;
	}

	@Override
	public void insert(Specialite specialite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (id,libelle) VALUES (?,?)");
			
			ps.setInt(1, specialite.getId());
			ps.setString(2,specialite.getLibelle());

			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Specialite specialite) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
			
			PreparedStatement ps = conn.prepareStatement("Update compte set libelle=? where id=?");
			ps.setString(1, specialite.getLibelle());
			ps.setInt(2,specialite.getId());
		
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE from specialite where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Specialite connect(String libelle) 
	{
		Specialite s=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
			
			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where libelle=?");
			ps.setString(1, libelle);
			
			ResultSet rs=ps.executeQuery();
	
					s = new Specialite(rs.getInt("id"),rs.getString("libelle")); 
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}


}
