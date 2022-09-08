package com.example.notbored

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.notbored.databinding.ActivitySuggestionsBinding
import com.example.notbored.service.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuggestionsActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySuggestionsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuggestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val numParticipants = intent.getStringExtra("numParticipants")?.toInt()
        val typeActivities = intent.getStringExtra("typeActivities")?.lowercase()
        if(!typeActivities.equals("random")){
            binding.tvCategoryActivity.visibility = View.GONE
        }

        search(getEndPoint(numParticipants,typeActivities))

        binding.btnTryAgain.setOnClickListener {
            search( getEndPoint(numParticipants,typeActivities))
        }
        binding.btnArrow.setOnClickListener {
            finish()
        }

        binding.tvSuggestionsHead.text = typeActivities
    }

    private fun getRetrofit (): Retrofit{
        return Retrofit.Builder()
            .baseUrl("http://www.boredapi.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun search(query:String){
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getRequest(query)
            val respuesta = call.body()
            runOnUiThread {
                if (call.isSuccessful) {
                    binding.tvActivity.text = respuesta?.activity ?: getString(R.string.without_activity)
                    binding.tvNumParticipants.text = respuesta?.participants.toString()
                    binding.tvCategoryActivity.text = respuesta?.type
                    val price = respuesta?.price
                    price?.let { binding.tvCategoryPrice.text = calculatePrice(it) }
                    //mostrar
                } else {
                    //error
                    showEroor()
                }
            }
        }

    }

    private fun calculatePrice(price: Float):String{
         return when(price){
             0f ->  "Free"
             in 0.1..0.3 -> "Low"
             in 0.4..0.6 -> "Medium"
            else -> {
                "High"
            }
        }
    }

    private fun showEroor(){
        Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show()
    }
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