import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) {
        FastIO fastScanner = new FastIO();
        int numOfCards = fastScanner.nextInt();
        int numTypeOfCards = fastScanner.nextInt();
        int combosRequired = fastScanner.nextInt();
        ArrayList<Integer> deck = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> prices = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Integer> quantity = new HashMap<>();

        //Fill up values for deck, which are the current cards player has.
        /*Fill up values for hashmap, where type of card is the key and quantity of that particular card
          that appears in the player's deck*/
        for (int i = 0; i < numOfCards; i++) {
            int type = fastScanner.nextInt();
            deck.add(i, type);
            if (!quantity.containsKey(type)) {
                quantity.put(type, 1);
            } else {
                quantity.replace(type, quantity.get(type) + 1);
            }
        }

        //Create a 2D arraylist to store buy and sell prices for each type of card
        for(int j = 0; j < numTypeOfCards; j++) {
            int buyPrice = fastScanner.nextInt();
            int sellPrice = fastScanner.nextInt();
            ArrayList<Integer> indPrices = new ArrayList<>();
            indPrices.add(buyPrice);
            indPrices.add(sellPrice);
            prices.add(indPrices);
        }

        //Sell all cards to get maximum earned from sales
        long moneyEarned = 0;
        long finalProfit = 0;
        for(int a = 0; a < numOfCards; a++) {
            int currCard = deck.get(a);
            long priceSold = (prices.get(currCard - 1).get(1));
            moneyEarned += priceSold;
        }

        /*Update the true total cost of each card in price list, by including the total opp cost of selling
          cards away(refund price)*/
        for(int b = 0; b < numTypeOfCards; b++) {
            if(quantity.containsKey(b + 1)) {
                int quantityOfCard = quantity.get(b + 1);
                int totalBuyCost;
                if(quantityOfCard >= 2) {
                    totalBuyCost = 2 * prices.get(b).get(1);
                }else {
                    totalBuyCost = prices.get(b).get(0) + prices.get(b).get(1);
                }
                prices.get(b).set(0, totalBuyCost);
            }else {
                int totalBuyCost = prices.get(b).get(0) * 2;
                prices.get(b).set(0, totalBuyCost);
            }
        }

        //Sort the prices of cards in ascending order according to total true cost of buying the card
        Collections.sort(prices, (x, y) -> x.get(0) - y.get(0));

        //Choose the first K cards to form the K combos
        //Calculate the net profit and print it out
        long moneySpent = 0;
        for(int m = 0; m < combosRequired; m++) {
            long cheapestBuy = prices.get(m).get(0);
            moneySpent += cheapestBuy;
        }
        finalProfit = moneyEarned - moneySpent;
        //Total run time = O(n) + O(n) + O(n) + O(n) + O(nlogn) + O(k)
        System.out.println(finalProfit);
    }
}