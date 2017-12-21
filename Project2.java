/**************************************************************************************
 * ------------------------------------------------------------------------------------
 * File name: Project1.java
 * Project name: CSCI 1250 Project 2
 * ------------------------------------------------------------------------------------
 * Author Name: Dakota Cowell
 * Author E-mail: cowelld@goldmail.etsu.edu
 * Course-Section: CSCI-1250-201
 * Creation Date: 9/28/2015
 * Date of Last Modification: 10/4/2015
 * ------------------------------------------------------------------------------------
 */
import java.util.Scanner; //to allow input from the keyboard
import java.text.DecimalFormat;//to allow decimal formatting
/**************************************************************************************
 * Class Name: Project2 <br>
 * Class Purpose: Project 2  <br>
 *
 * <hr>
 * Date created: 9/28/2015 <br>
 * Date last modified: 10/4/2015
 * @author Dakota Cowell
 */
public class Project2
{
  /**********************************************************************************
 * Method Name: main <br>
 * Method Purpose: Develop a simple program in Java that should calculate the
 * amount of due for a user’s ticket order based upon the user’s selection. It
 * should ask the user how many adult tickets and how many discounted
 * (student/senior) tickets they would like to purchase. It should then give the
 * user a menu of options for discounts to be applied. After the user has made
 * their selection it should display a bill indicating the purchase price, the
 * shipping costs (if any), the discount applied (if any) and the total due.
 * <br>
 *
 * <hr>
 * Date created: 9/28/2015 <br>
 * Date last modified: 10/4/2015 <br>
 *
 * <hr>
 * Notes on specifications, special algorithms, and assumptions:
 * The discount percentage and shipping rate should be constants (discount rate
 * should be 10 percent and shipping should be $5). It should be that if the
 * discount rate or shipping cost change, you would only have to make one
 * change in your program – not multiple places throughout. The output should
 * look exactly like that shown in the examples (pay close attention to line
 * breaks and spacing). Be sure to place your own name in the greeting. All
 * currency should be displayed to 2 decimal places and percentages be displayed
 * to 1 decimal place. If the user makes an invalid selection from the menu, the
 * program should automatically apply free shipping. You must use a switch
 * statement to process the menu selection.
 * The cost of the tickets are: $10/adult, $5/discounted. After you display the
 * Welcome message, you should display the message
 * “ --Press Enter to Continue -- “ and wait for the user to press Enter. Upon
 * pressing Enter, the program should continue running. Once the user has
 * pressed Enter, you should display enough blank lines to make it appear that
 * the screen has been cleared. You should also do this before displaying the
 * menu to the user. This is not shown in the example, but you should ask the
 * user if they wish to calculate another tip. If they say they do, then you
 * should repeat the program (except for the welcome screen). If they say no,
 * you should thank them for using your program and the program should end.
 *
 * <hr>
 * @param String[] args - Command Line Arguments
 */
  public static void main(String[] args)
  {
    //create new Scanner
    Scanner kb = new Scanner(System.in);
    DecimalFormat twoDecimal = new DecimalFormat("#, ##0.00");//2 decimal places
    DecimalFormat percentage = new DecimalFormat("#0.0%");// percentage format

    //***************************VARIABLE DECLARATIONS*************************
    //-------------------------------constants---------------------------------
    final double DISCOUNT_PERCENTAGE = 0.10; //10% discount
    final double SHIPPING_RATE = 5.00; //cost of shipping
    final double ADULT_TICKET_PRICE = 10.00; //cost for adult ticket
    final double STUDENT_TICKET_PRICE = 5.00; //cost for student/senior ticket

    //-------------------------------input by user-----------------------------
    int adultTickets; //number of adult tickets entered by the user
    int studentTickets;//number of student/senior tickets entered by the user
    int menuSelection; //menu selection entered by the user
    String moreTickets = ""; //if user wants to buy more tickets

    //--------------------------------calculated-------------------------------
    double subTotal = 0; //total price before discount
    double discount = 0; //amount of discount applied
    double shippingCost = 0; //cost of shipping after selection
    double grandTotal = 0;//final price for the user's purchase

    //----------------------------other variables------------------------------
    String optionalSavings = "";//if free shipping is chosen, display at end
    String optionalShipping = "";//if discount is chosen, display at end

    //*************************INPUT - PROCESSING - OUTPUT*********************

    //Greet the user and ask them to press enter to continue
    System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.println("****** WELCOME TO THE TICKET PRICE CALCULATOR ******");
    System.out.println("              created by Dakota Cowell        \n");
    System.out.println("             -- Press Enter to Continue --");


    //enter the code to continue when they press enter
    kb.nextLine();
    do
    {
      //extra space
      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

      //Ask for number of adult tickets
      System.out.print("How many adult tickets do you wish to purchase " +
                         "(ages 18-64): ");
      adultTickets = kb.nextInt();

      //Ask for student or senior tickets
      System.out.print("\nHow many student/senior tickets do you wish to " +
                         "purchase (0-17 or 65+): ");
      studentTickets = kb.nextInt();

      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

      System.out.println("Please make a selection from the menu options " +
                         "below for additional savings\n");

      //create savings menu
      System.out.println(   "        Savings Menu");
      System.out.println(   "   -----------------------");
      System.out.println(   "   1. Free Shipping");
      System.out.println(   "   2. 10.0% Discount");
      System.out.println(   "   3. Apply whichever discount will save me the " +
                            "most money\n");
      System.out.print(     "   Enter your selection: ");
      menuSelection = kb.nextInt();

      System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");


      //*****************************Calculations*******************************

      //Multiply number of adult tickets by adult ticket price and number of
      //student tickets by student ticket price and add those 2 numbers together
      subTotal = adultTickets * ADULT_TICKET_PRICE
      + studentTickets * STUDENT_TICKET_PRICE;

      //If User enters 1, apply free shipping
      //If user enters 2, multiply subtotal by discount percent and subtract that
      //from subtotal
      //If user enters 3, multiply subtotal by discount percent and subtract that
      //from subtotal
      //Compare that to the cost of shipping.
          //If shipping is greater than the discount percent, subtract shipping
          //from subtotal
          //If the discount percent is greater than the shipping, subtract the
          //discount from subtotal.
          //If user does not enter 1, 2, or 3, tell the user that you will apply
          //free shipping.

      switch(menuSelection)
      {
        case 1:
                shippingCost = 0.00;
                discount = 0.00;
                grandTotal = subTotal - discount + shippingCost;
                optionalSavings = "";
                optionalShipping = "(FREE Shipping)";
          break;

        case 2:
                shippingCost = SHIPPING_RATE;
                discount = (subTotal * DISCOUNT_PERCENTAGE);
                grandTotal = subTotal - discount + shippingCost;
                optionalSavings = "(" + percentage.format(DISCOUNT_PERCENTAGE)
                                + " discount)";
                optionalShipping = "";
          break;

        case 3:
                shippingCost = SHIPPING_RATE;
                discount = (subTotal * DISCOUNT_PERCENTAGE);
                if(shippingCost > discount)
                {
                  shippingCost = 0.00;
                  discount = 0.00;
                  grandTotal = subTotal - discount + shippingCost;
                  optionalSavings = "";
                  optionalShipping = "(FREE Shipping)";
                }
                else if(discount > shippingCost)
                {
                  shippingCost = SHIPPING_RATE;
                  discount = (subTotal * DISCOUNT_PERCENTAGE);
                  grandTotal = subTotal - discount + shippingCost;
                  optionalSavings = "(" + percentage.format(DISCOUNT_PERCENTAGE)
                                  + " discount)";
                  optionalShipping = "";
                }
              break;

        default:
                System.out.println("Sorry, that was not a valid option. We will"
                               +   " apply\nfree shipping to save you a total "
                               +   "of $" + twoDecimal.format(SHIPPING_RATE)
                               +   "\n\n");

                shippingCost = 0.00;
                discount = 0.00;
                grandTotal = subTotal - discount + shippingCost;
                optionalSavings = "";
                optionalShipping = "(FREE Shipping)";
              break;
      }

      System.out.print("      Purchase price $ " +
                       twoDecimal.format(subTotal) + "\n");
      System.out.print("    Discount applied $-" +
                       twoDecimal.format(discount) + " " + optionalSavings + "\n");
      System.out.print("            Shipping $ " +
                       twoDecimal.format(shippingCost) + optionalShipping +
                       " \n");
      System.out.print("------------------------------------------------"
                     + "\n");
      System.out.print("           Total Due $ " +
                       twoDecimal.format(grandTotal) + "\n\n");

      System.out.print("Would you like to buy more tickets?(Yes or No) ");

      kb.nextLine(); //flushing input buffer
      moreTickets = kb.nextLine(); //saving if user wants to calculate again
    }
    while(moreTickets.equalsIgnoreCase("Yes"));//end of do while

    System.out.print("\n\n\n");

    System.out.println("******* Thank you for using THE TICKET PRICE " +
                       "CALCULATOR ******" + "\n\n\n");
  }//end main
}//end Project2
