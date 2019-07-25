package com.yuyakaido.android.cardstackview.sample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CardStackAdapter(
        private var spots: List<Spot> = emptyList(),
        private var listener: IOnClickListener
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_spot, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spot = spots[position]
        holder.name.text = "${spot.name}"
        holder.subject.text = spot.subject
        holder.summary.text = spot.summary
        var sourceRes = 0;
        if(spot.source.equals("email")){
            sourceRes = R.drawable.outlook
        }else if(spot.source.equals("teams")){
            sourceRes = R.drawable.teams
        }else if(spot.source.equals("excel")){
            sourceRes = R.drawable.excel
        }

        holder.sourceimage.setImageResource(sourceRes)

        holder.tag1.text = spot.tags[0]

        if(spot.tags.size > 1 ){
            holder.tag2.text = spot.tags[1]
            holder.tag2.setVisibility(View.VISIBLE)
        }

        holder.itemView.setOnClickListener { v ->
            listener.onClick()
        }
    }

    override fun getItemCount(): Int {
        return spots.size
    }

    fun setSpots(spots: List<Spot>) {
        this.spots = spots
    }

    fun getSpots(): List<Spot> {
        return spots
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.sender_name)
        var subject: TextView = view.findViewById(R.id.subject)
        var sourceimage: ImageView = view.findViewById(R.id.source_icon)
        var summary: TextView = view.findViewById(R.id.summary)
        var tag1: TextView = view.findViewById(R.id.tag1)
        var tag2: TextView = view.findViewById(R.id.tag2)
    }

}
