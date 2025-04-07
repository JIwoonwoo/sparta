import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class RandomQuiz {
    public static void main(String[] args) throws Exception {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Set<Character> wordSet = new HashSet<>();

        // 미리 선택한 50개의 단어
        String[] randomWords = {
                "apple", "banana", "cherry", "grape", "orange", "peach", "melon", "lemon", "plum", "berry",
                "ocean", "river", "cloud", "storm", "breeze", "thunder", "shadow", "glow", "flame", "stone",
                "happy", "lucky", "smile", "brave", "honest", "gentle", "bright", "silent", "kind", "sweet",
                "table", "chair", "pencil", "window", "garden", "mirror", "candle", "pocket", "button", "ladder",
                "circle", "square", "silver", "golden", "purple", "velvet", "cotton", "crystal", "forest", "sunset"
        };

        // 50개의 단어중 랜덤 단어 선택
        int rdNum = random.nextInt(50);
        char[] seletedWord = randomWords[rdNum].toCharArray();
        int wordCount = seletedWord.length;
        char[] checkedWord = new char[wordCount];

        for (int i = 0; i < wordCount; i++) {
            checkedWord[i] = '_';
        }

        System.out.println("이번 단어는 " + wordCount + "자리 단어입니다.\n");

        int count = 0;
        String inputWord;
        char myalphabet;
        int winJudge = 0;

        while (count < 9) {
            System.out.println("알파벳 A-Z 까지중에 하나를 입력해 주세요.");
            System.out.print("입력 ::: ");

            // 입력값 받은 후 소문자로 변환
            inputWord = scanner.nextLine().toLowerCase();

            // 입력값 오류 체크 (한 글자인지, 영어인지 확인)
            if (inputWord.length() != 1 || !inputWord.matches("[a-z]")) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
                continue;
            }

            myalphabet = inputWord.charAt(0);

            // 중복 체크
            if (wordSet.add(myalphabet) == false) {
                System.out.println("이미 입력된 글자입니다. 다시 입력해 주세요.");
                continue;
            }

            // 단어 판별
            for (int i = 0; i < wordCount; i++) {

                if (wordSet.contains(checkedWord[i]) == true && checkedWord[i] != '_') {
                    continue;
                }

                if (myalphabet == seletedWord[i]) {
                    checkedWord[i] = seletedWord[i];
                }

                if (checkedWord[i] != '_') {
                    winJudge++;
                }
            }

            count++;
            System.out.println("\n입력된 글자 :: " + wordSet);
            System.out.print("정답 현황 :: ");
            System.out.println(checkedWord);

            System.out.println("\n도전 횟수 : " + count+"\n");


            if (winJudge == wordCount) {
                System.out.println("정답입니다.");
                break;
            }
        }
        scanner.close();
        if (winJudge != wordCount) {
            System.out.println("정답은 '" + randomWords[rdNum] + "' 입니다.");
            System.out.println("다음기회에...\n");
        }
    }
}
