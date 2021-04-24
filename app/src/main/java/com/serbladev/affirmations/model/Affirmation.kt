package com.serbladev.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


//Both stringResourceId and imageResourceId are integer values.
// Although this looks okay, the caller could accidentally pass in the arguments in the wrong order (imageResourceId first instead of stringResourceId).

// To avoid this, you can use Resource annotations.
// Annotations are useful because they add additional info to classes, methods, or parameters.
// Annotations are always declared with an @ symbol.
// In this case, we add the @StringRes annotation to the string resource ID property and @DrawableRes annotation to the drawable resource ID property.
// Then you will get a warning if you supply the wrong type of resource ID.

data class Affirmation (@StringRes val stringResourceId: Int, @DrawableRes val imageResourceId: Int){

}