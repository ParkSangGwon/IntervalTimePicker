package gun0912.intervaltimepicker.sample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import gun0912.intervaltimepicker.IntervalTimePicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<IntervalTimePicker>(R.id.time_picker).setOnTimeChangedListener { _, hourOfDay, minute ->
            Log.d("ted", "${hourOfDay}:${minute}")
        }
    }
}
