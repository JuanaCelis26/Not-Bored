package com.example.notbored

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        search(getEndPoint(numParticipants,typeActivities))

        binding.btnTryAgain.setOnClickListener {
            search( getEndPoint(numParticipants,typeActivities))
        }
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
                    binding.tvActivity.text = respuesta?.activity ?:"No hay :("
                    val actividad  = respuesta?.activity?: ":("
                    val participantes = respuesta?.participants?: "0"
                    println(actividad+" "+participantes + " "+respuesta?.type )
                    //mostrar
                } else {
                    //error
                    showEroor()
                }
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