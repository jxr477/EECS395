package Generator;
import java.util.*;
import DBConnect.*;

public class Generator {

    public static final int MAX_NUM_SCHOOLS = 10;
    public static final ArrayList<School> allSchools = SchoolDBConnect.getSchoolDBConnectInstance().getAllSchool();

    public static double getAverageGPA(String school_id){
        ArrayList<Double> gpa = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGPA(school_id);
        double sum = 0;
        for (int i = 0; i < gpa.size(); i++)
            sum = sum + gpa.get(i);

        double average = sum / gpa.size();
        return average;
    }

    public static double getAverageGRE_V(String school_id){
        ArrayList<Integer> gre_v = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGRE_V(school_id);
        double sum = 0;
        for (int i = 0; i < gre_v.size(); i++)
            sum = sum + gre_v.get(i);

        double average = sum / gre_v.size();
        return average;
    }

    public static double getAverageGRE_Q(String school_id){
        ArrayList<Integer> gre_q = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGRE_Q(school_id);
        double sum = 0;
        for (int i = 0; i < gre_q.size(); i++)
            sum = sum + gre_q.get(i);

        double average = sum / gre_q.size();
        return average;
    }

    public static double getAverageGRE_W(String school_id){
        ArrayList<Double> gre_w = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentGRE_W(school_id);
        double sum = 0;
        for (int i = 0; i < gre_w.size(); i++)
            sum = sum + gre_w.get(i);

        double average = sum / gre_w.size();
        return average;
    }

    public static double getAverageWorkingTime(String school_id){
        ArrayList<Double> working_time = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentWorkingTime(school_id);
        double sum = 0;
        for (int i = 0; i < working_time.size(); i++)
            sum = sum + working_time.get(i);

        double average = sum / working_time.size();
        return average;
    }

    public static double getAverageToefl(String school_id){
        ArrayList<Integer> toefl = StudentDBConnect.getStudentDBConnectInstance().getAcceptedStudentToefl(school_id);
        double sum = 0;
        for (int i = 0; i < toefl.size(); i++)
            sum = sum + toefl.get(i);

        double average = sum / toefl.size();
        return average;
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

    public static ArrayList<School> generate(Student student){

        ArrayList<School> recommendation = new ArrayList<School> ();

        for (int i = 0; i < allSchools.size(); i++){
            String school_id = ("'" + allSchools.get(i).getSchoolID() + "'"); // adjust format

            double average_gpa = Generator.getAverageGPA(school_id);
            double average_gre_v = Generator.getAverageGRE_V(school_id);
            double average_gre_q = Generator.getAverageGRE_Q(school_id);
            double average_gre_w = Generator.getAverageGRE_W(school_id);
            double average_working_time = Generator.getAverageWorkingTime(school_id);
            double average_toefl = Generator.getAverageToefl(school_id);
            boolean average_publication = Generator.getAveragePublication(school_id);

            boolean adjusted_publication = Generator.AdjustPublication(student.getPublication(), average_publication);

            if (Generator.GraduateFromUS(student.getStudentID()) == true){

                if (student.getGPA() >= (average_gpa - 0.2) && student.getGRE_V() >= (average_gre_v - 2)
                        && student.getGRE_Q() >= (average_gre_q - 2) && student.getGRE_W() >= (average_gre_w - 0.5)
                        &&  adjusted_publication == true && student.getTOEFL() >= (average_toefl - 10)
                        && student.getWorkingTime() >= (average_working_time - 1)){

                    recommendation.add(allSchools.get(i));
                }

            }

            else{

                if (student.getGPA() >= (average_gpa - 0.1) && student.getGRE_V() >= (average_gre_v - 2)
                        && student.getGRE_Q() >= (average_gre_q - 2) && student.getGRE_W() >= (average_gre_w - 0.5)
                        &&  adjusted_publication == true && student.getTOEFL() >= (average_toefl - 5)
                        && student.getWorkingTime() >= (average_working_time - 0.5)){

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

        student_id = ("'" + student_id + "'"); // adjust format
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

        Student student1 = new Student("9999", 4.0, 170, 170, 6.0, 120, true, 10, "China");
        Student student2 = new Student("0001", 3.42, 157, 168, 3.0, 100, false, 0, "China");


        System.out.println("Recommended Schools: ");
        System.out.println(" ");



        ArrayList<School> test = Generator.generate(student2);
        for (int i = 0; i < test.size(); i++)
            System.out.println(test.get(i));
    }
}
