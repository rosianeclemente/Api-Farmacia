package com.farmacia.farmaciaatos.resource

import com.farmacia.farmaciaatos.domain.Medicamentos
import javax.persistence.*

@Entity
@Table(name = "Farmacia")
class MedicamentoEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(nullable = false)
    val nome: String,
    @Column(nullable = false)
    val tipo: String,
    @Column(nullable = false)
    val concentracao: String
    )
{
    fun toMedicamentos()= Medicamentos(
      id, nome, tipo, concentracao
    )
    companion object{
        fun from (medicamentos: Medicamentos) = MedicamentoEntity(
            id = medicamentos.id,
            nome = medicamentos.nome,
            tipo = medicamentos.tipo,
            concentracao = medicamentos.concentracao
        )
    }

}