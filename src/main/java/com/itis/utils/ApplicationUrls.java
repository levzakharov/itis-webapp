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

        String UPDATE_NEWS_URL = BASE_NEWS_URL + "/update/{postId}";

        String DELETE_NEWS_URL = BASE_NEWS_URL + "/delete/{postId}";

        String IMPORT_USERS_URL = BASE_USERS_URL + "/import";

        String FIND_USER_URL = BASE_USERS_URL + "/search";

        String USER_URL = BASE_USERS_URL + "/{id}";


    }

    interface WebAppUrls {

        String SIGN_IN = "/signIn";

        String BASE_SCHEDULE_URL = "/schedule";

        String BASE_NOTIFICATIONS_URL = "/notifications";

        String BASE_NEWS_URL = "/news";

        String CREATE_NEWS_URL = BASE_NEWS_URL + "/new";

        String UPDATE_NEWS_URL = BASE_NEWS_URL + "/update/{postId}";

        String DELETE_NEWS_URL = BASE_NEWS_URL + "/delete/{postId}";

        String BASE_FILES_URL = "/files";

        String FILE_URL = BASE_FILES_URL + "/{fileName:.+}";
    }

}
