package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.SQLException;



public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user = new User("kamil","Akchurin","kamilxXx1992@mail.ru");
      User user1 = new User("Ruslan","Gafiyatullin","gaf@mail.ru");

      Car car = new Car("tesla", 1);
      Car car1 = new Car("BMV",3);

      user.setCar(car);
      user1.setCar(car1);

      userService.add(user);
      userService.add(user1);
      userService.getUser("tesla", 1);

      context.close();
      }
   }

