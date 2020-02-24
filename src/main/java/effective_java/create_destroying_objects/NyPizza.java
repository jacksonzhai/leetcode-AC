package effective_java.create_destroying_objects;


import java.util.Objects;

public class NyPizza extends Pizza {
    public NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public enum Size {SMALL,MEDIUM,LAGE};
    private final Size size;
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);

        }

        @Override
        public NyPizza build() {
           return new NyPizza(this);
        }

        @Override
        protected Builder self() {
           return this;
        }

    }

}
