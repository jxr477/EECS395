package DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class SchoolDBConnect {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Congrad";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jasky981013#";

    private static SchoolDBConnect SchoolDBConnectSingleton = new SchoolDBConnect();

    public static SchoolDBConnect getSchoolDBConnectInstance() {
        return SchoolDBConnectSingleton;
    }

    private SchoolDBConnect(){}

    public static ArrayList<String> getAllSchoolNames()
    {
        ArrayList<String> output = new ArrayList<>();

        try{
            Class.forName(JDBC_DRIVER);
        }
        catch(ClassNotFoundException e1){
            e1.printStackTrace();
        }

        Properties props= new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);

        try{
            Connection conn = DriverManager.getConnection(DB_URL, props);

            Statement st= conn.createStatement();
            ResultSet rs= st.executeQuery("select school_name from school");

            while(rs.next()){
                output.add(rs.getString("school_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }



    public static void main(String[] args) {

        ArrayList<String> test = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchoolNames();
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));

    }


}
