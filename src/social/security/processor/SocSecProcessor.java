/*
 * To change this license header, choose License Headers in 
 * Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package social.security.processor;

/**
 *
 * @author RPM
 */
import java.util.Scanner;  //Import scanner class for user input collection



public class SocSecProcessor 
{
    private static String name, ssn; // hold individual name and SSN

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String cont = "Y";
        
        //Scanner object receives user input
        Scanner input = new Scanner(System.in);  
        
        //Get input for name and SSN
        while(("Y".equals(cont)))   // continue while user chooses
        {
            System.out.println("Name? "); 
            name = input.nextLine(); 
            System.out.println("SSN? ");
            ssn = input.nextLine();
            
            try
            {
                isValid(ssn);       // test ssn format and values
                System.out.println(name + " " + ssn + " is valid");
                System.out.println("Continue? ");   // user choice
                cont = (input.nextLine()).toUpperCase();
            }
            catch(SocSecException e)
            {
                System.out.println(e.getMessage());
                System.out.println("Continue? "); // user choice
                cont = (input.nextLine()).toUpperCase();
            }
            
            
            
        }
        
    }
    
    // Method to test for valid ssn
    public static boolean isValid(String ssNum) throws SocSecException
    {
        ssn = ssNum;
        
        if(ssn.length() != 11)  // test ssn length for 11 places
        {
            throw new SocSecException("wrong number of characters");
        }
        for(int i = 0; i < 11; i++)
        {
            // test for dashes in right places
            if(((i == 3) || (i == 6)) && ssn.charAt(i) != '-')
                throw new SocSecException("dashes at wrong positions");
            // test for digits in remaining places
            if (((i != 3) && (i != 6)) && !Character.isDigit(ssn.charAt(i)))
                throw new SocSecException("contains a character that is not a digit");
        }
        return true;
        
    }
    
}
