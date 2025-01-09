package com.ismin.android

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class RemarkablePlaceDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_remarkable_place_detail)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val place = intent.getSerializableExtra("place") as RemarkablePlace

        findViewById<TextView>(R.id.libelle).text = place.properties.libelle
        findViewById<TextView>(R.id.commune).text = place.properties.commune
        findViewById<TextView>(R.id.type).text = place.properties.type
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}