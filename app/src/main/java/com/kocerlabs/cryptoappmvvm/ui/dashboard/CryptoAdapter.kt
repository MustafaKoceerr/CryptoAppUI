package com.kocerlabs.cryptoappmvvm.ui.dashboard

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kocerlabs.cryptoappmvvm.data.network.model.TempModel
import com.kocerlabs.cryptoappmvvm.databinding.ViewholderCryptoBinding
import java.text.DecimalFormat

class CryptoAdapter(
    private val dataList: List<TempModel>
) : RecyclerView.Adapter<CryptoAdapter.CryptoViewHolder>() {

    private val formatter = DecimalFormat("###,###,###,###.##")

    inner class CryptoViewHolder(private val cryptoBinding: ViewholderCryptoBinding) :
        RecyclerView.ViewHolder(cryptoBinding.root) {

        fun bind(model: TempModel) {
            with(cryptoBinding) {
                cryptoNameTxt.text = model.name
                cryptoPriceTxt.text = "$${formatter.format(model.price)}"
                changePercentTxt.text = "${model.changePercent}%"
                propertySizeTxt.text = "${model.propertySize} ${model.symbol}"
                propertyAmountTxt.text = "$${formatter.format(model.propertyAmount)}"
                sparkLineLayout.setData(model.lineData)

                val changeColor = when {
                    model.changePercent > 0 -> Color.parseColor("#12C737")
                    model.changePercent < 0 -> Color.parseColor("#FF0000")
                    else -> Color.WHITE
                }
                changePercentTxt.setTextColor(changeColor)
                sparkLineLayout.sparkLineColor = changeColor

                val drawableResourceId = itemView.context.resources.getIdentifier(
                    model.name, "drawable", itemView.context.packageName
                )

                Glide.with(itemView.context)
                    .load(drawableResourceId)
                    .into(logoImg)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder =
        CryptoViewHolder(
            ViewholderCryptoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        holder.bind(dataList[position])
    }
}