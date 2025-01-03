public class MakeWords {
    public static void main(String[] args) {
        makeWords(2,"","abc");
    }

    public static void makeWords(int remainingLetters, String result, String alphabet){
        if (remainingLetters > 0) {
            for (int i = 0; i < alphabet.length(); i++) {
                makeWords (remainingLetters - 1, result + alphabet.charAt(i), alphabet);
            }
        } else {
            System.out.println(result);
        }
    }
}
