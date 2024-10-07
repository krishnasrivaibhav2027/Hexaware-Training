import java.util.ArrayList;

public class LetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {
        System.out.println(generateCombinations("","78"));
        System.out.println(generateCombinations2("","78"));
    }
    static ArrayList<String> generateCombinations(String modified, String original){
        if(original.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(modified);
            return list;
        }
        int digit = original.charAt(0)-'0';
        ArrayList<String> list = new ArrayList<>();
        for(int i= (digit-1)*3; i<digit*3;i++){
            char ch = (char)('a'+i);
            list.addAll(generateCombinations(modified+ch,original.substring(1)));
        }
        return list;
    }

    static ArrayList<String> generateCombinations2(String modified, String original){
        if(original.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(modified);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        int digit = original.charAt(0)-'0';
        String[] mapping = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String letters = mapping[digit-1];
        for(int i=0;i<letters.length();i++){
            char ch = letters.charAt(i);
            list.addAll(generateCombinations2(modified+ch,original.substring(1)));
        }
        return list;
    }
}
