package socNetwork;

import entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@SpringBootApplication
public class SocNetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocNetworkApplication.class, args);
	}

}
