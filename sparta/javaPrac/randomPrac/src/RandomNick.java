public class RandomNick {
    public static void main(String[] args) throws Exception {

        //각각의 닉네임을 배열로 생성
        String[] firstWord = {"기절초풍", "멋있는", "재미있는"};
        String[] secondWord = {"도전적인", "노란색의", "바보같은"};
        String[] thirdWord= {"돌고래", "개발자", "오랑우탄"};

        //0부터 2까지의 랜덤 정수 생성
        int randomA = (int) (Math.random() * 3);
        int randomB = (int) (Math.random() * 3);
        int randomC = (int) (Math.random() * 3);      

        //생성된 닉네임 출력
        System.out.println(firstWord[randomA] + " " + secondWord[randomB] + " " + thirdWord[randomC]);

    }
}
