package seantool.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15下午4:14.
 */
@SuppressWarnings("unused")
public class SeanRecyclerView extends RecyclerView {

    private Context mContext;
    private SeanRecyclerViewBuilder seanRecyclerViewBuilder;
    private SeanRecyclerViewAdapter adapter;

    private boolean isHasFixedSize = true;

    private LayoutType layoutType = LayoutType.LINEAR;
    private int spanCount = 0;
    private boolean isVertical = true;
    private boolean isReserve = false;

    enum LayoutType {
        LINEAR, GRID, STAGGERED_GRID
    }

    private LayoutManager mLayoutManager;

    public SeanRecyclerView(Context context) {
        super(context);
        initial(context);
    }

    public SeanRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initial(context);
    }

    public SeanRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initial(context);
    }

    private void initial(Context context) {
        mContext = context;

    }

    /*  Set some attribute is you want to change  */
    public void setIsHasFixedSize(boolean isHasFixedSize) {
        this.isHasFixedSize = isHasFixedSize;
    }

    public void setSeanRecyclerViewBuilder(SeanRecyclerViewBuilder seanRecyclerViewBuilder) {
        this.seanRecyclerViewBuilder = seanRecyclerViewBuilder;
    }

    public void setLayoutType(LayoutType layoutType) {
        this.layoutType = layoutType;
    }

    public void setSpanCount(int spanCount) {
        this.spanCount = spanCount;
    }

    public void setVertical(boolean isVertical) {
        this.isVertical = isVertical;
    }

    public void setReserve(boolean isReserve) {
        this.isReserve = isReserve;
    }

    public void onBuild() {
        setHasFixedSize(isHasFixedSize);
        setLayoutManagerAttr(layoutType, spanCount, isVertical, isReserve);
        setAdapter(adapter);
    }

    //Set LayoutManager
    private void setLayoutManagerAttr(@NonNull LayoutType layoutType, int spanCount,
                                      boolean isVertical, boolean reverseLayout) {

        if (spanCount < 0) spanCount = 0;
        int orientation = isVertical ? VERTICAL : HORIZONTAL;

        switch (layoutType) {
            case LINEAR:
                mLayoutManager = new LinearLayoutManager(mContext, orientation, reverseLayout);
                break;

            case GRID:
                mLayoutManager = new GridLayoutManager(mContext, spanCount, orientation, reverseLayout);
                break;

            case STAGGERED_GRID:
                mLayoutManager = new StaggeredGridLayoutManager(spanCount, orientation);
                break;

        }

        setLayoutManager(mLayoutManager);
    }

    //Set builder to build recyclerView
    public interface SeanRecyclerViewBuilder {
        int getCellCount();

        SeanRecyclerViewCell onCreateCell(ViewGroup viewGroup, int type);

        void onBindData(SeanRecyclerViewCell recyclerViewCell, int position);
    }

    public void scrollToTop(boolean isAnimate) {
        scrollTo(0, isAnimate);
    }

    public void scrollTo(int position, boolean isAnimate) {

        if (isAnimate)
            smoothScrollToPosition(position);
        else
            scrollToPosition(position);
    }

    public void insertItem(int position) {
        adapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        adapter.notifyItemRemoved(position);
    }

    public void updateData() {
        if (adapter != null)
            adapter.notifyDataSetChanged();

    }

    //Adapter
    private class SeanRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new SeanRecyclerViewHolder(seanRecyclerViewBuilder.onCreateCell(parent, viewType));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            SeanRecyclerViewCell cell = (SeanRecyclerViewCell) holder.itemView;
            seanRecyclerViewBuilder.onBindData(cell, position);
        }

        @Override
        public int getItemCount() {
            return seanRecyclerViewBuilder.getCellCount();
        }

        private class SeanRecyclerViewHolder extends RecyclerView.ViewHolder {

            public SeanRecyclerViewHolder(View itemView) {
                super(itemView);
            }
        }


    }


}
