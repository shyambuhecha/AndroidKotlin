interface Fuelable {
    fun addFuel(fuel: Double)
    fun getFuelLevel(): Double
}

interface Launchable {
    fun igniteEngine()
    fun startThrust()
}

abstract class Rocket(val name: String, val countdownTime: Int, val initialVelocity: Double, val fuelCapacity: Double) : Launchable, Fuelable {
    var distanceTraveled = 0.0
    var speed = initialVelocity
    var timeElapsed = 0
    private var fuelLevel = fuelCapacity

    override fun addFuel(fuel: Double) {
        if (fuel + fuelLevel > fuelCapacity) {
            fuelLevel = fuelCapacity
        } else {
            fuelLevel += fuel
        }
        println("$name fuel level: $fuelLevel liters")
    }

    override fun getFuelLevel(): Double {
        return fuelLevel
    }

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
            fuelLevel -= 0.1 // Fuel consumption rate
            if (fuelLevel <= 0) {
                println("$name has run out of fuel!")
                break
            }
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

class SatelliteRocket(name: String, countdownTime: Int, initialVelocity: Double, fuelCapacity: Double) : Rocket(name, countdownTime, initialVelocity, fuelCapacity) {
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
        satellite.deploy
