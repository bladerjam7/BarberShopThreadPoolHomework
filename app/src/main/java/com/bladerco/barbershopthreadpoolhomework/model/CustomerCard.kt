package com.bladerco.barbershopthreadpoolhomework.model

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.bladerco.barbershopthreadpoolhomework.R

class CustomerCard( context: Context,  attributeSet: AttributeSet) : CardView(context, attributeSet){

    private var attrSet : AttributeSet

    private var customerNameText: TextView
    private var serviceProgress: ProgressBar

    private val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    init{
        layoutInflater.inflate(R.layout.item_customer_card, this, true)

        customerNameText = rootView.findViewById(R.id.tv_customer_name)
        serviceProgress = rootView.findViewById(R.id.pb_customer)

        this. attrSet = attributeSet
    }

    fun setName(name: String){
        customerNameText.text = name
    }

    fun updateProgressPercent(progress: Int){
        serviceProgress.progress = progress
    }

}