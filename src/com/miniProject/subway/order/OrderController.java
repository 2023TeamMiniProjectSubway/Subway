package com.miniProject.subway.order;

import com.miniProject.subway.menu.MenuDTO;
import com.miniProject.subway.view.OrderMain;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;


public class OrderController {


    ArrayList<MenuDTO> menuDTO= new ArrayList<>();

    /** 장바구니에 담을 상품명 배열 */
    private ArrayList ordermenu = new ArrayList();

    /** 장바구니에 담을 상품금액 배열 */
    private ArrayList orderprice = new ArrayList();





    Scanner sc = new Scanner(System.in);

    public OrderController () {
        menuDTO.add(new MenuDTO("에그마요", 2000,"부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러"));
        menuDTO.add(new MenuDTO("이탈리안 비엠티", 2000,"페퍼로니, 살라미 그리고 햄이 만들어내는 전세계가 사랑하는 베스트셀러"));
        menuDTO.add(new MenuDTO("비엘티", 2000,"오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~"));
        menuDTO.add(new MenuDTO("햄", 2000,"풍부한 햄이 만들어내는 담백함을 입 안 가득 즐겨보세요!"));
        menuDTO.add(new MenuDTO("참치", 2000,"남녀노소 누구나 좋아하는 담백한 참치와 고소한 마요네즈의 완벽한 조화"));
        //0~4
        //-----------------------------------------------------------------------------------------------------------------------
        menuDTO.add(new MenuDTO("치킨 슬라이스", 2000, "닭가슴살로 만든 치킨 슬라이스로 즐기는 담백한 맛!"));
        menuDTO.add(new MenuDTO("치킨 베이컨 아보카도", 2000, "담백하게 닭가슴살로 만든 치킨 슬라이스와 베이컨, 부드러운 아보카도의 만남"));
        menuDTO.add(new MenuDTO("로스트 치킨", 2000, "오븐에 구워 담백한 저칼로리 닭가슴살의 건강한 풍미"));
        menuDTO.add(new MenuDTO("로티세리 바비큐 치킨", 2000, "촉촉한 바비큐 치킨의 풍미가득, 손으로 찢어 더욱 부드러운 치킨의 혁명"));
        menuDTO.add(new MenuDTO("써브웨이 클럽", 2000, "고소한 베이컨, 담백한 치킨 슬라이스에 햄까지 더해 완벽해진 조화를 즐겨보세요!"));
        menuDTO.add(new MenuDTO("베지", 2000, "갓 구운 빵과 신선한 8가지 야채로 즐기는 깔끔한 한끼"));
        //5~10
        //-------------------------------------------------------------------------------------------------------------------------
        menuDTO.add(new MenuDTO("스파이시 쉬림프", 2000,"탱글한 쉬림프에 이국적인 시즈닝을 더해 색다른 매콤함을 만나보세요!"));
        menuDTO.add(new MenuDTO("쉬림프", 2000,"탱글한 쉬림프 5마리가 그대로, 신선하고 담백한 쉬림프의 맛 그대로 즐겨보세요!"));
        menuDTO.add(new MenuDTO("K-바비큐", 2000,"써브웨이의 코리안 스타일 샌드위치! 마늘, 간장 그리고 은은한 불맛까지!"));
        menuDTO.add(new MenuDTO("풀드 포크 바비큐", 2000,"미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치"));
        menuDTO.add(new MenuDTO("스테이크 & 치즈", 2000,"육즙이 쫙~풍부한 비프 스테이크의 풍미가 입안 한가득"));
        menuDTO.add(new MenuDTO("스파이시 이탈리안", 2000,"페퍼로니 & 살라미가 입안 가득, 페퍼로니의 부드러운 매콤함을 만나보세요!"));
        menuDTO.add(new MenuDTO("치킨 데리야끼", 2000,"담백한 치킨 스트립에 달콤짭쪼름한 써브웨이 특제 데리야끼 소스와의 환상적인 만남"));
        //11~17
        //------------------------------------------------------------------------------------------------------------------------
        menuDTO.add(new MenuDTO("랍스터", 2000,"신선한 랍스터 통살이 고소한 마요네즈와 만나 풍미가 가득, 입안 가득 신선한 랍스터 샌드위치"));
        //18

//        for(int i = 0; i < menuDTO.size(); i++){
//
//            System.out.println(menuDTO.get(i).menuInformation());
//        }

    }

    public void showMenuDetail(int choice){
        showdetail :
        while(true){
            System.out.println("======================================");
            System.out.println("        ▷ 메뉴 상세 정보          ");
            System.out.println("   ▷" + menuDTO.get(choice).getMenuname() + "◁   ");
            System.out.println("   ▷" + menuDTO.get(choice).getPrice() + "원◁   ");
            System.out.println("   ▷" + menuDTO.get(choice).getDescription() + "◁   ");

            System.out.println("======================================");
            System.out.println("      ▷ 메뉴를 장바구니에 넣으시겠습니까?    ");
            System.out.println("      ▷ 1. 예                          ");
            System.out.println("      ▷ 2. 아니오                       ");
            System.out.println("      ▶ 0. 이전 메뉴로                   ");
            System.out.println("======================================");

            int menuCheck = sc.nextInt();

            switch(menuCheck)
            {
                case 1 :                            // 메뉴를 장바구니에 넣기
                    orderMenu(choice);
                    break showdetail;
                case 2 :                            // 다시 메뉴 디테일 보여주기
                    break;
                case 0 :                            // 돌아가기
                    break ;
                default :
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
                    break;
            }
        }
    }

    public void orderMenu(int choice){

//        setMenuDTO();

//        for(int i = 0; i < menuDTO.size(); i++){
//            System.out.println(i + "번째 메뉴 : " + menuDTO.get(i).menuInformation())
//            ;
//        }
       // System.out.println(choice + "번째 메뉴 가격 : " + menuDTO.get(choice).getPrice() + "원");


        ordermenu.add(menuDTO.get(choice).getMenuname());       //선택한 값을 인덱스로 갖는 메뉴이름을 가져와서 ordermenu 에 넣음
//        orderprice.add(menuDTO.get(choice).getPrice());       //이것만 넣으면 IndexOutOfError가 뜸


//        for(int i = 0; i < ordermenu.size(); i++)
//        {
//            System.out.println(ordermenu.get(i) /*+ " : " + orderprice.get(i) + "원"*/);
//        }
        //-----------------------------------------------

//        orderprice.add(0,0);
        orderprice.add(menuDTO.get(choice).getPrice());          //* 1부터 차례대로 누르지않으면 IndexOfError가 뜸 왜??

//        System.out.println(orderprice.get(0));      //이렇게하면 잘뜸 -> choice만 넣으면 Index Out Of Bounds Exception발생


        int sum = 0;
        for(int i = 0; i < orderprice.size(); i++)
        {
            sum = (int)orderprice.get(i) + sum;
        }

        System.out.print("현재 고른 메뉴 : ");
        for(int i = 0; i < ordermenu.size(); i++)
        {
            System.out.print(ordermenu.get(i) + ", ");
        }
        System.out.println();
        System.out.println("현재 총 가격 : " + sum);
        //-----------------------------------------------

    }

    public void basket() {  // 주문한 메뉴들을 전부 담아주는 장바구니 메소드
//        System.out.println("테스트 메뉴 이름 " + ordermenu.toString());
        priceBasket();
        menuBasket();

    }

    public void lastBasket() {

        OrderMain orderMain = new OrderMain();

        System.out.println("======================================");
        System.out.println("      ▷ 결제 도와드리겠습니다.            ");
        System.out.println("      ▷ 1. 현금 결제                    ");
        System.out.println("      ▷ 2. 카드 결제                     ");
        System.out.println("      ▶ 0. 이전 메뉴로                   ");
        System.out.println("======================================");

        int pick = sc.nextInt();
        switch (pick) {
            case 1:
                moneyPayment();
                break;
            case 2:
                cardPayment();
                break;
            case 0:
                orderMain.orderContinue();
                break;
            default:
                System.out.println("선택할 수 없습니다. 다시 선택해주세요.");

        }

    }



    public int priceBasket() {
        int totPrc = 0;

        for (int i = 0; i < orderprice.size(); i++) {
            totPrc += (int) orderprice.get(i);
        }
        System.out.println("테스트 전체 가격 : " + totPrc);
        return totPrc;
    }

    public void menuBasket(){
        System.out.println("테스트 메뉴 이름 " + ordermenu.toString());
    }



    public void cardPayment() { // 카드 결제를 위한 메소드

        OrderMain orderMain = new OrderMain();
        System.out.println("============카드 결제 입니다============");
        System.out.println("      [주문 내역을 확인 해주세요]");
        basket();
        System.out.println("=====================================");
        System.out.println();
        System.out.println("1. 결제하기                   2. 취소하기");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("결제가 완료되었습니다.");
        } else {
            System.out.println("이전 페이지로 되돌아갑니다.");
            orderMain.orderContinue();
        }
        // void는 return을 안해도 된다...
    }

    public void moneyPayment () {   // 현금 결제를 위한 메소드

        OrderMain orderMain = new OrderMain();
        System.out.println("============현금 결제 입니다============");
        System.out.println("           [주문 내역을 확인 해주세요]");
        basket();
        System.out.println("=====================================");
        System.out.println();
        System.out.println("1. 결제하기                  2. 취소하기");

        Scanner sc = new Scanner(System.in);
        int cash = sc.nextInt();


        if(cash == 1) {
            System.out.println("지불할 금액을 입력해주세요.");
            sc.nextLine();
            int payCash = sc.nextInt();         // 지불할 금액 입력
            if (payCash < priceBasket()) {
                System.out.println("금액이 부족합니다. 지불하신 금액을 확인해주세요");
                orderMain.orderContinue();
            } else if (payCash == priceBasket()) {
                System.out.println("계산이 완료되었습니다. 감사합니다.");
            } else {
                System.out.println("=====================================");
                System.out.println("남은 잔돈은 : " + ( payCash - priceBasket() ) + " 입니다.");
                System.out.println("주문이 완료되었습니다. 감사합니다 ^_^ ");
                System.out.println("=====================================");

            }
        } else {
            System.out.println("이전 페이지로 되돌아갑니다.");
            orderMain.orderContinue();
        }

    }

    public void addPonint () {  // 포인트 적립을 위한 메소드

    }

    public void usePoint() {    // 포인트 사용을 위한 메소드

    }

}
