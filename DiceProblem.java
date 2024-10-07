import java.util.ArrayList;

public class DiceProblem {
    public static void main(String[] args) {
        System.out.println(generateDiceCombinations("",4));
    }
    static ArrayList<String> generateDiceCombinations(String combinations, int target){
        if(target==0){
            ArrayList<String> list = new ArrayList<>();
            list.add(combinations);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i=1; i<=6 && i<=target; i++){
            list.addAll(generateDiceCombinations(combinations+i,target-i));
        }
        return list;
    }
}
