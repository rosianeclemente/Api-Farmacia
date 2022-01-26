package com.farmacia.farmaciaPatos.Application.web.request

import com.farmacia.farmaciaPatos.domain.Medicamentos

data class FarmaciaRequest(
    val id: Long? = null,
    val nome: String,
    val tipo: String,
    val concentracao: String

) {
    fun toMedicamentos()= Medicamentos(
        nome = nome,
        tipo = tipo,
        concentracao = concentracao
    )
    companion object {
        fun to(id: Long?, request: FarmaciaRequest) = Medicamentos(
            id = request.id,
            nome = request.nome,
            tipo = request.tipo,
            concentracao = request.concentracao
        )
    }
}