package com.miniProject.subway.main;

import com.miniProject.subway.member.MemberController;
import com.miniProject.subway.member.MemberDTO;
import com.miniProject.subway.menu.Menu;
import com.miniProject.subway.order.OrderController;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {                             //메뉴화면

    public static  boolean login = false;

    public void MainMenu() {

        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);

        System.out.println("☆★☆★☆★서브웨이에 어서오세요☆★☆★☆★");

        //메인 메뉴
        main :
        while(true){
            System.out.println("=====================================");
            System.out.println("           ▷  1. 주문하기            ");
            System.out.println("                                   ");
            System.out.println("           ▷  0. 종료               ");
            System.out.println("=====================================");

            int mainMenu = sc.nextInt();

            switch(mainMenu){
                case 1 :
                    {
                        while(login == false)                   //로그인 안되어있으면
                        {
                            loginMenu();                       //loginMenu()로 이동
                            break;
                        }
                        if(login == true)                              //로그인 되어있으면
                        {
                            System.out.println("         ▷ 주문을 진행합니다.");
                            menu.ShowFirst(); //주문 메뉴로 이동
                            break;
                        }
                    }
                    break;
                case 0 :
                    System.out.println("         ▶ 메뉴를 종료합니다.");
                    break main;                     //메뉴 종료
                case 2 :
                    System.out.println("회원 목록을 조회합니다.");
                    callMemberList();
                    break;

            }
        }


    }

    public void loginMenu(){

        MemberController mc = new MemberController();
        Scanner sc = new Scanner(System.in);

        while(true)
        {
            System.out.println("=====================================");
            System.out.println("     ▷ 주문은 로그인 후 이용 가능합니다    ");
            System.out.println("           ▷  1. 로그인              ");
            System.out.println("           ▷  2. 회원가입            ");
            System.out.println("                                   ");
            System.out.println("           ▶  0. 이전 메뉴로          ");
            System.out.println("=====================================");

            int loginMenu = sc.nextInt();

            switch(loginMenu){
                case 1 :                    // 로그인
                    mc.memberLogin();
                    return;
                case 2 :                    // 회원가입
                    mc.memberRegister();
                    break;
                case 0 :                    // 로그인화면 종료
                    System.out.println("메인 화면으로 돌아갑니다.");
                    return;
            }

        }
    }

    public void callMemberList(){
        ArrayList<MemberDTO> memberDTO = new ArrayList<>();

        for(int i = 0; i < memberDTO.size(); i++){
            memberDTO.get(i).information();
        }
    }

}
