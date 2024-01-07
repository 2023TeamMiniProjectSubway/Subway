//package com.miniProject.subway.order;
//
//import com.miniProject.subway.menu.Food;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderController {
//
//    private List<Food> complete;    // 주문 성공
//    private int ChoiceNum;          // 주문 대기 번호 (피드백 : 주문이 시작되기 전에, choiceNum을 초기화 해놓고. while(주문) 끝에 1을 더해주면)
//
//    public OrderController() {
//        complete = new ArrayList<>();
//        ChoiceNum = 1;
//    }
//
//    public List<Food> getComplete() {
//        return complete;
//    }
//
//    public int getChoiceNum() { // ChoiceNum을 리턴해줌
//        return ChoiceNum;
//    }
//
//    public void setChoiceNum(int choiceNum) {
//        this.ChoiceNum = choiceNum;
//    }
//
//    public void completeMenu(Food menu) {
//        complete.add(menu);
//    }
//
//    public void cancelMenu(){
//        complete.clear();
//    }
//
//
//}
