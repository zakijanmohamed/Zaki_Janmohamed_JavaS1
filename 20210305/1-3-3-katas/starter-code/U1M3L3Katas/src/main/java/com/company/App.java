package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public void printKeys(HashMap<String, String> x) {
        for (String c : x.keySet()) {
            System.out.println(c);
        }
    }

    public void printValues(HashMap<String, String> x) {
        for (String c : x.values()) {
            System.out.println(c);
        }
    }

    public void printKeysAndValues(HashMap<String, String> x) {
        for (String c : x.keySet()) {
            System.out.println(c + ": " + x.get(c));
        }
    }

    public HashMap<String, Integer> mapFun(HashMap<String, Integer> x) {
        x.put("Ford Explorer", 2012);
        x.put("Smart Fortwo", 2013);
        x.remove("Jeep Wrangler");

        return (x);
    }

    public Map<String, List<Car>> listCars(List<Car> x) {
        List<Car> toyotaList = new ArrayList<Car>();
        List<Car> fordList = new ArrayList<Car>();
        List<Car> hondaList = new ArrayList<Car>();

        for (Car c : x) {
            if (c.getMake().equals("Toyota")) {
                toyotaList.add(c);
            } else if (c.getMake().equals("Ford")) {
                fordList.add(c);
            } else {
                hondaList.add(c);
            }
        }
        Map<String, List<Car>> h = new HashMap<String, List<Car>>();
        h.put("Toyota", toyotaList);
        h.put("Ford", fordList);
        h.put("Honda", hondaList);

        return h;

    }
}
