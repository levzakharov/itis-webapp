package com.itis.model.enums;

public enum Role {

    STUDENT {
        @Override
        public String toString() {
            return "STUDENT";
        }
    },
    STAROSTA {
        @Override
        public String toString() {
            return "STAROSTA";
        }
    },
    WORKER {
        @Override
        public String toString() {
            return "WORKER";
        }
    },
    ADMIN {
        @Override
        public String toString() {
            return "ADMIN";
        }
    },
    TEACHER {
        @Override
        public String toString() {
            return "TEACHER";
        }
    }

}