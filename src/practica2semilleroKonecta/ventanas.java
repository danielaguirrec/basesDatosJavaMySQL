package practica2semilleroKonecta;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.sql.Date;

public class ventanas extends generarQuerys {
	
	public static JFrame registrarAsesor() {
		
		 JFrame frameRegistro= new JFrame();
		 frameRegistro.setTitle("Registro de Asesor");
		 JPanel mainPanel = new JPanel();
		 
	     mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
         JPanel headingPanel = new JPanel();
         JLabel headingLabel = new JLabel("Registrando Asesores");
         headingPanel.add(headingLabel);
         
         JPanel panel = new JPanel(new GridBagLayout());
         // Constraints for the layout
         GridBagConstraints constr = new GridBagConstraints();
         constr.insets = new Insets(5, 5, 5, 5);     
         constr.anchor = GridBagConstraints.WEST;
         
         constr.gridx=0;
         constr.gridy=0; //necesito borrar esto
   
         // Declare the required Labels
         JLabel userNameLabel = new JLabel("Ingrese el nombre del asesor :");
         JLabel userCedulaLabel = new JLabel("Ingrese la cedula del asesor :");
         JLabel userTelefonoLabel = new JLabel("Ingrese el Telefono del asesor :");
         JLabel userAnioLabel = new JLabel("Ingrese el Año en que nacio el asesor :");
         JLabel userMesLabel = new JLabel("Ingrese el Mes en que nacio del asesor :");
         JLabel userDiaLabel = new JLabel("Ingrese el Dia en que nacio del asesor :");
         JLabel userGeneroLabel = new JLabel("Ingrese el Genero ( Masculino/Femenino) del asesor :");
         JLabel userClienteLabel = new JLabel("Ingrese el Cliente del asesor :");
         JLabel userSedeLabel = new JLabel("Ingrese sede (Ruta N, Puerto Seco, Buro) :");               
         
         JTextField userNameTxt = new JTextField(20);
         JTextField userCedulaTxt = new JTextField(20);
         JTextField userTelefonoTxt = new JTextField(20);
         JTextField userAnioTxt = new JTextField(20);
         JTextField userMesTxt = new JTextField(20);
         JTextField userDiaTxt = new JTextField(20);
         JTextField userGeneroTxt = new JTextField(20);
         JTextField userClienteTxt = new JTextField(20);
         JTextField userSedeTxt = new JTextField(20);    
         
         panel.add(userNameLabel, constr);
         constr.gridx=1;
         panel.add(userNameTxt, constr);
         constr.gridx=0; constr.gridy=1;
        
         panel.add(userCedulaLabel, constr);
         constr.gridx=1;
         panel.add(userCedulaTxt, constr);
         constr.gridx=0; constr.gridy=2;
          
         panel.add(userTelefonoLabel, constr);
         constr.gridx=1;
         panel.add(userTelefonoTxt, constr);
         constr.gridx=0; constr.gridy=3;
         
         panel.add(userAnioLabel, constr);
         constr.gridx=1;
         panel.add(userAnioTxt, constr);
         constr.gridx=0; constr.gridy=4;

         panel.add(userMesLabel, constr);
         constr.gridx=1;
         panel.add(userMesTxt, constr);
         constr.gridx=0; constr.gridy=5;
         
         panel.add(userDiaLabel, constr);
         constr.gridx=1;
         panel.add(userDiaTxt, constr);
         constr.gridx=0; constr.gridy=6;
         
         panel.add(userGeneroLabel, constr);
         constr.gridx=1;
         panel.add(userGeneroTxt, constr);
         constr.gridx=0; constr.gridy=7;
         
         panel.add(userClienteLabel, constr);
         constr.gridx=1;
         panel.add(userClienteTxt, constr);
         constr.gridx=0; constr.gridy=8;
         
         panel.add(userSedeLabel, constr);
         constr.gridx=1;
         panel.add(userSedeTxt, constr);
         constr.gridx=0; constr.gridy=9;
    
         constr.gridwidth = 2;
         constr.anchor = GridBagConstraints.CENTER;
         

         // Button with text "Register"
 JButton button = new JButton("Registrar");
 // add a listener to button
 button.addActionListener(new ActionListener()
 {
   public void actionPerformed(ActionEvent e)
   {
	   String Nombre = userNameTxt.getText();
	   
	   String Cedula = userCedulaTxt.getText();
	   boolean bCedula = validarSiEsNum(Cedula);
	   
	   String Telefono = userTelefonoTxt.getText();
	   boolean bTelefono = validarSiEsNum(Telefono);
	   
	   String Anio = userAnioTxt.getText();
	   boolean bAnio = validarSiEsAnio(Anio);
	   
	   String Mes = userMesTxt.getText();
	   boolean bMes = validarSiEsMes(Mes);
	   
	   String Dia = userDiaTxt.getText();
	   boolean bDia = validarSiEsDia(Mes, Dia);
	   
	   String Genero = userGeneroTxt.getText();
	   boolean bGenero = validarSiEsGenero(Genero);
	   
	   String Cliente = userClienteTxt.getText();
	   
	   String Sede = userSedeTxt.getText();
	   boolean bSede= validarSiEsSede(Sede);
	   
	   int edad = generarQuerys.obtenerEdad(Anio, Mes, Dia);
	   
	   String ValidacionCampo = validarTodoslosCampos(bCedula, bTelefono, bAnio, bMes, bDia, bGenero,  bSede);
   
	  // validarSiEsNum(validarCedula);
	   if("".equals(ValidacionCampo)) {
		    
		     headingLabel.setText("El registro en la BASE DE DATOS fue existoso!");
		     userNameTxt.setText("");	
		     userCedulaTxt.setText("");
		     userTelefonoTxt.setText("");
		     userAnioTxt.setText("");
		     userMesTxt.setText("");
		     userDiaTxt.setText("");
		     userGeneroTxt.setText("");
		     userClienteTxt.setText("");
		     userSedeTxt.setText("");	     
		     String strFecha=Anio+"-"+Mes+"-"+Dia;   //fecha de nacimeitno  
		     Date date=Date.valueOf(strFecha);//converting string into sql date  
		     registrarAsesor( Nombre, Cedula, Telefono,  date, Genero, Cliente,Sede, edad);
		     
	   }
	   else {
		   headingLabel.setText(ValidacionCampo); 
		
	   }
   }
 });

        // Add label and button to panel
		 panel.add(button, constr);
		 mainPanel.add(headingPanel);
		 mainPanel.add(panel);
 // Add panel to frame
		 frameRegistro.add(mainPanel);
		 frameRegistro.pack();
		 frameRegistro.setSize(800, 600);
		 frameRegistro.setLocationRelativeTo(null);
		 frameRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frameRegistro.setVisible(true);
		         
		return  frameRegistro;
	}
	
	public static JFrame actualizarInicio() {
		JFrame actualizar = new JFrame();
		
		 JFrame frameRegistro= new JFrame();
		 frameRegistro.setTitle("Actualizaciones de asesor");
		 JPanel mainPanel = new JPanel();
		 
	     mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
         JPanel headingPanel = new JPanel();
         JLabel headingLabel = new JLabel("Actualizaciones de asesor");
         headingPanel.add(headingLabel);
         
         JPanel panel = new JPanel(new GridBagLayout());
         // Constraints for the layout
         GridBagConstraints constr = new GridBagConstraints();
         constr.insets = new Insets(5, 5, 5, 5);     
         constr.anchor = GridBagConstraints.WEST;
         
         constr.gridx=0;
         constr.gridy=0; //necesito borrar esto

         // Declare the required Labels
         JLabel userCedulaLabel = new JLabel("Ingrese La cedula del asesor :");
         JTextField userCedulaTxt = new JTextField(20);
         
         panel.add(userCedulaLabel, constr);
         constr.gridx=1;
         panel.add(userCedulaTxt, constr);
         constr.gridx=1; constr.gridy=1;
         
         
         constr.gridwidth = 2;
         constr.anchor = GridBagConstraints.ABOVE_BASELINE_LEADING;
         

         // Button with text "Register"
 JButton buttonReicibirCedula = new JButton("Actualizar");
 // add a listener to button
 buttonReicibirCedula.addActionListener(new ActionListener()
 { 
	 public void actionPerformed(ActionEvent e)
	   {	
		 if(existeRegistro(userCedulaTxt.getText())) {		 
			 ventanas.actualizarAsesor(userCedulaTxt.getText());
		 }else {
			 headingLabel.setText("La Cedula Ingresada No existe en la BASE DE DATOS!");
			 userCedulaTxt.setText("");
		 }   
	   }
 }); 
 
 panel.add(buttonReicibirCedula, constr);

 
 mainPanel.add(headingPanel);
 mainPanel.add(panel);
 actualizar.add(mainPanel);
 actualizar.pack();
 actualizar.setSize(600, 300);
 actualizar.setLocationRelativeTo(null);
 actualizar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 actualizar.setVisible(true);	
		
		return actualizar;

	}
	
	// ACA COMIENZO
	public static JFrame actualizarAsesor(String cedula) {
		JFrame actualizarRegistro = new JFrame();
		
		 actualizarRegistro.setTitle("Actualizar Asesor");
		 JPanel mainPanel = new JPanel();
		 
	     mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
         JPanel headingPanel = new JPanel();
         JLabel headingLabel = new JLabel("Actualizando Asesores");
         headingPanel.add(headingLabel);
         
         JPanel panel = new JPanel(new GridBagLayout());
         // Constraints for the layout
         GridBagConstraints constr = new GridBagConstraints();
         constr.insets = new Insets(5, 5, 5, 5);     
         constr.anchor = GridBagConstraints.WEST;
         
         constr.gridx=0;
         constr.gridy=0; //necesito borrar esto
   
         // Declare the required Labels
         JLabel userNameLabel = new JLabel("Ingrese el nombre del asesor :");
      //   JLabel userCedulaLabel = new JLabel("Ingrese la cedula del asesor :");
         JLabel userTelefonoLabel = new JLabel("Ingrese el Telefono del asesor :");
         JLabel userAnioLabel = new JLabel("Ingrese el Año en que nacio el asesor :");
         JLabel userMesLabel = new JLabel("Ingrese el Mes en que nacio del asesor :");
         JLabel userDiaLabel = new JLabel("Ingrese el Dia en que nacio del asesor :");
         JLabel userGeneroLabel = new JLabel("Ingrese el Genero ( Masculino/Femenino) del asesor :");
         JLabel userClienteLabel = new JLabel("Ingrese el Cliente del asesor :");
         JLabel userSedeLabel = new JLabel("Ingrese sede (Ruta N, Puerto Seco, Buro) :");               
         
         JTextField userNameTxt = new JTextField(20);
       //  JTextField userCedulaTxt = new JTextField(20);
         JTextField userTelefonoTxt = new JTextField(20);
         JTextField userAnioTxt = new JTextField(20);
         JTextField userMesTxt = new JTextField(20);
         JTextField userDiaTxt = new JTextField(20);
         JTextField userGeneroTxt = new JTextField(20);
         JTextField userClienteTxt = new JTextField(20);
         JTextField userSedeTxt = new JTextField(20);    
         
         panel.add(userNameLabel, constr);
         constr.gridx=1;
         panel.add(userNameTxt, constr);
         constr.gridx=0; constr.gridy=1;
        
       /*  panel.add(userCedulaLabel, constr);
         constr.gridx=1;
         panel.add(userCedulaTxt, constr);
         constr.gridx=0; constr.gridy=2;*/
          
         panel.add(userTelefonoLabel, constr);
         constr.gridx=1;
         panel.add(userTelefonoTxt, constr);
         constr.gridx=0; constr.gridy=2;
         
         panel.add(userAnioLabel, constr);
         constr.gridx=1;
         panel.add(userAnioTxt, constr);
         constr.gridx=0; constr.gridy=3;

         panel.add(userMesLabel, constr);
         constr.gridx=1;
         panel.add(userMesTxt, constr);
         constr.gridx=0; constr.gridy=4;
         
         panel.add(userDiaLabel, constr);
         constr.gridx=1;
         panel.add(userDiaTxt, constr);
         constr.gridx=0; constr.gridy=5;
         
         panel.add(userGeneroLabel, constr);
         constr.gridx=1;
         panel.add(userGeneroTxt, constr);
         constr.gridx=0; constr.gridy=6;
         
         panel.add(userClienteLabel, constr);
         constr.gridx=1;
         panel.add(userClienteTxt, constr);
         constr.gridx=0; constr.gridy=7;
         
         panel.add(userSedeLabel, constr);
         constr.gridx=1;
         panel.add(userSedeTxt, constr);
         constr.gridx=0; constr.gridy=8;
    
         constr.gridwidth = 2;
         constr.anchor = GridBagConstraints.CENTER;
         

         // Button with text "Register"
 JButton button = new JButton("Actualizar");
 // add a listener to button
 button.addActionListener(new ActionListener()
 {
   public void actionPerformed(ActionEvent e)
   {
	   String Nombre = userNameTxt.getText();
	   
	   String Telefono = userTelefonoTxt.getText();
	   boolean bTelefono = validarSiEsNum(Telefono);
	   
	   String Anio = userAnioTxt.getText();
	   boolean bAnio = validarSiEsAnio(Anio);
	   
	   String Mes = userMesTxt.getText();
	   boolean bMes = validarSiEsMes(Mes);
	   
	   String Dia = userDiaTxt.getText();
	   boolean bDia = validarSiEsDia(Mes, Dia);
	   
	   String Genero = userGeneroTxt.getText();
	   boolean bGenero = validarSiEsGenero(Genero);
	   
	   String Cliente = userClienteTxt.getText();
	   
	   String Sede = userSedeTxt.getText();
	   boolean bSede= validarSiEsSede(Sede);
	   
	   int edad = generarQuerys.obtenerEdad(Anio, Mes, Dia);
	   
	   String ValidacionCampo = validarTodoslosCampos(true, bTelefono, bAnio, bMes, bDia, bGenero,  bSede);
   
	  // validarSiEsNum(validarCedula);
	   if("".equals(ValidacionCampo)) {
		    
		     headingLabel.setText("El registro en la BASE DE DATOS fue existoso!");
		     userNameTxt.setText("");	
		  //   userCedulaTxt.setText("");
		     userTelefonoTxt.setText("");
		     userAnioTxt.setText("");
		     userMesTxt.setText("");
		     userDiaTxt.setText("");
		     userGeneroTxt.setText("");
		     userClienteTxt.setText("");
		     userSedeTxt.setText("");	     
		     String strFecha=Anio+"-"+Mes+"-"+Dia;   //fecha de nacimeitno  
		     Date date=Date.valueOf(strFecha);//converting string into sql date  
		  //  registrarAsesor( Nombre, cedula, Telefono,  date, Genero, Cliente,Sede, edad);
		    actualizarAsesorQuery(Nombre,cedula,Telefono,  date, Genero, Cliente,Sede, edad);
		    
		     
	   }
	   else {
		   headingLabel.setText(ValidacionCampo); 
		
	   }
   }
 });

        // Add label and button to panel
		 panel.add(button, constr);
		 mainPanel.add(headingPanel);
		 mainPanel.add(panel);
 // Add panel to frame
		 actualizarRegistro.add(mainPanel);
		 actualizarRegistro.pack();
		 actualizarRegistro.setSize(800, 600);
		 actualizarRegistro.setLocationRelativeTo(null);
		 actualizarRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 actualizarRegistro.setVisible(true);	
		return actualizarRegistro;
	}
	
	///ACA FINALIZO
	public static JFrame menu() {
		 JFrame menuOpciones= new JFrame();
		 menuOpciones.setTitle("Menu de Consultas");
		 JPanel mainPanel = new JPanel();
 
	     mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); 
         JPanel headingPanel = new JPanel();
         JLabel headingLabel = new JLabel("Menu De Consultas");
         headingPanel.add(headingLabel);
         
         
         JPanel panel = new JPanel(new GridBagLayout());
         // Constraints for the layout
         GridBagConstraints constr = new GridBagConstraints();
         constr.insets = new Insets(5, 5, 5, 5);     
         constr.anchor = GridBagConstraints.WEST;      
         constr.gridx=0;
         constr.gridy=1; //necesito borrar esto   
         constr.gridwidth = 2;
         constr.anchor = GridBagConstraints.CENTER;

	 JButton buttonRegistrar = new JButton("Registrar");
	 // add a listener to button
	 buttonRegistrar.addActionListener(new ActionListener()
	 { 
		 public void actionPerformed(ActionEvent e)
		   {	ventanas.registrarAsesor();}
	 }); 
	 panel.add(buttonRegistrar, constr);
	 //comienza Listar
	  constr.gridx=0;
      constr.gridy=2; //necesito borrar esto   
      constr.gridwidth = 2;
      constr.anchor = GridBagConstraints.CENTER;

	 JButton buttonListar = new JButton("Listar");
	 // add a listener to button
	 buttonListar.addActionListener(new ActionListener()
	 { 
		 public void actionPerformed(ActionEvent e)
		   {ventanas.listarAsesores();
			 menuOpciones.dispose();
			//comienza aca
		   //hasta aca
		   }
	 }); 
	 panel.add(buttonListar, constr);
	 //Terminar Listar
	 
	 //comenzar actualizar
	  constr.gridx=0;
      constr.gridy=3; //necesito borrar esto   
      constr.gridwidth = 5;
      constr.anchor = GridBagConstraints.CENTER;

	 JButton buttonActualizar = new JButton("Actualizar");
	 // add a listener to button
	 buttonActualizar.addActionListener(new ActionListener()
	 { 
		 public void actionPerformed(ActionEvent e)
		   {	ventanas.actualizarInicio();}
	 }); 
	 panel.add(buttonActualizar, constr); 
	 //terminar actualizar
	 // Comenzar Eliminar
	 
	 constr.gridx=0;
     constr.gridy=4; //necesito borrar esto   
     constr.gridwidth = 10;
     constr.anchor = GridBagConstraints.CENTER;

	 JButton buttonEliminar = new JButton("Eliminar");
	 // add a listener to button
	 buttonEliminar.addActionListener(new ActionListener()
	 { 
		 public void actionPerformed(ActionEvent e)
		   {	System.out.println("Eliminar asesores");}
	 }); 
	 panel.add(buttonEliminar, constr); 
	 
	 
	 //terminar eliminar
	 
	 mainPanel.add(headingPanel);
	 mainPanel.add(panel);
	 menuOpciones.add(mainPanel);
	 menuOpciones.pack();
	 menuOpciones.setSize(400, 300);
	 menuOpciones.setLocationRelativeTo(null);
	 menuOpciones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 menuOpciones.setVisible(true);		
	return menuOpciones;
		
	}
	
	
	
	public static String validarTodoslosCampos(boolean cedula, boolean telefono, boolean anio, boolean mes, boolean dia, boolean genero, boolean sede) {
		String resultado ="";
		if(!cedula) {
			resultado = resultado +" - La cedula debe ser un numero";	
		}
		if(!telefono) {
			resultado = resultado +"\n - El telefono debe ser un numero";
		}
		if(!anio) {
			resultado = resultado +"\n - El anio debe ser un numero y menor que el anio actual";
		}
		if(!mes) {
			resultado = resultado +"\n - El mes debe estar correcto";
		}
		if(!dia) {
			resultado = resultado +"\n - El dia debe estar correcto";
		}
		if(!genero) {
			resultado = resultado +"\n - Solo se acepta genero (Masculino o Femenino)";
		}
		if(!sede) {
			resultado = resultado +"\n - Solo se aceptan las 3 sedes (Ruta N, Puerto Seco y Buro )";
		}
		
		return resultado;
	}

}
