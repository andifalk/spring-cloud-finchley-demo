package com.example.customerbackend.config

import org.springframework.boot.actuate.autoconfigure.security.reactive.EndpointRequest
import org.springframework.boot.autoconfigure.security.reactive.PathRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService
import org.springframework.security.core.userdetails.ReactiveUserDetailsService
import org.springframework.security.core.userdetails.User
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.security.web.server.authentication.logout.RedirectServerLogoutSuccessHandler
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler
import java.net.URI

@EnableWebFluxSecurity
@Configuration
class WebSecurityConfiguration {

    @Bean
    fun securityChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
                .csrf().disable()
                .authorizeExchange()
                .matchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                .matchers(EndpointRequest.to("health")).permitAll()
                .matchers(EndpointRequest.to("info")).permitAll()
                .matchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
                .pathMatchers("/public/**").permitAll()
                .anyExchange().authenticated()
                .and()
                .httpBasic().and().formLogin().and()
                .logout().logoutSuccessHandler(logoutSuccessHandler())
                .and()
                .build()
    }

    @Bean
    fun reactiveUserDetailsService(): ReactiveUserDetailsService {
        return MapReactiveUserDetailsService(
            User.withUsername("user")
                    .password("secret")
                    .passwordEncoder({passwordEncoder().encode(it)})
                    .roles("USER")
                    .build()
        )
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

    @Bean
    fun logoutSuccessHandler(): ServerLogoutSuccessHandler {
        val logoutSuccessHandler = RedirectServerLogoutSuccessHandler()
        logoutSuccessHandler.setLogoutSuccessUrl(URI.create("/customers"))
        return logoutSuccessHandler
    }
}
