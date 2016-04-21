package org.wucalv.quickstart.fullrecon;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface Entry<T> {

    T get();

    class TextEntry implements Entry<String> {

        private final String data;

        public TextEntry(String data) {
            this.data = data;
        }

        @Override
        public String get() {
            return data;
        }
    }
}
