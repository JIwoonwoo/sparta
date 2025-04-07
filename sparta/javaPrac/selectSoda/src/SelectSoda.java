import java.util.HashMap;
import java.util.Scanner;

public class SelectSoda {
    
    //미리 정의해 놓은 메뉴 리스트
    public void menuList(){
        System.out.println("---- 메뉴판----");
        System.out.println("사이다 : 1,700원");
        System.out.println("콜라 : 1,900원");
        System.out.println("식혜 : 2,500원");
        System.out.println("솔의눈 : 3,000원");
    }
    public static void main(String[] args) throws Exception {
        
        SelectSoda selectSoda = new SelectSoda();
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> sodaList = new HashMap<>();
          
        //HashMap 이용하여 각각의 정보 입력
        sodaList.put("사이다",1700);
        sodaList.put("콜라",1900);
        sodaList.put("식혜",2500);
        sodaList.put("솔의눈",3000);        



        //자주 사용 할 변수
        int sodaVal;
        int inputMoney;
        String sodaName;

        //음료 고르는 영역
        while (true) {
    
            selectSoda.menuList();
            System.out.println("\n음료를 골라주세요."); 
            
            sodaName = scanner.nextLine();

            if(sodaList.containsKey(sodaName) == false){
                selectSoda.menuList();
                System.out.println("\n해당 음료는 존재하지 않습니다.");
                continue;           
            }
            sodaVal = sodaList.get(sodaName);
            break;
        }

        System.out.println("\n돈을 넣어주세요.");

        //금액 확인 영역
        while(true){
            inputMoney = scanner.nextInt();
            System.out.println();

            if(inputMoney < sodaVal){
                System.out.println("금액이 부족합니다. 다시 넣어주세요.");
                continue;
            }else if(inputMoney == sodaVal){
                System.out.println("주문하신 " + sodaName + " 나왔습니다.");
                break;
            }else{
                System.out.println("주문하신 " + sodaName + " 나왔습니다.");
                System.out.println("잔액이 " + (inputMoney-sodaVal) + "원 남았습니다.");
                break;
            }
        }
        scanner.close();        
            
    }

}
