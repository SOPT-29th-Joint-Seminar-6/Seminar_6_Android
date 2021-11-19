package org.sopt.seminar_6_android.ui.find

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import org.sopt.seminar_6_android.R
import org.sopt.seminar_6_android.databinding.AddChannelPopupBinding
import org.sopt.seminar_6_android.databinding.FragmentFindBinding


class FindFragment : Fragment() {
    private var _binding: FragmentFindBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private lateinit var newsCardAdapter: NewsCardAdapter
    private lateinit var newsLinearCardAdapter: NewsLinearCardAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFindBinding.inflate(layoutInflater, container, false)
        initGridAdapter()
        initLinearAdapter()
        initDialog()
        initTestClickListener()
        initClickEvent()
        return binding.root
    }



    private lateinit var addDialog: Dialog // dialog 선언
    private lateinit var addDialogBinding: AddChannelPopupBinding // dialog xml binding 선언

    private fun initDialog() {
        addDialog = Dialog(requireContext())

        addDialogBinding = AddChannelPopupBinding.inflate(layoutInflater) // dialog xml binding 연결

        addDialog.apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(false)
            setContentView(addDialogBinding.root) // dialog xml binding, dialog 연결

            with(window?.attributes)  { // dialog size
                this?.width = WindowManager.LayoutParams.MATCH_PARENT
                this?.height = WindowManager.LayoutParams.WRAP_CONTENT
                this?.verticalWeight = 1F
            }
        }
    }

    private fun initTestClickListener() {
        binding.includeNewsCard.ivKakaoChannel.setOnClickListener { //  up button을 누르면 dialog를 띄움
            addDialog.show()
        }
    }

    private fun initClickEvent() {
        addDialogBinding.apply {
            ivChannel.setOnClickListener { // dialog layout 내의 button을 눌렀을 때 동작
                addDialog.dismiss() // dialog close()
            }
            ivCancel.setOnClickListener {
                addDialog.dismiss()
            }
        }
    }
    
    private fun initGridAdapter() {
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        newsCardAdapter = NewsCardAdapter()
        binding.includeNewsCard.rvNewsCard.adapter = newsCardAdapter

        newsCardAdapter.newsList.addAll(
            listOf(
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1")
            )
        )
        newsCardAdapter.notifyDataSetChanged()
    }

    private fun initLinearAdapter() {
        newsLinearCardAdapter = NewsLinearCardAdapter()
        binding.includeNewsLinearCard.rvNewsCard.adapter = newsLinearCardAdapter

        newsLinearCardAdapter.newsList.addAll(
            listOf(
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1"),
                NewsGridData("https://cdn.pixabay.com/photo/2021/11/08/11/19/buildings-6778915_1280.jpg", "설명1")
            )
        )
        newsLinearCardAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}