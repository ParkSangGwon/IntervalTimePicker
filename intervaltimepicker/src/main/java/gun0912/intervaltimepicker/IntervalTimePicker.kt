package gun0912.intervaltimepicker

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.Resources
import android.util.AttributeSet
import android.widget.NumberPicker
import android.widget.TimePicker
import kotlin.math.roundToInt


class IntervalTimePicker @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : TimePicker(context, attrs) {

    private val minuteInterval: Int


    init {
        with(context.obtainStyledAttributes(attrs, R.styleable.IntervalTimePicker)) {
            minuteInterval =
                getInt(R.styleable.IntervalTimePicker_interval, DEFAULT_MINUTE_INTERVAL)
            recycle()
        }
        setupMinutePicker()
    }

    @SuppressLint("DiscouragedApi")
    private fun setupMinutePicker() {
        val minuteResourceId = Resources.getSystem().getIdentifier("minute", "id", "android")
        findViewById<NumberPicker?>(minuteResourceId)?.apply {
            value = (value.toFloat() / minuteInterval).roundToInt()
            minValue = MIN_MINUTE
            maxValue = MAX_MINUTE / minuteInterval - 1
            displayedValues = mutableListOf<String>().apply {
                for (minute in MIN_MINUTE until MAX_MINUTE step minuteInterval) {
                    add(String.format("%02d", minute))
                }
            }.toTypedArray()
        }

    }

    override fun setMinute(minute: Int) {
        super.setMinute(minute / minuteInterval)
    }

    override fun getMinute(): Int = super.getMinute() * minuteInterval

    override fun setOnTimeChangedListener(onTimeChangedListener: OnTimeChangedListener) {
        super.setOnTimeChangedListener { view, hourOfDay, _ ->
            onTimeChangedListener.onTimeChanged(view, hourOfDay, minute)
        }
    }

    companion object {
        private const val DEFAULT_MINUTE_INTERVAL = 1
        private const val MIN_MINUTE = 0
        private const val MAX_MINUTE = 60
    }
}
