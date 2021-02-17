package com.ercarts.kotlin.theater.domain

import java.math.BigDecimal

/**
 * @author dkyryk
 */

data class BookingRequest(val money: BigDecimal, val position: Position)
