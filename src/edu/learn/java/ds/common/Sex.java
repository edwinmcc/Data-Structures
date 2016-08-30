package edu.learn.java.ds.common;

/**
 * Created by egnanasigamony on 30/08/2016.
 */
public enum Sex {
    FEMALE {
        public String getSex() {
            return "F";
        }
    },
    MALE {
        public String getSex() {
            return "M";
        }
    };

    abstract String getSex();

}
