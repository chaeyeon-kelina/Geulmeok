package com.example.geulmeok

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fragment_third.*
import me.relex.circleindicator.CircleIndicator3


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [third.newInstance] factory method to
 * create an instance of this fragment.
 */
class third : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var viewGroup //뷰그룹 객체 선언
            : ViewGroup? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewGroup = inflater.inflate(R.layout.fragment_third, container, false) as ViewGroup
        // Inflate the layout for this fragment
        setInit()

        return viewGroup;

    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment third.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            third().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


    private lateinit var viewPageSetUp: ViewPager2
    private val num_page = 2
    private lateinit var mIndicator: CircleIndicator3
    private fun setInit() { //뷰페이저2 실행 메서드

        /* setup infinity scroll viewpager */
        val viewPageSetUp: ViewPager2 = viewGroup!!.findViewById(R.id.viewPager2)
        mIndicator = viewGroup!!.findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPageSetUp);
        mIndicator.createIndicators(num_page, 0);

        val SetupPagerAdapter =
            activity?.let { FragPagerAdapter(it) } //프래그먼트에서는 getActivity로 참조하고, 액티비티에서는 this를 사용해주세요.
        viewPageSetUp.adapter = SetupPagerAdapter //FragPagerAdapter를 파라머티로 받고 ViewPager2에 전달 받는다.
        viewPageSetUp.orientation = ViewPager2.ORIENTATION_HORIZONTAL //방향은 가로로
        viewPageSetUp.offscreenPageLimit = 2 //페이지 한계 지정 갯수


//        registerAdapterDataObserver(mIndicator.getAdapterDataObserver());



        // 무제한 스크롤 처럼 보이기 위해서는 0페이지 부터가 아니라 1000페이지 부터 시작해서 좌측으로 이동할 경우 999페이지로 이동하여 무제한 처럼 스크롤 되는 것 처럼 표현하기 위함.
//        viewPageSetUp.currentItem = 1000
//        val pageMargin =
//            resources.getDimensionPixelOffset(R.dimen.pageMargin).toFloat() //페이지끼리 간격
//        val pageOffset =
//            resources.getDimensionPixelOffset(R.dimen.offset).toFloat() //페이지 보이는 정도
//        viewPageSetUp.registerOnPageChangeCallback(object : OnPageChangeCallback() {
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//            }
//        })
//        viewPageSetUp.setPageTransformer { page, position ->
//            val offset = position * -(2 * pageOffset + pageMargin)
//            if (-1 > position) {
//                page.translationX = -offset
//            } else if (1 >= position) {
//                val scaleFactor =
//                    Math.max(0.7f, 1 - Math.abs(position - 0.14285715f))
//                page.translationX = offset
//                page.scaleY = scaleFactor
//                page.alpha = scaleFactor
//            } else {
//                page.alpha = 0f
//                page.translationX = offset
//            }
//        }
//        viewPageSetUp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
//                if (positionOffsetPixels == 0) {
//                    viewPageSetUp.setCurrentItem(position)
//                }
//            }
//
//            override fun onPageSelected(position: Int) {
//                super.onPageSelected(position)
//                mIndicator.animatePageSelected(position % num_page)
//            }
//        })
    }



}

