package com.itis.exceptions;

/**
 * @author aleksandrpliskin on 23.05.17.
 */
public class TimetableCreationException extends RuntimeException {

    public TimetableCreationException() {
        super("Erro while parsing csv file to timetable events");
    }
}