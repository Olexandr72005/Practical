package com.company.da;

import java.util.List;

/**
 * Клас автосалону
 */
public class AutoSalon {

  /**
   * Масив автомобілів
   */
  private List<Car> cars;

  /**
   * Конструктор
   */
  public AutoSalon(){}

  /**
   * Повертає масив
   * @return повертає масив автомобілів
   */
  public List<Car> getCars() {
    return cars;
  }

  /**
   * Встановлює масив
   * @param cars приймає масив автомобілів
   */
  public void setCars(List<Car> cars) {
    this.cars = cars;
  }

  /**
   * Перевизначення
   * @return повертає список автомобілів
   */
  @Override
  public String toString() {
    return "\nСписок автомобiлiв\n" + cars;
  }
}
