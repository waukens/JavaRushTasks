package com.javarush.task.task25.task2502;

import jdk.nashorn.internal.runtime.ECMAException;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            if (loadWheelNamesFromDB().length != 4) {
                throw new Exception();
            }
            try {
                wheels = new LinkedList<>();
                for (String s : loadWheelNamesFromDB()) {
                    wheels.add(Wheel.valueOf(s));
                }
            } catch (Exception e) {
                throw new Exception();
            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {

    }
}
