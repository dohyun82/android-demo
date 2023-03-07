package kr.co.rkwkgo.androiddemo.compose.utils

data class RandomUser(
	val name: String = "개발하는 김대리",
	val description: String = "오늘도 빡코딩",
	val profileImage: String = "https://randomuser.me/api/portraits/women/71.jpg"
)

object DummyDataProvider {

	val userList = List<RandomUser>(200){ RandomUser() }

}