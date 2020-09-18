// Mickie Blair
// Midterm Project - Part 3 Payroll Class
// Payroll Class 

package midterm3payroll;

public class Payroll {
    //fields
    String name;
    String idNumber;
    double hourlyPay;
    double hoursWorked;
    
    /**
     * No Args Constructor
     */
    Payroll(){
        this.name = "";
        this.idNumber = "";
        this.hourlyPay = 0.0;
        this.hoursWorked = 0.0;
    }
    
    
    /**
     * Constructor
     * @param n Name
     * @param id ID Number
     * @throws NameException
     * @throws IDNumberException
     */
    Payroll(String n, String id){
        this.name = n;
        this.idNumber = id;
        this.hourlyPay = 0.0;
        this.hoursWorked = 0.0;
    }
    
    /**
     * Set Name
     * @param n Name
     * @throws NameException
     */
    public void setName(String n) throws NameException{
        if (n.equals(""))
        {
           throw new NameException();
        } 
        else
        {
           this.name = n;
        }       
}
    
    /**
     * Set ID number
     * @param idnum ID Number
     * @throws IDNumberException
     */
    public void setIDNumber(String idnum) throws IDNumberException{
        if (idnum.equals(""))
        {
           throw new IDNumberException();
        } 
        else
        {
           this.idNumber = idnum; 
        }
    }
    
    /**
     * Set Hourly Pay Rate
     * @param payrate Hourly Pay Rate
     * @throws PayRateException
     */
    public void setHourlyPay(double payrate) throws PayRateException{
        if (payrate<0 || payrate > 25.00 )
        {
           throw new PayRateException();
        } 
        else
        {
           this.hourlyPay = payrate;
        }
        
    }
    
    /**
     * Set Hours Worked
     * @param hours Hours Worked
     * @throws HoursWorkedException
     */
    public void setHoursWorked(double hours) throws HoursWorkedException{
        if (hours < 0 || hours > 84.00 )
        {
           throw new HoursWorkedException();
        } 
        else
        {
           this.hoursWorked = hours;
        }
        
    }
    
    /**
     * Get Name
     * @return Name
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get ID number
     * @return ID Number
     */
    public String getIDNumber(){
        return this.idNumber;
    }
    
    /**
     * Get Hourly Pay Rate
     * @return Hourly Pay Rate
     */
    public double getHourlyPay(){
        return this.hourlyPay;
    }
    
    /**
     * Get Hours Worked
     * @return Hours Worked
     */
    public double getHoursWorked(){
        return this.hoursWorked;
    }
    
    /**
     * Calculate Gross Pay
     * @return Gross Pay
     */
    public double calcGrossPay(){
        return this.hourlyPay * this.hoursWorked;
    }
    
    @Override
    public String toString(){
        String str = String.format("%-20s%-20s\n%-20s%-20s\n\n%-20s$%8.2f\n"
                + "%-20s%9.1f\n\n%-20s$%8.2f\n",
                "Employee Name:  ", getName(),
                "ID Number:                 ", getIDNumber(),
                "Hourly Pay Rate:       ", getHourlyPay(),
                "Hours Worked:           ", getHoursWorked(),
                "Gross Pay:                 ", calcGrossPay());
        
        return str;
    }
    
    
    
    
}
