package blackjack;

import java.security.SecureRandom;
import java.util.LinkedList;

public final class BJ21 {
    private final static LinkedList<Integer> deck = new LinkedList<>();
    private final static LinkedList<Integer> handCrupier = new LinkedList<>();
    private final static LinkedList<Integer> handPlayer = new LinkedList<>();
    private final static SecureRandom randCards = new SecureRandom();

    public static LinkedList<Integer> getHandPlayer() {
        return handPlayer;
    }

    public static LinkedList<Integer> getHandCrupier() {
        return handCrupier;
    }

    private BJ21() {}

    public static double b21(double bet) {
        if(BlackjackGUI.frame != null)
            BlackjackGUI.frame.dispose();

        BlackjackGUI.startGUI();

        restartDecks();
        initialHand();

        boolean continueGame = true;

        while (continueGame) {
            BlackjackGUI.updateView(handCrupier, handPlayer);
            continueGame = playerTurn();
            continueGame = (crupierTurn() || continueGame);
        }

        double winnings = decideVictory(bet);

        return BlackjackGUI.displayResultAndGetNewBet(listSum(handPlayer), listSum(handCrupier), winnings);
    }
    private static boolean playerTurn() {
        if (BlackjackGUI.getPlayerChoice()){
            handPlayer.add(getRandomCard());
            return true;
        }

        return false;
    }

    private static double decideVictory(double bet) {
        BlackjackGUI.revealAllCards(handCrupier, handPlayer);

        String resultMessage;
        double result;
        if (listSum(handPlayer) == listSum(handCrupier)) {
            resultMessage = "Empate";
            result = bet;
        } else if (listSum(handPlayer) < 22 && listSum(handCrupier) > 21) {
            resultMessage = "Victoria";
            result = bet * 2;
        } else if (listSum(handPlayer) > 21 && listSum(handCrupier) < 22) {
            resultMessage = "Perdiste";
            result = 0;
        } else if (listSum(handPlayer) > 21 && listSum(handCrupier) > 21) {
            if (Math.min(listSum(handCrupier), listSum(handPlayer)) == listSum(handPlayer)) {
                resultMessage = "Victoria";
                result = bet * 2;
            } else {
                resultMessage = "Perdiste";
                result = 0;
            }
        } else {
            if (Math.max(listSum(handCrupier), listSum(handPlayer)) == listSum(handPlayer)) {
                resultMessage = "Victoria";
                result = bet * 2;
            } else {
                resultMessage = "Perdiste";
                result = 0;
            }

        }

        return result;
    }


    private static boolean crupierTurn(){
        LinkedList<Integer> possibleCards = new LinkedList<>(deck);
        possibleCards.add(handPlayer.getFirst());

        int smallerThan22 = 0;
        int higherThan21 = 0;

        for(int i=0; i<possibleCards.size(); i++){
            if(listSum(handCrupier)+possibleCards.removeLast()>21)
                higherThan21++;
            else
                smallerThan22++;
        }

        if(smallerThan22>higherThan21)
            handCrupier.add(getRandomCard());
        else
            return false;

        return true;
    }

    private static void initialHand(){
        for(int i=0; i<2; i++){
            handCrupier.add(getRandomCard());
            handPlayer.add(getRandomCard());
        }
    }

    private static int getRandomCard(){
        return deck.remove(randCards.nextInt(deck.size()));
    }

    private static void restartDecks(){
        deck.clear();
        handCrupier.clear();
        handPlayer.clear();

        for(int i=0; i<11; i++)
            deck.add(i+1);
    }

    private static void printHands(){
        System.out.println("Crupier: "+ handCrupier.toString());
        System.out.println("Player: "+ handPlayer.toString());
    }

    private static void printPlayerView(){
        System.out.print("Crupier: [?, ");

        for(int i=1; i<handCrupier.size(); i++)
            if(handCrupier.get(i).equals(handCrupier.getLast()))
                System.out.print(handCrupier.get(i));
            else
                System.out.print(handCrupier.get(i)+", ");
        System.out.println("]");

        System.out.println("Player: "+ handPlayer.toString());
    }


    private static int listSum(LinkedList<Integer> list){
        int sum = 0;
        for(Integer i : list)
            sum += i;

        return sum;
    }

}


