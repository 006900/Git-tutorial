package com.example.rocho.presentation.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.rocho.presentation.model.Artist
import com.example.rocho.ui.theme.background
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

@Composable
fun HomeScreen(modifier: Modifier = Modifier,viewModel: HomeViewModel = HomeViewModel()) {
    val item = viewModel.artist.collectAsState()
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(background),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyRow (modifier = modifier.fillMaxWidth()){
            items (item.value){
                Item(item = it)
            }
        }
    }

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
private fun Item(modifier: Modifier = Modifier,item: Artist) {
    Column (horizontalAlignment = Alignment.CenterHorizontally){
        GlideImage(model = item.image.orEmpty(),contentDescription = null, modifier = modifier.size(60.dp).clip(CircleShape))
        Spacer(modifier.height(4.dp))
        Text(text = item.name.orEmpty(),color = Color.White)
    }
}
//fun createArtist(db: FirebaseFirestore){
//    val random = (1..10000).random()
//    val artist = Artist(name = "Alan $random",random)
//            db.collection("artist").add(artist).
//            addOnSuccessListener { Log.i("alan","Success") }.
//            addOnFailureListener { Log.i("alan","Failure") }.
//            addOnCompleteListener { Log.i("alan","Complete") }
//}