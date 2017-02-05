package All;

import java.lang.reflect.Type;

/**
 * Created by pierre on 04/02/17.
 */
public class DynamicInstance<T> {
    Class<T> myClass;


    public static DynamicInstance create() {
        double a = Math.random();
        if (a < 0.5) {
            return new DynamicInstance<String>().setMyClass(String.class);
        } else {
            return new DynamicInstance<Integer>().setMyClass(Integer.class);
        }
    }

    public void giveMyClass() {
        System.out.println(myClass.getName());
    }


    public static void main(String[] args) {
        DynamicInstance dynamicInstance = DynamicInstance.create();
        dynamicInstance.giveMyClass();
    }

    public DynamicInstance setMyClass(Class<T> myClass) {
        this.myClass = myClass;
        return this;
    }
}
