package com.micoder.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.micoder.newsapp.R
import com.micoder.newsapp.databinding.FragmentArticleBinding
import com.micoder.newsapp.databinding.FragmentSavedNewsBinding
import com.micoder.newsapp.ui.NewsActivity
import com.micoder.newsapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private var binding: FragmentArticleBinding? = null

    lateinit var viewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        binding!!.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        binding!!.fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Article Saved Successfully", Snackbar.LENGTH_SHORT).show()
        }

    }



    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}