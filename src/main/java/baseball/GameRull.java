package baseball;

public class GameRull {

    Computer computer;
    Player player;
    Referee referee;

    GameRull() {
        this.computer = new Computer();
        this.player = new Player();
        this.referee = new Referee();
    }

    public void GameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String computerCreateRandNum = startMent();
        while (true) {
            if (inputData(computerCreateRandNum)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = player.input();
        if (input.equals("1")) GameStart();
        if (input.equals("2")) return;
    }

    public String startMent() {
        return computer.randomNumberCreate();
    }

    public boolean inputData(String computerCreateRandNum) {
        System.out.println(computerCreateRandNum);
        System.out.print("숫자를 입력해주세요 : ");
        String answer = player.input();
        return referee.checkInput(computerCreateRandNum, answer);
    }
}
