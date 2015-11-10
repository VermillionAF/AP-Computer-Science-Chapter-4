import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

public class ShapesGUI extends JFrame {

	final ImageIcon Icon = new ImageIcon("/Users/s960339/Documents/APCS/shaq.gif");
	final ImageIcon Icon2 = new ImageIcon("/Users/s960339/Documents/APCS/36.gif");
	final ImageIcon Icon3 = new ImageIcon("/Users/s960339/Documents/APCS/giphy.gif");
	final ImageIcon Icon4 = new ImageIcon("/Users/s960339/Documents/APCS/John-Cena-Shock-to-Smile.gif");
	
	
	public JTextField radius, side, suar, volume;
	public JLabel rad, sidep, surf, vol, clabel, mlabel;
	public JComboBox shapes;
	public JButton CalculateButton;
	public String mtitle, cmessage;
	public double sa, volumee;
	String[] difshapes = {"Capsule","Circular Cone", "Circular Cylinder", "Cube", "Hemisphere", "Sphere"};
	public static Font font = new Font("Times New Roman", Font.BOLD,14);
	public static Font Output_font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);

public ShapesGUI()
{
   setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
   rad = new JLabel("Radius (m)");
   add(rad);
   radius = new JTextField(8);// Text box for radius
   add(radius);
   setEnabled(true);
   setVisible(true);
   sidep = new JLabel("Length (m)");
   add(sidep);
   side = new JTextField(8);// Text box for length
   add(side);
   setEnabled(true);
   setVisible(true);
   surf = new JLabel("Surface Area (m^2)");
   add(surf);
   suar = new JTextField(8);// Text box used for surface area output
   add(suar);
   setEnabled(true);
   setVisible(true);
   vol = new JLabel("Volume (m^3)");
   add(vol);
   volume = new JTextField(8);// Text box used for volume output
   add(volume);
   setEnabled(true);
   setVisible(true);
   final JComboBox planets = new JComboBox(difshapes);
   planets.setSelectedIndex(0);
   add(planets);
   setEnabled(true);
   CalculateButton = new JButton("Swagulate");// Calculate 
   add(CalculateButton);
   CalculateButton.addActionListener( new ActionListener()
	  {
		public void actionPerformed(ActionEvent event)
		{
		String rstring = radius.getText();
		Double rvalue = Double.valueOf(rstring);
		String hstring = side.getText();
		Double hvalue = Double.valueOf(hstring);
		String wmessage = "WOW, THAT IS HEAVY";
		String wtitle = "ARE YOU KIDDING?";
		int psel = planets.getSelectedIndex();
		switch (psel)
		{
		case 0: 
		sa = (2 * Math.PI * rvalue) * (2 * rvalue + hvalue);
		volumee = (Math.PI * Math.pow(rvalue, 2)) * ((4/3)*rvalue + hvalue);
		break;
		case 1: 
		double slant = Math.sqrt(Math.pow(rvalue, 2) + Math.pow(hvalue, 2));
		sa = (Math.PI * Math.pow(rvalue, 2)) + (Math.PI * rvalue * slant);	
		double volumepart = (Math.PI * Math.pow(rvalue, 2) * hvalue);
		volumee = volumepart * (1/3);
		break;
		case 2:
		volumee = Math.PI * Math.pow(rvalue, 2) * hvalue;
		sa = (2 * Math.PI * rvalue * hvalue) + (2 * (Math.PI * Math.pow(rvalue, 2))); 
		break;
		case 3: 
		rvalue = 0.0;
		volumee = Math.pow(hvalue, 3);
		sa = 6 * Math.pow(hvalue, 2); 
		break;
		case 4:
		hvalue = 0.0;
		volumee = (2.0 / 3.0) * Math.PI * Math.pow(rvalue, 3);
		sa = 3 * Math.PI * Math.pow(rvalue, 2); 
		break;
		case 5:
		hvalue = 0.0;
		volumee = (4 / 3) * Math.PI * Math.pow(rvalue, 3);
		sa = 4 * Math.PI * Math.pow(rvalue, 2);
		break;
		}  //** switch
		cmessage = "Why are you weighing yourself on the Sun?";
		
//EXPLORATION 2:
//Following code will be replaced as described above
		if (psel == 0) 
		{
		    clabel =new JLabel( "Capsules are cool!");
		    clabel.setFont(Output_font);
			mtitle = "Fun Fact: Capsules";
			mlabel = new JLabel("Capsule Fact");
			mlabel.setFont(Output_font);	    
			JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		String mmessage = "Remember, no air on the Moon";
		if (psel ==1)
		{
		    mtitle = "Fun Fact: Cones";
			clabel =new JLabel( "I love cones, especially full of ice cream!");
		    clabel.setFont(Output_font);
		    JOptionPane.showMessageDialog(null, clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon2);
		}
		
		if (psel ==2)
		{
		    mtitle = "Fun Fact: Cylinders";
			clabel =new JLabel( "Cylinders are just circles, but taller!");
		    clabel.setFont(Output_font);	    
		    JOptionPane.showMessageDialog(null, clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon3);
		}
		
		if (psel == 3)
		{
		mtitle = "Fun Fact: Cubes";
		clabel =new JLabel("A cube is a square that just didn't think two dimensions were enough.");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon3);
		}
		
		if (psel == 4)
		{
		mtitle = "Fun Fact: Hemispheres";
		cmessage = "Hemispheres: for when a sphere is just too much!";
		JOptionPane.showMessageDialog(null,  cmessage, mtitle, JOptionPane.PLAIN_MESSAGE, Icon2);
		}
		
		if (psel == 5)
		{
		mtitle = "Fun Fact: Spheres";
		clabel =new JLabel( "Spheres make the world go round!");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon4);
		}
		
	
//END OF EXPLORATION 2 BLOCK
		
		DecimalFormat tout = new DecimalFormat("##.00");
		String tstring = tout.format(sa);
		String vstring = tout.format(volumee);
		suar.setText("");
		volume.setText("");
		suar.setText(tstring);
		volume.setText(vstring);
		}//** actionPerformed
	  });  //** Action Listener
	   
	} //** PWeights constructor
public static void main(String[] args) 
{
ShapesGUI frame = new ShapesGUI();	
frame.setTitle("Patrick's Mighty Shapes Calculator");
frame.setFont(font);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 200);
frame.setBackground(Color.CYAN);
frame.getContentPane().setBackground(Color.cyan);
frame.setVisible(true);


} //** main

}  //** class