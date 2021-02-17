package com.ercarts.kotlin.theater.domain

import java.math.BigDecimal

/**
 * @author dkyryk
 */
data class Seat(val type: SeatType, var status: SeatStatus)

enum class SeatStatus {
    Booked, Vacant
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
