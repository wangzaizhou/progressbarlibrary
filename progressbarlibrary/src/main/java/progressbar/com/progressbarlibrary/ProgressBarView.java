package progressbar.com.progressbarlibrary;

/**
 * Created by wangzaizhou on 2016/12/10.
 */
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ProgressBarView extends View {

    private Paint paint;
    private Paint painttext;
    private Paint paintm;
    private float width = 0;
    private float right = 0;
    private float radius = 0;
    private float s_radius = 0;
    private int i = 1;
    private int j = 6;
    private String text = "";
    private String title="";
    private int pro =-1;


    public ProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void setdata(int pro){
        this.pro=pro;
    };
    public void settitle(String title){
        this.title=title;
    };

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);// 抗锯齿
        paint.setColor(Color.parseColor("#436EEE"));
        paint.setStrokeWidth(1);
        paintm = new Paint();
        paintm.setAntiAlias(true);// 抗锯齿
        paintm.setColor(Color.parseColor("#ccffffff"));
        paintm.setStrokeWidth(1);
        painttext = new Paint();
        painttext.setAntiAlias(true);// 抗锯齿
        painttext.setColor(Color.parseColor("#000000"));
        painttext.setStrokeWidth(1);
        painttext.setTextSize(30);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        width = getHeight() / 2;
        s_radius = width/25;
        radius = width - s_radius*8;
        right = width * 2 - s_radius*4;
        drawback(canvas);
        drawpost(canvas);
        drawtext(canvas);

    }

    private void drawback(Canvas canvas) {
        RectF rectF = new RectF(0, 0, canvas.getWidth(), canvas.getHeight());
        canvas.drawRoundRect(rectF, 10, 10, paintm);//绘制圆角矩形
    }

    private void drawtext(Canvas canvas) {
        text=pro+"%";
        int baseX = (int) (canvas.getHeight() / 2 - painttext.measureText(text) / 2);
        int baseY = (int) ((canvas.getHeight() / 2) - ((painttext.descent() + painttext
                .ascent()) / 2));
        if (pro!=-1) {
            canvas.drawText(text, baseX, baseY, painttext);

        }
        canvas.drawText(title, width*2+10, baseY, painttext);
    }

    private void drawpost(Canvas canvas) {
        int we=20;

        j = j + 2;
        if (j > right*2.5) {
            if (i == 1) {
                i = 1;
                j = (int) s_radius*4;
            } else {
                i = 1;
                j = (int) s_radius*4;
            }
            invalidate();
        } else {
            if (i == 2) {
                int jj = 6;
                jj = (int) right - j;
                canvas.drawCircle(jj, getY(jj, i), 6, paint);
                canvas.drawCircle(jj+20, getY(jj+20, i), 6, paint);
                canvas.drawCircle(jj+40, getY(jj+40, i), 6, paint);
                canvas.drawCircle(jj+60, getY(jj+60, i), 6, paint);
                canvas.drawCircle(jj+80, getY(jj+80, i), 6, paint);
                canvas.drawCircle(jj+100, getY(jj+100, i), 6, paint);
                canvas.drawCircle(jj+120, getY(jj+120, i), 6, paint);
            } else {
                if (j>right) {
                    int qq=(int)right*2-j;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j, getY(j, i), s_radius, paint);
                }
                if (j-20>right) {
                    int qq=(int)right*2-j+20;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j-20, getY(j-20, i), s_radius, paint);
                }
                if (j-40>right) {
                    int qq=(int)right*2-j+40;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j-40, getY(j-40, i), s_radius, paint);
                }
                if (j-60>right) {
                    int qq=(int)right*2-j+60;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j-60, getY(j-60, i), s_radius, paint);
                }
                if (j-80>right) {
                    int qq=(int)right*2-j+80;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j-80, getY(j-80, i), s_radius, paint);
                }
                if (j-100>right) {
                    int qq=(int)right*2-j+100;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j-100, getY(j-100, i), s_radius, paint);
                }
                if (j-120>right) {
                    int qq=(int)right*2-j+120;
                    canvas.drawCircle(qq, getY(qq, 2), s_radius, paint);
                }else{

                    canvas.drawCircle(j-120, getY(j-120, i), s_radius, paint);
                }
            }

            invalidate();
        }
    }




    private float getY(float x, int i) {
        double res = Math.pow((x - width), 2);// 2次方
        double r = Math.pow(radius, 2);
        double de = 0;
        try {
            de = Math.sqrt((r - res));//开平方
        } catch (Exception e) {
            de = 0;
        }
        double dy = 0;
        if (i == 1) {
            dy = width - de;

        } else {
            dy = width + de;
        }
        float y = 0;
        if (dy != 0.0) {
            y = (float) dy;

        }
        return y;

    }


}
