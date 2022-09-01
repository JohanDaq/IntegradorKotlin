import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    private val checkInTime = vehicle.checkInTime
    val parkedTime : Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime ) / MINUTES_IN_MILLISECONDS


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
     *
     */
    private fun calculateFee(type: VehicleType, parkedTime: Int, hasDiscount: Boolean): Int{
        val discountRate = if(hasDiscount) 0.85 else 1.0
        val minimumTime = 120
        return when{
            (parkedTime <= minimumTime) -> ceil(type.rate * discountRate).toInt()
            else  -> {
                val extraMinutes = parkedTime - minimumTime
                val quarterValue = ceil((extraMinutes.toDouble() / 15)) * 5
                val totalFee = quarterValue + type.rate
                ceil(totalFee * discountRate).toInt()
            }
        }
    }
}
