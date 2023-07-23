package corp.siendev.com.rickandmorty.config

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@OpenAPIDefinition
class SwaggerConfiguration {
    @Bean
    fun swaggerConfig(): OpenAPI {
        return OpenAPI()
                .components(Components())
                .info(Info()
                        .version("0.1")
                        .title("Rick and Morty API documentation")
                        .description("API documentation for Rick and Morty web app")
                        .contact(Contact()
                                .name("Iurii Golubnichenko")
                                .email("iurii.golubnichenko@gmail.com")))
    }
}
