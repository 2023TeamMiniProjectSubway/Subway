package com.miniProject.subway.view;

import com.miniProject.subway.menu.MenuDTO;
import com.miniProject.subway.order.OrderController;

import java.util.Scanner;

public class OrderMain {

    Scanner sc = new Scanner(System.in);
    OrderController oc = new OrderController();
    MenuDTO menudto = new MenuDTO();
    int choice;
    public static int orderMenuNum = 0;

    public void orderMenu(){

        while(true)
        {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 주문할 메뉴를 선택해주세요.                            ");
            System.out.println("                            ▷ 1. 클래식                                           ");
            System.out.println("                            ▷ 2. 프레쉬&라이트                                     ");
            System.out.println("                            ▷ 3. 프리미엄                                          ");
            System.out.println("                            ▷ 4. 신제품 (new!)                                    ");
            System.out.println("                                                                                 ");
            System.out.println("                            ▶ 0. 이전 메뉴로                                      ");
            System.out.println("=================================================================================");

            int ordermenu = sc.nextInt();

            switch(ordermenu)
            {
                case 1 :
                    classicMenu();
                    continue;
                case 2 :
                    freshlightMenu();
                    break;
                case 3 :
                    premiumMenu();
                    break;
                case 4 :
                    newMenu();
                    break;
                case 0 :
                    System.out.println("                            ▶ 이전 메뉴로 돌아갑니다.                         ");
                    oc.clearMenu();                                 //메뉴 초기화
                    orderMenuNum = 0;
                    sc.nextLine();
                    return;
                default :
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다.                     ");
                    break;
            }
        }

    }

    public void classicMenu(){

        while(true){
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 주문할 메뉴를 선택해주세요.                            ");
            System.out.println("---------------------------------- 클래식 ----------------------------------------");
            System.out.println("                            ▷ 1. 에그마요                                         ");
            System.out.println("                            ▷ 2. 이탈리안 비엠티                                   ");
            System.out.println("                            ▷ 3. 비엘티                                           ");
            System.out.println("                            ▷ 4. 햄                                              ");
            System.out.println("                            ▷ 5. 참치                                            ");
            System.out.println("                                                                                 ");
            System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
            System.out.println("=================================================================================");

            int classicMenu = sc.nextInt();         //주문할 메뉴 선택
            choice = classicMenu - 1;

            switch(classicMenu){
                case 1 : case 2 : case 3 : case 4 : case 5 :
                    oc.showMenuDetail(choice);               //선택한 숫자를 orderMenu에 넣음
                    if(orderContinue()==true){               //계속 주문할지 선택
                        continue;
                    }
                    else{
                        System.out.println("주문 끝!");

                        return;
                    }

                case 0 :
                    return;
                default :
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다.                     ");
                    break;
            }

        }

    }

    public void freshlightMenu(){
        while(true){
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 주문할 메뉴를 선택해주세요.                           ");
            System.out.println("-------------------------------- 프레쉬 & 라이트 ---------------------------------");
            System.out.println("                            ▷ 1. 치킨 슬라이스                                   ");
            System.out.println("                            ▷ 2. 치킨 베이컨 아보카도                             ");
            System.out.println("                            ▷ 3. 로스트 치킨                                     ");
            System.out.println("                            ▷ 4. 로티세리 바비큐 치킨                             ");
            System.out.println("                            ▷ 5. 써브웨이 클럽                                  ");
            System.out.println("                            ▷ 6. 베지                                         ");
            System.out.println();
            System.out.println("                            ▶ 0. 이전 메뉴로                                    ");
            System.out.println("=================================================================================");

            int classicMenu = sc.nextInt();         //주문할 메뉴 선택
            choice = classicMenu + 4;               // 5~10

            switch(classicMenu){
                case 1 : case 2 : case 3 : case 4 : case 5 : case 6 :
                    oc.showMenuDetail(choice);               //선택한 숫자를 orderMenu에 넣음
                    if(orderContinue()==true){              //계속 주문할지 선택
                        continue;
                    }
                    else{
                        System.out.println("주문 끝!");
                                                            // 결제화면으로 넘어가기
                        return;
                    }

                case 0 :
                    return;
                default:
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다.                     ");
                    break;

            }
        }
    }

    public void premiumMenu(){

        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 주문할 메뉴를 선택해주세요.                            ");
            System.out.println("--------------------------------- 프리미엄 ---------------------------------------");
            System.out.println("                            ▷ 1. 스파이시 쉬림프                                   ");
            System.out.println("                            ▷ 2. 쉬림프                                           ");
            System.out.println("                            ▷ 3. K-바비큐                                         ");
            System.out.println("                            ▷ 4. 풀드 포크 바비큐                                  ");
            System.out.println("                            ▷ 5. 스테이크 & 치즈                                   ");
            System.out.println("                            ▷ 6. 스파이시 이탈리안                                  ");
            System.out.println("                            ▷ 7. 치킨 데리야끼                                     ");
            System.out.println();
            System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
            System.out.println("=================================================================================");


            int classicMenu = sc.nextInt();         //주문할 메뉴 선택
            choice = classicMenu + 10;               // 11~17

            switch (classicMenu) {
                case 1:     case 2:     case 3:     case 4:     case 5:     case 6:     case 7:
                    oc.showMenuDetail(choice);                  //선택한 숫자를 orderMenu에 넣음
                    if (orderContinue() == true) {              //계속 주문할지 선택
                        continue;
                    } else {
                        System.out.println("주문 끝!");
                                                                // 결제화면으로 넘어가기
                        return;
                    }

                case 0:
                    return;
                default:
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다.");
                    break;
            }
        }
    }

    public void newMenu(){

        while(true){

            System.out.println("=================================================================================");
            System.out.println("                            ▷ 주문할 메뉴를 선택해주세요.                            ");
            System.out.println("----------------------------------- 신제품 -------------------------------------- ");
            System.out.println("                            ▷  1. 랍스터                                          ");
            System.out.println("                                                                                 ");
            System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
            System.out.println("=================================================================================");

            int classicMenu = sc.nextInt();         //주문할 메뉴 선택
            choice = classicMenu + 17;               // 18

            switch (classicMenu) {
                case 1:
                    oc.showMenuDetail(choice);                  //선택한 숫자를 orderMenu에 넣음
                    if (orderContinue() == true) {              //계속 주문할지 선택
                        continue;
                    } else {
                        System.out.println("주문 끝!");
                        // 결제화면으로 넘어가기
                        return;
                    }

                case 0:
                    return;
                default:
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다.");
                    break;
            }

        }
    }

    public boolean orderContinue(){
        boolean result = true;
        while(true)
        {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 계속 주문하시겠습니까?                                ");
            System.out.println("                            ▷ 1. 예                                             ");
            System.out.println("                            ▷ 2. 아니오(장바구니로 이동합니다.)                      ");
            System.out.println("=================================================================================");


            int orderContinue = sc.nextInt();

            switch(orderContinue){
                case 1 :                                //계속 주문 -> 원래 메뉴로 이동


                    result =  true;
                    return result;
                case 2 :                                //주문 끝 -> 결제창으로 이동
                    result =  false;
                    return result;
                default:
                    System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요.");
                    continue;
            }
        }

    }
}
