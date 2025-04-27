package com.example.rocho.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rocho.presentation.model.Artist
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class HomeViewModel: ViewModel() {
    private var database = Firebase.database
    private var db: FirebaseFirestore = Firebase.firestore
    private val _artist = MutableStateFlow<List<Artist>>(emptyList())
    val artist : StateFlow<List<Artist>> = _artist

    init {
       // repeat (20){
       //     loadData()
       // }
        getArtist()
    }

   // private fun loadData() {
   //     val random = (1..1000).random()
   //     val artist = Artist(name = "jose", description = "jose : $random", image = "https://static.messi.com/wp-content/uploads/2023/07/Messi-INTER-silueta.png")
   //     db.collection("artist").add(artist)
   // }

    private fun getArtist() {
        viewModelScope.launch {
            val result : List<Artist> = withContext (Dispatchers.IO){
                getAllArtist()
            }
            _artist.value = result
        }
    }

    suspend fun getAllArtist(): List<Artist>{
        return try {
            db.
            collection("artist").
            get().
            await().
            documents.
            mapNotNull { it.toObject(Artist::class.java) }
        }catch (e: Exception){
            Log.i("alan",e.toString())
            emptyList()
        }

    }

}