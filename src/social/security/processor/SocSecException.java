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
public class SocSecException extends Exception
{
    
    /**
    *  constructor takes string arg for specific error
    */

   public SocSecException(String str)
   {
      super("Invalid social security number, "+ str);
   }

      
    
}
