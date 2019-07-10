

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer() {
        filePartReader = new FilePartReader();

    }

    public List getWordsOrderedAlphabetically() {

        String data =filePartReader.readLines();
        List<String> arrayList = new ArrayList<>(Arrays.asList(data.split("\n")));
        Collections.sort(arrayList);
        return arrayList;

    }

    public List<String> getWordsContainingSubstring(String subString) {
        String[] dataList = getArrayFromFilePartReader();
        List<String> substringList = new ArrayList<>();
        for (String word : dataList) {
            if (word.contains(subString)) {
                substringList.add(word);
            }
        }
        return substringList;

//TODO: change all left siede of arraylists should be just LIST; done
    }
    //TODO: create more small methods and replace some code in side getStringsWhichPalindromes; done
    public List<String> getStringsWhichPalindromes() {
        String[] dataArray = getArrayFromFilePartReader();
        List<String> wordArray = new ArrayList<>();

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
            if (isPalindrome) {
                wordArray.add(dataArray[i]);
            }


        }
        return  wordArray;


    }

    private String[] getArrayFromFilePartReader(){
        String partOfText = filePartReader.readLines();
        return partOfText.split("\n");

    }

    public void setFilePartReader(String filePath, int fromLine, int toLine){
        this.filePartReader.setup(filePath, fromLine, toLine);
    }


}
