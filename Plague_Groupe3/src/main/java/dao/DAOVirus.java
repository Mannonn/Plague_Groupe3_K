package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.Difficulte;
import model.Virus;

public class DAOVirus implements IDAO<Virus,Integer>{

	@Override
	public Virus findById(Integer id) {
		Virus v=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
	
					v = new Virus(rs.getInt("id"),rs.getString("nom").toString(), Difficulte.valueOf(rs.getString("difficulte")), rs.getDouble("propagation"), rs.getDouble("mortalite")); 
			
			rs.close();
			ps.close();
			conn.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}

	@Override
	public List<Virus> findAll() {
		return null;
	}

	@Override
	public void insert(Virus virus) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
			
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (id,nom,difficulte,propagation,mortalite) VALUES (?,?,?,?,?)");
			
			ps.setInt(1, virus.getId());
			ps.setString(2,virus.getNom());
			ps.setString(3, virus.getDifficulte().toString());
			ps.setDouble(4, virus.getPropagation());
			ps.setDouble(5, virus.getMortalite());
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Virus virus) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
			
			PreparedStatement ps = conn.prepareStatement("Update compte set nom=?,difficulted=?, propagation=?, mortalite=? where id=?");
			
			ps.setString(1,virus.getNom());
			ps.setString(2, virus.getDifficulte().toString());
			ps.setDouble(3, virus.getPropagation());
			ps.setDouble(4, virus.getMortalite());
			ps.setInt(5, virus.getId());
			
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
			
			PreparedStatement ps = conn.prepareStatement("DELETE from virus where id=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	}





