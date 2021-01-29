package com.bladerco.barbershopthreadpoolhomework.util

import android.os.Handler
import com.bladerco.barbershopthreadpoolhomework.model.BarberCustomer
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit


class HandlerUtil(private val handler: Handler,
                  private val customerList: List<BarberCustomer>) {

    private val CORE_POOL_SIZE = 4
    private val MAX_POOL_SIZE = 6
    private val KEEP_ALIVE_TIME = 10L

    private lateinit var barberManager: ThreadPoolExecutor

    private val customerQueue: BlockingQueue<Runnable> = LinkedBlockingQueue()

    fun serveCustomers(){
        if(!this::barberManager.isInitialized)
            barberManager = ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, customerQueue)

        customerList.forEach{
            barberManager.execute(it)
        }
    }
}