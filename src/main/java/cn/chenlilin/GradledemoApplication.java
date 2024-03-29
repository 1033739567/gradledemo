package cn.chenlilin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan(basePackages = "cn.chenlilin")
@MapperScan(basePackages ={"cn.chenlilin.mapper"})
public class GradledemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradledemoApplication.class, args);
    }

}
