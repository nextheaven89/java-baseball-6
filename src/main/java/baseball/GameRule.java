package baseball;

public class GameRule {

    private final Computer computer;
    private final Player player;
    private final Referee referee;

    public GameRule() {
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
        switch (player.input()) {
            case "1":
                GameStart();
                break;
            case "2":
                return;
            default:
                throw new Error("잘못된 값을 입력하셨습니다.");
        }
    }

    public String startMent() {
        return computer.randomNumberCreate();
    }

    public boolean inputData(String computerCreateRandNum) {
        System.out.print("숫자를 입력해주세요 : ");
        return referee.checkInput(computerCreateRandNum, player.input());
    }
}
