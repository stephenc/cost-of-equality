package org.cloudbees.equality;

import java.util.Objects;

public class BeanB {
    private final Object a;
    private final Object b;

    public BeanB(Object a, Object b) {
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
        if (!(o instanceof BeanB)) {
            return false;
        }

        BeanB beanB = (BeanB) o;

        if (getA() != null ? !getA().equals(beanB.getA()) : beanB.getA() != null) {
            return false;
        }
        return getB() != null ? getB().equals(beanB.getB()) : beanB.getB() == null;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a);
        result = 31 * result + Objects.hashCode(b);
        return result;
    }
}
