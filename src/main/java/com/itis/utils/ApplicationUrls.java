package com.itis.utils;

/**
 * @author aleksandrpliskin on 13.05.17.
 */
public interface ApplicationUrls {

    interface ApiUrls {

        String BASE_API_URL = "/api/v2";

        String BASE_USERS_URL = BASE_API_URL + "/users";

        String BASE_NEWS_URL = BASE_API_URL + "/news";
    }

    interface WebAppUrls {

        String SIGN_IN = "/signIn";

        String BASE_SCHEDULE_URL = "/schedule";

        String BASE_NOTIFICATIONS_URL = "/notifications";

        String BASE_NEWS_URL = "/news";
    }

}
