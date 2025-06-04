package in.sp.main.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(
		title = "Stock Maerket Data API",
		description = "Stock market data REST API",
		summary = "API for accessing stock market data",
		contact = @Contact(name ="Karan Vaghela",
		email = "karanvaghela134@gmail.com"),
		license = @License(name= "Karan Vaghela"),version = "1.0.0"),
		servers = {@Server(description = "Singlestock",url="http://localhost:8080/api/stocks?symbols=AAPL"),
				@Server(description = "Multiplestock",url="http://localhost:8080/api/stocks?symbols=AAPL/GOOGL/MSFT"),
				
		}
		
)
public class SwaggerConfig {

}
