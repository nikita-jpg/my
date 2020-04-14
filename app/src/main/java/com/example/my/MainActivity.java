package com.example.my;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.OperationApplicationException;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.os.RemoteException;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView list;

    private SimpleCursorAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.list);


        Bitmap[] mass= new Bitmap[0];
        try {
            mass = getImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Adapter arr= new Adapterr(this,mass);
        list.setAdapter((ListAdapter) arr);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private Uri[] getImagesUri(){
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        String sortedOrder = MediaStore.Images.Media.DATE_ADDED;

        String[] projection = new String[]{MediaStore.Images.Media.DISPLAY_NAME,MediaStore.Images.Media._ID};
        Cursor cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,projection, null, null, sortedOrder);
        cursor.moveToFirst();

        Uri[] uris = new Uri[cursor.getCount()];

        for(int i=0;i<cursor.getCount();i++) {
            uris[i] = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,""+cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID)));
            cursor.moveToNext();
        }
        return uris;
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    private Bitmap[] getImage() throws IOException {
        ContentResolver contentResolver = getApplicationContext().getContentResolver();
        Uri[] arrUri=getImagesUri();
        Bitmap[] bitmaps = new Bitmap[arrUri.length];
        for(int i=0;i<arrUri.length;i++){


            if(Build.VERSION.SDK_INT>=29) {
                ImageDecoder.Source dec = ImageDecoder.createSource(contentResolver,arrUri[i]);
                bitmaps[i] = ImageDecoder.decodeBitmap(dec);
            } else {
                bitmaps[i]=MediaStore.Images.Media.getBitmap(contentResolver, arrUri[i]);
            }
        }
        String d ="d";
        return bitmaps;
    }
}
