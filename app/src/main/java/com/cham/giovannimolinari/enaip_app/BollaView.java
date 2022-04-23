package com.cham.giovannimolinari.enaip_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BollaView extends View {

    private float pitch = 0, roll = 0;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    private boolean firstDraw;
    final float radiusPt = (float) 16;

    public BollaView(Context context) {
        super(context);

        init();
    }

    public BollaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
    }

    public BollaView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    private void init(){


        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(getResources().getColor(R.color.colorPrimaryDark));
        paint.setTextSize(20);

        paint2.setStyle(Paint.Style.FILL_AND_STROKE);
        paint2.setStrokeWidth(4);
        paint2.setColor(getResources().getColor(R.color.colorAccent));

        firstDraw = true;
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // TODO Auto-generated method stub
        setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub

        int cxPlan = getMeasuredWidth()/2;
        int cyPlan = getMeasuredHeight()/2;

        float fullLength, halfLength, ptPerDegree;

        if(cxPlan > cyPlan){
            fullLength = (float)(getMeasuredHeight() * 0.9);

        }
        else{
            fullLength = (float)(getMeasuredWidth() * 0.9);
        }
        halfLength = fullLength/2;
        ptPerDegree = fullLength/360;

        canvas.drawRect(cxPlan-halfLength, cyPlan-halfLength, cxPlan+halfLength, cyPlan+halfLength, paint);

       // canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
       // canvas.drawCircle(getWidth()/2, getHeight()/2, 320, paint);
        canvas.drawCircle(getWidth()/2, getHeight()/2, 20, paint);



        if(!firstDraw){
            float yPt = cyPlan + (pitch * ptPerDegree);
            float xPt = cxPlan + (roll * ptPerDegree);
            canvas.drawCircle(xPt, yPt, radiusPt, paint2);
        }
    }

    public void updateHorizontal(float tPitch, float tRoll)
    {
        firstDraw = false;
        pitch = tPitch;
        roll = tRoll;
        invalidate();
    }



}