package az.hesabport;

import org.springframework.boot.SpringApplication;

public class TestHesabportApiApplication {

    public static void main(String[] args) {
        SpringApplication.from(HesabportApiApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
