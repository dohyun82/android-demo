package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

/**
 * Pager
 */
class ComposePagerActivity: ComponentActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PagerContent()
		}
	}

}

@Composable
private fun PagerContent(){
	AndroidDemoTheme {
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			PagerPage()
		}
	}
}

@Preview
@Composable
private fun PreviewPagerPage(){
	PagerPage()
}

@Composable
private fun PagerPage(){
	Scaffold {
		PagerBody(
			modifier = Modifier.padding(it)
		)
	}
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun PagerBody(
	modifier: Modifier = Modifier
){
	val pagerState = rememberPagerState {
		10
	}
	Box(
		modifier = modifier.fillMaxSize()
	){
		HorizontalPager(state = pagerState) { page ->
			Text(
				text = "page: $page",
				modifier = Modifier.fillMaxWidth()
			)
		}
	}
}

