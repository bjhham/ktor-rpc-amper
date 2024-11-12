package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.rpc.krpc.ktor.client.RPC
import kotlinx.rpc.krpc.ktor.client.rpc
import kotlinx.rpc.krpc.ktor.client.rpcConfig
import kotlinx.rpc.krpc.serialization.json.json
import kotlinx.rpc.withService

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
    @Test
    fun testRpc() = testApplication {
        application {
            configureRouting()
        }
    
        val ktorClient = createClient {
            install(RPC)
        }
    
        val rpcClient = ktorClient.rpc("/api") {
            rpcConfig {
                serialization {
                    json()
                }
            }
        }
    
        val service = rpcClient.withService<SampleService>()
    
        val response = service.hello(Data("client"))
    
        assertEquals("Server: client", response)
    }
}