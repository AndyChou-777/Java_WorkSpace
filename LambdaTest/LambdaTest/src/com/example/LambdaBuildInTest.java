package com.example;

import java.security.cert.PKIXReason;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;

public class LambdaBuildInTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        
        // 使用 Lambda Expression 定義以Function 函式介面,傳回稱謂(姓名前加上Ms./Mr.)
        Function<Person, String> fun1 = (p) -> p.getGender()==Gender.MALE?"Mr. "+ p.getFirstName():"Ms. "+ p.getFirstName();
        for (Person per: personList) {
        	System.out.println(fun1.apply(per));
        }

        
        
        
        
        // 使用 Lambda Expression 定義Predicate 函式介面,篩選列印30歲以下的Person資訊
        //Predicate<Person> fun2 = (p)->p.getAge()<=30;
        //for (Person per: personList) {
        //   	if(fun2.test(per)) {
        //    		System.out.println(per);
        //    	}
        //    }
        
        
        
        // 使用 Lambda Expression 定義以Comsumer 函式介面以FirstName(age)格式來列印Person資訊           
        //Consumer<Person> fun3 = p -> System.out.println(p.getFirstName()+"("+p.getAge()+")");
        
        //for (Person per: personList) {
        //       	fun3.accept(per);
        //       }
        
        
        
        
    }
    
}
