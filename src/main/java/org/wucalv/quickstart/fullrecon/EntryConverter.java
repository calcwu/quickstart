package org.wucalv.quickstart.fullrecon;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public interface EntryConverter<I, O> {

    O convert(Entry<I> entry);

    boolean isValid(Entry<I> entry);
}
