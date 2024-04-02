package sample.cafekiosk.unit;

import lombok.Getter;
import sample.cafekiosk.unit.beverage.Beverage;
import sample.cafekiosk.unit.order.Order;

import java.time.LocalDateTime;
import java.time.LocalTime;
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

 public static final LocalTime SHOP_OPEN_TIME = LocalTime.of(10, 0);

    public static final LocalTime SHOP_CLOSE_TIME = LocalTime.of(22, 0);

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
  return beverages.stream()
    .mapToInt(Beverage::getPrice)
    .sum();
 }

 public Order createOrder() {
  LocalDateTime currentDateTime = LocalDateTime.now();

  LocalTime currentTime = currentDateTime.toLocalTime();

  if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
   throw new IllegalStateException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
  }
  return new Order(currentDateTime, beverages);
 }

 public Order createOrder(LocalDateTime currentDateTime) {
  LocalTime currentTime = currentDateTime.toLocalTime();

  if(currentTime.isBefore(SHOP_OPEN_TIME) || currentTime.isAfter(SHOP_CLOSE_TIME)) {
   throw new IllegalStateException("주문 시간이 아닙니다. 관리자에게 문의하세요.");
  }
  return new Order(currentDateTime, beverages);
 }
}
