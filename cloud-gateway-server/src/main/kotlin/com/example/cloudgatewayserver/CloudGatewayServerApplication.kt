package com.example.cloudgatewayserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CloudGatewayServerApplication

fun main(args: Array<String>) {
    runApplication<CloudGatewayServerApplication>(*args)
}
