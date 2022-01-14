package ru.amlet;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Convertor convertor = new Convertor();
        convertor.htmlToImage("/home/amlet/IdeaProjects/FromHtmlToImage/src/main/resources/source.html", 2300, 320);
    }

}
