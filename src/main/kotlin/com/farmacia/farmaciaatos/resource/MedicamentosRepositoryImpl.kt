package com.farmacia.farmaciaatos.resource

import com.farmacia.farmaciaatos.domain.Medicamentos
import com.farmacia.farmaciaatos.domain.MedicamentosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class MedicamentosRepositoryImpl(@Autowired private val repository: MedicamentosEntityRepository): MedicamentosRepository {
    override fun getDetail(id: Long): Medicamentos = repository.findByIdOrNull(id)!!.toMedicamentos()

    override fun getMedicamento(): List<Medicamentos> = repository.findAll().map { it.toMedicamentos() }

    override fun insert(medicamento: Medicamentos): Medicamentos = repository.save(MedicamentoEntity.from(medicamento)).toMedicamentos()

    override fun delete(id: Long) = repository.deleteById(id)

    override fun update(medicamento: Medicamentos): Medicamentos = repository.save(MedicamentoEntity.from(medicamento)).toMedicamentos()

}