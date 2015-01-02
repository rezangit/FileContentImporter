import database.DBAccess;
import database.MysqlDBAccess;
import scanners.DirectoryScanner;
import scanners.TextFileContentScanner;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by reza on 12/31/14.
 */

public class ContentImporter {


    public static void main(String[] args) {

        ContentImporter ci = new ContentImporter();
        ci.importData();

    }

    public void importData() {

        String strLineContent;
        DirectoryScanner directory = new DirectoryScanner();
        List<File> fileList = directory.scan(new File("/home/reza"), false);

        DBAccess db = new MysqlDBAccess();
        Connection con = db.getConnection("127.0.0.1:3306/dataInfo", "utest", "upass");
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO textfile (file, firstField, secondField) VALUES(?,?,?);");

            TextFileContentScanner tf = new TextFileContentScanner();

            for (File f : fileList) {

                if (f.getName().contains(".dinf")) {

                    tf.openFile(f);
                    try {
                        while (true) {
                            strLineContent = tf.readTextLine();
                            if (strLineContent.isEmpty()) {
                                break;
                            }
                            String[] strList = strLineContent.split(":");


                            if (strList.length >= 2) {

                                ps.setString(1, f.getName());

                                ps.setString(2, strList[0]);
                                ps.setString(3, strList[1]);
                                ps.executeUpdate();
                            }


                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
