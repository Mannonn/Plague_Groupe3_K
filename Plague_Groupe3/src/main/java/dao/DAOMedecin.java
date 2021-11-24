package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Difficulte;
import model.Medecin;

public class DAOMedecin implements IDAO<Medecin,Integer>{

	@Override
	public Medecin findById(Integer id) {
		Medecin m=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
	
					m = new Medecin(rs.getInt("id"),rs.getString("nom"), rs.getInt("id_specialite"), Difficulte.valueOf(rs.getString("difficulte"))); 
			
			rs.close();
			ps.close();
			conn.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public List<Medecin> findAll() {
		return null;
	}

	@Override
	public void insert(Medecin medecin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (id,nom,id_specialite,difficulte) VALUES (?,?,?,?)");
			
			ps.setInt(1, medecin.getId());
			ps.setString(2,medecin.getNom());
			ps.setDouble(3, medecin.getId_specialite());
			ps.setString(4, medecin.getDifficulte().toString());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Medecin medecin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
			
			PreparedStatement ps = conn.prepareStatement("Update compte set nom=?,id_specialite=?, difficulte=? where id=?");
			
			ps.setString(1,medecin.getNom());
			ps.setDouble(2, medecin.getId_specialite());
			ps.setString(3, medecin.getDifficulte().toString());
			ps.setInt(5, medecin.getId());
			
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE from medecin where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	}





