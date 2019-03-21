package com.gpetuhov.android.samplecustomview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.view.LayoutInflater
import android.view.Gravity


class ColorOptionsView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private var mValue: View? = null
    private var mImage: ImageView? = null

    constructor(context: Context): this(context, null)

    init {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {
        // Here we initialize our view with values provided
        // in attributes inside the layout xml file (in MainActivity layout in this example).
        // And also inflate it from its own layout file (view_color_options.xml).

        val attributes = context.obtainStyledAttributes(
            attrs,
            R.styleable.ColorOptionsView, 0, 0
        )
        val titleText = attributes?.getString(R.styleable.ColorOptionsView_titleText)
        val valueColor = attributes?.getColor(
            R.styleable.ColorOptionsView_valueColor,
            Color.BLUE
        ) ?: Color.BLUE
        attributes?.recycle()

        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_color_options, this, true)

        val title = getChildAt(0) as TextView
        title.text = titleText

        mValue = getChildAt(1)
        mValue?.setBackgroundColor(valueColor)

        mImage = getChildAt(2) as ImageView
    }

    fun setValueColor(color: Int) {
        mValue?.setBackgroundColor(color)
    }

    fun setImageVisible(visible: Boolean) {
        mImage?.visibility = if (visible) View.VISIBLE else View.GONE
    }
}