class Card {
    private final int type;
    private final long buyPrice;
    private final long sellPrice;

    Card(int type, long buyPrice, long sellPrice) {
        this.type = type;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    //Get the type of card
    int getType() {
        return this.type;
    }

    //Get the buy price of card
    long getBuyPrice() {
        return this.buyPrice;
    }

    //Get the sell price of card
    long getSellPrice() {
        return this.sellPrice;
    }
    
    /*Returns String representation of the Card,
      for debugging purposes*/
    @Override
    public String toString() {
        return "Card: " + this.type + " Buy: "
            + this.buyPrice + " Sell: " + this.sellPrice;
    }

}
