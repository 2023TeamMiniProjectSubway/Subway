package com.miniProject.subway.view;

import java.util.Scanner;

public class OrderMain {

    Scanner sc = new Scanner(System.in);

    public void orderMenu(){

        System.out.println("=====================================");
        System.out.println("       ▷ 주문할 메뉴를 선택해주세요.      ");
        System.out.println("       ▷ 1. 클래식                    ");
        System.out.println("       ▷ 2. 프레쉬&라이트              ");
        System.out.println("       ▷ 3. 프리미엄                  ");
        System.out.println("       ▷ 4. 신제품 (new!)             ");
        System.out.println("");
        System.out.println("       ▶ 0. 이전 메뉴로               ");
        System.out.println("=====================================");



    }

    public void classicMenu(){

        System.out.println("=====================================");
        System.out.println("       ▷ 주문할 메뉴를 선택해주세요.      ");
        System.out.println("-------------- 클래식 -----------------");
        System.out.println("       ▷ 1. 에그마요                    ");
        System.out.println("       ▷ 2. 이탈리안 비엠티              ");
        System.out.println("       ▷ 3. 비엘티                     ");
        System.out.println("       ▷ 4. 햄                        ");
        System.out.println("       ▷ 5. 참치                       ");
        System.out.println();
        System.out.println("       ▶ 0. 이전 메뉴로                  ");
        System.out.println("=====================================");

    }

    public void freshlightMenu(){
        System.out.println("=====================================");
        System.out.println("       ▷ 주문할 메뉴를 선택해주세요.      ");
        System.out.println("----------- 프레쉬 & 라이트 -------------");
        System.out.println("       ▷ 1. 치킨 슬라이스                  ");
        System.out.println("       ▷ 2. 치킨 베이컨 아보카도            ");
        System.out.println("       ▷ 3. 로스트 치킨                   ");
        System.out.println("       ▷ 4. 로티세리 바비큐 치킨            ");
        System.out.println("       ▷ 5. 써브웨이 클럽                 ");
        System.out.println("       ▷ 6. 베지                        ");
        System.out.println();
        System.out.println("       ▶ 0. 이전 메뉴로                  ");
        System.out.println("=====================================");
    }

    public void premiumMenu(){
        System.out.println("=====================================");
        System.out.println("       ▷ 주문할 메뉴를 선택해주세요.      ");
        System.out.println("------------- 프리미엄 ---------------");
        System.out.println("       ▷ 1. 스파이시 쉬림프               ");
        System.out.println("       ▷ 2. 쉬림프                      ");
        System.out.println("       ▷ 3. K-바비큐                    ");
        System.out.println("       ▷ 4. 풀드 포크 바비큐              ");
        System.out.println("       ▷ 5. 스테이크 & 치즈              ");
        System.out.println("       ▷ 6. 스파이시 이탈리안             ");
        System.out.println("       ▷ 7. 치킨 데리야끼                ");
        System.out.println();
        System.out.println("       ▶ 0. 이전 메뉴로                  ");
        System.out.println("=====================================");
    }

    public void newMenu(){
        System.out.println("=====================================");
        System.out.println("       ▷ 주문할 메뉴를 선택해주세요.      ");
        System.out.println("--------------- 신제품 ---------------");
        System.out.println("       ▷  1. 랍스터                   ");
        System.out.println("     ");
        System.out.println();
        System.out.println("       ▶ 0. 이전 메뉴로                  ");
        System.out.println("=====================================");
    }
}
