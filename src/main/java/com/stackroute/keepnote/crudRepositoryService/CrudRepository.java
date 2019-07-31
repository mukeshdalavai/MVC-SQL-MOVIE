package com.stackroute.keepnote.crudRepositoryService;

/*
 * This class contains the code for data storage interactions and methods 
 * of this class will be used by other parts of the applications such
 * as Controllers and Test Cases
 * */
import com.stackroute.keepnote.domain.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudRepository {
	private Connection con;
	public List<Movie> displayData() {
		List<Movie> movieList = new ArrayList<>();
		try {
			//Resister Driver with driver manager service
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb", "root", "Root@123");
			//create statement object
			System.out.println("got connected");

			Statement stmt = con.createStatement();


			//execute query
			ResultSet rs = stmt.executeQuery("select * from movie");
			//process result
			while (rs.next()) {
				Movie movie=new Movie();
				movie.setId(rs.getInt(1));
				movie.setName(rs.getString(2));
				movie.setGenre(rs.getString(3));
				movie.setLanguage(rs.getString(4));
				movieList.add(movie);
				//System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return movieList;
	}

	public List<Movie> displayMovieByName(String name,Movie movie) {
		List<Movie> movieList= new ArrayList<>();
		try{

			//Resister Driver with driver manager service
			//Class.forName("com.mysql.cj.jdbc.Driver");
			//System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb","root","Root@123");
			//create statement object
			System.out.println("got connected");

			PreparedStatement stmt=con.prepareStatement("Select * from movie where name = ?");
			stmt.setString(1,name);
			ResultSet rs = stmt.executeQuery();
			//execute query
			//  ResultSet rs=stmt.executeQuery("select * from customers");
			//process result
			rs.first();
				movie.setId(rs.getInt(1));
				movie.setName(rs.getString(2));
				movie.setGenre(rs.getString(3));
				movie.setLanguage(rs.getString(4));
				//System.out.println("ID "+rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
			con.close();
		}catch(Exception e){ System.out.println(e);}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(movie.toString());
		movieList.add(movie);
		return movieList;
	}

	public void insertMovie(Movie movie) {
		try {
			//Resister Driver with driver manager service
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb", "root", "Root@123");
			//create statement object
			System.out.println("got connected");

			PreparedStatement stmt = con.prepareStatement("insert into movie (id, name, genre, language) values (?,?,?,?)");
			stmt.setInt(1,movie.getId());
			stmt.setString(2, movie.getName());
			stmt.setString(3, movie.getGenre());
			stmt.setString(4, movie.getLanguage());
			stmt.executeUpdate();
		}catch(Exception e){ System.out.println(e);}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void deleteMovie(int deleteMovieId) {
		try {
			//Resister Driver with driver manager service
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded");//create connection
			//here db1 is database name, root is username and root123 is password
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/moviedb", "root", "Root@123");
			//create statement object
			System.out.println("got connected");

			PreparedStatement stmt = con.prepareStatement("delete from movie where id=?");
			stmt.setInt(1,deleteMovieId);
			stmt.executeUpdate();
		}catch(Exception e){ System.out.println(e);}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
