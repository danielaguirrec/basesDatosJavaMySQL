package practica2semilleroKonecta;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;

import java.sql.Date;

public class generarQuerys extends JFrame {
	
		public String Nombre="";
		private int Cedula=0;
		private int Telefono=0;
		private int anio=0;
		private int mes=0;
		private int dia=0;
		private String Genero="";
		private String Cliente="";
		private String Sede="";
	
		public String getNombre() {
			return Nombre;
		}

		public void setNombre(String nombre) {
			Nombre = nombre;
		}

		public int getCedula() {
			return Cedula;
		}

		public void setCedula(int Cedula) {
			this.Cedula = Cedula;
		}

		public int getTelefono() {
			return Telefono;
		}

		public void setTelefono(int Telefono) {
			this.Telefono = Telefono;
		}

		public int getanio() {
			return anio;
		}

		public void setanio(int anio) {
			this.anio = anio;
		}

		public int getmes() {
			return mes;
		}

		public void setmes(int mes) {
			this.mes = mes;
		}

		public int getdia() {
			return dia;
		}

		public void setdia(int dia) {
			this.dia = dia;
		}

		public String getGenero() {
			return Genero;
		}

		public void setGenero(String Genero) {
			this.Genero = Genero;
		}

		public String getCliente() {
			return Cliente;
		}

		public void setCliente(String cliente) {
			Cliente = cliente;
		}

		public String getSede() {
			return Sede;
		}

		public void setSede(String sede) {
			Sede = sede;
		}		
		// Metodos De Sql
	

		public static Connection conectarseDB() throws SQLException {
			// TODO Auto-generated method stub		
			String url="jdbc:mysql://localhost:3306/practica1konecta?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "daniel10nal";
			return DriverManager.getConnection(url,user,password);
		}	
		
		public static void registrarAsesor(String Nombre, int Cedula, int Telefono, Date Fecha_de_nacimiento,String Genero,String Cliente_para_el_que_trabaja, String Sede_donde_trabaja) {
			String queryAgregar = "INSERT INTO asesor (Nombre, Cedula, Telefono, Fecha_de_nacimiento,Genero,Cliente, Sede) VALUES(?, ?, ?, ?, ?, ?,)";		
			try(Connection conn = conectarseDB();
				PreparedStatement ps = conn.prepareStatement(queryAgregar);) {

				ps.setString(1, Nombre);
				ps.setInt(2, Cedula);
				ps.setInt(3, Telefono);
				ps.setDate(4, Fecha_de_nacimiento);
				ps.setString(5, Genero);
				ps.setString(6, Cliente_para_el_que_trabaja);
				ps.setString(7, Sede_donde_trabaja);
				
				int respuesta = ps.executeUpdate();		
					
				}   catch (SQLException sqlEx) {		
					sqlEx.printStackTrace();
				}
		}
		
		
		//metodos NO SQL
		public static void pedirValorAsesor() {
				
			  generarQuerys recibirValores = new generarQuerys();
			  //Nombre
			  Scanner scanNombre = new Scanner(System.in);  
	          System.out.println("Ingrese el nombre: ");  
	          String sNombre = scanNombre.nextLine();          
	          recibirValores.setNombre(sNombre);
	          scanNombre.close();      
	          System.out.println(validarSiEsNum(recibirValores.getNombre()));     
		}
		
		public static boolean validarSiEsNum(String valorPaComparar) {
			
			String patron = "\\b\\d+\\b";
			boolean emparejo = Pattern.matches(patron, valorPaComparar);			
			return emparejo;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}



