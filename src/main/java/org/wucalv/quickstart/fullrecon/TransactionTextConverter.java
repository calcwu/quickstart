package org.wucalv.quickstart.fullrecon;

/**
 * @author Calvin Wu (calvin.wu@addepar.com)
 */
public class TransactionTextConverter implements EntryConverter<String, Transaction> {
    @Override
    public Transaction convert(Entry<String> entry) {
        return null;
    }

    @Override
    public boolean isValid(Entry<String> entry) {
        String data = entry.get();
        return data.split(data).length == 7;
    }
}
