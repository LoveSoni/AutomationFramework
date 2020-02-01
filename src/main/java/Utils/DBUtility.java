package Utils;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
    // initialized globally for testing
    private Logger logger = Logger.getLogger(DBUtility.class);
    String url ="";
    String username="";
    String password="";

    @Test
    public void setUp(){
        connect(url,username,password);
    }

    public void connect(String dbUrl,String userName,String password){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection(dbUrl, userName, password);
        }catch (Exception sqlException)
        {
            logger.error("exception catch "+sqlException.getMessage());
        }
    }

}
