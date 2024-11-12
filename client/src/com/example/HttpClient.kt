package com.example

import io.ktor.client.*
import kotlinx.rpc.krpc.ktor.client.installRPC

fun HttpClientConfig<*>.configureForProject() {
    installRPC()
}
