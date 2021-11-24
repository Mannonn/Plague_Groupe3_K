package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


import model.Compte;

import model.Type_compte;



	public class DAOCompte implements IDAO<Compte,Integer>{

		@Override
		public Compte findById(Integer id) {
			Compte c=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
				
				PreparedStatement ps = conn.prepareStatement("Select * from compte where id=?");
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				c= new Compte(rs.getInt("id"),rs.getString("login"),rs.getString("password"),Type_compte.valueOf(rs.getString("type_compte")),rs.getString("nom"),rs.getString("prenom"));
				
				rs.close();
				ps.close();
				conn.close();
			}catch (Exception e)
			{
				e.printStackTrace();
			}
			return c;
	
		}

		@Override
		public List<Compte> findAll() {
			return null;
		}

		@Override
		public void insert(Compte compte) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet_pandemie","root","");
				
				PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (id,login,password,type_compte,nom,prenom) VALUES (?,?,?,?,?,?)");
				
				ps.setInt(1, compte.getId());
				ps.setString(2,compte.getLogin());
				ps.setString(3, compte.getPassword());
				ps.setString(4,compte.getType_compte().toString());
				ps.setString(5, compte.getNom());
				ps.setString(6, compte.getPrenom());
				
				ps.executeUpdate();
				
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public void update(Compte compte) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hopital","root","");
				
				PreparedStatement ps = conn.prepareStatement("Update compte set login=?,password=?, type_compte=?, nom=?, prenom=? where id=?");
				
				
				ps.setString(1,compte.getLogin());
				ps.setString(2, compte.getPassword());
				ps.setString(3,compte.getType_compte().toString());
				ps.setString(4, compte.getNom());
				ps.setString(5, compte.getPrenom());
				ps.setInt(6, compte.getId());
				
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
				
				PreparedStatement ps = conn.prepareStatement("DELETE from compte where id=?");
				ps.setInt(1, id);
				
				ps.executeUpdate();
				
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		
		public Compte connect(String login,String password) 
		{
			Compte c=null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/voyage","root","");
				
				PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
				ps.setString(1, login);
				ps.setString(2, password);
				
				ResultSet rs=ps.executeQuery();
				
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return c;
		}


	}



