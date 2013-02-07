package com.bharatdodeja.linkifydemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.text.util.Linkify.MatchFilter;
import android.text.util.Linkify.TransformFilter;
import android.widget.TextView;

public class LinkifyTextDemo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView textView = (TextView)findViewById(R.id.txtSampleTextView);
        textView.setText("This is a demo of custom text linkify, developed by @Bharat");

        MatchFilter matchFilter = new MatchFilter() {
        	public final boolean acceptMatch(CharSequence s, int start, int end) {
//        		you can compare match over here
//        		return s.toString().equals("@Bharat");
        		return true;
        	}
        };
        
        TransformFilter transformFilter = new TransformFilter() {
        	public final String transformUrl(final Matcher match, String url) {
        		return "https://twitter.com/bharatdodeja";
        	}
        };

        Pattern pattern = Pattern.compile("@Bharat");
        String scheme = "https://";
        Linkify.addLinks(textView, pattern, scheme, matchFilter, transformFilter);
    }
}