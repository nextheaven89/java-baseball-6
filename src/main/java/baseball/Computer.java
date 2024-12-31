package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public Computer() {
    }

    public String randomNumberCreate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        StringBuilder stringBuilder = new StringBuilder(3);
        for (Integer i : computer) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }
}
