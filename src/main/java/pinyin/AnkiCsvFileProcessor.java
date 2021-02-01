package pinyin;

import org.apache.commons.cli.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class AnkiCsvFileProcessor {


    public static List<String> pinyinInitialsFinalsList;
    private final List<CsvFileEntry> fileEntries;



    private void readInputFile(){
        Path path = Paths.get("testinput.csv");
        try {
            Files.readAllLines(path).forEach(line -> {
                String[] entries = line.split("\t");
                CsvFileEntry csvFileEntry = new CsvFileEntry.Builder()
                        .simplifiedChinese(entries[0])
                        .definition(entries[1])
                        .rawPinyin(entries[2])
                        .build();
                fileEntries.add(csvFileEntry);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public AnkiCsvFileProcessor(String pathToFile) throws IOException {
        Path filePath = Paths.get(pathToFile);
        this.fileEntries = new ArrayList<>();
        Files.readAllLines(filePath).forEach(line -> {
            String[] entries = line.split("\t");
            CsvFileEntry csvFileEntry = new CsvFileEntry.Builder().simplifiedChinese(entries[0]).definition(entries[1]).rawPinyin(entries[2]).build();
            fileEntries.add(csvFileEntry);
        });
    }

    public void toCsvWithCharactersFile(){
        Set<CsvFileEntry> setOfEntries = new HashSet<>();
        fileEntries.forEach(csvFileEntry -> {
            if(!setOfEntries.contains(csvFileEntry)){
                csvFileEntry.getSingleCharacterEntries().forEach(singleCharacterEntry -> {
                    System.out.println(singleCharacterEntry.toCsvLine());
                    setOfEntries.add(csvFileEntry);
                });
                System.out.println(csvFileEntry.toCsvLine());
                setOfEntries.add(csvFileEntry);

            }
        });
    }




    public static void main(String[] args){

        Options options = new Options();
        Option inputFile = new Option("f", "file", true, "input file path");
        inputFile.setRequired(true);
        options.addOption(inputFile);

        Option inputPinyin = new Option("p", "pinyin", true, "input file path");
        inputPinyin.setRequired(true);
        options.addOption(inputPinyin);

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
        String inputPinyinPath = cmd.getOptionValue("pinyin");
        try {
            pinyinInitialsFinalsList = Files.readAllLines(Paths.get(inputPinyinPath));
            AnkiCsvFileProcessor ankiCsvFileProcessor = new AnkiCsvFileProcessor(inputFilePath);
            ankiCsvFileProcessor.toCsvWithCharactersFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
