package com.example.orahiassignment.ui.fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Log;
import android.view.Display;
import android.view.View;

import com.example.orahiassignment.R;
import com.example.orahiassignment.jetpack.Model.Demo;

import java.util.List;

public class GraphView extends View {
    private List<Demo> demoList;
    private Canvas canvas;
    private Paint paint;

    public GraphView(Context context, List<Demo> demoList) {
        super(context);
        this.demoList = demoList;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint = new Paint();
        this.canvas = canvas;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2f);
        paint.setColor(getResources().getColor(R.color.colorBlack));
        canvas.drawLine(0, canvas.getHeight() - 100, canvas.getWidth(), canvas.getHeight() - 100, paint);
        paint.setStyle(Paint.Style.FILL);
        createGraph();
        paint.setTextSize(45);

    }

    private void createGraph() {
        int left = 20, right = canvas.getWidth() / 14+20, bottom = canvas.getHeight() - 100;
        paint.setStyle(Paint.Style.FILL);
        int index = 0;
        for (Demo demo : demoList) {
            int top = 882-Integer.parseInt(demo.getStat())*2 ;
            Log.e("left right top bottom ",left+" "+right+" "+top+" "+bottom);

            if (index % 2 == 0)
                paint.setColor(getResources().getColor(R.color.colorFirst));
            else
                paint.setColor(getResources().getColor(R.color.colorSecond));

            canvas.drawRect(left, top, right, bottom, paint);
            paint.setColor(Color.BLACK);
            canvas.drawText(demo.getMonth().substring(0,3).toUpperCase(),left+10,top-10,paint);
            left = left + canvas.getWidth()/14;
            right+=canvas.getWidth()/14;
            index++;
        }
    }
}
