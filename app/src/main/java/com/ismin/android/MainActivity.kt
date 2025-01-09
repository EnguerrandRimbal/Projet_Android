package com.ismin.android

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val SERVER_BASE_URL = "https://api.npoint.io"
const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap
    private val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
        .baseUrl(SERVER_BASE_URL).build()
    private val remarkablePlaceService = retrofit.create(RemarkablePlaceService::class.java)
    private lateinit var places: List<RemarkablePlace>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_main)

        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        Log.d(TAG, "onMapReady called")
        googleMap = map
        val grenoble = LatLng(45.188529, 5.724524)
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(grenoble, 12f))

        remarkablePlaceService.getRemarkablePlaces().enqueue(object : Callback<List<RemarkablePlace>> {
            override fun onResponse(call: Call<List<RemarkablePlace>>, response: Response<List<RemarkablePlace>>) {
                Log.d(TAG, "API call successful")
                places = response.body() ?: emptyList()
                if (places.isNotEmpty()) {
                    Log.d(TAG, "Number of places received: ${places.size}")
                    places.forEach { place ->
                        Log.d(TAG, "Place received: $place")
                        val position = LatLng(place.coordinates[1], place.coordinates[0])
                        googleMap.addMarker(MarkerOptions().position(position).title(place.properties.libelle))
                    }
                } else {
                    Log.d(TAG, "No places received")
                }
            }

            override fun onFailure(call: Call<List<RemarkablePlace>>, t: Throwable) {
                Log.e(TAG, "API call failed", t)
            }
        })

        googleMap.setOnMarkerClickListener { marker ->
            Log.d(TAG, "Marker clicked: ${marker.title}")
            val place = places.find { it.properties.libelle == marker.title }
            if (place != null) {
                val intent = Intent(this, RemarkablePlaceDetailActivity::class.java)
                intent.putExtra("place", place)
                startActivity(intent)
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}