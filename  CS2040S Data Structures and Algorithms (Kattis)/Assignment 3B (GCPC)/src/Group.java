public class Group {
    //Each group has a score and team number.
    //Score represented in an array.
    //Index 0 is number of questions solved.
    //Index 1 is total penalty incurred.
    public int[] score;
    public int teamNum;

    //Constructor
    Group(int teamNum) {
        this.teamNum = teamNum;
        this.score = new int[2];
    }

    //Modifies the score of the team based on event.
    public Group modifyScore(int penalty) {
        this.score[0] = this.score[0] + 1;
        this.score[1] = this.score[1] + penalty;
        return this;
    }

    //Gets the total number of questions solved.
    public int totalSolved() {
        return this.score[0];
    }

    //Gets the total penalty incurred.
    public int totalPenalty() {
        return this.score[1];
    }
}
