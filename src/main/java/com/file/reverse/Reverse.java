package com.file.reverse;

import java.io.*;
import java.util.List;

public class Reverse {
    public static void main(String[] args) throws IOException {
        FileUtil fileUtil = new FileUtil();
        String contents = null;
        try (FileReader fileReader = new FileReader("src/main/resources/input.txt");
             BufferedReader reader = new BufferedReader(fileReader)){
            contents = fileUtil.fileContents(reader.lines());
        }
        List<Character> reverseList = fileUtil.reverseContents(contents);
        String reverseString = fileUtil.convertCharacterArrayToString(reverseList);
        if(reverseString !=null && !reverseString.isBlank()){
            try (FileWriter fileWriter = new FileWriter("src/main/resources/output.txt");
                 BufferedWriter writer = new BufferedWriter(fileWriter)){
                writer.write(reverseString);
            }
        }
    }
}