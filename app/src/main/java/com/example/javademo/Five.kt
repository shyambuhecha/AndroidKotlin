package com.example.javademo

interface Launchable {
    fun igniteEngine()
    fun startThrust()
}

abstract class Rocket(val name: String, val countdownTime: Int, val initialVelocity: Double) : Launchable {
    var distanceTraveled = 0.0
    var speed = initialVelocity
    var timeElapsed = 0

    fun countdown() {
        println("$name countdown started:")
        for (i in countdownTime downTo 1) {
            println(i)
            Thread.sleep(1000)
            if (i % 3 == 0 && isAbortSignalReceived()) {
                println("$name launch aborted!")
                exitProcess(0)
            }
        }
    }

    fun launch() {
        igniteEngine()
        println("$name engine ignited!")
        startThrust()
        println("$name thrust started!")

        while (true) {
            distanceTraveled += speed
            timeElapsed++
            speed += 0.1 // Acceleration due to gravity
            println("$name distance traveled: $distanceTraveled km")
            println("$name speed: $speed km/s")
            println("$name time elapsed: $timeElapsed seconds")
            if (distanceTraveled >= getTargetDistance()) {
                println("$name has reached its target!")
                break
            }
            Thread.sleep(1000)
        }

        calculateTravelStats()
    }

    abstract fun isAbortSignalReceived(): Boolean
    abstract fun getTargetDistance(): Double

    open fun calculateTravelStats() {
        val timeOfReach = timeElapsed.toDouble()
        val finalSpeed = speed
        val distanceFromTarget = getTargetDistance() - distanceTraveled

        println("$name reached its target after $timeOfReach seconds!")
        println("$name final speed: $finalSpeed km/s")
        println("$name distance from target: $distanceFromTarget km")
    }
}

class SatelliteRocket(name: String, countdownTime: Int, initialVelocity: Double) : Rocket(name, countdownTime, initialVelocity) {
    override fun igniteEngine() {
        println("$name igniting engine...")
        // Code to ignite the rocket engine for satellite rocket
    }

    override fun startThrust() {
        println("$name starting thrust...")
        // Code to start the rocket thrust for satellite rocket
    }

    override fun isAbortSignalReceived(): Boolean {
        // Code to check if the abort signal has been received for satellite rocket
        return false
    }

    override fun getTargetDistance(): Double {
        // Code to get the target distance for satellite rocket
        return 20000.0 // km
    }

    override fun calculateTravelStats() {
        super.calculateTravelStats()
        deploySatellite()
    }

    private fun deploySatellite() {
        println("$name deploying satellite...")
        val satellite = Satellite("Satellite-1", "Geostationary Orbit")
        satellite.deploy()
    }
}

object LaunchSystem {
    fun launch(rocket: Launchable) {
        rocket.countdown()
        rocket.launch()
    }
}

class Satellite(val name: String, val orbit: String) {
    fun deploy() {
        println("$name has been deployed to $orbit!")
        // Code to deploy the satellite to the specified orbit
    }
}

fun main() {
    println("Welcome to the satellite launching system!")
    println("Please enter the countdown time in seconds:")

    val countdownTime = readLine()?.toIntOrNull()

    if (countdownTime == null || countdownTime <= 0) {
        println("Invalid countdown time!")
        exitProcess(0)
    }

    println("Please enter the initial velocity of the rocket in km/s:")

    val initialVelocity
