package scanners;

import java.io.*;

/**
 * Created by reza on 12/31/14.
 *
 */
public class TextFileContentScanner {

    BufferedReader br;
    public void openFile(File file){

        FileReader fr;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void closeFile(){

        try {
            if(br !=  null) {
                br.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String readTextLine(){

        try {
            if(br.ready()){

                return br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";

    }




}
