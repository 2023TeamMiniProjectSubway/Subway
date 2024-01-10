package com.miniProject.subway.view;

import com.miniProject.subway.menu.MenuDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOrder {    // TODO :: OrderMain에 들어갈 메소드 모음 클래스

    List<MenuDTO> classicmenu = new ArrayList<>();      // 클래식 메뉴
    List<MenuDTO> freshLightmenu = new ArrayList<>();   // 프레쉬&라이트 메뉴
    List<MenuDTO> premiummenu = new ArrayList<>();      // 프리미엄 메뉴
    List<MenuDTO> newmenu = new ArrayList<>();          // 신메뉴


    OrderList orderList = new OrderList();

    Scanner sc = new Scanner(System.in);

    public MenuOrder() {


        classicmenu.add(new MenuDTO("에그마요", 2000,"부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러"));
        classicmenu.add(new MenuDTO("이탈리안 비엠티", 2000,"페퍼로니, 살라미 그리고 햄이 만들어내는 전세계가 사랑하는 베스트셀러"));
        classicmenu.add(new MenuDTO("비엘티", 2000,"오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~"));
        classicmenu.add(new MenuDTO("햄", 2000,"풍부한 햄이 만들어내는 담백함을 입 안 가득 즐겨보세요!"));
        classicmenu.add(new MenuDTO("참치", 2000,"남녀노소 누구나 좋아하는 담백한 참치와 고소한 마요네즈의 완벽한 조화"));

        freshLightmenu.add(new MenuDTO("치킨 슬라이스", 2000, "닭가슴살로 만든 치킨 슬라이스로 즐기는 담백한 맛!"));
        freshLightmenu.add(new MenuDTO("치킨 베이컨 아보카도", 2000, "담백하게 닭가슴살로 만든 치킨 슬라이스와 베이컨, 부드러운 아보카도의 만남"));
        freshLightmenu.add(new MenuDTO("로스트 치킨", 2000, "오븐에 구워 담백한 저칼로리 닭가슴살의 건강한 풍미"));
        freshLightmenu.add(new MenuDTO("로티세리 바비큐 치킨", 2000, "촉촉한 바비큐 치킨의 풍미가득, 손으로 찢어 더욱 부드러운 치킨의 혁명"));
        freshLightmenu.add(new MenuDTO("써브웨이 클럽", 2000, "고소한 베이컨, 담백한 치킨 슬라이스에 햄까지 더해 완벽해진 조화를 즐겨보세요!"));
        freshLightmenu.add(new MenuDTO("베지", 2000, "갓 구운 빵과 신선한 8가지 야채로 즐기는 깔끔한 한끼"));

        premiummenu.add(new MenuDTO("스파이시 쉬림프", 2000,"탱글한 쉬림프에 이국적인 시즈닝을 더해 색다른 매콤함을 만나보세요!"));
        premiummenu.add(new MenuDTO("쉬림프", 2000,"탱글한 쉬림프 5마리가 그대로, 신선하고 담백한 쉬림프의 맛 그대로 즐겨보세요!"));
        premiummenu.add(new MenuDTO("K-바비큐", 2000,"써브웨이의 코리안 스타일 샌드위치! 마늘, 간장 그리고 은은한 불맛까지!"));
        premiummenu.add(new MenuDTO("풀드 포크 바비큐", 2000,"미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치"));
        premiummenu.add(new MenuDTO("스테이크 & 치즈", 2000,"육즙이 쫙~풍부한 비프 스테이크의 풍미가 입안 한가득"));
        premiummenu.add(new MenuDTO("스파이시 이탈리안", 2000,"페퍼로니 & 살라미가 입안 가득, 페퍼로니의 부드러운 매콤함을 만나보세요!"));
        premiummenu.add(new MenuDTO("치킨 데리야끼", 2000,"담백한 치킨 스트립에 달콤짭쪼름한 써브웨이 특제 데리야끼 소스와의 환상적인 만남"));

        newmenu.add(new MenuDTO("랍스터", 2000,"신선한 랍스터 통살이 고소한 마요네즈와 만나 풍미가 가득, 입안 가득 신선한 랍스터 샌드위치"));


    }


    public  void showAllMenu(){
        System.out.println("       ▷ 주문을 계속하시겠습니까?        ");
        System.out.println("       ▷ 1. 클래식                    ");
        System.out.println("       ▷ 2. 프레쉬&라이트              ");
        System.out.println("       ▷ 3. 프리미엄                  ");
        System.out.println("       ▷ 4. 신제품 (new!)             ");
        System.out.println("");
        System.out.println("       ▶ 0. [주문 종료] 결제하러 가기    ");
        System.out.println("=====================================");

        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                showClassic();
                break;
            case 2:
                showfershlight();
                break;
            case 3:
                showpremium();
                break;
            case 4:
                shownewmenu();
                break;
            case 0:
                showOrderBasket();
                break;
        }
    }

    public void showClassic() {
        System.out.println();
        System.out.println("[ 메뉴 상세 정보는 다음과 같습니다. ]");
        for (int i = 0; i < classicmenu.size(); i++){
            MenuDTO menuDTO = classicmenu.get(i);
            System.out.println((i+1) + ". " + "▶" +menuDTO.getName() + "◀");    // i+1을 한 이유는 번호를 1번부터 출력위해.
            System.out.println("Price : " + menuDTO.getPrice() + "원");
            System.out.println("▶" + menuDTO.getDescription() + "◁");

        }

        int choice = sc.nextInt();
        sc.nextLine(); // 이거 안하면 오류 남

        int classicNum = choice - 1;

        MenuDTO selectclassic = classicmenu.get(classicNum);
        System.out.println("=====================================");
        System.out.println("▷ 주문하신 메뉴를 확인해주세요");
        System.out.println("▷ "+ selectclassic.getName()+ "");
        System.out.println("▷" + selectclassic.getPrice() + "원");

        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소      3. 결제");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            orderList.addOrderList(selectclassic);
            System.out.println(selectclassic.getName() + "이(가) 장바구니에 추가되었습니다.");
            showOrderBasket();      // 추가 되면, 장바구니를 체크할 수 있게끔 해줌
        } else if (check == 2) {
            System.out.println(" 장바구니 추가가 취소되었습니다. ");
        } else {
            System.out.println("번호를 잘못 입력하셨습니다.");

            showAllMenu();
        }
    }

    public void showfershlight() {
        System.out.println();
        System.out.println("[ MENU ]");
        for (int i = 0; i < freshLightmenu.size(); i++){
            MenuDTO menuDTO = freshLightmenu.get(i);
            System.out.println((i+1) + ". " + menuDTO.getName() +" ("+ menuDTO.getPrice() +"원) ");

        }

        System.out.println("상품 선택 : ");
        int choice = sc.nextInt();
        sc.nextLine(); // 이거 안하면 오류 남

        int classicNum = choice - 1;

        MenuDTO selectfreshlight = freshLightmenu.get(classicNum);
        System.out.println("================================");
        System.out.println("메뉴 이름 : " + selectfreshlight.getName());
        System.out.println("메뉴 금액 : " + selectfreshlight.getPrice());
        System.out.print("메뉴 특징 : " + selectfreshlight.getDescription());
        System.out.println();
        System.out.println("================================");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소      3. 결제");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            orderList.addOrderList(selectfreshlight);
            System.out.println(selectfreshlight.getName() + "이(가) 장바구니에 추가되었습니다.");
            showOrderBasket();      // 추가 되면, 장바구니를 체크할 수 있게끔 해줌
        } else if (check == 2) {
            System.out.println(" 장바구니 추가가 취소되었습니다. ");
        } else {
            System.out.println("번호를 잘못 입력하셨습니다.");

            showAllMenu();
        }
    }

    public void showpremium() {
        System.out.println();
        System.out.println("[ MENU ]");
        for (int i = 0; i < premiummenu.size(); i++){
            MenuDTO menuDTO = premiummenu.get(i);
            System.out.println((i+1) + ". " +  menuDTO.getName() +" ("+ menuDTO.getPrice() +"원) ");    // i+1을 한 이유는 번호를 1번부터 출력위해.
            break;
        }

        System.out.println("상품 선택 : ");
        int choice = sc.nextInt();
        sc.nextLine(); // 이거 안하면 오류 남

        int classicNum = choice - 1;

        MenuDTO selectpremium = premiummenu.get(classicNum);
        System.out.println("================================");
        System.out.println("메뉴 이름 : " + selectpremium.getName());
        System.out.println("메뉴 금액 : " + selectpremium.getPrice());
        System.out.print("메뉴 특징 : " + selectpremium.getDescription());
        System.out.println("================================");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소      3. 결제");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            orderList.addOrderList(selectpremium);
            System.out.println(selectpremium.getName() + " 이(가) 장바구니에 추가되었습니다.");
            showOrderBasket();      // 추가 되면, 장바구니를 체크할 수 있게끔 해줌
        } else if (check == 2) {
            System.out.println(" 장바구니 추가가 취소되었습니다. ");
        } else {
            System.out.println("번호를 잘못 입력하셨습니다.");

            showAllMenu();
        }
    }

    public void shownewmenu() {
        System.out.println();
        System.out.println("[ MENU ]");
        for (int i = 0; i < newmenu.size(); i++){
            MenuDTO menuDTO = newmenu.get(i);
            System.out.println((i++) + ". " + menuDTO.getName() +" ("+ menuDTO.getPrice() +"원) ");    // i+1을 한 이유는 번호를 1번부터 출력위해.

        }

        System.out.println("상품 선택 : ");
        int choice = sc.nextInt();
        sc.nextLine(); // 이거 안하면 오류 남

        int classicNum = choice - 1;

        MenuDTO selectnewmenu = newmenu.get(classicNum);
        System.out.println("================================");
        System.out.println("메뉴 이름 : " + selectnewmenu.getName());
        System.out.println("메뉴 금액 : " + selectnewmenu.getPrice());
        System.out.print("메뉴 특징 : " + selectnewmenu.getDescription());
        System.out.println("================================");
        System.out.println();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소      3. 결제");

        int check = sc.nextInt();
        sc.nextLine();

        if (check == 1) {
            orderList.addOrderList(selectnewmenu);
            System.out.println(selectnewmenu.getName() + "이(가) 장바구니에 추가되었습니다.");
            showOrderBasket();      // 추가 되면, 장바구니를 체크할 수 있게끔 해줌
        } else if (check == 2) {
            System.out.println(" 장바구니 추가가 취소되었습니다. ");
        } else {
            System.out.println("번호를 잘못 입력하셨습니다.");

            showAllMenu();
        }
    }



    public void showOrderBasket() {

        System.out.println("========== 현재 장바구니 목록 ==========");

        List<MenuDTO> basket = orderList.getOrderList();    // OrderList 리스트형식 basket을 생성  basket안의 값을 받아서 리턴

        for (int i = 0; i < basket.size(); i++) {   // basket의 길이만큼 장바구니의 메뉴를 돌리고
            MenuDTO order = basket.get(i);          // 0번째 부터 가져옴
            System.out.println(order.getName() + "[ " + order.getPrice() + "원 ]");
        }       // todo :: 출력이 안되고, 포문이 어떻게 도는지를 잘 모르겠음.

        System.out.println();
        System.out.println("========== 결제하시겠습니까? ==========");
        System.out.println(orderList.totalPrice() + " 원");

        System.out.println("1. 결제           2. 추가 선택");
        int pick = sc.nextInt();
        sc.nextLine();

        if (pick == 1){
            Account();
            orderList.clearOrderList();
        } else if (pick == 2){
            System.out.println("메뉴판으로 되돌아 갑니다.");
            showAllMenu();
        }
    }

    public void Account() {
        System.out.println("========== 어떤 것으로 결제하시겠습니까? ==========");
        System.out.println("1. 카드            2. 현금                 3.취소" );
        int pick = sc.nextInt();
        sc.nextLine();

        switch (pick){
            case 1:
                card();
                break;
            case 2:
                cash();
                break;
            case 3:
                Account();
                break;
        }


    }

    public void card() {
        List<MenuDTO> basket = orderList.getOrderList();
        System.out.println("결제가 완료되었습니다. 감사합니다.");
        System.out.println();
        System.out.println("------------------------------------------");
    }

    public void cash() {
        for (int i = 0; i <= orderList.totalPrice(); i++) { // TODO :: 왜 금액이 출력이 안되는지, 왜 빠지지 않는지?
            int account = sc.nextInt();
            if (account == orderList.totalPrice()) {
                System.out.println("결제 완료되었습니다. 감사합니다.");
                orderList.clearOrderList();
                break;

            } else if (account > orderList.totalPrice()) {
                System.out.println("결제가 완료되었습니다.");
                System.out.println("남은 잔돈 : ▶" + (account - orderList.totalPrice()) + "◀ ");
                orderList.clearOrderList();
                break;

            } else {
                System.out.println("잔액이 부족합니다. 다른 결제 방법을 이용해주세요");
                Account();
            } break;
        }
    }

}
