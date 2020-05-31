package com.masa.colorfultextview

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.lang.Exception

class ColorfulTextView  @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyle: Int = 0)
    : AppCompatTextView(context, attrs, defStyle)
{
    override fun setText(text: CharSequence?, type: BufferType?) {
        super.setText(formatText(text), type)
    }

    private fun formatText(text : CharSequence?) : SpannableStringBuilder{

        val final = SpannableStringBuilder()
        try {
            val tokens = text?.split(" ")
            tokens?.forEachIndexed { index, it ->
                final.append(if(index!=0) " " else "")
                if (it.startsWith("@{")){
                    val temp = it.substring(it.indexOf('{')+1,it.indexOf('}'))
                    val tempArray = temp.split(',')
                    final.append(tempArray[0])
                    final.setSpan(ForegroundColorSpan(Color.parseColor(tempArray[1])), final.length-tempArray[0].length, final.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    final.setSpan(AbsoluteSizeSpan(tempArray[2].toInt()),final.length-tempArray[0].length, final.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE) //resize size
                    when (tempArray[3]){
                        "B" -> final.setSpan(StyleSpan(Typeface.BOLD), final.length-tempArray[0].length, final.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        "I" -> final.setSpan(StyleSpan(Typeface.ITALIC), final.length-tempArray[0].length, final.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                        "N" -> final.setSpan(StyleSpan(Typeface.NORMAL), final.length-tempArray[0].length, final.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    }
                }
                else
                    final.append(it)
            }

            return final
        }
        catch (e:Exception){
            final.append(text)
            return final

        }
    }
}
