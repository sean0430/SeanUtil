package seantool;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.RenderScript;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Toast;

/**
 * SeanUtilSample
 * Created by Sean on 2016/7/15上午9:53.
 */
@SuppressWarnings("unused")
public class SeanNotify {

    private Context context;

    public SeanNotify(@NonNull Context context) {
        this.context = context;
    }

    /*
        Toast
         */
    public void showShortToast(String message) {
        if (isNonNullAndEmptyCheck(message))
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public void showLongToast(String message) {
        if (isNonNullAndEmptyCheck(message))
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    /*
    Alert
    If positive string not set, default value is "ok".
    If negative string not set, default value is "Cancel".
     */
    public void showAlert(String title, String message) {
        showAlert(title, message, null);
    }

    public void showAlert(String title, String message
            , String positiveStr) {

        if (!isNonNullAndEmptyCheck(positiveStr)) positiveStr = "Ok";
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveStr, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .show();
    }

    public void showAlert(String title, String message,
                          String positiveStr,
                          DialogInterface.OnClickListener positiveListener,
                          String negativeStr,
                          DialogInterface.OnClickListener negativeListener) {
        if (isNonNullAndEmptyCheck(title) && isNonNullAndEmptyCheck(message)) {
            if (!isNonNullAndEmptyCheck(positiveStr)) positiveStr = "Ok";
            if (!isNonNullAndEmptyCheck(negativeStr)) negativeStr = "Cancel";

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(context)
                            .setTitle(title)
                            .setMessage(message);

            if (positiveListener != null) {
                builder.setPositiveButton(positiveStr, positiveListener);
            }

            if (negativeListener != null) {
                builder.setNegativeButton(negativeStr, negativeListener);
            }

            builder.show();

        }

    }


    public void showAlert(Drawable iconDrawable, String title, String message,
                          String positiveStr,
                          DialogInterface.OnClickListener positiveListener,
                          String negativeStr,
                          DialogInterface.OnClickListener negativeListener) {
        if (isNonNullAndEmptyCheck(title) && isNonNullAndEmptyCheck(message)) {
            if (!isNonNullAndEmptyCheck(positiveStr)) positiveStr = "Ok";
            if (!isNonNullAndEmptyCheck(negativeStr)) negativeStr = "Cancel";

            AlertDialog.Builder builder =
                    new AlertDialog.Builder(context)
                            .setTitle(title)
                            .setMessage(message);

            if (positiveListener != null) {
                builder.setPositiveButton(positiveStr, positiveListener);
            }

            if (negativeListener != null) {
                builder.setNegativeButton(negativeStr, negativeListener);
            }

            if (iconDrawable != null) {
                builder.setIcon(iconDrawable);
            }

            builder.show();

        }

    }



    /*
    SnackBar

    Important: This is dependencies on design library !!
    compile 'com.android.support:design:24.0.0'
     */

    public void showShortSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    public void showLongSnackBar(View view, String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).show();
    }

    public void showShortSnackBarWithAction(View view, String message,
                                            String actionStr,
                                            View.OnClickListener onClickListener) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT)
                .setAction(actionStr, onClickListener)
                .show();
    }

    public void showLongSnackBarWithAction(View view, String message,
                                           String actionStr,
                                           View.OnClickListener onClickListener) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
                .setAction(actionStr, onClickListener)
                .show();
    }



    /*
    Notification

     */

    //Simple notification will sent notification with title, message,
    // use height notify priority and default ring ;
    public void sentSimpleNotification(String title, String message) {
        sentSimpleNotification(-1, title, message);
    }

    public void sentSimpleNotification(int iconResId, String title, String message) {
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setContentTitle(title)
                        .setContentText(message);

        if (iconResId == -1) {
            builder.setSmallIcon(android.R.drawable.ic_notification_overlay);
        } else {
            builder.setSmallIcon(iconResId);
        }

        builder.setPriority(Notification.PRIORITY_HIGH);
        builder.setDefaults(Notification.DEFAULT_ALL);


        NotificationManager manager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        manager.notify(0, builder.build());

    }

    private boolean isNonNullAndEmptyCheck(String checkStr) {
        return checkStr != null && !"".equals(checkStr.trim());
    }
}
