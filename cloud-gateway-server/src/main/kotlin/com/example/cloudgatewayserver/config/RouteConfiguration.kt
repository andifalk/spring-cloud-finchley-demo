package com.example.cloudgatewayserver.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RouteConfiguration {

    @Bean
    fun routeLocator(@Autowired builder: RouteLocatorBuilder, @Autowired rewrite: RewritePathGatewayFilterFactory): RouteLocator {
        return builder.routes()
                .route({
                    r -> r.host("**localhost:8080**").uri("http://localhost:9090")
                }).build()
    }

}
