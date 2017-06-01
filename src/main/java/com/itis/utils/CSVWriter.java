package com.itis.utils;

import com.itis.model.User;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by softi on 01.06.2017.
 */
public class CSVWriter {

    private static final String LOCATION = "src/main/resources/db/users.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void writeToCSV(User user) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCATION, true), "UTF-8"));
            StringBuffer oneLine = new StringBuffer();
            oneLine.append(user.getFullName() + CSV_SEPARATOR);
            oneLine.append(user.getPassword() + CSV_SEPARATOR);
            oneLine.append(user.getEmail() + CSV_SEPARATOR);
            oneLine.append(user.getPhone() + CSV_SEPARATOR);
            if (user.getUserGroup() != null) {
                oneLine.append(user.getUserGroup().getNumber() + CSV_SEPARATOR);
            } else {
                oneLine.append("" + CSV_SEPARATOR);
            }
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String strDate = format.format(new Date(user.getBirthday()));
            oneLine.append(strDate + CSV_SEPARATOR);
            oneLine.append(user.isContract() ? "contract" : "budget");
            bw.write(oneLine.toString());
            bw.newLine();
            bw.flush();
            bw.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }
}
