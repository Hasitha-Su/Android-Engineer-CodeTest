package jp.co.yumemi.android.code_check.bindadapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

/**
 * Contains [BindingAdapter]s for custom attribute handling in XML layouts.
 *
 * This object defines adapter methods that can be referenced directly in layout files to handle
 * specific data types or to perform actions that require custom logic, such as image loading or
 * formatting text.
 */
object BindingAdapters {

    /**
     * Sets the text of a [TextView] to the string representation of a [Long] value.
     *
     * If the value is null, the text is set to an empty string to ensure the [TextView] does not
     * display a null or incorrect state.
     *
     * @param view The [TextView] whose text will be set.
     * @param value The [Long] value that needs to be converted to a string and displayed.
     */
    @JvmStatic
    @BindingAdapter("android:text")
    fun setLongText(view: TextView, value: Long?) {
        if (value != null) {
            view.text = value.toString()
        } else {
            view.text = ""
        }
    }

    /**
     * Loads an image from a URL into an [ImageView] using the Glide library.
     *
     * If the provided URL is null or empty, the [ImageView] is cleared to ensure no residual images
     * are displayed. This is particularly useful for recycled views in lists or grids where old data
     * might inadvertently persist.
     *
     * @param view The [ImageView] into which the image should be loaded.
     * @param imageUrl The URL of the image to load. If null or empty, the image view will be cleared.
     */
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        } else {
            view.setImageDrawable(null)
        }
    }
}
