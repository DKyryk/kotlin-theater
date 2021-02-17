package com.ercarts.kotlin.theater

import java.math.BigDecimal

/**
 * @author dkyryk
 */
class Theater {

    private val seats: List<Seat>

    init {
        val result = mutableListOf<Seat>()
        for (row in (1..15)) {
            for (number in (1..36)) {
                Position(row, number)
                val position = Position(row, number)
                result.add(Seat(position, SeatType.determineType(position)))
            }
        }
        seats = result.toList()
    }
}

data class Position(val row: Int, val number: Int)

data class Seat(val position: Position, val type: SeatType)

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