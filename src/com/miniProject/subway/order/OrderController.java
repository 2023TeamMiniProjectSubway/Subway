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

    /** 메뉴 어레이리스트 */
    public OrderController () {
        menuDTO.add(new MenuDTO("에그마요", 4900,"부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러"));
        menuDTO.add(new MenuDTO("이탈리안 비엠티", 6100,"페퍼로니, 살라미 그리고 햄이 만들어내는 전세계가 사랑하는 베스트셀러"));
        menuDTO.add(new MenuDTO("비엘티", 6000,"오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~"));
        menuDTO.add(new MenuDTO("햄", 5200,"풍부한 햄이 만들어내는 담백함을 입 안 가득 즐겨보세요!"));
        menuDTO.add(new MenuDTO("참치", 5200,"남녀노소 누구나 좋아하는 담백한 참치와 고소한 마요네즈의 완벽한 조화"));

        menuDTO.add(new MenuDTO("치킨 슬라이스", 5900, "닭가슴살로 만든 치킨 슬라이스로 즐기는 담백한 맛!"));
        menuDTO.add(new MenuDTO("치킨 베이컨 아보카도", 5900, "담백하게 닭가슴살로 만든 치킨 슬라이스와 베이컨, 부드러운 아보카도의 만남"));
        menuDTO.add(new MenuDTO("로스트 치킨", 6700, "오븐에 구워 담백한 저칼로리 닭가슴살의 건강한 풍미"));
        menuDTO.add(new MenuDTO("로티세리 바비큐 치킨", 6700, "촉촉한 바비큐 치킨의 풍미가득, 손으로 찢어 더욱 부드러운 치킨의 혁명"));
        menuDTO.add(new MenuDTO("써브웨이 클럽", 6500, "고소한 베이컨, 담백한 치킨 슬라이스에 햄까지 더해 완벽해진 조화를 즐겨보세요!"));
        menuDTO.add(new MenuDTO("베지", 4400, "갓 구운 빵과 신선한 8가지 야채로 즐기는 깔끔한 한끼"));

        menuDTO.add(new MenuDTO("스파이시 쉬림프", 6300,"탱글한 쉬림프에 이국적인 시즈닝을 더해 색다른 매콤함을 만나보세요!"));
        menuDTO.add(new MenuDTO("쉬림프", 6500,"탱글한 쉬림프 5마리가 그대로, 신선하고 담백한 쉬림프의 맛 그대로 즐겨보세요!"));
        menuDTO.add(new MenuDTO("K-바비큐", 6700,"써브웨이의 코리안 스타일 샌드위치! 마늘, 간장 그리고 은은한 불맛까지!"));
        menuDTO.add(new MenuDTO("풀드 포크 바비큐", 6600,"미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치"));
        menuDTO.add(new MenuDTO("스테이크 & 치즈", 7400,"육즙이 쫙~풍부한 비프 스테이크의 풍미가 입안 한가득"));
        menuDTO.add(new MenuDTO("스파이시 이탈리안", 6300,"페퍼로니 & 살라미가 입안 가득, 페퍼로니의 부드러운 매콤함을 만나보세요!"));
        menuDTO.add(new MenuDTO("치킨 데리야끼", 6400,"담백한 치킨 스트립에 달콤짭쪼름한 써브웨이 특제 데리야끼 소스와의 환상적인 만남"));

        menuDTO.add(new MenuDTO("랍스터", 7600,"신선한 랍스터 통살이 고소한 마요네즈와 만나 풍미가 가득, 입안 가득 신선한 랍스터 샌드위치"));



    }

    /** 주문메뉴 정보*/
    public void showMenuDetail(int choice){
        showdetail :
        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 메뉴 상세 정보          ");
            System.out.println("                            ▶ " + menuDTO.get(choice).getMenuname() + " ◁  ");
            System.out.println("                            ▶ " + menuDTO.get(choice).getPrice() + "원   ");
            System.out.println("                            ▶ " + menuDTO.get(choice).getDescription() + "   ");

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
                        System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.           ");
                        break;
                }
            }catch (InputMismatchException e)
            {
                System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.                  ");
                sc.nextLine();
            }
        }
    }

    /** 주문한 메뉴를 보여주는 메소드 */
    public void orderMenu(int choice){

        System.out.println("현재 주문하신 메뉴 개수 : " + (orderMenuNum + 1));

        ordermenu.add(menuDTO.get(choice).getMenuname());
        orderprice.add(menuDTO.get(choice).getPrice());


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
            System.out.println("                                  └ 빵 : " + choosebread.get(i));

            if(minusVegetable.get(i).size() == 0)
            {
                System.out.println("                                  └ 뺄 야채 : " + "없음");
            }
            else {

                System.out.println("                                  └ 뺄 야채 : " + minusVegetable.get(i));
            }
            if(addTopping.get(i).size() == 0 )
            {
                System.out.println("                                  └ 추가할 토핑 : " + "없음");
            }
            else {
                System.out.println("                                  └ 추가할 토핑 : " + addTopping.get(i));
            }
        }
        System.out.println();
        System.out.println();
        System.out.println("                            √ 현재 총 가격 : " + sum          );

    }


    /** 주문한 메뉴를 담아주는 장바구니 메소드 */
    public void basket() {
        priceBasket();
        menuBasket();
    }

    /** 결제수단 메소드 */
    public void lastBasket() {
        while(true) {
            try {
                sc.nextLine();
                System.out.println("=================================================================================");
                menuBasket();
                System.out.println("                            ▷ 현재 선택하신 메뉴 총 금액 : " + priceBasket());
                System.out.println("=================================================================================");
                System.out.println("                            ▷ 결제 도와드리겠습니다.                                ");
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

                    default:
                        System.out.println(pick);
                        System.out.println("                            ▷ 선택할 수 없습니다. 다시 선택해주세요.");

                }
            } catch (InputMismatchException e) {
                System.out.println("                            ▷ 잘못 선택하셨습니다. 다시 선택해주세요.");
                continue;
            }
        }

    }

    /** 이전 단계로 돌아가는 메소드 */
    public void backMenu(){
        while(true) {
            sc.nextLine();
            System.out.println();
            System.out.println("==============================돌아가고 싶은 메뉴를 선택해주세요======================");
            System.out.println("                            ▷ 1. 장바구니");
            System.out.println("");
            System.out.println("                            ▷ 0. 초기화면");

            System.out.println("=================================================================================");


            int backmenu = sc.nextInt();
            switch (backmenu) {
                case 1:
                    lastBasket();


                case 0:
                    clearMenu();
                    orderMenuNum = 0;
                    Main.login = false;
                    Main main = new Main();
                    main.MainMenu();
                default:
                    System.out.println("                            ▷ 잘못입력하셨습니다. 다시 입력해주세요");
                    continue;
            }

        }

    }

    /** 장바구니 담긴 총 금액 */
    public int priceBasket() {  // TODO :: 메소드 자체를 변수로 이용 (선택한 총 금액)
        int totPrc = 0;

        for (int i = 0; i < orderprice.size(); i++) {
            totPrc += (int) orderprice.get(i);
        }
        return totPrc;
    }

    /** 장바구니 담긴 총 메뉴 */
    public void menuBasket(){
        System.out.println("                            ▷ 선택하신 메뉴 " + ordermenu.toString());

    }

    /** 포인트 계산 메소드 */
    public int payPoint() {
        int point = 0;

        for (int i = 0; i < orderprice.size(); i++){
            point += ((int) orderprice.get(i)) / 10;

        }   return point;
    }

    /** 카드결제창 메소드 */
    public void cardPayment() { //

        OrderMain orderMain = new OrderMain();
        OrderList orderList = new OrderList();

        while(true) {

            System.out.println("                            ▷ 카드 결제 입니다");
            System.out.println("                            ▷ 주문 내역을 확인 해주세요");
            basket();
            System.out.println("                            ▷ 주문 총 금액 : " + priceBasket());
            System.out.println("=================================================================================");
            System.out.println();
            System.out.println("                            ▷ 1. 결제하기");
            System.out.println("                            ▷ 2. 취소하기");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println("                            ▶ 결제가 완료되었습니다.");
                orderList.orderComplete();
                System.out.println("                            ▶" + priceBasket() );
                System.out.println("                            ▶ " + payPoint() );
                return;
            } else if(choice == 2 ) {
                System.out.println("                            ▶ 이전 페이지로 되돌아갑니다.");

                  golastbasket();


            } else {
                System.out.println("                            ▷ 잘못입력하셨습니다. 다시 입력해주세요");
            }
        }
    }

    /** 현금 결제창 메소드 */
    public void moneyPayment () {

        OrderMain orderMain = new OrderMain();
        OrderList orderList = new OrderList();

        while(true) {


            System.out.println("                            ▶ 현금 결제 입니다");
            System.out.println("                            ▶ 주문 내역을 확인해주세요 ◀");
            basket();
            System.out.println("                            ▶ 주문 총 금액 : " + priceBasket());
            System.out.println("=================================================================================");
            System.out.println();
            System.out.println("                            ▶ 1. 결제하기");
            System.out.println("                            ▶ 2. 취소하기");

            Scanner sc = new Scanner(System.in);
            int cash = sc.nextInt();


            if (cash == 1) {
                System.out.println("                            ▷ 지불할 금액을 입력해주세요.");
                sc.nextLine();
                int payCash = sc.nextInt();
                if (payCash < priceBasket()) {
                    System.out.println("                            ▷ 금액이 부족합니다. 지불하신 금액을 확인해주세요");
                    continue;
                } else if (payCash == priceBasket()) {
                    System.out.println("                            ▷ " + payCash + "원이 " + "계산되었습니다. 감사합니다♥ ");
                    System.out.println("                            ▷ 적립 포인트  : " + payPoint() + " ◀");

                    clearMenu();

                    orderList.orderComplete();
                    return;

                } else {
                    System.out.println("=================================================================================");
                    System.out.println("                            ▷ 주문 총 금액 : " + (priceBasket()) + " ◀");
                    System.out.println("                            ▷ 남은 잔돈 : " + (payCash - priceBasket()) + " ◀");
                    System.out.println("                            ▷ 적립 포인트 : " + payPoint() + " ◀");
                    System.out.println("=================================================================================");
                    System.out.println("                            주문이 완료되었습니다. 감사합니다 ★ ");

                    clearMenu();

                    System.out.println("");
                    orderList.orderComplete();
                    System.out.println("=================================================================================");
                    return;

                }
            } else if (cash == 2) {
                System.out.println("                            ▷ 이전 페이지로 되돌아갑니다.");
                    golastbasket();


            } else {
                System.out.println("                            ▷ 잘못입력하셨습니다. 다시 입력해주세요.");
                continue;
            }
        }
    }

    /** 빵 선택 */
    public void chooseBread(){

        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 빵을 선택해 주세요.                                   ");
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

                        return;
                    default:
                        System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.                 ");
                sc.nextLine();
            }
        }

    }

    /** 야채 제외 */
    public void minusVegetable(){

        Set<String> minusVegetableSet = new HashSet();
        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 뺄 야채를 선택해 주세요.                             ");
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

                if (chooseveg == 0) {

                    minusVegetableSet.add(" ");
                    minusVegetable.add(orderMenuNum, minusVegetableSet);
                    return;

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
                                    System.out.println("                            ▶ 잘못 입력하셨습니다. 다시 입력해주세요.");
                                    break;
                            }
                        } catch (InputMismatchException e)
                        {
                            System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.        ");
                            sc.nextLine();
                        }
                    }

                } else if (chooseveg == 10) {


                    for (int i = 0; i < vegetable.length; i++) {
                        minusVegetableSet.add(vegetable[i]);
                    }


                    System.out.println("현재 뺄 야채 : " + minusVegetableSet);
                    minusVegetable.add(minusVegetableSet);

                    return;
                } else {
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요.");
                    continue;
                }
            } catch(InputMismatchException e)
            {
                System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.           ");
                sc.nextLine();
            }
        }
    }

    /** 토핑 추가 */
    public void addTopping(){
        Set<String> addToppingSet = new HashSet<>();
        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 추가할 토핑을 선택해 주세요.                             ");
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
                                case 1:
                                    break toppingcontinue;
                                case 2:

                                    addTopping.add(addToppingSet);
                                    System.out.println((orderMenuNum + 1) + "번째 토핑 목록 : " + addTopping.get(orderMenuNum));
                                    return;
                                default:
                                    System.out.println("                            ▶ 번호를 잘못 입력하셨습니다. 다시 입력해주세요.     ");
                                    break;
                            }
                        }catch(InputMismatchException e)
                        {
                            System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요.    ");
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
                System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.           ");
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

    }

    /** 마지막 장바구니로 이동하는 메소드 */
    public void golastbasket(){
        lastBasket();
    }

}
