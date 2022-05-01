package org.acme.service.experiment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

// @QuarkusTest
public class MapStructTest {
    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    @Test
    public void test(){
        Foo foo = new Foo();
        foo.setFoo("sss");
        foo.setXxx("xxx");
        FooChild child = new FooChild();
        child.setXxx("XXX");
        child.setFooChild("child");
        foo.setChild(new ArrayList<>());
        foo.getChild().add(child);
        // foo.setChild(child);

        Bar bar = INSTANCE.fooToBar(foo);
        assertEquals(bar.getXxx(),"xxx");
        assertEquals(foo.getFoo(),bar.getBar());

    }
}

@Mapper
interface CarMapper {

    @Mapping(source = "foo", target = "bar")
    Bar fooToBar(Foo foo);

    @Mapping(source = "fooChild", target = "barChild")
    BarChild fooChildToBarChild(FooChild fooChild);

}
class Foo{

    private String foo;
    private String xxx;
    // private FooChild child;
    // public FooChild getChild() {
    //     return child;
    // }
    // public void setChild(FooChild child) {
    //     this.child = child;
    // }
    // private List<FooChild> child = new ArrayList<>();
    public String getFoo() {
        return foo;
    }
    public void setFoo(String foo) {
        this.foo = foo;
    }
    private List<FooChild> child;
    public List<FooChild> getChild() {
        return child;
    }
    public void setChild(List<FooChild> child) {
        this.child = child;
    }
    public String getXxx() {
        return xxx;
    }
    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
}

class FooChild{

    private String fooChild;
    private String xxx;

    public String getXxx() {
        return xxx;
    }
    public String getFooChild() {
        return fooChild;
    }
    public void setFooChild(String fooChild) {
        this.fooChild = fooChild;
    }
    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

}

class Bar{
    private String bar;
    private String xxx;
    // private BarChild child;
    // public BarChild getChild() {
    //     return child;
    // }
    // public void setChild(BarChild child) {
    //     this.child = child;
    // }
    // private List<FooChild> child = new ArrayList<>();
    public String getBar() {
        return bar;
    }
    public void setBar(String bar) {
        this.bar = bar;
    }
    private List<BarChild> child;
    public List<BarChild> getChild() {
        return child;
    }
    public void setChild(List<BarChild> child) {
        this.child = child;
    }
    public String getXxx() {
        return xxx;
    }
    public void setXxx(String xxx) {
        this.xxx = xxx;
    }

}

class BarChild{
    private String barChild;
    private String xxx;
    public String getXxx() {
        return xxx;
    }
    public void setXxx(String xxx) {
        this.xxx = xxx;
    }
    public String getBarChild() {
        return barChild;
    }
    public void setBarChild(String barChild) {
        this.barChild = barChild;
    }

}