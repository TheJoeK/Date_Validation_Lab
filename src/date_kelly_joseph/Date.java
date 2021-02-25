//----------------------------------------------------------------------
// Date.java              by Dale/Joyce/Weems                  Chapter 1
//
// Defines date objects having year, month, and day attributes.
//----------------------------------------------------------------------

/*
 * Joseph Kelly
 * CSC 245 Data Structures
 * Date difference program corrections
*/
package date_kelly_joseph;

public class Date
{
  protected int year, month, day;
  public static final int MINYEAR = 1583;

  // Constructor
  public Date(int newMonth, int newDay, int newYear)
  {
    month = newMonth;  day = newDay;  year = newYear;
   }

  // Observers
  public int getYear() { return year;  }
  public int getMonth(){ return month; }
  public int getDay()  { return day;   }
  
  
  
  public int lilian()
  {
    // Returns the Lilian Day Number of this date.
    // Precondition: This Date is a valid date after 10/14/1582.
    //
    // Computes the number of days between 1/1/0 and this date as if no calendar
    // reforms took place, then subtracts 578,100 so that 
    //October 15, 1582 is day 1. 
    
    // number of calculated days from 1/1/0 to 10/14/1582
    final int subDays = 578100;  

    int numDays = 0;

    // Add days in years.
    numDays = year * 365;

    // Add days in the months.
    if (month <= 2) 
      numDays = numDays + (month - 1) * 31;
    else 
      numDays = numDays + ((month - 1) * 31) - ((4 * (month-1) + 27) / 10);

    // Add days in the days.
    numDays = numDays + day;

    // Take care of leap years.
    numDays = numDays + (year / 4) - (year / 100) + (year / 400);

    // Handle special case of leap year but not yet leap day.
    if (month < 3) 
    {
        if ((year % 4) == 0)   numDays = numDays - 1;
        if ((year % 100) == 0) numDays = numDays + 1;
        if ((year % 400) == 0) numDays = numDays - 1;
    }

    // Subtract extra days up to 10/14/1582.
    numDays = numDays - subDays;
    return numDays;
  }
  
  //PART B of assignment
  //boolean method to check if entered date is a real date
  public boolean valid() throws IllegalDateException{
      boolean isValidDate = true;
      boolean isLeap = checkLeapYear(year);
      if(year<Date.MINYEAR){
          return false;
      } 
      else {
        if(month > 12)
                {
                    isValidDate = false;
                    
                }
                //months with 31 days
                else if (month == 1 || month == 3 || month == 5 || month ==  7 
                        || month ==  8 || month ==  10 || month == 12)
                {
                    if (day>=1 && day <= 31)
                    {   
                        isValidDate = true;
                    }
                    else
                    {
                        isValidDate = false;
                    }
                }
                //months with 30 days
                else if (month == 4 || month == 6 || month == 9 || month == 11)
                {
                    if (day>=1 && day <= 30)
                    {
                        isValidDate = true;
                    }
                    else
                    {
                        isValidDate = false;
                    }

                 }
                 else if (month == 2) // February
                 {
                    if (isLeap == true) 
                    {
                        if (day >= 1 && day <= 29)
                        {
                            isValidDate = true;
                        }
                        else
                        {
                            isValidDate = false;
                        }
                    }
                    else if (isLeap == false)
                    {
                        if (day>=1 && day <= 28)
                        {
                            isValidDate = true;
                        }
                        else
                        {
                            isValidDate = false;
                        }
                     }
                }
                if(year==Date.MINYEAR){
                      if(month==10 && day>14){
                          isValidDate =true;
                      }
                      else if(month>10 && month<13){
                          isValidDate =true;
                      }
                      else{
                          isValidDate = false;
                      }
                }
          
          
      }
      return isValidDate;
  }
  
  //boolean method to check if year is a leap year (aids the valid method)
  public boolean checkLeapYear(int year){

        boolean isLeapYear;
        
        isLeapYear = (year % 4 ==0);
        isLeapYear = isLeapYear && (year %100 != 0);
        isLeapYear = isLeapYear || (year % 400 == 0);
        return isLeapYear;
  }
  
  //PART C of assignment
  //int return method to compare two dates
  public int compareTo(Date secondDate){
      if(this.lilian() == secondDate.lilian()){
          return 0;
      }
      else if(this.lilian() > secondDate.lilian()){
          return 1;
      }
      else
          return -1;
  }
  
  
  @Override
  public String toString()
  // Returns this date as a String.
  {
    return(month + "/" + day + "/" + year);
  }
}
