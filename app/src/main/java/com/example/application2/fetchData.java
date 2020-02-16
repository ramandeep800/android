package com.example.application2;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class fetchData extends AsyncTask<Void,Void,Void> {
    String line="";
    public String values="";
    String sigleparsed;
    String parsedobject;

    @Override
    protected Void  doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.myjson.com/bins/ippvu");
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            InputStream inputStreamReader = httpsURLConnection.getInputStream();
            InputStreamReader responseBodyReader =
                    new InputStreamReader(inputStreamReader, "UTF-8");
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamReader));
            String data = "";
            while (data != null) {
                data = bufferedReader.readLine();
                line = data + line;
                Log.d("Data", "doInBackground: "+line );

            }
//            JSONArray jsonArray=new JSONArray(line);
//            for(int i=0;i<jsonArray.length();i++)
//            {
//                JSONObject jsonObject=(JSONObject) jsonArray.get(i);
//                sigleparsed="name" +jsonObject.get("name") +"/n" +"password:" +jsonObject.get("password")
//                     +"/n"   +"contact: " +jsonObject.get("contact");
//                parsedobject=parsedobject+sigleparsed;
//            }
//            JsonReader jsonReader;
//            jsonReader = new JsonReader(responseBodyReader);
//            jsonReader.beginObject();
//            while (jsonReader.hasNext())
//            {
//                String key=jsonReader.nextName();
//                if(key.equals("name"))
//                {
//                    String values=jsonReader.nextString();
                    String val=values.toString();
//                    break;
//                }
//                else
//                {
//                    jsonReader.skipValue();
//                }
//            }
//            jsonReader.close();


        }catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        return null;

    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        //MainActivity.txt1.setText(line);
        MainActivity.txt1.setText(line);


    }
}
