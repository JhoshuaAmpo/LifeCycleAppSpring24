package edu.fullerton.fz.cs411.simpleandroidappspring24

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

const val LOG_TAG = "MyApp"

const val COUNTER_KEY = "myCounterKey"

class MainActivity : AppCompatActivity() {

    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
    private lateinit var counterText: TextView

    private val myCounterViewModel: MyCounterViewModel by lazy {
        ViewModelProvider(this).get(MyCounterViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        Log.d(LOG_TAG, "onCreate called")

        val cntr = savedInstanceState?.getInt(COUNTER_KEY, 0) ?: 0
        myCounterViewModel.setCounter(cntr)

        setContentView(R.layout.activity_main)

        counterText = findViewById(R.id.textCounter)

        this.nextButton = this.findViewById(R.id.buttonNext)
        val nextButtonLocal: Button? = this.findViewById(R.id.buttonNext)
        if (nextButtonLocal != null) {
            nextButton.setOnClickListener {
                Log.d(LOG_TAG, "next clicked")
                var counter = myCounterViewModel.getCounter()
                counter += 1
                myCounterViewModel.setCounter(counter)
                counterText.text = counter.toString()
            }
        }

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            this.prevButton = this.findViewById(R.id.buttonPrev)
            prevButton.setOnClickListener {
                var counter = myCounterViewModel.getCounter()
                counter -= 1
                myCounterViewModel.setCounter(counter)
                counterText.text = counter.toString()
            }
        }

        var counter = myCounterViewModel.getCounter()
        counterText.text = counter.toString()

    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause called")
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        Log.d(LOG_TAG, "SaveInstance is called")
        val counter = myCounterViewModel.getCounter()
        savedInstanceState.putInt(COUNTER_KEY, counter)
    }
}