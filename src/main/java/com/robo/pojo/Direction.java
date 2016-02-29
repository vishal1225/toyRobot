package com.robo.pojo;

/**
 * Created by Vishal on 12-11-2015.
 */
public enum Direction {
    NORTH("NORTH"), EAST("EAST"), WEST("WEST"), SOUTH("SOUTH");
    private String value;
    private Direction(String value) {
        value = value;
    }

    public String getValue() {
        return value;
    }
}
