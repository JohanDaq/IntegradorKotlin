import java.util.*
import kotlin.math.ceil

const val MINUTES_IN_MILLISECONDS = 60000

data class ParkingSpace(var vehicle: Vehicle, val parking: Parking) {
    val checkInTime = vehicle.checkInTime
    val parkedTime : Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime ) / MINUTES_IN_MILLISECONDS


    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit){
        val vehicle = parking.vehicles.find { it.plate == plate }
        val fee = vehicle?.let { calculateFee(it.type, parkedTime.toInt()) } ?: 0
        if (parking.validatePlate(plate)){
            onSuccess(fee)
        }else{
            onError()
        }
    }

    fun calculateFee(type: VehicleType, parkedTime: Int): Int{
        val amount = parkedTime - 120
        val quarterValue = ceil((amount.toDouble() / 15)) * 5
        return (quarterValue + type.rate).toInt()
    }
}
