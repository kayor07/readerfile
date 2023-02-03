package tg.esig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {

    private static final String[] BAD_WORDS = {"fuck", "merde", "putain", "ass"};
    private static final String[] EMOJIS = {":)", "😂", "😍", "😭", "😡"};
    private static final String[] THANK_WORDS = {"amen", "akpe", "Merci", "nagode", "imela", "thanks", "thank you", "alhamdulillah", "shukran"};

    public static void main(String[] args) throws IOException {

        System.out.println("Entrez le nom de l'utilisateur:");
        Scanner Userscan = new Scanner(System.in);
        String userName = Userscan.nextLine();

        // Initialise les compteurs
        int totalM = 0;
        int lolC = 0;
        int lmaoC = 0;
        int emojiSentC = 0;
        int badWordsC = 0;
        int emojiReceivedC = 0;
        int angryEmojiC = 0;
        int thankC = 0;

        // Lit le fichier d'historique de WhatsApp
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\A2KA\\Downloads\\dislaurine.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            // Si la ligne contient le nom de l'utilisateur, cela signifie qu'elle contient un message envoyé par cet utilisateur
            if (line.contains(userName)) {
                totalM++;
                if (line.contains("lol")) {
                    lolC++;
                }
                if (line.contains("lmao")) {
                    lmaoC++;
                }
                for (String emoji : EMOJIS) {
                    if (line.contains(emoji)) {
                        emojiSentC++;
                    }
                }
                for (String badWord : BAD_WORDS) {
                    if (line.contains(badWord)) {
                        badWordsC++;
                    }
                }
                for (String thankWord : THANK_WORDS) {
                    if (line.contains(thankWord)) {
                        thankC++;
                    }
                }
            } else {
                // Si la ligne ne contient pas le nom de l'utilisateur, cela signifie qu'elle contient un message reçu par l'utilisateur
                for (String emoji : EMOJIS) {
                    if (line.contains(emoji)) {
                        emojiReceivedC++;
                    }
                }
                if (line.contains("😡")) {
                    angryEmojiC++;
                }
            }
        }
        reader.close();

        // Affiche les résultats
        System.out.println("Nombre total de messages envoyes: " + totalM);
        System.out.println("Nombre total de fois que l'utilisateur a envoye 'lol': " + lolC);
        System.out.println("Nombre total de fois ou l'utilisateur a envoye 'lmao': " + lmaoC);
        System.out.println("Nombre total de fois ou l'utilisateur a envoye des emojis: " + emojiSentC);
        System.out.println("Nombre total de grossieretes envoyees par l'utilisateur: " + badWordsC);
        System.out.println("Nombre total de fois que l'utilisateur a recu des emojis: " + emojiReceivedC);
        System.out.println("Nombre total de fois ou l'utilisateur a recu l'emoji 😡 en colere: " + angryEmojiC);
        System.out.println("Nombre total de fois ou l'utilisateur a envoye et recu les mots de remerciement: " + thankC);
    }
}
