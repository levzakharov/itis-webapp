package com.itis.service;

import com.itis.model.Event;
import com.itis.model.UserGroup;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface EventService {

    Map<UserGroup, List<Event>> getTimetable(String interval, String personality);

    void createTimetable(MultipartFile file);
}
