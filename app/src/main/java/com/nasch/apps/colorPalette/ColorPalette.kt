package com.nasch.apps.colorPalette


import android.app.Dialog
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.graphics.alpha
import androidx.core.graphics.toColor
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nasch.apps.R


class ColorPalette : AppCompatActivity() {

    private lateinit var verticalBarsAdapter: VerticalBarsAdapter
    private lateinit var rvVerticalBars: RecyclerView
    private lateinit var cvH1: CardView
    private lateinit var cvH2: CardView
    private lateinit var cvH3: CardView
    private lateinit var colorButton: Button

    private lateinit var H120 : RadioButton
    private lateinit var H250 : RadioButton
    private lateinit var H380 : RadioButton
    private lateinit var V120 : RadioButton
    private lateinit var V235 : RadioButton
    private lateinit var V350 : RadioButton
    private lateinit var V465 : RadioButton
    private lateinit var V580 : RadioButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_palette)
        initcomponents()
        initUI()
        initListeners()

    }


    private fun initcomponents() {
        rvVerticalBars= findViewById(R.id.rvVerticalBars)
        cvH1 = findViewById(R.id.cvH1)
        cvH2 = findViewById(R.id.cvH2)
        cvH3 = findViewById(R.id.cvH3)
        colorButton = findViewById(R.id.changeButton)
    }

    private var verticalBarsList = mutableListOf(
        VerticalBar(R.string.v1_20.toString(), Color.argb(20, 2, 2, 2)),
        VerticalBar(R.string.v2_35.toString(), Color.argb(35, 2, 2, 2)),
        VerticalBar(R.string.v3_50.toString(), Color.argb(50, 2, 2, 2)),
        VerticalBar(R.string.v4_65.toString(), Color.argb(65, 2, 2, 2)),
        VerticalBar(R.string.v5_80.toString(), Color.argb(80, 2, 2, 2))
    )

    private fun initUI(){
        verticalBarsAdapter = VerticalBarsAdapter(verticalBarsList)
        rvVerticalBars.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvVerticalBars.adapter = verticalBarsAdapter
    }

    private fun showDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.activity_dialog_change_color)
        val applyButton: Button = dialog.findViewById(R.id.applyButton)
        var rgBars: RadioGroup = dialog.findViewById(R.id.rgBars)
        var rgColors: RadioGroup = dialog.findViewById(R.id.rgColors)

        applyButton.setOnClickListener {
        val selectedIdBars = rgBars.checkedRadioButtonId
        val selectedIdColors = rgColors.checkedRadioButtonId
        val selectedRadioButtonBars: RadioButton = rgBars.findViewById(selectedIdBars)
        val selectedRadioButtonColors: RadioButton = rgColors.findViewById(selectedIdColors)

        var black = arrayOf(R.color.black_20, R.color.black_35, R.color.black_50, R.color.black_65, R.color.black_80)
        val blue = arrayOf(R.color.blue_20, R.color.blue_35, R.color.blue_50, R.color.blue_65 ,R.color.blue_80)
        val orange = arrayOf(R.color.orange_20, R.color.orange_35, R.color.orange_50, R.color.orange_65 ,R.color.orange_80)
        val green = arrayOf(R.color.green_20, R.color.green_35, R.color.green_50, R.color.green_65 ,R.color.green_80)
        val red = arrayOf(R.color.red_20, R.color.red_35, R.color.red_50, R.color.red_65 ,R.color.red_80)
        val pink = arrayOf(R.color.pink_20, R.color.pink_35, R.color.pink_50, R.color.pink_65 ,R.color.pink_80)
        val yellow = arrayOf(R.color.yellow_20, R.color.yellow_35, R.color.yellow_50, R.color.yellow_65 ,R.color.yellow_80)
        val white = arrayOf(R.color.white_20, R.color.white_35, R.color.white_50, R.color.white_65,R.color.white_80)

        var currentColor =
            arrayOf(R.color.black_20, R.color.black_35, R.color.black_50, R.color.black_65, R.color.black_80)

        when (selectedRadioButtonColors.text.toString()) { //.toString()
            "Black" -> {
                currentColor = black
            }

            "White" -> {
                currentColor = white
            }

            "Blue" -> {
                currentColor = blue
            }

            "Orange" -> {
                currentColor = orange
            }

            "Green" -> {
                currentColor = green
            }

            "Red" -> {
                currentColor = red
            }

            "Pink" -> {
                currentColor = pink
            }

            "Yellow" -> {
                currentColor = yellow
            }
        }
        when (selectedRadioButtonBars.text.toString()) { //.toString()
            "H1 20%" -> {
                cvH1.setCardBackgroundColor(getColor(currentColor[0]))
            }

            "H2 50%" -> {
                cvH2.setCardBackgroundColor(getColor(currentColor[2]))
            }

            "H3 80%" -> {
                cvH3.setCardBackgroundColor(getColor(currentColor[3]))
            }

            "V1 20%" -> {
                verticalBarsList[0].color = getColor(currentColor[0])
            }

            "V2 35%" -> {
                verticalBarsList[1].color = getColor(currentColor[1])
            }

            "V3 50%" -> {
                verticalBarsList[2].color = getColor(currentColor[2])
            }

            "V4 65%" -> {
                verticalBarsList[3].color = getColor(currentColor[3])
            }

            "V5 80%" -> {
                verticalBarsList[4].color = getColor(currentColor[4])
            }

        }
            updateVerticalBars()
            dialog.hide()
    }
        dialog.show()
    }

    private fun updateVerticalBars() {
        rvVerticalBars.adapter?.notifyDataSetChanged()
    }

    private fun initListeners() {
        colorButton.setOnClickListener{ showDialog()}
    }

}