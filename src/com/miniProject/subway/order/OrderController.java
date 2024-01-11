package com.miniProject.subway.order;

import com.miniProject.subway.menu.MenuDTO;
import com.miniProject.subway.view.OrderMain;
import com.miniProject.subway.view.OrderList;
import com.miniProject.subway.view.Main;
import java.util.*;

import static com.miniProject.subway.view.OrderMain.*;


public class OrderController {

    ArrayList<MenuDTO> menuDTO= new ArrayList<>();
    ArrayList ordermenu = new ArrayList();
    ArrayList orderprice = new ArrayList();
    ArrayList choosebread = new ArrayList();



    ArrayList<Set> minusVegetable = new ArrayList<>();
    ArrayList<Set> addTopping = new ArrayList<>();



    public static int orderMenuNum = 0;



    String [] breadlist = new String[]{"화이트", "하티", "파마산오레가노", "위트", "허니오트", "플랫브레드"};
    String [] vegetable = new String[]{"양상추", "토마토", "오이", "피망", "양파", "피클", "올리브", "할라피뇨", "아보카도"};
    String [] topping = new String []{"미트 추가", "에그마요", "베이컨", "치즈 추가", "아보카도", "오믈렛", "페퍼로니"};


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
        while(true) {
            System.out.println("=================================================================================");
            System.out.println(" ▷ 메뉴 상세 정보          ");
            System.out.println(" ▷ " + menuDTO.get(choice).getMenuname() + " ◁   ");
            System.out.println(" ▷ " + menuDTO.get(choice).getPrice() + "원◁   ");
            System.out.println(" ▷ " + menuDTO.get(choice).getDescription() + "◁   ");

            System.out.println("=================================================================================");
            System.out.println("                            ▷ 메뉴를 장바구니에 넣으시겠습니까?                       ");
            System.out.println("                            ▷ 1. 예                                             ");
            System.out.println("                            ▷ 2. 아니오                                          ");
            System.out.println("                            ▶ 0. 이전 메뉴로                                      ");
            System.out.println("=================================================================================");

            try {
                int menuCheck = sc.nextInt();

                switch (menuCheck) {
                    case 1:
                        chooseBread();                               // 빵고르기 -> 야채뺴기 -> 토핑고르기
                        minusVegetable();
                        System.out.println(minusVegetable);
                        addTopping();
                        System.out.println(addTopping);
                        // 여유가 있으면 음료고르기까지
                        orderMenu(choice);              // 메뉴를 장바구니에 넣기
                        orderMenuNum++;
                        System.out.println("오더 넘버 : " + orderMenuNum);
                        break showdetail;
                    case 2:                            // 다시 메뉴 디테일 보여주기
                        break;
                    case 0:                            // 돌아가기
                        // 이전 메뉴로 가야하는데 왜 계속 주문하겠냐로 돌아가는가
                        showMenuAgain = true;
                        return;
                    default:
                        System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.           ");
                        break;
                }
            }catch (InputMismatchException e)
            {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.                  ");
                sc.nextLine();
            }
        }
    }

    public void orderMenu(int choice){

        System.out.println("현재 주문하신 메뉴 개수 : " + (orderMenuNum + 1));
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

        System.out.println("                            √ 현재 고른 메뉴 ");



        for(int i = 0; i < ordermenu.size(); i++)
        {
            System.out.println();
            System.out.println("                                ◇ " + ordermenu.get(i));
            System.out.println();
            System.out.println("                                  └ 🥯 빵 : " + choosebread.get(i));
//            System.out.println("뺄 야채 : " + minusVegetable.size());
            if(minusVegetable.get(i).size() == 0)
            {
                System.out.println("                                  └ 🥗 뺄 야채 : " + "없음");

            }
            else {

                System.out.println("                                  └ 🥗 뺄 야채 : " + minusVegetable.get(i));
            }
            if(addTopping.get(i).size() == 0 )
            {
                System.out.println("                                  └ 🧀 추가할 토핑 : " + "없음");
            }
            else {
                System.out.println("                                  └ 🧀 추가할 토핑 : " + addTopping.get(i));
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("                            √ 💰 현재 총 가격 : " + sum          );
        //-----------------------------------------------

    }

    public void basket() {  // 주문한 메뉴들을 전부 담아주는 장바구니 메소드
//        System.out.println("테스트 메뉴 이름 " + ordermenu.toString());
        priceBasket();
        menuBasket();

    }


    public void lastBasket() {
        while(true) {
            try {

                System.out.println("=================================================================================");
                menuBasket();
                System.out.println("                            ▷ 현재 선택하신 메뉴 총 금액 : " + priceBasket());
                System.out.println("=================================================================================");
                System.out.println("                            ▷ 💁‍♂️ 결제 도와드리겠습니다.                                ");
                System.out.println("                            ▷ 1. 현금 결제                                         ");
                System.out.println("                            ▷ 2. 카드 결제                                        ");
                System.out.println("                            ▷ 0. 이전 메뉴로                                      ");
                System.out.println("=================================================================================");


                int pick = sc.nextInt();
                System.out.println(pick);

                switch (pick) {
                    case 1:
                        moneyPayment();
                        break;
                    case 2:
                        cardPayment();
                        break;
                    case 0:
                        backMenu();
//                OrderMain orderMain = new OrderMain();      //
//                orderMain.orderContinue();

//                paycancel = true;

//                 return;

                    default:
                        System.out.println(pick);
                        System.out.println("                            ▷ 😥 선택할 수 없습니다. 다시 선택해주세요.");

                }
            } catch (InputMismatchException e) {
                System.out.println("                            ▶ 😥 잘못 선택하셨습니다. 다시 선택해주세요.");
                sc.nextLine();
                continue;                           //continue를 하기위한 while문
            }
        }

    }

    public void backMenu(){
        while(true) {
            System.out.println();
            System.out.println("==============================돌아가고 싶은 메뉴를 선택해주세요======================");
            System.out.println("                            ▷ 1. 장바구니");
            System.out.println("");
            System.out.println("                            ▷ 0. 초기화면");

            System.out.println("=================================================================================");

            try {
                int backmenu = sc.nextInt();
                switch (backmenu) {
                    case 1:
//                basket();
//                priceBasket();
                        lastBasket();


                    case 0:
                        clearMenu();
                        orderMenuNum = 0;
                        Main.login = false;
                        Main main = new Main();
                        main.MainMenu();

                }
            } catch (InputMismatchException e) {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.                 ");
                sc.nextLine();
            }
        }
    }


    public int priceBasket() {  // TODO :: 메소드 자체를 변수로 이용 (선택한 총 금액)
        int totPrc = 0;

        for (int i = 0; i < orderprice.size(); i++) {
            totPrc += (int) orderprice.get(i);
        }
        return totPrc;
    }

    public void menuBasket(){
        System.out.println("                            ▷ 선택하신 메뉴 " + ordermenu.toString());

    }

    public int payPoint() { // TODO :: 메소드 자체를 변수로 이용 (총 금액 / 10 == 포인트)
        int point = 0;

        for (int i = 0; i < orderprice.size(); i++){
            point += ((int) orderprice.get(i)) / 10;

        }   return point;
    }

    public void cardPayment() { // 카드 결제를 위한 메소드

        OrderMain orderMain = new OrderMain();
        OrderList orderList = new OrderList();

        while(true) {

            System.out.println("                            ▷ 💳 카드 결제 입니다");
            System.out.println("                            ▷ 주문 내역을 확인 해주세요");
            basket();
            System.out.println("                            ▷ 주문 총 금액 : " + priceBasket());
            System.out.println("=================================================================================");
            System.out.println();
            System.out.println("                            ▷ 1. 결제하기");
            System.out.println("                            ▶ 2. 취소하기");

            Scanner sc = new Scanner(System.in);

            try{
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("                            ▷ 😊 결제가 완료되었습니다.");
                orderList.orderComplete();
                System.out.println("                            ▷" + priceBasket() );
                System.out.println("                            ▷ " + payPoint() );
                return;
            } else {
                System.out.println("                            ▶ 이전 페이지로 되돌아갑니다.");

//                return;
//                orderMain.orderContinue();    // TEST
                golastbasket();

//                continue;

            }
            }catch(InputMismatchException e){
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.");
                sc.nextLine();
                continue;
            }
        }
    }

    public void moneyPayment () {   // 현금 결제를 위한 메소드

        OrderMain orderMain = new OrderMain();
        OrderList orderList = new OrderList();

        while(true) {


            System.out.println("                            ▷ 💸 현금 결제 입니다");
            System.out.println("                            ▷ 주문 내역을 확인해주세요 ◀");
            basket();
            System.out.println("                            ▷ 주문 총 금액 : " + priceBasket());
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 1. 결제하기");
            System.out.println("                            ▶ 2. 취소하기");

            Scanner sc = new Scanner(System.in);

            try {
                int cash = sc.nextInt();


                if (cash == 1) {
                    System.out.println("                            ▷ 지불할 금액을 입력해주세요.");
                    sc.nextLine();
                    int payCash = sc.nextInt();         // 지불할 금액 입력
                    if (payCash < priceBasket()) {
                        System.out.println("                            ▷ 😥 금액이 부족합니다. 지불하신 금액을 확인해주세요");
                        continue;
                        // orderMain.orderContinue();                  //*금액이 부족함을 확인 후 계속 주문 으로 넘어가는걸 의도하셨는지?   :: 의도 하였습니다.
                        //*금액이 부족하면 지금까지 넣어놓은 메뉴가 초기화됨
                    } else if (payCash == priceBasket()) {
                        System.out.println("                            ▷ " + payCash + "원이 " + "계산되었습니다. 감사합니다♥ ");
                        System.out.println("                            ▷ 적립 포인트  : " + payPoint() + " ◀");

                        clearMenu();

                        orderList.orderComplete();
                        //break;  // TODO :: 여기서 끝나야해
                        return;
// 24.01.11 메인 merge 후 확인할부분

//                    orderMain.orderContinue();                  //*금액이 부족함을 확인 후 계속 주문 으로 넘어가는걸 의도하셨는지?
//                     //*금액이 부족하면 지금까지 넣어놓은 메뉴가 초기화됨
//                 } else if (payCash == priceBasket()) {
//                     System.out.println(payCash + "원이" + "계산되었습니다.");
//                     System.out.println("적립 포인트  : ▶ " + payPoint() + " ◀");
//                     orderList.orderComplete();
//                     break;

                    } else {
                        System.out.println("=================================================================================");
                        System.out.println("                            ▷ 주문 총 금액 : " + (priceBasket()) + " ◀");
                        System.out.println("                            ▷ 남은 잔돈 : " + (payCash - priceBasket()) + " ◀");
                        System.out.println("                            ▷ 적립 포인트 : " + payPoint() + " ◀");
                        System.out.println("=================================================================================");
                        System.out.println("                          😋 주문이 완료되었습니다. 감사합니다 ★ ");

                        clearMenu();

                        System.out.println("");
                        orderList.orderComplete();
                        System.out.println("=================================================================================");
                        return;

                    }
                } else {
                    System.out.println("                            ▷ 이전 페이지로 되돌아갑니다.");
                    golastbasket();
//                 orderMain.orderContinue();

                }
            }catch(InputMismatchException e)
            {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.      ");
                sc.nextLine();
            }
        }
    }

    public void chooseBread(){                      //빵 선택

        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 🥯 빵을 선택해 주세요.                                   ");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("                            ▷ 1. 화이트                                           ");
            System.out.println("                            ▷ 2. 하티                                            ");
            System.out.println("                            ▷ 3. 파마산오레가노                                    ");
            System.out.println("                            ▷ 4. 위트                                            ");
            System.out.println("                            ▷ 5. 허니오트                                         ");
            System.out.println("                            ▷ 6. 플랫브레드                                       ");
            System.out.println("=================================================================================");


            try {
                int breadnum = sc.nextInt();

                switch (breadnum) {
                    case 1: case 2: case 3: case 4: case 5: case 6:
                        choosebread.add(breadlist[breadnum - 1]);
//            System.out.println("고른 빵은 : " + choosebread + "입니다.");
                        return;
                    default:
                        System.out.println("                            ▶ 😥 번호를 잘못 입력하였습니다. 다시 입력해주세요.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.                 ");
                sc.nextLine();
            }
        }

    }

    public void minusVegetable(){

        Set<String> minusVegetableSet = new HashSet();
        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 🥗 뺄 야채를 선택해 주세요.                             ");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("                            ▷ 1. 양상추                                            ");
            System.out.println("                            ▷ 2. 토마토                                            ");
            System.out.println("                            ▷ 3. 오이                                             ");
            System.out.println("                            ▷ 4. 피망                                             ");
            System.out.println("                            ▷ 5. 양파                                             ");
            System.out.println("                            ▷ 6. 피클                                             ");
            System.out.println("                            ▷ 7. 올리브                                           ");
            System.out.println("                            ▷ 8. 할라피뇨                                          ");
            System.out.println("                            ▷ 9. 아보카도                                          ");
            System.out.println("                            ▷ 10. 다 빼주세요                                     ");
            System.out.println("                                                                                  ");
            System.out.println("                            ▶ 0. 다 넣어주세요                                       ");
            System.out.println("=================================================================================");

            try {
                int chooseveg = sc.nextInt();

//            System.out.println(chooseveg);
                if (chooseveg == 0) {
                    //* 이부분이 문제!
                    minusVegetableSet.add(" ");
                    minusVegetable.add(orderMenuNum, minusVegetableSet);
//                minusVegetableSet.add(" ");
                    return;                                 //뺄 야채 없으니 원래 메뉴로
                } else if (chooseveg > 0 && chooseveg < 10) {
                    sc.nextLine();
                    int minveg = chooseveg - 1;
                    minusVegetableSet.add(vegetable[minveg]);

                    System.out.println("현재 뺄 야채 : " + minusVegetableSet);

                    minuscontinue :
                    while(true) {


                        System.out.println("=================================================================================");
                        System.out.println("                            ▷ 계속 빼시겠습니까?                                  ");
                        System.out.println("                            ▷ 1. 예                                            ");
                        System.out.println("                            ▷ 2. 아니오                                        ");
                        System.out.println("=================================================================================");
                        //잘못입력함 -> 잘못입력했다고 함 -> 야채빼는 번호 고름 -> (*) 또 번호 고르라고함 -> (*)고르면 계속 뺴시겠습니까 를 보여주고 바로 야채목록을 보여줌
                        try {
                            int continuuVeg = sc.nextInt();

                            switch (continuuVeg) {
                                case 1:                        //야채 추가로 빼
                                    break minuscontinue;
                                case 2:                        //토핑소스 고르는 메뉴로
                                    minusVegetable.add(minusVegetableSet);              //ArrayList(샌드위치당 야채)에 야채 Set 넣기
                                    System.out.println(minusVegetable);
                                    return;
                                default:
                                    System.out.println("                            ▶ 😥 잘못 입력하셨습니다. 다시 입력해주세요.");
                                    break;
                            }
                        }catch(InputMismatchException e)
                        {
                            System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.        ");
                            sc.nextLine();
                        }
                    }

                } else if (chooseveg == 10) {
//                System.out.println("선택번호 = 10");

                    for (int i = 0; i < vegetable.length; i++) {
                        minusVegetableSet.add(vegetable[i]);
                    }


                    System.out.println("현재 뺄 야채 : " + minusVegetableSet);
                    minusVegetable.add(minusVegetableSet);
//                System.out.println(ordermenu + "의 뺄 야채 : " + minusVegetableset);
                    return;
                } else {
                    System.out.println("                            ▶ 😥 번호를 잘못 입력하였습니다. 다시 입력해주세요.");
                    continue;
                }
            } catch(InputMismatchException e)
            {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.           ");
                sc.nextLine();
            }
        }
    }

    public void addTopping(){
        Set<String> addToppingSet = new HashSet<>();
        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 🧀 추가할 토핑을 선택해 주세요.                             ");
            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("                            ▷ 1. 미트 추가                                         ");
            System.out.println("                            ▷ 2. 에그마요                                          ");
            System.out.println("                            ▷ 3. 베이컨                                           ");
            System.out.println("                            ▷ 4. 치즈 추가                                         ");
            System.out.println("                            ▷ 5. 아보카도                                          ");
            System.out.println("                            ▷ 6. 오믈렛                                            ");
            System.out.println("                            ▷ 7. 페퍼로니                                          ");
            System.out.println("                            ▷ 8. 전부 다 넣어주세요                                  ");
            System.out.println("                                                                                  ");
            System.out.println("                            ▶ 0. 토핑 안 넣을래요                                    ");
            System.out.println("=================================================================================");

            try {
                int toppingSelect = sc.nextInt();

                if (toppingSelect == 0)                              //토핑 안 넣으면 원래 메뉴로 돌아가기
                {
                    //* 이부분이 문제!
                    addToppingSet.add(" ");
                    addTopping.add(orderMenuNum, addToppingSet);
                    return;
                } else if (toppingSelect > 0 && toppingSelect <= 7) {
                    int topSelNum = toppingSelect - 1;

                    addToppingSet.add(topping[topSelNum]);

                    System.out.println("현재 추가한 토핑 : " + addToppingSet);

                    toppingcontinue:
                    while(true){
                        System.out.println("=================================================================================");
                        System.out.println("                            ▷ 계속 추가하시겠습니까?                                ");
                        System.out.println("                            ▷ 1. 예                                              ");
                        System.out.println("                            ▷ 2. 아니오                                           ");
                        System.out.println("=================================================================================");

                        try {
                            int continueAddTop = sc.nextInt();

                            switch (continueAddTop) {
                                case 1:                            //계속 추가
                                    break toppingcontinue;
                                case 2:                            //주문 끝 -> 원래 있던 자리로
                                    System.out.println("주문 끝났대요~!");
                                    addTopping.add(addToppingSet);
                                    System.out.println((orderMenuNum + 1) + "번째 토핑 목록 : " + addTopping.get(orderMenuNum));
                                    return;
                                default:
                                    System.out.println("                            ▶ 😥 번호를 잘못 입력하셨습니다. 다시 입력해주세요.     ");
                                    break;
                            }
                        }catch(InputMismatchException e)
                        {
                            System.out.println("                            ▶ 😥 번호를 잘못 입력하였습니다. 다시 입력해주세요.    ");
                            sc.nextLine();
                        }
                    }

                }
                else if (toppingSelect == 8)
                {
                    for (int i = 0; i < topping.length; i++) {
                        addToppingSet.add(topping[i]);
                    }

                    System.out.println("현재 추가한 토핑 : " + addToppingSet);
                    addTopping.add(addToppingSet);
                    return;
                }
            } catch(InputMismatchException e)
            {
                System.out.println("                            ▶ 😥 잘못 입력하였습니다. 다시 입력해주세요.           ");
                sc.nextLine();
            }
        }

    }


    /** clearMenu = 리스트 초기화*/
    public void clearMenu(){                        //메뉴 초기화
        ordermenu.clear();
        orderprice.clear();
        choosebread.clear();
        minusVegetable.clear();
        addTopping.clear();
//        System.out.println(ordermenu);
    }

    public void golastbasket(){
        lastBasket();
    }

}
