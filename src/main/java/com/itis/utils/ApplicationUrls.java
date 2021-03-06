package com.itis.utils;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface ApplicationUrls {

    interface ApiUrls {

        String BASE_API_URL = "/api/v2";

        String BASE_USERS_URL = BASE_API_URL + "/users";

        String USER_ROLES_URL = BASE_USERS_URL + "/roles";

        String BASE_NOTIFICATIONS_URL = BASE_API_URL + "/notifications";

        String BASE_NEWS_URL = BASE_API_URL + "/news";

        String BASE_GROUPS_URL = BASE_API_URL + "/groups";

        String NEW_URL = BASE_NEWS_URL + "{postId}";

        String CREATE_NEWS_URL = BASE_NEWS_URL + "/new";

        String UPDATE_NEWS_URL = BASE_NEWS_URL + "/{postId}/update";

        String DELETE_NEWS_URL = BASE_NEWS_URL + "/{postId}/delete";

        String IMPORT_USERS_URL = BASE_USERS_URL + "/import";

        String FIND_USER_URL = BASE_USERS_URL + "/search";

        String USER_URL = BASE_USERS_URL + "/{id}";

        String GROUPS_BY_COURSE = BASE_GROUPS_URL + "/{courseNumber}";

        String BASE_TIMETABLE_URL = BASE_API_URL + "/timetable";

    }

    interface WebAppUrls {

        String LOGIN = "/login";

        String BASE_TIMETABLE_URL = "/timetable";
        String TIMETABLE_SEARCH = BASE_TIMETABLE_URL + "/search";
        String TIMETABLE_CSV = BASE_TIMETABLE_URL + "/csv";

        String BASE_NOTIFICATIONS_URL = "/notifications";

        String EXTENDED_NOTIFICATIONS_URL = BASE_NOTIFICATIONS_URL + "/extended";

        String CREATE_NOTIFICATION_URL = BASE_NOTIFICATIONS_URL + "/new";

        String BASE_NEWS_URL = "/news";

        String CREATE_NEWS_URL = BASE_NEWS_URL + "/new";

        String UPDATE_NEWS_URL = BASE_NEWS_URL + "/{postId}/update";

        String DELETE_NEWS_URL = BASE_NEWS_URL + "/{postId}/delete";

        String BASE_FILES_URL = "/files";

        String FILE_URL = BASE_FILES_URL + "/{fileName:.+}";

        String NEW = BASE_NEWS_URL + "/{newId}";

        String BASE_DOCUMENTS_URL = "/documents";

        String CREATE_DOCUMENT_URL = BASE_DOCUMENTS_URL + "/new";

        String DELETE_DOCUMENT_URL = BASE_DOCUMENTS_URL + "/{documentId}/delete";

        String TEACHER_FOLDERS_URL = BASE_DOCUMENTS_URL + "/teachers";

        String TEACHER_DOCUMENTS_URL = TEACHER_FOLDERS_URL + "/{userId}";

        String DEAN_DOCUMENTS_URL = BASE_DOCUMENTS_URL + "/dean";

        String BASE_RAITING_URL = "/raiting";

        String BASE_ACCOUNTS_MANAGEMENT_URL = "/accounts";

        String BAN_ACCOUNT_URL = BASE_ACCOUNTS_MANAGEMENT_URL + "/{userId}/ban";

        String UNBAN_ACCOUNT_URL = BASE_ACCOUNTS_MANAGEMENT_URL + "/{userId}/unban";

        String CREATE_ACCOUNT_URL = BASE_ACCOUNTS_MANAGEMENT_URL + "/new";

        String BASE_REQUESTS_URL = "/certificates";

        String PROCESSED_REQUESTS_URL = BASE_REQUESTS_URL + "/processed";

        String CREATE_REQUEST_URL = BASE_REQUESTS_URL + "/new";

        String ACCEPT_REQUEST_URL = BASE_REQUESTS_URL + "/{requestId}/accept";

        String DECLINE_REQUEST_URL = BASE_REQUESTS_URL + "/{requestId}/decline";

        String GENERATE_CERTIFICATE_URL = BASE_REQUESTS_URL + "/{requestId}/generate";

        String BASE_CHAT_URL = "/chat";

    }

    interface WebSocketsUrls {

        String BASE_MESSAGES_URL = "/messages";

        String MESSAGES_PREVIEW_URL = BASE_MESSAGES_URL + "-preview";

        String MESSAGE_URL = BASE_MESSAGES_URL + "/{id}";

        String READ_MESSAGE_URL = MESSAGE_URL + "/read";

        String MESSAGES_FROM_USER_URL = BASE_MESSAGES_URL + "/{user}";

        String MESSAGES_QUEUE_URL = "/queue/messages";

        String MESSAGES_READEN_QUEUE_URL = "/topic/read";
    }

    interface WebAppErrorsUrls {

        String ERROR_404_URL = "/404";
        String ERROR_403_URL = "/403";
        String ERROR_500_URL = "/500";

    }
}