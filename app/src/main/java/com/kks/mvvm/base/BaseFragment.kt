package com.kks.mvvm.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.kks.mvvm.dialog.LottieDialogFragment

/**
 * Base Fragment class with helper methods for handling views and back button events.
 *
 * @see Fragment
 */
abstract class BaseFragment<B : ViewDataBinding>(@LayoutRes val layoutId: Int) : Fragment() {
    lateinit var binding: B
    protected lateinit var thisContext: Context
    lateinit var lottieDialog: LottieDialogFragment

    abstract fun init()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        thisContext = inflater.context
        lottieDialog = LottieDialogFragment.newInstance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        init()
    }

    protected fun showToast(msg: String) =
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()

    fun showProgressDialog() {
        if (!lottieDialog.isAdded) {
            lottieDialog.show(
                requireActivity().supportFragmentManager,
                lottieDialog.tag
            )
        }
    }

    fun hideProgressDialog() {
        if (lottieDialog.isAdded) {
            lottieDialog.dismissAllowingStateLoss()
        }
    }
}