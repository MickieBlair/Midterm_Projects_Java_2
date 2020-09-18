// Mickie Blair
// Midterm Project - Part 3 Payroll Class
// Invalid Payrate Exception 

package midterm3payroll;

public class PayRateException extends Exception{
    
    PayRateException(){
        super("The hourly payrate must be between $0.00 and $25.00.");
    }
    
}
