package com.testtask.myapplication.presentation.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.testtask.myapplication.BuildConfig
import com.testtask.myapplication.R
import com.testtask.myapplication.domain.model.User
import com.testtask.myapplication.presentation.ui.MainActivity
import com.testtask.myapplication.presentation.viewmodel.AppViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class WebViewFragment : Fragment(R.layout.fragment_webview) {

    private val viewModel: AppViewModel by sharedViewModel()

    private lateinit var user: User
    private lateinit var webView: WebView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.app_vew_view)

        loadUser()
        loadUrl()
        webViewClientSettings()
    }

    private fun loadUser() {
        user = viewModel.userData.value ?: throw NullPointerException("before load WebViewFragment, make viewModel.getUser()")
    }

    private fun loadUrl() {

        arguments?.getString(URL, BuildConfig.DEFAULT_LOADING_LINK).apply {
            if (this == null) {
                webView.loadUrl(BuildConfig.DEFAULT_LOADING_LINK)
            } else {
                webView.loadUrl(this)
            }
        }
    }

    private fun webViewClientSettings() {
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                url?.let {
                    view?.loadUrl(it)
                }
                return true
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                request?.let {
                    view?.loadUrl(it.url.toString())
                }
                return true
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.saveUser(user.copy(lastLink = webView.url))
    }

    companion object {
        private const val URL = "web_url"

        @JvmStatic
        fun newInstance(url: String?): WebViewFragment =
            WebViewFragment().apply {
                arguments = Bundle().apply {
                    putString(URL, url)
                }
            }
    }
}