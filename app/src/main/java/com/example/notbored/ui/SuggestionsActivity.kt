package com.example.notbored.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.notbored.R
import com.example.notbored.databinding.ActivitySuggestionsBinding
import com.example.notbored.service.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
/**
 * the suggestions screen, shows an activity depending on the type, if it was random, it will show the type at the bottom
 * numParticipants is the number of participants selected.
 * typesActivities represents the selected type.
 * btnTryAnother repeats the search with the selected data.
 * btnBackToActivities redirects to the activities list section.
 * tvHead represents the header, the name of the activity.
 **/

class SuggestionsActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySuggestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numParticipants = intent.getStringExtra("numParticipants")?.toInt()
        val typeActivities = intent.getStringExtra("typeActivities")?.lowercase()
        val btnTryAnother = binding.btnTryAgain
        val btnBackToActivities = binding.btnArrow
        val tvHeader = binding.tvSuggestionsHead

        if(!typeActivities.equals("random")){
            binding.tvCategoryActivity.visibility = View.GONE
        }
        searchUrl(getEndPoint(numParticipants,typeActivities))
        btnTryAnother.setOnClickListener {
            searchUrl( getEndPoint(numParticipants,typeActivities))
        }
        btnBackToActivities.setOnClickListener {
            finish()
        }
        tvHeader.text = typeActivities
    }

    /**
     * This function returns an instance with the base URL
     **/
    private fun getRetrofit (): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /**
     * searchUrl makes the request to the API
     **/
    private fun searchUrl(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getRequest(query)
            val response = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    binding.tvActivity.text = response?.activity ?: getString(R.string.without_activity)
                    binding.tvNumParticipants.text = response?.participants.toString()
                    binding.tvCategoryActivity.text = response?.type
                    val price = response?.price
                    price?.let { binding.tvCategoryPrice.text = calculatePrice(it) }
                    //mostrar
                } else {
                    //error
                    showError()
                }
            }
        }

    }

    /**
     * calculatePrice assigns a category to the price depending on its value
     **/
    private fun calculatePrice(price: Float):String{
         return when{
             price == 0.0f ->  "Free"
             price > 0.0f && price <= 0.3f -> "Low"
             price > 0.3f && price <= 0.6f -> "Medium"
            else -> {
                "High"
            }
        }
    }

    private fun showError(){
        Toast.makeText(this,"Not response from API",Toast.LENGTH_SHORT).show()
    }

    /**
     * getEndPoint returns the secondary part of the url depending on the participants and activities
     **/
    private fun getEndPoint(numParticipants: Int?, typeActivities: String?):String{
        return when{
            numParticipants != 0 && !typeActivities.equals("random") ->{
                "activity/?participants=$numParticipants&type=$typeActivities"
            }
            numParticipants == 0 && typeActivities.equals("random") ->{
                "activity/"
            }
            numParticipants == 0 ->{
                "activity/?type=$typeActivities"
            }
            else -> {
                "activity/?participants=$numParticipants"
            }
        }
    }
}