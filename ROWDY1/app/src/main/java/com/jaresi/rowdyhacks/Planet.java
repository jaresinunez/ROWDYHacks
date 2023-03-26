package com.jaresi.rowdyhacks;

public class Planet {
    String size;
    String color1;
    String color2;
    String color3;
    String pattern; // spiral, dots, hlines, vlines, checkered
    String url;

    Planet(String s, String c1, String c2, String c3, String p, String u){
        this.size = s;
        this.color1 = c1;
        this.color2 = c2;
        this.color3 = c3;
        this.pattern = p;
        this.url = u;
    }
}
