package sample.cafekiosk.unit.beverage;

/**
 * @author : kimkyeongjun
 * @packageName : sample.cafekiosk.unit
 * @fileName : Americano
 * @Date : 4/2/24
 * @description :
 */
public class Americano implements Beverage {
    @Override
    public String getName() {
        return "아메리카노";
    }

    @Override
    public int getPrice() {
        return 4000;
    }
}
