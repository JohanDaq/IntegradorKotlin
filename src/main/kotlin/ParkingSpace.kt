import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000

/**
 * The ParkingSpace class represents a parking space which has the responsibilities to check out vehicles
 * and calculate fee.
 * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
 */
data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    private val checkInTime = vehicle.checkInTime
    private val plate = vehicle.plate
    private val parkedTime : Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis ) / MINUTES_IN_MILLISECONDS

    /**
     * Checks-out a vehicle and notify if the check-out process was successful or failed
     * verifying if a plate [String] is on parking zone
     * @param plate [String] unique vehicle identifier
     * @param onSuccess [Unit] gives a successful notification given a fee [Int]
     * @param onError [UInt] gives a failed notification
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit){
        val vehicle = parking.searchVehicle(plate)
        val hasDiscount = vehicle?.discountCard?.isNotBlank() ?: false
        val fee = vehicle?.let { calculateFee(it.type, parkedTime.toInt(), hasDiscount) } ?: 0
        if (parking.validatePlate(plate)){
            onSuccess(fee)
        }else{
            onError()
        }
    }

    /**
     * Return the fee [Int] depending on vehicle [type], [parkedTime] and [hasDiscount]
     * @param type enum [VehicleType] a rate depending on vehicle
     * @param parkedTime [Int] minutes that vehicle was parked
     * @param hasDiscount [Boolean] parking coupon which apply a 15% discount
     * @author Johan Aponte, Kevin Von Hausen, Yilber Sánchez, Débora Tolaba
     */
    private fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscount: Boolean): Int{
        val discountRate = if(hasDiscount) 0.85 else 1.0
        val minimumTime = 120
        val quarterHour = 15
        val quarterPrice = 5
        return when{
            (parkedTime <= minimumTime) -> ceil(type.rate * discountRate).toInt()
            else  -> {
                val extraMinutes = parkedTime - minimumTime
                val quarterValue = ceil((extraMinutes.toDouble() / quarterHour)) * quarterPrice
                val totalFee = quarterValue + type.rate
                ceil(totalFee * discountRate).toInt()
            }
        }
    }
}
