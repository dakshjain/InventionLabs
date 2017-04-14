package com.example.rajatjain.inventionlabs;

import android.content.Intent;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    public ImageView view;
    String[] result = new String[21];
    int x = 0;
    int y = 0;
    int result_count=0;
    int values_count =0;
    int counter = 0;
    Point point;
    Path path, path2, path3, path3_2, path4, path5, path5_2, path5_3, path5_4, path5_5,
            path6, path7, path8, path8_2, path9, path10, path10_2, path10_3, path10_4, path11, path12;
    Region r;
    RelativeLayout layout;
    GestureDetector.SimpleOnGestureListener gesture;
    Button submit;
    boolean flag;
    GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        view = (ImageView) findViewById(R.id.daksh1);
        layout = (RelativeLayout) findViewById(R.id.activity_main);
        gestureDetector = new GestureDetector(getApplicationContext(),new GestureListener());
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return gestureDetector.onTouchEvent(event);
            }
        });
        submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i  =new Intent(MainActivity.this,Result.class);
                i.putExtra("Results", result_count);
                i.putExtra("Values_no",values_count);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().
                INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
        return true;
    }
    public boolean checkpoint(int x, int y, String no) {
        RectF rectF = new RectF();
        Path p  = getPath(no);
        p.computeBounds(rectF, true);
        r = new Region();
        r.setPath(p, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        if (r.contains(x, y)) {
            result[Integer.parseInt(no)] = "true";
            result_count++;
            flag = true;
        } else {
            if (Integer.parseInt(no) == 3 && counter < 2) {
                flag = checkpoint(x, y, no);
            } else if (Integer.parseInt(no) == 5 && counter < 5) {
                Toast.makeText(this, "" + flag, Toast.LENGTH_SHORT).show();
                flag = checkpoint(x, y, no);
            } else if (Integer.parseInt(no) == 8 && counter < 2) {
                flag = checkpoint(x, y, no);
            } else if (Integer.parseInt(no) == 10 && counter < 4) {
                flag = checkpoint(x, y, no);
            } else
                flag = false;
        }
        counter = 0;
        return flag;
    }
    private Path getPath(String no) {
        path = new Path();
        path.moveTo(390, 85);
        path.lineTo(500, 85);
        path.lineTo(500, 150);
        path.lineTo(390, 150);
        path.close();
        path2 = new Path();
        path2.moveTo(910, 315);
        path2.lineTo(940, 315);
        path2.lineTo(940, 335);
        path2.lineTo(910, 335);
        path2.close();
        path3 = new Path();
        path3.moveTo(250, 200);
        path3.lineTo(370, 200);
        path3.lineTo(370, 250);
        path3.lineTo(250, 250);
        path3.close();
        path3_2 = new Path();
        path3_2.moveTo(250, 120);
        path3_2.lineTo(370, 120);
        path3_2.lineTo(370, 150);
        path3_2.lineTo(250, 150);

        path4 = new Path();
        path4.moveTo(600, 80);
        path4.lineTo(630, 80);
        path4.lineTo(630, 115);
        path4.lineTo(600, 115);
        path4.close();
        path5 = new Path();
        path5.moveTo(200, 415);
        path5.lineTo(230, 415);
        path5.lineTo(230, 445);
        path5.lineTo(200, 445);
        path5.close();
        path5_2 = new Path();
        path5_2.moveTo(25, 540);
        path5_2.lineTo(50, 540);
        path5_2.lineTo(50, 585);
        path5_2.lineTo(25, 585);
        path5_2.close();
        path5_3 = new Path();
        path5_3.moveTo(1000, 550);
        path5_3.lineTo(1070, 550);
        path5_3.lineTo(1070, 590);
        path5_3.lineTo(1000, 590);
        path5_3.close();
        path5_4 = new Path();
        path5_4.moveTo(1030, 150);
        path5_4.lineTo(1050, 150);
        path5_4.lineTo(1050, 180);
        path5_4.lineTo(1030, 180);
        path5_4.close();
        path5_5 = new Path();
        path5_5.moveTo(880, 80);
        path5_5.lineTo(900, 80);
        path5_5.lineTo(900, 115);
        path5_5.lineTo(800, 115);
        path5_5.close();
        path6 = new Path();
        path6.moveTo(30, 110);
        path6.lineTo(90, 110);
        path6.lineTo(90, 170);
        path6.lineTo(30, 170);
        path6.close();
        path7 = new Path();
        path7.moveTo(410, 540);
        path7.lineTo(540, 540);
        path7.lineTo(540, 625);
        path7.lineTo(410, 625);
        path7.close();
        path8 = new Path();
        path8.moveTo(915, 450);
        path8.lineTo(945, 450);
        path8.lineTo(945, 500);
        path8.lineTo(915, 500);
        path8.close();
        path8_2 = new Path();
        path8_2.moveTo(700, 350);
        path8_2.lineTo(735, 350);
        path8_2.lineTo(735, 375);
        path8_2.lineTo(700, 375);
        path8_2.close();
        path9 = new Path();
        path9.moveTo(640, 430);
        path9.lineTo(670, 430);
        path9.lineTo(670, 470);
        path9.lineTo(640, 470);
        path9.close();
        path10 = new Path();
        path10.moveTo(120, 220);
        path10.lineTo(140, 220);
        path10.lineTo(140, 250);
        path10.lineTo(120, 250);
        path10.close();
        path10_2 = new Path();
        path10_2.moveTo(245, 390);
        path10_2.lineTo(260, 390);
        path10_2.lineTo(260, 410);
        path10_2.lineTo(245, 410);
        path10_2.close();

        path10_3 = new Path();
        path10_3.moveTo(20, 230);
        path10_3.lineTo(35, 230);
        path10_3.lineTo(35, 245);
        path10_3.lineTo(20, 245);
        path10_3.close();
        path10_4 = new Path();
        path10_4.moveTo(10, 210);
        path10_4.lineTo(20, 210);
        path10_4.lineTo(20, 229);
        path10_4.lineTo(10, 229);
        path10_4.close();

        path11 = new Path();
        path11.moveTo(750, 440);
        path11.lineTo(770, 440);
        path11.lineTo(770, 470);
        path11.lineTo(750, 470);
        path11.close();
        path12 = new Path();
        path12.moveTo(650, 65);
        path12.lineTo(850, 65);
        path12.lineTo(850, 100);
        path12.lineTo(650, 100);
        path12.close();
        Path paths = new Path();

        switch (no) {
            case "1":
                paths = path;
                break;
            case "2":
                paths = path2;
                break;
            case "3":
                counter++;
                if (counter == 1) {
                    paths = path3;
                } else if (counter == 2) {
                    paths = path3_2;
                }
                break;
            case "4":
                paths = path4;
                break;
            case "5":
                counter++;
                switch (counter) {
                    case 1:
                        Log.i("Path:", "Path5");
                        paths = path5;
                        break;
                    case 2:
                        Log.i("Path:", "Path5_2");
                        paths = path5_2;
                        break;
                    case 3:
                        Log.i("Path:", "Path5_3");
                        paths = path5_3;
                        break;
                    case 4:
                        Log.i("Path:", "Path5_4");
                        paths = path5_4;
                        break;
                    case 5:
                        Log.i("Path:", "Path5_5");
                        paths = path5_5;
                        break;
                }
                break;
            case "6":
                paths = path6;
                break;
            case "7":
                paths = path7;
                break;
            case "8":
                counter++;
                if (counter == 1) {
                    paths = path8;
                } else if (counter == 2) {
                    paths = path8_2;
                }
                break;
            case "9":
                paths = path9;
                break;
            case "10":
                counter++;
                switch (counter) {
                    case 1:
                        paths = path10;
                        break;
                    case 2:
                        paths = path10_2;
                        break;
                    case 3:
                        paths = path10_3;
                        break;
                    case 4:
                        paths = path10_4;
                        break;
                }
                break;
            case "11":
                paths = path11;
                break;
            case "12":
                paths = path12;
                break;
        }
        return paths;
    }
    public class GestureListener extends
            GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        // event when double tap occurs
        @Override
        public boolean onDoubleTap(MotionEvent event) {
            point = new Point();
            point.x = (int) event.getX();
            point.y = (int) event.getY();
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    final TextView text = new TextView(getApplicationContext());
                    text.setBackground(getResources().getDrawable(R.drawable.textview_design));
                    text.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    RelativeLayout.LayoutParams layoutParams1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams1.topMargin = point.y - 13;
                    layoutParams1.leftMargin = point.x - 13;
                    text.setLayoutParams(layoutParams1);
                    layout.addView(text);
                    final EditText textview = new EditText(getApplicationContext());
                    textview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
                    textview.setInputType(InputType.TYPE_CLASS_NUMBER);
                    textview.setBackgroundColor(16777215);
                    textview.setHint("??");
                    textview.setSingleLine();
                    textview.requestFocus();
                    textview.setFocusableInTouchMode(true);
                    InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                    imm.showSoftInput(textview, InputMethodManager.SHOW_IMPLICIT);
                    textview.setImeActionLabel("Enter", KeyEvent.KEYCODE_ENTER);
                    textview.setImeOptions(EditorInfo.IME_FLAG_NO_EXTRACT_UI);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.topMargin = point.y - 13;
                    layoutParams.leftMargin = point.x - 13;
                    textview.setLayoutParams(layoutParams);
                    layout.addView(textview);
                    textview.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                        @Override
                        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                            switch (actionId) {

                                case EditorInfo.IME_ACTION_DONE:
                                    InputMethodManager imm = (InputMethodManager) getSystemService(getApplicationContext().INPUT_METHOD_SERVICE);
                                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                                    textview.setVisibility(View.GONE);
                                    try {
                                        if (Integer.parseInt(textview.getText().toString()) <= 12) {
                                            values_count++;
                                            text.setText(textview.getText().toString());
                                            if (checkpoint(point.x, point.y, textview.getText().toString())) {
                                                Log.d("TouchIn", "Touch IN");
                                            } else {
                                                Log.d("TouchOut", "Touch OUT");
                                            }
                                        }

                                        else {
                                            Toast.makeText(MainActivity.this, "invalid no", Toast.LENGTH_SHORT).show();

                                        }
                                    } catch (NumberFormatException e) {
                                        if (textview.getText().toString() == "") {
                                        } else {
                                            Toast.makeText(MainActivity.this, "invalid no", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                default:
                                    return false;
                            }

                        }
                    });
                default:
                    break;
            }
            return true;


        }
}

}

