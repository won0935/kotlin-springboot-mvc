package com.springboot.mvc.controller.api.car

import com.springboot.mvc.dto.CarDto
import com.springboot.mvc.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/car")
class CarApiController {

    @PutMapping("")
    fun read(@Valid @RequestBody carDto: CarDto?, bindingResult: BindingResult): ResponseEntity<Any>? {
        if(bindingResult.hasErrors()){
            val message = mutableListOf<String>()

            bindingResult.allErrors.forEach {
                message.add(it.defaultMessage.toString())
            }

            val errorDto = ErrorDto().apply {
                this.message = message
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto)
        }

        return carDto?.let { ResponseEntity.ok(it) }
    }


    @PostMapping("")
    fun create(@Valid
               @RequestBody
               carDto: CarDto?
    ): CarDto? {
        return carDto
    }


}