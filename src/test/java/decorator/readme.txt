装饰者模式：
    动态的给一个对象添加一些额外的职责；

    Component：被装饰对象的基类/抽象组件
        定义一个对象接口，可以给这些对象动态添加职责

    ConcreteComponent: 具体被装饰对象/具体组件
        定义一个对象，可以给这个对象添加一些职责

    Decorator: 装饰者抽象类
        维持一个指向 Component 实例的引用，并定义一个与 Component 接口一直的接口

    ConcreteDecorator: 具体装饰者
        具体的装饰对象，给内部持有的具体装饰对象，增加具体的职责
