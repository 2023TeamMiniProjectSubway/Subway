package com.miniProject.subway.member;

import com.miniProject.subway.view.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController{                    // login여부를 바꾸기 위해 Main클래스를 상속함

    ArrayList<MemberDTO> memberDTO= new ArrayList<>();
    Scanner sc = new Scanner(System.in);

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

            //** 그냥 로그인 들어오면 상관없는데 로그인 실패 후 다시 돌아오면 ID=""이 돼서 입력할수없음
            System.out.println("                            ▶ Password :                                       ");
            String pwd = sc.nextLine();

            for(int i = 0 ; i < memberDTO.size(); i++){

                if(memberDTO.get(i).getid().equals(id))              //입력한 id와 같은 id가 회원목록에 들어있다면
                {
                    if(memberDTO.get(i).getPwd().equals(pwd))        //비밀번호 같은지 검사
                    {
                        System.out.println("=================================================================================");
                        System.out.println("                            ▷ 로그인되었습니다.            ");   //id, pwd 일치할시 로그인
                        System.out.println("=================================================================================");
                        Main.login = true;                               //로그인 되어있음
                        return;
                    }
                }
            }

            incorrect :
            while(true){
                System.out.println("=================================================================================");
                System.out.println("                            ▶ 회원정보가 일치하지 않습니다.                          ");
                System.out.println("                            ▷ 회원가입하시겠습니까?                                 ");
                System.out.println("                            ▷ 1. 예                                              ");
                System.out.println("                            ▷ 2. 아니오(로그인화면으로 돌아갑니다.)                    ");
                System.out.println("                                                                                 ");
                System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
                System.out.println("=================================================================================");

                int registerSelect = sc.nextInt();

                switch(registerSelect){
                    case 1 :                            //회원가입
                        sc.nextLine();
                        memberRegister();
                        return;
                    case 2 :                            //로그인화면
                        sc.nextLine();
                        break incorrect;
                    case 0 :
                        System.out.println("                            ▶ 이전 화면으로 돌아갑니다.     ");
                        return;
                    default:
                        System.out.println("                            ▶ 번호를 잘못 입력하였습니다. 다시 입력해주세요. ");
                        continue;
                }
            }

            //continue membercheck;
        }


    }

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

            //sc.nextLine();
            id = sc.nextLine();
            // !! ** 로그인 시도 후 회원가입을 하려할 때 자꾸 nextLine()이 공백으로 되고 바로 비밀번호로 넘어감 **
            // sc.nextLine();을 쓰면 로그인 후 회원가입 메뉴로 들어올때 비밀번호로 바로 넘어가지지 않지만
            // 대신 바로 회원가입 메뉴로 들어올때 두번 쳐야함....

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
            for(int i = 0; i < memberDTO.size(); i++){                                   //이미 가입된 ID 확인
                if(memberDTO.get(i).getid().equals(id)){
                    System.out.println("=================================================================================");
                    System.out.println("                            ▶ 이미 가입된 ID입니다. 다시 입력해주세요.                 ");
                    System.out.println("                                                                                 ");
                    System.out.println("                            ▶ 0. 이전 메뉴로                                       ");
                    System.out.println("=================================================================================");

                    String alreadyId = sc.nextLine();
                    id = alreadyId;                     //아이디에 새로쓴 아이디 엎기

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

        //확인용
//        memberDTO.get(id.indexOf(id)).information();

        System.out.println("                            ▷ 회원가입이 완료되었습니다.      ");
        System.out.println("=================================================================================");


        //memberList();
        return;
    }

    public void memberList(){

        for(int i = 0; i < memberDTO.size(); i++){
            memberDTO.get(i).information();
            System.out.println("----------------------------------");
        }
    }
}
