package baseball;

import java.util.ArrayList;
import java.util.List;

public class Referee {
    private List<String> listCall;
    private int ball;
    private int strike;

    public Referee() {
        this.ball = 0;
        this.strike = 0;
    }

    public boolean checkInput(String computerCreateRandNum, String playerInput) {
        if (playerInput.length() != 3 || !isNumeric(playerInput)) {
            throw new IllegalArgumentException("에러가 발생하였습니다.");
        }

        callReferee(computerCreateRandNum, playerInput);
        shoutReferee();

        return this.strike == 3;
    }

    private boolean isNumeric(String strNum) {
        return strNum.matches("-?\\d+(\\.\\d+)?");
    }

    private void initReferee() {
        this.listCall = new ArrayList<>();
        this.ball = 0;
        this.strike = 0;
    }

    private void callReferee(String computerCreateRandNum, String playerInput) {
        initReferee();

        // 스트라이크 검사
        for (int i = 0; i < computerCreateRandNum.length(); i++) {
            if (computerCreateRandNum.charAt(i) == playerInput.charAt(i)) {
                strike++; // 스트라이크 증가
                listCall.add(computerCreateRandNum.substring(i, i + 1)); // 스트라이크 문구 저장
            }
        }
        for (int i = 0; i < computerCreateRandNum.length(); i++) {
            if (!listCall.contains(computerCreateRandNum.substring(i, i + 1))) {
                for (int j = 0; j < playerInput.length(); j++) {
                    if (computerCreateRandNum.charAt(i) == playerInput.charAt(j)) {
                        ball++;
                    }
                }
            }
        }
    }

    private void shoutReferee() {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        } else if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0 && strike > 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
