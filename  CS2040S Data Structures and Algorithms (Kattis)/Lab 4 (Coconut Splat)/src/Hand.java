class Hand {
    private final int player;

    /*
    type 0: folded
    type 1: fist
    type 2: palm
     */
    private final int type;

    Hand(int player, int type) {
        this.player = player;
        this.type = type;
    }

    int getPlayer() {
        return this.player;
    }

    int getType() {
        return this.type;
    }

    //String representation of Hand, for debugging purpose
    @Override
    public String toString() {
        return "player: " + this.player + " Type: " + this.type;
    }
}
