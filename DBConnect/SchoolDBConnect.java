package DBConnect;

import Generator.*;

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
            ResultSet rs= st.executeQuery("select school_name from school order by school_ranking");

            while(rs.next()){
                output.add(rs.getString("school_name"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<String> getAllSchoolIDs()
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
            ResultSet rs= st.executeQuery("select school_id from school order by school_ranking");

            while(rs.next()){
                output.add(rs.getString("school_id"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<String> getAllSchoolLocations()
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
            ResultSet rs= st.executeQuery("select school_location from school order by school_ranking");

            while(rs.next()){
                output.add(rs.getString("school_location"));
            }

            conn.close();
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Integer> getAllSchoolRankings()
    {
        ArrayList<Integer> output = new ArrayList<>();

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
            ResultSet rs= st.executeQuery("select school_ranking from school order by school_ranking");

            while(rs.next()){
                output.add(rs.getInt("school_ranking"));
            }

            conn.close();
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public String getSchoolName(String id)
    {

        String output = "Not Found";

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
            ResultSet rs= st.executeQuery("select school_name from school where school_id = " + id);

            while(rs.next()){
                output = (rs.getString("school_name"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public String getSchoolLocation(String id)
    {

        String output = "Not Found";

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
            ResultSet rs= st.executeQuery("select school_location from school where school_id = " + id);

            while(rs.next()){
                output = (rs.getString("school_location"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public int getSchoolRanking(String id)
    {

        int output = 0;

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
            ResultSet rs= st.executeQuery("select school_ranking from school where school_id = " + id);

            while(rs.next()){
                output = (rs.getInt("school_ranking"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }



    public ArrayList<School> getAllSchool()
    {

        ArrayList<School> output = new ArrayList<School> ();

        ArrayList<String> names = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchoolNames();
        ArrayList<String> ids = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchoolIDs();
        ArrayList<String> locations = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchoolLocations();
        ArrayList<Integer> rankings = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchoolRankings();

        for (int i = 0; i < names.size(); i++){
            School school = new School(ids.get(i), names.get(i), locations.get(i), rankings.get(i));
            output.add(school);
        }

        return output;
    }


    public static void main(String[] args) {

        ArrayList<School> test = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchool();
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));


    }


}
