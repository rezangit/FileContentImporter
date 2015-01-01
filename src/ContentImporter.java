import scanners.DirectoryScanner;
import scanners.TextFileContentScanner;

import java.io.File;
import java.util.List;

/**
 * Created by reza on 12/31/14.
 */

public class ContentImporter {


    public static void main(String[] args){

        ContentImporter ci = new ContentImporter();
        ci.importData();

    }

    public void importData(){

        String strLineContent;
        DirectoryScanner directory = new DirectoryScanner();
        List<File> fileList = directory.scan(new File("/home/reza"),false);

        TextFileContentScanner tf = new TextFileContentScanner();

        for(File f: fileList) {

            tf.openFile(f);
            while(true) {
                strLineContent = tf.readTextLine();
                if (strLineContent.isEmpty()){
                    break;
                }
                String[] strList = strLineContent.split(":");

                for(String s:strList){
                    System.out.print(s + " - ");
                }
                System.out.println(" ");

            }

        }


    }

}
