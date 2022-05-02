package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private ArrayList<String> documents;
    private ArrayList<String> finalDocuments;
    private File file;

    public FileHandler(File file) {
        //  Initialise the docs ArrayList
        documents = new ArrayList<>();

        //  Try opening file and creating scanner on it
        try (Scanner sc = new Scanner(file)) {
            //  Iterate each line in file and read it into the Arraylist of doc IDs
            while (sc.hasNextLine()) {
                documents.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        System.out.println(documents.size() + " documents read.");

        //  Format the file names appropriately
        trimDocs();
        //  Write the filenames to file
        writeFile();
    }

    public void trimDocs() {
        //  Initialise the new ArrayList which will be outputted
        finalDocuments = new ArrayList<>();

        for (String docID : documents) {
            //  Remove first 2 chars
            String current = docID.substring(2);
            current = current.substring(0, current.length() - 4);

            finalDocuments.add(current);
        }
    }

    public void writeFile() {
        try(FileWriter fw = new FileWriter("Audit helper output.txt")) {
            for (String docID : finalDocuments) {
                fw.write(docID + ",");
            }
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }

    }
}
