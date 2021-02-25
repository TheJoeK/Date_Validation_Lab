//----------------------------------------------------------------------
// DaysBetween.java          by Dale/Joyce/Weems               Chapter 1
//
// Asks the user to enter two "modern" dates and then reports 
// the number of days between the two dates.
//----------------------------------------------------------------------

/*
 * Joseph Kelly
 * CSC 245 Data Structures
 * Date difference program corrections
*/
package date_kelly_joseph;

import java.util.Scanner;
import java.util.InputMismatchException;

//import ch01.dates.*;

public class Date_Kelly_Joseph
{
  public static void main(String[] args) throws IllegalDateException
  {
     
        Scanner scan;// = //new Scanner(System.in);
        int day = 0, month = 0, year = 0;
        
         
        
    //for loop to test program 10 times
    for(int i = 1; i <=10;i++){
        //modified out statements to improve text format
        boolean validDate = true;
        scan = new Scanner(System.in);
        System.out.println("Attempt: "+ i);
        System.out.println("-------------------------------------------------");
        System.out.println("Enter two 'modern' dates: month day year");
        System.out.println("For example, January 21, 1939, would be:1 21 1939");
        System.out.println();
        System.out.println("Modern dates are not before " + Date.MINYEAR + ".");
        System.out.println();

        System.out.println("Enter the first date:");
        
        //If-else blocks determining valid input or not
        try{  
            month = scan.nextInt();
//            if(month <1 || month>12){
//                System.out.println("Illegal input was entered\n");
//                validDate = false;
//            }
            //else{
                
                try{  
                    day = scan.nextInt();
                    try{  
                        year = scan.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Illegal input was entered\n");
                        validDate = false;

                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Illegal input was entered\n");
                    validDate = false;

                } 

            //}

        }
        catch(InputMismatchException e){
            System.out.println("Illegal input was entered\n");
            scan = new Scanner(System.in);
            validDate = false;
        }

        //Date object created and int variables sent as parameters
        Date d1 = new Date(month, day, year);
        
            try {

                    if(!d1.valid()){
                        validDate = false;
                        throw new IllegalDateException("\nIllegal Date\n");
                        
                    }
            } catch (IllegalDateException ex) {
                
                System.out.println(ex.getMessage());

            }
        if(validDate){
            System.out.println("Enter the second date:");

            //If-else blocks determining valid input or not
            try{  
            month = scan.nextInt();
//            if(month <1 || month>12){
//                System.out.println("Illegal input was entered\n");
//                validDate = false;
//            }
            //else{
                
                try{  
                    day = scan.nextInt();
                    try{  
                        year = scan.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Illegal input was entered\n");
                        validDate = false;

                    }
                }
                catch(InputMismatchException e){
                    System.out.println("Illegal input was entered\n");
                    validDate = false;

                } 

            //}

        }
            catch(InputMismatchException e){
                System.out.println("Illegal input was entered\n");
                validDate = false;

            }
            //Date object created and int variables sent as parameters
            Date d2 = new Date(month, day, year);
                try {
                     if(!d2.valid() || !validDate){
                         validDate = false;
                         throw new IllegalDateException("\nIllegal Date\n");
                     }
                     
            int compareDates = d1.compareTo(d2);

            //if block for all possible date comparison scenarios
            if(compareDates == 0){
                System.out.println("\n"+d1+" and "+d2);
                System.out.println("are the same date.\n");
                System.out.println("-----------------------------------------");
            }
            else if(compareDates > 0){
                System.out.println("\n"+d1+" Takes place after "+d2);
                System.out.println("The number of days between");
                System.out.print(d1 + " and " + d2 + " is ");
                System.out.println(Math.abs(d1.lilian() - d2.lilian())+"\n");
                System.out.println("-----------------------------------------");

            }
            else{
                System.out.println("\n"+d1+" Takes place before "+d2);
                System.out.println("The number of days between");
                System.out.print(d1 + " and " + d2 + " is ");
                System.out.println(Math.abs(d1.lilian() - d2.lilian())+"\n");
                System.out.println("-----------------------------------------");
            }                     
                     
                     
                } catch (IllegalDateException ex) {

                    System.out.println(ex.getMessage());

                }
    //        if(validDate == false){
    //            System.out.println("this is not a valid date.\n");
    //            continue;
    //        }

            
        }
    }
  }
 
}