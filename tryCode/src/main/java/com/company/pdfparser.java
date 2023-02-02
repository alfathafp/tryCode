package com.company;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.xmlbeans.XmlException;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Slf4j
public class pdfparser {

    @Test
    public void parsePDF() throws IOException, TikaException, SAXException {
//        pdf parser
        BodyContentHandler ch = new BodyContentHandler();

        File fl = new File("/Users/alfath/Downloads/Alfath docs/Alfath Febriadi Pratama.pdf");

        FileInputStream fs = new FileInputStream(fl);

        Metadata md = new Metadata();

        ParseContext pc = new ParseContext();

        PDFParser pp = new PDFParser();

        pp.parse(fs, ch, md, pc);

        String strContext = ch.toString();
        System.out.println(strContext);
    }

    @Test
    public void parseWord() throws IOException, OpenXML4JException, XmlException {
//        word parser
        File file = new File("");
        FileInputStream fs = new FileInputStream(file);
        OPCPackage d = OPCPackage.open(fs);
        XWPFWordExtractor xw = new XWPFWordExtractor(d);

        String fileName = "/Users/alfath/Downloads/Alfath Febriadi.docx";
        try (XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get(fileName)))){

            List<XWPFParagraph> list = doc.getParagraphs();
            for (XWPFParagraph paragraph : list
                 ) {
            }

        }
    }


}
