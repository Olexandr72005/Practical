package com.company;

import com.company.da.CreateCars;
import com.company.ui.Colors;
import com.company.ui.Menu;
import java.io.IOException;

/**
 * @author Олександр Соляник
 * Головний клас
 */
public class Main {

  /**
   * Метод, який є початковою точкою роботи програми
   * @param args значення
   * @throws IOException вийняток
   */
  public static void main(String[] args) throws IOException {
    System.out.println(Colors.GREEN + "---------------------------");
    System.out.println("----Автомобiльний салон----");
    System.out.println("---------------------------" + Colors.RESET);
    Menu.menuStart();
  }
}
