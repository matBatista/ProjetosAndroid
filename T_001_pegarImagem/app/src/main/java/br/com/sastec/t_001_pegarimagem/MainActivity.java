package br.com.sastec.t_001_pegarimagem;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    Context context;
    ImageView ivCamera;
    ImageView ivGaleria;

    Button btnGaleria;

    TextView tst;

    Intent intent;
    private static int RESULT_LOAD_IMAGE = 1;
    private static int CAMERA_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telainicial);

        initVariaveis();
        initAcoes();
    }

    private void initVariaveis() {
        ivCamera = (ImageView) findViewById(R.id.ivCamera);
        ivGaleria = (ImageView) findViewById(R.id.ivGaleria);

        tst = (TextView) findViewById(R.id.tst);

        btnGaleria = (Button) findViewById(R.id.btnGaleria);

    }


    private void initAcoes() {
        ivCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirCamera();

            }
        });
        btnGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String caminho = "/sdcard/nova_mae.jpg";
                ivGaleria.setImageBitmap(BitmapFactory.decodeFile(caminho));
                tst.setText(caminho);
//                abrirGaleria();
            }
        });
    }

    private void abrirCamera() {
        //startActivityForResult(intent, CAMERA_REQUEST);
    }

    private void abrirGaleria() {

        intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,RESULT_LOAD_IMAGE);

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {android.provider.MediaStore.Images.Media.DATA};

            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            try {
                ivGaleria.setImageBitmap(BitmapFactory.decodeFile(picturePath));
            }catch (Exception ex){
                ivGaleria.setImageResource(R.drawable.ic_camera_alt_black_24px);
            }
            tst.setText(picturePath);

        }
     }
}
