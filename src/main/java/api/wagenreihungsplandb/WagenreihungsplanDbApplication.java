package api.wagenreihungsplandb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to start the WagenreihungsplanDB application.
 */
@SpringBootApplication
public class WagenreihungsplanDbApplication {

	/**
	 * The entry point of the application.
	 *
	 * @param args The command-line arguments passed to the application (not used in this application).
	 */
	public static void main(String[] args) {
		SpringApplication.run(WagenreihungsplanDbApplication.class, args);
	}
}
