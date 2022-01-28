package com.farmacia.farmaciaPatos.Application.web

import com.farmacia.farmaciaPatos.Application.web.request.FarmaciaRequest
import com.farmacia.farmaciaPatos.Application.web.response.FarmaciaResponse
import com.farmacia.farmaciaPatos.domain.MedicamentosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.net.URI
import javax.validation.Valid


private const val API_PATH = "/medicamentos"
@RestController
@RequestMapping(value = [API_PATH])
class MedicamentosResource(@Autowired private val repository: MedicamentosRepository) {

    @PostMapping
    fun insert(@Valid @RequestBody request: FarmaciaRequest) = request.toMedicamentos().run{
        repository.insert(this)
    }.let {
        ResponseEntity.created(URI("$API_PATH/${it.id}")).body(FarmaciaResponse.from(it))
    }

    @GetMapping
    @Transactional(readOnly = true)
    fun getMedicamentos() = repository.getMedicamento().map { FarmaciaResponse.from(it) }
        .let {
            ResponseEntity.ok().body(it)
        }
    @GetMapping("{id}/detail")
    fun getDetail(@PathVariable("id") id:Long) =
        repository.getDetail(id).let { ResponseEntity.ok().body(FarmaciaResponse.from(it)) }

    @DeleteMapping("/{id}")
    fun deleteMedicamento(@PathVariable id: Long) =
        repository.delete(id).let {
        ResponseEntity.accepted().build<Void>()
    }
    @PutMapping("/{id}")
    fun update(@Valid @RequestBody request: FarmaciaRequest, @PathVariable("id") id: Long) =
        repository.getDetail(id)?.let {
            FarmaciaRequest.to(it.id, request).apply {
                repository.update(this)
            }.let { ResponseEntity.ok().body(FarmaciaResponse.from(it))

            }
        }?: ResponseEntity.accepted().build<Void>()


}