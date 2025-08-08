package _01_DataList;

public class DataListExample {
    public static void main(String[] args) {
        DataList list = new DataList();

        list.add(10);
        list.add("문자");
        list.add(10.33);

        for (int i = 0; i < list.size(); i++) {
            Object data = list.get(i);
            System.out.println(data);

            if(data instanceof Integer) {
                System.out.println("정수 : " + (int)data  );
            } else if (data instanceof Double) {
                System.out.println("실수 : " + (double)data);
            } else if (data instanceof String) {
                System.out.println("문자열 : " + (String)data);
            }
        }
    }
}
