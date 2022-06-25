import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        Scanner input = new  Scanner(System.in);
        String inputWord = "";
        boolean palinOrNot = false;
        boolean palinOrNot2 = false;
        
        System.out.print("Please enter a word to check if it is a palindrome or not: ");
        inputWord = input.nextLine();
        System.out.println();

        palinOrNot = checkPalindromeStack(inputWord);
        if(palinOrNot == true)
            System.out.println("This word is a palindrome (checked by Stack).");
        else
            System.out.println("This word is not a palindrome (checked by Stack).");

        palinOrNot2 = checkPalindromeQueue(inputWord);
        if(palinOrNot2 == true)
            System.out.println("This word is a palindrome (checked by Queue).");
        else
            System.out.println("This word is not a palindrome (checked by Queue).");
    }

    public static boolean checkPalindromeStack(String word) {
        LinkedStack<Character> letters = new LinkedStack<Character>();
        
        int wordlength = word.length();
        String newWord = "";
        
        for(int i = 0; i < wordlength; i++) {
            letters.push(word.charAt(i));
        }

        for(int i = 0; i < wordlength; i++) {
            newWord = "" + newWord + letters.pop();
        }

        if(newWord.equals(word))
            return true;
        else
            return false;
    }

    public static boolean checkPalindromeQueue(String word) {
        LinkedQueue<Character> letters = new LinkedQueue<Character>();
        
        int wordlength = word.length();
        String newWord = "";
        
        for(int i = word.length() - 1; i >= 0; i--) {
            letters.enqueue(word.charAt(i));
        }

        for(int i = 0; i < wordlength; i++) {
            newWord = "" + newWord + letters.dequeue();
        }

        if(newWord.equals(word))
            return true;
        else
            return false;
    }
}