package com.rubicon.rms.admin;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

class ExportJTable {

    void exportJtable(JTable table, String fileName) {
        PrintWriter pw = null;
        File file = new File(fileName);
        try {
            pw = new PrintWriter(new FileOutputStream(file, false));
            //String EmplooyeeQuantity = quantity.getText();
            TableModel model = table.getModel();

            for (int i = 0; i < model.getColumnCount(); i++) {
                pw.print(model.getColumnName(i));
                if (i != model.getColumnCount() - 1) pw.print(",");
            }
            pw.print("\n");

            for (int i = 0; i < model.getRowCount(); i++) {
                for (int j = 0; j < model.getColumnCount(); j++) {
                    pw.print(model.getValueAt(i, j).toString());
                    if (j != model.getColumnCount() - 1) pw.print(",");
                }
                pw.print("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.flush();
                pw.close();
            }
        }
    }
}
