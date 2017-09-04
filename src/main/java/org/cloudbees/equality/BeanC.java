package org.cloudbees.equality;

import java.util.Objects;

public class BeanC {
    private final Object a;
    private final Object b;

    public BeanC(Object a, Object b) {
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
        if (!(o instanceof BeanC)) {
            return false;
        }
        BeanC beanC = (BeanC) o;
        return Objects.equals(getA(), beanC.getA()) &&
                Objects.equals(getB(), beanC.getB());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a);
        result = 31 * result + Objects.hashCode(b);
        return result;
    }
}
