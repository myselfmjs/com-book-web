内部类：
普通内部类   NormalInnerClassTest
静态内部类   StaticInnerClassTest
匿名内部类   UnKnownInnerClassTest
局部内部类   TopicalInnerClassTest

普通内部类:  普通内部类对象依赖外部类对象而存在；即在创建一个普通内部类对象时，需先创建其外部类对象；
            内部类对象可以访问外部类对象的所有访问权限的字段，外部类对象也可以通过内部类对象的引用访问内部类定义的
            所有访问权限的字段
            普通内部类不可以定义static字段
            在类内部可以直接new InnerClass()创建内部类；在类外部需要先 new OutClass().new I你呢人Class()


静态内部类:  一个类的静态成员独立于这个类的任何一个对象而存在，只要在具有访问权限的地方，可以通过 类名.静态成员 的形式访问这个静态成员
            静态内部类作为一个外部类的静态成员而存在：创建一个类的静态内部类对象不需要依赖其外部类对象。
            静态内部类中无法访问外部类的非静态成员(因为外部类的非静态成员是属于每一个外部类对象的，
            而本身静态内部类就是独立外部类对象存在的)


匿名内部类:  匿名内部类有很多种形式，其中最常见的莫过于在方法参数中新建一个借口/类对象，并且实现这个接口声明/类中原有的方法：
            new 一个已经存在的类/抽象类，并且选择性的实现这个类中的一个或多个非final的方法，这个过程
            会创建一个匿名内部类对对象继承对应的类/抽象类，并且重写对应的方法
            同样，在匿名内部类中科院使用外部类的属性，但是外部类却不能使用匿名内部类中定义的属性，
            因为是匿名内部类，在外部类中无法获取这个类的类名，也就无法得到属性信息


局部内部类：  其声明在一个方法体/一段代码块的内部，而且不在定义类的定义域之内便无法使用，
            其提供的功能使用匿名内部类都可以实现，而本身匿名内部类可以写得比它更简洁，因此局部内部类用的比较少



在非静态内部类访问外部类私有成员/外部类访问内部类私有成员的时候，对应的外部类/内部类会生成一个静态方法，
用来返回对应私有成员的值，而对应外部类对象/内部类对象通过调用其内部类/外部类提供的静态方法来回去对应的私有成员的值
