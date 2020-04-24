package Generator;

public class Program {

    private String program_id;
    private String program_name;
    private String program_major;
    private String program_degree;
    private int program_tuition;
    private int program_ranking;
    private int program_enrollment;
    private int program_duration;

    public Program(String program_ids,
                   String program_names,
                   String program_majors,
                   String program_degrees,
                   int program_tuitions,
                   int program_rankings,
                   int program_enrollments,
                   int program_durations) {
        program_id = program_ids;
        program_name = program_names;
        program_major = program_majors;
        program_degree = program_degrees;
        program_tuition = program_tuitions;
        program_ranking = program_rankings;
        program_enrollment = program_enrollments;
        program_duration = program_durations;
    }

    public String getProgram_id() {
        return program_id;
    }

    public String getProgram_name(){
        return program_name;
    }

    public String getProgram_major(){
        return program_major;
    }

    public String getProgram_degree(){
        return program_degree;
    }


    public int getProgram_tuition(){ return program_tuition; }

    public int getProgram_ranking(){ return program_ranking; }

    public int getProgram_enrollment(){ return program_enrollment; }

    public int getProgram_duration(){ return program_duration; }

    public String toString(){
        return ("program_id: " + program_id + ", " +
                "program_name: " + program_name + ", " +
                "program_major: " + program_major + ", " +
                "program_degree: " + program_degree + ", " +
                "program_tuition: " + program_tuition + ", " +
                "program_ranking: " + program_ranking + ", " +
                "program_enrollment: " + program_enrollment + ", " +
                "program_duration: " + program_duration);
    }
}


