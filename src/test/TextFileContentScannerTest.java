package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import scanners.TextFileContentScanner;

import java.io.File;

public class TextFileContentScannerTest {

    TextFileContentScanner tfs;
    @Before
    public void setUp() throws Exception {

        tfs = new TextFileContentScanner();
        tfs.openFile(new File("/home/reza/tt.txt"));
    }

    @After
    public void tearDown() throws Exception {

        tfs.closeFile();
    }

    @Test
    public void testReadTextLine() throws Exception {

        String strLine;
        while(true) {
            strLine = tfs.readTextLine();
            if(strLine.isEmpty()){
                break;
            }

            System.out.println(strLine);


        }

    }
}