package com.example.calculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;

public class CircleTextView extends android.support.v7.widget.AppCompatTextView {

    private Paint mBgPaint=new Paint();
    private PaintFlagsDrawFilter pdf=new PaintFlagsDrawFilter(0,Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG);

    public CircleTextView(Context context) {
        super(context);

        mBgPaint.setAntiAlias(true);
    }

    public CircleTextView(Context context,AttributeSet attrs) {
        super(context, attrs);

        mBgPaint.setAntiAlias(true);
    }

    public CircleTextView(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth=getMeasuredWidth();
        int measureHeigth=getMeasuredHeight();
        int max=Math.max(measureWidth,measureHeigth);
        setMeasuredDimension(max,max);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width=getWidth();
        int height=getHeight();
        canvas.setDrawFilter(pdf);
        canvas.drawCircle(width/2,height/2,Math.min(width,height),mBgPaint);

        super.onDraw(canvas);
    }


}
