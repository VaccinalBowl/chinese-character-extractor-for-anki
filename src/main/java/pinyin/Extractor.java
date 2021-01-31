package pinyin;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.apache.commons.cli.*;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Extractor {

    public static void main(String[] args) throws Exception {

        Options options = new Options();
        Option input = new Option("f", "file", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option output = new Option("t", "type", true, "csv or xml");
        output.setRequired(true);
        options.addOption(output);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd=null;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);
            System.exit(1);
        }

        String inputFilePath = cmd.getOptionValue("file");
        String fileType = cmd.getOptionValue("type");

        if(fileType.equals("xml")){
            extractFromXml(inputFilePath);
        }else if (fileType.equals("csv")){
            extractFromCsv(inputFilePath);
        }else{
            System.out.println("Unsupported file type");
            System.exit(1);
        }



    }

    private static void extractFromCsv(String inputFilePath) {
        try {

            File f = new File(inputFilePath);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                String[] parts = readLine.split(",");
                Entry entry = new Entry(parts[0],parts[2],parts[1]);
                entry.toStdOut();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void extractFromXml(String fileName) {


        try {

            File plecoXmlFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(plecoXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("entry");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    Entry entry = new Entry(eElement.getElementsByTagName("headword").item(0).getTextContent(),
                            eElement.getElementsByTagName("pron").item(0).getTextContent().toLowerCase(),
                            eElement.getElementsByTagName("defn").item(0).getTextContent());
                    entry.toStdOut();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
