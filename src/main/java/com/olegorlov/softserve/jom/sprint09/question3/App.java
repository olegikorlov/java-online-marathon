package com.olegorlov.softserve.jom.sprint09.question3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author <a href="mailto:info@olegorlov.com">Oleg Orlov</a>
 */
public class App {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@interface TestSuite {
  String[] value() default "";
}

class TestSuitHandler {

  static void run(Class<?> clazz) {
    try {
      if (!clazz.isAnnotationPresent(TestSuite.class)) {
        System.out.printf("Class %s isn't annotated", clazz.getName());
        return;
      }

      Object instance = clazz.getDeclaredConstructor().newInstance();
      String[] methodNames = clazz.getDeclaredAnnotation(TestSuite.class).value();

      for (String name : methodNames) {
        try {
          final Method method = clazz.getDeclaredMethod(name);
          if (isPublicAndNonStatic(method)) {
            final String format = "\t -- Method %s.%s %s --%n";
            System.out.printf(format, clazz.getSimpleName(), name, "started");
            method.invoke(instance);
            System.out.printf(format, clazz.getSimpleName(), name, "finished");
          } else {
            throw new NoSuchMethodException();
          }
        } catch (NoSuchMethodException e) {
          System.out.printf("Method with name %s doesn't exists or not public in class %s%n",
              name, clazz.getSimpleName());
        }
      }
    } catch (ReflectiveOperationException e) {
      e.printStackTrace();
    }
  }

  private static boolean isPublicAndNonStatic(Method method) {
    final int modifiers = method.getModifiers();
    return Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers);
  }

}
