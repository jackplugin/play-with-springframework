package fun.erudite.playwithsf.beanlifecycle;

import javax.annotation.PostConstruct;

public class BeanDemo {

    static {
        System.out.println("This message comes from initializer block of BeanDemo");
    }

    public BeanDemo() {
        System.out.println("This message comes from BeanDemo() - Constructor of BeanDemo");
    }

    public void sayHello() {
        System.out.println("This message comes from sayHello() method of BeanDemo");
    }

    public void customInit() {
        System.out.println("This message comes from customInit() method of BeanDemo");
    }

    @PostConstruct
    public void init() {
        System.out.println("This message comes from @PostConstructor of BeanDemo");
    }
}
