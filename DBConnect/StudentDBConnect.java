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

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Double> getAcceptedStudentGPA(String school_id)
    {
        ArrayList<Double> output = new ArrayList<>();

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
            ResultSet rs= st.executeQuery("select gpa from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getDouble("gpa"));
            }

            conn.close();
            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Integer> getAcceptedStudentGRE_V(String school_id)
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
            ResultSet rs= st.executeQuery("select gre_v from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getInt("gre_v"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Integer> getAcceptedStudentGRE_Q(String school_id)
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
            ResultSet rs= st.executeQuery("select gre_q from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getInt("gre_q"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Double> getAcceptedStudentGRE_W(String school_id)
    {
        ArrayList<Double> output = new ArrayList<>();

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
            ResultSet rs= st.executeQuery("select gre_w from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getDouble("gre_w"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Integer> getAcceptedStudentToefl(String school_id)
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
            ResultSet rs= st.executeQuery("select toefl from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getInt("toefl"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Double> getAcceptedStudentWorkingTime(String school_id)
    {
        ArrayList<Double> output = new ArrayList<>();

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
            ResultSet rs= st.executeQuery("select working_time from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getDouble("working_time"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<Boolean> getAcceptedStudentPublication(String school_id)
    {
        ArrayList<Boolean> output = new ArrayList<>();

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
            ResultSet rs= st.executeQuery("select student_publication from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getBoolean("student_publication"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static ArrayList<String> getAcceptedStudentNationality(String school_id)
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
            ResultSet rs= st.executeQuery("select nationality from student, admit, school where student.student_id = admit.student_id and school.school_id = admit.school_id and admit.accepted = true and school.school_id = " + school_id);

            while(rs.next()){
                output.add(rs.getString("nationality"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public double getGPA(String id)
    {

        double output = 0;

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
            ResultSet rs= st.executeQuery("select gpa from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getDouble("GPA"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public int getGRE_V(String id)
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
            ResultSet rs= st.executeQuery("select gre_v from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getInt("GRE_V"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public int getGRE_Q(String id)
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
            ResultSet rs= st.executeQuery("select gre_q from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getInt("GRE_Q"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public double getGRE_W(String id)
    {

        double output = 0;

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
            ResultSet rs= st.executeQuery("select gre_w from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getDouble("GRE_W"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public int getToefl(String id)
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
            ResultSet rs= st.executeQuery("select toefl from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getInt("Toefl"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public String getGraduateSchoolName(String student_id){

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
            ResultSet rs= st.executeQuery("select school_name from student, school, graduate where " +
                    "student.student_id = graduate.student_id and school.school_id = graduate.school_id and graduate.student_id = " + student_id);

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

    public boolean getPublication(String id)
    {

        boolean output = false;

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
            ResultSet rs= st.executeQuery("select student_publication from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getBoolean("student_publication"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public double getWorkingTime(String id)
    {

        double output = 0;

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
            ResultSet rs= st.executeQuery("select working_time from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getInt("working_time"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public String getNationality(String id)
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
            ResultSet rs= st.executeQuery("select nationality from student where student_id = " + id);

            while(rs.next()){
                output = (rs.getString("nationality"));
            }

            conn.close();
            st.close();
            rs.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;
    }

    public static void main(String[] args) {

        ArrayList<String> test = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentNationality("'0021'");
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));

        System.out.println(StudentDBConnect.getStudentDBConnectInstance().getGraduateSchoolName("'0101'"));

        //System.out.println(StudentDBConnect.getStudentDBConnectInstance().getNationality("'0001'"));

    }

}
