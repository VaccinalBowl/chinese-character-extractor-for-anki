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
        Option input = new Option("f", "file", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

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
        try {
          

            pinyinInitialsFinalsList = Files.readAllLines(Paths.get(AnkiCsvFileProcessor.class.getResource("pinyin_list.txt").getPath()));
            AnkiCsvFileProcessor ankiCsvFileProcessor = new AnkiCsvFileProcessor(inputFilePath);
            ankiCsvFileProcessor.toCsvWithCharactersFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
