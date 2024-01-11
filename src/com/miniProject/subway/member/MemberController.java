package com.miniProject.subway.member;

import com.miniProject.subway.view.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MemberController{                    // login여부를 바꾸기 위해 Main클래스를 상속함

    ArrayList<MemberDTO> memberDTO= new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    /** 로그인 창 메소드 */
    public void memberLogin(){

        membercheck :
        while(true){
            System.out.println("=================================================================================");
            System.out.println("                            ▷ 아이디와 비밀번호를 입력해주세요    ");
            System.out.println("=================================================================================");
            System.out.println("                            ▷ ID :                                              ");
            String id = sc.nextLine();
            if(id.equals("")){
                System.out.println("                            ▶ 아이디를 입력해주세요                            ");
                continue;
            }


            System.out.println("                            ▶ Password :                                       ");
            String pwd = sc.nextLine();

            for(int i = 0 ; i < memberDTO.size(); i++){

                if(memberDTO.get(i).getid().equals(id))
                {
                    if(memberDTO.get(i).getPwd().equals(pwd))
                    {
                        System.out.println("=================================================================================");
                        System.out.println("                            ▷ 로그인되었습니다.            ");   //id, pwd 일치할시 로그인
                        System.out.println("=================================================================================");
                        Main.login = true;
                        return;
                    }
                }
            }

            incorrect :
            while(true) {
                System.out.println("=================================================================================");
                System.out.println("                            ▶ 회원정보가 일치하지 않습니다.                          ");
                System.out.println("                            ▷ 회원가입하시겠습니까?                                 ");
                System.out.println("                            ▷ 1. 예                                              ");
                System.out.println("                            ▷ 2. 아니오(로그인화면으로 돌아갑니다.)                    ");
                System.out.println("                                                                                 ");
                System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
                System.out.println("=================================================================================");

                try {
                    int registerSelect = sc.nextInt();

                    switch (registerSelect) {
                        case 1:
                            sc.nextLine();
                            memberRegister();
                            return;
                        case 2:
                            sc.nextLine();
                            break incorrect;
                        case 0:
                            System.out.println("                            ▶ 이전 화면으로 돌아갑니다.     ");
                            return;
                        default:
                            System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요. ");
                            continue;
                    }
                }catch(InputMismatchException e)
                {
                    System.out.println("                            ▶ 잘못 입력하였습니다. 다시 입력해주세요.             ");
                    sc.nextLine();
                }
            }

            //continue membercheck;
        }


    }

    /** 회원가입 메소드 */
    public void memberRegister(){
        System.out.println("=================================================================================");
        System.out.println("                            ▷ 회원 가입을 진행합니다.       ");
        String id = "";

        while(true)
        {
            System.out.println("                            ▷ ID를 입력해주세요.          ");
            System.out.println("                                    ");
            System.out.println("                            ▶ 0. 이전 메뉴로              ");
            System.out.println("=================================================================================");


            id = sc.nextLine();

            if(id.equals("0"))
            {
                System.out.println("=================================================================================");
                System.out.println("                            ▶ 이전 화면으로 돌아갑니다.     ");
                System.out.println("=================================================================================");
                return;
            }
            if(id.equals(""))
            {
                System.out.println("                            ▷ ID가 입력되지 않았습니다.       ");
                continue;
            }
            for(int i = 0; i < memberDTO.size(); i++){
                if(memberDTO.get(i).getid().equals(id)){
                    System.out.println("=================================================================================");
                    System.out.println("                            ▶ 이미 가입된 ID입니다. 다시 입력해주세요.                 ");
                    System.out.println("                                                                                 ");
                    System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
                    System.out.println("=================================================================================");

                    String alreadyId = sc.nextLine();
                    id = alreadyId;

                    if(alreadyId.equals("0"))
                    {
                        System.out.println("=================================================================================");
                        System.out.println("                            ▶ 이전 화면으로 돌아갑니다.                              ");
                        System.out.println("=================================================================================");
                        return;
                    }

                    continue;
                }
            }
            break;
        }

        System.out.println("                            ▷ 패스워드를 입력해주세요.      ");
        String pwd = sc.nextLine();
        System.out.println("                            ▷ 이름을 입력해주세요.          ");
        String name = sc.nextLine();
        System.out.println("                            ▷ 이메일을 입력해주세요.          ");
        String email = sc.nextLine();
        System.out.println("                            ▷ 연락처를 입력해주세요.          ");
        String phone= sc.nextLine();

        memberDTO.add(new MemberDTO(id, pwd, name, email, phone));



        System.out.println("                            ▷ 회원가입이 완료되었습니다.      ");
        System.out.println("=================================================================================");


        return;
    }

    public void memberList(){

        for(int i = 0; i < memberDTO.size(); i++){
            memberDTO.get(i).information();
            System.out.println("----------------------------------");
        }
    }
}
