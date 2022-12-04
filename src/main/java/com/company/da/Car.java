package com.company.da;

public class Car {

  /**
   * Компанія автомобіля
   */
  private String company;
  /**
   * Модель автомобіля
   */
  private String model;
  /**
   * Тип кузова автомобіля
   */
  private String typeBody;
  /**
   * Тип транспорту автомобіля
   */
  private String typeTransport;
  /**
   * Країна виробник автомобіля
   */
  private String country;
  /**
   * Тип приводу автомобіля
   */
  private String typeDrive;
  /**
   * Максимальна швидкість автомобіля
   */
  private int maxSpeed;
  /**
   * Масса автомобіля
   */
  private int mass;
  /**
   * Конструктор автомобіля
   */
  public Car(String company, String model, String typeBody, String typeTransport, String country, String typeDrive,
      int maxSpeed, int mass) {
    this.company = company;
    this.model = model;
    this.typeBody = typeBody;
    this.typeTransport = typeTransport;
    this.country = country;
    this.typeDrive = typeDrive;
    this.maxSpeed = maxSpeed;
    this.mass = mass;
  }
  /**
   * Конструктор автомобіля
   */
  public Car(){}

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getTypeBody() {
    return typeBody;
  }

  public void setTypeBody(String typeBody) {
    this.typeBody = typeBody;
  }

  public String getTypeTransport() {
    return typeTransport;
  }

  public void setTypeTransport(String typeTransport) {
    this.typeTransport = typeTransport;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getTypeDrive() {
    return typeDrive;
  }

  public void setTypeDrive(String typeDrive) {
    this.typeDrive = typeDrive;
  }

  public int getMaxSpeed() {
    return maxSpeed;
  }

  public void setMaxSpeed(int maxSpeed) {
    this.maxSpeed = maxSpeed;
  }

  public int getMass() {
    return mass;
  }

  public void setMass(int mass) {
    this.mass = mass;
  }
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  @Override
  public String toString() {
    return
        "\nКомпанiя: " + company +
        "\nМодель: " + model +
        "\nТип кузова: " + typeBody +
        "\nТип транспорту: " + typeTransport +
        "\nКраїна виробник: " + country +
        "\nТип приводу: " + typeDrive +
        "\nМаксимальна швидкiсть: " + maxSpeed +
        "\nПовна маса (кг): " + mass + "\n";
  }


}
