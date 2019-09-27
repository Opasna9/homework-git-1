package reflection;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        SomeClass someClass = new SomeClass();

        Class clazz = someClass.getClass();
        Class clazz1 = Class.forName(SomeClass.class.getName());
        Class clazz2 = Class.forName("reflection.SomeClass");
        System.out.println("Class " + clazz.getName());
        System.out.println("");

        System.out.println("Constructors");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.print(i+1 + " ");
            System.out.println(constructors[i].getName());
            Parameter[] parameters  = constructors[i].getParameters();
            for (Parameter parameter : parameters) {
                String parameterName = parameter.getName();
                String parameterType = parameter.getType().getName();
                System.out.println("Parameter: Name = " +parameterName + ": , Type = " + parameterType);
            }
        }
        System.out.println("");

        System.out.println("Methods");
        Method[] methods = clazz.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            String nameMethod = methods[i].getName();
            String modifierMethod = Modifier.toString(methods[i].getModifiers());
            String returnTypeMethod = methods[i].getReturnType().getName();

            System.out.println(i+1 + " " + nameMethod);
            System.out.println("Modifier: " + modifierMethod);
            System.out.println("ReturnType: " + returnTypeMethod);
            Parameter[] parameters  = methods[i].getParameters();
            for (Parameter parameter : parameters) {
                String parameterName = parameter.getName();
                String parameterType = parameter.getType().getName();
                System.out.println("Parameter: Name = " + parameterName + ": , Type = " + parameterType);
            }

            if (nameMethod.equals("someMethod")){
                System.out.println("-- run method someMethod from real object someClass");
                methods[i].invoke(someClass,"test");
             }
        }

        System.out.println("");

        System.out.println("Fields");
        Field[] fields = clazz.getDeclaredFields();
        int i = 1;
        for (Field field : fields) {
            String name = field.getName();
            String type = field.getType().getName();
            String modifier = Modifier.toString(field.getModifiers());
            System.out.println(i + " Name: " + name + ", Type: " + type + ", Modifier: " + modifier);
            i++;

            if (type.equals("int")){
                System.out.println("-- init and see object field value from real object someClass");
                System.out.println("int");
                field.setAccessible(true);
                field.setInt(someClass, 6);

                System.out.println(field.getInt(someClass));
            }
        }

        System.out.println("");
        createdObject();
        System.out.println("");
        createdObjectWithConstructor();

    }

    public static void createdObject() {
        System.out.println("createdObject()");
        SomeClass myClass = null;
        try {
            Class clazz = Class.forName(SomeClass.class.getName());
            //Class clazz = Class.forName("reflection.SomeClass");
            myClass = (SomeClass) clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output created object reflection.MyClass@60e53b93
    }

    // ???
    public static void createdObjectWithConstructor() {
        System.out.println("createdObjectWithConstructor()");
        SomeClass myClass = null;
        try {
            //Class clazz = Class.forName(SomeClass.class.getName());
            Class clazz = Class.forName("reflection.SomeClass");

            // if Constructor is not buplic
//            Constructor[] constructors = clazz.getDeclaredConstructors();
//            for (int i = 0; i < constructors.length; i++) {
//                constructors[i].isAccessible();
//            }
//            myClass = (SomeClass)  constructors[1].newInstance(1,"default2");

            // примем, что мы уже знаем параметры конструктора
            Class[] params = {int.class, String.class};
            Constructor con2 = clazz.getConstructor(params);
            myClass = (SomeClass) con2.newInstance(1,"default2");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(myClass);//output created object reflection.MyClass@60e53b93
    }

}

class SomeClass {
    private int i;
    String s;

    public SomeClass() {
    }


    public SomeClass(int i, String s) {
        this.s = s;
        this.i = i;
    }

    public String someMethod(String s) {
        System.out.println("this is " + s);
        return s;
    }

    public final String someMethodSecond(int i) {
        String s = "this is " + i;
        System.out.println(s);
        return s;
    }
}