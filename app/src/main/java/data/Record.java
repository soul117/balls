package data;

public class Record {
    private String nickname;
    private int score;
    //record initialization nickname and score
    public Record() {
        this("Player", 0);
    }
    //setNickname and setScore initialization
    public Record(String nickname, int score) {
        //setNickname referred to nickname
        this.setNickname(nickname);
        //setScore referred to score
        this.setScore(score);
    }

    //Nickname getter
    public String getNickname() {
        return nickname;
    }
    //Nickname setter
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    //Score getter
    public int getScore() {
        return score;
    }
    //Score setter
    public void setScore(int score) {
        this.score = score;
    }
}
