package com.bladerco.barbershopthreadpoolhomework.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import androidx.recyclerview.widget.RecyclerView
import com.bladerco.barbershopthreadpoolhomework.R
import com.bladerco.barbershopthreadpoolhomework.model.BarberCustomer
import com.bladerco.barbershopthreadpoolhomework.model.CustomerCard
import com.bladerco.barbershopthreadpoolhomework.util.Const.Companion.TAG

class CustomerRVAdapter(): RecyclerView.Adapter<CustomerRVAdapter.ViewHolder>(), LifecycleOwner {

    private var barberCustomerList: List<BarberCustomer> = ArrayList()
    private var progress = 0


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val cardview : CustomerCard = itemView.findViewById(R.id.customer_card)
        
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customercard_layout, parent, false))

    }

    override fun getItemCount(): Int {
        //Log.d(TAG, "getItemCount: ${barberCustomerList.size}")
        return barberCustomerList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Log.d(TAG, "onBindViewHolder: ${barberCustomerList.get(position).customer}")
        holder.cardview.let {
            it.setName(barberCustomerList.get(position).customer)
            it.updateProgressPercent(progress)
        }
    }

    fun updateProgress(p: Int){
        progress = p
        notifyDataSetChanged()
    }

    fun updateList(barberCustomerList: List<BarberCustomer>) {
        this.barberCustomerList = barberCustomerList
        
    }

    override fun getLifecycle(): Lifecycle {
        return lifecycle
    }
}