package com.miniProject.subway.view;

import com.miniProject.subway.member.MemberController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {                             //메뉴화면

    public static boolean login = false;
    MemberController mc = new MemberController();


    public void MainMenu() {

        OrderMain order = new OrderMain();
        Scanner sc = new Scanner(System.in);
        int mainMenu = 0;

        System.out.println("                       ☆★☆★☆★서브웨이에 어서오세요☆★☆★☆★                            ");

        //메인 메뉴
        main :
        while(true){
            System.out.println("=================================================================================");
            System.out.println("                              ▷  1. 주문하기                                      ");
            System.out.println("                                                                                 ");
            System.out.println("                              ▷  0. 종료                                          ");
            System.out.println("=================================================================================");

            try {
                mainMenu = sc.nextInt();


                switch (mainMenu) {
                    case 1: {
                        sc.nextLine();
                        while (login == false)                   //로그인 안되어있으면
                        {
                            loginMenu();                       //loginMenu()로 이동
                            break;
                        }
                        if (login == true)                      //로그인 되어있으면
                        {
                            System.out.println("                            ▷ 주문을 진행합니다.                    ");
                            order.orderMenu();                  //주문 메뉴로 이동
                        }
                    }
                    break;
                    case 0:                                //try-catch 문을 쓰고 문자열입력해서 다시 MainMenu()로 돌아온후 0을 다시 입력하면 숫자를 다시 입력하라고(즉 MisMatchException 발생) 뜸
//                        System.out.println(mainMenu);
                        sc.nextLine();
                        System.out.println("                            ▶ 메뉴를 종료합니다.                         ");
                        break main;                                 //메뉴 종료
                    case 2:
                        System.out.println("                            ▷ 회원 목록을 조회합니다.                    ");
                        callMemberList();
                        break;
                    case 9:
                        sc.nextLine();
                        order.orderMenu();
                        break;
                    default:
                        sc.nextLine();
                        System.out.println(mainMenu);
                        System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요.     ");
                        // 왜자꾸 3?이 넘어오는가
                        break;
                }
            }catch(InputMismatchException e)
            {
                System.out.println(" 잘못 입력하였습니다. 다시 입력해주세요.");
                sc.nextLine();

            }

        }


    }

    public void loginMenu(){

        //MemberController mc = new MemberController();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 주문은 로그인 후 이용 가능합니다                        ");
            System.out.println("                            ▷  1. 로그인                                          ");
            System.out.println("                            ▷  2. 회원가입                                        ");
            System.out.println("                                                                                ");
            System.out.println("                            ▶  0. 이전 메뉴로                                     ");
            System.out.println("=================================================================================");

            try {
                int loginMenu = sc.nextInt();

                switch (loginMenu) {
                    case 1:                    // 로그인
                        mc.memberLogin();
                        return;
                    case 2:                    // 회원가입
                        mc.memberRegister();
                        break;
                    case 0:                    // 로그인화면 종료
                        System.out.println("                            ▶ 메인화면으로 돌아갑니다.                    ");
                        return;
                    default:
                        System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요.  ");
                        break;
                }

            }catch(InputMismatchException e)
            {
                System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.          ");
                sc.nextLine();
            }
        }
    }

    public void callMemberList(){

        mc.memberList();
//        for(int i = 0; i < memberDTO.size(); i++){
//            memberDTO.get(i).information();
//        }
    }


}
