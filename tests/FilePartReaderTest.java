import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    FilePartReader filePartReader = new FilePartReader();

    @Test
    public void setup_and_readCorrectData() throws IOException {
        filePartReader.setup("text.txt",2,4);
        assertEquals(9,filePartReader.read().split("\n").length);

//        String content = filePartReader.read();
//        assertEquals("1\n2\n3", content);

    }
    @Test
    public void setup_and_readLinesCorrectData() throws IOException{
        filePartReader.setup("text.txt",1,4);
        assertEquals(4,filePartReader.readLines().split("\n").length);
    }

    @Test
    public void setup_and_readLinesWrongData(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            filePartReader.setup("text.txt", 3,1);
                });

    }

    @Test
    public void checkExaxtMasage_read() throws IOException {
        filePartReader.setup("test2.txt",1,2);
        assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n0\n",filePartReader.read());
    }

    @Test
    public void getOneLine_readLines() throws IOException {
        filePartReader.setup("test2.txt",1,1);
        assertEquals("1",filePartReader.readLines());
    }

    @Test
    public void checkExaxtMasage_readLines() throws IOException {
        filePartReader.setup("test2.txt",1,3);
        assertEquals("1\n2\n3\n",filePartReader.readLines());
    }




}