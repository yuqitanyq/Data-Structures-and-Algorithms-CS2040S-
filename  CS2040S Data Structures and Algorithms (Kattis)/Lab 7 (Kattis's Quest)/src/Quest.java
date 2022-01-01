class Quest implements Comparable<Quest> {
    private long energy;
    private long gold;
    private long id;

    //Constructor
    Quest(long energy, long gold, long id) {
        this.energy = energy;
        this.gold = gold;
        this.id = id;
    }

    long getEnergy() {
        return this.energy;
    }

    long getGold() {
        return this.gold;
    }

    long getId() {
        return this.id;
    }

    //Basis of comparison: check energy, followed by gold, followed by Id.
    @Override
    public int compareTo (Quest other) {
        if(this.energy < other.getEnergy()) {
            return -1;
        } else if(this.energy > other.getEnergy()) {
            return 1;
        } else {
            if(this.gold < other.getGold()) {
                return -1;
            } else if(this.gold > other.getGold()) {
                return 1;
            } else {
                if(this.id < other.getId()) {
                    return -1;
                } else if(this.id > other.getId()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }
}
