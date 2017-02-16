package com.bwie.objectanimotor;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mStart;
    private Button mOver;
    private TextView mText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStart = (Button) findViewById(R.id.start);
        mOver = (Button) findViewById(R.id.over);
        mText1 = (TextView) findViewById(R.id.text1);
        mStart.setOnClickListener(this);
        mOver.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start:
                //此处代码是一个平滑过程,看不到任何界面效果
               /* ValueAnimator animator = ValueAnimator.ofFloat(0f, 1f);
                animator.setDuration(3000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        Log.d("TAG", "onAnimationUpdate: " + animatedValue);
                    }
                });
                animator.start();*/
                ObjectAnimator objectAnimat = ObjectAnimator.ofFloat(mText1, "rotation", 0f, 360f, 0f);
                objectAnimat.setDuration(1000);
                objectAnimat.setRepeatCount(200);//必须要设置重复次数
                objectAnimat.setRepeatMode(ValueAnimator.RESTART);//倒序播放
                objectAnimat.start();
                break;
            case R.id.over:

                break;
            default:
                break;
        }
    }
}
