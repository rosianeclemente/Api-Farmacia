package com.farmacia.farmaciaatos.Application


data class BadRequestException(override val message: String) : RuntimeException(message)