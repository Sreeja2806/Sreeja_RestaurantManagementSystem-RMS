package com.rubicon.rms.orders;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Scanner;

public class TotalPrice {
    private Scanner sc;
    private Scanner scan;
    private String name;
    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private double dPrice;
    private int dQuantity;
    private double multi;
    private PrintWriter pw;
    private String fileName = "Order.csv";
    public TotalPrice() throws IOException {
        fullnames = new StringBuilder();
        openFile();
        readFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }

    private void openFile() throws IOException {

        File file = new File(fileName);
        PrintWriter pw = null;
        if (!file.exists()) {
            file.createNewFile();
            pw = new PrintWriter(new FileOutputStream(fileName));
            System.out.println("File not found");
            pw.println("Name,Quantity,Price");
            System.out.println("File Created " + file.getPath());
            pw.flush();
            pw.close();
        }
        else {System.out.println("File found!");}
    }
    private void readFile() throws IOException {
        String[] orderDetails=null;
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '\'', 1);
        try {
            while ((orderDetails = reader.readNext())!=null){
                name = orderDetails[0];
                System.out.println(name);

                quantity=orderDetails[1];

                price =orderDetails[1];

                fullnames.append(name + ","+quantity+","+price+ "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try
            {
                //closing the reader
                reader.close();
            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
        }

//        try{
//            while(scan.hasNextLine())
//            {
//                name = scan.nextLine();
//                System.out.println(name);
//                // price = scan.nextLine();
//
//                quantity=scan.nextLine();
//                // dQuantity=Integer.decode(quantity);
//                //multi=dPrice*dQuantity;
//                price =scan.nextLine();
//                fullnames.append(name + "\t"+quantity+"\t"+price+ "\n");
//            }
//        }
//        catch(Exception e){
//            System.out.println(e);
//        }
    }


}
