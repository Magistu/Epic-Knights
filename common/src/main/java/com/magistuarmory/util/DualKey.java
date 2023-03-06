package com.magistuarmory.util;

import java.util.Objects;

public class DualKey<K1, K2>
{
    public K1 key1;
    public K2 key2;

    public DualKey(K1 key1, K2 key2)
    {
        this.key1 = key1;
        this.key2 = key2;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean equals(Object o)
    {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        DualKey key = (DualKey) o;
        if (!Objects.equals(key1, key.key1)) 
        {
            return false;
        }

        return Objects.equals(key2, key.key2);
    }

    @Override
    public int hashCode()
    {
        int result = key1 != null ? key1.hashCode() : 0;
        result = 31 * result + (key2 != null ? key2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "[" + key1 + ", " + key2 + "]";
    }
}