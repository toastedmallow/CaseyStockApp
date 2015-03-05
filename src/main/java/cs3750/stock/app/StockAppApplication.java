package cs3750.stock.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication
public class StockAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockAppApplication.class, args);
    }
}
