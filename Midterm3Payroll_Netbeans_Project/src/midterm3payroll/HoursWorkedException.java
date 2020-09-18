// Mickie Blair
// Midterm Project - Part 3 Payroll Class
// Invalid Hours Worked Exception 

package midterm3payroll;

public class HoursWorkedException extends Exception{
    
    HoursWorkedException(){
        super("The hours worked must be between 0 and 84.");
    }
}
