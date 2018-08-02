
public class ProjectCrypto {
    public static void main(String[] args){
        //take in string to be encrypted
        System.out.println(normalizeText("This is some \"really\" great. (Text)!?"));
        System.out.println(caesarify("DOG",3));
        System.out.println(groupify("APPLESQ",2));
        System.out.println(encryptString("APPLES",5,2));
        System.out.println(obify("APPLES"));

    }
    //Renoves spaces, punctuation, and makes string uppercase.
    public static String normalizeText(String text){
        return text.replaceAll("[^a-zA-Z ]", "")
                .replaceAll("\\s+","").toUpperCase();
    }
    public static String obify(String s){
        String new_string = "";
        for (int i=0;i<s.length();i++){
            //adds an "OB" before every vowel in a string
            if (s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'||s.charAt(i)=='Y'){
                new_string+="OB";
                //Adds "OB" in then goes to the next letter
                new_string+=s.charAt(i);
            }
            //so if it's not a vowel just add the next letter in
            else{
                new_string+=s.charAt(i);
            }
        }
        return new_string;
    }
    public static String caesarify(String text, int n){
        String s = "";
        String alpha = shiftAlphabet(n);
        for(int i =0; i < text.length();i++){
            // subtract char at this index by char value for A
            int shift = text.charAt(i) - 65;
            //create new string with character at this index in alpha
            s += alpha.charAt(shift);
        }
        return s;
    }
/*Takes an integer to specify the shift value and return a string, the uppercase
alphabet shifted by the shift value */
    public static String shiftAlphabet(int shift) {
        int start = 0;
        if (shift < 0) {
            start = (int) 'Z' + shift + 1;
        } else {
            start = 'A' + shift;
        }
        String result = "";
        char currChar = (char) start;
        for(; currChar <= 'Z'; ++currChar) {
            result = result + currChar;
        }
        if(result.length() < 26) {
            for(currChar = 'A'; result.length() < 26; ++currChar) {
                result = result + currChar;
            }
        }
        return result;
    }
    public static String groupify(String text, int n){
        String a = text;
        //if remainder add an x so it's an even grouping
        if(text.length()%n != 0){
            // while i is less than the remainder of the length and number of groups
            for(int i = 0; i < text.length()%n;i++){
                a+="x";
            }
        }
        //if no remainder, add a space every n letters
        String s ="";
        for(int i = 0; i<a.length();i+=n){
            //substring is exclusive in second parameter
            s+=a.substring(i,i+n);
            //so space gets added in here in this line
            s+=" ";
        }
        return s;
    }
    public static String encryptString(String s, int n, int group){
        return groupify(caesarify(obify(normalizeText(s)),n),group);

    }
}
