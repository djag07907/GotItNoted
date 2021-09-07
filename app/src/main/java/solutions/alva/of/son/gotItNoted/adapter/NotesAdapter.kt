package solutions.alva.of.son.gotItNoted.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rv_notes.view.*
import solutions.alva.of.son.gotItNoted.R
import solutions.alva.of.son.gotItNoted.entities.Notes

class NotesAdapter(val arrList : List<Notes>) :
        RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes,parent,false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.itemView.tvTitle.text = arrList[position].title
        holder.itemView.tvDescription.text = arrList[position].noteText
        holder.itemView.tvDateTime2.text = arrList[position].dateTime
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view){

    }

}