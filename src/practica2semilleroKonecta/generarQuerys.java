package practica2semilleroKonecta;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.util.Date;

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
			String url="jdbc:mysql://localhost:3306/practica2konecta?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "root";
			String password = "daniel10nal";
			return DriverManager.getConnection(url,user,password);
		}	
		
		public static void registrarAsesor(String Nombre, String Cedula, String Telefono, Date Fecha_de_nacimiento,String Genero,String Cliente_para_el_que_trabaja, String Sede_donde_trabaja, int edad) {
			String queryAgregar = "INSERT INTO asesor (Nombre, Cedula, Telefono, Fecha_de_nacimiento,Genero,Cliente, Sede, edad) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";		
			try(Connection conn = conectarseDB();
				PreparedStatement ps = conn.prepareStatement(queryAgregar);) {

				ps.setString(1, Nombre);
				ps.setString(2, Cedula);
				ps.setString(3, Telefono);
				ps.setDate(4, Fecha_de_nacimiento);
				ps.setString(5, Genero);
				ps.setString(6, Cliente_para_el_que_trabaja);
				ps.setString(7, Sede_donde_trabaja);
				ps.setInt(8, edad);
				
				int respuesta = ps.executeUpdate();		
					
				}   catch (SQLException sqlEx) {		
					sqlEx.printStackTrace();
				}
		}
		
		public static void listarAsesores() {
			
			String selectPersonas = "select * from asesor"; 
			try(Connection conn = conectarseDB();
				PreparedStatement ps = conn.prepareStatement(selectPersonas);) {
				String plantilla = "Nombre : %s, Cedula: %s"
						+ "Telefono : %s, Fecha de Nacimiento: %s "
						+ "Genero : %s, Cliente: %s"+
						"Sede : %s, Edad: %s";
				
			 ResultSet res = ps.executeQuery();
				 while(res.next()) {
					 
					 String Nombre = res.getString("Nombre");
					 String Cedula = res.getString("Cedula");
					 String Telefono = res.getString("Nombre");
					 String Fecha_de_nacimiento = ""+res.getDate("Fecha_de_nacimiento");
					 String Genero = res.getString("Genero");
					 String Cliente = res.getString("Cliente");
					 String Sede = res.getString("Sede");
					 String edad = ""+ res.getInt("edad");				 
					 System.out.println(String.format(plantilla,Nombre,Cedula,Telefono,
							 			Fecha_de_nacimiento,Genero,Cliente, Sede, edad));			
				 }
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
		
		public static boolean validarSiEsAnio(String anio) {
			
			if(validarSiEsNum(anio)) {
				java.util.Date d = new java.util.Date();
				@Deprecated
				int anioActual= d.getYear()+ 1900;
				int anioEntero = Integer.parseInt(anio);
				if(anioActual < anioEntero && anioEntero > 0) {
				return false;}else {return true;}
				
			}
			else {
				return false;
			}
		}
		
	public static boolean validarSiEsMes(String mes) {
			
			if(validarSiEsNum(mes)) {
				
				int mesUsuario = Integer.parseInt(mes);
				if(13 < mesUsuario && mesUsuario > 0) {
				return false;}else {return true;}
				
			}
			else {
				return false;
			}
		}
	
	public static boolean validarSiEsDia(String mes, String dia) {
		
		int mesUsuario = Integer.parseInt(mes);
		int diaUsuario = Integer.parseInt(dia);
		if(diaUsuario <32) {
		
		switch (mesUsuario) {
			  case 1:
			  case 3:
			  case 5:
			  case 7:
			  case 8:
			  case 10:
			  case 12:
			  if(diaUsuario <= 31 && diaUsuario > 0) {
				  return true;
			  }
			  else {
				  return false;
			  }
			  case 4:
			  case 6:
			  case 9:
			  case 11:
				  if(diaUsuario <= 30 && diaUsuario > 0) {
					  return true;
				  }
				  else {
					  return false;
				  }
			  case 2:
				  if(diaUsuario <= 28 && diaUsuario > 0) {
					  return true;
				  }
				  else {
					  return false;
				  }
				  
			  default:
			   return false;
			}
		}else {return false;}
		}
	
		public static boolean validarSiEsGenero(String Genero) {
			if(Genero.equalsIgnoreCase("Masculino") || Genero.equalsIgnoreCase("Femenino") ) {
				return true;
			}
			else {
				return false;
			}			
		}
		
		public static boolean validarSiEsSede(String Genero) {
			if(Genero.equalsIgnoreCase("ruta N") || Genero.equalsIgnoreCase("puerto seco")  || Genero.equalsIgnoreCase("buro") ) {
				return true;
			}
			else {
				return false;
			}			
		}
		
		public static int obtenerEdad(String anio, String mes, String dia) {
			
			int edad = 0;
			java.util.Date d = new java.util.Date();
			@Deprecated
			int anioActual= d.getYear()+ 1900;
			@Deprecated
			int mesActual =d.getMonth() +1;
			@Deprecated
			Calendar cal  = new GregorianCalendar();
		    int diaActual = cal.get(Calendar.DAY_OF_MONTH); 
			int anioEntero = Integer.parseInt(anio);
			int mesEntero = Integer.parseInt(mes);
			int diaEntero = Integer.parseInt(dia);
			
			System.out.print("Año actual: ");
			System.out.print(anioActual);
			
			System.out.print("\nAño nacimiento: ");
			System.out.print(anioEntero);
			edad = anioActual - anioEntero;
			
			if (mesActual == mesEntero) {
				if(diaActual < diaEntero) {
					edad = edad -1;
				}			
			}
			else if(mesActual < mesEntero) {
				edad = edad -1;
			}
					
			return edad;
		}
	}



