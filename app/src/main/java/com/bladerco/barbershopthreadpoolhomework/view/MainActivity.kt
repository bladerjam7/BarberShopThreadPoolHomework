package com.bladerco.barbershopthreadpoolhomework.view


import android.os.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bladerco.barbershopthreadpoolhomework.R
import com.bladerco.barbershopthreadpoolhomework.model.BarberCustomer
import com.bladerco.barbershopthreadpoolhomework.util.HandlerUtil
import com.bladerco.barbershopthreadpoolhomework.view.adapter.CustomerRVAdapter

class MainActivity : AppCompatActivity(), Handler.Callback{

    private lateinit var handlerUtil: HandlerUtil

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CustomerRVAdapter

    private val handler = Handler(Looper.getMainLooper(), this)

    private val barberCustomer = listOf(
            BarberCustomer(3, "John", handler),
            BarberCustomer(1, "Jack", handler),
            BarberCustomer(5, "June", handler),
            BarberCustomer(2, "Jerry", handler),
            BarberCustomer(6, "Jim", handler),
            BarberCustomer(2, "James", handler),
            BarberCustomer(5, "Julie", handler),
            BarberCustomer(1, "Jennet", handler)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.rv_bar_customers_list)



        adapter = CustomerRVAdapter()

        adapter.updateList(barberCustomer)
        recyclerView.adapter = adapter



        handlerUtil = HandlerUtil(handler, barberCustomer)
        handlerUtil.serveCustomers()
    }

    override fun handleMessage(p0: Message): Boolean {

        barberCustomer.forEach {
            when(p0.data.getString("user_id")){
                it.hashCode().toString()->{
                    adapter.updateProgress(p0.data.getInt("progress"))
                }
            }
        }




        return true
    }
}