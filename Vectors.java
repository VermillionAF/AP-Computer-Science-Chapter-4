
// *********************************************************************************************
// Name: Patrick Wooden
// Date: November 16, 2015
// Project Name: Vectors.java
// 
// Inputs: X and Y components for V1 and V2, or magnitude and angle of V1 and V2.
// Number of inputs: Four for components, four for magnitude&angle
// Outputs: For components, it gives the angles of V1 and V2, along with components of Vsum and Vsum's magnitude and angle,
// where Vsum is the vector sum of V1 and V2.
// For magnitude & angle, 
//
// Description: This program was designed for AP Calculus BC, as a lot of work is done with both vector-valued functions
// and vectors, which often times involve adding two vectors together. Most problem types in the class give either magnitudes and angles, or the components
// of vectors, which set the basis for the two input methods that I created for this program. With this program, someone can input components of two vectors, and
// get the magnitude and angle of their given vectors, plus the components, angle, and magnitude of a vector sum of their two input vectors. Also, the angles are
// displayed in both degrees and radians. Someone could also input the magnitudes and angles of two separate vectors, then the program 
// will give them the x and y components of their input vectors, along with the components, magnitude, and angle of a sum vector of the two input vectors.
// The program will ask if they know their angles in degrees or radians for appropriate calculation, and then output angles in both degrees and radians.
// *********************************************************************************************
import java.util.*;

public class Vectors {
	public static boolean companswer = false, anganswer = false, dataanswer = false;
	public static String magmag, angang, magmag2, angang2;
	public static void main(String[] args) {
		double x1, x2, y1, y2; // declares variables inputed by user
		double magv, xv, yv, mgv, angvd, angvr, mag1, mag2, mg1, mg2, ang1r, ang2r, ang1d, ang2d;// declares variables created by program to be output
		double m_mag, m_ang, m_mag2, m_ang2, m_x1, m_x2, m_y1, m_y2, m_yv, m_xv, m_magv, m_mgv, m_angd, m_angr; // declares variables used in the magnitude&angle portion of the program
		// declares variables used for calculation
		
		Scanner scan = new Scanner(System.in);
		String answer, answer2;
		
		
		while (!companswer) {
			System.out.println("Do you know components or magnitude & angle? [C/M]");
			answer = scan.nextLine();
			
		if (answer.equalsIgnoreCase("C")) { // If the user indicates they know components, the program sends them here first.
				
		while(!dataanswer) {
			System.out.println("List the x and y components of V1.");
			String xx1 = scan.next(); // Sets x1 and y1 to be the values input by the user.
			String yy1 = scan.next();
			System.out.println("List the x and y components of V2");
			String xx2 = scan.next();
			String yy2 = scan.next();
			if (Vectors.isNumeric(xx1) && Vectors.isNumeric(xx2) && Vectors.isNumeric(yy1) && Vectors.isNumeric(yy2)) {
			x1 = Double.valueOf(xx1);
			y1 = Double.valueOf(yy1);
			x2 = Double.valueOf(xx2); // Sets x2 and y2 to be the values input by the user.
			y2 = Double.valueOf(yy2);

			
			// The following lines are the equations used to find the output data.
			mg1 = Math.pow(x1, 2) + Math.pow(y1, 2);// mg1 and mg2 are the squared magnitudes of the two input vectors.
			mg2 = Math.pow(x2, 2) + Math.pow(y2, 2);
			mag1 = Math.sqrt(mg1);// mag1 and mag2 are the magnitudes of input vectors (displayed).
			mag2 = Math.sqrt(mg2);
			ang1r = Math.atan2(x1,y1);// finds the angles of the two given vectors in radians (displayed).
			ang2r = Math.atan2(x2,y2);
			ang1d = Math.toDegrees(ang1r);// converts the angle measures into degrees (displayed).
			ang2d = Math.toDegrees(ang2r);
		
			xv = x1 + x2; // Finds the x and y components of the vector sum of the two given vectors (displayed).
			yv = y1 + y2;
			
			angvr = Math.atan2(xv, yv); // Finds the angle of the vector sum of the two given vectors in radians (displayed).
			angvd = Math.toDegrees(angvr);// Converts the measure of angvr to degrees (displayed).
			
			mgv = Math.pow(xv, 2) + Math.pow(yv, 2);// Finds the squared magnitude of the vector sum.
			magv = Math.sqrt(mgv);// Finds the magnitude of the vector sum of the two given vectors (displayed).
			// The system.out statements all print the data labeled previously with '(displayed)'.
			System.out.print("|V1| (magnitude) = ");
			System.out.printf("%.3f", mag1);
			System.out.print("\n|V2| (maagnitude) = ");
			System.out.printf("%.3f", mag2);
			System.out.print("\ntheta of V1 (degrees) = ");
			System.out.printf("%.3f", ang1d);
			System.out.print(", (radians) = ");
			System.out.printf("%.3f", ang1r);
			System.out.print("\ntheta of V2 (degrees) = ");
			System.out.printf("%.3f", ang2d);
			System.out.print(", (radians) = ");
			System.out.printf("%.3f", ang2r);
			System.out.print("\nVsum = <");
			System.out.printf("%.3f", xv);
			System.out.print(",");
			System.out.printf("%.3f", yv);
			System.out.print(">\n");
			System.out.print("|Vsum| (magnitude) = ");
			System.out.printf("%.3f", magv);
			System.out.print("\ntheta of Vsum (degrees) = ");
			System.out.printf("%.3f", angvd);
			System.out.print(", (radians) = ");
			System.out.printf("%.3f", angvr);
			companswer = true;
			dataanswer = true;
			}//end of if-numeric
			else if (!Vectors.isNumeric(xx1) || !Vectors.isNumeric(xx2) || !Vectors.isNumeric(yy1) || !Vectors.isNumeric(yy2)) {
				System.out.println("Input value(s) are not numeric, please try again.");
			}//end of if not numeric values
		}//end of if-components
		}//end of while dataanswer
		else if (answer.equalsIgnoreCase("M")) { //If the user indicates they know magnitude & angle, then the program goes here to start.
			dataanswer = false;
			while(!dataanswer) {
			System.out.println("What are the magnitude and angle of V1?");
			System.out.print("|V1| = ");
			magmag = scan.next();
			// User inputs the magnitude of the first vector as m_mag.
			System.out.print("theta = ");
			angang = scan.next();
			// User inputs the angle of the first vector as m_ang.
			System.out.println("What are the magnitude and angle of V2?");
			System.out.print("|V2| = ");
			magmag2 = scan.next();
			// User inputs the magnitude of the second vector as m_mag2.
			System.out.print("theta = ");
			angang2 = scan.next();
			if (Vectors.isNumeric(magmag) && Vectors.isNumeric(angang) && Vectors.isNumeric(magmag2) && Vectors.isNumeric(angang2)) {
				m_mag = Double.valueOf(magmag);
				m_ang = Double.valueOf(angang);
				m_mag2 = Double.valueOf(magmag2);
				m_ang2 = Double.valueOf(angang2);
				dataanswer = true;
			// User inputs the angle of the second vector as m_ang2.
			while(!anganswer) {
			System.out.println("Are the angles degrees or radians? [D/R]");
			answer2 = scan.next();// Prompts the user 
				switch(answer2) {// Begins a switch statement oriented around the value of answer2.
				case "D" :
				case "d" :
						m_ang = Math.toRadians(m_ang); // Converts the given angles into radians.
						m_ang2 = Math.toRadians(m_ang2);
						anganswer = true;
						dataanswer = true;
						
				case "R" :
				case "r" :
					// Performs all the necessary calculations of data to be output.
						m_x1 = m_mag * Math.cos(m_ang);// Finds the x component of the first given vector (displayed).
						m_y1 = m_mag * Math.sin(m_ang);// Finds the y component of the first given vector (displayed).
						m_x2 = m_mag2 * Math.cos(m_ang2);// Finds the x component of the second given vector (displayed).
						m_y2 = m_mag2 * Math.sin(m_ang2);// Finds the y component of the second given vector (displayed).
						m_xv = m_x1 + m_x2; // Uses the previously found components to find x and y components of the vector sum of the two given vectors (displayed).
						m_yv = m_y1 + m_y2;
						m_mgv = Math.pow(m_xv, 2) + Math.pow(m_yv, 2);// Finds the magnitude squared of the vector sum.
						m_magv = Math.sqrt(m_mgv);// Finds the magnitude of the vector sum (displayed).
						m_angr = Math.atan(m_yv / m_xv);// Finds the angle, in radians, of the vector sum (displayed).
						m_angd = Math.toDegrees(m_angr);// Converts the measure of the previous angle to degrees (displayed).
						// Shows all the data marked as (displayed) to the user, and formatted for easier viewing.
						System.out.print("V1 = <");
						System.out.printf("%.3f", m_x1);
						System.out.print(", ");
						System.out.printf("%.3f", m_y1);
						System.out.print(">\n");
						System.out.print("V2 = <");
						System.out.printf("%.3f", m_x2);
						System.out.print(", ");
						System.out.printf("%.3f", m_y2);
						System.out.print(">\n");
						System.out.print("\nVsum = <");
						System.out.printf("%.3f", m_xv);
						System.out.print(",");
						System.out.printf("%.3f", m_yv);
						System.out.print(">\n");
						System.out.print("|Vsum| = ");
						System.out.printf("%.3f", m_magv);
						System.out.print("\ntheta of Vsum (degrees) = ");
						System.out.printf("%.3f", m_angd);
						System.out.print(", (radians) = ");
						System.out.printf("%.3f", m_angr);
						anganswer = true;
						dataanswer = true;
						break;
						default: 
							if (!answer2.equalsIgnoreCase("D") && (!answer2.equalsIgnoreCase("R"))){ // If the user put a value that wasn't D or R, this portion is ran.
								System.out.println("That is not a D or R. Please try again.");
								break;
							}//end of if-not D or R in degrees/radians switch
								break;
								
						
						
						
				} //end of degrees/radians switch
			}//end of while-anganswer
			
			companswer = true;
			dataanswer = true;
			}//end of if ang and mag are numeric
			else if (!Vectors.isNumeric(magmag) || !Vectors.isNumeric(angang) || !Vectors.isNumeric(magmag2) || !Vectors.isNumeric(angang2)) {
				System.out.println("Input(s) were not numeric, please try again.");
			}//end of if ang and mag arent numeric
		}//end of dataanswer
			
		} //end of if-magnitude&angle
		
		
		else if (!answer.equalsIgnoreCase("C") && !answer.equalsIgnoreCase("M")){// Runs an else statement, which runs if the user inputs a value that isn't C or M at the start of the program.
			System.out.println("Please insert C or M, based on which you know.");
			
		} //end of else
		}//end of while-companswer
		
	} //end of main
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}

} // end of class
