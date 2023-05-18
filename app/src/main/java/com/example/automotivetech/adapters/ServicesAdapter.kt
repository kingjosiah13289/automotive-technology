package com.example.automotivetech.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.automotivetech.R
import com.example.automotivetech.models.Service

class ServicesAdapter(var context: Context, var data: ArrayList<Service>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtServiceName:TextView
        var mTxtServiceDesc:TextView
        init {
            this.mTxtServiceName = row?.findViewById(R.id.mTvServiceName) as TextView
            this.mTxtServiceDesc = row?.findViewById(R.id.mTvServiceDesc) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.service_item,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Service = getItem(position) as Service
        viewHolder.mTxtServiceName.text = item.serviceName
        viewHolder.mTxtServiceDesc.text = item.serviceDesc
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