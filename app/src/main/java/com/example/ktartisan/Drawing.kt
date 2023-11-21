package com.example.kotlinartisan

import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.ktartisan.R

private lateinit var drawingView: Drawing
private lateinit var deleteButton: ImageButton
private lateinit var saveButton: ImageButton
private lateinit var shrinkButton: ImageButton
private lateinit var growButton: ImageButton
private lateinit var undoButton: ImageButton
class Drawing : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing)

        drawingView = findViewById(R.id.drawingView)
        deleteButton = findViewById(R.id.deleteButton)
        saveButton = findViewById(R.id.saveButton)
        shrinkButton = findViewById(R.id.shrinkButton)
        growButton = findViewById(R.id.growButton)
        undoButton = findViewById(R.id.undoButton)

        deleteButton.setOnClickListener { drawingView.clearDrawing() }
        saveButton.setOnClickListener {val bitmap = Bitmap.createBitmap(drawingView.width, drawingView.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            drawingView.draw(canvas) }
        shrinkButton.setOnClickListener { drawingView.shrinkShape() }
        growButton.setOnClickListener { drawingView.growShape() }
        undoButton.setOnClickListener { drawingView.undo() }
    }
}