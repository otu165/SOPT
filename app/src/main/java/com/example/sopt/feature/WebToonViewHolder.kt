package com.example.sopt.feature

import android.content.Intent
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.sopt.R
import com.example.sopt.WebPageActivity
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

        view.setOnClickListener {
            Toast.makeText(view.context, "웹툰 페이지로 이동합니다.", Toast.LENGTH_SHORT).show()

            val intent = Intent(view.context, WebPageActivity::class.java)
            view.context.startActivity(intent)
        }
    }
}