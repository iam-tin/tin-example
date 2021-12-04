package com.tin.example.jdk.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * title: ArrayListTest
 * <p>
 * description:
 *
 * @author tin @看点代码再上班 on 2021/3/30 下午11:50
 */
public class ArrayListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("apple");
        list.add("orange");
        list.add("strawberry");
        list.add("dog");
        list.add("cat");
        list.add("people");
        list.add("people");
        list.add("people");
        list.add("people");
        list.add("people");
        list.add("people");

        list.remove(1);
    }
}
