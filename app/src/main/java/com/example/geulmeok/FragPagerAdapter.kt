package com.example.geulmeok

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class FragPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    //뷰페이저2에서는 FragmentStateAdapter를 사용한다.
    // Real Fragment Total Count
    private val mSetItemCount = 2 //프래그먼트 갯수 지정
    lateinit var frag1 : timer
    lateinit var frag2 : Mygroup

    override fun createFragment(position: Int): Fragment {
        val iViewIdx = getRealPosition(position)

        frag1 = timer()
        frag2 = Mygroup()

        return when (iViewIdx) {
            0 -> {
                frag1
            } //프래그먼트 순서에 맞게 넣어주세요.
            1 -> {
                frag2
            }
            else -> {
                frag1
            } //기본으로 나와있는 프래그먼트
        }
    }

    fun getRealPosition(_iPosition: Int): Int {
        return _iPosition % mSetItemCount
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}