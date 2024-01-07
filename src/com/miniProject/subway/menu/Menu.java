package com.miniProject.subway.menu;

import com.miniProject.subway.main.Main;
import com.miniProject.subway.order.OrderController;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.SystemColor.menu;


public class Menu {
    OrderController order = new OrderController();

    List<Food> sandwitchMenu = new ArrayList<>();   // 샌드위치 리스트 생성

//    List<Drink> drinksMenu = new ArrayList<>();     // 음료 리스트 생성
//    List<SideMenu> sidesMenu = new ArrayList<>();   // 사이드 리스트 생성

    Scanner sc = new Scanner(System.in);

    public Menu(){
        sandwitchMenu.add(new Food("에그마요 set", 10000, "부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러"));
        sandwitchMenu.add(new Food("비엘티 set", 10600, "오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~"));
        sandwitchMenu.add(new Food("이탈리안 비엠티 set", 11500, "페퍼로니, 살라미 그리고 햄이 만들어내는 최상의 조화! 전세계가 사랑하는 베스트셀러"));
        sandwitchMenu.add(new Food("폴드 포크 바베큐 set", 13200, "미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치"));

//        drinksMenu.add(new Drink("coke", 5.5, "부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러"));     // TODO :: 세트를 선택할 수 있다면, 동일하게 만들 수 있음.
//        sidesMenu.add(new SideMenu("에그마요", 5.5, "부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러")); // TODO :: 세트를 선택할 수 있다면, 동일하게 만들 수 있음.
    }


    public void ShowFirst(){
        System.out.println("=====================================");
        System.out.println("            WELCOME SUBWAY           ");
        System.out.println("=====================================");
        System.out.println();
        System.out.println("에그마요 set          | 부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러");
        System.out.println("비엘티  set           |오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~");
        System.out.println("이탈리엔 비엠티 set    | 페퍼로니, 살라미 그리고 햄이 만들어내는 최상의 조화! 전세계가 사랑하는 베스트셀러");
        System.out.println("폴드 포크 바베큐 set   | 미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치");
        System.out.println("=====================================");
        System.out.println("주문하시겠습니까?");
        System.out.println("=====================================");
        System.out.println("1. 주문");
        System.out.println("2. 주문 취소 ");
        System.out.println("3. 주문 종료 ");

        int i = sc.nextInt();
        if (i == 1){
            ShowMenu();
        } else if (i == 2) {
            OrderCancel();
        } else {
            OrderBasket();
        }
    }

    public void ShowMenu (){
        System.out.println("=====================================");
        System.out.println("         ▶ 메뉴를 선택해주세요     ");
        System.out.println("=====================================");
        System.out.println();
        System.out.println("[Subway MENU]");
        System.out.println("에그마요 set          | 부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러");
        System.out.println("비엘티  set           |오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~");
        System.out.println("이탈리엔 비엠티 set    | 페퍼로니, 살라미 그리고 햄이 만들어내는 최상의 조화! 전세계가 사랑하는 베스트셀러");
        System.out.println("폴드 포크 바베큐 set   | 미국 스타일의 풀드 포크 바비큐가 가득 들어간 샌드위치");
        System.out.println();

        System.out.println("[ORDER]");
        System.out.println("1. 주문하시겠습니까? ");
        System.out.println("2. 취소하시겠습니까? ");

        System.out.println("번호를 입력해주세요 : ");
        int pick = sc.nextInt();
        sc.nextLine();

        switch (pick) {
            case 1:
                ShowSandwitch();;
                break;
            case 2:
                OrderCancel();

        }

    }

    public void ShowSandwitch(){    // 샌드위치
        System.out.println();
        System.out.println("[Sandwitch LIST]");
        for (int i = 0; i < sandwitchMenu.size(); i++){
            Food menu = sandwitchMenu.get(i);
            System.out.println((i+1) + ". " + menu.getName() + "   | " + menu.getPrice() + "   | " + menu.getDescription());
        }

        System.out.println("상품 선택 : ");
        int choice = sc.nextInt();
        sc.nextLine();

        int SandwitchInfo = choice;

        Food select = sandwitchMenu.get(SandwitchInfo);
        System.out.println("[" +  select.getName() + "]" + "["+ select.getPrice() + "]" + "[" + select.getDescription() + "]" );

        System.out.println("위 메뉴를 선택하시겠습니까?");
        System.out.println("1. 확인         2. 취소");

        int check = sc.nextInt();
        sc.nextLine();


        if (check == 1) {
            System.out.println(select.getName() + " 가 장바구니에 추가 되었습니다.");
            System.out.println();

        } else if (check == 2) {
            System.out.println("메뉴를 취소하셨습니다.");
            System.out.println("다시 선택 해주세요.");
        } else {
            System.out.println("다시 선택해주세요");
        }
//            OrderBasket();        // 선택한 메뉴를 보관
    }

    public void OrderCancel() {
        System.out.println();
        System.out.println("주문을 취소하셨습니다.");
        System.out.println("1. 확인");

        int cancel = sc.nextInt();
        sc.nextLine();

        if (cancel == 1) {
            order.cancelMenu();
            System.out.println("주문 취소를 선택하셨습니다. 처음 페이지로 되돌아 갑니다.");
            Main main = new Main();
            main.MainMenu();
        }

    }

    public void OrderBasket(){

        System.out.println("추가로 더 주문하시겠습니까?");
        System.out.println("1. 추가하기");
        System.out.println("2. 주문 끝내기");
        System.out.println("3. 주문 취소하기");

        int ordernum = sc.nextInt();

        if (ordernum == 1){
            ShowSandwitch();
        } else if (ordernum == 2) {
            OrderComplete();
        } else if (ordernum == 3) {
            OrderCancel();
        } else {
            System.out.println(" 다시 입력해주세요");
            OrderBasket();
        }


    }

    public void OrderComplete(){
        int ordernumber = sc.nextInt();

        System.out.println("주문이 완료되었습니다.");
        System.out.println("선택하신 금액은" +  "입니다");

    }

}