package com.kocerlabs.cryptoappmvvm.ui.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kocerlabs.cryptoappmvvm.databinding.FragmentSplashBinding
import com.kocerlabs.simplifiedcodingmvvm.ui.base.BaseFragment

class SplashFragment() : BaseFragment<FragmentSplashBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSplashBinding = FragmentSplashBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnStart.setOnClickListener(::goToDashboard)
            txtLogin.setOnClickListener(::goToDashboard)
        }
    }

    private fun goToDashboard(view: View) {
        val action = SplashFragmentDirections.actionSplashFragmentToDashboardFragment()
        findNavController().navigate(action)
    }
}