package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameRule {

    private final Computer computer;
    private final Player player;
    private final Referee referee;

    public GameRule() {
        this.computer = new Computer();
        this.player = new Player();
        this.referee = new Referee();
    }

    public void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame(getComputerRandNum());
        retryGameSelectAndShowWinCount();
    }

    public void playGame(String computerCreateRandNum) {
        while (true) {
            if (inputUserNumber(computerCreateRandNum)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                player.addWinCount();
                break;
            }
        }
    }

    public void retryGameSelectAndShowWinCount() {
        player.showWinCountAndClearInputData();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        switch (Console.readLine()) {
            case "1":
                gameStart();
                break;
            case "2":
                return;
            default:
                throw new Error("잘못된 값을 입력하셨습니다.");
        }
    }

    public String getComputerRandNum() {
        return computer.randomNumberCreate();
    }

    public boolean inputUserNumber(String computerCreateRandNum) {
        player.showTryList();
        return referee.checkInput(computerCreateRandNum, player.inputUserNumber());
    }
}
