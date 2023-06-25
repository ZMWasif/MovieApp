package com.example.movieapp.screens.home

import android.annotation.SuppressLint
import android.content.ContentValues
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieapp.MovieRow
import com.example.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Movies") },
            Modifier.background(color = MaterialTheme.colorScheme.primary));Modifier

    }) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<String> = listOf(
    "Avatar",
    "300",
    "Harry Potter",
    "Avengers",
    "Friends",
    "Hangover",
    "The Dark Knight",
    "Mission Impossible",
    "Inception"
)){
    Column(modifier = Modifier
        .padding(16.dp)
        .padding(top = 50.dp)) {
        LazyColumn {
            items(items = movieList){
                MovieRow(movie = it){
                        movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name)
                   // Log.d(ContentValues.TAG, "MainContent: $movie")
                }

            }
        }
    }

}