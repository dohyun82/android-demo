package kr.co.rkwkgo.androiddemo.biometric

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat
import kr.co.rkwkgo.androiddemo.databinding.ActivityBiometricBinding
import java.nio.charset.Charset
import java.security.KeyStore
import java.util.concurrent.Executor
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

/**
 * 생체 인증
 */
class BiometricActivity : AppCompatActivity() {

	companion object{
		private val REQUEST_CODE_BIOMETRIC = 1000
		private val KEY_NAME = "keyName"
	}

	private lateinit var executor: Executor
	private lateinit var biometricPrompt: BiometricPrompt
	private lateinit var promptInfo: BiometricPrompt.PromptInfo

	private lateinit var mBinding: ActivityBiometricBinding

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		mBinding = ActivityBiometricBinding.inflate(layoutInflater)
		setContentView(mBinding.root)
		executor = ContextCompat.getMainExecutor(this)
		biometricPrompt = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback(){
			override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
				super.onAuthenticationError(errorCode, errString)
				Toast.makeText(this@BiometricActivity, "인증 에러 : $errString", Toast.LENGTH_SHORT).show()
			}

			override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
				super.onAuthenticationSucceeded(result)
				Toast.makeText(this@BiometricActivity, "인증 성공", Toast.LENGTH_SHORT).show()
				val encryptedInfo: ByteArray = result.cryptoObject?.cipher?.doFinal(
					"password".toByteArray(Charset.defaultCharset())
				)!!
			}

			override fun onAuthenticationFailed() {
				super.onAuthenticationFailed()
				Toast.makeText(this@BiometricActivity, "인증 실패", Toast.LENGTH_SHORT).show()
			}

		})

		promptInfo = BiometricPrompt.PromptInfo.Builder()
			.setTitle("생체 인증")
			.setSubtitle("지문을 인증해 주세요")
			.setNegativeButtonText("취소")
			.build()

		mBinding.btnBioMetric.setOnClickListener {
			val cipher = getCipher()
			val secretKey = getSecretKey()
			cipher.init(Cipher.ENCRYPT_MODE, secretKey)
			biometricPrompt.authenticate(promptInfo, BiometricPrompt.CryptoObject(cipher))
		}

		checkBiometric()
	}

	/**
	 * 생체인증 체크하기
	 */
	private fun checkBiometric(){
		val biometricManager = BiometricManager.from(this)
		when (biometricManager.canAuthenticate(BIOMETRIC_STRONG)) {
			BiometricManager.BIOMETRIC_SUCCESS ->{
				Log.d("MY_APP_TAG", "App can authenticate using biometrics.")
				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
					generateSecretKey(KeyGenParameterSpec.Builder(
						KEY_NAME,
						KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)
						.setBlockModes(KeyProperties.BLOCK_MODE_CBC)
						.setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
						.setUserAuthenticationRequired(true)
						// Invalidate the keys if the user has registered a new biometric
						// credential, such as a new fingerprint. Can call this method only
						// on Android 7.0 (API level 24) or higher. The variable
						// "invalidatedByBiometricEnrollment" is true by default.
						.setInvalidatedByBiometricEnrollment(true)
						.build())
				}
			}
			BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
				Log.e("MY_APP_TAG", "No biometric features available on this device.")
			BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
				Log.e("MY_APP_TAG", "Biometric features are currently unavailable.")
			BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
				// Prompts the user to create credentials that your app accepts.
				val enrollIntent = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
					Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
						putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED, BIOMETRIC_STRONG)
					}
				} else {
					Intent(Settings.ACTION_SETTINGS)
				}
				startActivityForResult(enrollIntent, REQUEST_CODE_BIOMETRIC)
			}
			else -> {

			}
		}
	}

	private fun generateSecretKey(keyGenParameterSpec: KeyGenParameterSpec) {
		val keyGenerator = KeyGenerator.getInstance(
			KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			keyGenerator.init(keyGenParameterSpec)
		}
		keyGenerator.generateKey()
	}

	private fun getSecretKey(): SecretKey {
		val keyStore = KeyStore.getInstance("AndroidKeyStore")

		// Before the keystore can be accessed, it must be loaded.
		keyStore.load(null)
		return keyStore.getKey(KEY_NAME, null) as SecretKey
	}

	private fun getCipher(): Cipher {
		return Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
			+ KeyProperties.BLOCK_MODE_CBC + "/"
			+ KeyProperties.ENCRYPTION_PADDING_PKCS7)
	}

}