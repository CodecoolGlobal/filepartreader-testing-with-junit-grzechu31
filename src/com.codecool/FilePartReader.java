import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class FilePartReader {

    private static String filePath;
    private static Integer fromLine;
    private static Integer toLine;

    public FilePartReader() {
        filePath = "/home/cc/Desktop/OopModule/testing/filepartreader-testing-with-junit-grzechu31/text.txt";
        fromLine = 1;
        toLine = 10;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine || fromLine < 1 ) {
            throw new  IllegalArgumentException("Jestes glupi, zle argumenty wejsciowe");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.filePath));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }


    public String readLines() throws IOException {

        String fileAsString = null;
        try {
            fileAsString = read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String newString = "";
            if(fromLine == toLine){
                newString = fileAsString.split("\n")[fromLine-1];
                return newString;
            }else{
                if(toLine>fileAsString.split("\n").length) {
                    toLine = fileAsString.split("\n").length;
                };
                for(int i = fromLine-1; i < toLine;i++){

                    newString +=fileAsString.split( "\n")[i]+"\n";


                }
        }




        return newString;
    }

}

