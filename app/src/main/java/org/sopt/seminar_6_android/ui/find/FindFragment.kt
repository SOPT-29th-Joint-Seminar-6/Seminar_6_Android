package org.sopt.seminar_6_android.ui.find

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import org.sopt.seminar_6_android.R
import org.sopt.seminar_6_android.data.api.ServiceCreator
import org.sopt.seminar_6_android.data.model.request.RequestChannelData
import org.sopt.seminar_6_android.data.model.response.ResponseChannelData
import org.sopt.seminar_6_android.data.model.response.ResponseChannelIdData
import org.sopt.seminar_6_android.data.model.response.ResponseFindData
import org.sopt.seminar_6_android.databinding.AddChannelPopupBinding
import org.sopt.seminar_6_android.databinding.FragmentFindBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class FindFragment : Fragment() {
    private var _binding: FragmentFindBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private lateinit var newsCardAdapter: NewsCardAdapter
    private lateinit var newsLinearCardAdapter: NewsLinearCardAdapter
    private var clickChannelId : Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFindBinding.inflate(layoutInflater, container, false)
        initAdapter()
        initLinearAdapter()
        initDialog()
        initTestClickListener()
        initClickEvent()
        initNetwork()
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
            clickChannelId = 1
            initDialogNetwork()
            addDialog.show()
        }
        binding.includeNewsLinearCard.ivKakaoChannel.setOnClickListener {
            clickChannelId = 2
            initDialogNetwork()
            addDialog.show()
        }
    }

    private fun initDialogNetwork() {
        val call : Call<ResponseChannelIdData> = ServiceCreator.findService.getChannelIdList(clickChannelId)

        call.enqueue(object  : Callback<ResponseChannelIdData>{
            override fun onResponse(
                call: Call<ResponseChannelIdData>,
                response: Response<ResponseChannelIdData>
            ) {
                if(response.isSuccessful) {
                    with(response.body()?.data?.get(0)){
                        Glide.with(addDialogBinding.ivPopupMovie).load(this?.channelImageUrl).into(addDialogBinding.ivPopupMovie)
                        addDialogBinding.tvChannelDesc.text = this?.channelDesc
                        addDialogBinding.tvTitle.text = this?.channelName
                        addDialogBinding.tvFriend.text = "친구" + this?.friendCount.toString()
                    }
                }
            }

            override fun onFailure(call: Call<ResponseChannelIdData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun initDialogPostNetwork() {
        val call : Call<ResponseChannelData> = ServiceCreator.findService.postChannelList(
            RequestChannelData(1, 1)
        )

        call.enqueue(object  : Callback<ResponseChannelData>{
            override fun onResponse(
                call: Call<ResponseChannelData>,
                response: Response<ResponseChannelData>
            ) {
                if(response.isSuccessful) {
                    }
            }

            override fun onFailure(call: Call<ResponseChannelData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun initNetwork() {
        val call : Call<ResponseFindData> = ServiceCreator.findService.getFindlist()

        call.enqueue(object  : Callback<ResponseFindData>{
            override fun onResponse(
                call: Call<ResponseFindData>,
                response: Response<ResponseFindData>
            ) {
                if(response.isSuccessful) {
                    val gridData : List<NewsGridData> = response.body()?.data?.get(1)?.articles?.map {
                        NewsGridData(newsImg = it.postImageUrl, newsTitle = it.title)
                    } ?: listOf()

                    val linearData : List<NewsLinearData> = response.body()?.data?.get(0)?.articles?.map {
                        NewsLinearData(newsImg = it.postImageUrl, newsTitle = it.title)
                    } ?: listOf()

                    newsCardAdapter.newsList.addAll(gridData.subList(0,2))
                    newsLinearCardAdapter.newsList.addAll(linearData.subList(0,2))

                    newsCardAdapter.notifyDataSetChanged()
                    newsLinearCardAdapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ResponseFindData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }

    private fun initClickEvent() {
        addDialogBinding.apply {
            ivChannel.setOnClickListener { // dialog layout 내의 button을 눌렀을 때 동작
                initDialogPostNetwork()
                addDialog.dismiss() // dialog close()
                if(clickChannelId == 1) {
                    binding.includeNewsCard.ivKakaoChannel.visibility = View.GONE
                }
                else {
                    binding.includeNewsLinearCard.ivKakaoChannel.visibility = View.GONE
                }
            }
            ivCancel.setOnClickListener {
                addDialog.dismiss()
            }
        }
    }

    private fun initAdapter() {
        newsCardAdapter = NewsCardAdapter()
        binding.includeNewsCard.rvNewsCard.adapter = newsCardAdapter
    }

    private fun initLinearAdapter() {
        newsLinearCardAdapter = NewsLinearCardAdapter()
        binding.includeNewsLinearCard.rvNewsCard.adapter = newsLinearCardAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
