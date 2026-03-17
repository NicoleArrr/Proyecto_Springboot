package com.proyecto.LogiTrack.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("API Documentada para LogITrack S.A.")
                        .version("1.0")
                        .description("Esta API tiene como objetivo informar sobre la estructuración y el\n funcionamiento de las apis correspondientes a cada entidad a fin de ser consumidas \ny ejemplificadas mediante elementos de prueba a continuación"));
    }
}
