/**
 * The Parking class represents a place where the vehicles will be store in
 */
data class Parking(
    val vehicles: MutableSet<Vehicle>,
) {
    private val spaces = 20
    var profit: Pair<Int,Int> = Pair(0,0)

    /**
     * Add a vehicle [Vehicle] if it is not registered yet otherwise the register process would be rejected
     * @param vehicle [Vehicle] instance to be added
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    fun addVehicle(vehicle: Vehicle): Boolean {
        return when {
            vehicles.contains(vehicle) -> {
                println("Sorry, the has check-in failed")
                false
            }

            (vehicles.size < spaces) -> {
                println("Welcome to AlkeParking! ${vehicle.plate}")
                vehicles.add(vehicle)
                true
            }

            else -> {
                println("Sorry, the check-in failed")
                false
            }
        }
    }

    /**
     * Return [true] or [false] whether vehicle is at parking
     * @param plate [String] unique vehicle identifier
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    fun validatePlate(plate: String): Boolean {
        return this.vehicles.any { it.plate == plate }
    }

    /**
     * Return a vehicle [Vehicle] instance found by plate [String]
     * @param plate [String] unique vehicle identifier
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    fun searchVehicle(plate: String): Vehicle? {
        return vehicles.find { it.plate == plate }
    }

    /**
     * Remove a vehicle [Vehicle] from the parking list and print the notification
     * @param vehicle [Vehicle] instance to be removed
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    fun removeVehicle(vehicle: Vehicle) {
        val parkingSpace = ParkingSpace(vehicle, this)
        parkingSpace.checkOutVehicle(vehicle.plate, {
            println("Your fee is $it. Come back soon.")
            updateProfits(it)
            vehicles.remove(vehicle)
        }, { println("Sorry, the check-out failed") })
    }

    /**
     * When a vehicle leaves update the profits
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    private fun updateProfits(fee: Int): Unit{
        profit = profit.copy(first = profit.first + 1)
        profit = profit.copy(second = profit.second + fee)
    }

    /**
     * Print the current profits in the parking place and the amount of vehicles which has left the parking
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    fun getEarnings(){
        println("${profit.first} vehicles have checked out and have earnings of $${profit.second}")
    }

    /**
     * Show the complete list of vehicle plate inside parking
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
      */

    fun listVehicles(): Unit = vehicles.forEach(){ println(it.plate) }
}
