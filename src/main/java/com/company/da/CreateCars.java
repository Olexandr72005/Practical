package com.company.da;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CreateCars {

  /**
   * Маппер
   */
  ObjectMapper mapper = new ObjectMapper();

  /**
   * Створює список автомобілів, якщо їх немає
   * @throws IOException вийняток
   */
  public void createCars() throws IOException {
    checkFilesDirectory();
    List<Car> cars = new ArrayList<>();
    Car car1 = new Car("Mersedes-Benz","GL 450","Позашляховик","Легковий","Нiмеччина","Повний",235,2430);
    Car car2 = new Car("Renault","Megane 3","Унiверсал","Легковий","Францiя","Переднiй",210,1944);
    Car car3 = new Car("Audi","A4 B8","Седан","Легковий","Нiмеччина","Повний",232,2080);
    Car car4 = new Car("BMW","","X5 M50d","Легковий","Нiмеччина","Повний",250,2900);
    Car car5 = new Car("Chevrolet","Aveo","Хэтчбэк","Легковий","США","Переднiй",157,1465);
    Car car6 = new Car("Citroen","C4","Кросовер","Легковий","Францiя","Повний",198,1970);
    Car car7 = new Car("Dacia","Sandero","Хэтчбэк","Легковий","Румунiя","Переднiй",163,1561);
    Car car8 = new Car("Daewoo","Lanos","Хэтчбэк","Легковий","Корея","Переднiй",172,1595);
    Car car9 = new Car("Fiat","Doblo","Мiнiвен","Легковий","Італiя","Переднiй",161,1940);
    Car car10 = new Car("Ford","Fusion","Седан","Легковий","США","Переднiй",180,1900);
    Car car11 = new Car("Honda","CR-V","Кросовер","Легковий","Японiя","Переднiй",177,2086);
    Car car12 = new Car("Infiniti","FX","Позашляховик","Легковий","Японiя","Заднiй",228,2340);
    Car car13 = new Car("Jeep","Cherokee","Позашляховик","Легковий","США","Повний",180,2520);
    Car car14 = new Car("Kia","Sportage","Кросовер","Легковий","Корея","Переднiй",178,1830);
    Car car15 = new Car("Land Rover","R/R","Позашляховик","Легковий","Англiя","Повний",210,2660);
    Car car16 = new Car("Lexus","LX","Позашляховик","LX","Позашляховик","Повний",200,3386);
    Car car17 = new Car("Mazda","CX-5","Кросовер","Легковий","Японiя","Переднiй",197,2043);
    Car car18 = new Car("Mitshbishi","Outlander","Кросовер","Легковий","Японiя","Переднiй",190,3384);
    Car car19 = new Car("Nissan","Qashqai","Кросовер","Легковий","Японiя","Переднiй",190,2025);
    Car car20 = new Car("Opel","Astra","Хэтчбэк","Легковий","Нiмеччина","Переднiй",220,1850);
    Car car21 = new Car("Peugeot","3008","Кросовер","Легковий","Францiя","Переднiй",180,1970);
    Car car22 = new Car("Skoda","Octavia","Унiверсал","Легковий","Чехiя","Повний",225,2225);
    Car car23 = new Car("Toyota","Camry","Седан","Легковий","Японiя","Переднiй",190,2100);
    Car car24 = new Car("Volkswagen","Passat B6","Седан","Легковий","Нiмеччина","Переднiй",227,1970);
    Car car25 = new Car("Volvo","XC90","Позашляховик","Легковий","Швецiя","Повний",190,2560);
    cars.add(car1);
    cars.add(car2);
    cars.add(car3);
    cars.add(car4);
    cars.add(car5);
    cars.add(car6);
    cars.add(car7);
    cars.add(car8);
    cars.add(car9);
    cars.add(car10);
    cars.add(car11);
    cars.add(car12);
    cars.add(car13);
    cars.add(car14);
    cars.add(car15);
    cars.add(car16);
    cars.add(car17);
    cars.add(car18);
    cars.add(car19);
    cars.add(car20);
    cars.add(car21);
    cars.add(car22);
    cars.add(car23);
    cars.add(car24);
    cars.add(car25);
    String path = "data\\cars\\cars.json";
    JsonNode jsonNode = mapper.readTree(new File(path));
    ObjectNode root = mapper.createObjectNode();;
    ArrayNode carsArray = mapper.createArrayNode();
    for (int i = 0; i < cars.size(); i++){
      ObjectNode item = mapper.createObjectNode();
      item.put("company",cars.get(i).getCompany());
      item.put("model",cars.get(i).getModel());
      item.put("typeBody",cars.get(i).getTypeBody());
      item.put("typeTransport",cars.get(i).getTypeTransport());
      item.put("country",cars.get(i).getCountry());
      item.put("typeDrive",cars.get(i).getTypeDrive());
      item.put("maxSpeed",cars.get(i).getMaxSpeed());
      item.put("mass",cars.get(i).getMass());
      carsArray.add(item);
    }
    root.put("cars",carsArray);
    PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(path)));
    writer.println(mapper.writeValueAsString(root));
    writer.close();

  }

  /**
   * Читає JSON файл
   * @throws IOException вийняток
   */
  public void readFile() throws IOException {
    File carsFile = new File("data\\cars\\cars.json");
    AutoSalon autoSalon = mapper.readValue(carsFile, AutoSalon.class);
    System.out.println(autoSalon.toString().replaceAll("\\[","").replaceAll("]","").replaceAll(",",""));
  }

  /**
   * Перевіряє на існування директорію
   * @throws IOException вийняток
   */
  public void checkFilesDirectory() throws IOException {
    File mainDirectory = new File("data");
    if(!mainDirectory.exists()){
      mainDirectory.mkdir();
    }
    File carsDirectory = new File("data\\cars");
    if(!carsDirectory.exists()){
      carsDirectory.mkdir();
    }
    File carsFile = new File("data\\cars\\cars.json");
    if(!carsFile.exists()){
      carsFile.createNewFile();
    }
  }

}
