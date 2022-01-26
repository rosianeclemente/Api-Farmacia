package com.farmacia.farmaciaPatos.Application


data class BadRequestException(override val message: String) : RuntimeException(message)