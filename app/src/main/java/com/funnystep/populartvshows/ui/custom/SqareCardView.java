package com.funnystep.populartvshows.ui.custom;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

public class SqareCardView extends CardView {

    public SqareCardView(Context context) {
        super(context);
    }

    public SqareCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SqareCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(final int widthMeasureSpec, final int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

}
