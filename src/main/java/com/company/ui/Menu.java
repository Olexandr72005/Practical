package com.company.ui;

import com.company.bl.Filter;
import com.company.bl.Sort;
import com.company.da.AutoSalon;
import com.company.da.CreateCars;
import com.company.da.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Клас меню
 */
public class Menu {

  /**
   * Зчитує те, що ввів користувач
   */
  public static Scanner scanner1 = new Scanner(System.in, Charset.forName(System.getProperty("os.name").toLowerCase().startsWith("win") ? "Windows-1251":"UTF-8"));
  /**
   * Змінна, яка зберігає те, що ввів користувач
   */
  public static String input = null;
  /**
   * Змінна консолі
   */
  public static Console cnsl = System.console();
  /**
   * Логін користувача
   */
  public static String login;
  /**
   * Це зміна, в якій буде зберігатись пароль користувача
   */
  public static char[] readPassword;
  /**
   * Змінна перевірки
   */
  public static boolean check;
  /**
   * Зберігає шлях до файлу
   */
  public static final String PATH_TO_FILE = "data\\cars\\cars.json";

  /**
   * Початкове меню
   * @throws IOException вийняток
   */
  public static void menuStart() throws IOException {
    System.out.println("\n"+Colors.BLUE + "---------------------------");
    System.out.println("------Початкове меню-------");
    System.out.println("---------------------------" + Colors.RESET);
    System.out.println("1. Авторизацiя");
    System.out.println("2. Реєстрацiя");
    System.out.println("3. Список автомобiлiв");
    System.out.println("4. Вихiд");
    System.out.print("Оберiть варiант: ");
    input = scanner1.nextLine();
    switch (input){
      case "1":
        if (cnsl == null) {
          System.out.println(Colors.RED+"Немає доступу до консолi");
          break;
        }
        System.out.print("Введiть логiн: ");
        login = scanner1.nextLine();
        if (login.length() >= 2 && login.length() <= 25){
          readPassword = cnsl.readPassword("Введiть пароль: ");
          if(readPassword.length <= 25 && readPassword.length >= 2){
            User user = new User(login, new String(readPassword));
            check = user.Authorization();
            if (check) {
              System.out.println(Colors.GREEN+"Ви успiшно ввiйшли в акаунт!!!");
              menuMain();
            } else {
              System.out.println(Colors.RED+"Невiрний логiн або пароль!!!");
              menuStart();
            }
          } else {
            System.out.println(Colors.RED+"Довжина паролю повина бути вiд 2 до 25 символiв!!!");
            menuStart();
          }
        } else {
          System.out.println(Colors.RED+"Довжина логiну повина бути вiд 2 до 25 символiв!!!");
          menuStart();
        }

        break;
      case "2":
        if (cnsl == null) {
          System.out.println(Colors.RED+"Немає доступу до консолi");
          break;
        }
        System.out.print("Введiть новий логiн: ");
        login = scanner1.nextLine();
        if (login.length() >= 4 && login.length() <= 20){
          readPassword = cnsl.readPassword("Введiть новий пароль: ");
          if(readPassword.length <= 20 && readPassword.length >= 4){
            User newUser = new User(login, new String(readPassword));
            check = newUser.Registration();
            if (check) {
              System.out.println(Colors.GREEN+"Ви успiшно зареєструвалися!!!");
              menuStart();
            } else {
              System.out.println(Colors.RED+"Такий акаунт уже iснує!!!");
              menuStart();
            }
          } else {
            System.out.println(Colors.RED+"Довжина паролю повинна бути вiд 4 до 20 символiв!!!");
            menuStart();
          }

        } else {
          System.out.println(Colors.RED+"Довжина логiну повинна бути вiд 4 до 20 символiв!!!");
          menuStart();
        }
        break;
      case "3":
        CreateCars createCars = new CreateCars();
        File file = new File(PATH_TO_FILE);
        if(!file.exists()){
          createCars.createCars();
        }
        createCars.readFile();
        menuStart();
        break;
      case "4":
        System.exit(0);
      default:
        System.out.println(Colors.RED+"Невiрна відповiдь!!! Спробуйте ще раз!!!");
        menuStart();
        break;
    }

  }
  /**
   * Головне меню
   * @throws IOException вийняток
   */
  public static void menuMain() throws IOException {
    System.out.println(Colors.BLUE + "---------------------------");
    System.out.println("-------Головне меню--------");
    System.out.println("---------------------------" + Colors.RESET);

    System.out.println("1. Список автомобiлiв");
    System.out.println("2. Сортувати автомобiлi по максимальнiй швидкостi");
    System.out.println("3. Сортувати автомобiлi по вазi(кг)");
    System.out.println("4. Фiльтрувати автомобiлi по типу приводу");
    System.out.println("5. Вихiд з акаунту");
    System.out.println("6. Вихiд");
    System.out.print("Оберiть варiант: ");
    input = scanner1.nextLine();
    switch (input){
      case "1":
        CreateCars createCars = new CreateCars();
        File file = new File(PATH_TO_FILE);
        if(!file.exists()){
          createCars.createCars();
        }
        createCars.readFile();
        menuMain();
        break;
      case "2":
        Sort.sortMaxSpeed();
        break;
      case "3":
        Sort.sortMass();
        break;
      case "4":
        Filter.filterTypeDrive();
        break;
      case "5":
        System.out.println(Colors.GREEN+"Ви вийшли з акаунту!!!");
        menuStart();
        break;
      case "6":
        System.exit(0);
      default:
        System.out.println(Colors.RED+"Невiрна вiдповiдь!!! Спробуйте ще раз!!!");
        menuMain();
        break;
    }

  }

}
