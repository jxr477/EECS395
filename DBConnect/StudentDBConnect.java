package DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public class StudentDBConnect {
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Congrad";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jasky981013#";

    private static StudentDBConnect StudentDBConnectSingleton = new StudentDBConnect();

    public static StudentDBConnect getStudentDBConnectInstance() {
        return StudentDBConnectSingleton;
    }

    private StudentDBConnect(){}

    // get all distinct program names
    public static ArrayList<String> getAllStudentNationalities()
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
            ResultSet rs= st.executeQuery("select distinct nationality from student");

            while(rs.next()){
                output.add(rs.getString("nationality"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void main(String[] args) {

        ArrayList<String> test = StudentDBConnect.getStudentDBConnectInstance().getAllStudentNationalities();
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));

    }

}
