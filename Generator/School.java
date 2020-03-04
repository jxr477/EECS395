package Generator;

import java.util.*;

public class School {

    private String school_id;
    private String school_name;
    private String school_location;
    private int school_ranking;

    public School(String school_ids, String school_names, String school_locations, int school_rankings){
        school_id = school_ids;
        school_name = school_names;
        school_location = school_locations;
        school_ranking = school_rankings;

    }

    public String getSchoolID() {
        return school_id;
    }

    public String getSchoolName(){
        return school_name;
    }

    public String getSchool_location(){
        return school_location;
    }

    public int getSchoolRanking(){
        return school_ranking;
    }

    public String toString(){
        return ("school_id: " + school_id + ", " + "school_name: " + school_name + ", " + "school_location: " + school_location
        + ", " + "school_ranking: " + school_ranking);
    }

    public static void main(String[] args){

        System.out.println("Test");
    }

}


