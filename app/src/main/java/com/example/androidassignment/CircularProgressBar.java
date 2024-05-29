package com.example.androidassignment;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CircularProgressBar extends View {
    private Paint paint;
    private Paint textPaint;
    private int progress = 53;
    private int strokeWidth = 20;

    public CircularProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CircularProgressBar(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(0xFFFFDB58);
        textPaint.setTextSize(22 * getResources().getDisplayMetrics().scaledDensity);
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setFakeBoldText(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2 - strokeWidth / 2;


        paint.setColor(Color.GRAY);
        canvas.drawCircle(width / 2, height / 2, radius, paint);


        paint.setColor(0xFFFFDB58);
        float sweepAngle = 360 * progress / 100;
        canvas.drawArc(strokeWidth / 2, strokeWidth / 2,
                width - strokeWidth / 2, height - strokeWidth / 2, -90,
                sweepAngle, false, paint);

        String progressText = progress + "/100";
        String[] textParts = progressText.split("/");

        
        float textHeight = textPaint.descent() - textPaint.ascent();
        float textOffset = (textHeight / 2) - textPaint.descent();
        float yPos1 = height / 2 - textHeight / 2 + textOffset;
        float yPos2 = height / 2 + textHeight / 2 + textOffset;

        canvas.drawText(textParts[0], width / 2, yPos1, textPaint);
        textPaint.setFakeBoldText(false);
        textPaint.setColor(Color.BLACK);
        canvas.drawText("/" + textParts[1], width / 2, yPos2, textPaint);
    }

    public void setProgress(int progress) {
        this.progress = progress;
        invalidate();
    }
}
