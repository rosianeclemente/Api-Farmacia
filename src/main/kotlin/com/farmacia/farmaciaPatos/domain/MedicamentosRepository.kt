package com.farmacia.farmaciaPatos.domain

interface MedicamentosRepository {
    fun getDetail(id: Long): Medicamentos
    fun getMedicamento(): List<Medicamentos>
    fun insert(medicamento: Medicamentos): Medicamentos
    fun delete(id: Long)
    fun update(medicamento: Medicamentos): Medicamentos
}