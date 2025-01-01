package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ComputerTest {
    Computer computer = new Computer();

    @Test
    void randomNumberCreate() {

        List<Integer> randomNumList = Stream.of(1, 2, 3)
                .sorted((o1, o2) -> o2 - o1) // comparator 활용, descending 처리
                .toList(); // new arrayList가 필요없다.

        Assertions.assertThat(randomNumList.equals(List.of(3, 2, 1))).isTrue();
    }

    @Test
    void 스트림_활용_예제_1() {
        List<Integer> randNumList = Stream.of(Randoms.pickNumberInRange(1, 9))
                .limit(3)
                .toList();

        Assertions.assertThat((long) randNumList.size()).isEqualTo(1);
    }

    @Test
    void 스트림_활용_예제_2() {
        List<Integer> randNumList = Stream.iterate(0, n -> n + 2)
                .limit(3)
                .toList();

        List<Integer> randNumList2 = Stream.iterate(Randoms.pickNumberInRange(1, 9), i -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .toList();

        Assertions.assertThat((long) randNumList2.size()).isEqualTo(3);
    }

    @Test
    void 스트림_활용_예제_3() {
        List<Integer> randNumList = Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .toList();

        Assertions.assertThat((long) randNumList.size()).isEqualTo(3);

        System.out.println(randNumList);
    }

    @Test
    void 스트림_활용_예제_4(){
        List<Integer> randInteger = Stream.generate(()->Randoms.pickNumberInRange(1,9))
                .distinct()
                .limit(3)
                .toList();

        System.out.println("randInteger = " + randInteger);

        String str = randInteger.stream()
                .map(i->Integer.toString(i))
                .collect(Collectors.joining());

        System.out.println("str = " + str);
    }

    @Test
    void 스트림_활용_예제_5() {
        List<Integer> randNumList = Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .toList();

        System.out.println("randNumList = " + randNumList); // 리스트 변환

        String str = Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                .distinct()
                .limit(3)
                .map(String::valueOf)
                .collect(Collectors.joining());

        StringBuilder stringBuilder = new StringBuilder(3).append(
                Stream.generate(() -> Randoms.pickNumberInRange(1, 9))
                        .distinct()
                        .limit(3)
                        .map(String::valueOf)
                        .collect(Collectors.joining()));


        System.out.println("str = " + str);
        System.out.println();
        System.out.println("strBuilder = " + stringBuilder);


    }
}