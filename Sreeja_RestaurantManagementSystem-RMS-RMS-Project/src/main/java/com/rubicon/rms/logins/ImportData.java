package com.rubicon.rms.logins;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.List;

/**
 *
 * @author P. Sreeja-VJIT
 */
class ImportData {

    List<String[]> importData(String fileName) throws IOException {
        File file= new File(fileName);
        PrintWriter pw = null;
        if (!file.exists()){
            file.createNewFile();
            pw = new PrintWriter(new FileOutputStream(fileName));
            pw.println("HostId, BusBoyID, ManagerId, ChefId, LineCookId, ServerId, CustomerId, Customer Name, No: Persons, TableId, OrderId, OrderDetails Details, Bill, Feedback, Status");
            System.out.println("Emlooyee File Created " + file.getPath());
            pw.flush();
            pw.close();
        }
        CSVReader reader = new CSVReader(new FileReader(fileName), ',', '\'', 1);
        return reader.readAll();
    }
}
