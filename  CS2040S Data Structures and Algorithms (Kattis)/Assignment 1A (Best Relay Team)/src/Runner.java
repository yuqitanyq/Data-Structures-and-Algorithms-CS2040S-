class Runner {
    private final String name;
    private final double firstTiming;
    private final double secondTiming;

    Runner(String name, double firstTiming, double secondTiming) {
        this.name = name;
        this.firstTiming = firstTiming;
        this.secondTiming = secondTiming;
    }

    String getName() {
        return this.name;
    }

    double getFirstTiming() {
        return this.firstTiming;
    }

    double getSecondTiming() {
        return this.secondTiming;
    }

    /*Returns String representation of the name of the runner,
    for debugging purposes*/
    @Override
    public String toString() {
        return "name: " + this.name;
    }
}
