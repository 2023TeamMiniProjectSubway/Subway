package com.miniProject.subway.order;

import com.miniProject.subway.menu.Food;


import java.util.ArrayList;
import java.util.List;

public class OrderController {

    private List<Food> complete;    // 주문 성공
    private int ChoiceNum;          // 주문 취소

    public OrderController() {
        complete = new ArrayList<>();
        ChoiceNum = 1;
    }

    public List<Food> getComplete() {
        return complete;
    }

    public int getChoiceNum() { // ChoiceNum을 리턴해줌
        return ChoiceNum;
    }

    public void setChoiceNum(int choiceNum) {
        this.ChoiceNum = choiceNum;
    }

    public void completeMenu(Food menu) {
        complete.add(menu);
    }

    public void cancelMenu(){
        complete.clear();
    }


}
