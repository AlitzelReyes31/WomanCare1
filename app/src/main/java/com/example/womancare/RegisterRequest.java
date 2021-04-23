package com.example.womancare;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.Response;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="http://192.168.0.12/Register.php";
    private Map<String,String> params;
    public RegisterRequest(String nombre,String username,String password,int edad, Response.Listener<String>listener){
        super(Method.POST, REGISTER_REQUEST_URL,listener,null);
        params= new HashMap<>();
        params.put("nombre",nombre);
        params.put("username",username);
        params.put("password",password);
        params.put("edad",edad+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
