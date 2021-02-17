package com.ercarts.kotlin.theater.domain

import org.springframework.stereotype.Component
import java.math.BigDecimal

/**
 * @author dkyryk
 */
@Component
class Theater {

    private val seats: Map<Position, Seat>

    init {
        val result = mutableMapOf<Position, Seat>()
        for (row in (1..15)) {
            for (number in (1..36)) {
                Position(row, number)
                val position = Position(row, number)
                result[position] = Seat(SeatType.determineType(position), SeatStatus.Vacant)
            }
        }
        seats = result.toMap()
    }

    fun getSeat(position: Position) = seats[position]
}

data class Position(val row: Int, val number: Int)

data class Seat(val type: SeatType, val status: SeatStatus)

enum class SeatStatus {
    Occupied, Vacant
}

enum class SeatType(val description: String, val price: BigDecimal) {
    BestView("Best view", BigDecimal(21.00)),
    Standard("Standard seat", BigDecimal(18.00)),
    RestrictedView("Restricted view", BigDecimal(16.50)),
    Cheaper("Cheaper seat", BigDecimal(14.50)),
    BackRow("Back row", BigDecimal(14.50));

    companion object {
        fun determineType(position: Position): SeatType {
            return when {
                position.row == 15 -> BackRow
                position.row == 14 -> Cheaper
                position.number in (1..3) || position.number in (34..36) -> RestrictedView
                position.row in (1..2) -> BestView
                else -> Standard
            }

        }
    }
}