package ru.amlet;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import org.xhtmlrenderer.swing.Java2DRenderer;
import org.xhtmlrenderer.util.FSImageWriter;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Convertor {

    public byte[] htmlToImage(String url, int width, int height) throws IOException {
        File file = new File(url);

        Document jsoupDocument = Jsoup.parse(file, StandardCharsets.UTF_8.name());
        W3CDom w3cDom = new W3CDom();
        org.w3c.dom.Document document = w3cDom.fromJsoup(jsoupDocument);

        Java2DRenderer renderer = new Java2DRenderer(document, width, height);
        renderer.setBufferedImageType(BufferedImage.TYPE_INT_RGB);
        BufferedImage image = renderer.getImage();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        FSImageWriter imageWriter = new FSImageWriter();
        String path = file.getAbsolutePath();
        path = path.substring(0, path.lastIndexOf("."));
        imageWriter.write(image, path + ".png");

        imageWriter.write(image, outputStream);
        return outputStream.toByteArray();
    }
}
