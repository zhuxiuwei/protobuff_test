package com.example.tutorial;

public class AddressBookProtosTest {
    public static void main(String[] args) {
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
    }
}
