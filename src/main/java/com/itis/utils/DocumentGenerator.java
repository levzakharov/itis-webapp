package com.itis.utils;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * @author aleksandrpliskin on 26.05.17.
 */
public class DocumentGenerator {

    private static final String DOCUMENT_LOCATION = "src/main/resources/upload-dir/";
    private static final String DOCUMENT_NAME = "certificate.docx";
    private static final String NAME_TO_REPLACE = "Бобринская Екатерина Олеговна";

    public static String generateDocument(String fullName) throws IOException {
        String filePath = DOCUMENT_LOCATION + DOCUMENT_NAME;
        String outPath = DOCUMENT_LOCATION + fullName + "-" + new Date().getTime() + ".docx";

        XWPFDocument doc = new XWPFDocument(new FileInputStream(filePath));
        for (XWPFParagraph p : doc.getParagraphs()) {

            int numberOfRuns = p.getRuns().size();

            // Collate text of all runs
            StringBuilder sb = new StringBuilder();
            for (XWPFRun r : p.getRuns()) {
                int pos = r.getTextPosition();
                if (r.getText(pos) != null) {
                    sb.append(r.getText(pos));
                }
            }

            // Continue if there is text and contains "test"
            if (sb.length() > 0 && sb.toString().contains(NAME_TO_REPLACE)) {
                // Remove all existing runs
                for (int i = 0; i < numberOfRuns; i++) {
                    p.removeRun(i);
                }
                String text = sb.toString().replace(NAME_TO_REPLACE, fullName);
                // Add new run with updated text
                XWPFRun run = p.createRun();
                run.setText(text);
                p.addRun(run);
            }
        }
        doc.write(new FileOutputStream(outPath));

        return outPath;
    }

}
