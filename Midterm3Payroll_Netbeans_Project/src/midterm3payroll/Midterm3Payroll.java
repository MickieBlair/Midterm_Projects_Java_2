// Mickie Blair
// Midterm Project - Part 3 Payroll Class
// Payroll Class Demo

package midterm3payroll;

import javax.swing.JOptionPane;

public class Midterm3Payroll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //show introduction
        showIntro();
        
        //repeat program method
        repeatProgram(); 
    }
    
//show introduction to the program
public static void showIntro(){
        JOptionPane.showMessageDialog(null, "Payroll Program\n"
                  + "\nThe user will be asked to enter the employee's name,    "
                  + "\nID number, hourly pay rate and the number of hours      "
                  + "\nworked. The program will then calculate and display     "
                  + "\nthe gross pay of the employee."
                  + "\n\nThe program will validate user input using custom"
                  + "\nexceptions.");
    }
    
//repeat program
public static void repeatProgram(){
        String again;           //variable for do again
                
        //loop to do again
        do
        {
            //do this again
            payrollDemo();
            
            //ask the user if they would like to run the program again
            again = JOptionPane.showInputDialog("\nWould you like to run "
                        + "the program again? (Enter Y or N):  ");
            

            //verify input        
            while ((!again.equalsIgnoreCase("Y")) 
                    && (!again.equalsIgnoreCase("N"))){

                again = JOptionPane.showInputDialog("\nInvalid Entry\n"
                    + "Would you like to run the program again? "
                    + "(Enter Y or N):  ");
                
            }
        }
 
        while (again.equalsIgnoreCase("Y"));
        
        System.exit(0);
    }

//bank account and saving account demo program
public static void payrollDemo(){
    //create a new payroll object
    Payroll test = new Payroll(); 
    
    //call methods to set
    getEmployeeName(test);
    getIDNumber(test);
    getEmployeePayrate(test);
    getHoursWorked(test);

    //print the results
    JOptionPane.showMessageDialog(null,test);
}

/**
 * Get and Set Employee Name
 * @param demo Payroll Object
 */
public static void getEmployeeName(Payroll demo){
    //boolean for valid data entry
    boolean isValid = false;
    
    //ask user for input
    String name= JOptionPane.showInputDialog("Enter Employee Name:");
    
    //validation for input
    while(!isValid){
        try
          {
              demo.setName(name);
              isValid = true;
          }  
        catch (NameException e)
          {
              isValid = false;
              name= JOptionPane.showInputDialog(e.getMessage() 
                      + "\n\nEnter Employee Name:\n");
          }
     }
  }

/**
 * Get and Set ID Number
 * @param demo Payroll Object
 */
public static void getIDNumber(Payroll demo){
    //boolean for valid data entry
    boolean isValid = false;
    
    //ask user for input
    String id= JOptionPane.showInputDialog("Enter Employee ID Number:");
    
    //validation for input
    while(!isValid){
        try
          {
              demo.setIDNumber(id);
              isValid = true;
          }  
        catch (IDNumberException e)
          {
              isValid = false;
              id= JOptionPane.showInputDialog(e.getMessage() 
                      + "\n\nEnter Employee ID Number:\n");
          }
     }
  }

/**
 * Get and Set Employee Hourly Pay
 * @param demo Payroll Object
 */
public static void getEmployeePayrate(Payroll demo){
    //boolean for valid data entry
    boolean isValid = false;
    double empPay;
    //ask user for input
    String input= JOptionPane.showInputDialog("Enter Employee Hourly Pay Rate:");
    
    //validation for input
    while(!isValid){
        try
        {
            empPay = Double.parseDouble(input);
            demo.setHourlyPay(empPay);
            isValid = true;
        }  
        catch (NumberFormatException e)
        {
            isValid = false;
            input= JOptionPane.showInputDialog("Must be a Number."
                    + "\n\nEnter Employee Hourly Pay Rate:\n");
        }
        catch (PayRateException e)
        {
            isValid = false;
            input= JOptionPane.showInputDialog(e.getMessage() 
                      + "\n\nEnter Employee Hourly Pay Rate:\n");
        }
     }
  }

/**
 * Get and Set Hours Worked
 * @param demo Payroll Object
 */
public static void getHoursWorked(Payroll demo){
    //boolean for valid data entry
    boolean isValid = false;
    
    double hours;
    
    //ask user for input
    String input= JOptionPane.showInputDialog("Enter Hours Worked:");
    
    //validation for input
    while(!isValid){
        try
        {
            hours = Double.parseDouble(input);
            demo.setHoursWorked(hours);
            isValid = true;
        }  
        catch (NumberFormatException e)
        {
            isValid = false;
            input= JOptionPane.showInputDialog("Must be a Number."
                    + "\n\nEnter Hours Worked:\n");
        }
        catch (HoursWorkedException e)
        {
            isValid = false;
            input= JOptionPane.showInputDialog(e.getMessage() 
                      + "\n\nEnter Hours Worked:\n");
        }
     }
  }
}
