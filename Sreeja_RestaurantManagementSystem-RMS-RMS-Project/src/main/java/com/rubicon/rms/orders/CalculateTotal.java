package com.rubicon.rms.orders;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author P. Sreeja-VJIT
 */
public class CalculateTotal {
    private Scanner scan;
    private double total=0;
    public String price;

    String getTotal() {

        try{
            scan = new Scanner(new FileInputStream("Order.csv"));
            while(scan.hasNextLine())
            {


                scan.nextLine();
                scan.nextLine();
                price = scan.nextLine();
                total+=Double.valueOf(price);

            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return String.valueOf("Total Price is : "+total);
    }


}

