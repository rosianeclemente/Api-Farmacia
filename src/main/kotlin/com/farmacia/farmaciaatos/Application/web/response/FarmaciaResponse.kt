package com.farmacia.farmaciaatos.Application.web.response

import com.farmacia.farmaciaatos.domain.Medicamentos

data class FarmaciaResponse (

    val id: Long? = null,
    val nome: String,
    val tipo: String,
    val concentracao: String
        ){
    companion object {
        fun from(medicamento: Medicamentos) = FarmaciaResponse(
            id = medicamento.id,
            nome = medicamento.nome,
            tipo = medicamento.tipo,
            concentracao = medicamento.concentracao
        )
    }
}