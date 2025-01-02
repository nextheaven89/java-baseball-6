package baseball;

public class BallScore {
    private int ball;
    private int strike;

    private BallScore(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static BallScore ofStart(int ball, int strike) {
        return new BallScore(ball, strike);
    }

    public String callBallScore() {
        if (strike == 0 && ball == 0) return "낫싱";
        else if (ball > 0 && strike == 0) return ball + "볼";
        else if (ball == 0 && strike > 0) return strike + "스트라이크";
        else return ball + "볼 " + strike + "스트라이크";
    }

    public int getStrikeCount() {
        return this.strike;
    }

    public void setAddBall() {
        this.ball++;
    }

    public void setAddStrike() {
        this.strike++;
    }
}
