package com.rubicon.rms.orders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author P. Sreeja-VJIT
 */
public class GenerateReceipt {
    private Scanner sc;
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private double dPrice;
    private int dQuantity;
    private double multi;
    private double sum=0;
    private PrintWriter pw;
    public GenerateReceipt()
    {
        fullnames = new StringBuilder();
        openFile();
        readFile();
        closeFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    public String getSum(){

        return String.valueOf(sum);
    }

    private void openFile()
    {
        try
        {
            pw = new PrintWriter(new FileOutputStream("Order.csv",true));
            scan = new Scanner(new File("temp.txt"));
            sc = new Scanner(new FileInputStream("Menu.csv"));
            System.out.println("File found!");
        }

        catch(Exception e)
        {
            System.out.println("File not found");
        }
    }

    private void readFile()
    {
        try{
            while(scan.hasNextLine())
            {
                sc = new Scanner(new FileInputStream("Menu.csv"));

                name = scan.nextLine();
                System.out.println(name);
                // price = scan.nextLine();
                while(sc.hasNextLine()){
                    multi=1;
                    if(name.equalsIgnoreCase(sc.nextLine())){
                        price=sc.nextLine();
                        dPrice=Double.valueOf(price);
                        System.out.println(dPrice);
                        sc.nextLine();
                    }

                }
                sc.close();

                quantity=scan.nextLine();
                dQuantity=Integer.decode(quantity);
                multi=dPrice*dQuantity;
                sum+=multi;

                fullnames.append(name).append(" \t").append(quantity).append("\t").append(multi).append("\n");
                //   write();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private void closeFile()
    {
        scan.close();
        sc.close();
        pw.close();
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public double getMulti() {
        return multi;
    }

}