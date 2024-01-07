package com.miniProject.subway.member;

import com.miniProject.subway.view.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController extends  Main{                    // login여부를 바꾸기 위해 Main클래스를 상속함

    ArrayList<MemberDTO> memberDTO= new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void memberLogin(){

        membercheck :
        while(true){
            System.out.println("=====================================");
            System.out.println("     ▷ 아이디와 비밀번호를 입력해주세요    ");
            System.out.println("=====================================");
            System.out.println("             ▷ ID :                   ");
            String id = sc.nextLine();

            System.out.println("             ▶ Password :             ");
            String pwd = sc.nextLine();

            for(int i = 0 ; i < memberDTO.size(); i++){

                if(memberDTO.get(i).getid().equals(id))              //입력한 id와 같은 id가 회원목록에 들어있다면
                {
                    if(memberDTO.get(i).getPwd().equals(pwd))        //비밀번호 같은지 검사
                    {
                        System.out.println("=====================================");
                        System.out.println("          ▷ 로그인되었습니다.            ");   //id, pwd 일치할시 로그인
                        System.out.println("=====================================");
                        login = true;                               //로그인 되어있음
                        return;
                    }
                }
            }
            System.out.println("=====================================");
            System.out.println("    ▶ 회원정보가 일치하지 않습니다.       ");
            System.out.println("    ▷ 회원가입하시겠습니까?              ");
            System.out.println("    ▷ 1. 예                          ");
            System.out.println("    ▷ 2. 아니오(로그인화면으로 돌아갑니다.)");
            System.out.println("                                     ");
            System.out.println("    ▶ 0. 이전 메뉴로                   ");
            System.out.println("=====================================");

            int registerSelect = sc.nextInt();

            switch(registerSelect){
                case 1 :                            //회원가입
                    memberRegister();
                    return;
                case 2 :                            //로그인화면
                    break;
                case 0 :
                    System.out.println("      ▶ 이전 화면으로 돌아갑니다.     ");
                    return;
            }
            continue membercheck;
        }


    }

    public void memberRegister(){
        System.out.println("=====================================");
        System.out.println("         ▷ 회원 가입을 진행합니다.       ");
        String id = "";

        while(true)
        {
            System.out.println("         ▷ ID를 입력해주세요.          ");
            System.out.println("                                    ");
            System.out.println("         ▶ 0. 이전 메뉴로              ");
            System.out.println("=====================================");

            //sc.nextLine();
            id = sc.nextLine();
            // !! ** 로그인 시도 후 회원가입을 하려할 때 자꾸 nextLine()이 공백으로 되고 바로 비밀번호로 넘어감 **
            // sc.nextLine();을 쓰면 로그인 후 회원가입 메뉴로 들어올때 비밀번호로 바로 넘어가지지 않지만
            // 대신 바로 회원가입 메뉴로 들어올때 두번 쳐야함....

            if(id.equals("0"))
            {
                System.out.println("=====================================");
                System.out.println("        ▶ 이전 화면으로 돌아갑니다.     ");
                System.out.println("=====================================");
                return;
            }
            if(id.equals(""))
            {
                System.out.println("=====================================");
                System.out.println("       ▷ 아이디를 입력하지 않았습니다.    ");
                System.out.println("       ▷ 다시 입력해 주세요.            ");
                System.out.println("=====================================");
                continue;
            }
            for(int i = 0; i < memberDTO.size(); i++){                                   //이미 가입된 ID 확인
                if(memberDTO.get(i).getid().equals(id)){
                    System.out.println("=====================================");
                    System.out.println("  ▶ 이미 가입된 ID입니다. 다시 입력해주세요. ");
                    System.out.println("                                      ");
                    System.out.println("  ▶ 0. 이전 메뉴로                      ");
                    System.out.println("=====================================");

                    String alreadyId = sc.nextLine();
                    id = alreadyId;                     //아이디에 새로쓴 아이디 엎기

                    if(alreadyId.equals("0"))
                    {
                        System.out.println("=====================================");
                        System.out.println("         ▶ 이전 화면으로 돌아갑니다.     ");
                        System.out.println("=====================================");
                        return;
                    }

                    continue;
                }
            }
            break;
        }

        System.out.println("         ▷ 패스워드를 입력해주세요.      ");
        String pwd = sc.nextLine();
        System.out.println("         ▷ 이름을 입력해주세요.          ");
        String name = sc.nextLine();
        System.out.println("         ▷ 이메일을 입력해주세요.          ");
        String email = sc.nextLine();
        System.out.println("         ▷ 연락처를 입력해주세요.          ");
        String phone= sc.nextLine();

        memberDTO.add(new MemberDTO(id, pwd, name, email, phone));

        //확인용
        memberDTO.get(id.indexOf(id)).information();

        System.out.println("        ▷ 회원가입이 완료되었습니다.      ");
        System.out.println("=====================================");


        memberList();
        return;
    }

    public void memberList(){
        // !! ** 멤버 전체 리스트를 띄우고싶은데 Main 클래스에서 MC 클래스를 부르면 StackOverFlow Exception(무한호출) 발생 (MC가 Main 클래스를 상속받고있기때문 -> 로그인여부(login) 변수때문에)
        // 그래서 Main 클래스 내부의 메소드에서 선언하려하면 new 연산자때문에 객체가 새로 생성돼서 회원가입한 정보가 담긴 객체가 아닌 새 객체를 불러옴
        // 어쨌든 MC 클래스 내부 메소드에서 전체 멤버리스트를 조회하는 메소드를 작성한다고 해도 Main 클래스에 MC클래스를 불러야하는 상황 발생... 혹은 새 객체가 만들어지거나...

        for(int i = 0; i < memberDTO.size(); i++){
            memberDTO.get(i).information();
        }
    }
}
