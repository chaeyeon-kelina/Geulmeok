package com.example.geulmeok

//import com.example.geulmeok.databinding.ActivityMainBinding
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*

class MainActivity : AppCompatActivity() {

    lateinit var tab1 : FirstFragment
    lateinit var tab2 : chat
    lateinit var tab3 : third
    lateinit var tab4 : chart
    lateinit var tab5 : profile



//    lateinit var navController: NavController
//    companion object{
//        const val TAG = "MainActivity"
//    }
//    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent_chat = Intent(this, Chatting::class.java)

//        binding = ActivityMainBinding.inflate(layoutInflater)
////
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val view = binding.root
//        setContentView(view)
//        binding..setupWithNavController(navController)
//        navController = nav_host_fragment.findNavController()
//
//        findViewById<FloatingActionButton>(R.id.fab_routine).setOnClickListener {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.view_fragment_page, SecondFragment())
//                .addToBackStack(null).commit()
//        }


        tab1 = FirstFragment()
        tab2 = chat()
        tab3 = third()
        tab4 = chart()
        tab5 = profile()

        supportFragmentManager.beginTransaction().add(R.id.view_page, tab1).commit();
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when (tab?.position) {
                    0 -> {
                        //Tab1
                        replaceView(tab1)
                    }
                    1 -> {
                        startActivity(intent_chat)
                    }
                    2 -> replaceView(tab3)
                    3 -> replaceView(tab4)
                    4 -> replaceView(tab5)
                }
            }
        })


//        val adapter = PagerAdapter(supportFragmentManager)
////
//        adapter.addFragment(FirstFragment(), "1번")
////        adapter.addFragment(chat(), "2번")
////        adapter.addFragment(timer(), "3번")
////
//        viewpager.adapter = adapter
//        bottom_menu.setupWithViewPager(viewpager)
////
//        val adapter = PagerAdapter(supportFragmentManager)
//        adapter.addFragment(FirstFragment(), "메인")
//        adapter.addFragment(SecondFragment(), "채팅")
//        view_fragment_page.adapter = adapter
//        nav_btn_main.setupWithViewPager(after_login_viewpager)
//

    }


    fun changeFragment(index: Int){
        val intent_chatSetting = Intent(this, ChatSetting::class.java)
        when(index){
            1 -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.view_page, ChangeName())
                    .commit()
            }
            2 -> {
                startActivity(intent_chatSetting)
            }
        }
    }

    override fun startActivityForResult(intent: Intent?, requestCode: Int) {
        var intent = intent
        if (intent == null) {
            intent = Intent()
        }
        super.startActivityForResult(intent, requestCode)
    }

    private fun replaceView(tab: Fragment){
        //change fragment view
        var selectedFragment: Fragment? = null
        selectedFragment = tab
        selectedFragment?.let {
            supportFragmentManager.beginTransaction()
                .replace(R.id.view_page, it).commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}