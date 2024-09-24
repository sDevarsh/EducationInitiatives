package Prototype;

abstract class Mobile implements Cloneable {
    private String id;
    protected String processor;

    abstract void call();

    public String getProcessor() {
        return processor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object clone() {
        Object clone = null;
        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
}
