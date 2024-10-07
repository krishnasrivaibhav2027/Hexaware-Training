public class Permutations {
    public static void main(String[] args) {
        generatePermutations("","123");
    }
    static void generatePermutations(String modified, String original){
        if(original.isEmpty()){
            System.out.println(modified);
            return;
        }
        char ch = original.charAt(0);
        for(int i=0;i<=modified.length();i++){
            String first = modified.substring(0,i);
            String last = modified.substring(i);
            generatePermutations(first+ch+last,original.substring(1));

        }
    }
}
