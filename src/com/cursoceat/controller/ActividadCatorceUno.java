package com.cursoceat.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//SUBIR 1 PUNTO A TODOS LOS ALUMNOS DEL CURSO 1B
public class ActividadCatorceUno {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Connection con;
		Statement st;
		ResultSet rt;
		String sql="";
		String url="jdbc:mysql://localhost:3306/instituto";
		String user="root";
		String password="";
		
		try {
			con= DriverManager.getConnection(url, user,password);
			//sql="UPDATE alumnos SET media= media+1 WHERE curso='1B' AND media<=9.0;";
			st=con.createStatement();
			//st.executeUpdate(sql);//da un booleano
			
			//System.out.println("Actualización correcta");
			sql="SELECT * FROM alumnos ORDER BY nombre;";
			rt= st.executeQuery(sql);
			
			System.out.println("Listado de alumnos ordenados por nombre:");
			while(rt.next()) {
			
			
			System.out.println("Código: "+ rt.getInt("cod")+"\t"+"Nombre:    "+ rt.getString("nombre")+"\t"
			+"Curso: "+	rt.getString("curso") +"\t"+"Media: "+ rt.getFloat("media"));
			
			}
			
			
			con.close();
			
			
			
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
