package com.promote.threeman.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;

import com.promote.jchlib.util.DisplayUtil;
import com.promote.threeman.R;

/**
 * Created by ACER on 2015/4/3.
 */
public class ThreeLoginDialog extends Dialog {

    private Context context;

    public ThreeLoginDialog(Context context) {
        super(context);
        this.context = context;
    }

    public ThreeLoginDialog(Context context, int theme) {
        super(context, theme);
    }

    /**
     * 子类重写，不可用本父类方法。
     *
     * @return
     */
    protected View getThreeContentView() {
        throw new IllegalStateException("Three Dialog's content view should not be null.");
    }

    /**
     * Helper class for creating a custom dialog.
     */
    public static class Builder {

        private ImageButton thrdialogcloseib;
        private FrameLayout contentLayout;
        private ThreeLoginDialog dialog;
        private View customContentView;
        private Context context;

        public void setCustomContentView(View customContentView) {
            this.customContentView = customContentView;
        }

        public Builder() {
        }

        public ThreeLoginDialog create(ThreeLoginDialog dialog_temp) {

            this.dialog = dialog_temp;
            this.context = dialog_temp.getContext();
            View view = LayoutInflater.from(context).inflate(R.layout.login_base_dialog, null);

            initialize(view);

            dialog.setContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                    .MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            dialog.setCanceledOnTouchOutside(false);
            dialog.getWindow().setBackgroundDrawable(context.getResources().getDrawable(R
                    .drawable.three_login_dialog_bg));

            //resize dialog size.width is 80 percent of the screen width.
            int winWidth = (int) ((double) setDialogSize(dialog.getWindow().getWindowManager()).x
                    * 0.9);
            dialog.getWindow().setLayout(winWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setGravity(Gravity.CENTER);

            return dialog;

        }

        public Point setDialogSize(WindowManager windowManager) {
            Point point = new Point();
            Display display = windowManager.getDefaultDisplay();
            DisplayUtil.getSize(display, point);

            return point;
        }


        private void initialize(View view) {

            thrdialogcloseib = (ImageButton) view.findViewById(R.id.thr_dialog_close_ib);
            contentLayout = (FrameLayout) view.findViewById(R.id.three_dialog_content_ll);

            thrdialogcloseib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            customContentView = dialog.getThreeContentView();
            if (customContentView != null) {
                contentLayout.addView(customContentView, new FrameLayout.LayoutParams(ViewGroup
                        .LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            }
        }
    }


}
