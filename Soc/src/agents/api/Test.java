package agents.api;

import java.util.*;

public class Test {

	public Test() {
        Map<String, Object> testMap = new HashMap<String, Object>();
        String str = useTestMap(testMap);
        System.out.println(str);
    }
   
    public String useTestMap(Map<String, Object> test){
        String result = null;
        Object obj = new Object();
        test.put("string1", obj );
        System.out.println(test);
        result = test.get("string1").toString();
        return result;
    }
   
    public static void main(String[] args) {
        new Test();
    }
   
    
}