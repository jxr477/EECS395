package DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;



public class ProgramDBConnect {

    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/Congrad";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Jasky981013#";

    private static ProgramDBConnect ProgramDBConnectSingleton = new ProgramDBConnect();

    public static ProgramDBConnect getProgramDBConnectInstance() {
        return ProgramDBConnectSingleton;
    }

    private ProgramDBConnect(){}

    // get all distinct program names
    public static ArrayList<String> getAllProgramNames()
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
            ResultSet rs= st.executeQuery("select distinct program_name from school_program");

            while(rs.next()){
                output.add(rs.getString("program_name"));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void main(String[] args) {

        ArrayList<String> test = ProgramDBConnect.getProgramDBConnectInstance().getAllProgramNames();
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));

    }

}
