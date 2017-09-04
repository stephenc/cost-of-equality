package org.cloudbees.equality;

import java.util.Objects;
import java.util.Optional;

public class BeanA {
    private final Object a;
    private final Object b;

    public BeanA(Object a, Object b) {
        this.a = a;
        this.b = b;
    }

    public Object getA() {
        return a;
    }

    public Object getB() {
        return b;
    }

    @Override
    public boolean equals(Object o) {
        return Optional.ofNullable(o)
                .filter(x -> x instanceof BeanA)
                .map(x -> (BeanA) x)
                .filter(x -> Objects.equals(x.getA(), getA()))
                .filter(x -> Objects.equals(x.getB(), getB()))
                .isPresent();
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a);
        result = 31 * result + Objects.hashCode(b);
        return result;
    }
}

/*
  public boolean equals(java.lang.Object);
    Code:
       0: aload_1
       1: invokestatic  #4                  // Method java/util/Optional.ofNullable:(Ljava/lang/Object;)
       Ljava/util/Optional;
       4: invokedynamic #5,  0              // InvokeDynamic #0:test:()Ljava/util/function/Predicate;
       9: invokevirtual #6                  // Method java/util/Optional.filter:(Ljava/util/function/Predicate;)
       Ljava/util/Optional;
      12: invokedynamic #7,  0              // InvokeDynamic #1:apply:()Ljava/util/function/Function;
      17: invokevirtual #8                  // Method java/util/Optional.map:(Ljava/util/function/Function;)
      Ljava/util/Optional;
      20: aload_0
      21: invokedynamic #9,  0              // InvokeDynamic #2:test:(Lorg/cloudbees/equality/BeanA;)
      Ljava/util/function/Predicate;
      26: invokevirtual #6                  // Method java/util/Optional.filter:(Ljava/util/function/Predicate;)
      Ljava/util/Optional;
      29: aload_0
      30: invokedynamic #10,  0             // InvokeDynamic #3:test:(Lorg/cloudbees/equality/BeanA;)
      Ljava/util/function/Predicate;
      35: invokevirtual #6                  // Method java/util/Optional.filter:(Ljava/util/function/Predicate;)
      Ljava/util/Optional;
      38: invokevirtual #11                 // Method java/util/Optional.isPresent:()Z
      41: ireturn


 */
