package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");

        File docsList = new File(path + "\\docs list.txt");

        File test = new File(path + "\\" + args);

        FileHandler fh = new FileHandler(docsList);
    }
}
