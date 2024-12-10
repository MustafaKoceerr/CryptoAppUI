package com.kocerlabs.cryptoappmvvm.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.kocerlabs.cryptoappmvvm.data.network.model.TempModel
import com.kocerlabs.cryptoappmvvm.databinding.FragmentDashboardBinding
import com.kocerlabs.simplifiedcodingmvvm.ui.base.BaseFragment

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding = FragmentDashboardBinding.inflate(inflater, container, false)

    private val lineData = arrayListOf(1000, 1100, 1200, 1100)
    private val lineData2 = arrayListOf(2100, 2000, 1900, 2000)
    private val lineData3 = arrayListOf(900, 1100, 1200, 1000, 1150)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cryptoList()
        stockList()
    }

    private fun cryptoList() {
        val domainMutableList = mutableListOf(
            TempModel("bitcoin", "BTX", 1234.12, 2.13, lineData, 1234.12, 0.123),
            TempModel("etherium", "ETH", 2134.12, -1.13, lineData2, 6545.12, 0.272),
            TempModel("trox", "ROX", 4324.12, 0.72, lineData3, 1234.12, 0.013),
        )
        // this is sample data for this video. You can use real data with API Services

        with(binding.cryptoView) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = CryptoAdapter(domainMutableList)
        }
    }

    private fun stockList() {
        val domainMutableList = mutableListOf(
            TempModel("NASDAQ100", "BTX", 1234.12, 2.13, lineData, 1234.12, 0.123),
            TempModel("S&P 500", "ETH", 2134.12, -1.13, lineData2, 6545.12, 0.272),
            TempModel("DoW Jones", "ROX", 4324.12, 0.72, lineData3, 1234.12, 0.013),
        )
        // this is sample data for this video. You can use real data with API Services

        with(binding.stockView) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = StockAdapter(domainMutableList)
        }
    }
}