package ufc.gestao.scs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SCSApplication {

    public static void main(String[] args) {
        SpringApplication.run(SCSApplication.class, args);
        //System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }

}
