package kr.co.rkwkgo.androiddemo.view.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

/**
 * Text and typography
 */
class TextDemoActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			TextDemoContent()
		}
	}
}

@Composable
private fun TextDemoContent(){
	AndroidDemoTheme {
		// A surface container using the 'background' color from the theme
		Surface(
			modifier = Modifier.fillMaxSize(),
			color = MaterialTheme.colorScheme.background
		) {
			TextDemoPage()
		}
	}
}

@Preview
@Composable
private fun PreviewTextDemoPage(){
	TextDemoPage()
}

@Composable
private fun TextDemoPage(){
	Scaffold {
		TextDemoBody(Modifier.padding(it))
	}
}

@Composable
private fun TextDemoBody(
	modifier: Modifier = Modifier
){
	Column(
		modifier = modifier.verticalScroll(rememberScrollState())
	) {
		ParagraphStyles()
		OpacitySpanStyle()
		BrushSpanStyle()
		BrushTextStyle()
		MultipleStylesInText()
		TextShadow()
		BoldText()
		ItalicText()
		BigText()
		BlueText()
		SimpleText()
		StringResourceText()
	}
}

@Composable
private fun ParagraphStyles(){
	Text(
		buildAnnotatedString { 
			withStyle(
				style = ParagraphStyle(lineHeight = 30.sp)
			){
				withStyle(style = SpanStyle(color = Color.Blue)){
					append("Hello\n")
				}
				withStyle(style = SpanStyle(
					fontWeight = FontWeight.Bold, color = Color.Red
				)){
					append("World\n")
				}
				append("Compose")
			}
		}
	)
}

@Composable
private fun OpacitySpanStyle(){
	val rainbowColors = listOf(Color.Cyan, Color.Blue, Color.Green)
	val brush = Brush.linearGradient(colors = rainbowColors)
	Text(
		text = buildAnnotatedString {
			withStyle(
				SpanStyle(
					brush = brush, alpha = .5f
				)
			){
				append("Text in")
			}
			withStyle(
				SpanStyle(
					brush = brush, alpha = 1f
				)
			){
				append("Compose *")
			}
		}
	)
}

@Composable
private fun BrushSpanStyle(){
	val rainbowColors = listOf(Color.Cyan, Color.Blue, Color.Green)
	Text(
		text = buildAnnotatedString {
			append("Do not allow people to dim your shine\n")
			withStyle(
				SpanStyle(
					brush = Brush.linearGradient(
						colors = rainbowColors
					)
				)
			){
				append("because they are blinded.")
			}
			append("\nTell them to put some sunglasses on.")
		}
	)
}

@Composable
private fun BrushTextStyle(){
	val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Green)
	Text(
		text = stringResource(id = R.string.dummy_short_text),
		style = TextStyle(
			brush = Brush.linearGradient(
				colors = gradientColors
			)
		)
	)
}

@Composable
private fun MultipleStylesInText(){
	Text(
		buildAnnotatedString {
			withStyle(style = SpanStyle(color = Color.Blue)){
				append("H")
			}
			append("ello ")
			withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Red)){
				append("W")
			}
			append("orld")
		}
	)
}

@Composable
private fun TextShadow(){
	val offset = Offset(5.0f, 10.0f)
	Text(
		text = "Hello world!",
		style = TextStyle(
			fontSize = 24.sp,
			shadow = Shadow(
				color  = Color.Blue,
				offset = offset,
				blurRadius = 3f
			)
		)
	)
}

@Composable
private fun BoldText(){
	Text("Hello World", fontWeight = FontWeight.Bold)
}

@Composable
private fun ItalicText(){
	Text("Hello World", fontStyle = FontStyle.Italic)
}

@Composable
private fun BigText(){
	Text("Hello World", fontSize = 30.sp)
}

@Composable
private fun BlueText(){
	Text("Hello World", color = Color.Blue)
}

@Composable
private fun StringResourceText(){
	Text(stringResource(id = R.string.dummy_long_text))
}

@Composable
private fun SimpleText(){
	Text("Hello World")
}

