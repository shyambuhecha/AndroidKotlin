//package com.example.javademo
//
//class Six
//
//import kotlin.math.absoluteValue
//
//enum class RocketType(val fuelConsumptionRate: Double, val payloadCapacity: Double) {
//    FALCON_9(20.0, 1000.0),
//    DELTA_IV_HEAVY(30.0, 5000.0),
//    ATLAS_V(40.0, 8000.0)
//}
//
//interface RocketController {
//    fun igniteEngine()
//    fun shutdownEngine()
//}
//
//abstract class Rocket(
//    val name: String,
//    var velocity: Double,
//    var fuelCapacity: Double,
//    val countdownTime: Int,
//    val targetDistance: Double,
//    val payload: Double,
//    val rocketType: RocketType
//) {
//    private var fuelLevel: Double = 0.0
//    private var elapsedTime: Double = 0.0
//    private var distanceTraveled: Double = 0.0
//    private var isEngineIgnited: Boolean = false
//
//    fun addFuel(amount: Double) {
//        fuelLevel += amount
//        if (fuelLevel > fuelCapacity) {
//            fuelLevel = fuelCapacity
//        }
//        println("Fuel level is now $fuelLevel liters.")
//    }
//
//    fun countdown() {
//        println("Countdown started for $name.")
//        (countdownTime downTo 1).forEach {
//            println(it)
//            Thread.sleep(1000)
//            if (isAbortSignalReceived()) {
//                println("Abort signal received. Countdown aborted.")
//                return
//            }
//        }
//    }
//
//    fun launch() {
//        if (fuelLevel == 0.0) {
//            println("Cannot launch $name without fuel.")
//            return
//        }
//        println("$name launching!")
//        igniteEngine()
//        while (fuelLevel > 0.0 && distanceTraveled < targetDistance) {
//            val fuelConsumed = rocketType.fuelConsumptionRate * elapsedTime
//            fuelLevel -= fuelConsumed
//            if (fuelLevel < 0.0) {
//                fuelLevel = 0.0
//            }
//            val acceleration = calculateAcceleration()
//            velocity += acceleration * elapsedTime
//            if (velocity < 0.0) {
//                velocity = 0.0
//            }
//            distanceTraveled += velocity * elapsedTime
//            elapsedTime += 1.0
//            println("$name is $distanceTraveled km away from the launch site at a speed of $velocity km/s.")
//        }
//        shutdownEngine()
//        calculateTravelStats()
//        if (distanceTraveled >= targetDistance) {
//            deploySatellite()
//        }
//    }
//
//    fun calculateTravelStats() {
//        val timeTaken = elapsedTime
//        val averageSpeed = distanceTraveled / timeTaken
//        println("$name traveled a distance of $distanceTraveled km in $timeTaken seconds at an average speed of $averageSpeed km/s.")
//    }
//
//    abstract fun deploySatellite()
//
//    private fun calculateAcceleration(): Double {
//        return if (isEngineIgnited) {
//            -1.0 * rocketType.fuelConsumptionRate.absoluteValue / (fuelLevel + 1.0)
//        } else {
//            0.0
//        }
//    }
//
//    private fun isAbortSignalReceived(): Boolean {
//        // Logic to check for abort signal goes here.
//        return false
//    }
//}
//
//class SatelliteRocket(
//    name: String,
//    countdownTime: Int,
//    targetDistance: Double,
//    fuelCapacity: Double,
//    payload: Double,
//    rocketType: RocketType
//) : Rocket(name, 0.0, fuelCapacity, countdownTime, targetDistance, payload, rocketType), RocketController {
//
//    override fun igniteEngine() {
//        println("Igniting engines for $name.")
//        isEngineIgnited = true
//    }
//
//    override fun shutdownEngine() {
//        println("Shutting down engines for $name.")
//        isEngineIgnited = false
//    }
//
//    override fun deploySatellite() {
//        println("Deploying satellite from $name.")
//        // Logic to deploy satellite goes here.
//    }
//
//}
//
//fun main() {
//    val rocket = SatelliteRocket("Falcon 9", 10, 1000.0, 2000.0, 500.0, RocketType.FALCON_9)
//    rocket.addFuel(1000.0)
//
//    rocket.countdown()
//
//    rocket.launch()
//
//// Using lambda to calculate distance traveled after 5 seconds
//    val distanceAfter5Seconds = rocket.run {
//        var distance = distanceTraveled
//        (1..5).forEach {
//            val fuelConsumed = rocketType.fuelConsumptionRate * elapsedTime
//            fuelLevel -= fuelConsumed
//            if (fuelLevel < 0.0) {
//                fuelLevel = 0.0
//            }
//            val acceleration = calculateAcceleration()
//            velocity += acceleration * elapsedTime
//            if (velocity < 0.0) {
//                velocity = 0.0
//            }
//            distance += velocity * elapsedTime
//            elapsedTime += 1.0
//        }
//        distance
//    }
//
//    println("Distance traveled after 5 seconds: $distanceAfter5Seconds km")
//}