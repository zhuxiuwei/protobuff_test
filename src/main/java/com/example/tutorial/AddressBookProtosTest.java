package com.example.tutorial;

import java.io.*;

public class AddressBookProtosTest {

    //创建和修改对象
    public static AddressBookProtos.Person testCreateAndUpdateMessage(){
        AddressBookProtos.Person.PhoneNumber number1 =
                AddressBookProtos.Person.PhoneNumber.newBuilder()
                        .setNumber("1381111111")
                        .setType(AddressBookProtos.Person.PhoneType.MOBILE)
                        .build();
        AddressBookProtos.Person.PhoneNumber number2 =
                AddressBookProtos.Person.PhoneNumber.newBuilder()
                        .setNumber("010-1234567")
                        .setType(AddressBookProtos.Person.PhoneType.WORK)
                        .build();
        AddressBookProtos.Person p =
                AddressBookProtos.Person.newBuilder()
                        .setId(123)
                        .setEmail("asdsad@123.com")
                        .setName("Joe")
                        .addPhones(number1)
                        .addPhones(number2)
                        .build();
        System.out.println(p);

        //修改对象只能从Builder创建一个新对象，来修改。Message对象是只读的。
        AddressBookProtos.Person.Builder b = p.toBuilder();
        b.clearPhones();
        b.setId(456);
        b.setName("Tom");
        System.out.println(b.build());  //修改后生成一个新对象
        return p;
    }

    //序列化对象到磁盘
    public static String saveMessageToFile(AddressBookProtos.Person p){
        String fileName = "testSave";
        try {
            FileOutputStream out = new FileOutputStream(fileName);
            p.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    //从磁盘文件反序列化成对象
    public static AddressBookProtos.Person readMessageFromFile(String path){
        AddressBookProtos.Person p = null;
        try {
            FileInputStream in = new FileInputStream(path);
            p = AddressBookProtos.Person.parseFrom(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return p;
    }

    public static void main(String[] args) {
        //生成对象
        AddressBookProtos.Person p = testCreateAndUpdateMessage();
        //序列化
        String file = saveMessageToFile(p);
        //反序列化
        AddressBookProtos.Person p2 = readMessageFromFile(file);
        //验证对象数据没出错
        System.out.println(p.equals(p2));
    }
}
