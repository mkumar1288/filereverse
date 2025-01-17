package com.file.reverse;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil {

    public String fileContents(Stream<String> reader) throws IOException {
        String contents = reader.collect(Collectors.joining(System.lineSeparator()));
        return contents;
    }

    public List<Character> reverseContents(String contents){
        if(contents!=null && !contents.isBlank()) {
            char[] reverseCharacters = contents.toCharArray();
            List<Character> reverseList = new ArrayList<>();
            for (char c : reverseCharacters)
                reverseList.add(c);
            Collections.reverse(reverseList);
            return reverseList;
        }else return new ArrayList<>();
    }

    public String convertCharacterArrayToString(List<Character> reverseArray) {
        String reverseString = reverseArray.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return reverseString;
    }
}
