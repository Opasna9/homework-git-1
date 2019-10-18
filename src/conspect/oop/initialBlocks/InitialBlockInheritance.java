package conspect.oop.initialBlocks;

public class InitialBlockInheritance {
    public static void main(String[] args) {
        Doctor.stDoctor();
        System.out.println("new Doctor()");
        Doctor doctor = new Doctor();
        System.out.println(doctor.form);
        Doctor.stDoctor();
    }
}

class Man {
    public static String form = "man";
    static {
        System.out.println("static block in Man");
    }
    public static void stMan(){
        System.out.println("static method in Man");
    }
}

class Doctor extends Man{
    static {
        System.out.println("static block in Doctor");
    }
    public static void stDoctor(){
        System.out.println("static method in Doctor");
    }
}
