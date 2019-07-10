

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileWordAnalyzerTest{
    private FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer();



    @Test
    public void test_getWordsOrderedAlphabetically()  {
        fileWordAnalyzer.setFilePartReader("test4.txt",1,3);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("ada");
        expected.add("barbara");
        expected.add("tereska");
        assertEquals(expected,this.fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void getWordsContainingSubstring() {
        fileWordAnalyzer.setFilePartReader("test3.txt",1,5);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("asddsa");
        expected.add("asdfdsa");
        expected.add("asfsa");
        assertEquals(expected,fileWordAnalyzer.getWordsContainingSubstring("as"));
    }

    @Test
    public void getStringsWhichPalindromes() {
        fileWordAnalyzer.setFilePartReader("test3.txt",1,5);
        ArrayList<String> expected = new ArrayList<>();
        expected.add("asddsa");
        expected.add("asdfdsa");
        expected.add("asfsa");
        assertEquals(expected,fileWordAnalyzer.getStringsWhichPalindromes());
    }
}