package com.rubicon.rms.orders;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author P Sreeja-VJIT
 */
class TotalBil {
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
    TotalBil() throws IOException {
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

                fullnames.append(name).append(",").append(quantity).append(",").append(price).append("\n");
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
    }
}
