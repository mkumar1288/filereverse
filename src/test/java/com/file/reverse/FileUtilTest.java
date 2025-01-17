package com.file.reverse;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileUtilTest {

    private FileUtil fileUtil;

    @BeforeTest
    public void setUp(){
        fileUtil = new FileUtil();
    }

    @Test
    public void testFileContentsWithValues() throws IOException {
        Stream<String> inputStream= Stream.of("test");
        String data = fileUtil.fileContents(inputStream);
        Assert.assertEquals("test",data);
    }

    @Test
    public void testFileContentsWithEmptyValue() throws IOException {
        Stream<String> inputStream= Stream.empty();
        String data = fileUtil.fileContents(inputStream);
        Assert.assertEquals("",data);
    }

    @Test
    public void testFileReverseContents(){
        List<Character> reverseCharaters = fileUtil.reverseContents("tests");
        Assert.assertEquals(reverseCharaters.size(),5);
        Assert.assertEquals(reverseCharaters.get(0),'s');
    }

    @Test
    public void testFileReverseContentsEmpty() {
        List<Character> reverseCharaters = fileUtil.reverseContents("");
        Assert.assertEquals(reverseCharaters.size(),0);
    }

    @Test
    public void testFileReverseContentsNull() {
        List<Character> reverseCharaters = fileUtil.reverseContents(null);
        Assert.assertEquals(reverseCharaters.size(),0);
    }

    @Test
    public void testConvertCharacterArrayToString(){
        List<Character> reverseValues = Arrays.asList('s','t','e');
        String reverseValuesString = fileUtil.convertCharacterArrayToString(reverseValues);
        Assert.assertEquals("ste",reverseValuesString);
    }
}
