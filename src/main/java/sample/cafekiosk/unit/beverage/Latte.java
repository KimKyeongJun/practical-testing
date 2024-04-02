package sample.cafekiosk.unit.beverage;

/**
 * @author : kimkyeongjun
 * @packageName : sample.cafekiosk.unit
 * @fileName : Latte
 * @Date : 4/2/24
 * @description :
 */
public class Latte implements Beverage {
    @Override
    public String getName() {
        return "라떼";
    }

    @Override
    public int getPrice() {
        return 4500;
    }
}
