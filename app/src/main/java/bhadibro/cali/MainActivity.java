package bhadibro.cali;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    double val1 = 0,val2=0,equiv=0;
    String opr;
    Boolean isOp=false;
    public boolean ZeroCheck(TextView display){
        double x;
        try{
            x=Double.parseDouble(display.getText().toString());
        }catch(Exception e){
            Log.e("Invalid:","Might be a Expression: "+e);
            return false;
        }
        if (x==0)
            return true;
        else
            return false;
    }
    public void Disp(TextView display, int Op){
        if(ZeroCheck(display)){
            display.setText("");
        }
        display.setText("" + display.getText() + Op);
    }
    public double Calculate(String op){
        switch (op) {
            case "+": return val1+val2;
            case "-": return val1-val2;
            case "*": return val1*val2;
            case "÷": return val1/val2;
            default : return 0;
        }
    }
    public  void ExprMk(TextView display, TextView exprDisplay,String op){
        String cont = display.getText().toString();
        if (!isOp){
            val1 = Double.parseDouble(cont);
            exprDisplay.setText(cont+" "+op);
            display.setText("0");
            opr=op;
            isOp=true;
        }
        else{
            String ExprCont= exprDisplay.getText().toString();
            exprDisplay.setText(ExprCont.substring(0,ExprCont.length()-1)+op);
            opr=op;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FontsOverride.setDefaultFont(this, "normal", "segoeui.ttf");
        final TextView display = (TextView)findViewById(R.id.Display);
        final TextView exprDisplay = (TextView)findViewById(R.id.ExprDisplay);

        Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bMC,bDot,bEqual,bMultiply,bPlus,bSubtract,bC,bCE,bBackspace,bDivide,bMS,bMPlus,bMMinus,bMR,bMDown,bMod,bSqrt,bSqr,bRecip,bSignInvert;
        b0 = (Button)findViewById(R.id.b0);
        b1 = (Button)findViewById(R.id.b1);
        b2 = (Button)findViewById(R.id.b2);
        b3 = (Button)findViewById(R.id.b3);
        b4 = (Button)findViewById(R.id.b4);
        b5 = (Button)findViewById(R.id.b5);
        b6 = (Button)findViewById(R.id.b6);
        b7 = (Button)findViewById(R.id.b7);
        b8 = (Button)findViewById(R.id.b8);
        b9 = (Button)findViewById(R.id.b9);
        bMC = (Button)findViewById(R.id.bMC);
        bMR = (Button)findViewById(R.id.bMR);
        bMPlus = (Button)findViewById(R.id.bMPlus);
        bMMinus = (Button)findViewById(R.id.bMMinus);
        bMS = (Button)findViewById(R.id.bMS);
        bMDown = (Button)findViewById(R.id.bMDown);
        bMod = (Button)findViewById(R.id.bMod);
        bSqrt = (Button)findViewById(R.id.bSqrt);
        bSqr = (Button)findViewById(R.id.bSqr);
        bRecip = (Button)findViewById(R.id.bRecip);
        bCE = (Button)findViewById(R.id.bCE);
        bC = (Button)findViewById(R.id.bC);
        bBackspace = (Button)findViewById(R.id.bBackspace);
        bDivide = (Button)findViewById(R.id.bDivide);
        bMultiply = (Button)findViewById(R.id.bMultiply);
        bSubtract = (Button)findViewById(R.id.bSubtract);
        bPlus = (Button)findViewById(R.id.bPlus);
        bSignInvert = (Button)findViewById(R.id.bSignInvert);
        bDot = (Button)findViewById(R.id.bDot);
        bEqual = (Button)findViewById(R.id.bEqual);
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,0);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,3);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,4);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,5);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,6);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,7);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display,8);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Disp(display, 9);
            }
        });
        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
                exprDisplay.setText("");

            }
        });
        bCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("0");
                exprDisplay.setText("");

            }
        });
        bBackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cont = display.getText().toString();
                System.out.println(cont + " len:: " + cont.length());
                if (cont.length()==1 || cont.equals("0") ){
                    display.setText("0");
                }
                else if (cont.length()==2 || cont.equals("-") ){
                    display.setText("0");
                }
                else if(cont.length()>1){
                    display.setText(cont.substring(0, cont.length() - 1));
                }
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cont = display.getText().toString();
                if (!cont.contains(".")){
                    display.setText(cont+".");
                }
            }
        });
        bSignInvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cont = display.getText().toString();
                double x=Double.parseDouble(cont);
                if (x>0){
                    display.setText("-"+cont);
                }
                else if (x < 0) {
                    display.setText(cont.substring(1));
                }
            }
        });
        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExprMk(display,exprDisplay,"+");
            }
        });
        bSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExprMk(display,exprDisplay,"-");
            }
        });
        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExprMk(display,exprDisplay,"*");
            }
        });
        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExprMk(display,exprDisplay,"÷");
            }
        });
        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isOp){
                    String cont = display.getText().toString();
                    val2 = Double.parseDouble(cont);
                    equiv = Calculate(opr);
                    exprDisplay.setText("");
                    display.setText(""+equiv);
                    opr="";
                    isOp=false;
                }
            }
        });
        bSqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cont = display.getText().toString();
                val1 = Math.sqrt(Integer.parseInt(cont));
                exprDisplay.setText("\u221A"+"("+Double.parseDouble(cont)+")");
                display.setText(""+val1);
            }
        });
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        //testing commit
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        /*if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}