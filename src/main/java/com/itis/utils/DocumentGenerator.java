package com.itis.utils;

import com.itis.model.User;
import com.itis.service.DecreeService;
import com.itis.service.UserGroupService;
import com.itis.storage.StorageProperties;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author aleksandrpliskin on 26.05.17.
 */
@Component
public class DocumentGenerator {

    private String DOCUMENT_LOCATION;
    private static final String DOCUMENT_NAME = "certificate.docx";
    private static final String NAME_TO_REPLACE = "%fullName";
    private static final String BIRTHDAY_TO_REPLACE = "%birthday";
    private static final String COURSE_TO_REPLACE = "%course";
    private static final String GROUP_TO_REPLACE = "%userGroup";
    private static final String CONTRACT_TO_REPLACE = "%isContract";
    private static final String START_YEAR_TO_REPLACE = "%startsYear";
    private static final String DECREES_TO_REPLACE = "%decrees";
    private static final String END_DATE_TO_REPLACE = "%endDate";
    private static final String CURRENT_DATE_TO_REPLACE = "%currentDate";
    private static final DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

    private final DecreeService decreeService;
    private final UserGroupService userGroupService;
    private final Transliterator transliterator;

    @Autowired
    public DocumentGenerator(DecreeService decreeService, UserGroupService userGroupService,
                             StorageProperties storageProperties, Transliterator transliterator) {
        this.decreeService = decreeService;
        this.userGroupService = userGroupService;
        this.transliterator = transliterator;
        this.DOCUMENT_LOCATION = storageProperties.getDocumentLocation() + "/";
    }

    public String generateDocument(User user) throws IOException {
        String filePath = DOCUMENT_LOCATION + DOCUMENT_NAME;
        String documentName = transliterator.transliterate(user.getFullName()) + "-" + new Date().getTime() + ".docx";
        String outPath = DOCUMENT_LOCATION + documentName;
        Calendar birthday = Calendar.getInstance();
        birthday.setTimeInMillis(user.getBirthday());
        String userCourse = userGroupService.getCourseByUserGroups(user.getUserGroup()).toString();
        String contract = user.isContract() ? "контракт" : "бюджет";

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
            if (sb.length() > 0 && sb.toString().contains("%")) {
                // Remove all existing runs
                String text = sb.toString().replace(NAME_TO_REPLACE, user.getFullName());
                text = text.replace(BIRTHDAY_TO_REPLACE, sdf.format(birthday.getTime()));
                text = text.replace(COURSE_TO_REPLACE, userCourse);
                text = text.replace(GROUP_TO_REPLACE, user.getUserGroup().getNumber());
                text = text.replace(CONTRACT_TO_REPLACE, contract);
                text = text.replace(START_YEAR_TO_REPLACE, user.getUserGroup().getStartYear().toString());
                text = text.replace(DECREES_TO_REPLACE, decreeService.getDecreeTextByUser(user));
                text = text.replace(END_DATE_TO_REPLACE, (user.getUserGroup().getStartYear() + 4) + "");
                text = text.replace(CURRENT_DATE_TO_REPLACE, sdf.format(new Date()));
                // Add new run with updated text
                for (int i = numberOfRuns - 1; i > -1; i--) {
                    p.removeRun(i);
                }
                XWPFRun run = p.createRun();
                run.setText(text);
                p.addRun(run);
            }
        }
        doc.write(new FileOutputStream(outPath));
        return documentName;
    }
}