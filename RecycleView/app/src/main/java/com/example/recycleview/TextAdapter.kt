package com.example.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val itemList: List<String>) :
    RecyclerView.Adapter<TextAdapter.TextViewHolder>() {

    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textItem: TextView = view.findViewById(R.id.textItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextAdapter.TextViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_text, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextAdapter.TextViewHolder, position: Int) {
        holder.textItem.text = itemList[position]
    }

    override fun getItemCount() = itemList.size
    }

