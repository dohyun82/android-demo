package kr.co.rkwkgo.androiddemo.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.co.rkwkgo.androiddemo.compose.ui.theme.AndroidDemoTheme
import kr.co.rkwkgo.androiddemo.R

class TextDemoActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					TextContainer()
				}
			}
		}
	}
}

//text: String,
//modifier: Modifier = Modifier,
//color: Color = Color.Unspecified,
//fontSize: TextUnit = TextUnit.Unspecified,
//fontStyle: FontStyle? = null,
//fontWeight: FontWeight? = null,
//fontFamily: FontFamily? = null,
//letterSpacing: TextUnit = TextUnit.Unspecified,
//textDecoration: TextDecoration? = null,
//textAlign: TextAlign? = null,
//lineHeight: TextUnit = TextUnit.Unspecified,
//overflow: TextOverflow = TextOverflow.Clip,
//softWrap: Boolean = true,
//maxLines: Int = Int.MAX_VALUE,
//onTextLayout: (TextLayoutResult) -> Unit = {},
//style: TextStyle = LocalTextStyle.current

@Composable
fun TextContainer(){
	val name = "rkwkgo"

	val scrollState = rememberScrollState()

	var words = stringResource(id = R.string.dummy_short_text)
	var wordsArray = words.split(" ")


	Column (
			modifier = Modifier
				.padding(10.dp)
				.fillMaxSize().verticalScroll(scrollState),
		verticalArrangement = Arrangement.spacedBy(10.dp),
			) {
		Text(text = "안녕하세요 $name" ,
			style = TextStyle(
				textAlign = TextAlign.Center
			),
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Yellow))
		Text(text = "안녕하세요 $name" ,
			style = TextStyle(
				textAlign = TextAlign.Start
			),
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Yellow))
		Text(text = "안녕하세요 $name" ,
			style = TextStyle(
				textAlign = TextAlign.End
			),
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Yellow))
		Text(text = stringResource(id = R.string.dummy_short_text),
			maxLines = 2,
			overflow = TextOverflow.Ellipsis,
			style = TextStyle(
				textAlign = TextAlign.Justify,
				textDecoration = TextDecoration.combine(
					listOf(
						TextDecoration.Underline,
						TextDecoration.LineThrough
					)
				)
			),
			fontWeight = FontWeight.W200,
			fontSize = 40.sp,
			fontFamily = FontFamily.SansSerif,
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Yellow))
		Text(text = stringResource(id = R.string.dummy_short_text) ,
			style = TextStyle(
				textAlign = TextAlign.Start,
				fontFamily = FontFamily(Font(R.font.cafe24syongsyong, weight = FontWeight.ExtraBold)),
				lineHeight = 40.sp,
				),
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Yellow))
		Text(text = buildAnnotatedString {
			append("안녕하세요")
			withStyle(style = SpanStyle(color = Color.Blue,
				fontSize = 40.sp,
				fontWeight = FontWeight.ExtraBold
				)){
				append("개발하는 정대리")
			}
			withStyle(style = SpanStyle(color = Color.Red)){
				append("안녕하세요")
			}
		})
		Text(text = buildAnnotatedString {
			wordsArray.forEach{
				if (it.contains("꽃")){
					withStyle(style = SpanStyle(color = Color.Green,
						fontSize = 80.sp,
						fontWeight = FontWeight.ExtraBold
						)){
						append("$it ")
					}
				}else{
					append("$it ")
				}
			}
		})

		ClickableText(text = AnnotatedString("클릭미!"), onClick = {

		})

		Text(text = stringResource(id = R.string.dummy_long_text),
			style = TextStyle(lineHeight = 20.sp)
			)
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
	AndroidDemoTheme {
		TextContainer()
	}
}