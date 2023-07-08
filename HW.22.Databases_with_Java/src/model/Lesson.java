package model;

import lombok.Data;

@Data
public class Lesson {
    private Integer id;
    private String name;
    private Homework homework;
}
