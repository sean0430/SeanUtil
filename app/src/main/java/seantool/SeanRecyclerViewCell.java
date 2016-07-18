package seantool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15下午4:18.
 */
public abstract class SeanRecyclerViewCell extends RelativeLayout implements View.OnClickListener{

    private OnItemClickListener onItemClickListener;

    public SeanRecyclerViewCell(Context context, int layoutId) {
        super(context);

        LayoutInflater lf =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        addView(lf.inflate(layoutId, null));
        setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onClick();
        }
    }

    public interface OnItemClickListener {
        void onClick();
    }

    public void setOnCellEventListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public abstract void bindData(Object object);
}
