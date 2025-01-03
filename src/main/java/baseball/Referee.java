package baseball;

public class Referee {
    private final int MAX_USER_INPUT_NUMBER = 3;
    private final int GAME_OUT_STRIKE_NUMBER = 3;

    private BallScore ballScore;

    public boolean checkInput(String computerCreateRandNum, String playerInput) {
        if (playerInput.length() != MAX_USER_INPUT_NUMBER || !isNumeric(playerInput)) {
            throw new IllegalArgumentException("에러가 발생하였습니다.");
        }
        callReferee(computerCreateRandNum, playerInput);

        System.out.println(ballScore.callBallScore());

        return ballScore.getStrikeCount() == GAME_OUT_STRIKE_NUMBER;
    }

    private boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    private void callReferee(String computerCreateRandNum, String playerInput) {
        ballScore = BallScore.ofStart(0, 0);

        for (int i = 0; i < computerCreateRandNum.length(); i++) {
            String currentCheck = String.valueOf(computerCreateRandNum.charAt(i));
            if (currentCheck.equals(String.valueOf(playerInput.charAt(i)))) {
                ballScore.setAddStrike(); // 스트라이크 증가
            } else if (playerInput.contains(currentCheck)) {
                ballScore.setAddBall(); // 볼 증가
            }
        }
    }
}
