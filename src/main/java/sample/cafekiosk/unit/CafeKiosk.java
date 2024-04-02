package sample.cafekiosk.unit;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : kimkyeongjun
 * @packageName : sample.cafekiosk.unit
 * @fileName : CafeKiosk
 * @Date : 4/2/24
 * @description : 음료를 받거나 삭제하거나 등 여러 조작을 할 수 있는 클래스
 */

@Getter
public class CafeKiosk {

 private final List<Beverage> beverages = new ArrayList<>();
 public void add(Beverage beverage) {
   beverages.add(beverage);
 }

 public void add(Beverage beverage, int count) {

  if(count <= 0) {
   throw new IllegalArgumentException("음료는 1잔 이상 주문하실 수 있습니다.");
  }
    for(int i = 0; i < count; i++) {
     beverages.add(beverage);
    }
 }

 public void remove(Beverage beverage) {
  beverages.remove(beverage);
 }

 public void clear() {
  beverages.clear();
 }

 public int calculateTotalPrice() {
  int totalPrice = 0;
  for(Beverage beverage : beverages) {
   totalPrice += beverage.getPrice();
  }
  return totalPrice;
 }

 public Order createOrder() {
  return new Order(LocalDateTime.now(), beverages);
 }
}
