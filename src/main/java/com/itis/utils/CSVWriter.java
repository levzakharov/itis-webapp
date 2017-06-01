package com.itis.utils;

import com.itis.model.User;
import com.itis.model.enums.Role;
import org.apache.log4j.Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by softi on 01.06.2017.
 */
public class CSVWriter {

    private static final Logger LOGGER = Logger.getLogger(CSVWriter.class);

    private static final String LOCATION = "src/main/resources/db/users.csv";
    private static final String CSV_SEPARATOR = ",";

    public static void writeToCSV(List<User> users) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LOCATION, true), "UTF-8"));
            users.forEach(user -> {

            StringBuilder sb = new StringBuilder()
                    .append(user.getFullName()).append(CSV_SEPARATOR)
                    .append(user.getPassword()).append(CSV_SEPARATOR)
                    .append(user.getEmail()).append(CSV_SEPARATOR)
                    .append(user.getPhone()).append(CSV_SEPARATOR);
            if (user.getUserGroup() != null) {
                sb.append(user.getUserGroup().getNumber()).append(CSV_SEPARATOR);
            } else {
                sb.append("" + CSV_SEPARATOR);
            }
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String strDate = format.format(new Date(user.getBirthday()));
            sb.append(strDate).append(CSV_SEPARATOR);
                try {
                    bw.write(sb.toString());
                    bw.newLine();
                } catch (IOException e) {
                    LOGGER.error("Problems while creating file with user credentials", e);
                }
            });
            bw.flush();
            bw.close();
        } catch (IOException e) {
            LOGGER.error("Problems while creating file with user credentials", e);
        }
    }
}
