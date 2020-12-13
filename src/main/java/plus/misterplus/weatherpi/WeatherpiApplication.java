package plus.misterplus.weatherpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class WeatherpiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherpiApplication.class, args);
    }
}
