package com.example.vipmenu

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vipmenu.databinding.ActivityRecipeDetailsBinding

class RecipeDetailsActivity : AppCompatActivity() {
    lateinit var garson: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRecipeDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        garson = findViewById(R.id.btnrecipe)

        val recipe = intent.getSerializableExtra("recipe") as? Recipes
garson.setOnClickListener{
    Toast.makeText(this, "Garsonunuz Geliyor", Toast.LENGTH_SHORT).show()
}
        // Tarif verilerini göster
        recipe?.let {

            binding.tvRecipeName.text = it.mealName
            binding.tvRecipeDescription.text = it.description
            binding.ivRecipeImage.setImageResource(it.imageResourceId)
            binding.circleImageView.setImageResource(it.circleImageResourceId)
            binding.btnrecipe.text = it.buttonText
        }
    }
}
