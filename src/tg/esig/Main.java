package tg.esig;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;



public class Main {

    private static final String[] INJURES = {"fuck", "merde", "putain", "ass"};
    private static final String[] EMOJIS = {":)", "😂", "😍", "😭", "😡"};
    private static final String[] REMERCIEMENTS = {"amen", "akpe", "Merci", "nagode", "imela", "thanks", "thank you", "alhamdulillah", "shukran"};

    public static void main(String[] args) throws IOException {

        System.out.println("Entrez le nom de l'utilisateur:");
        Scanner Userscan = new Scanner(System.in);
        String userName = Userscan.nextLine();

        // Initialise les compteurs
        int total = 0;
        int lol = 0;
        int lmao = 0;
        int emojiEnvoye = 0;
        int injures = 0;
        int emojiRecu = 0;
        int emojiColere = 0;
        int remerciement = 0;

        // Lit le fichier d'historique de WhatsApp
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\A2KA\\Downloads\\dislaurine.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            // Si la ligne contient le nom de l'utilisateur, cela signifie qu'elle contient un message envoyé par cet utilisateur
            if (line.contains(userName)) {
                total++;
                if (line.contains("lol")) {
                    lol++;
                }
                if (line.contains("lmao")) {
                    lmao++;
                }
                for (String emoji : EMOJIS) {
                    if (line.contains(emoji)) {
                        emojiEnvoye++;
                    }
                }
                for (String badWord : INJURES) {
                    if (line.contains(badWord)) {
                        injures++;
                    }
                }
                for (String thankWord : REMERCIEMENTS) {
                    if (line.contains(thankWord)) {
                        remerciement++;
                    }
                }
            } else {
                // Si la ligne ne contient pas le nom de l'utilisateur, cela signifie qu'elle contient un message reçu par l'utilisateur
                for (String emoji : EMOJIS) {
                    if (line.contains(emoji)) {
                        emojiRecu++;
                    }
                }
                if (line.contains("😡")) {
                    emojiColere++;
                }
            }
        }
        reader.close();

        // Affiche les résultats
        System.out.println("Au total "+userName+" a envoye "+ total+" messages" );
        System.out.println("Au total "+userName+" a envoye lol " + lol+" fois");
        System.out.println("Au total "+userName+" a envoye lmao " + lmao+" fois");
        System.out.println("Au total "+userName+" a envoye "+ emojiEnvoye+ " emojis" );
        System.out.println("Au total "+userName+" a envoye " + injures+ " injures");
        System.out.println("Au total "+userName+" a recu " + emojiRecu+ " emojis");
        System.out.println("Au total "+userName+" a recu "+ emojiColere+ " fois l'emoji en colere" );
        System.out.println("Au total "+userName+" a envoye et recu "+ remerciement+ " mots de remerciements" );
    }
}
