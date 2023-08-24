package kr.co.rkwkgo.androiddemo.view.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.rkwkgo.androiddemo.R
import kr.co.rkwkgo.androiddemo.model.compose.SampleData
import kr.co.rkwkgo.androiddemo.model.compose.UserInfo
import kr.co.rkwkgo.androiddemo.view.compose.ui.theme.AndroidDemoTheme

class TutorialActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			AndroidDemoTheme {
				UserInfoCard(userInfo = UserInfo(name = "Kim DoHyun", age = 41))
			}
		}
	}
}


@Composable
private fun UserInfoCard(userInfo: UserInfo){
	Row(modifier = Modifier.padding(8.dp)) {
		Image(
			painter = painterResource(id =R.drawable.profile_picture),
			contentDescription = "프로필 사진",
			modifier = Modifier
				.size(40.dp)
				.clip(CircleShape)
				.border(width = 1.5.dp, MaterialTheme.colorScheme.primary, CircleShape)
		)
		Spacer(modifier = Modifier.width(8.dp))
		Column {
			Text(
				text = userInfo.name,
				color = MaterialTheme.colorScheme.secondary,
				style = MaterialTheme.typography.titleSmall
			)
			Spacer(modifier = Modifier.height(4.dp))

			Surface(shape = MaterialTheme.shapes.medium, shadowElevation = 1.dp) {
				Text(
					text = userInfo.age.toString(),
					modifier = Modifier.padding(all = 4.dp),
					style = MaterialTheme.typography.bodyMedium,
				)
			}
		}
	}
}

@Composable
fun Conversation(userInfoList: List<UserInfo>){
	LazyColumn{
		items(userInfoList) { userInfo ->
			UserInfoCard(userInfo = userInfo)
		}
	}
}

@Preview
@Composable
fun PreviewUserInfoList(){
	AndroidDemoTheme {
		Conversation(userInfoList = SampleData.userInfoList)
	}
}

@Preview(
	uiMode = Configuration.UI_MODE_NIGHT_NO,
	showBackground = true,
	name = "Light Mode"
)
@Preview(
	uiMode = Configuration.UI_MODE_NIGHT_YES,
	showBackground = true,
	name = "Dark Mode"
)
@Composable
fun PreviewUserInfoCard(){
	AndroidDemoTheme {
		UserInfoCard(userInfo = UserInfo(name = "Kim DoHyun", age = 41))
	}
}