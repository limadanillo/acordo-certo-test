package br.com.acordocerto;

import br.com.acordo.BasePackageScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = BasePackageScan.class)
@EntityScan("br.com.acordo.domain")
@EnableJpaRepositories("br.com.acordo.repository")
public class AcordoCertoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(AcordoCertoApplication.class, args);
    }

}
