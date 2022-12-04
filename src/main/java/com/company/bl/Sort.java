package com.company.bl;

import com.company.da.Car;
import com.company.da.CreateCars;
import com.company.ui.Colors;
import com.company.ui.Menu;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Клас сортування
 */
public class Sort {

  /**
   * Сортує автомобілі по максимальній швидкості
   * @throws IOException вийняток
   */
  public static void sortMaxSpeed() throws IOException {
    File file = new File("data\\cars\\cars.json");
    if(!file.exists()){
      CreateCars createCars = new CreateCars();
      createCars.createCars();
    }
    Scanner s = new Scanner(System.in, Charset.forName(System.getProperty("os.name").toLowerCase().startsWith("win") ? "Windows-1251":"UTF-8"));
    List<Car> cars = ParseToArray.parseToArray();
    System.out.println("1. Сортувати по зростаню\n2. Сортувати по спаданю");
    System.out.print("Оберіть вид сортування: ");
    String input = s.nextLine();
    switch (input){
      case "1":
        cars = cars.stream()
            .sorted(Comparator.comparingInt(Car::getMaxSpeed))
            .collect(Collectors.toList());
        System.out.println(cars.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
        break;
      case "2":
        cars = cars.stream()
            .sorted(Comparator.comparingInt(Car::getMaxSpeed).reversed())
            .collect(Collectors.toList());
        System.out.println(cars.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
        break;
      default:
        System.out.println(Colors.RED+"Невірні дані!!!");
        break;
    }
    Menu.menuMain();
  }

  /**
   * Сортує автомобілі по масі
   * @throws IOException вийняток
   */
  public static void sortMass() throws IOException {
    File file = new File("data\\cars\\cars.json");
    if(!file.exists()){
      CreateCars createCars = new CreateCars();
      createCars.createCars();
    }
    Scanner s = new Scanner(System.in, Charset.forName(System.getProperty("os.name").toLowerCase().startsWith("win") ? "Windows-1251":"UTF-8"));
    List<Car> cars = ParseToArray.parseToArray();
    System.out.println("1. Сортувати по зростаню\n2. Сортувати по спаданю");
    System.out.print("Оберiть вид сортування: ");
    String input = s.nextLine();
    switch (input){
      case "1":
        cars = cars.stream()
            .sorted(Comparator.comparingInt(Car::getMass))
            .collect(Collectors.toList());
        System.out.println(cars.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
        break;
      case "2":
        cars = cars.stream()
            .sorted(Comparator.comparingInt(Car::getMass).reversed())
            .collect(Collectors.toList());
        System.out.println(cars.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
        break;
      default:
        System.out.println(Colors.RED+"Невiрні данi!!!");
        break;
    }
    Menu.menuMain();
  }

}
