package baseball;

public class Referee {
    private final int MAX_USER_INPUT_NUMBER = 3;

    private int ball;
    private int strike;

    private void initReferee() {
        this.ball = 0;
        this.strike = 0;
    }

    public boolean checkInput(String computerCreateRandNum, String playerInput) {
        if (playerInput.length() != MAX_USER_INPUT_NUMBER || !isNumeric(playerInput)) {
            throw new IllegalArgumentException("에러가 발생하였습니다.");
        }
        callReferee(computerCreateRandNum, playerInput);
        System.out.println(shoutReferee());
        return this.strike == 3;
    }

    private boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    private void callReferee(String computerCreateRandNum, String playerInput) {
        initReferee();

        for (int i = 0; i < computerCreateRandNum.length(); i++) {
            String currentCheck = String.valueOf(computerCreateRandNum.charAt(i));
            if (currentCheck.equals(String.valueOf(playerInput.charAt(i)))) {
                strike++; // 스트라이크 증가
            } else if (playerInput.contains(currentCheck)) {
                ball++; // 볼 증가
            }
        }
    }

    private String shoutReferee() {
        if (strike == 0 && ball == 0) return "낫싱";
        else if (ball > 0 && strike == 0) return ball + "볼";
        else if (ball == 0 && strike > 0) return strike + "스트라이크";
        else return ball + "볼 " + strike + "스트라이크";
    }
}
