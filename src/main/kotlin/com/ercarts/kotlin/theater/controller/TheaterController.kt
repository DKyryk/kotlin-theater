package com.ercarts.kotlin.theater.controller

import com.ercarts.kotlin.theater.domain.Position
import com.ercarts.kotlin.theater.domain.Seat
import com.ercarts.kotlin.theater.service.TheaterService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author dkyryk
 */

@RestController
@RequestMapping("/theater/api")
class TheaterController(val service: TheaterService) {

    @GetMapping("/seats/{row}/{number}")
    fun checkSeat(@PathVariable row: Int, @PathVariable number: Int): Seat {
        return service.getSeat(Position(row, number))
    }

}