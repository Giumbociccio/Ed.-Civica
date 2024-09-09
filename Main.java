import java.util.*;
public class Main {
  public static void main(String[] args) {
    List<Double> numeri = new ArrayList<Double>();
    numeri.add(1.3);
    numeri.add(16.4);
    double somma = 0;
    for(int i = 0; i < numeri.size(); i++){
      somma += numeri.get(i);
    }
    System.out.println(numeri.size());

    Auto<String> a1 = new Auto("benzina", 2000);
  }

}