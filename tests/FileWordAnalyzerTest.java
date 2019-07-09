

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest{
    FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();
    FilePartReader filePartReader = new FilePartReader();


    @Test
    public void test_getWordsOrderedAlphabetically() throws IOException {
        filePartReader.setup("test4.txt",1,3);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("ada");
        expected.add("barbara");
        expected.add("tereska");
        assertEquals(expected,this.fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void getWordsContainingSubstring() throws IOException {
        filePartReader.setup("test3.txt",1,5);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("asddsa");
        expected.add("asdfdsa");
        expected.add("asfsa");
        assertEquals(expected,fileWordAnalyzer.getWordsContainingSubstring("as"));
    }

    @Test
    public void getStringsWhichPalindromes() throws IOException {
        filePartReader.setup("test3.txt",1,5);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("asddsa");
        expected.add("asdfdsa");
        expected.add("asfsa");
        assertEquals(expected,fileWordAnalyzer.getStringsWhichPalindromes());
    }
}