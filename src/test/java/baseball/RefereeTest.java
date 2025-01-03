package baseball;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RefereeTest {

    public final String computerStr ="123";
    public final String playerStr ="321";
    public List<String> checkList = new ArrayList<>();
    public int strike;
    public int ball;

    @Test
    void 검사_로직_개선(){
        //3볼이 나와야함
        for(int i=0; i<computerStr.length(); i++){
            if(computerStr.charAt(i)==playerStr.charAt(i)) {
                strike++;
                System.out.println("strike = " + strike);
                checkList.add(String.valueOf(computerStr.charAt(i)));
                for (int j = 0; j < playerStr.length(); j++) {
                   if (playerStr.charAt(j) == computerStr.charAt(i) || checkList.contains(computerStr.charAt(i))) {
                       ball++;
                       System.out.println("ball = " + ball);
                   }
                }
            }
        }
        System.out.println("strike = " + strike);
        System.out.println("ball = " + ball);
    }

    @Test
    public void GPT_방법(){

        Set<Character> playerSet = new HashSet<>();
        for (int i = 0; i < playerStr.length(); i++) {
            playerSet.add(playerStr.charAt(i)); // playerInput의 문자들을 Set에 추가
        }

        for (int i = 0; i < computerStr.length(); i++) {
            char currentChar = computerStr.charAt(i);
            if (currentChar == playerStr.charAt(i)) {
                strike++; // 스트라이크 증가
            } else if (playerSet.contains(currentChar)) {
                ball++; // 볼 증가
            }
        }

        System.out.println("strike = " + strike);
        System.out.println("ball = " + ball);
    }

    @Test
    public void GPT_개선(){

        for (int i = 0; i < computerStr.length(); i++) {
            String currentCheck = String.valueOf(computerStr.charAt(i));
            if (currentCheck.equals(String.valueOf(playerStr.charAt(i)))){
                strike++; // 스트라이크 증가
            } else if (playerStr.contains(currentCheck)) {
                ball++; // 볼 증가
            }
        }

        System.out.println("strike = " + strike);
        System.out.println("ball = " + ball);
    }

}