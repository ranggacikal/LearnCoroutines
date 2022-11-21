package ranggacikal.co.id.learncoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import ranggacikal.co.id.learncoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val RESULT_1 = "Result #1"
    private val RESULT_2 = "Result #2"
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            CoroutineScope(IO).launch {
                fakeApiRequest()
            }
        }
    }

    private fun setNewText(input: String) = with(binding) {
        val newText = txtResult.text.toString() + "\n$input"
        txtResult.text = newText
    }

    private suspend fun setTextOnMainThread(input: String) {
        withContext(Main){
            setNewText(input)
        }
    }

    private suspend fun fakeApiRequest() = with(binding) {
        val result1 = getResult1FromApi()
        println("debug: $result1")
        setTextOnMainThread(result1)

        val result2 = getResult2FromApi()
        setTextOnMainThread(result2)
    }

    private suspend fun getResult1FromApi(): String {
        logThread("getResult1FromApi")
        delay(1000)
        return RESULT_1
    }

    private suspend fun getResult2FromApi(): String {
        logThread("getResult2FromApi")
        delay(1000)
        return RESULT_2
    }

    private fun logThread(method: String) {
        println("debug: ${method}: ${Thread.currentThread().name}")
    }
}