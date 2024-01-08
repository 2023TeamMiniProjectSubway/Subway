package com.miniProject.subway.order;

import com.miniProject.subway.menu.MenuDTO;
import java.util.ArrayList;
import java.util.Scanner;


public class OrderController {

    ArrayList<MenuDTO> menuDTO= new ArrayList<>();
    ArrayList ordermenu = new ArrayList();
    ArrayList orderprice = new ArrayList();
    Scanner sc = new Scanner(System.in);

    public OrderController () {
        menuDTO.add(new MenuDTO("에그마요", 2000,"부드러운 달걀과 고소한 마요네즈가 만나 더 부드러운 스테디셀러"));
        menuDTO.add(new MenuDTO("이탈리안 비엠티", 2000,"페퍼로니, 살라미 그리고 햄이 만들어내는 전세계가 사랑하는 베스트셀러"));
        menuDTO.add(new MenuDTO("비엘티", 2000,"오리지널 아메리칸 스타일 베이컨의 풍미와 바삭함 그대로~"));
        menuDTO.add(new MenuDTO("햄", 2000,"풍부한 햄이 만들어내는 담백함을 입 안 가득 즐겨보세요!"));
        menuDTO.add(new MenuDTO("참치", 2000,"남녀노소 누구나 좋아하는 담백한 참치와 고소한 마요네즈의 완벽한 조화"));

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
                    return;
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
        System.out.println(choice + "번째 메뉴 가격 : " + menuDTO.get(choice).getPrice() + "원");

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

        System.out.println("현재 총 가격 : " + sum);
        //-----------------------------------------------

    }
}
