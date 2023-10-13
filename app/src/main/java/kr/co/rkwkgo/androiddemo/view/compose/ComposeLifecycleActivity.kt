package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

class ComposeLifecycleActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LifecycleContent()
		}
	}
}

@Composable
fun LifecycleContent(){
	AndroidDemoTheme {
		// A surface container using the 'background' color from the theme
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
//			MyComposable()
			LoginScreen(true)
		}
	}
}

data class Movie(val id: Int, val name: String, val description: String)


@Composable
fun MoviesScreenLazy(movies: List<Movie>){
	LazyColumn{
		items(movies, key = { movie -> movie.id }){movie ->
			MovieOverview(movie = movie)
		}

	}
}

@Composable
fun MoviesScreenWithKey(movies: List<Movie>){
	Column {
		for(movie in movies){
			key(movie.id){
				MovieOverview(movie = movie)
			}
		}
	}
}

@Composable
fun MoviesScreen(movies: List<Movie>){
	for( movie in movies){
		MovieOverview(movie)
	}
}

@Composable
fun MovieOverview(movie: Movie){

}


@Composable
fun LoginScreen(showError: Boolean){
	Column (modifier = Modifier.fillMaxWidth()){
		if(showError){
			LoginError()
		}
		LoginInput()
	}
}

@Composable
fun LoginInput() {
	TextField(
		modifier = Modifier.fillMaxWidth(),
		value = "", onValueChange = {

	})
}

@Composable
fun LoginError() {
	Text(
		text = "LoginError",
		color = Color.Red
	)
}

@Composable
fun MyComposable(){
	Column {
		Text("Hello")
		Text("World")
	}
}

@Preview(showBackground = true)
@Composable
fun PreviewLifecycleContent(){
	LifecycleContent()
}