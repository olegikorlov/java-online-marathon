package com.olegorlov.softserve.jom.sprint09.selfpreporation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class JsonSerialization {

  public static void main(String[] args) {
    String string = new String();
    ObjectToJsonConverter converter = new ObjectToJsonConverter();
    try {
      converter.convertToJson(string);
    } catch (JsonSerializationExeption exeption) {
      System.err.println(exeption);
    }

    User user = new User("Oleg", "Orlov", 40);
    System.out.println(converter.convertToJson(user));
  }

}

@JsonSerializable
class User {

  @JsonElement
  private String fistName;

  @JsonElement
  private String lastName;

  @JsonElement(key = "personAge")
  private int age;

  private String password;

  public User(String fistName, String lastName, int age) {
    this.fistName = fistName;
    this.lastName = lastName;
    this.age = age;
  }

  public User(String fistName, String lastName) {
    this.fistName = fistName;
    this.lastName = lastName;
  }

  public String getFistName() {
    return fistName;
  }

  public void setFistName(String fistName) {
    this.fistName = fistName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonElement {
  String key() default "";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface JsonSerializable {
}

class JsonSerializationExeption extends RuntimeException {

  private static final long serialVersionUID = 2572389656821959193L;

  public JsonSerializationExeption(String message) {
    super(message);
  }

}

class ObjectToJsonConverter {
  public String convertToJson(Object object) throws JsonSerializationExeption {
    try {
      checkIfSerializable(object);
      return getJsonString(object);
    } catch (Exception exeption) {
      throw new JsonSerializationExeption(exeption.getMessage());
    }
  }

  private void checkIfSerializable(Object object) {
    if (Objects.isNull(object)) {
      throw new JsonSerializationExeption("Can't serialize a null object");
    }

    Class<?> clazz = object.getClass();
    if (!clazz.isAnnotationPresent(JsonSerializable.class)) {
      throw new JsonSerializationExeption(
          "The class " + clazz.getSimpleName() + " isn't annotated with JsonSerializable");
    }
  }

  private String getJsonString(Object object) throws IllegalAccessException {
    Class<?> clazz = object.getClass();
    Map<String, String> jsonElementsMap = new HashMap<>();

    for (Field field : clazz.getDeclaredFields()) {
      field.setAccessible(true);
      if (field.isAnnotationPresent(JsonElement.class)) {
        jsonElementsMap.put(getKey(field), field.get(object).toString());
      }
    }

    String jsonString = jsonElementsMap.entrySet()
        .stream()
        .map(entry -> String.format("\"%s\":\"%s\"", entry.getKey(), entry.getValue()))
        .collect(Collectors.joining(", "));
    return String.format("{%s}", jsonString);
  }

  private String getKey(Field field) {
    final String value = field.getAnnotation(JsonElement.class).key();
    if (value.isEmpty()) {
      return field.getName();
    }
    return value;
  }


}