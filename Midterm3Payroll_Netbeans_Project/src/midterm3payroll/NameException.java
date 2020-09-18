// Mickie Blair
// Midterm Project - Part 3 Payroll Class
// Invalid Name Exception 

package midterm3payroll;

public class NameException extends Exception{
    
    NameException(){
        super("Employee Name is a Required Field.");
    }
   
}
