package conspect.oop.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverridingWithThrows {
}

 class Parent {
    // предок пугает IOException и InterruptedException
    public void f() throws IOException, InterruptedException {}
}

class Child extends Parent {
    // а потомок пугает только потомком IOException
    @Override
    public void f() throws FileNotFoundException {}
    // попытались «расширить тип» бросаемых исключений
    //public void f() throws Exception {} // COMPILATION ERROR: overridden method does not throw 'java.lang.Exception'
}