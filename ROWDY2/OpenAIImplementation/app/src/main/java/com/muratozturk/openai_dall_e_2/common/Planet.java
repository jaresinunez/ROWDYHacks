package com.muratozturk.openai_dall_e_2.common;

public class Planet {
    public String size;
    public String color1;
    public String color2;
    public String color3;
    public String pattern; // spiral, dots, hlines, vlines, checkered

    public Planet(String s, String c1, String c2, String c3, String p){
        this.size = s;
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
        this.pattern = p;
    }
}
