package com.ercarts.kotlin.theater.service

import com.ercarts.kotlin.theater.domain.*
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException

/**
 * @author dkyryk
 */

@Service
class TheaterService {

    private val seats = mutableMapOf<Position, Seat>()

    init {
        for (row in (1..15)) {
            for (number in (1..36)) {
                Position(row, number)
                val position = Position(row, number)
                seats[position] = Seat(SeatType.determineType(position), SeatStatus.Vacant)
            }
        }
    }

    fun getSeat(position: Position): Seat {
        return seats[position] ?: throw IllegalArgumentException("Wrong position")
    }

    fun bookSeat(bookingRequest: BookingRequest): Seat {
        val requestedSeat = getSeat(bookingRequest.position)
        if (bookingRequest.money < requestedSeat.type.price) {
            throw IllegalArgumentException("Insufficient funds")
        }
        requestedSeat.status = SeatStatus.Booked
        seats[bookingRequest.position] = requestedSeat
        return requestedSeat
    }

}
