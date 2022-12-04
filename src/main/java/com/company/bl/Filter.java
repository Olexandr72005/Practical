package com.company.bl;

import com.company.da.Car;
import com.company.da.CreateCars;
import com.company.ui.Colors;
import com.company.ui.Menu;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Клас для фільтрації даних
 */
public class Filter {

  /**
   * Змінна типу приводу
   */
  static String typeDrive;

  /**
   * Фільтрування по типу приводу
   * @throws IOException вийняток
   */
  public static void filterTypeDrive() throws IOException {
    File file = new File("data\\cars\\cars.json");
    if(!file.exists()){
      CreateCars createCars = new CreateCars();
      createCars.createCars();
    }
    Scanner s = new Scanner(System.in, Charset.forName(
        System.getProperty("os.name").toLowerCase().startsWith("win") ? "Windows-1251" : "UTF-8"));

    List<Car> cars = ParseToArray.parseToArray();
    System.out.println("1. Переднiй\n2. Заднiй\n3. Повний");
    System.out.print("Оберiть тип приводу: ");
    String input = s.nextLine();
    switch (input) {
      case "1":
        typeDrive = "Переднiй";
        break;
      case "2":
        typeDrive = "Заднiй";
        break;
      case "3":
        typeDrive = "Повний";
        break;
      default:
        System.out.println(Colors.RED + "Невірнi данi!!!");
        Menu.menuMain();
        break;
    }

    cars = cars.stream()
        .filter(element -> element.getTypeDrive().equals(typeDrive))
        .collect(Collectors.toList());
    System.out.println(cars.toString().replaceAll("\\[", "").replaceAll("]", ""));

    Menu.menuMain();

  }
}


