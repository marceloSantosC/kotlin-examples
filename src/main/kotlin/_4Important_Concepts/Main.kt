package _4Important_Concepts

import _2Object_Oriented.swap
import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt


const val EARTH_RADIUS_METERS = 6378

typealias LatLng = Pair<Double, Double>

fun haversineDistance(pointA: LatLng, pointB: LatLng): Double {
    val (latA, lonA) = pointA
    val (latB, lonB) = pointB

    val latDifference = (latB - latA).toRadians()
    val lonDifference = (lonB - lonA).toRadians()

    val latAInRadians = latA.toRadians()
    val latBInRadians = latB.toRadians()

    val a = sin(latDifference / 2) * sin(latDifference / 2) +
            cos(latAInRadians) * cos(latBInRadians) *
            sin(lonDifference / 2) * sin(lonDifference / 2)

    val c = 2 * atan2(sqrt(a), sqrt(1 - a))

    return EARTH_RADIUS_METERS * c
}

fun Double.toRadians(): Double {
    return Math.toRadians(this)
}

fun main() {

    val pointA = LatLng(-17.221666,	-46.875000)
    val pointB = LatLng(-1.765833, -55.865833)

    println(haversineDistance(pointA, pointB))

}