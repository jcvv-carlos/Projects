package com.example.karloz.lanzador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    GridView appView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appView = (GridView) findViewById(R.id.appView);
        final ArrayList<App> apps = appsInstaladas();
        AppAdapter adapter = new AppAdapter(this, apps);
        appView.setAdapter(adapter);
        final PackageManager packageManager = this.getPackageManager();

        appView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(apps.get(position).getPaquete());
                startActivity( LaunchIntent );
            }
        });
    }

    public ArrayList appsInstaladas() {
        ArrayList<App> appsLista = new ArrayList<>();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        List aplicaciones = getPackageManager().queryIntentActivities(mainIntent, 0);

        for (Object object : aplicaciones){
            ResolveInfo info = (ResolveInfo) object;
            String nombre = (String)((info != null) ? getBaseContext().getPackageManager().getApplicationLabel(info.activityInfo.applicationInfo) : "???");
            String appNombre  	= info.activityInfo.applicationInfo.publicSourceDir.toString();
            String paquete  = info.activityInfo.applicationInfo.packageName.toString();
            Drawable icono    = getBaseContext().getPackageManager().getApplicationIcon(info.activityInfo.applicationInfo);
            appsLista.add(new App(nombre, appNombre, paquete, icono));
        }

        return appsLista;
    }
}
