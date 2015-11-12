import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

public class ShapesGUI extends JFrame {

	ImageIcon Icon = new ImageIcon("/Users/s960339/Documents/APCS/shaq.gif");
	
	public JTextField radius, side, suar, volume;
	public JLabel rad, sidep, surf, vol, clabel, mlabel;
	public JButton CalculateButton;
	public String mtitle, cmessage;
	public double sa, volumee;
	String[] difshapes = {"Capsule","Circular Cone", "Circular Cylinder", "Cube", "Hemisphere", "Sphere"};
	String[] icons = {"/Users/s960339/Documents/APCS/shaq.gif", "/Users/s960339/Documents/APCS/36.gif", 
			"/Users/s960339/Documents/APCS/giphy.gif", "/Users/s960339/Documents/APCS/John-Cena-Shock-to-Smile.gif", "/Users/s960339/Documents/APCS/Techno-Viking1.gif"};
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
   radius.setText("0");
   sidep = new JLabel("Length (m)");
   add(sidep);
   side = new JTextField(8);// Text box for length
   add(side);
   setEnabled(true);
   setVisible(true);
   side.setText("0");
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
   final JComboBox shape = new JComboBox(difshapes);
   shape.setSelectedIndex(0);
   add(shape);
   setEnabled(true);
   CalculateButton = new JButton("Swagulate");// Calculate 
   add(CalculateButton);
   CalculateButton.addActionListener( new ActionListener()
	  {
		public void actionPerformed(ActionEvent event) {
		String rstring = radius.getText();
		Double rvalue = Double.valueOf(rstring);
		String hstring = side.getText();
		Double hvalue = Double.valueOf(hstring);
		int rng = (int) (Math.random() * 50);
		if (rng >= 0 && rng < 10) {
			// random number generator that determines what icon is used for the pop-up
			Icon = new ImageIcon(icons[0]);
		}
		else if (rng >= 10 && rng < 20) {
			Icon = new ImageIcon(icons[1]);
		}
		else if (rng >= 20 && rng < 30) {
			Icon = new ImageIcon(icons[2]);
		}
		else if (rng >= 30 && rng < 40) {
			Icon = new ImageIcon(icons[3]);
		}
		else {
			Icon = new ImageIcon(icons[4]);
		}
		//rvalue and hvalue are the double values of the two user inputs
		int psel = shape.getSelectedIndex();
		switch (psel)
		{
		case 0: // Capsule case
		sa = (2 * Math.PI * rvalue) * (2 * rvalue + hvalue);
		volumee = (Math.PI * Math.pow(rvalue, 2)) * ((4/3)*rvalue + hvalue);
		break;
		case 1: // Cone case
		double slant = Math.sqrt(Math.pow(rvalue, 2) + Math.pow(hvalue, 2));
		sa = (Math.PI * Math.pow(rvalue, 2)) + (Math.PI * rvalue * slant);	
		double volumepart = (Math.PI * Math.pow(rvalue, 2) * hvalue);
		volumee = volumepart * (1/3);
		break;
		case 2: // Cylinder case
		volumee = Math.PI * Math.pow(rvalue, 2) * hvalue;
		sa = (2 * Math.PI * rvalue * hvalue) + (2 * (Math.PI * Math.pow(rvalue, 2))); 
		break;
		case 3: // Cube case
		volumee = Math.pow(hvalue, 3);
		sa = 6 * Math.pow(hvalue, 2); 
		break;
		case 4: // Hemisphere case
		volumee = (2.0 / 3.0) * Math.PI * Math.pow(rvalue, 3);
		sa = 3 * Math.PI * Math.pow(rvalue, 2); 
		break;
		case 5: // Sphere case
		volumee = (4 / 3) * Math.PI * Math.pow(rvalue, 3);
		sa = 4 * Math.PI * Math.pow(rvalue, 2);
		break;
		}  //** switch
		
		if (psel == 0) 
		{
		    clabel =new JLabel( "Capsules are cool!");
		    clabel.setFont(Output_font);
			mtitle = "Fun Fact: Capsules";
			mlabel = new JLabel("Capsule Fact");
			mlabel.setFont(Output_font);	    
			JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}// end of if 0
		String mmessage = "Remember, no air on the Moon";
		if (psel ==1)
		{
		    mtitle = "Fun Fact: Cones";
			clabel =new JLabel( "I love cones, especially full of ice cream!");
		    clabel.setFont(Output_font);
		    JOptionPane.showMessageDialog(null, clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}// end of if 1
		
		if (psel ==2)
		{
		    mtitle = "Fun Fact: Cylinders";
			clabel =new JLabel( "Cylinders are just circles, but taller!");
		    clabel.setFont(Output_font);	    
		    JOptionPane.showMessageDialog(null, clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}// end of if 2
		
		if (psel == 3)
		{
		mtitle = "Fun Fact: Cubes";
		clabel =new JLabel("A cube is a square that just didn't think two dimensions were enough.");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}// end of if 3
		
		if (psel == 4)
		{
		mtitle = "Fun Fact: Hemispheres";
		cmessage = "Hemispheres: for when a sphere is just too much!";
		JOptionPane.showMessageDialog(null,  cmessage, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}// end of if 4
		
		if (psel == 5)
		{
		mtitle = "Fun Fact: Spheres";
		clabel =new JLabel( "Spheres make the world go round!");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}// end of if 5
		
	
		
		DecimalFormat tout = new DecimalFormat("##.00");
		String tstring = tout.format(sa);
		String vstring = tout.format(volumee);
		suar.setText("");
		volume.setText("");
		suar.setText(tstring);
		volume.setText(vstring);
		}//** actionPerformed
	  });  //** Action Listener
	   
	} //** ShapesGUI constructor
public static void main(String[] args) 
{
ShapesGUI frame = new ShapesGUI();	//Manages the appearance of the GUI
frame.setTitle("Patrick's Mighty Shapes Calculator");
frame.setFont(font);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 200);
frame.setBackground(Color.CYAN);
frame.getContentPane().setBackground(Color.yellow);
frame.setVisible(true);


} //** main

}  //** class