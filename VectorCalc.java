/*
 * Name: Patrick Wooden
 * 
 * Revision 0: Initial version
 * 
 * Description: Program asks the user to pick a shape they wish to calculate surface area and
 * volume, and they input the required information into the given text fields. Program than displays 
 * a pop-up with an image and a brief statement about the shape. After this, the program will
 * output the surface area and volume.
 */

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.text.DecimalFormat;
import java.awt.Color;
import java.awt.Font;

public class VectorCalc extends JFrame {

	ImageIcon Icon = new ImageIcon("/Users/s960339/Documents/APCS/shaq.gif");
	
	public DecimalFormat tout = new DecimalFormat("##.00");
	public JTextField vx, vy, suar, volume, height;
	public JLabel vvx, vvy, surf, vol, clabel, mlabel, hei, check;
	public JButton CalculateButton;
	public JCheckBox angleBox;
	public String mtitle, cmessage, xstring, ystring;
	public double mag, ang, vxx, vyy;
	String[] types = {"Capsule","Circular Cone", "Circular Cylinder", "Cube", "Hemisphere", "Sphere"};
	public static Font font = new Font("Times New Roman", Font.BOLD,14);
	public static Font Output_font = new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16);

public VectorCalc() 
{
   setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
   vvx = new JLabel("V,x: ");
   add(vvx);
   vx = new JTextField(8);// Text box for radius
   add(vx);
   setEnabled(true);
   setVisible(true);
   vvy = new JLabel("V,y: ");
   add(vvy);
   vy = new JTextField(8);// Text box for length
   add(vy);
   setEnabled(true);
   setVisible(true);
   surf = new JLabel("|V|: ");
   add(surf);
   suar = new JTextField(8);// Text box used for surface area output
   add(suar);
   setEnabled(true);
   setVisible(true);
   vol = new JLabel("ϴ: ");
   add(vol);
   volume = new JTextField(8);// Text box used for volume output
   add(volume);
   setEnabled(true);
   setVisible(true);
   check = new JLabel("Do you know the angle?");
   add(check);
   setEnabled(true);
   setVisible(true);
   angleBox = new JCheckBox();
   add(angleBox);
   angleBox.addActionListener( new ActionListener ()
		   {
	   public void actionPerformed(ActionEvent event) {
		   vvx.setText("|V|: ");
		   vvy.setText("ϴ: ");
		   surf.setText("V,x: ");
		   vol.setText("V,y: ");
		   check.setText("You know the angle!");
		  if (!angleBox.isSelected()) {
			  vvx.setText("V,x: ");
			  vvy.setText("V,y: ");
			  surf.setText("|V|: ");
			  vol.setText("ϴ: ");
			  check.setText("Do you know the angle?");
		  }
	   } //end of checkbox actionPerformed
	
		   }); // end of actionListener for checkbox
   CalculateButton = new JButton("Calculate");// Calculate 
   add(CalculateButton);
   CalculateButton.addActionListener( new ActionListener()
	  {
		public void actionPerformed(ActionEvent event) {
		if (vx.getText().isEmpty()) {
			vx.setText("0");
		}//end of if radius is empty
		if (vy.getText().isEmpty()) {
			vy.setText("0");
		}// end of if side is empty
		String vxstr = vx.getText();
		Double vxv = Double.valueOf(vxstr);
		String vystr = vy.getText();
		Double vyv = Double.valueOf(vystr);
		int switchInt;
		if (angleBox.isSelected()) {
			switchInt = 1;
		}//end of if anglebox is selected
		else {
			switchInt = 0;
		}
		switch (switchInt)
		{
		case 0: 
		double magPart = (Math.pow(vxv, 2) + Math.pow(vyv, 2));
		mag = Math.sqrt(magPart);
		double pretan = (vyv / vxv);
		ang = Math.atan(pretan);
		xstring = tout.format(mag);
		ystring = tout.format(ang);
		break;
		case 1: 
		vxx = vxv * Math.cos(vyv);
		vyy = vxv * Math.sin(vyv);
		xstring = tout.format(vxx);
		ystring = tout.format(vyy);
		break;
		}  //** switch
		
		
		
	
		
		suar.setText("");
		volume.setText("");
		suar.setText(xstring);
		if (switchInt == 0) {
			volume.setText(ystring + " rad");
		}//end of if switchint 1
		else {
		volume.setText(ystring);
		}//end of else switchint ystring
		}//** actionPerformed
	  });  //** Action Listener
	   
	} //** ShapesGUI constructor
public static void main(String[] args) 
{
VectorCalc frame = new VectorCalc();	//Manages the appearance of the GUI
frame.setTitle("Vectors Calculator");
frame.setFont(font);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(330, 200);
frame.setBackground(Color.CYAN);
frame.getContentPane().setBackground(Color.orange);
frame.setVisible(true);


} //** main

}  //** class