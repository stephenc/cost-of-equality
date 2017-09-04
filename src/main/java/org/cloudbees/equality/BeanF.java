package org.cloudbees.equality;

import java.util.Objects;

public class BeanF {
    private final Object a;
    private final Object b;

    public BeanF(Object a, Object b) {
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
        if (this == o) {
            return true;
        }
        if (!(o instanceof BeanF)) {
            return false;
        }

        BeanF beanB = (BeanF) o;

        if (!sameA(beanB)) {
            return false;
        }
        return sameB(beanB);
    }

    private boolean sameB(BeanF beanB) {
        return getB() != null ? getB().equals(beanB.getB()) : beanB.getB() == null;
    }

    private boolean sameA(BeanF beanB) {
        return getA() != null ? getA().equals(beanB.getA()) : beanB.getA() == null;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a);
        result = 31 * result + Objects.hashCode(b);
        return result;
    }
}
