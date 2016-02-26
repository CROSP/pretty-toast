package ua.com.crosp.solutions.library.prettytoast;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.IoniconsModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialModule;
import com.joanzapata.iconify.fonts.MeteoconsModule;
import com.joanzapata.iconify.fonts.SimpleLineIconsModule;
import com.joanzapata.iconify.fonts.TypiconsModule;
import com.joanzapata.iconify.fonts.WeathericonsModule;

/*
* Copyright (C) 2016 Alexander Crospenko
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
public class PrettyToast extends Toast {

    private static final int DEFAULT_TEXT_SIZE = 20;
    private static final int DEFAULT_ICON_SIZE = 35;
    private static final int DEFAULT_TOAST_DURATION = LENGTH_LONG;
    @ColorRes
    private static final int DEFAULT_ICON_COLOR = R.color.white;
    private static final int DEFAULT_TEXT_COLOR = R.color.white;
    @LayoutRes
    private static final int DEFAULT_LAYOUT_RESOURCE = R.layout.toast_base;
    private static LayoutInflater mInflater;
    private static Toast mToast;
    private static View mView;
    private boolean mIsCreatedFromCustomResource = false;

    /**
     * Construct an empty Toast object.  You must call {@link #setView} before you
     * can call {@link #show}.
     *
     * @param context The context to use.  Usually your {@link Application}
     *                or {@link Activity} object.
     */
    public PrettyToast(Context context) {
        super(context);
    }

    /**
     * Please consider to call this method if you wanna to use icons
     */
    public static void initIcons() {
        Iconify
                .with(new FontAwesomeModule())
                .with(new EntypoModule())
                .with(new TypiconsModule())
                .with(new MaterialModule())
                .with(new MaterialCommunityModule())
                .with(new MeteoconsModule())
                .with(new WeathericonsModule())
                .with(new SimpleLineIconsModule())
                .with(new IoniconsModule());
    }

    public static void showInfo(Context context, String msg) {
        showToastBase(context, R.drawable.background_toast_blue, msg);
    }

    public static void showInfo(Context context, String msg,
                                String leftIcon) {
        showToastBase(context, R.drawable.background_toast_blue, msg, leftIcon);
    }

    public static void showInfo(Context context, String msg,
                                String leftIcon, String rightIcon) {
        showToastBase(context, R.drawable.background_toast_blue, msg, leftIcon, rightIcon);
    }

    public static void showInfo(Context context, String msg,
                                String leftIcon, String rightIcon, int duration) {
        showToastBase(context, R.drawable.background_toast_blue, msg, leftIcon, rightIcon, duration);
    }
    // Error toast methods

    public static void showError(Context context, String msg) {
        showToastBase(context, R.drawable.background_toast_red, msg);
    }

    public static void showError(Context context, String msg, String leftIcon) {
        showToastBase(context, R.drawable.background_toast_red, msg, leftIcon);
    }

    public static void showError(Context context, String msg, String leftIcon, String rightIcon) {
        showToastBase(context, R.drawable.background_toast_red, msg, leftIcon, rightIcon);
    }

    public static void showError(Context context, String msg,
                                 String leftIcon, String rightIcon, int duration) {
        showToastBase(context, R.drawable.background_toast_red, msg, leftIcon, rightIcon, duration);
    }

    // Warning default toast methods
    public static void showWarning(Context context, String msg) {
        showToastBase(context, R.drawable.background_toast_yellow, msg);
    }

    public static void showWarning(Context context, String msg, String leftIcon) {
        showToastBase(context, R.drawable.background_toast_yellow, msg, leftIcon);
    }

    public static void showWarning(Context context, String msg, String leftIcon, String rightIcon) {
        showToastBase(context, R.drawable.background_toast_yellow, msg, leftIcon, rightIcon);
    }

    public static void showWarning(Context context, String msg,
                                   String leftIcon, String rightIcon, int duration) {
        showToastBase(context, R.drawable.background_toast_yellow, msg, leftIcon, rightIcon, duration);
    }
    // Success toast methods

    public static void showSuccess(Context context, String msg) {
        showToastBase(context, R.drawable.background_toast_green, msg);
    }

    public static void showSuccess(Context context, String msg, String leftIcon) {
        showToastBase(context, R.drawable.background_toast_green, msg, leftIcon);
    }

    public static void showSuccess(Context context, String msg, String leftIcon, String rightIcon) {
        showToastBase(context, R.drawable.background_toast_green, msg, leftIcon, rightIcon);
    }

    public static void showSuccess(Context context, String msg,
                                   String leftIcon, String rightIcon, int duration) {
        showToastBase(context, R.drawable.background_toast_green, msg, leftIcon, rightIcon, duration);
    }
    // Dim toast methods

    public static void showDim(Context context, String msg) {
        showToastBase(context, R.drawable.background_toast_gray, msg);
    }

    public static void showDim(Context context, String msg, String leftIcon) {
        showToastBase(context, R.drawable.background_toast_gray, msg, leftIcon);
    }

    public static void showDim(Context context, String msg, String leftIcon, String rightIcon) {
        showToastBase(context, R.drawable.background_toast_gray, msg, leftIcon, rightIcon);
    }

    public static void showDim(Context context, String msg,
                               String leftIcon, String rightIcon, int duration) {
        showToastBase(context, R.drawable.background_toast_gray, msg, leftIcon, rightIcon, duration);
    }

    // Base toast methods used by others, for the sake of cleaner code

    public static void showToastBase(Context context, int backgroundResource, String msg) {
        new Builder(context)
                .withBackgroundResource(backgroundResource)
                .withMessage(msg)
                .build().show();
    }

    public static void showToastBase(Context context, int backgroundResource, String msg,
                                     String leftIcon) {
        new Builder(context)
                .withBackgroundResource(backgroundResource)
                .withMessage(msg)
                .withLeftIcon(leftIcon)
                .build().show();
    }

    public static void showToastBase(Context context, int backgroundResource, String msg,
                                     String leftIcon, String rightIcon) {
        new Builder(context)
                .withBackgroundResource(backgroundResource)
                .withMessage(msg)
                .withLeftIcon(leftIcon)
                .withRightIcon(rightIcon)
                .build().show();
    }

    public static void showToastBase(Context context, int backgroundResource, String msg,
                                     String leftIcon, String rightIcon, int duration) {
        new Builder(context)
                .withBackgroundResource(backgroundResource)
                .withMessage(msg)
                .withLeftIcon(leftIcon)
                .withRightIcon(rightIcon)
                .withDuration(duration)
                .build().show();
    }


    /**
     * Gravity info class, just for encapsulating all required data for setting toast gravity
     */
    public static class Gravity {
        private int mGravity;
        private int mXOffset;
        private int mYOffset;

        public Gravity(int gravity, int XOffset, int YOffset) {
            mGravity = gravity;
            mXOffset = XOffset;
            mYOffset = YOffset;
        }

        public int getGravity() {
            return mGravity;
        }

        public void setGravity(int gravity) {
            mGravity = gravity;
        }

        public int getXOffset() {
            return mXOffset;
        }

        public void setXOffset(int XOffset) {
            mXOffset = XOffset;
        }

        public int getYOffset() {
            return mYOffset;
        }

        public void setYOffset(int YOffset) {
            mYOffset = YOffset;
        }
    }

    /**
     * Builder class for creating different types of toasts
     */
    public static class Builder {
        ;
        private String mMessage;
        private String mLeftIcon;
        private String mRightIcon;
        private int mTextSize;
        private int mCustomLayoutId;
        private View mCustomView;
        private Gravity mGravity;
        private Context mContext;
        private IconDrawable mLeftIconDrawable;
        private IconDrawable mRightIconDrawable;
        private int mLeftIconColor;
        private int mRightIconColor;
        private int mShowDuration;
        private int mBackgroundResource;
        private int mTextColor;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder withMessage(String message) {
            this.mMessage = message;
            return this;
        }

        public Builder withLeftIcon(String icon) {
            this.mLeftIcon = icon;
            return this;
        }

        public Builder withDuration(int duration) {
            this.mShowDuration = duration;
            return this;
        }

        public Builder withLeftIconDrawable(IconDrawable iconDrawable) {
            this.mLeftIconDrawable = iconDrawable;
            return this;
        }

        public Builder withRightIconDrawable(IconDrawable iconDrawable) {
            this.mRightIconDrawable = iconDrawable;
            return this;
        }

        public Builder withRightIcon(String icon) {
            this.mRightIcon = icon;
            return this;
        }

        public Builder withTextSize(int size) {
            this.mTextSize = size;
            return this;
        }

        public Builder withTextColor(int color) {
            this.mTextColor = color;
            return this;
        }

        public Builder withCustomLayout(@LayoutRes int layout) {
            this.mCustomLayoutId = layout;
            return this;
        }

        public Builder withCustomView(View view) {
            this.mCustomView = view;
            return this;
        }

        public Builder withLeftIconColor(int color) {
            this.mLeftIconColor = color;
            return this;
        }

        public Builder withRightIconColor(int color) {
            this.mRightIconColor = color;
            return this;
        }

        public Builder withGravity(Gravity gravity) {
            this.mGravity = gravity;
            return this;
        }

        public Builder withBackgroundResource(@DrawableRes int backgroundResource) {
            this.mBackgroundResource = backgroundResource;
            return this;
        }

        public PrettyToast build() {
            PrettyToast toast = new PrettyToast(mContext);
            // If custom view is provided you are responsible for handling all layout by yourself
            if (mCustomView != null) {
                toast.mIsCreatedFromCustomResource = true;
                toast.setView(mCustomView);
                return toast;
            }
            // When layout resource provided it should contain
            if (mCustomLayoutId > 0) {
                View inflated = LayoutInflater.from(mContext).inflate(mCustomLayoutId, null, false);
                toast.mIsCreatedFromCustomResource = true;
                toast.setView(inflated);
            }
            View defaultView = LayoutInflater.from(mContext).inflate(PrettyToast.DEFAULT_LAYOUT_RESOURCE, null, false);
            if (mMessage != null) {
                TextView textView = (TextView) defaultView.findViewById(R.id.text_view_toast_main);
                if (textView != null) {
                    if (mTextSize > 0) {
                        textView.setTextSize(mTextSize);
                    }
                    textView.setVisibility(View.VISIBLE);
                    textView.setText(mMessage);
                    textView.setTextColor(mTextColor > 0 ? mContext.getResources().getColor(mTextColor) : mContext.getResources().getColor(DEFAULT_ICON_COLOR));
                }
            }
            ImageView imageViewRightIcon = (ImageView) defaultView.findViewById(R.id.image_view_toast_icon_right);
            ImageView imageViewLeftIcon = (ImageView) defaultView.findViewById(R.id.image_view_toast_icon_left);
            if (mLeftIconDrawable != null) {
                imageViewLeftIcon.setImageDrawable(mLeftIconDrawable);
            } else if (mLeftIcon != null) {
                try {
                    imageViewLeftIcon.setImageDrawable(
                            new IconDrawable(mContext, mLeftIcon)
                                    .sizeDp(mTextSize > 0 ? mTextSize : PrettyToast.DEFAULT_ICON_SIZE)
                                    .colorRes(mLeftIconColor != 0 ? mLeftIconColor : DEFAULT_ICON_COLOR));
                } catch (Exception ex) {
                    imageViewLeftIcon.setImageResource(R.drawable.ok);
                }
                imageViewLeftIcon.setVisibility(View.VISIBLE);
            }
            if (mRightIconDrawable != null) {
                imageViewRightIcon.setImageDrawable(mRightIconDrawable);
            } else if (mRightIcon != null) {
                try {
                    imageViewRightIcon.setImageDrawable(new IconDrawable(mContext, mRightIcon)
                            .sizeDp(mTextSize > 0 ? mTextSize : PrettyToast.DEFAULT_ICON_SIZE)
                            .colorRes(mRightIconColor != 0 ? mRightIconColor : DEFAULT_ICON_COLOR));
                } catch (Exception ex) {
                    imageViewRightIcon.setImageResource(R.drawable.ok);
                }
                imageViewRightIcon.setVisibility(View.VISIBLE);
            }
            if (mGravity != null) {
                toast.setGravity(mGravity.getGravity(), mGravity.getXOffset(), mGravity.getYOffset());
            }
            defaultView.setBackgroundResource(mBackgroundResource > 0 ? mBackgroundResource : R.drawable.background_toast_blue);
            toast.setView(defaultView);
            toast.setDuration(mShowDuration >= 0 ? mShowDuration : DEFAULT_TOAST_DURATION);
            return toast;
        }
    }
}
