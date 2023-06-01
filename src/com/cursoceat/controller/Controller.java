package com.cursoceat.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cursoceat.modell.Alumnos;
//actividad 14.2
public class Controller {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con;
		Statement st;
		ResultSet rt;
		String sql="";
		String url="jdbc:mysql://localhost:3306/instituto";
		String user="Celia";
		String password="1234";
		
		try {
			con= DriverManager.getConnection(url, user,password);
			
			st=con.createStatement();
			
			System.out.println("Nombre del alumno");
			String nombre= new Scanner(System.in).nextLine();
				
			System.out.println("Curso del alumno");
			String curso= new Scanner(System.in).nextLine();
			
			System.out.println("Media del alumno");
			Float media= new Scanner(System.in).nextFloat();
			
			
			//insertar
			sql="INSERT INTO alumnos (nombre,curso,media) VALUES("
			+"'"+nombre+"',"
			+"'"+curso+"',"
			+media
			+");" ;
			st.executeUpdate(sql);
			
			//mostrar
			sql="SELECT * FROM alumnos ORDER BY nombre;";
			rt= st.executeQuery(sql);
			
			System.out.println("Listado de alumnos ordenados por nombre:");
			
			List<Alumnos> misAlumnos  = new ArrayList<>();
			
			while(rt.next()) {
			
			Alumnos miAlumno = new Alumnos(rt.getInt("cod"),rt.getString("nombre"),rt.getString("curso"), rt.getFloat("media"));
			misAlumnos.add(miAlumno);
			
			}
			System.out.println(misAlumnos);
			System.out.println("Escriba el código del alumno que sea borrar");
			int borrar=new Scanner(System.in).nextInt();
			sql="DELETE FROM alumnos WHERE cod="+borrar+";";
			st.executeUpdate(sql);
			sql="SELECT * FROM alumnos;";
			rt=st.executeQuery(sql);
			while(rt.next()) {
				
			System.out.println(rt.getInt("cod")+" "+ rt.getString("nombre")+" "+rt.getString("curso")+" "+ rt.getFloat("media") );
				
				
				}
			
			con.close();
			System.out.println("Datos guardados correctamente");
			
		}catch (SQLException e) {
			System.out.println("Algo ha salido mal...");
			e.printStackTrace();
		}
		
		
		
	}

}
