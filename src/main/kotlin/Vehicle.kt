import java.util.Calendar

/**
 * The Vehicle class represents a car, bus, motorcycle and mini bus which are stored at parking place.
 */
data class Vehicle(
    val plate: String,
    val type: VehicleType,
    val checkInTime: Calendar,
    val discountCard: String? = null
){
    override fun equals(other: Any?): Boolean{
        if (other is Vehicle){
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()
}
