package com.yuyakaido.android.cardstackview.sample;

import java.util.ArrayList;
import java.util.List;

public class DataFactory {
    private static List<DataModel> data = null;

    public static void initialize(){
        data = new ArrayList<DataModel>();
        DataModel d1 = new DataModel();
        d1.senderName = "Sheena";
        d1.source = "outlook";
        d1.subject = "Design discussion";

        DataModel d2 = new DataModel();
        d2.senderName = "Abhinav";
        d2.source = "teams";
        d2.subject = "PR review";

        DataModel d3 = new DataModel();
        d3.senderName = "Vani";
        d3.source = "Excel";
        d3.subject = "Seat allocatiom";

        data.add(d1);
        data.add(d2);
        data.add(d3);
    }

    public static List<DataModel> getData(){
        if(data == null) {
            initialize();
        }
        return data;
    }
}
