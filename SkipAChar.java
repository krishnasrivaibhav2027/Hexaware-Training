public class SkipAChar {
    public static void main(String[] args) {
        skip("","bcaddah");
        System.out.println(skipReturnsVal("bcaddah"));
    }
    static void skip(String modify, String original){
        if(original.isEmpty()){
            System.out.println(modify);
            return;
        }
        char ch=original.charAt(0);
        if(ch=='a'){
            skip(modify,original.substring(1));
        }
        else{
            skip(modify+ch,original.substring(1));
        }
    }
    static String skipReturnsVal(String original){
        if(original.isEmpty()){
            return "";
        }
        char ch=original.charAt(0);
        if(ch=='a'){
            return skipReturnsVal(original.substring(1));
        }
        else{
            return ch+skipReturnsVal(original.substring(1));
        }
    }
}
