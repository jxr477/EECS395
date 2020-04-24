package Generator;

import DBConnect.ProgramDBConnect;

import java.util.ArrayList;

public class Search {

    public static final int MAX_NUM_SCHOOLS = 10;
    public static final ArrayList<Program> allPrograms = ProgramDBConnect.getProgramDBConnectInstance().getAllProgram();

    public static ArrayList<String> search(String input){
        ArrayList<String> result = new ArrayList<String>( );
        for (int i = 0; i < allPrograms.size();i++){
            Program temp = allPrograms.get(i);
            if (input.equals(temp.getProgram_name())){
                result.add(temp.toString());
            }
        }
        if (result.size() == 0)
            result.add("No result found");
        return result;
    }


    public static void main(String[] args) {
        ArrayList<String> test1 = Search.search("Computer Engineering");
        for (int i = 0; i < test1.size(); i++)
            System.out.println(test1.get(i));
        ArrayList<String> test2 = Search.search("should have no result");
        for (int i = 0; i < test2.size(); i++)
            System.out.println(test2.get(i));
    }
}
