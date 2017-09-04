package org.cloudbees.equality;

import java.util.Objects;
import org.apache.commons.lang3.builder.EqualsBuilder;

public class BeanE {
    private final Object a;
    private final Object b;

    public BeanE(Object a, Object b) {
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
        if (!(o instanceof BeanE)) {
            return false;
        }

        BeanE beanE = (BeanE) o;

        if (a != null ? !a.equals(beanE.a) : beanE.a != null) {
            return false;
        }
        return b != null ? b.equals(beanE.b) : beanE.b == null;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(a);
        result = 31 * result + Objects.hashCode(b);
        return result;
    }
}
