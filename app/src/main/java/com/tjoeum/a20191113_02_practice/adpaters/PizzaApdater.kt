package com.tjoeum.a20191113_02_practice.adpaters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tjoeum.a20191113_02_practice.R
import com.tjoeum.a20191113_02_practice.datas.PizzaData

class PizzaApdater(context: Context, res : Int, pizzaList: ArrayList<PizzaData>) : ArrayAdapter<PizzaData>(context,res,pizzaList){

    var mContext = context
    var mList = pizzaList
    var inf = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null)
            tempRow = inf.inflate(R.layout.pizza_list_view_item,null)

        var row = tempRow!!

        var pizzaLogo = row.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.pizzaLogo)
        var pizzaNamTxt = row.findViewById<TextView>(R.id.pizzaNameTxt)

        Glide.with(mContext).load("${mList[position].pizzaLogo}").into(pizzaLogo)
        pizzaNamTxt.text = mList[position].pizzaName

        return row



    }



}