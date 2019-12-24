package com.example.sopt.feature

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.data.WebToonItem
import kotlinx.android.synthetic.main.rv_webtoon_item.view.*
import org.w3c.dom.Text

class WebToonViewHolder(view : View) : RecyclerView.ViewHolder(view) {
    val view : View = view.findViewById(R.id.rvItem)

    val txtTitle : TextView = view.findViewById(R.id.txtRvItemTitle)
    val txtRate : TextView = view.findViewById(R.id.txtRvItemRate)
    val txtAuthor : TextView = view.findViewById(R.id.txtRvItemAuthor)

    fun bind(data : WebToonItem) {
        txtTitle.text = data.title
        txtRate.text = data.rate
        txtAuthor.text = data.author
        
    }
}