package Intermediate1.string3;

public class TestString1 {
    public static void main(String[] args) {
//        String url = "https://www.example.com"; // 코드 작성
//        System.out.println(url.startsWith("https://"));
//
//        String[] arr = {"hello", "java", "jvm", "spring", "jpa"}; // 코드 작성
//        int total =0;
//        for (var str : arr) {
//            total += str.length();
//            System.out.println(str+" : "+str.length());
//        }
//        System.out.println("sum = " + total);

//        String str = "hello.txt"; // 코드 작성
//        int index=str.indexOf(".txt");
//        System.out.println(index);

//        String str = "hello.txt"; // 코드 작성
//        String res1=str.substring(5);
//        String res2=str.substring(0,5);
//        System.out.println(res1+" "+res2);
//        String str = "hello.txt";
//        String ext = ".txt";
//        int index =str.indexOf(ext);
//        String name = str.substring(index);
//        String txt = str.substring(0,index);
//        System.out.println(name+" "+txt);
//        String str = "start hello java, hello spring, hello jpa";
//        String key = "hello";
//        int count=0;
//        int index = str.indexOf(key);
//        while (index >=0) {
//            index = str.indexOf(key,index+1);
//            count++;
//        }
//        System.out.println(count);

        String str = "Hello Java";
        StringBuilder builder = new StringBuilder(str);
        String r = builder.reverse().toString();
        System.out.println(r);

    }
}
