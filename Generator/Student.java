package Generator;

import java.util.*;

public class Student {

    private String student_id;
    private double gpa;
    private int gre_v;
    private int gre_q;
    private double gre_w;
    private int toefl;
    private boolean publication;
    private double working_time;
    private String nationality;


    public Student(String student_id, double gpa, int gre_v, int gre_q, double gre_w, int toefl, boolean publication, double working_time, String nationality){
        this.student_id = student_id;
        this.gpa = gpa;
        this.gre_v = gre_v;
        this.gre_q = gre_q;
        this.gre_w = gre_w;
        this.toefl = toefl;
        this.publication = publication;
        this.working_time = working_time;
        this.nationality = nationality;
    }

    public String getStudentID() {
        return student_id;
    }

    public String getNationality(){
        return nationality;
    }

    public double getGPA(){
        return gpa;
    }

    public int getGRE_V(){
        return gre_v;
    }

    public int getGRE_Q(){
        return gre_q;
    }

    public double getGRE_W(){
        return gre_w;
    }

    public int getTOEFL(){
        return toefl;
    }

    public boolean getPublication(){
        return publication;
    }

    public double getWorkingTime(){
        return working_time;
    }

    public String toString(){
        return ("student_id: " + student_id + " " + "gpa: " + gpa + " " + "gre_v: " + gre_v
                + " " + "gre_q: " + gre_q + " " + "gre_w: " + gre_w + " " + "toefl: " + toefl
        + " " + "publication: " + publication + " " + "working_time: " + working_time + " " +
        "nationality: " + nationality);
    }

    public static void main(String[] args){

        System.out.println("Test");
    }

}


