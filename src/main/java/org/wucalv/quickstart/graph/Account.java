package org.wucalv.quickstart.graph;

/**
 * Created by calvin.wu on 2/29/16.
 */
public class Account extends Vertex {

    private String name;
    private String accountNumber;

    public Account(String name, String accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
