package com.ercarts.kotlin.theater.service

import com.ercarts.kotlin.theater.domain.Position
import com.ercarts.kotlin.theater.domain.Seat
import com.ercarts.kotlin.theater.domain.Theater
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

/**
 * @author dkyryk
 */

@Service
class TheaterService(val theater: Theater) {

    fun getSeat(position: Position): Seat {
        return theater.getSeat(position) ?: throw IllegalArgumentException("Wrong position")
    }

}
