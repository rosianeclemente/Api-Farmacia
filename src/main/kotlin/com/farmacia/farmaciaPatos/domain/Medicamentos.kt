package com.farmacia.farmaciaPatos.domain

import javax.persistence.Entity


data class Medicamentos (

    val id: Long? = null,
    val nome: String,
    val tipo: String,
    val concentracao: String
        ) {
}