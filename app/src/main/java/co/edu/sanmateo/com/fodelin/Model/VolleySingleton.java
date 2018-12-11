package co.edu.sanmateo.com.fodelin.Model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.security.AccessControlContext;

/**
 * Created by CHENAO on 19/11/2017.
 */

public class VolleySingleton {

    private static VolleySingleton intanciaVolley;
    private RequestQueue request;
    private static Context contexto;

    private VolleySingleton(Context context) {
        contexto = context;
        request = getRequestQueue();
    }

    public VolleySingleton() {

    }


    public static synchronized VolleySingleton getIntanciaVolley(AccessControlContext context) {
        if (intanciaVolley == null) {
            intanciaVolley = new VolleySingleton();
        }

        return intanciaVolley;
    }

    public RequestQueue getRequestQueue() {
        if (request == null) {
            request = Volley.newRequestQueue(contexto.getApplicationContext());
        }

        return request;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }

}
