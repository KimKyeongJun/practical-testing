package sample.cafekiosk.unit.order;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import sample.cafekiosk.unit.beverage.Beverage;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : kimkyeongjun
 * @packageName : sample.cafekiosk.unit.order
 * @fileName : Order
 * @Date : 4/2/24
 * @description :
 */

@RequiredArgsConstructor
@Getter
public class Order {

    private final LocalDateTime orderDateTime;

    private final List<Beverage> beverages;
}
