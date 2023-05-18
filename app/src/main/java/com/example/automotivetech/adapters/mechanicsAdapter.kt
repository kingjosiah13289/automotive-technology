package com.example.automotivetech.adapters


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.automotivetech.R
import com.example.automotivetech.models.Mechanics

class mechanicsAdapter(var context: Context, var data: ArrayList<Mechanics>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mechname:TextView
        var mechlocation:TextView
        var mechphone : TextView
        init {
            this.mechname = row?.findViewById(R.id.mechname_view) as TextView
            this.mechlocation = row?.findViewById(R.id.mechlocation_view) as TextView
            this.mechphone = row?.findViewById(R.id.mechphone_view) as TextView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.mechanics,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:Mechanics = getItem(position) as Mechanics
        viewHolder.mechname.text = item.mechname
        viewHolder.mechlocation.text = item.mechlocation
        viewHolder.mechphone.text = item.mechphone
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