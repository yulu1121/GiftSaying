package com.example.administrator.giftsaying.view.top;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageView;

import com.example.administrator.giftsaying.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 显示详情的Activity
 * Created by Administrator on 2017/2/12.
 */

public class FirstChoiceActivity extends AppCompatActivity {
    @BindView(R.id.first_formation_iv)
    ImageView imageView;
    @BindView(R.id.first_main_item_wv)
    WebView webView;
    private Bundle bundle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.formation_layout)
    CoordinatorLayout layout;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_formation_layout);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        bundle=intent.getBundleExtra("formation");
        toolbar.setTitle(bundle.getString("title"));
        setSupportActionBar(toolbar);
        initView();
    }

    private void initView() {
        Picasso.with(this).load(bundle.getString("image")).into(imageView);
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("文章加载中...");
        dialog.setMax(100);
        webView.loadUrl(bundle.getString("content"));
        dialog.show();
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                dialog.setProgress(newProgress);
                if(newProgress==100){
                    dialog.dismiss();
                }
            }
        });
    }

    public void clikFinish(View view) {
        finish();
    }

}
