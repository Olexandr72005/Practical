package com.company.bl;

import com.company.da.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас перетворення файлу в масив
 */
public class ParseToArray {

  /**
   * Масив автомобілів
   * @return повертає масив автомобілів
   * @throws IOException вийняток
   */
  public static List<Car> parseToArray() throws IOException {

    ObjectMapper mapper = new ObjectMapper();
    final String PATH = "data\\cars\\cars.json";
    List<Car> cars = new ArrayList<>();
    ObjectNode root = (ObjectNode) mapper.readTree(new File(PATH));
    ArrayNode array = (ArrayNode) root.get("cars");
    for (int j = 0; j < array.size(); j++) {
      ObjectNode objectNode = (ObjectNode) array.get(j);
      Car car = new Car(objectNode.get("company").textValue(),objectNode.get("model").textValue(),
          objectNode.get("typeBody").textValue(),objectNode.get("typeTransport").textValue(),
          objectNode.get("country").textValue(),objectNode.get("typeDrive").textValue(),
          objectNode.get("maxSpeed").intValue(), objectNode.get("mass").intValue());
      cars.add(car);
    }
    return cars;
  }

}
