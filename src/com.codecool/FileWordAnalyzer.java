

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer() {
        filePartReader = new FilePartReader();

    }

    public ArrayList getWordsOrderedAlphabetically() throws IOException {
        String data =filePartReader.readLines();
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(data.split("\n")));
        Collections.sort(arrayList);
        return arrayList;

    }

    public ArrayList<String> getWordsContainingSubstring(String subString) throws IOException {
        String data = filePartReader.readLines();
        String[] dataList = data.split("\n");
        ArrayList<String> substringList = new ArrayList<>();
        for (int i = 0; i < dataList.length; i++) {
            if (dataList[i].contains(subString)) {
                substringList.add(dataList[i]);
            }
        }
        return substringList;


    }

    public ArrayList<String> getStringsWhichPalindromes() throws IOException {
        String data = filePartReader.readLines();
        String[] dataArray = data.split("\n");
        ArrayList<String> wordArray = new ArrayList<>();
        for (int i = 0; i < dataArray.length; i++) {

            int index = dataArray[i].length() / 2;
            boolean isPalindrome = false;
            for (int j = 0; j < index; j++) {
                if (dataArray[i].charAt(j) == dataArray[i].charAt(dataArray[i].length() - j-1)) {
                    isPalindrome = true;
                } else {
                    isPalindrome = false;
                }

            }
            if (isPalindrome)
                wordArray.add(dataArray[i]);
            }


        }
        return  wordArray;


    }
}
