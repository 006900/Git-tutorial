package com.example.rocho.presentation.home

import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreen(modifier: Modifier = Modifier,db: FirebaseFirestore) {

}


//fun createArtist(db: FirebaseFirestore){
//    val random = (1..10000).random()
//    val artist = Artist(name = "Alan $random",random)
//            db.collection("artist").add(artist).
//            addOnSuccessListener { Log.i("alan","Success") }.
//            addOnFailureListener { Log.i("alan","Failure") }.
//            addOnCompleteListener { Log.i("alan","Complete") }
//}