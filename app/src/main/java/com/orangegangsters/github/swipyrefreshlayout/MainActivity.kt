package com.orangegangsters.github.swipyrefreshlayout

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.orangegangsters.github.swiperefreshlayout.R
import com.orangegangsters.github.swiperefreshlayout.databinding.ActivityMainBinding
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout.OnRefreshListener
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection

class MainActivity : AppCompatActivity(), OnRefreshListener, View.OnClickListener {
    /**
     * This view binding
     */
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        initLayout()
    }

    private fun initLayout() {
        mBinding.listview.adapter = DummyListViewAdapter()
        mBinding.swipyrefreshlayout.setOnRefreshListener(this)
        mBinding.buttonTop.setOnClickListener(this)
        mBinding.buttonBottom.setOnClickListener(this)
        mBinding.buttonBoth.setOnClickListener(this)
        mBinding.buttonRefresh.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.button_top -> mBinding.swipyrefreshlayout.direction =
                SwipyRefreshLayoutDirection.TOP
            R.id.button_bottom -> mBinding.swipyrefreshlayout.direction =
                SwipyRefreshLayoutDirection.BOTTOM
            R.id.button_both -> mBinding.swipyrefreshlayout.direction =
                SwipyRefreshLayoutDirection.BOTH
            R.id.button_refresh -> {
                mBinding.swipyrefreshlayout.isRefreshing = true
                Handler(Looper.getMainLooper()).postDelayed({ //Hide the refresh after 2sec
                    runOnUiThread { mBinding.swipyrefreshlayout.isRefreshing = false }
                }, 2000)
            }
        }
    }

    /**
     * Called when the [com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout]
     * is in refresh mode. Just for example purpose.
     */
    override fun onRefresh(direction: SwipyRefreshLayoutDirection) {
        Log.d(
            "MainActivity", "Refresh triggered at "
                + if (direction === SwipyRefreshLayoutDirection.TOP) "top" else "bottom"
        )
        Handler(Looper.getMainLooper()).postDelayed({ //Hide the refresh after 2sec
            runOnUiThread { mBinding.swipyrefreshlayout.isRefreshing = false }
        }, DISMISS_TIMEOUT.toLong())
    }

    companion object {
        /**
         * The dismiss time for [SwipyRefreshLayout]
         */
        const val DISMISS_TIMEOUT = 2000
    }
}