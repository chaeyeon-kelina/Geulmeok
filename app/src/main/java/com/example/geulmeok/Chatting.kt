package com.example.geulmeok

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class Chatting : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chatting)

        val mToolbar: Toolbar = findViewById<View>(R.id.tool_bar) as Toolbar
        setSupportActionBar(mToolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);       //앱 네임 없애기

        supportActionBar!!.setDisplayHomeAsUpEnabled(true) // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김


    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java) //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP //인텐트 플래그 설정
        startActivity(intent) //인텐트 이동
        finish() //현재 액티비티 종료
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {    //액티비티에 딸려 있는 메뉴를 최초로 구성할 때 1회만 호출
        Log.d("menu", "onCreateOptionsMenu")
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {       //버튼을 클릭하여 메뉴가 펼쳐질 때마다 호출
        Log.d("menu", "onPrepareOptionsMenu")
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var result = false
        when (item.getItemId()) {
            android.R.id.home -> {          //메뉴바의 뒤로가기 버튼 누르면
                val intent_chat = Intent(this, MainActivity::class.java)
                startActivity(intent_chat)
                finish()
                return true
            }
            R.id.action_settings ->{
                val intent_setting = Intent(this, ChatSetting::class.java)
                startActivity(intent_setting)
                finish()
                return true
            }
        }
        return result
    }

}