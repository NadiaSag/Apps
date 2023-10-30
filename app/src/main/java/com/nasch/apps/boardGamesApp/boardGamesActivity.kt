package com.nasch.apps.boardGamesApp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nasch.apps.R
import com.nasch.apps.boardGamesApp.GameCategory.*

class boardGamesActivity : AppCompatActivity() {
    private lateinit var rvCategories: RecyclerView
    private lateinit var rvGames: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var gamesAdapter: GamesAdapter
    private lateinit var fabAddGame: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_board_game)

        initcomponents()
        initUI()
        initListeners()

    }
    private fun initListeners() {
        fabAddGame.setOnClickListener{ showDialog()}
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_game)
        val btnAddGame: Button = dialog.findViewById(R.id.btnAddGame)
        val etGame: EditText = dialog.findViewById(R.id.etGame)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)


        btnAddGame.setOnClickListener {
            val currentGame = etGame.text.toString()
            if (currentGame.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory: GameCategory = when (selectedRadioButton.text) {
                    getString(R.string.dialog_cooperative_category) -> Cooperative
                    getString(R.string.dialog_deckbuilding_category) -> Deckbuilding
                    getString(R.string.dialog_eurogames_category) -> Euro
                    getString(R.string.dialog_LCG_category) -> LCG

                    else -> Legacy//por poner algo para que no dé error
                }
                games.add(Game(currentGame, currentCategory))//si no es mutable no se puede añadir
                updateGames()
                dialog.hide()
            }
        }
        dialog.show()
    }

    private fun updateGames(){
        val selectedCategories: List<GameCategory> = categories.filter { it.isSelected }
        val newGames = games.filter { selectedCategories.contains(it.category) }
        gamesAdapter.games = newGames

        gamesAdapter.notifyDataSetChanged()
    }

    private fun onGameSelected(position:Int){
        games[position].isSelected = !games[position].isSelected
        updateGames()
    }


    private fun onCategoriesSelected(position: Int){
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateGames()
    }


    private val categories = mutableListOf(
        Cooperative,
        Deckbuilding,
        Euro,
        LCG,
        Legacy
    )

    private var games = mutableListOf(
        Game("Hero Realm", GameCategory.Deckbuilding),
        Game("Teamwork Quest", GameCategory.Cooperative),
        Game("Euro Ventures", GameCategory.Euro),
        Game("Legacy Chronicles", GameCategory.Legacy),
        Game("Cardmaster's Guild", GameCategory.LCG)
    )


    private fun initcomponents() {
        rvCategories = findViewById<RecyclerView>(R.id.rvCategories)
        rvGames = findViewById<RecyclerView>(R.id.rvGames)
        fabAddGame = findViewById(R.id.fabAddGame)

    }

    private fun initUI(){

        categoriesAdapter = CategoriesAdapter(categories) {position -> onCategoriesSelected(position)}
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter
        //el orden es súper importante
        gamesAdapter = GamesAdapter(games) {position -> onGameSelected(position)}
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvGames.adapter = gamesAdapter

    }

}