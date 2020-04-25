package Generator;
import java.util.*;
import DBConnect.*;

public class Generator {

    public static final int MAX_NUM_SCHOOLS = 10;
    public static final ArrayList<School> allSchools = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchool();
    public static final ArrayList<String> allSchoolIds = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchoolIDs();
    public static final ArrayList<Double> all_average_gpa = Generator.getAllAverageGPA();
    public static final ArrayList<Double> all_average_gre_v = Generator.getAllAverageGRE_V();
    public static final ArrayList<Double> all_average_gre_q = Generator.getAllAverageGRE_Q();
    public static final ArrayList<Double> all_average_gre_w = Generator.getAllAverageGRE_W();
    public static final ArrayList<Double> all_average_working_time = Generator.getAllAverageWorkingTime();
    public static final ArrayList<Double> all_average_toefl = Generator.getAllAverageToefl();
    public static final ArrayList<Boolean> all_average_publication = Generator.getAllAveragePublication();

    public static double getAverageGPA(String school_id){
        ArrayList<Double> gpa = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGPA(school_id);
        double sum = 0;
        for (int i = 0; i < gpa.size(); i++)
            sum = sum + gpa.get(i);

        double average = sum / gpa.size();
        return average;
    }

    public static ArrayList<Double> getAllAverageGPA(){
        ArrayList<Double> output = new ArrayList<Double> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAverageGPA(school_id));
        }

        return output;

    }

    public static double getAverageGRE_V(String school_id){
        ArrayList<Integer> gre_v = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGRE_V(school_id);
        double sum = 0;
        for (int i = 0; i < gre_v.size(); i++)
            sum = sum + gre_v.get(i);

        double average = sum / gre_v.size();
        return average;
    }

    public static ArrayList<Double> getAllAverageGRE_V(){
        ArrayList<Double> output = new ArrayList<Double> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAverageGRE_V(school_id));
        }

        return output;

    }

    public static double getAverageGRE_Q(String school_id){
        ArrayList<Integer> gre_q = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGRE_Q(school_id);
        double sum = 0;
        for (int i = 0; i < gre_q.size(); i++)
            sum = sum + gre_q.get(i);

        double average = sum / gre_q.size();
        return average;
    }

    public static ArrayList<Double> getAllAverageGRE_Q(){
        ArrayList<Double> output = new ArrayList<Double> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAverageGRE_Q(school_id));
        }
        return output;
    }

    public static double getAverageGRE_W(String school_id){
        ArrayList<Double> gre_w = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGRE_W(school_id);
        double sum = 0;
        for (int i = 0; i < gre_w.size(); i++)
            sum = sum + gre_w.get(i);

        double average = sum / gre_w.size();
        return average;
    }

    public static ArrayList<Double> getAllAverageGRE_W(){
        ArrayList<Double> output = new ArrayList<Double> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAverageGRE_W(school_id));
        }
        return output;
    }

    public static double getAverageWorkingTime(String school_id){
        ArrayList<Double> working_time = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentWorkingTime(school_id);
        double sum = 0;
        for (int i = 0; i < working_time.size(); i++)
            sum = sum + working_time.get(i);

        double average = sum / working_time.size();
        return average;
    }

    public static ArrayList<Double> getAllAverageWorkingTime(){
        ArrayList<Double> output = new ArrayList<Double> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAverageWorkingTime(school_id));
        }
        return output;
    }

    public static double getAverageToefl(String school_id){
        ArrayList<Integer> toefl = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentToefl(school_id);
        double sum = 0;
        for (int i = 0; i < toefl.size(); i++)
            sum = sum + toefl.get(i);

        double average = sum / toefl.size();
        return average;
    }

    public static ArrayList<Double> getAllAverageToefl(){
        ArrayList<Double> output = new ArrayList<Double> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAverageToefl(school_id));
        }
        return output;
    }

    public static boolean getAveragePublication(String school_id){
        ArrayList<Boolean> publication = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentPublication(school_id);

        int true_count = 0;
        int false_count = 0;

        for (int i = 0; i < publication.size(); i++){
            if (publication.get(i) == true)
                true_count++;
            else
                false_count++;
        }

        boolean average = false;
        if (true_count > false_count)
            average = true;

        return average;
    }

    public static ArrayList<Boolean> getAllAveragePublication(){
        ArrayList<Boolean> output = new ArrayList<Boolean> ();;

        for (int i = 0; i < allSchoolIds.size(); i++){
            String school_id = allSchoolIds.get(i);
            output.add(Generator.getAveragePublication(school_id));
        }
        return output;
    }

    public static ArrayList<School> generate(String studentID){
        studentID = "'" + studentID + "'";

        ArrayList<School> recommendation = new ArrayList<School> ();

        double studentGPA = StudentDBConnect.getStudentDBConnectInstance().getGPA(studentID);
        double studentGRE_V = StudentDBConnect.getStudentDBConnectInstance().getGRE_V(studentID);
        double studentGRE_Q = StudentDBConnect.getStudentDBConnectInstance().getGRE_Q(studentID);
        double studentGRE_W = StudentDBConnect.getStudentDBConnectInstance().getGRE_W(studentID);
        double studentTofel = StudentDBConnect.getStudentDBConnectInstance().getToefl(studentID);
        double studentWorkingTime = StudentDBConnect.getStudentDBConnectInstance().getWorkingTime(studentID);

        for (int i = 0; i < allSchools.size(); i++){
            double average_gpa = all_average_gpa.get(i);
            double average_gre_v = all_average_gre_v.get(i);
            double average_gre_q = all_average_gre_q.get(i);
            double average_gre_w = all_average_gre_w.get(i);
            double average_working_time = all_average_working_time.get(i);
            double average_toefl = all_average_toefl.get(i);
            boolean average_publication = all_average_publication.get(i);


            boolean adjusted_publication = Generator.AdjustPublication(StudentDBConnect.getStudentDBConnectInstance().getPublication(studentID), average_publication);

            if (Generator.GraduateFromUS(studentID) == true){

                if (studentGPA >= (average_gpa - 0.2) && studentGRE_V >= (average_gre_v - 2)
                        && studentGRE_Q >= (average_gre_q - 2) && studentGRE_W >= (average_gre_w - 0.5)
                        &&  adjusted_publication == true && studentTofel >= (average_toefl - 10)
                        && studentWorkingTime >= (average_working_time - 1)){

                    recommendation.add(allSchools.get(i));
                }

            }

            else{

                if (studentGPA >= (average_gpa - 0.1) && studentGRE_V >= (average_gre_v - 2)
                        && studentGRE_Q >= (average_gre_q - 2) && studentGRE_W >= (average_gre_w - 0.5)
                        &&  adjusted_publication == true && studentTofel >= (average_toefl - 5)
                        && studentWorkingTime >= (average_working_time - 0.5)){

                    recommendation.add(allSchools.get(i));
                }

            }

        }

        ArrayList<School> output = new ArrayList<School> ();
        if (recommendation.size() > MAX_NUM_SCHOOLS)
        {
            for (int i = 0; i < MAX_NUM_SCHOOLS; i++)
                output.add(recommendation.get(i));
        }
        else
            output = recommendation;

        return output;
    }

    public static boolean GraduateFromUS(String student_id){

        if (StudentDBConnect.getStudentDBConnectInstance().getGraduateSchoolName(student_id).equals("Not Found"))
            return false;
        else
            return true;

    }

    public static boolean AdjustPublication(boolean student_publication, boolean average_publication){

        if (student_publication == average_publication == true)
            return true;
        else if (student_publication == average_publication == false)
            return true;
        else if (student_publication == true && average_publication == false)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

        System.out.println("Recommended Schools: ");
        System.out.println(" ");



        ArrayList<School> test = Generator.generate("0001");
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));
    }
}