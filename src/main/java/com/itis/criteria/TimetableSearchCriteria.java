package com.itis.criteria;

/**
 * @author aleksandrpliskin on 25.05.17.
 */
public class TimetableSearchCriteria {

    public static final String INTERVAL_WEEK = "week";
    public static final String PERSONALITY_ALL = "overall";

    private String interval;
    private String personality;

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }
}
