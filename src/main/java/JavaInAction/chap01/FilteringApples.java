package JavaInAction.chap01;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

  private static final String GREEN = "green";

  public static void main(String[] args) {

    List<Apple> inventory = Arrays.asList(new Apple(79, "red"), new Apple(81, "red"), new Apple(79, "green"),
        new Apple(81, "green"), new Apple(151, "green"), new Apple(149, "green"), new Apple(151, "red"),
        new Apple(149, "red"));
//        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
//        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);

    /* isGreenApple, isHeavyApple 처럼 한번만 사용할 조건을 따로 메서드 지정하기 귀찮으니께, 익명 함수(람다) 를 사용 */
    List<Apple> greenApples = filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
    List<Apple> heavyApples = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
    List<Apple> redAndLightApples = filterApples(inventory, a -> a.getWeight() < 80 && a.color.equals("red"));

//        long start = System.currentTimeMillis();
//        List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
//        long finish = System.currentTimeMillis();
//
//        long start1 = System.currentTimeMillis();
//        List<Apple> heavyApples1 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
//        long finish1 = System.currentTimeMillis();

    System.out.println("greenApples = " + greenApples);
    System.out.println("heavyApples = " + heavyApples);
    System.out.println("redAndLightApples = " + redAndLightApples);

//        System.out.println("time : " + (finish - start) + "ms");
//
//        System.out.println(heavyApples1);
//        System.out.println("time : " + (finish1 - start1) + "ms");
  }

  // java 8 이전
  public static List<Apple> filterGreenApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (GREEN.equals(apple.getColor())) {
        result.add(apple);
      }
    }
    return result;
  }

  // java 8 이전
  public static List<Apple> filterHeavyApples(List<Apple> inventory) {
    List<Apple> result = new ArrayList<>();

    for (Apple apple : inventory) {
      if (apple.getWeight() > 150) {
        result.add(apple);
      }
    }
    return result;
  }

  // java 8
  public static boolean isGreenApple(Apple apple) {
    return GREEN.equals(apple.getColor());
  }

  // java 8
  public static boolean isHeavyApple(Apple apple) {
    return apple.getWeight() > 150;
  }

  static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
    List<Apple> result = new ArrayList<>();
    for (Apple apple : inventory) {
      if (p.test(apple)) {
        result.add(apple);
      }
    }
    return result;
  }

  public interface Predicate<T> {

    boolean test(T t);
  }

  @Data
  @AllArgsConstructor
  public static class Apple {

    private int weight = 0;
    private String color = "";
  }
}
