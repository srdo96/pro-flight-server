package com.ars.proflight.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Sakib"
                ),
                description = "OpenApi Documentation for Pro Flight",
                title = "Pro Flight",
                version = "1.0"
        ),
        servers = {
                @Server(
                        description="Local Host",
                        url="http://localhost:8080"        )
        }
)
public class OpenApiConfig {
}
