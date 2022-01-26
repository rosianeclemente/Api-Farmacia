package com.farmacia.farmaciaatos.resource

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MedicamentosEntityRepository: JpaRepository<MedicamentoEntity, Long> {
}