package com.example.vipmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatDelegate
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vipmenu.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import java.util.ArrayList


class MainActivity : AppCompatActivity() {
    var arraySubCategory = ArrayList<Recipes>()
    var adapter = SubCategoryAdapter()
    lateinit var rv_sub_category: RecyclerView
    lateinit var garson: Button

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rv_sub_category = findViewById(R.id.rv_sub_category)
        garson = findViewById(R.id.garson)
        getImageResources()
        adapter = SubCategoryAdapter()
        rv_sub_category.adapter = adapter

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        garson.setOnClickListener {
            Toast.makeText(this, "Garsonunuz Geliyor", Toast.LENGTH_SHORT).show()
        }
        arraySubCategory.add(
            Recipes(
                1,
                "Noodle " + "$7.2",
                "N O O D L E",
                "Rice noodle with\nshrimps,egg,pork,choy,cabbage,Noodles\nfave or trying something completely new , we want\nyour\ntastebuds to be your happy buds",
                R.drawable.noodle,
                R.drawable.heart,
                "Garsonu Çağır"
            )
        )
        arraySubCategory.add(
            Recipes(
                2,
                "Rice of Bowl",
                "R I C E \n O F \n B O W L ",
                "Cook the rice, according to How to Cook Rice. (Or try Cilantro Lime Rice!)\n" +
                        "Cook the black beans: Mince the garlic. In a medium saucepan, heat the olive oil over medium heat. Add the garlic and sauté for 30 seconds to 1 minute until fragrant but not yet browned. Add the beans (drained but not rinsed), cumin, kosher salt, and several grinds of black pepper. Cook 2 minutes until warmed through. Taste and add additional salt if desired.\n" +
                        "Make the sauce (see above).\n" +
                        "Slice the tomatoes in half. Slice the avocado. Defrost the corn. Thinly slice the red onion.\n" +
                        "To serve, place rice in the bowl and top with black beans and vegetables. Drizzle with the sauce and top with torn cilantro.",
                R.drawable.rcbowl,
                R.drawable.heart,
                "Garsonu Çağır"
            )
        )

        arraySubCategory.add(
            Recipes(
                3,
                "Sushi",
                "S U S H I",
                "Sushi rolls or maki sushi is the most classic and traditional sushi one can make at home.\n To get started, you just need a few ingredients like tuna, cucumber, nori, and Japanese short-grain rice.\n You can certainly add whatever other fillings you like.\n Go ahead and try shredded egg crepe, avocado, carrot strips, kimchi, imitation crab, or pan-fried tofu",
                R.drawable.sushi,
                R.drawable.heart,
                "Garsonu Çağır"

            )
        )
        arraySubCategory.add(
            Recipes(
                4,
                "Ramen",
                "R A M E N",
                "\n" +
                        "Ramen noodles, scallions, garlic, soy sauce, eggs and sesame oil are also common ingredients in ramen recipes. For herbs and spices, ginger is popular. Salt is in 50% of ramen recipes and pepper, 30%.\n" +
                        "\n" +
                        "The average ramen recipe has about 11.8 ingredients, with a minimum of 3 and a maximum of 34.\n" +
                        "\n" +
                        "In terms of directions, ramen recipes have about 5.5 steps on average, ranging from 1 to 14 instructions.\n" +
                        "\n" +
                        "An average ramen recipe takes about 2 hours 27 minutes to prepare, ranging from 3 minutes to 1 day.",
                R.drawable.ramen,
                R.drawable.heart,
                "Garsonu Çağır"
            )
        )
        arraySubCategory.add(
            Recipes(
                5,
                "Yakisoba",
                "Y A K I S O B A ",
                "Yakisoba is a stir-fry dish made of Chinese-style wheat noodles, thinly sliced meat, and vegetables such as cabbage, carrots, onions, and bean sprouts and tossed with a thick, sweet-savory sauce. To finish off, it is often topped with a variety of garnishes.\n" +
                        "\n" +
                        "Although the name “yaki soba” implies fried buckwheat noodles, there’s no buckwheat (soba) used in the noodles at all. In Japan, the word soba is also being used to describe noodles of any type.\n" +
                        "\n" +
                        "Yakisoba noodles are called Mushi Chukamen (蒸し中華麺 or Steamed Chinese-style noodles). They are made of wheat flour, kansui, and water. Even though the color of the noodles is yellowish, they are not egg noodles, and the color is the result of using kansui. Yakisoba noodles are steamed and packaged, so they’re ready for a quick reheat. The texture of these noodles is similar to ramen noodles.\n" +
                        "\n" +
                        "It’s easy to make yakisoba at home, and you can add almost any ingredients to make it your style. Try it with chicken, shrimp, or calamari, or a simple vegetarian style with mushrooms for Meatless Mondays!",
                R.drawable.yakisoba,
                R.drawable.heart,
                "Garsonu Çağır"
            )
        )

        adapter.setData(arraySubCategory)

        rv_sub_category.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_sub_category.adapter = adapter


        navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> Toast.makeText(
                    applicationContext,
                    "Home tuşuna bastınız",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.rateus -> Toast.makeText(
                    applicationContext,
                    "Bizi Yıldızlayın ",
                    Toast.LENGTH_SHORT
                ).show()

                R.id.share -> Toast.makeText(applicationContext, "Paylaşın", Toast.LENGTH_SHORT)
                    .show()
            }
            true

        }

    }

    private fun getImageResources(): List<Int> {
        val imageResources = mutableListOf<Int>()
        for (recipe in arraySubCategory) {
            imageResources.add(recipe.imageResourceId)
        }
        return imageResources
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}
