import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class FilePartReader {

    private String filePath;

    private int fromLine;
    private int toLine;
    // TODO: replace statics and get getters instead

    public FilePartReader() {
        filePath = "/home/cc/Desktop/OopModule/testing/filepartreader-testing-with-junit-grzechu31/text.txt";
        fromLine = 1;
        toLine = 10;
    }


    public void setup(String filePath, int fromLine, int toLine) {
        if(toLine-fromLine<0){
            throw new IllegalArgumentException("Wrong imput of fromLine and toLine");
        }
        try{
            this.filePath = filePath;
            this.fromLine = fromLine;
            this.toLine = toLine;

        }catch (IllegalArgumentException exception){}


    }

    public String read() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(this.filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            return sb.toString();
    }
    //TODO: replace throws with catch;


    public String readLines() {

        String fileAsString;
        fileAsString = read();
        StringBuilder newString = new StringBuilder();
        if (fileAsString != null) {
            if (fromLine == toLine) {

                newString = new StringBuilder(fileAsString.split("\n")[fromLine - 1]);
                return newString.toString();
            } else {
                if (toLine > fileAsString.split("\n").length) {
                    toLine = fileAsString.split("\n").length;
                }
                ;
                for (int i = fromLine - 1; i < toLine; i++) {

                    newString.append(fileAsString.split("\n")[i]).append("\n");


                }
            }

        }


        return newString.toString();
    }

}

