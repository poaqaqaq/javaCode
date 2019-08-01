package cn.young.util;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.TreeSet;

interface library<T> {
    public T getName(T name);

    public <T> T getPos(T pos);//这里用上声明：<T>标签，会覆盖类上面声明的T

    public <R> R getDate(R date);
}

class Book<R, E> implements library<String> {//实现这个接口必须要声明泛型

    @Override
    public String getName(String name) {//因为在接口中，是使用和接口一样的泛型，而且没有<>重新声明，所以和实现接口传入的泛型一致
        return null;
    }

    @Override
    public <E> E getPos(E pos) {//如果是加上<E>，声明标签，则将会覆盖类声明时的泛类的E
        return null;
    }

    @Override
    public <U> U getDate(U date) {//此处不能直接写上类型，一定要用泛类型！因为接口类也是没有声明，此处将在使用此方法时，根据传入参数确定泛型的类型
        return null;
    }
}

class People<T extends Number, E extends Double> {//此处只能用extends（只允许泛型为给定的类和其子类）限制上限，不能用super（只允许泛型为给定的类和其父类）限制下限
    T age;
    E salary;

    public People(T age, E salary) {
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "People{" +
                "age=" + age +
                ", salary=" + salary +
                '}';
    }
}

class MyComparator implements Comparator<People<Integer, Double>> {//比较器也必须使用限制的泛型，即如果的比较器如果用了String，下面使用此比较器的构造方法将会报错


    @Override
    public int compare(People<Integer, Double> o1, People<Integer, Double> o2) {
        return o1.age - o2.age;
    }
}

public class MyGeneric {
    public static void main(String[] args) {
        Book<String, Integer> book = new Book<>();
        book.getDate("ggg");
        String a = book.getPos("qqq");//因为调用此方法时声明了泛型为String，所以必须用String类型来接受

        TreeSet<People<Integer, Double>> treeSet = new TreeSet<>(new MyComparator());//这里声明People的泛型，而且比较器必须要符合声明的People泛型
        treeSet.add(new People<>(15, 11.0));//所以这里被限制了只能传入Integer和Double，也可以不写<>，那么将使用Object
        treeSet.add(new People<>(18, 13.0));
        treeSet.add(new People<>(19, 14.1));
        System.out.println(treeSet);

        ArrayList<Character> arrayList=new ArrayList<>();//限制了元素只能为Character类型
        arrayList.add(0,'a');
        test(arrayList);//此处只能传入泛型为Character或者其父类的ArrayList，不声明泛型时（则为Object）时也可以传入
    }

    public static void test(ArrayList<? extends Character> arrayList){//这里只能用?代表泛型，也可以不extends；在类时则可以直接用T extends Character来声明
        System.out.println(arrayList);
    }
}
