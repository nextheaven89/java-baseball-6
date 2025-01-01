package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Computer {

    public String randomNumberCreate() {

        return Stream.generate(() -> Randoms.pickNumberInRange(1, 9)) // 9개의 랜덤 숫자를 배분한다
                .distinct()// 중복을 제거 해준다
                .limit(3)//3개까지만 생성해준다
                .map(i -> Integer.toString(i)) // Integer -> String 변환
                .collect(Collectors.joining()); // 값을 붙여준다. -> 최종
    }
}
