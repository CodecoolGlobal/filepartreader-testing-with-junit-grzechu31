package com.codecool;

import java.io.IOException;

public class Main {

    public static void main(String[] args){
        Integer fromLine = 1;
        Integer toLine = 10;

        String path = "D:\\aaaa.txt";
        FilePartReader filePartReader = new FilePartReader();


        filePartReader.setup(path, fromLine, toLine);
        String fileContent = null;
        try {
            fileContent = filePartReader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent);
    }


}
