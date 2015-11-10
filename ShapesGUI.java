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
	
	public JTextField radius, side, length;
	public JLabel rad, sidep, clabel, mlabel;
	public JComboBox shapes;
	public JButton CalculateButton;
	public String mtitle, cmessage;
	public double sa;
	String[] difshapes = {"Capsule","Circular Cone", "Circular Cylinder", "Cube", "Hemisphere", "Sphere", "Spherical Segment", "Tube"};
	public static Font font = new Font("Times New Roman", Font.BOLD,14);
	public static Font Output_font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);

public ShapesGUI()
{
   setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
   rad = new JLabel("Radius (m)");
   add(rad);
   radius = new JTextField(8);
   add(radius);
   setEnabled(true);
   setVisible(true);
   sidep = new JLabel("Planet weight (lbs)");
   add(sidep);
   side = new JTextField(8);
   add(side);
   setEnabled(true);
   setVisible(true);
   final JComboBox planets = new JComboBox(difshapes);
   planets.setSelectedIndex(0);
   add(planets);
   setEnabled(true);
   CalculateButton = new JButton("Calculate");
   add(CalculateButton);
   CalculateButton.addActionListener( new ActionListener()
	  {
		public void actionPerformed(ActionEvent event)
		{
		String rstring = radius.getText();
		Double sweight = Double.valueOf(rstring);
		String wmessage = "WOW, THAT IS HEAVY";
		String wtitle = "ARE YOU KIDDING?";
		if (sweight > 200) JOptionPane.showMessageDialog(null,  wmessage, wtitle, JOptionPane.PLAIN_MESSAGE);
		int psel = planets.getSelectedIndex();
		switch (psel)
		{
		case 0: ; break;
		case 1: ; break;
		case 2: ; break;
		case 3: ; break;
		case 4: ; break;
		case 5: ; break;
		case 6: ; break;
		case 7: ; break;
		case 8: ; break;
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
		    mtitle = "Mercury Fact";
			clabel =new JLabel( "Average daytime temperature on Mercury is 672F");
		    clabel.setFont(Output_font);
		    JOptionPane.showMessageDialog(null, clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		
		if (psel ==2)
		{
		    mtitle = "Venus Fact";
			clabel =new JLabel( "Venus rotates once every 243 days");
		    clabel.setFont(Output_font);	    
		    JOptionPane.showMessageDialog(null, clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		
		if (psel == 3)
		{
		mtitle = "Moon Fact";
		clabel =new JLabel("China launched a lunar rover last year.");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		
		if (psel == 4)
		{
		mtitle = "Mars Fact";
		cmessage = "Check recent photos from rover Curiosity on Nasa website";
		JOptionPane.showMessageDialog(null,  cmessage, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		
		if (psel == 5)
		{
		mtitle = "Jupiter Fact";
		clabel =new JLabel( "Jupiter rotates faster than any planet, 10 hours");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		
		if (psel == 6)
		{
		mtitle = "Saturn Fact";
		clabel =new JLabel( "Saturn's magnetic field is 578 times stronger than Earth's");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
		
		if (psel == 7)
		{
		mtitle = "Uranus Fact";
		clabel =new JLabel( "Uranus rotates perpendicular to its orbit");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
	
		if (psel == 8)
		{
		mtitle = "Neptune Fact";
		clabel =new JLabel( "Neptune radiates more heat than it absorbs");
	    clabel.setFont(Output_font);
		JOptionPane.showMessageDialog(null,  clabel, mtitle, JOptionPane.PLAIN_MESSAGE, Icon);
		}
//END OF EXPLORATION 2 BLOCK
		
		DecimalFormat tout = new DecimalFormat("##.00");
		String tstring = tout.format(sa);
		sidep.setText("");
		sidep.setText(tstring);
		}//** actionPerformed
	  });  //** Action Listener
	   
	} //** PWeights constructor
public static void main(String[] args) 
{
ShapesGUI frame = new ShapesGUI();	
frame.setTitle("The Dankest Surface Area Calculator");
frame.setFont(font);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(500, 200);
frame.setBackground(Color.CYAN);
frame.getContentPane().setBackground(Color.lightGray);
frame.setVisible(true);


} //** main

}  //** class