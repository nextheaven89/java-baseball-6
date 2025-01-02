
/// 2025-01-02
/// 추가할 기능?
/// 1. 시도했던 숫자 리스트
/// 2. 성공 했었던 횟수 출력

package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Player {

    private final List<String> tryInput = new ArrayList<>();
    private Integer WinCount = 0;

    public String inputUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        tryInput.add(input);
        return input;
    }

    public void showTryList() {
        IntStream.range(0, tryInput.size()).forEach(index -> {
            String userInputHistory = tryInput.get(index);
            System.out.println("입력 횟수 " + (index+1) + ": " + userInputHistory);
        });
    }

    public void showWinCountAndClearInputData() {
        tryInput.clear();
        System.out.println("승리 횟수 : " + WinCount);
    }

    public void addWinCount() {
        this.WinCount++;
    }
}
