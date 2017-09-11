package example.com.intentsproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    private File ImageFile;
    Intent intent= null, chooser= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void TakeAPhoto(View view)
    {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ImageFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"TestImage/jpg");
        Uri TempUri = Uri.fromFile(ImageFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, TempUri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(intent,0);
    }
   /* protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode==0)
        {
            switch (resultCode)
            {
                case Activity.RESULT_OK:
                    if (ImageFile.exists())

                    {


                    }else
                        {


                        }
                    break;
                case Activity.RESULT_CANCELED:
                    break;
                default:
                    break;


            }

        }

    }*/

    public void SendAnEmail(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        String[] to= {};
        intent.putExtra(Intent.EXTRA_EMAIL,to);
        intent.putExtra(Intent.EXTRA_SUBJECT," ");
        intent.putExtra(Intent.EXTRA_TEXT," ");
        intent.setType("message/rfc822");
        chooser = Intent.createChooser(intent,"Send Email");
        startActivity(chooser);

    }
}
