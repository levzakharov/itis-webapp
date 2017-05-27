package com.itis.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author aleksandrpliskin on 26.05.17.
 */
public class DocumentGenerator {

    private static final String DOCUMENT_LOCATION = "src/main/resources/upload-dir/";
    private static final String DOCUMENT_NAME = "certificate.docx";
    private static final String NAME_TO_REPLACE = "Бобринская";

    public static void main(String[] args) throws IOException {
        String filePath = DOCUMENT_LOCATION + DOCUMENT_NAME;
        String outpath = DOCUMENT_LOCATION + "pliskin.docx";

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
                String text = sb.toString().replace(NAME_TO_REPLACE, "Плискин");
                // Add new run with updated text
                XWPFRun run = p.createRun();
                run.setText(text);
                p.addRun(run);
            }
        }
        doc.write(new FileOutputStream(outpath));
    }
//        POIFSFileSystem fs = null;
//        try {
//            fs = new POIFSFileSystem(new FileInputStream(filePath));
////            XWPFDocument doc = new XWPFDocument(OPCPackage.open(filePath));
//            HWPFDocument doc = new HWPFDocument(fs);
//            doc = replaceText(doc, NAME_TO_REPLACE, "Плискин");
//            saveWord(DOCUMENT_LOCATION + "pliskin.docx", doc);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    private static HWPFDocument replaceText(HWPFDocument doc, String findText, String replaceText) {
        Range r1 = doc.getRange();

        for (int i = 0; i < r1.numSections(); ++i) {
            Section s = r1.getSection(i);
            for (int x = 0; x < s.numParagraphs(); x++) {
                Paragraph p = s.getParagraph(x);
                for (int z = 0; z < p.numCharacterRuns(); z++) {
                    CharacterRun run = p.getCharacterRun(z);
                    String text = run.text();
                    if (text.contains(findText)) {
                        run.replaceText(findText, replaceText);
                    }
                }
            }
        }
        return doc;
    }

    private static void saveWord(String filePath, HWPFDocument doc) throws IOException {
        try (FileOutputStream out = new FileOutputStream(filePath)) {
            doc.write(out);
        }
    }

//    public static Document generateDocument(String fullName) throws IOException {
//
//    }

//    public static void main(final String[] args) throws IOException {
//        File file = new File(DOCUMENT_LOCATION + DOCUMENT_NAME);
//        PDDocument document = PDDocument.load(file);
//        replaceText(document, FULL_NAME_TO_REPLACE, "Плискин");
//        document.save(DOCUMENT_LOCATION + "pliskin.pdf");
//    }
//
//
//    public static PDDocument replaceText(PDDocument document, String searchString, String replacement) throws IOException {
//        final PDPage page = document.getPage(0);
//        PDFStreamParser parser = new PDFStreamParser(page);
//        parser.parse();
//        List tokens = parser.getTokens();
//        for (int j = 0; j < tokens.size(); j++) {
//            Object next = tokens.get(j);
//            if (next instanceof Operator) {
//                Operator op = (Operator) next;
//                //Tj and TJ are the two operators that display strings in a PDF
//                if (op.getName().equals("Tj")) {
//                    // Tj takes one operator and that is the string to display so lets update that operator
//                    COSString previous = (COSString) tokens.get(j - 1);
//                    String string = previous.getString();
//                    string = string.replaceFirst(searchString, replacement);
//                    previous.setValue(string.getBytes());
//                    System.out.println(previous.getString());
//                } else if (op.getName().equals("TJ")) {
//                    COSArray previous = (COSArray) tokens.get(j - 1);
//                    for (int k = 0; k < previous.size(); k++) {
//                        Object arrElement = previous.getObject(k);
//                        if (arrElement instanceof COSString) {
//                            COSString cosString = (COSString) arrElement;
//                            String string = cosString.getString();
//                            string = StringUtils.replaceOnce(string, searchString, replacement);
//                            cosString.setValue(string.getBytes());
//                        }
//                    }
//                }
//            }
//        }
//        // now that the tokens are updated we will replace the page content stream.
//        PDStream updatedStream = new PDStream(document);
//        OutputStream out = updatedStream.createOutputStream();
//        ContentStreamWriter tokenWriter = new ContentStreamWriter(out);
//        tokenWriter.writeTokens(tokens);
//        page.setContents(updatedStream);
//        out.close();
//        return document;
//    }

}
