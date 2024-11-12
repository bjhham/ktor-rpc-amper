package com.example

import io.ktor.server.application.*
import io.ktor.server.routing.*
import kotlinx.rpc.krpc.ktor.server.RPC
import kotlinx.rpc.krpc.ktor.server.rpc
import kotlinx.rpc.krpc.serialization.json.*

fun Application.configureFrameworks() {
    install(RPC)
    routing {
        rpc("/api") {
            rpcConfig {
                serialization {
                    json()
                }
            }
        
            registerService<SampleService> { ctx -> SampleServiceImpl(ctx) }
        }
    }
}
