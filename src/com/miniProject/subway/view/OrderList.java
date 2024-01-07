package com.miniProject.subway.view;

import com.miniProject.subway.member.MemberDTO;

import java.util.ArrayList;
import java.util.List;

public class OrderList {    // TODO :: 메뉴 어레이리스트

    private List<MenuDTO> orderList;

    public OrderList() {
        orderList = new ArrayList<>();
    }

    public List<MenuDTO> getOrderList(){
        return orderList;
    }

    public void addOrderList(MenuDTO menuDTO) {
        this.orderList = orderList;
    }

    public void clearOrderList() {
        orderList.clear();
    }

    public int totalPrice() {
        int total = 0;
        for (MenuDTO order : orderList) {
            total += order.getPrice();
        }
        return total;
    }
}
