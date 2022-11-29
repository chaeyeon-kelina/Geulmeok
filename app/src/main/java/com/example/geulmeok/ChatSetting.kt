package com.example.geulmeok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar

class ChatSetting : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_setting)

        val mToolbar: Toolbar = findViewById<View>(R.id.tool_bar_setting) as Toolbar
        setSupportActionBar(mToolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);       //앱 네임 없애기
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, Chatting::class.java) //지금 액티비티에서 다른 액티비티로 이동하는 인텐트 설정
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP //인텐트 플래그 설정
        startActivity(intent) //인텐트 이동
        finish() //현재 액티비티 종료
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
        }
        return result
    }
}