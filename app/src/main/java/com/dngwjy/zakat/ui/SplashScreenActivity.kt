package com.dngwjy.zakat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import com.dngwjy.zakat.R
import com.dngwjy.zakat.ui.main.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    private var handler: Handler?=null
    private val runnable=Runnable{
        if(!isFinishing){
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.requestFeature(Window.FEATURE_ACTION_BAR)
        setContentView(R.layout.activity_spash_screen)
        supportActionBar?.hide()
        startSplash()
    }
    private fun startSplash(){
        handler= Handler()
        handler!!.postDelayed(runnable,2000)
    }

    override fun onDestroy() {
        if(handler!=null){
            handler!!.removeCallbacks(runnable)
        }
        super.onDestroy()
    }
}
