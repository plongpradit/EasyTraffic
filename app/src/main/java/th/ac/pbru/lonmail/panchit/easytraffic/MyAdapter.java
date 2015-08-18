package th.ac.pbru.lonmail.panchit.easytraffic;

import android.content.Context;
import android.renderscript.RenderScript;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by plongpradit on 18-Aug-15.
 */
public class MyAdapter extends BaseAdapter{
    // Google already built Adapter and store in SDK, we can then extend it.

    // Explicit
    private Context objContext; // การต่อท่อเดต้าระหว่าง obj กับ obj
    private int[] iconInts;
    private String[] titleStrings;

    // build constructor => main method, use 'this'
    // constructor will be instantiated when the class is called
    public MyAdapter(Context objContext, int[] iconInts, String[] titleStrings) {
        this.objContext = objContext;
        this.iconInts = iconInts;
        this.titleStrings = titleStrings;
    }

    @Override
    public int getCount() {
        return titleStrings.length;
        // counting the round of driving data (looping)
        // use 'length', instead of 0, to allow for flexibility in the future
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       

        return null;
    } // getView



} // Main Class
