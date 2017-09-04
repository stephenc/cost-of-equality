package org.cloudbees.equality;

import java.util.Objects;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class BeanD {
    private final Object a;
    private final Object b;

    public BeanD(Object a, Object b) {
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

        if (!(o instanceof BeanD)) {
            return false;
        }

        BeanD beanD = (BeanD) o;

        return new EqualsBuilder()
                .append(getA(), beanD.getA())
                .append(getB(), beanD.getB())
                .isEquals();
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a);
        result = 31 * result + Objects.hashCode(b);
        return result;
    }
}
