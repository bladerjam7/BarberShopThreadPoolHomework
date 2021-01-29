package com.bladerco.barbershopthreadpoolhomework.model

import android.os.Bundle
import android.os.Message
import android.util.Log
import com.bladerco.barbershopthreadpoolhomework.util.Const.Companion.TAG

data class BarberCustomer(val timeTaken: Int, val customer: String, val handler: android.os.Handler): Runnable {


    override fun run() {

        val message: Message = handler.obtainMessage()
        for(i in 1..timeTaken){
            Thread.sleep(1000)
            handler.sendMessage(Message().also {
                it.data = Bundle().also { bund ->
                    bund.putString("user_id", this.hashCode().toString())
                    bund.putInt("progress", ((i / timeTaken.toDouble() * 100).toInt()))
                }

            })
            Log.d(TAG, " $customer is getting a hair cut and its $i mins")
        }

        Log.d(TAG, "$customer is done")
    }



}