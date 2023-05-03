package com.example.javademo

import kotlin.system.exitProcess

class ThirdRS {}
interface Launchable {
    fun igniteEngine()
    fun startThrust()
    fun countdown()
    fun launch()
}

abstract class Rocket(val name: String, val countdownTime: Int) : Launchable {
    override fun countdown() {
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

    override fun launch() {
        igniteEngine()
        println("$name engine ignited!")
        startThrust()
        println("$name thrust started!")
        Thread.sleep(5000)
        println("$name has launched!")
    }

    abstract fun isAbortSignalReceived(): Boolean
}

class SatelliteRocket(name: String, countdownTime: Int) : Rocket(name, countdownTime) {
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

    val rocket = SatelliteRocket("Satellite-1", countdownTime)
    LaunchSystem.launch(rocket)

    val satellite = Satellite("Satellite-1", "Geostationary Orbit")
    satellite.deploy()
}
