package com.rubicon.rms.orders;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author P. Sreeja-VJIT
 */
public class OrderDetails {
    private Scanner scan;
    private String srchName;

    private String name;

    private String price;
    private String quantity;
    private StringBuilder fullnames;
    private String itemName [];
    private StringBuilder receiptName;
    public OrderDetails() throws IOException {
        fullnames = new StringBuilder();
        try {
            openFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        readFile();
    }

    public StringBuilder getFullNames()
    {
        return fullnames;
    }
    public StringBuilder getReceiptName()
    {
        return receiptName ;
    }
    private void openFile() throws IOException {
        File file = new File(fileName);
        PrintWriter pw = null;
        if (!file.exists()) {
            file.createNewFile();
            pw = new PrintWriter(new FileOutputStream(fileName));
            System.out.println("File not found");
            pw.println("Id,Name,Price,Quantity");
            System.out.println("File Created " + file.getPath());
            pw.flush();
            pw.close();
        }
        else {System.out.println("File found!");}
    }

    private void setSrchName(String srchName) {
        this.srchName = srchName;
    }
    private String getSrchName() {
        return srchName;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    private void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    private String getQuantity() {
        return quantity;
    }

    private String fileName = "Menu.csv";

    private void readFile() throws IOException {
        String[] orderDetails = null;
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '\'', 1);
        try {
            while ((orderDetails = reader.readNext()) != null) {

                name = orderDetails[1];
                System.out.println(name);
                //quantity=orderDetails[1];
                quantity = "1";
                price = orderDetails[3];

                int num = 1;
                fullnames.append(num + "," + name + "," + price + "," + quantity + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //closing the reader
                reader.close();
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
    }

    private void ModifyItem(){
        String srcKey=getSrchName();
        System.out.println(srcKey +" is going to be changed in quantity");

        System.out.println(srcKey+"will be modified");


        int c=0,track, cnt=0,temp=0;

        try{
            Scanner sc = new Scanner(new FileInputStream("Menu.csv"));
            while(sc.hasNextLine()){
                cnt++;
                sc.nextLine();

            }
            itemName= new String[cnt];
            sc.close();
            sc = new Scanner(new FileInputStream("Menu.csv"));
            while(sc.hasNextLine()){
                itemName[c]=sc.nextLine();
                if(itemName[c].equalsIgnoreCase(srcKey)){
                    temp=c;
                    System.out.println("Index will be deleted" +c);
                }
                c++;
            }

        }
        catch(Exception e){
            System.out.println(e);

        }

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("Menu.csv"));
            for (int i = 0; i < c; i++) {
                if(i==temp+2){
                    int cngQuantity = Integer.decode(itemName[i]);

                    cngQuantity = cngQuantity -Integer.decode(getQuantity());
                    pw.println(cngQuantity);
                    System.out.println("Value has been changed ");
                }
                else{
                    pw.println(itemName[i]);
                }

            }
            System.out.println("Your item has been deleted.");
            pw.close();
        }
        catch (Exception ignored) {
        }

    }

    public int checkQuantity(int n){
        int i=1;
        int quantity;
        int count;
        try{
            Scanner sc = new Scanner(new FileInputStream("Menu.csv"));
            while(sc.hasNextLine()){
                if(i==n){
                    sc.nextLine();sc.nextLine();
                    quantity=Integer.decode(sc.nextLine());
                    return quantity;
                } else {
                    sc.nextLine();
                    sc.nextLine();
                    sc.nextLine();
                }
                i++;
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);

        }
        return 0;
    }
    public void temp(int n, int i) {

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt",true));

            Scanner sc = new Scanner(new FileInputStream("Menu.csv"));
            for(int j=1;sc.hasNextLine(); j++){
                if (j==n){
                    String s1 = sc.nextLine();
                    pw.println(s1);

                    String s2 = sc.nextLine();
                    pw.println(i);
                    sc.nextLine();
                } else {sc.nextLine();sc.nextLine();sc.nextLine();}
            }
            sc.close();
            pw.close();
       /*

        try {
            PrintWriter pw = new PrintWriter(new FileOutputStream("temp.txt",true));
            pw.println(s1);
            pw.println(s2);
            pw.close();

        } catch (Exception e) {
            System.out.println("New File has been created with values ");
        }
               */


        } catch (Exception ignored) {}
        //delete();
    }
    void delete(){
        String name ="";
        String quantity="";
        try {
            Scanner sc= new Scanner(new FileInputStream("temp.txt"));
            while(sc.hasNextLine()){
                name=sc.nextLine();
                quantity =sc.nextLine();
                setSrchName(name);
                setQuantity(quantity);
                ModifyItem();



            }
            System.out.println("End of reading temp file");
            sc.close();
        } catch (Exception ignored) {
        }

    }

    public void readReceipt(){

        try{
            Scanner sc = new Scanner(new FileInputStream("temp.txt"));
            while(sc.hasNextLine())
            {
                name = sc.nextLine();
                //price = scan.nextLine();
                quantity=sc.nextLine(); // + " \t"+quantity+
                receiptName.append(name).append(" \t").append(quantity).append("\n");
            }
            sc.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
