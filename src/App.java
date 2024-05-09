import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        String secret_word = "freedom";
        int max_attemp = 10;
        int attemp = 0;
        boolean guessed = false;
        char[] guessed_letters = new char[secret_word.length()];

        for (int i = 0; i < secret_word.length(); i++) {
            guessed_letters[i] = '_';
        }

        while (!guessed && attemp < max_attemp) {

            System.out.println("Word to guess: " + String.valueOf(guessed_letters) + " " + secret_word.length());
            System.out.println("Please, enter a letter: ");
            char letter = Character.toLowerCase(scanner.next().charAt(0));
            boolean correct_letter = false;
            for (int i = 0; i < secret_word.length(); i++) {
                if (secret_word.charAt(i) == letter) {
                    guessed_letters[i] = letter;
                    correct_letter = true;
                }
            }
            if (!correct_letter) {
                attemp++;
                System.out.println("Wrong letter, you have " + (max_attemp - attemp) + " attempts left");
            }
            if (String.valueOf(guessed_letters).equals(secret_word)) {
                guessed = true;
                System.out.println("Congratulations! you guessed the word " + secret_word);
            }
        }
        if (!guessed) {
            System.out.println("You ran out of attempts");
        }
        scanner.close();

    }
}
