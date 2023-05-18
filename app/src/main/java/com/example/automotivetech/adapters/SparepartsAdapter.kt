package com.example.automotivetech.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.automotivetech.R
import com.example.automotivetech.models.Service
import com.example.automotivetech.models.Sparepart

class SparepartsAdapter(var context: Context, var data:ArrayList<Sparepart>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var sparepart:TextView
        var sparename:TextView
        var spareprice : TextView
        init {
            this.sparepart = row?.findViewById(R.id.sparepart_part) as TextView
            this.sparename = row.findViewById(R.id.sparepart_name) as TextView
            this.spareprice = row.findViewById(R.id.sparepart_price) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.spareparts,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Sparepart = getItem(position) as Sparepart
        viewHolder.sparepart.text = item.sparepart
        viewHolder.sparename.text = item.sparename
        viewHolder.spareprice.text = item.spareprice
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }
}