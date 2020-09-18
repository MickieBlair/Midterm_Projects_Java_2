// Mickie Blair
// Midterm Project - Part 3 Payroll Class
// Invalid ID Number Exception 

package midterm3payroll;

public class IDNumberException extends Exception{
    
    IDNumberException(){
        super("ID Number is a Required Field.");
    }
}
