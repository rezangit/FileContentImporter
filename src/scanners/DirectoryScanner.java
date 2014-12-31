package scanners;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by reza on 12/28/14.
 */
public class DirectoryScanner {

    ArrayList<File> mainList;

    public List<File> scan(File path, boolean recursive){

        mainList = new ArrayList<File>();

        if(recursive == true) {
            findFileRecursive(path);
        }
        else{
            findFile(path);
        }

        return mainList;
    }

    private void findFile(File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File f : list)
            {
                if (f.isFile())
                {
                    System.out.println(f.getAbsolutePath());
                    mainList.add(f.getAbsoluteFile());
                }
            }
    }

    private void findFileRecursive(File file)
    {
        File[] list = file.listFiles();
        if(list!=null)
            for (File f : list)
            {
                if (f.isDirectory())
                {
                    findFileRecursive(f);
                }
                else
                {
                    System.out.println(f.getAbsolutePath());
                    mainList.add(f.getAbsoluteFile());
                }
            }
    }

}
