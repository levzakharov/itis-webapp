package com.itis.model.enums;

/**
 * @author aleksandrpliskin on 23.05.17.
 */
public enum EventInterval {

    I_8_30_10_00 {
        @Override
        public String toString() {
            return "08:30-10:00";
        }
    },
    I_10_10_11_40 {
        @Override
        public String toString() {
            return "10:10-11:40";
        }
    },
    I_11_50_13_20 {
        @Override
        public String toString() {
            return "11:50-13:20";
        }
    },
    I_13_35_15_05 {
        @Override
        public String toString() {
            return "13:35-15:05";
        }
    },
    I_15_20_16_50 {
        @Override
        public String toString() {
            return "15:20-16:50";
        }
    },
    I_17_00_18_30 {
        @Override
        public String toString() {
            return "17:00-18:30";
        }
    },
    I_18_00_19_30 {
        @Override
        public String toString() {
            return "18:00-19:30";
        }
    },
    I_19_35_21_05 {
        @Override
        public String toString() {
            return "19:35-21:05";
        }
    };

}