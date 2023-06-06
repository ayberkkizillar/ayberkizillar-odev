package com.example.vipmenu

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {
    private var arraySubCategory = ArrayList<Recipes>()

    inner class RecipeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textView: TextView? = null
        var imageView: ImageView? = null

        init {
            textView = view.findViewById(R.id.tv_dish_name)
            imageView = view.findViewById(R.id.iv_dish_image)
        }
    }


    fun setData(arrData: ArrayList<Recipes>) {
        arraySubCategory = arrData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rv_sub_category, parent, false)
        return RecipeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arraySubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = arraySubCategory[position]
        holder.textView?.text = recipe.dishName
        holder.imageView?.setImageResource(recipe.imageResourceId)

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, RecipeDetailsActivity::class.java)
            intent.putExtra("recipe", recipe)
            holder.itemView.context.startActivity(intent)
        }
    }


}
