package com.itis.utils;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface ApplicationUrls {

    interface ApiUrls {

        String BASE_API_URL = "/api/v2";

        String BASE_USERS_URL = BASE_API_URL + "/users";

        String BASE_NOTIFICATIONS_URL = BASE_API_URL + "/notifications";

        String BASE_NEWS_URL = BASE_API_URL + "/news";

        String NEW_URL = BASE_NEWS_URL + "{postId}";

        String CREATE_NEWS_URL = BASE_NEWS_URL + "/new";

        String UPDATE_NEWS_URL = BASE_NEWS_URL + "/{postId}/update";

        String DELETE_NEWS_URL = BASE_NEWS_URL + "/{postId}/delete";

        String IMPORT_USERS_URL = BASE_USERS_URL + "/import";

        String FIND_USER_URL = BASE_USERS_URL + "/search";

        String USER_URL = BASE_USERS_URL + "/{id}";
    }

    interface WebAppUrls {

        String LOGIN = "/login";

        String BASE_TIMETABLE_URL = "/timetable";
        String TIMETABLE_SEARCH = BASE_TIMETABLE_URL + "/search";
        String TIMETABLE_CSV = BASE_TIMETABLE_URL + "/csv";

        String BASE_NOTIFICATIONS_URL = "/notifications";

        String BASE_NEWS_URL = "/news";

        String CREATE_NEWS_URL = BASE_NEWS_URL + "/new";

        String UPDATE_NEWS_URL = BASE_NEWS_URL + "/{postId}/update";

        String DELETE_NEWS_URL = BASE_NEWS_URL + "/{postId}/delete";

        String BASE_FILES_URL = "/files";

        String FILE_URL = BASE_FILES_URL + "/{fileName:.+}";

        String NEW = BASE_NEWS_URL + "/{newId}";

        String BASE_CERTIFICATE_URL = "/certificates";

<<<<<<< HEAD
        String BASE_DOCUMENTS_URL = "/documents";

        String CREATE_DOCUMENT_URL = BASE_DOCUMENTS_URL + "/new";

        String TEACHER_FOLDERS_URL = BASE_DOCUMENTS_URL + "/teachers";

        String TEACHER_DOCUMENTS_URL = TEACHER_FOLDERS_URL + "/{userId}";

        String DEAN_DOCUMENTS_URL = BASE_DOCUMENTS_URL + "/dean";

=======
>>>>>>> 5a397e5c043136174ae353e11244a7e11381210a
    }

}
