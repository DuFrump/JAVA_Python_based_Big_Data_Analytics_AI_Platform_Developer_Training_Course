package _04_Inheritance_public.Access02;

import _04_Inheritance_public.Access01.Parent;

public class Child extends Parent {
    void accessTest() {
        super.accessProtected();

//        Parent p1 = new Parent();
//        p1.accessProtected();
    }
}
