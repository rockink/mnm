package com.mnm.rockink.recipe;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class InputImageFragment extends Fragment {

    private ImageView imageView;
    private Button this_image;
    private Button other_image;
    private InputImageFragmentInteraction myListener;
    private Bitmap bitmap;
    private TextView info;

    public interface InputImageFragmentInteraction{
        void imageChoosen(Bitmap b);
    }


    public InputImageFragment() {
        // Required empty public constructor
    }

    public void setParams(InputImageFragmentInteraction myListener){
        this.myListener = myListener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.input_image_fragment_layout, container, false);

        imageView = (ImageView) v.findViewById(R.id.imageView);
        this_image = (Button) v.findViewById(R.id.this_image);
        other_image = (Button) v.findViewById(R.id.other_image);
        info =(TextView)v.findViewById(R.id.info);

        this_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListener.imageChoosen(bitmap);
            }
        });

        other_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pickIntent = new Intent();
                pickIntent.setType("image/*");
                pickIntent.setAction(Intent.ACTION_GET_CONTENT);

                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                String pickTitle = "Select or take a new Picture"; // Or get from strings.xml
                Intent chooserIntent = Intent.createChooser(pickIntent, pickTitle);
                chooserIntent.putExtra
                        (
                                Intent.EXTRA_INITIAL_INTENTS,
                                new Intent[] { takePhotoIntent }
                        );

                startActivityForResult(chooserIntent, 1);
            }
        });

        if(savedInstanceState != null){
            bitmap = savedInstanceState.getParcelable("bitmap");
            imageView.setImageBitmap(bitmap);
        }

        if(imageView.getDrawable() != null){
            info.setVisibility(View.GONE);
        }

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            if (data == null) {
                return;
            }

            final Bundle extras = data.getExtras();
            if (extras != null) {
                //Get image
                bitmap = extras.getParcelable("data");
                imageView.setImageBitmap(bitmap);
                info.setVisibility(View.GONE);
            }
            else{
                InputStream inputStream = null;
                try {
                    inputStream = getActivity().getContentResolver().openInputStream(data.getData());
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    imageView.setImageBitmap(bitmap);
                    info.setVisibility(View.GONE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("bitmap",bitmap);
    }
}
