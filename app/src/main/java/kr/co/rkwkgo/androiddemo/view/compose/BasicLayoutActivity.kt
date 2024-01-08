package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

class BasicLayoutActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme{
				Surface {
					ArtistCard()
				}
			}
		}
	}
}

@Composable
private fun ArtistCard(){
	Row(
		modifier = Modifier.size(
			width = 400.dp,
			height = 100.dp
		),
		verticalAlignment = Alignment.CenterVertically
	){
		Image(
			painter = painterResource(id = R.drawable.ic_empty_user_img),
			contentDescription = "",
			modifier = Modifier.fillMaxHeight(),
		)
		Column {
			Text("제목", modifier = Modifier.paddingFromBaseline(top = 50.dp))
			Text("내용")
		}
	}
}

@Preview
@Composable
fun PreviewArtistCard(){
	ArtistCard()
}