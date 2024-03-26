import java.util.ArrayList;
import java.util.Iterator;
/*
interface Op {
    String op(String s);
}
*/

abstract class Xform<E> {
    public Xform() {
    }
    abstract public E op(E s);
}

class Reverse extends Xform<String> { //implements Op {
    public Reverse() {
        super();
    }
    @Override
    public String op(String s) {
        return (new StringBuilder(s)).reverse().toString();
    }
}

class Rotate extends Xform<String> { //implements Op {
    public Rotate(int chars) {
        super();
        this.chars = chars;
    }
    @Override
    public String op(String s) {
        return s.substring(chars) + s.substring(0,chars);
    }
    private int chars;
}

class LTrim extends Xform<String> { //implements Op {
    public LTrim(int chars) {
        super();
        this.chars = chars;
    }
    @Override
    public String op(String s) {
        return s.substring(chars);
    }
    private int chars;
}

class RTrim extends Xform<String> { //implements Op {
    public RTrim(int chars) {
        super();
        this.chars = chars;
    }
    @Override
    public String op(String s) {
        return s.substring(0, s.length() - chars);
    }
    private int chars;
}

class Append extends Xform<String> {
    public Append(String suffix)  {
        super();
        this.suffix = suffix;
    }
    @Override
    public String op(String s) {
        return s + suffix;
    }
    private String suffix;
}

class Prepend extends Xform<String> {
    public Prepend(String prefix)  {
        super();
        this.prefix = prefix;
    }
    @Override
    public String op(String s) {
        return prefix + s;
    }
    private String prefix;
}

public class Transform {
    private static ArrayList<Xform<String>> xforms;
    public static void main(String[] args) {
        xforms = new ArrayList<>();
        xforms.add(new Reverse());  // Two of these six transforms
        xforms.add(new LTrim(4));       // or 3
        xforms.add(new RTrim(3));       // or 4
        xforms.add(new Rotate(3));      // or 4
        xforms.add(new Append("<=>"));  // or =#=
        xforms.add(new Prepend("=#=")); // or <=>
        
        Iterator<Xform<String>> it = xforms.iterator();
        String s = args[0]; 
        while(it.hasNext()) {
            System.out.print(s + " -> ");
            s = it.next().op(s);
            System.out.println(s);
        }
    }
}
