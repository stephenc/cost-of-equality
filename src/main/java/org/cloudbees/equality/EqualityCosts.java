package org.cloudbees.equality;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.TearDown;
import org.openjdk.jmh.infra.Blackhole;


@State(Scope.Thread)
public class EqualityCosts {

    private Object x = new Object();
    private Object y = new Object();
    private Object z = new Object();
    private Object w = new Object();
    private Object a1;
    private Object a2;
    private Object a3;
    private Object a4;
    private Object b1;
    private Object b2;
    private Object b3;
    private Object b4;
    private Object c1;
    private Object c2;
    private Object c3;
    private Object c4;
    private Object d1;
    private Object d2;
    private Object d3;
    private Object d4;
    private Object e1;
    private Object e2;
    private Object e3;
    private Object e4;
    private Object f1;
    int something;

    public EqualityCosts() {
    }

    @Setup(Level.Iteration)
    public void init() {
        x = createSomething();
        y = createSomething();
        z = createSomething();
        w = createSomething();
        a1 = new BeanA(x, z);
        a2 = new BeanA(x, w);
        a3 = new BeanA(y, z);
        a4 = new BeanA(y, w);
        b1 = new BeanB(x, z);
        b2 = new BeanB(x, w);
        b3 = new BeanB(y, z);
        b4 = new BeanB(y, w);
        c1 = new BeanC(x, z);
        c2 = new BeanC(x, w);
        c3 = new BeanC(y, z);
        c4 = new BeanC(y, w);
        d1 = new BeanD(x, z);
        d2 = new BeanD(x, w);
        d3 = new BeanD(y, z);
        d4 = new BeanD(y, w);
        e1 = new BeanE(x, z);
        e2 = new BeanE(x, w);
        e3 = new BeanE(y, z);
        e4 = new BeanE(y, w);
        f1 = new BeanF(x, z);
    }

    @TearDown(Level.Iteration)
    public void preventInliningOptimization(Blackhole bh) {
        a1 = createSomething();
        a2 = createSomething();
        a3 = createSomething();
        a4 = createSomething();
        b1 = createSomething();
        b2 = createSomething();
        b3 = createSomething();
        b4 = createSomething();
        c1 = createSomething();
        c2 = createSomething();
        c3 = createSomething();
        c4 = createSomething();
        d1 = createSomething();
        d2 = createSomething();
        d3 = createSomething();
        d4 = createSomething();
        e1 = createSomething();
        e2 = createSomething();
        e3 = createSomething();
        e4 = createSomething();
        f1 = createSomething();
        optionalFilter_xa(bh);
        optionalFilter_xn(bh);
        optionalFilter_xo(bh);
        optionalFilter_xx(bh);
        optionalFilter_xy(bh);
        optionalFilter_xz(bh);
        optionalFilter_xw(bh);
        intellijDefault_xa(bh);
        intellijDefault_xn(bh);
        intellijDefault_xo(bh);
        intellijDefault_xx(bh);
        intellijDefault_xy(bh);
        intellijDefault_xz(bh);
        intellijDefault_xw(bh);
        intellijInline_xn(bh);
        intellijInline_xx(bh);
        objectsEquals_xa(bh);
        objectsEquals_xn(bh);
        objectsEquals_xx(bh);
        objectsEquals_xy(bh);
        objectsEquals_xz(bh);
        commonsLang3_xa(bh);
        commonsLang3_xn(bh);
        commonsLang3_xx(bh);
        commonsLang3_xy(bh);
        commonsLang3_xz(bh);
        intellijFields_xa(bh);
        intellijFields_xn(bh);
        intellijFields_xx(bh);
        intellijFields_xy(bh);
        intellijFields_xz(bh);
        reference(bh);
    }

    private Object createSomething() {
        // we want a prime number of object types that all have their own impl of .equals
        switch (something++) {
            case 0:
                return new Object(){
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "0";
                    }
                };
            case 1:
                return new Object() {
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "1";
                    }
                };
            case 2:
                return new Object() {
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "2";
                    }
                };
            case 3:
                return new Object() {
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "3";
                    }
                };
            case 4:
                return new Object() {
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "4";
                    }
                };
            case 5:
                return new Object() {
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "5";
                    }
                };
            default:
                something = 0;
                return new Object() {
                    @Override
                    public boolean equals(Object obj) {
                        return this == obj;
                    }

                    @Override
                    public String toString() {
                        return "6";
                    }
                };
        }
    }

    @Benchmark
    public void optionalFilter(Blackhole bh) {
        Bean b = new Bean(...);
        bh.consume(b.equals(b));
        bh.consume(b.equals(null));
        bh.consume(b.equals(""));
        bh.consume(b.equals(new Bean(...)));
    }
    @Benchmark
    public void optionalFilter_xa(Blackhole bh) {
        bh.consume(a1.equals(null));
        bh.consume(a1.equals(x));
        bh.consume(a1.equals(a1));
        bh.consume(a1.equals(a2));
        bh.consume(a1.equals(a3));
        bh.consume(a1.equals(a4));
    }

    @Benchmark
    public void optionalFilter_xn(Blackhole bh) {
        bh.consume(a1.equals(null));
    }

    @Benchmark
    public void optionalFilter_xo(Blackhole bh) {
        bh.consume(a1.equals(x));
    }

    @Benchmark
    public void optionalFilter_xx(Blackhole bh) {
        bh.consume(a1.equals(a1));
    }

    @Benchmark
    public void optionalFilter_xy(Blackhole bh) {
        bh.consume(a1.equals(a2));
    }

    @Benchmark
    public void optionalFilter_xz(Blackhole bh) {
        bh.consume(a1.equals(a3));
    }

    @Benchmark
    public void optionalFilter_xw(Blackhole bh) {
        bh.consume(a1.equals(a4));
    }

    @Benchmark
    public void intellijDefault_xa(Blackhole bh) {
        bh.consume(b1.equals(null));
        bh.consume(b1.equals(x));
        bh.consume(b1.equals(b1));
        bh.consume(b1.equals(b2));
        bh.consume(b1.equals(b3));
        bh.consume(b1.equals(b4));
    }

    @Benchmark
    public void intellijDefault_xn(Blackhole bh) {
        bh.consume(b1.equals(null));
    }

    @Benchmark
    public void intellijDefault_xo(Blackhole bh) {
        bh.consume(b1.equals(x));
    }

    @Benchmark
    public void intellijDefault_xx(Blackhole bh) {
        bh.consume(b1.equals(b1));
    }

    @Benchmark
    public void intellijDefault_xy(Blackhole bh) {
        bh.consume(b1.equals(b2));
    }

    @Benchmark
    public void intellijDefault_xz(Blackhole bh) {
        bh.consume(b1.equals(b3));
    }

    @Benchmark
    public void intellijDefault_xw(Blackhole bh) {
        bh.consume(b1.equals(b4));
    }

    @Benchmark
    public void intellijInline_xn(Blackhole bh) {
        bh.consume(f1.equals(null));
    }

    @Benchmark
    public void intellijInline_xx(Blackhole bh) {
        bh.consume(f1.equals(f1));
    }

    @Benchmark
    public void objectsEquals_xa(Blackhole bh) {
        bh.consume(c1.equals(null));
        bh.consume(c1.equals(x));
        bh.consume(c1.equals(c1));
        bh.consume(c1.equals(c2));
        bh.consume(c1.equals(c3));
        bh.consume(c1.equals(c4));
    }

    @Benchmark
    public void objectsEquals_xn(Blackhole bh) {
        bh.consume(c1.equals(null));
    }

    @Benchmark
    public void objectsEquals_xx(Blackhole bh) {
        bh.consume(c1.equals(c1));
    }

    @Benchmark
    public void objectsEquals_xy(Blackhole bh) {
        bh.consume(c1.equals(c2));
    }

    @Benchmark
    public void objectsEquals_xz(Blackhole bh) {
        bh.consume(c1.equals(c3));
    }

    @Benchmark
    public void commonsLang3_xa(Blackhole bh) {
        bh.consume(d1.equals(null));
        bh.consume(d1.equals(x));
        bh.consume(d1.equals(d1));
        bh.consume(d1.equals(d2));
        bh.consume(d1.equals(d3));
        bh.consume(d1.equals(d4));
    }

    @Benchmark
    public void commonsLang3_xn(Blackhole bh) {
        bh.consume(d1.equals(null));
    }

    @Benchmark
    public void commonsLang3_xx(Blackhole bh) {
        bh.consume(d1.equals(d1));
    }

    @Benchmark
    public void commonsLang3_xy(Blackhole bh) {
        bh.consume(d1.equals(d2));
    }

    @Benchmark
    public void commonsLang3_xz(Blackhole bh) {
        bh.consume(d1.equals(d3));
    }

    @Benchmark
    public void intellijFields_xa(Blackhole bh) {
        bh.consume(e1.equals(null));
        bh.consume(e1.equals(x));
        bh.consume(e1.equals(e1));
        bh.consume(e1.equals(e2));
        bh.consume(e1.equals(e3));
        bh.consume(e1.equals(e4));
    }

    @Benchmark
    public void intellijFields_xn(Blackhole bh) {
        bh.consume(e1.equals(null));
    }

    @Benchmark
    public void intellijFields_xx(Blackhole bh) {
        bh.consume(e1.equals(e1));
    }

    @Benchmark
    public void intellijFields_xy(Blackhole bh) {
        bh.consume(e1.equals(e2));
    }

    @Benchmark
    public void intellijFields_xz(Blackhole bh) {
        bh.consume(e1.equals(e3));
    }

    @Benchmark
    public void reference(Blackhole bh) {
        bh.consume(true);
    }

}
