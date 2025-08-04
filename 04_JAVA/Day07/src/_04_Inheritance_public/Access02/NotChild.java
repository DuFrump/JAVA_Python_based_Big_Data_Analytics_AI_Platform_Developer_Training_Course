package _04_Inheritance_public.Access02;

import _04_Inheritance_public.Access01.Parent;

public class NotChild extends Parent{
    void accessTest() {
        Parent p2 = new Parent();
//        p2.accessProtected() ;
    }
}
