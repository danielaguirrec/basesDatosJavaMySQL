package practica2semilleroKonecta;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;

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
         JLabel userNameLabel = new JLabel("Ingrese el nombre del asesor :");
         JLabel userNameLabel = new JLabel("Ingrese el nombre del asesor :");
         
         
         
         
         
         
         
         JTextField userNameTxt = new JTextField(20);
         
         panel.add(userNameLabel, constr);
         constr.gridx=1;
         panel.add(userNameTxt, constr);
         constr.gridx=0; constr.gridy=1;
         
         constr.gridwidth = 2;
         constr.anchor = GridBagConstraints.CENTER;
         

         // Button with text "Register"
 JButton button = new JButton("Register");
 // add a listener to button
 button.addActionListener(new ActionListener()
 {
   public void actionPerformed(ActionEvent e)
   {
	   String validarCedula = userNameTxt.getText();
	   
	  // validarSiEsNum(validarCedula);
	   if(!validarSiEsNum(validarCedula)) {
		   headingLabel.setText("Los campos cedula y edad deben ser numeros");   
	   }
	   else {
		   headingLabel.setText("Buena validacion");
		     userNameTxt.setText("");
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

}
