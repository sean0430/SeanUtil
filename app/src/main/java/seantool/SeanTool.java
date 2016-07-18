package seantool;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15上午10:46.
 */
public class SeanTool {

    private static SeanTool instance = null;
    private Context context;
    private SeanNotify notifyTool;
    private SeanTime timeTool;

    public static SeanTool getInstance(@NonNull Context context) {
        if (instance == null) {
            instance = new SeanTool(context);
        }
        return instance;
    }

    private SeanTool(Context context) {
        this.context = context;
        notifyTool = new SeanNotify(context);
        timeTool = new SeanTime();
    }

    public SeanNotify getNotifyTool() {
        return notifyTool;
    }

    public SeanTime getTimeTool() {
        return timeTool;
    }
}
