package com.rubicon.rms.orders;

import java.io.FileInputStream;
import java.util.Scanner;

public class CalculateTotal {
    public Scanner scan;
    public double total=0;
    public String price;

    public String getTotal() {

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

