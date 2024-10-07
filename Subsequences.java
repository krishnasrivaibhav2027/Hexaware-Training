import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        generateSubSequences("","abcabcbb");
        System.out.println(generateArrayList("","abcabcbb"));
    }
    static void generateSubSequences(String modified,String original){
        if(original.isEmpty()){
            System.out.println(modified);
            return;
        }
        generateSubSequences(modified+original.charAt(0),original.substring(1));
        generateSubSequences(modified,original.substring(1));
    }
    static ArrayList<String> generateArrayList(String modified, String original){
        if(original.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            if(!modified.isEmpty()){
                list.add(modified);
            }
            return list;
        }
        ArrayList<String> consider = generateArrayList(modified+original.charAt(0),original.substring(1));
        ArrayList<String> Ignore = generateArrayList(modified,original.substring(1));

        consider.addAll(Ignore);
        return consider;
    }
}
