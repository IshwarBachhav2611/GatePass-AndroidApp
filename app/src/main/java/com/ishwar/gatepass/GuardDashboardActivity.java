package com.ishwar.gatepass;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class GuardDashboardActivity extends AppCompatActivity {

    private CardView cardShowQR;
    private CardView cardPendingRequest;
    private CardView cardVisitorList;

    private TextView btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guard_dashboard);

        initializeViews();
        setupClickListeners();
    }


    // INITIALIZE VIEWS
    private void initializeViews() {

        cardShowQR = findViewById(R.id.cardShowQR);
        cardPendingRequest = findViewById(R.id.cardPendingRequest);
        cardVisitorList = findViewById(R.id.cardVisitorList);

        // Menu button
        btnMenu = findViewById(R.id.btnMenu);
    }


    // CLICK LISTENERS
    private void setupClickListeners() {

        // Menu
        btnMenu.setOnClickListener(
                v -> showGuardMenu()
        );

        // Show QR
        cardShowQR.setOnClickListener(
                v -> showQRPopup()
        );

        // Pending Requests
        cardPendingRequest.setOnClickListener(
                v -> showPendingRequestsPopup()
        );

        // Accepted Visitor List
        cardVisitorList.setOnClickListener(
                v -> showAcceptedVisitorsPopup()
        );
    }


    // GUARD MENU
    private void showGuardMenu() {

        PopupMenu popupMenu = new PopupMenu(
                GuardDashboardActivity.this,
                btnMenu
        );

        popupMenu.getMenu().add(
                Menu.NONE,
                1,
                Menu.NONE,
                "Logout"
        );

        popupMenu.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == 1) {

                logoutGuard();

                return true;
            }

            return false;
        });

        popupMenu.show();
    }


    // LOGOUT GUARD
    private void logoutGuard() {

        Toast.makeText(
                this,
                "Logged out successfully",
                Toast.LENGTH_SHORT
        ).show();

        Intent intent = new Intent(
                GuardDashboardActivity.this,
                MainActivity.class
        );

        // Remove dashboard from back stack
        intent.setFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK
        );

        startActivity(intent);

        finish();
    }


    // SHOW QR POPUP
    private void showQRPopup() {

        Dialog dialog = createDialog(
                R.layout.popup_show_qr
        );

        ImageView imgVisitorQR =
                dialog.findViewById(R.id.imgVisitorQR);

        TextView btnCloseQR =
                dialog.findViewById(R.id.btnCloseQR);

        // Data stored inside the QR code
        String qrData =
                "gatepass://visitor/register";

        // Generate QR code
        Bitmap qrBitmap = generateQRCode(qrData);

        if (qrBitmap != null) {
            imgVisitorQR.setImageBitmap(qrBitmap);
        }

        // Close button
        btnCloseQR.setOnClickListener(
                v -> dialog.dismiss()
        );

        dialog.show();

        setDialogSize(dialog);
    }


    // GENERATE QR CODE
    private Bitmap generateQRCode(String data) {

        QRCodeWriter writer = new QRCodeWriter();

        try {

            BitMatrix bitMatrix =
                    writer.encode(
                            data,
                            BarcodeFormat.QR_CODE,
                            500,
                            500
                    );

            int width = bitMatrix.getWidth();
            int height = bitMatrix.getHeight();

            Bitmap bitmap = Bitmap.createBitmap(
                    width,
                    height,
                    Bitmap.Config.RGB_565
            );

            for (int x = 0; x < width; x++) {

                for (int y = 0; y < height; y++) {

                    bitmap.setPixel(
                            x,
                            y,
                            bitMatrix.get(x, y)
                                    ? Color.BLACK
                                    : Color.WHITE
                    );
                }
            }

            return bitmap;

        } catch (WriterException e) {

            e.printStackTrace();

            Toast.makeText(
                    this,
                    "Unable to generate QR code",
                    Toast.LENGTH_SHORT
            ).show();

            return null;
        }
    }



    // PENDING REQUESTS POPUP
    private void showPendingRequestsPopup() {

        Dialog dialog = createDialog(
                R.layout.popup_pending_requests
        );

        TextView btnAccept1 =
                dialog.findViewById(R.id.btnAccept1);

        TextView btnReject1 =
                dialog.findViewById(R.id.btnReject1);

        TextView btnAccept2 =
                dialog.findViewById(R.id.btnAccept2);

        TextView btnReject2 =
                dialog.findViewById(R.id.btnReject2);

        TextView btnClose =
                dialog.findViewById(R.id.btnCloseRequests);

        // Visitor 1 - Accept
        btnAccept1.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Visitor accepted",
                    Toast.LENGTH_SHORT
            ).show();

        });

        // Visitor 1 - Reject
        btnReject1.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Visitor rejected",
                    Toast.LENGTH_SHORT
            ).show();

        });

        // Visitor 2 - Accept
        btnAccept2.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Visitor accepted",
                    Toast.LENGTH_SHORT
            ).show();

        });

        // Visitor 2 - Reject
        btnReject2.setOnClickListener(v -> {

            Toast.makeText(
                    this,
                    "Visitor rejected",
                    Toast.LENGTH_SHORT
            ).show();

        });

        // Close
        btnClose.setOnClickListener(
                v -> dialog.dismiss()
        );

        dialog.show();

        setDialogSize(dialog);
    }


    // ACCEPTED VISITORS POPUP
    private void showAcceptedVisitorsPopup() {

        Dialog dialog = createDialog(
                R.layout.popup_accepted_visitors
        );

        TextView btnClose =
                dialog.findViewById(R.id.btnCloseVisitors);

        btnClose.setOnClickListener(
                v -> dialog.dismiss()
        );

        dialog.show();

        setDialogSize(dialog);
    }


    // CREATE DIALOG
    private Dialog createDialog(int layoutId) {

        Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(
                Window.FEATURE_NO_TITLE
        );

        dialog.setContentView(layoutId);

        if (dialog.getWindow() != null) {

            dialog.getWindow().setBackgroundDrawable(
                    new ColorDrawable(Color.TRANSPARENT)
            );
        }

        return dialog;
    }


    // DIALOG SIZE
    private void setDialogSize(Dialog dialog) {

        if (dialog.getWindow() != null) {

            WindowManager.LayoutParams params =
                    dialog.getWindow().getAttributes();

            params.width =
                    WindowManager.LayoutParams.WRAP_CONTENT;

            params.height =
                    WindowManager.LayoutParams.WRAP_CONTENT;

            dialog.getWindow().setAttributes(params);
        }
    }
}