package sample.inherit;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class InstrumentedHashSetTest {

    @Test
    public void addAllTest(){
        InstrumentedHashSet<String> instrumentedHashSet = new InstrumentedHashSet<>();
        Assert.assertEquals(true, instrumentedHashSet.addAll(Arrays.asList("Java", "Ruby", "Scala")));
        Assert.assertEquals(3, instrumentedHashSet.size());
        Assert.assertEquals(6, instrumentedHashSet.getAddCount());
    }
}