import java.util.Scanner;


/************************************************
 *  File:		LNStudent
 *  Author:		J.Foy
 *  Created:	7/14/2015
 *  Defines a class used in Ch4Demo program
 *  Revision History
 *  	Rev 0:	Initial Release
 *  
 */
public class LNStudent 
{
// Following are instance variables, each LNStudent object
// will have unique values for these variables
	
 private String LNName;
 private String LNId;
 private int LNYear;
 private String LNPhnr;

 // constructor, it initializes instance variables
 public LNStudent(String sname, String studentID, int syear, String sphnr)
 {
	LNName = sname;
	LNId = studentID;
	LNYear = syear;
	LNPhnr = sphnr;	
 }
 
 // overloaded constructor.  Fill this in according to exploration 1.  You need to
 // explicitly assign values to LNName, LNId, LNYear, LNPhnr
 public LNStudent()
 {
	
 }
 
 // getName: method which displays LNStudent object name
 public String getName()
 {
	return this.LNName; 
 }
 
// setPhNr: method which permits update of student phone number	
 public void setPhNr(String sphnr)
 {
   this.LNPhnr = sphnr;	 
 }
 
// getPhNr: method which returns phone number for an LNStudent object
 public String getPhNr()
 {
	return this.LNPhnr; 
 }
 
//  getID: returns student ID for an LNStudent object.
 public String getID()
 {
  return this.LNId;	 
 }
//getID: returns student ID for an LNStudent object.
public int getYear()
{
return this.LNYear;	 
}
 // toString: not called as a method, rather it is called by
 // System.out.print, System.out.println with an LNStudent object
   public String toString()
 {
	 return LNName + ", " + LNId; 
 }
} // end of class
