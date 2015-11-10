import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

// Exploration 1:  Choose a small image, it can be your picture, the LNSTEM logo, or some other file.
//                 Store the image on your MACAIR.  Find the line below (there is an EXPLORATION 1 NOTE
//			       comment above it) which says final ImageIcon... and change the value found there, to
//                 be the address of your chosen image.  Then run the code
// Exploration 2:  The program has a case statement, and then several if (psel ==...) statements with
//				   code per "if".  Instead, do the following modifications:
//             A.  Write a new method called "popup" which receives three strings.  This method will have
//                 clabel, mlabel, mtitle lines of code.  However these lines will use the three strings
//                 passed to the method.  The JOptionPane line of code will be inside the method.
//             B.  In the switch-case statement that operates on psel, set values for the clabel, mlabel,
//                 mtitle strings specific to the case, then call new method "popup" with these three values.
//             C.  Delete all of the "if (psel == ...) code blocks.  That code has now been optimized by a
//                 single method, and the new switch-case statement
//			   D.  Debug and run your code
//  Exploration 3: AFTER EXPLORATION 1 AND 2 ARE DONE, and code compiles\runs successfully
//                 See Canvas Assignment

public class PWeights extends JFrame 
{

	//****************************************
	//**  GUI Structure
	//**  Title: Planetary Weight Calculator
	//**  Weight prompt (jlabel, jtext)
	//**  planet pulldown
	//**  Weight on planet (jlabel, jtext)
	//**  calculate button
	//****************************************
	// EXPLORATION 1 NOTE:   Modify the following line so that it points to the location of your image
	final ImageIcon Icon = new ImageIcon("/Users/s960339/Documents/APCS/shaq.gif");
	
	//  JTextField is a GUI place where strings can be written by this program
	//  JLabels are names of places on the GUI where a label will appear.  The label field is just that,
	//  a descriptor that explains to a user what appears in the accompanying JTextField box
	//  JComboBox is the name of a GUI device that can show a vertical list of choices, i.e. days of the
	//  week, names of planets in the solar system
	//  JButton is an action device.  It is shown, with a label, on the GUI.  In this case, the label is
	//  Calculate, and when the user clicks on it, the program reads JComboBox selection, earth weight,
	//  calculates weight on the specified planet, and updates the JTextField with planetary weight
	
	public JTextField studente, studentp;
	public JLabel weight, wplanet, clabel, mlabel;
	public JComboBox planets;
	public JButton CalculateButton;
	public double multiplier = 1, pweight;
	public String mtitle, cmessage;
	String[] solarsystem = {"Sun","Mercury", "Venus", "Moon", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
	public static Font font = new Font("Times New Roman", Font.BOLD,14);
	public static Font Output_font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);
	
	public PWeights()
	{
	   setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
	   weight = new JLabel("Earth Weight (lbs)");
	   add(weight);
	   studente = new JTextField(8);
	   add(studente);
	   setEnabled(true);
	   setVisible(true);
	   wplanet = new JLabel("Planet weight (lbs)");
	   add(wplanet);
	   studentp = new JTextField(8);
	   add(studentp);
	   setEnabled(true);
	   setVisible(true);
	   final JComboBox planets = new JComboBox(solarsystem);
	   planets.setSelectedIndex(0);
	   add(planets);
	   setEnabled(true);
	   CalculateButton = new JButton("Calculate");
	   add(CalculateButton);
	   
	//** g multiplier on planets, sun, moon
	//** Sun = 27.755
	//** Moon = 0.18
	//** Mercury = 0.377
	//** Venus = 0.905
	//** Mars = 0.378
	//** Jupiter = 2.54
	//** Uranus = 0.905
	//** Neptune = 1.14
	//** Saturn = 1.06
	  CalculateButton.addActionListener( new ActionListener()
	  {
		public void actionPerformed(ActionEvent event)
		{
		String rstring = studente.getText();
		Double sweight = Double.valueOf(rstring);
		String wmessage = "WOW, THAT IS HEAVY";
		String wtitle = "ARE YOU KIDDING?";
		if (sweight > 200) JOptionPane.showMessageDialog(null,  wmessage, wtitle, JOptionPane.PLAIN_MESSAGE);
		int psel = planets.getSelectedIndex();
		switch (psel)
		{
		case 0: multiplier = 27.755; break;
		case 1: multiplier = 0.377; break;
		case 2: multiplier = 0.905; break;
		case 3: multiplier = 0.18; break;
		case 4: multiplier = 0.378; break;
		case 5: multiplier = 2.54; break;
		case 6: multiplier = 1.06; break;
		case 7: multiplier = 0.905; break;
		case 8: multiplier = 1.14; break;
		}  //** switch
		cmessage = "Why are you weighing yourself on the Sun?";
		
// EXPLORATION 2:
// Following code will be replaced as described above
		if (psel == 0) 
		{
		    clabel =new JLabel( "The Sun generates heat from Nuclear Fusion");
		    clabel.setFont(Output_font);
			mtitle = "Sun fact";
			mlabel = new JLabel("Sun Fact");
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
// END OF EXPLORATION 2 BLOCK
		
		pweight = sweight * multiplier;
		DecimalFormat tout = new DecimalFormat("##.00");
		String tstring = tout.format(pweight);
		studentp.setText("");
		studentp.setText(tstring);
		}//** actionPerformed
	  });  //** Action Listener
	   
	} //** PWeights constructor
	
	public static void main(String[] args) 
	{
	PWeights frame = new PWeights();	
	frame.setTitle("L&N Solar System Weight Calculator");
	frame.setFont(font);
	frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(500, 200);
	frame.setBackground(Color.CYAN);
	frame.getContentPane().setBackground(Color.lightGray);
	frame.setVisible(true);
	

	} //** main

}  //** class
