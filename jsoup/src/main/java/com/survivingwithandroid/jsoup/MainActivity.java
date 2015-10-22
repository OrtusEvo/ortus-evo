package com.survivingwithandroid.jsoup;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;


public class MainActivity extends ActionBarActivity {

    private TextView respText;
    public LogicAdapter la;
    public LinkedList<Second> data;
    Second sla;
    public static String url2="https://nodarbibas.rtu.lv/grafiks.php?action=callendar&id=15343&lang=en";
    public static String url="https://nodarbibas.rtu.lv/grafiks.php?action=callendar&id=15341&lang=en";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        respText = (TextView) findViewById(R.id.edtResp);

        custWorker();

        start();
    }
    public  void start(){
        new ParseURL().execute(new String[]{url});
        Log.d("AUTO excution : ", "URL : " + url);
    }

    public void custWorker(){
        File file=new File(getFilesDir()+File.separator+"a");
        file.delete();
        if(!file.exists()){
            Log.d("File Check : ", file.getPath()+" File Not Found \nCreating New File!");

            try {
                file.createNewFile();
                Log.d("File Check : ", " File Created Successfully!");
                Thread work=new Thread(new Runnable() {
                    @Override
                    public void run() {

                        StringBuffer buffer = new StringBuffer();
                        try {
                            Log.d("JSwa", "Connecting to [" + url + "]");
                            Document doc  = Jsoup.connect(url).get();
                            Log.d("JSwa", "Connected to ["+url+"]");
                            buffer.append(doc.toString());
                            FileOutputStream outputStream;

                            try {
                                File fil=new File(getFilesDir()+File.separator+"a");
                                outputStream = openFileOutput(fil.getPath(), Context.MODE_PRIVATE);
                                outputStream.write(buffer.toString().getBytes());
                                outputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }catch(Throwable t) {
                            t.printStackTrace();
                        }
                        Log.d("## Worker Thread : ",buffer.toString());

                    }


                });
                work.start();

            } catch (IOException e) {
                e.printStackTrace();
                Log.d("File Check : ", " File Creation Failed due to :\n"+e.toString());

            }
        }else{
            Log.d("File no : ", "Path : " + file.getAbsolutePath()+"  Found\nSkiping online Sync\nShowing offline data!!");
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
        if (id == R.id.action_settings) {
            Toast.makeText(this,"Application is in development phase,Beta Version will be released soon. \nDeveloper Code_Beast<SR>",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private class ParseURL extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            StringBuffer buffer = new StringBuffer();
            try {
                File input = new File(getFilesDir()+"/a");
               // Document doc = Jsoup.parse(input, "UTF-8");
                Log.d("JSwa", "Connecting to ["+strings[0]+"]");
                Document doc  = Jsoup.connect(strings[0]).get();
                Log.d("JSwa", "Connected to ["+strings[0]+"]");
                // Get document (HTML page) title
                String title = doc.title();
                Log.d("JSwA", "Title ["+title+"]");
                buffer.append("Course: " + title + "\r\n");

                /*// Get meta info
                Elements metaElems = doc.select("meta");
                buffer.append("META DATA\r\n");
                for (Element metaElem : metaElems) {
                    String name = metaElem.attr("name");
                    String content = metaElem.attr("content");
                    buffer.append("name ["+name+"] - content ["+content+"] \r\n");
                }

                Elements topicList = doc.select("calendar-day");
                buffer.append("Topic list\r\n");
                for (Element topic : topicList) {
                    String data = topic.attr("event");

                    buffer.append("Data ["+data+"] \r\n");
                }*/

                Elements bodyContents=doc.getElementsByClass("calendar-day");

               // buffer.append(bodyContents.toString());
                for (Element bc:bodyContents) {
                    DateFormat dateFormat = new SimpleDateFormat("dd");
                    Date date = new Date();
                    String day=dateFormat.format(date);
                    int dayint=Integer.parseInt(day);

                    String rtudate = bc.getElementsByClass("day-number").text();
                   // buffer.append(day+" "+rtudate);
                    int rtudayint=Integer.parseInt(rtudate);
                    if (dayint ==rtudayint) {
                        buffer.append("\n#########################################\n");

                        Elements bc2 = bc.getElementsByClass("event");
                        if (bc2.size() == 0) {
                            buffer.append("\n Yo No fuckin Class Today!\n");
                        }else{
                            buffer.append("   Today we have "+bc2.size()+" classes");
                        }
                        buffer.append("\n     Date : "+bc.getElementsByClass("day-number").text()+",Oct,2015 ");
                        int count = 1;
                        for (Element bc3 : bc2) {
                            buffer.append("\n------------------------- Class " + count + " -------------------------\n");
                            String str1 = (bc3.text());
                            String time = str1.substring(0, 11);
                            String sub = bc3.getElementsByTag("b").text();
                            String teacher = str1.substring(str1.indexOf(sub) + sub.length(), str1.indexOf(','));
                            String place = str1.substring(str1.lastIndexOf(',') + 1, str1.length());
                            buffer.append("Time : " + time + "\nSub : " + sub + "\nTeacher : " + teacher + "\nPlace : " + place);
                            buffer.append("\n-------------------------------------------------------------");
                            count++;
                        }
                    }

                }
                buffer.append("\n Monthly Time-Table \n");
                for (Element bc:bodyContents){
                    buffer.append("\n**********************************************************\n");
                    buffer.append("     Date : "+bc.getElementsByClass("day-number").text()+",Sept,2015 ");
                    //buffer.append("\n*****************\n");

                    Elements bc2=bc.getElementsByClass("event");
                    if(bc2.size()==0){
                        buffer.append("\n Yo No fuckin Class Today!\n");
                    }
                    int count=1;
                    for (Element bc3:bc2) {
                        buffer.append("\n------------------------- Class "+count+" -------------------------\n");
                         String str1= (bc3.text());
                        String time=str1.substring(0, 11);
                        String sub =bc3.getElementsByTag("b").text();
                        String teacher = str1.substring(str1.indexOf(sub)+sub.length(),str1.indexOf(','));
                        String place=str1.substring(str1.lastIndexOf(',')+1,str1.length());
                        buffer.append("Time : "+time+"\nSub : "+sub+"\nTeacher : "+teacher+"\nPlace : "+place);
                        buffer.append("\n-------------------------------------------------------------");
                        count++;
                    }
                }


            }
            catch(Throwable t) {
                t.printStackTrace();
            }

            return buffer.toString();

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            respText.setText(s);
        }
    }

}
